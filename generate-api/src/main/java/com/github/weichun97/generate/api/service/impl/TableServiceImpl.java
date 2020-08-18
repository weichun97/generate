package com.github.weichun97.generate.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.weichun97.generate.api.pojo.dao.TableDao;
import com.github.weichun97.generate.api.pojo.mapper.TableMapper;
import com.github.weichun97.generate.api.pojo.entity.TableEntity;
import com.github.weichun97.generate.api.pojo.vo.generate.ListResVO;
import com.github.weichun97.generate.api.service.TableService;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 15:54
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableDao, TableEntity> implements TableService {

    @Resource
    TableMapper tableMapper;

    @Override
    @NonNull
    public List<ListResVO> listQuery() {
        List<TableEntity> list = this.baseMapper.listQuery();
        return list == null ? Collections.EMPTY_LIST : tableMapper.poToListResVO(list);
    }

    @Override
    @Nullable
    public TableEntity getByName(String k) {
        return this.baseMapper.getByName(k);
    }
}
