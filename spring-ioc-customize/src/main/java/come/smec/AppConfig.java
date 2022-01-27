package come.smec;

import come.smec.service.MailSession;
import come.smec.service.User;
import come.smec.service.UserService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.register("sam@example.com", "password", "Sam");
        User user = userService.login("sam@example.com", "password");
        System.out.println(user.getName());
        context.getBean(MailSession.class);
        context.getBean(MailSession.class);
        context.getBean(MailSession.class);
        ((ConfigurableApplicationContext) context).close();
    }
}
