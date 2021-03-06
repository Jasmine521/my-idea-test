package come.smec.service;

import come.smec.validator.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    MailService mailService;

    @Autowired
    Validators validators;

    public UserService(@Autowired MailService mailService) {
        this.mailService = mailService;
    }

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "bob@example.com", "password", "Bob"), // bob
            new User(2, "alice@example.com", "password", "Alice"), // alice
            new User(3, "tom@example.com", "password", "Tom")
    ));

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed.");
    }

    public Optional<User> getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst();
    }

    @MetricTime("register")
    public User register(String email, String password, String name) {
        validators.validate(email, password, name);
        users.forEach((user -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        }));
        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong(), email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }
}
