package habr.demo.app;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
public @interface IntegrationTest {
}
