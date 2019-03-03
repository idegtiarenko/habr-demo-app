package habr.demo.app.web;

import habr.demo.app.service.RequestIdProvider;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@Component
public class RequestIdFilter extends OncePerRequestFilter {

    private static final String REQUEST_ID_HEADER_NAME = "X-Request-ID";

    @Autowired
    private RequestIdProvider requestIdProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            String requestId = request.getHeader(REQUEST_ID_HEADER_NAME) != null
                    ? request.getHeader(REQUEST_ID_HEADER_NAME)
                    : requestIdProvider.generateRequestId();

            MDC.put(REQUEST_ID_HEADER_NAME, requestId);
            response.addHeader(REQUEST_ID_HEADER_NAME, requestId);

            chain.doFilter(request, response);

        } finally {
            MDC.remove(REQUEST_ID_HEADER_NAME);
        }
    }
}
