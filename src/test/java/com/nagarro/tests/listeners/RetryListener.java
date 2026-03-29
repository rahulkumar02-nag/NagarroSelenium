package com.nagarro.tests.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.nagarro.tests.retry.RetryAnalyzer;

public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(
    		ITestAnnotation annotation, 
    		Class testClass,
    		Constructor testConstructor,
    		Method testMethod) {

        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}