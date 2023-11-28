package PINCOM.GuitarMall.global.config;

import PINCOM.GuitarMall.global.filter.LogFilter;
import PINCOM.GuitarMall.global.filter.LoginCheckFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean<Filter> logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new LogFilter());  // LogFilter 등록
        filterRegistrationBean.setOrder(1); // 먼저 적용할 필터 순서
        filterRegistrationBean.addUrlPatterns("/*");    // 모든 URL 다 적용 -> 모든 요청에 다 필터 적용
        return filterRegistrationBean;
    }

    // 로그 필터 등록
    @Bean
    public FilterRegistrationBean<Filter> loginCheckFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new LoginCheckFilter());   // LoginCheckFilter 등록
        filterRegistrationBean.setOrder(2); // 먼저 적용할 필터 순서
        filterRegistrationBean.addUrlPatterns("/*");    // 모든 URL 다 적용 -> 모든 요청에 다 필터 적용
        return filterRegistrationBean;
    }
}
