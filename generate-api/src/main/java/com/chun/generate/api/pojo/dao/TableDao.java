package com.chun.generate.api.pojo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chun.generate.api.pojo.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:51
 */
@Mapper
public interface TableDao extends BaseMapper<TableEntity> {

    /**
     * 列表查询
     * @return 数据表列表
     */
    List<TableEntity> listQuery();

    /**
     * 通过表名获取表信息
     * @param k 表名
     * @return 表信息
     */
    TableEntity getByName(String k);
}
