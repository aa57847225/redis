package com.whl.demo.service;

import java.lang.annotation.*;

/**
 * @description 防止表单重复提交注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DuplicateSubmitToken {

    //保存重复提交标记 默认为需要保存
    boolean save() default true;

//    //超时时间：默认5秒
//    long timeout() default 5000;

}
