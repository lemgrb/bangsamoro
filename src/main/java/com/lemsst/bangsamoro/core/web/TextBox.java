package com.lemsst.bangsamoro.core.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface TextBox {
    public String value() default "Hello world";
}
