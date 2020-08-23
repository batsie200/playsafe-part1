package com.rc.assessment.test.playsafepart1.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        long endTime = System.currentTimeMillis();
        long startTime = (Long)request.getAttribute("startTime");
        request.setAttribute("endTime", endTime);
        long executeTime = endTime - startTime;
        request.setAttribute("timeTaken", executeTime);
        log.info("Request Duration Time : {}", request.getAttribute("timeTaken"));
    }
}
