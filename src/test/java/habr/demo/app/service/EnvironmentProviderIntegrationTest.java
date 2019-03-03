package habr.demo.app.service;

import habr.demo.app.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
class EnvironmentProviderIntegrationTest {

    @Autowired
    private EnvironmentProvider environment;

    @Test
    void shouldREsolveEnvironment() {

        assertThat(environment.getEnvironment()).isEqualTo("test");
    }
}