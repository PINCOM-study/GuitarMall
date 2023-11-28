package PINCOM.GuitarMall.global.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    // 로그인이 필요하지 않은 페이지 url 요청
    private static final String[] whitelist = {"/login", "/logout", "/join"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        HttpServletResponse resp = (HttpServletResponse) response;

        log.info("로그인 인증 체크 필터 시작");

        // whitelist에서 매칭 되지 않는 경우만
        // 인증 체크 로직 시작
        if(isLoginCheckPath(requestURI)) {
            log.info("로그인 인증 체크 로직 실행: " + requestURI);
            HttpSession session = req.getSession();
            if(session.isNew() || session.getAttribute("loginInfo") == null) {
                log.info("미 인증 사용자 요청");
                // 사용자가 원래 가려고 했던 URI를 파라미터 값으로 기억, 로그인 후 해당 페이지로 이동
                resp.sendRedirect("/login?redirectURL=" + requestURI);
                // 미인증 사용자는 다음으로 진행하지 않고 종료
                return;
            }
        }
        // 로그인이 필요 없거나 로그인이 되어 있다면 다음 단계로
        chain.doFilter(request, response);
    }

    // 화이트 리스트의 경우 인증 체크 X
    private boolean isLoginCheckPath(String requestURI) {
        // 매칭이 되지 않을 때 검증 해야 하므로 부정
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI); // simpleMatch: 파라미터 문자열이 특정 패턴에 매칭 되는지 검사
    }
}
