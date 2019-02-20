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
  `update_time` timestamp not null default now() comment '更新时间',
  `insert_time` timestamp not null default '2000-01-01 00:00:00' comment '插入时间',
  `content_id` integer not null default '-1' comment 'content主键'
) default charset = utf8 auto_increment = 1;

# 创建content表
create table if not exists `content` (
  `id` integer not null auto_increment primary key comment '主键id',
  `content` text not null comment '文章内容',
  `update_time` timestamp not null default now() comment '更新时间',
  `insert_time` timestamp not null default '2000-01-01 00:00:00' comment '插入时间'
) default charset = utf8 auto_increment = 1;

# 标签tag_info表
create table if not exists `tag_info` (
  `id` integer not null auto_increment primary key comment '主键id',
  `article_id` integer not null comment '文章id',
  `tag` varchar(20) not null default '' comment '文章tag',
  `update_time` timestamp not null default now() comment '更新时间',
  `insert_time` timestamp not null default '2000-01-01 00:00:00' comment '插入时间'
) default charset = utf8 auto_increment = 1;