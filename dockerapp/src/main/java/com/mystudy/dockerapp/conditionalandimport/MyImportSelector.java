package com.mystudy.dockerapp.conditionalandimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：songdalin
 * @date ：2021-12-23 下午 05:59
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
 /*       if () {

        }*/
        return new String[]{"com.mystudy.dockerapp.conditionalandimport.City"};
    }
}
