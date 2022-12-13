DROP TABLE IF EXISTS TL_TEMPLATE;
CREATE TABLE IF NOT EXISTS TL_TEMPLATE(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id' PRIMARY KEY,
    name VARCHAR(20) NOT NULL COMMENT '名称',
    create_time TIMESTAMP WITH TIME ZONE NOT NULL COMMENT '创建时间',
    update_time TIMESTAMP WITH TIME ZONE COMMENT '更新时间',
    delete_time TIMESTAMP WITH TIME ZONE COMMENT '删除时间'
);

DROP TABLE IF EXISTS TL_TEMPLATE_DETAIL;
CREATE TABLE TL_TEMPLATE_DETAIL (
    ID BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id' PRIMARY KEY,
    TEMPLATE_ID BIGINT NOT NULL COMMENT '模板id',
    NAME VARCHAR(100) NOT NULL COMMENT '名称',
    CONTENT CLOB NOT NULL COMMENT '内容',
    SUFFIX VARCHAR(20) COMMENT '文件后缀',
    DIR VARCHAR(20) COMMENT '文件目录',
    create_time TIMESTAMP WITH TIME ZONE NOT NULL COMMENT '创建时间',
    update_time TIMESTAMP WITH TIME ZONE COMMENT '更新时间',
    delete_time TIMESTAMP WITH TIME ZONE COMMENT '删除时间'
);