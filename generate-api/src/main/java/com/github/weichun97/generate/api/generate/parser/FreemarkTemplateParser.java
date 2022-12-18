package com.github.weichun97.generate.api.generate.parser;

import com.github.weichun97.generate.api.generate.GenerateContext;
import com.github.weichun97.generate.api.var.GenerateVar;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;

@Getter
@Component
public class FreemarkTemplateParser implements TemplateParser {

    private int type = GenerateVar.TemplateType.FREEMARK;

    @Resource
    private Configuration configuration;

    @Override
    public String parse(GenerateContext content, String templateStr) throws IOException, TemplateException {
        Template template = new Template("temp", templateStr, configuration);
        StringWriter stringWriter = new StringWriter();
        template.process(content, stringWriter);
        return stringWriter.toString();
    }
}
