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
        //后台
        registry.addViewController("/end/index").setViewName("end/index");
    }



}
