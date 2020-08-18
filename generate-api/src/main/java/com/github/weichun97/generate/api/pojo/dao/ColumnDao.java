package com.github.weichun97.generate.api.pojo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.weichun97.generate.api.pojo.entity.ColumnEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:51
 */
@Mapper
public interface ColumnDao extends BaseMapper<ColumnEntity> {

    /**
     * 根据表名查询表的所有列
     * @param tableNames 表名集合
     * @return 表的列数据
     */
    List<ColumnEntity> getByTableNames(@Param("tableNames") List<String> tableNames);
}
