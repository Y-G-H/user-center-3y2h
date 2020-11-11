package cn.y3h2.blog.user.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {
        "cn.y3h2.blog.user.web",
        "cn.y3h2.blog.user.provider",
        "cn.y3h2.blog.user.core",
})
@Configuration
@EnableScheduling
@MapperScan("cn.y3h2.blog.user.core.dao")
@ImportResource("classpath:/spring/dubbo.xml")
public class DubboStarter {

    public static void main(String[] args) {
        SpringApplication application =
                new SpringApplication(DubboStarter.class);
        application.run(args);
    }

}
