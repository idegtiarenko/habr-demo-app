package habr.demo.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentProvider {

    @Value("${env:unknown}")
    private String environment;

    public String getEnvironment() {
        return environment;
    }
}
