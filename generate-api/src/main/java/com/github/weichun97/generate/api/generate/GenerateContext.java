package com.github.weichun97.generate.api.generate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerateContext {

    /**
     * 自定义字段
     */
    private Map<String, String> custom;

    /**
     * 基本信息
     */
    private BaseDTO base;

    /**
     * 表信息
     */
    private TableDTO table;

    /**
     * 字段信息
     */
    private List<ColumnDTO> columns;
}
