package com.github.weichun97.generate.api.generate;

import com.github.weichun97.generate.common.util.Enums;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/13 11:33
 */
public interface GenerateVar {


    /**
     * 模板类型
     */
    String ENTITY = "entity";
    String DAO = "dao";
    String DAO_XML = "daoXml";
    String SERVICE = "service";
    String SERVICE_IMPL = "serviceImpl";
    String MAPPER = "mapstruct";

    /**
     * 所有生成的模板类型
     */
    List<String> TYPE_LIST = Arrays.asList(new String[]{
            GenerateVar.ENTITY,
            GenerateVar.DAO,
            GenerateVar.SERVICE,
            GenerateVar.SERVICE_IMPL,
            GenerateVar.MAPPER,
            GenerateVar.DAO_XML
    });

    /**
     * 模板注释
     */
    Enums SCOPE = Enums.build()
            .add(ENTITY, "entity")
            .add(DAO, "dao")
            .add(SERVICE, "服务")
            .add(SERVICE_IMPL, "服务实现类")
            .add(MAPPER, "mapstruct")
            .add(DAO_XML, "mybatis的xml文件")
            ;
    /**
     * 模板位置
     */
    Enums TEMPLATE_FILE = Enums.build()
            .add(ENTITY, "java"+ File.separator +"entity.ftl")
            .add(DAO, "java"+ File.separator +"dao.ftl")
            .add(SERVICE, "java"+ File.separator +"service.ftl")
            .add(SERVICE_IMPL, "java"+ File.separator +"service_impl.ftl")
            .add(MAPPER, "java"+ File.separator +"mapper.ftl")
            .add(DAO_XML, "java"+ File.separator +"dao_xml.ftl")
            ;

    /**
     * 模板存放模块
     */
    Enums TEMPLATE_MODULE_PATH = Enums.build()
            .add(ENTITY, "pojo"+ File.separator +"entity")
            .add(DAO, "pojo"+ File.separator +"dao")
            .add(SERVICE, "service")
            .add(SERVICE_IMPL, "service"+ File.separator +"impl")
            .add(MAPPER, "pojo"+ File.separator +"mapper")
            .add(DAO_XML, "mapper")
            ;

    /**
     * 模板文件后缀
     */
    Enums TEMPLATE_SUFFIX = Enums.build()
            .add(ENTITY, "Entity.java")
            .add(DAO, "Dao.java")
            .add(SERVICE, "Service.java")
            .add(SERVICE_IMPL, "ServiceImpl.java")
            .add(MAPPER, "Mapper.java")
            .add(DAO_XML, "Dao.xml")
            ;
}
