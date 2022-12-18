package com.github.weichun97.generate.api.generate.parser;

import com.github.weichun97.generate.api.generate.GenerateContext;
import com.github.weichun97.generate.api.var.GenerateVar;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class NullTemplateParser implements TemplateParser {

    private int type = GenerateVar.TemplateType.NULL;

    @Override
    public String parse(GenerateContext content, String templateStr) {
        return null;
    }
}
