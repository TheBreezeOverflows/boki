package boke.boke.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/KanbanMusume").setViewName("KanbanMusume");
//        registry.addViewController("/register").setViewName("regist");
        registry.addViewController("/errors").setViewName("errors");
        registry.addViewController("/aboutMy").setViewName("aboutMy");
        registry.addViewController("/detail").setViewName("detail");
        registry.addViewController("/message").setViewName("message");
        registry.addViewController("/friend").setViewName("friend");
        registry.addViewController("/archive").setViewName("archive");
        registry.addViewController("/author").setViewName("author");
        registry.addViewController("/search").setViewName("search");
        //后台
        registry.addViewController("/end/index").setViewName("end/index");
        registry.addViewController("/end/frame").setViewName("end/frame");
        registry.addViewController("/end/blog").setViewName("end/blog");
        registry.addViewController("/end/blog_edit").setViewName("end/blog_edit");
        registry.addViewController("/end/blog_display").setViewName("end/blog_display");
        registry.addViewController("/end/message").setViewName("end/message");
        registry.addViewController("/end/friend").setViewName("end/friend");
        registry.addViewController("/end/user").setViewName("end/user");
        registry.addViewController("/end/tag").setViewName("end/tag");
        registry.addViewController("/end/link").setViewName("end/link");
        registry.addViewController("/end/author").setViewName("end/author");
    }

    //图片的映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //博客文章主图的映射
        String staticMappingzip="/compress/file/**";
        //idea项目显示时
        String localDirectoryzip = "file:"+System.getProperty("user.dir")+"/src/main/resources/static/compress/file/";//本地
        //String localDirectoryzip ="file:"+"/file/";//服务器
        //映射压缩图片
        registry.addResourceHandler(staticMappingzip).
                addResourceLocations(localDirectoryzip);
        //映射原图
        String staticMapping="/file/**";
        String localDirectory="file:"+System.getProperty("user.dir")+"/src/main/resources/static/file/";//本地
        //String localDirectory="file:"+"/file/";//服务器
        registry.addResourceHandler(staticMapping).
                addResourceLocations(localDirectory);

    }

}
