package com.web.application.e2e.automator.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Lazy
@Bean
@Scope("com/web/application/e2e/automator/browser")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Browser {
}