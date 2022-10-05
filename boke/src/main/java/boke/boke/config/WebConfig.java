package boke.boke.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/KanbanMusume").setViewName("KanbanMusume");
        registry.addViewController("/register").setViewName("regist");
        registry.addViewController("/errors").setViewName("errors");
        registry.addViewController("/aboutMy").setViewName("aboutMy");
        registry.addViewController("/detail").setViewName("detail");
        registry.addViewController("/newplq").setViewName("newplq");
        //后台
        registry.addViewController("/end/index").setViewName("end/index");
        registry.addViewController("/end/frame").setViewName("end/frame");
        registry.addViewController("/end/blog").setViewName("end/blog");
        registry.addViewController("/end/blog_edit").setViewName("end/blog_edit");
        registry.addViewController("/end/blog_display").setViewName("end/blog_display");
    }



}
