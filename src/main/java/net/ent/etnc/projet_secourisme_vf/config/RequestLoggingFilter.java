package net.ent.etnc.projet_secourisme_vf.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);

        // Passer la requête au reste de la chaîne
        chain.doFilter(requestWrapper, response);

        // Lire le corps de la requête après traitement
        String requestBody = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
        if (!requestBody.isEmpty()) {
            log.info("URI: {}", requestWrapper.getRequestURI());
            log.info("Méthode: {}", requestWrapper.getMethod());
            log.info("Corps de la requête: {}", requestBody);
        }
    }
}