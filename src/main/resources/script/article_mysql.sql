# 创建数据库
create database `phoenix` charset utf8 collate utf8_general_ci;

# 创建article表
create table if not exists `article` (
  `id` integer not null auto_increment primary key comment '主键id',
  `title` varchar(50) not null comment '标题',
  `hbase_path` varchar(200) not null default '' comment 'hbase路径'
) default charset = utf8 auto_increment = 1;