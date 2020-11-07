package cn.y3h2.blog.user.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {
        "cn.y3h2.blog.user.provider",
})
@Configuration
@EnableScheduling
@ImportResource("classpath:/spring/dubbo.xml")
public class DubboStarter {

    public static void main(String[] args) {
        SpringApplication application =
                new SpringApplication(DubboStarter.class);
        application.run(args);
    }

}
