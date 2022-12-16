package com.github.weichun97.generate.api.generate.convert;

public class NullColumnTypeConverterImpl implements ColumnTypeConverter {

    @Override
    public String convertType(String type) {
        return null;
    }

    @Override
    public String convertTypeBox(String type) {
        return null;
    }
}
