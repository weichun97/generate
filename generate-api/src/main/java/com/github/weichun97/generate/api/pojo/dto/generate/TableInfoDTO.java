package com.github.weichun97.generate.api.pojo.dto.generate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chun
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableInfoDTO implements Serializable {

    private static final long serialVersionUID = -3525784162454061600L;

    /***
     * 表名
     */
    private String tableName;

    /**
     * 表名驼峰，首字母大写
     */
    private String tableNameCamelCase;

    /**
     * 表备注
     */
    private String tableComment;

    /***
     * 表字段信息
     */
    private List<ColumnDTO> columnDtos;
}