package com.web.application.e2e.automator.browser.scope;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BrowserScopePostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        beanFactory.registerScope("com/web/application/e2e/automator/browser", new BrowserScope());
    }

}