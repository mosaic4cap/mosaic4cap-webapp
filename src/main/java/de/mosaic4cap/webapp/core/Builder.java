package de.mosaic4cap.webapp.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * Created by svenklemmer on 09.10.14.
 *
 * Builder annotations marks a builder class
 * its annotated with {@link org.springframework.stereotype.Component} to make its
 * marked class available in spring context
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Builder {
}
