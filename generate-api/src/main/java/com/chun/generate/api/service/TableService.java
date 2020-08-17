package com.chun.generate.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chun.generate.api.pojo.entity.TableEntity;
import com.chun.generate.api.pojo.vo.generate.ListResVO;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:53
 */
public interface TableService extends IService<TableEntity> {

    /**
     * 列表查询
     * @return
     */
    List<ListResVO> listQuery();

    /**
     * 根据表名获取表信息
     * @param k
     * @return
     */
    TableEntity getByName(String k);
}
