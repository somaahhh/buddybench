package com.buddybench.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Component
    @ControllerAdvice
    public class CustomExceptionHandlerResolver {
        @ExceptionHandler(value= BindException.class)
        protected ModelAndView handleBindException(
                BindException ex, HttpServletRequest request, HttpServletResponse response, @Nullable Object handler)
                throws IOException {
            System.out.println("In CustomExceptionHandlerResolver");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return new ModelAndView();
        }

    }
}
