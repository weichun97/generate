package com.github.weichun97.generate.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.weichun97.generate.api.pojo.entity.ColumnEntity;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:53
 */
public interface ColumnService extends IService<ColumnEntity> {

    /**
     * 根据表名获取表字段
     * @param tableNames
     * @return
     */
    List<ColumnEntity> getByTableNames(List<String> tableNames);
}
