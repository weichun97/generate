package com.github.weichun97.generate.api.pojo.mapper;

import com.github.weichun97.generate.api.generate.TableDTO;
import com.github.weichun97.generate.api.pojo.vo.generate.TablesVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface TableMapper {
    TablesVO dtoToVo(TableDTO tableDTO);

    List<TablesVO> dtoToVo(List<TableDTO> tableDTOS);
}
