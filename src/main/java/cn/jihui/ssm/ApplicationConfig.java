package cn.jihui.ssm;

import cn.jihui.ssm.interceptor.InitInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@EnableTransactionManagement /*开启事务支持*/
//@ImportResource("classpath:applicationContext.xml")  /*导入XML 配置文件*/
//@PropertySource("classpath:jdbc.properties")  /*导入jdbc 配置文件*/
@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 50)
@MapperScan("cn.jihui.ssm.mapper")  /*mapper的扫描*/
@EnableScheduling
public class ApplicationConfig implements WebMvcConfigurer {
    @Autowired
    private InitInterceptor initInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }

    /**
     * 配置拦截器
     * 一般放行login
     * @param registry
     */
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(initInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
//    }
}
