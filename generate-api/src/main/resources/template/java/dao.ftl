package ${packageName}.pojo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${packageName}.pojo.entity.${tableInfo.tableNameCamelCase}Entity;

/**
 * @author chun
 * @date 2020/8/12 15:51
 */
@Mapper
public interface ${tableInfo.tableNameCamelCase}Dao extends BaseMapper<${tableInfo.tableNameCamelCase}Entity> {

}
