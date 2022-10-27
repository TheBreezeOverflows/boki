package boke.boke.controller;

import boke.boke.entity.Friend;
import boke.boke.entity.Link;
import boke.boke.entity.dto.SearchParam;
import boke.boke.entity.dto.SearchResult;
import boke.boke.mapper.LinkMapper;
import boke.boke.service.FriendInfo;
import boke.boke.service.Linkinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 后台博客资源详细操作
 */
@RestController
@RequestMapping("/blog/link")
public class LinkController {

    //依赖mapper
    @Autowired
    private Linkinfo linkinfo;

    //查询所有资源
    @GetMapping("/AllLinkdmessage")
    @ResponseBody
    public SearchResult selectAllFriend(SearchParam params){
        return linkinfo.AllLinkdmessage(params);
    }
    //根据名称信息查询信息
    @GetMapping("/NamePage")
    @ResponseBody
    public SearchResult NamefindPage(SearchParam para,String search){
        return  linkinfo.commentNameifyIdInfo(para,search);
    }
    //添加批评论
    @PostMapping("/LinkOper")
    @ResponseBody
    public SearchResult<?> save(@RequestBody Link link){
        link.setLinkType(Integer.parseInt(link.getUsername()));
        boolean flg =linkinfo.save(link);
        if (flg){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }

    //修改评论
    @PutMapping("/LinkOper")
    @ResponseBody
    public SearchResult<?> update(@RequestBody Link link){
        if(StringUtils.isNumeric(link.getUsername())){
            link.setLinkType(Integer.parseInt(link.getUsername()));
        }
        boolean flg =linkinfo.updateBylink(link);
        if (flg){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }

    //删除评论
    @GetMapping("/delteComment")
    @ResponseBody
    public SearchResult<?> deleteLink(int id) {
        System.out.print("id="+id);
        linkinfo.Deltelinkmessage(id);
        if (linkinfo.Deltelinkmessage(id)){
            return SearchResult.success();
        }
        return SearchResult.success("500");
    }
}
