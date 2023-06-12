package me.belk;

@Configuraion
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/WEB-INF/", ".jsp");
    }
}
