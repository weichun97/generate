package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.weichun97.generate.api.pojo.dao.DatasourceDao;
import com.github.weichun97.generate.api.pojo.entity.DatasourceEntity;
import com.github.weichun97.generate.api.pojo.mapper.DatasourceMapper;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;
import com.github.weichun97.generate.api.service.DatasourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:54
 */
@Service
public class DatasourceServiceImpl extends ServiceImpl<DatasourceDao, DatasourceEntity> implements DatasourceService {

    @Resource
    private DatasourceMapper maps;

    @Override
    public List<ListVO> listQuery() {
        List<DatasourceEntity> datasourceEntities = list(new LambdaQueryWrapper<DatasourceEntity>()
                .orderByDesc(DatasourceEntity::getCreateTime)
        );
        return CollUtil.isEmpty(datasourceEntities) ? Collections.emptyList() : maps.poToListVo(datasourceEntities);
    }
}
