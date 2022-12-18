package com.github.weichun97.generate.api.generate.convert;

import com.github.weichun97.generate.api.var.GenerateVar;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class NullColumnTypeConverter implements ColumnTypeConverter {

    private final int type = GenerateVar.LangConverterType.NULL;

    @Override
    public String convertType(String type) {
        return null;
    }

    @Override
    public String convertTypeBox(String type) {
        return null;
    }
}
