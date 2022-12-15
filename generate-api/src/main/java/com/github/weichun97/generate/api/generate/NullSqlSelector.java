package com.github.weichun97.generate.api.generate;

import com.github.weichun97.generate.api.var.DatasourceVar;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class NullSqlSelector implements SqlSelector{

    private final int dbType = DatasourceVar.DbType.NULL;

    @Override
    public String showTablesSql(String database) {
        return null;
    }
}
