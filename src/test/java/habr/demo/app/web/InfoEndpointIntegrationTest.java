package habr.demo.app.web;

import habr.demo.app.IntegrationTest;
import habr.demo.app.service.VersionProvider;
import habr.demo.app.web.model.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@IntegrationTest
class InfoEndpointIntegrationTest {

    @Autowired
    private TestRestTemplate client;

    @MockBean
    private VersionProvider versionProvider;

    @Test
    void shouldDisplayInfo() {

        String version = "latest-under-test";
        when(versionProvider.getVersion()).thenReturn(version);

        //when
        Info info = client.getForObject("/info", Info.class);

        //then
        assertThat(info)
                .isNotNull()
                .isEqualTo(new Info(
                        "habr-demo-app",
                        version,
                        "test"
                ));
    }
}