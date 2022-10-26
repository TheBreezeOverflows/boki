package boke.boke.service.Impl;

import boke.boke.entity.*;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.BlogandclassifyMapper;
import boke.boke.mapper.BlogsarticleMapper;
import boke.boke.mapper.ClassifyMapper;
import boke.boke.service.ClassifyInfo;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClassifyInfoImpl implements ClassifyInfo {

    //依赖mapper
    @Autowired(required = false)
    private ClassifyMapper classifyMapper;
    @Autowired(required = false)
    private BlogandclassifyMapper blogandclassifyMapper;
    @Autowired(required = false)
    private BlogsarticleMapper blogsarticleMapper;

    //查询默认显示的,状态为零的
    @Override
    public List<Classify> calssifyInfo() {
        return classifyMapper.selectByPrimarydatakey();
    }

    @Override
    public List<Classify> calssifyInfos() {
        return classifyMapper.selectByExample(null);
    }

    //查询当前文章的标签名称
    @Override
    public String selectByByPrimaryClassid(int id) {
        Classify classify = classifyMapper.selectByByPrimaryClassname(id);
        if (classify==null){
            classify=classifyMapper.selectByByPrimaryClassbigname(id);
        }

        return classify.getClassifyName();
    }
    //根据当前文章名称查询标签id
    @Override
    public Classify selectByByPrimaryClass(String name) {
        return classifyMapper.selectByByClassname(name);
    }

    @Override
    public SearchResult<Classify> AllClassMessage(SearchParam searchParam) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        List<Classify> brands = classifyMapper.selectByExample(null);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Classify>((long)brands.size(),brands);
    }

    @Override
    public SearchResult<Classify> AllClassNameMessage(SearchParam searchParam, String name) {
        //设置分页信息
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        ClassifyExample classifyExample=new ClassifyExample();
        classifyExample.createCriteria().andClassifyNameLike("%" +name+ "%");
        List<Classify> brands = classifyMapper.selectByExample(classifyExample);
        //查询
        Page page =new Page();
        if (brands instanceof Page){
            page = (Page) brands;
            return new SearchResult<>(page.getTotal(), page.getResult());
        }
        return new SearchResult<Classify>((long)brands.size(),brands);
    }

    @Transactional
    @Override
    public boolean updatebigByClass(Classify classdatainfo) {
        boolean fal =false;
        //是否需要进行上级id的修改
        boolean classidble=false;
        String classname=classdatainfo.getClassifyName();
        //查询当前修改的标签名称是否与数据库重复
        Integer calssin = classifyMapper.selectByClassnameid(classdatainfo.getClassifyName(), classdatainfo.getClassifyId());
        Classify classify = classifyMapper.selectByPrimaryKey(classdatainfo.getClassifyId());
        if (calssin<=0){
            //判断标签是否为空(如果为空则只是修改一下名称)
            if (!StringUtils.isEmpty(classdatainfo.getClassifyCategory())){
                //查询上级标签是否为原本之前的
                if (classify.getClassifyName().equals(classdatainfo.getClassifyCategory())){
                    //如果标签和上级标签是相同的则修改名称以及上级标签的名称(以及博客文章中的标签名称)
                    classdatainfo.setClassifyCategory(classdatainfo.getClassifyName());
                }else{
                    //上级标签不为原本的则修改上级标签的id
                    Integer superid = classifyMapper.selectByclassName(classdatainfo.getClassifyCategory());
                    classdatainfo.setSuperclassId(superid);
                    classname=classdatainfo.getClassifyCategory();
                    classidble=true;
                }
            }
            try {
            //如果标签为空则直接进行修改
            classifyMapper.updateByPrimaryKey(classdatainfo);
            //判断是否需要进行上级id的修改
            if (classidble){
            //根据上级标签id修改上级标签名称和id
            classifyMapper.updatetagnameandid(classdatainfo.getClassifyCategory(), classdatainfo.getClassifyId(), classdatainfo.getSuperclassId());
                //修改博客关联id
            blogandclassifyMapper.UpdaClassByid(classdatainfo.getClassifyId(),classdatainfo.getSuperclassId());

            }else {
            //根据上级标签id修改上级标签名称
            classifyMapper.updatetagnameByid(classdatainfo.getClassifyName(),classdatainfo.getClassifyId());
            }
            //修改博客文章中的标签名称
                System.out.println("改前"+classify.getClassifyName()+"改后"+classname);
            blogsarticleMapper.updateBlogsAlterClass(classify.getClassifyName(),classname);
            fal=true;
            }catch (Exception exception){
                fal=false;
            }
        }

        return fal;
    }

    @Transactional
    @Override
    public boolean updateByClass(Classify classdatainfo) {
        boolean fal =false;
        //查询当前修改的标签名称是否与数据库重复
        Integer calssin = classifyMapper.selectByClassnameid(classdatainfo.getClassifyName(), classdatainfo.getClassifyId());
        Classify classify = classifyMapper.selectByPrimaryKey(classdatainfo.getClassifyId());
        System.out.println(classify.getClassifyName());
        if (calssin<=0){
            //判断标签是否为空(如果为空则只是修改一下名称)
            if (!StringUtils.isEmpty(classdatainfo.getClassifyCategory())) {
                //根据名称查询标签id后修改上级标签id
                Integer superid = classifyMapper.selectByclassName(classdatainfo.getClassifyCategory());
                classdatainfo.setSuperclassId(superid);
            }
            int in =  classifyMapper.updateByPrimaryKey(classdatainfo);
            if (in!=0){
                //修改博客文章中的标签名称
                blogsarticleMapper.updateBlogsAlterClass(classify.getClassifyName(),classdatainfo.getClassifyName());
             fal=true;
            }
        }
        return fal;
    }

    @Override
    public boolean saveByClass(Classify classdatainfo) {
        boolean fal =false;
        //判断上级是否为空(为空则为大标签)
        if (StringUtils.isEmpty(classdatainfo.getClassifyCategory())){
            classdatainfo.setSuperclassId(0);
            classdatainfo.setClassifyCategory(classdatainfo.getClassifyName());
        }else {
            //不为空则查询标签的id
            Integer superid = classifyMapper.selectByclassName(classdatainfo.getClassifyCategory());
            classdatainfo.setSuperclassId(superid);
        }
        int i = classifyMapper.insert(classdatainfo);
        if (i!=0){
            fal=true;
        }
        return fal;
    }

    @Override
    public boolean DelteByClassMessage(int id) {
        boolean fal =false;
        //删除前搜索关联表是否存在次标签的数据(存在则不能删除)
        BlogandclassifyExample blogandclassifyExample=new BlogandclassifyExample();
        blogandclassifyExample.createCriteria().andClassifyIdEqualTo(id);
        List<Blogandclassify> blogandclassifies = blogandclassifyMapper.selectByExample(blogandclassifyExample);
        if (blogandclassifies.size()>0){
            return fal;
        }
        //判断是否为大标签
        Classify classify = classifyMapper.selectByPrimaryKey(id);
        if (classify.getSuperclassId()==0){
            ClassifyExample classifyExample=new ClassifyExample();
            classifyExample.createCriteria().andSuperclassIdEqualTo(id);
            List<Classify> classifies = classifyMapper.selectByExample(classifyExample);
            if (classifies.size()>0){
                return fal;
            }
        }

        int in =  classifyMapper.deleteByPrimaryKey(id);
        if (in!=0){
            fal=true;
        }
        return fal;
    }


}
