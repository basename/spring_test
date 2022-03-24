package com.basename.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({
        ElementType.METHOD,
        ElementType.FIELD
})
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
