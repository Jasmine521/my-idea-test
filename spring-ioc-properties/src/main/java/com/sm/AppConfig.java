package com.sm;

import com.sm.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.time.ZoneId;

@Configuration
@ComponentScan
@PropertySource("app.properties")
@PropertySource("smtp.properties")
@EnableAspectJAutoProxy
public class AppConfig {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("bob@example.com", "password");
    }

    @Bean
    ZoneId createZoneId(@Value("${app.zone:Z}") String zoneId) {
        return ZoneId.of(zoneId);
    }
}
