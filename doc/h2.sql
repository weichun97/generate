DROP TABLE IF EXISTS TL_TEMPLATE;
create table TL_TEMPLATE
(
    ID           BIGINT auto_increment
        primary key,
    NAME         VARCHAR(50)              not null,
    CREATE_TIME  TIMESTAMP WITH TIME ZONE not null,
    UPDATE_TIME  TIMESTAMP WITH TIME ZONE,
    DELETE_TIME  TIMESTAMP WITH TIME ZONE,
    CUSTOM_FIELD CLOB,
    BASE_DIR     VARCHAR(100),
    REMARK     VARCHAR(100)
);
comment on table TL_TEMPLATE is '模板组';
comment on column TL_TEMPLATE.NAME is '名称';
comment on column TL_TEMPLATE.CREATE_TIME is '创建时间';
comment on column TL_TEMPLATE.UPDATE_TIME is '更新时间';
comment on column TL_TEMPLATE.DELETE_TIME is '删除时间';
comment on column TL_TEMPLATE.CUSTOM_FIELD is '自定义字段';
comment on column TL_TEMPLATE.BASE_DIR is '基础文件夹';
comment on column TL_TEMPLATE.REMARK is '备注';

DROP TABLE IF EXISTS TL_TEMPLATE_DETAIL;
create table TL_TEMPLATE_DETAIL
(
    ID          BIGINT auto_increment
        primary key,
    NAME        VARCHAR(100)             not null,
    CONTENT     CLOB                     not null,
    FILE_NAME   VARCHAR(100)             not null,
    DIR         VARCHAR(200),
    TEMPLATE_ID BIGINT                   not null,
    DELETE_TIME TIMESTAMP WITH TIME ZONE,
    CREATE_TIME TIMESTAMP WITH TIME ZONE not null,
    UPDATE_TIME TIMESTAMP WITH TIME ZONE
);
comment on table TL_TEMPLATE_DETAIL is '模板详情';
comment on column TL_TEMPLATE_DETAIL.NAME is '模板名';
comment on column TL_TEMPLATE_DETAIL.CONTENT is '内容';
comment on column TL_TEMPLATE_DETAIL.FILE_NAME is '文件名';
comment on column TL_TEMPLATE_DETAIL.DIR is '目录';
comment on column TL_TEMPLATE_DETAIL.TEMPLATE_ID is '模板组id';
comment on column TL_TEMPLATE_DETAIL.DELETE_TIME is '删除时间';
comment on column TL_TEMPLATE_DETAIL.CREATE_TIME is '创建时间';
comment on column TL_TEMPLATE_DETAIL.UPDATE_TIME is '更新时间';

DROP TABLE IF EXISTS TL_DATASOURCE;
create table TL_DATASOURCE
(
    ID          BIGINT auto_increment,
    HOST        VARCHAR(50)              not null,
    PORT        INT                      not null,
    USERNAME    VARCHAR(50)              not null,
    PASSWORD    VARCHAR(100)             not null,
    DB_NAME     VARCHAR(50)              not null,
    DB_TYPE     INT                      not null,
    DEL_PREFIX  VARCHAR(100),
    CREATE_TIME TIMESTAMP WITH TIME ZONE not null,
    UPDATE_TIME TIMESTAMP WITH TIME ZONE,
    DELETE_TIME TIMESTAMP WITH TIME ZONE,
    constraint TL_DATASOURCE_PK
        primary key (ID)
);
comment on table TL_DATASOURCE is '数据源';
comment on column TL_DATASOURCE.ID is 'id';
comment on column TL_DATASOURCE.HOST is 'host';
comment on column TL_DATASOURCE.PORT is '端口号';
comment on column TL_DATASOURCE.USERNAME is '用户名';
comment on column TL_DATASOURCE.PASSWORD is '密码';
comment on column TL_DATASOURCE.DB_NAME is '数据库名';
comment on column TL_DATASOURCE.DB_TYPE is '数据库类型';
comment on column TL_DATASOURCE.DEL_PREFIX is '删除的表前缀';
comment on column TL_DATASOURCE.CREATE_TIME is '创建时间';
comment on column TL_DATASOURCE.UPDATE_TIME is '更新时间';
comment on column TL_DATASOURCE.DELETE_TIME is '删除时间';

