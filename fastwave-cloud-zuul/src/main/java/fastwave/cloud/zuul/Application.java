package fastwave.cloud.zuul;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.filter.CorsFilter;

import fastwave.cloud.zuul.filter.Filter;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

@SpringBootApplication
@EnableZuulProxy
@EnableWebSecurity
@Configuration
public class Application {
	
	@Value("${spring.http.multipart.maxFileSize}")
	private String maxFileSize;
	@Value("${spring.http.multipart.maxRequestSize}")
	private String maxRequestSize;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("------------ 统一网关(zuul)服务启动成功 ---------------\n");
	}

	@Bean
	public Filter getFilter() {
		return new Filter();
	}
	/**
	 * api 跨域配置
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
    /**  
     * 文件上传配置
     * @return  
     */ 
    //在多模块下进行编程时，如果有Config Client在运行时，回去配置文件找$(foo)的值。
    //在第一个application.properties下找不到的时候，就不会继续找下去了，直接报错。
    //在springboot的启动类中设置，一个配置文件中找不到继续找。
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize(maxFileSize);
		// 设置总上传数据总大小
		factory.setMaxRequestSize(maxRequestSize);
		return factory.createMultipartConfig();
	}
}
