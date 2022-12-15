package com.github.weichun97.generate.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.weichun97.generate.api.pojo.entity.DatasourceEntity;
import com.github.weichun97.generate.api.pojo.param.datasource.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:53
 */
public interface DatasourceService extends IService<DatasourceEntity> {

    /**
     * 数据源列表
     * @return
     */
    List<ListVO> listQuery();

    /**
     * 保存数据源
     * @param saveOrUpdateParam
     */
    void save(SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 删除数据源
     * @param id
     */
    void remove(Long id);

    /**
     * 更新数据源
     * @param id
     * @param saveOrUpdateParam
     */
    void update(Long id, SaveOrUpdateParam saveOrUpdateParam);

    /**
     * 测试连接
     * @param saveOrUpdateParam
     */
    void test(SaveOrUpdateParam saveOrUpdateParam);
}
