package com.chun.generate.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chun.generate.api.pojo.dao.ColumnDao;
import com.chun.generate.api.pojo.entity.ColumnEntity;
import com.chun.generate.api.service.ColumnService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:54
 */
@Service
public class ColumnServiceImpl extends ServiceImpl<ColumnDao, ColumnEntity> implements ColumnService {

    @Override
    public List<ColumnEntity> getByTableNames(List<String> tableNames) {
        List<ColumnEntity> columnEntities = this.baseMapper.getByTableNames(tableNames);
        return columnEntities == null ? Collections.EMPTY_LIST : columnEntities;
    }
}
