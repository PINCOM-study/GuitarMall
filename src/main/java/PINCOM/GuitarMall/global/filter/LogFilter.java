package PINCOM.GuitarMall.global.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // ServletRequest -> HttpServletRequest 로 명시적 형변환 해주기
        HttpServletRequest req = (HttpServletRequest)request;
        String requestURI = req.getRequestURI();

        log.debug("requestURI: " + requestURI);

        chain.doFilter(request, response);

        log.debug("responseURI: " + requestURI);
    }
}
