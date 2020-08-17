package ${packageName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${packageName}.pojo.dao.${tableInfo.tableNameCamelCase}Dao;
import ${packageName}.pojo.entity.${tableInfo.tableNameCamelCase}Entity;
import ${packageName}.service.${tableInfo.tableNameCamelCase}Service;
import org.springframework.stereotype.Service;

/**
 * @author chun
 * @date 2020/8/12 15:54
 */
@Service
public class ${tableInfo.tableNameCamelCase}ServiceImpl extends ServiceImpl<${tableInfo.tableNameCamelCase}Dao, ${tableInfo.tableNameCamelCase}Entity> implements ${tableInfo.tableNameCamelCase}Service {


}
