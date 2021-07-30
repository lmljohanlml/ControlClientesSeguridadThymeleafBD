package mx.com.gm.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author DrMerlyn
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    //asingacion del idioma predeterminado del aplicativo
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;        
    }
    
    //captura del idioma seleccionado por el usuario
    @Bean
    public LocaleChangeInterceptor localeChageInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    //Asingancion del idioma del aplicativo
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChageInterceptor());
    }
    
    //Ejecuciin de redireccionamiento y permisos a las paginas    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
    
}
