# 创建数据库
create database `phoenix` charset utf8 collate utf8_general_ci;

# 选择数据库
use phoenix;

# 创建article表
create table if not exists `article` (
  `id` integer not null auto_increment primary key comment '主键id',
  `title` varchar(100) not null comment '标题',
  `outline` varchar(500) not null comment '概述',
  `category` varchar(50) not null comment '类别',
  `update_time` timestamp not null comment '更新时间',
  `rowkey` varchar(200) not null default '' comment 'hbase主键'
) default charset = utf8 auto_increment = 1;