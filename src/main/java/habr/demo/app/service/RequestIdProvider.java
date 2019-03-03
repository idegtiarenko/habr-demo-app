package habr.demo.app.service;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestIdProvider {

    public String generateRequestId() {
        return UUID.randomUUID().toString();
    }
}
