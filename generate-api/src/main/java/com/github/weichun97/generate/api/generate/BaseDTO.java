package com.github.weichun97.generate.api.generate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {

    /**
     * 目录
     */
    private String dir;

    /**
     * 包名-根据目录转换
     */
    private String packageName;

    /**
     * 日期 2022-01-01
     */
    private String date;

    /**
     * 时间 12:00:00
     */
    private String time;

    /**
     * 日期+时间 2022-01-01 12:00:00
     */
    private String datetime;
}
