package com.github.weichun97.generate.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.weichun97.generate.api.pojo.entity.DatasourceEntity;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:53
 */
public interface DatasourceService extends IService<DatasourceEntity> {

    List<ListVO> listQuery();
}
