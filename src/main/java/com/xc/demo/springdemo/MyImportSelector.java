package com.xc.demo.springdemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportSelector implements ImportSelector {

    //AnnotationMetadata : 标注的类的注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        System.out.println(annotationTypes);
        return new String[]{"com.xc.demo.springdemo.Person"};
    }
}
