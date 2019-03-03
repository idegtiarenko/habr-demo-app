package habr.demo.app.service;

import org.springframework.stereotype.Component;

@Component
public class VersionProvider {

    private String version = VersionProvider.class.getPackage().getImplementationVersion();

    public String getVersion() {
        return version;
    }
}
