package com.github.weichun97.generate.autoconfigure.annotations;

import com.github.weichun97.generate.autoconfigure.configuration.GenerateAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({GenerateAutoConfigure.class})
public @interface EnableGenerate {
}
