package boke.boke.service.Impl;

import boke.boke.entity.*;
import boke.boke.entity.dto. ArchiveResult;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.BlogandclassifyMapper;
import boke.boke.mapper.BlogsarticleMapper;
import boke.boke.mapper.ClassifyMapper;
import boke.boke.repository.BlogEsRepository;
import boke.boke.util.FetchSourceFilter;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Pageable;
import boke.boke.service.BlogsArticleInfo;
import boke.boke.service.ClassifyInfo;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogsArticleInfoImpl implements BlogsArticleInfo {
    //依赖mapper
    @Autowired(required = false)
    private BlogsarticleMapper blogsarticleMapper;
    @Autowired(required = false)
    private BlogandclassifyMapper blogandclassifyMapper;
    @Autowired(required = false)
    private ClassifyMapper classifyMapper;
    //es搜索
    @Autowired(required = false)
    private BlogEsRepository blogEsRepository;
    @Autowired(required = false)
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    //搜索的字段
    private String[] fieldName={"blogsarticleHeadline","blogsarticleContent","blogsarticleDetailedinformation"};


    public BlogsArticleInfoImpl() {
    }

    //根据用户id查询用户所编写的文章
    @Override
    public SearchResult<Blogsarticle> BlogsArticleUserIdInfo(SearchParam searchParam) {
       SearchResult<Blogsarticle> result=new SearchResult<>();
        //使用es默认查询
        //创建一个ES本地搜索构建者对象
        //创建SearchQuery对象
        //查询条件(词条查询：对应ES query里的match)
        FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("blogsarticleId").order(SortOrder.ASC);//排序
        //指定query
        QueryBuilder queryBuilder =QueryBuilders.matchAllQuery();//没有关键字
        if (!StringUtils.isEmpty(searchParam.getKeyword())){
            //有关键字的搜索
            queryBuilder = QueryBuilders.multiMatchQuery(searchParam.getKeyword(),fieldName);
        }
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withSort(fieldSortBuilder)
                .withPageable(PageRequest.of(searchParam.getPageNum()-1, searchParam.getPageSize()))
                .withSourceFilter(new FetchSourceFilter(new String[0],new String[]{"blogsarticleDetailedinformation"}))
                .build();
        //查询,获取查询结果
        AggregatedPage<Blogsarticle> blogsarticles = elasticsearchRestTemplate.queryForPage(nativeSearchQuery, Blogsarticle.class);
        //获取总记录数
        System.out.println("totalHits = " + blogsarticles.getContent());
        result.setTotal(blogsarticles.getTotalElements());
        result.setList(blogsarticles.getContent());
        return result;
    }



    //根据文章分类id查询用户所写文章
    @Override
    public SearchResult<Blogsarticle> BlogsArticleClassifyIdInfo(int id, SearchParam searchParam) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        //查询
        Page page =new Page();
        //获取根据文章标签查询的文章信息集合
        List<Blogsarticle> brands = blogsarticleMapper.selectByClassifExample(id);
        if (null!=brands) {
            if (brands instanceof Page) {
                page = (Page) brands;
                return new SearchResult<>(page.getTotal(), page.getResult());
            }
        }
        return new SearchResult<Blogsarticle>((long)brands.size(),brands);
    }
    //根据文章分类id查询用户所写文章
    @Override
    public SearchResult<Blogsarticle> BlogsArticleNameifyIdInfo(SearchParam searchParam,String name) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        //查询
        Page page =new Page();
        //获取根据文章标签查询的文章信息集合
        List<Blogsarticle> brands = blogsarticleMapper.selectByNameifExample(name);
        if (null!=brands) {
            if (brands instanceof Page) {
                page = (Page) brands;
                return new SearchResult<>(page.getTotal(), page.getResult());
            }
        }
        return new SearchResult<Blogsarticle>((long)brands.size(),brands);
    }

    //根据文章id查询文章内容
    @Override
    public Blogsarticle BlogsArticleContentInfo(int id) {
        SearchResult<Blogsarticle> result=new SearchResult<>();
        //使用es根据id查询
        //创建一个ES本地搜索构建者对象
        //指定query
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(id,"blogsarticleId");
        //创建查询条件构建器SearchSourceBuilder(对应ES外面的大括号)
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();
        //查询,获取查询结果
        try {
            AggregatedPage<Blogsarticle> blogsarticles = elasticsearchRestTemplate.queryForPage(nativeSearchQuery, Blogsarticle.class);
            return blogsarticles.getContent().get(0);
        }catch (Exception e){
            return null;
        }
    }

    //根据创建时间查询文章分类信息
    @Override
    public List<ArchiveResult<Blogsarticle>> BlogsArticleCreationTime() {
         ArchiveResult<Blogsarticle>  archiveResult=null;
        List< ArchiveResult<Blogsarticle>>  archiveResultList=new ArrayList< ArchiveResult<Blogsarticle>>();
        Blogsarticle blog=null;
        //查询文章所以年份
        List<Integer> yearTime = blogsarticleMapper.BlogsArticleYearTime();
        for (Integer ytime:yearTime) {
            //年份查询当年份的文章
            List<Blogsarticle> blogsarticlelist = blogsarticleMapper.BlogsArticleCreationTime(ytime);
            archiveResult=new  ArchiveResult<>();
            archiveResult.setData(ytime+"");
            archiveResult.setList(blogsarticlelist);
            archiveResultList.add(archiveResult);
        }

        return  archiveResultList;
    }

    //根据文章id查询文章标签id
    @Override
    public List<Blogandclassify> LableRelevanceLableid(int id) {
        BlogandclassifyExample example=new BlogandclassifyExample();
        example.createCriteria().andBlogsarticleIdEqualTo(id);
        return blogandclassifyMapper.selectByExample(example);
    }

    //保存文章信息
    @Override
    public int save(Blogsarticle blog) {
        int in=-1;
        int insertstr = blogsarticleMapper.insertstr(blog);
        if(insertstr>0){//判断是否保存到mysql数据库中
            //将文章信息添加到es中
            blogEsRepository.save(blog);
        }
        in =blog.getBlogsarticleId();
        return in;
    }

    //修改文章信息
    @Override
    public boolean updateById(Blogsarticle blog) {
        boolean fal =false;
        int in = blogsarticleMapper.updateByPrimaryKey(blog);
        if (in!=0){
            blogEsRepository.save(blog);
            fal=true;
        }
        return fal;
    }

    //删除文章
    @Override
    public boolean removeById(int id) {
        boolean fal =false;
        int in =  blogsarticleMapper.deleteByPrimaryKey(id);
        if (in!=0){
            //es中删除好像是需要long类型的这里可能会报错
            blogEsRepository.deleteById(id);
            fal=true;
        }
        return fal;
    }

    //添加文章与标签关联信息
    @Override
    public boolean AddblogClassify(int blogid,int classid){
        boolean fal =false;
        int in =  blogandclassifyMapper.insert(new Blogandclassify(blogid,classid));
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    //修改文章与标签关联信息
    @Override
    public boolean UpdablogClassify(int blogid,int classid) {
        boolean fal =false;
        int in =  blogandclassifyMapper.UpdablogClassKey(blogid,classid);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean removeblogIdClass(int id) {
        boolean fal =false;
        int in = blogandclassifyMapper.deleteblogclass(id);
        if (in!=0){
            fal=true;
        }
        return fal;
    }

    //给文章添加一次浏览次数
    @Override
    public boolean AddBlogAccessnumber(int id) {
        blogsarticleMapper.AddBlogAccessnumber(id);
        return false;
    }
    //给文章点赞
    @Override
    public boolean AddBlogLikenumber(int id) {
        blogsarticleMapper.AddBlogLikenumber(id);
        return false;
    }
    //给文章回复数统计+1
    @Override
    public boolean AddBlogcommentnumber(int id) {
        blogsarticleMapper.AddBlogcommentnumber(id);
        return false;
    }

    @Override
    public boolean delBlogcommentnumber(int id,int number) {
        blogsarticleMapper.delBlogcommentnumber(id,number);
        return false;
    }

    //将数据临时写入es
    @Override
    public void index() {
        List<Blogsarticle> brands = blogsarticleMapper.selectByExampleusername(null);
        brands.forEach(item ->{
            blogEsRepository.index(item);
        });

    }
}
