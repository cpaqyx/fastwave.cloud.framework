package fastwave.service.admin;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * 
 * @ClassName:  Application   
 * @Description:fastwave-sevice-admin 程序入口 
 * @author: fastwave
 * @date:   
 */
@EnableScheduling
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("fastwave.service.admin.*.dao")
@EnableEurekaClient
@SpringBootApplication(scanBasePackages="fastwave.service.admin")
@Configuration
public class Application {
	
	@Value("${spring.http.multipart.maxFileSize}")
	private String maxFileSize;
	@Value("${spring.http.multipart.maxRequestSize}")
	private String maxRequestSize;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("------------ 后台管理服务启动成功 ---------------\n");
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
	public MultipartConfigElement multipartConfigElement(
			) {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize(maxFileSize);
		// 设置总上传数据总大小
		factory.setMaxRequestSize(maxRequestSize);
		return factory.createMultipartConfig();
	} 
	
	@Bean
	 public ServletRegistrationBean DruidStatViewServlet(){
	    //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
	    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

	    //添加初始化参数：initParams

	    //白名单 (没有配置或者为空，则允许所有访问)
	    //servletRegistrationBean.addInitParameter("allow","");
	    //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
	   // servletRegistrationBean.addInitParameter("deny","192.168.1.80");
	    //登录查看信息的账号密码.
//	    servletRegistrationBean.addInitParameter("loginUsername","root");
//	    servletRegistrationBean.addInitParameter("loginPassword","123456");
	    //是否能够重置数据(禁用HTML页面上的“Reset All”功能)
	    //servletRegistrationBean.addInitParameter("resetEnable","false");
	    return servletRegistrationBean;
	}

}


