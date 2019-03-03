package habr.demo.app.service;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RequestIdProviderTest {

    private RequestIdProvider requestIdProvider = new RequestIdProvider();

    @Test
    void shouldGenerateRequestId() {

        assertThat(requestIdProvider.generateRequestId())
                .isNotNull()
                .isNotEmpty()
                .matches("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");
    }

    @Test
    void shouldGenerateNewRequestIdOnEachCall() {

        int samples = 5;

        assertThat(Stream.generate(requestIdProvider::generateRequestId).limit(samples).distinct()).hasSize(5);
    }
}