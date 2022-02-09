package learnjava.service;

import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class UserService {

    public final ZoneId zoneId = ZoneId.systemDefault();

    public UserService() {
        System.out.println("UserService(): init...");
        System.out.println("UserService(): zoneId = " + this.zoneId);
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public final ZoneId getFinalZoneId() {
        return zoneId;
    }
}
