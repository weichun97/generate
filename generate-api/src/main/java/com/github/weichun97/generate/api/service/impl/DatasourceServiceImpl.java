package com.github.weichun97.generate.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.db.Db;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.weichun97.generate.api.pojo.dao.DatasourceDao;
import com.github.weichun97.generate.api.pojo.entity.DatasourceEntity;
import com.github.weichun97.generate.api.pojo.mapper.DatasourceMapper;
import com.github.weichun97.generate.api.pojo.param.datasource.SaveOrUpdateParam;
import com.github.weichun97.generate.api.pojo.vo.datasource.ListVO;
import com.github.weichun97.generate.api.service.DatasourceService;
import com.github.weichun97.generate.api.util.JdbcUtils;
import com.github.weichun97.generate.api.var.DatasourceVar;
import com.github.weichun97.generate.common.api.ResultCode;
import com.github.weichun97.generate.common.exception.ApiException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    @Override
    public void save(SaveOrUpdateParam saveOrUpdateParam) {
        test(saveOrUpdateParam);
        save(maps.saveOrUpdateParamToPo(saveOrUpdateParam));
    }

    @Override
    public void remove(Long id) {
        removeById(id);
    }

    @Override
    public void update(Long id, SaveOrUpdateParam saveOrUpdateParam) {
        test(saveOrUpdateParam);
        update(maps.saveOrUpdateParamToPo(saveOrUpdateParam),
                new LambdaQueryWrapper<DatasourceEntity>().eq(DatasourceEntity::getId, id));
    }

    @Override
    public void test(SaveOrUpdateParam saveOrUpdateParam) {
        Connection connect = JdbcUtils.getConnect(maps.saveOrUpdateParamToJdbcParam(saveOrUpdateParam));
        JdbcUtils.close(connect);
    }
}
