drop table if exists tongyu_shop;
CREATE TABLE `tongyu_shop` (
  `ID` varchar(50) NOT NULL,
  `TITLE` varchar(100) DEFAULT NULL COMMENT '标题',
  `TYPE` int DEFAULT NULL COMMENT '类型  1：主页置顶商品  2：信息商品列表',
  `CAROUSEL` text DEFAULT NULL COMMENT '轮播图',
  `NUM` int DEFAULT NULL COMMENT '排列序号',
  `SHOWPICTURE` text DEFAULT NULL COMMENT '缩略图展示',
  `RICHTEXT_ID` varchar(50) DEFAULT NULL COMMENT '富文本id；旅游才有',
  `COMMODITY_TYPE` varchar(10) DEFAULT NULL COMMENT '商品类型 1：酒店，2：餐饮，3：酒水，4：建材
，5：设备',
  `COMMODITY_NAME` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `SUM` int DEFAULT NULL COMMENT '总数',
  `SELL` int DEFAULT NULL COMMENT '卖出数量',
  `PRICE` bigint DEFAULT NULL COMMENT '原价：分',
  `DISCOUNT` bigint DEFAULT NULL COMMENT '折扣价：分',
  `COMMODITYDESC` text DEFAULT NULL COMMENT '商品描述',
  `DETAIL` text DEFAULT NULL COMMENT '图文详情',
  `JSON` text DEFAULT NULL,
  `TRADE_START_DATE` varchar(50) DEFAULT NULL COMMENT '购买开始时间',
  `TRADE_END_DATE` varchar(50) DEFAULT NULL COMMENT '购买结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 comment = '商品表';

drop table if exists tongyu_shopmessage;
CREATE TABLE `tongyu_shopmessage` (
  `id` varchar(50) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `text` text,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 comment = '新闻简报表';

drop table if exists tongyu_shoporder;
CREATE TABLE `tongyu_shoporder` (
  `ID` varchar(50) NOT NULL,
  `COMMODITY_ID` varchar(100) DEFAULT NULL COMMENT '商品ID',
  `COMMODITY_NAME` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `TYPE` varchar(10)  DEFAULT NULL COMMENT '类型；0：普通商品: 1：门票',
  `SPECIFICATIONS` text DEFAULT NULL COMMENT '商品规格(json格式)',
  `PRICES` bigint DEFAULT NULL COMMENT '总计价格：分',
  `ORDER_STATUS` varchar(50) DEFAULT NULL COMMENT '订单状态U:未支付P:已支付C：退货中R：已退货',
  `PAY` bigint DEFAULT NULL COMMENT '支付价格：分',
  `SUM` int DEFAULT NULL COMMENT '购买总数',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '下单人id',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '地址',
  `PHONE` varchar(50) DEFAULT NULL COMMENT '用户手机',
  `CREATE_DATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `PAY_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '支付时间',
  `JSON` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 comment = '商品订单表';

drop table if exists tongyu_shoprecommend;
CREATE TABLE `tongyu_shoprecommend` (
  `id` varchar(50) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `shop_id` varchar(50) DEFAULT NULL COMMENT '商品id',
  `type` varchar(20) DEFAULT NULL COMMENT '类型：轮播，活动等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3  comment = '商品推荐表';

drop table if exists tongyu_shoptype;
CREATE TABLE `tongyu_shoptype` (
  `id` varchar(50) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL,
  `recommend` varchar(20) DEFAULT NULL COMMENT '是否推荐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3   comment = '商品分类表';


--20211011 add by
-- 公告用户阅读记录表记录阅读过公告的账户
drop table if exists sys_notice_ready;
create table sys_notice_ready (
  id int(10) NOT NULL  auto_increment,
  notice_id         int(10)          not null     comment '公告ID',
  notice_ReadName      varchar(50)     not null                   comment '阅读账号名',
  create_time         datetime                                   comment '阅读时间',
  primary key (id)
) engine=innodb auto_increment=100  comment = '公告用户阅读记录表';

insert into sys_dict_data values(30, 3,  '新闻',     '3',       'sys_notice_type',     '',   'success', 'N', '0', 'admin', sysdate(), '', null, '公告');
--新闻表
drop table if exists tongyu_news;
CREATE TABLE tongyu_news (
  news_Id bigint(50) NOT NULL auto_increment,
  title  varchar(100)  COMMENT '标题',
  type   char(1)         not null COMMENT '类型  1：主页置顶新闻  2：信息列表新闻',
  carousel_Name   varchar(1000)   COMMENT '轮播图名称',
  thumbnail_Name  varchar(1000)   COMMENT '缩略图名称',
  details        varchar(5000)   COMMENT '新闻详情富文本文件名称',
  create_time       datetime     comment '创建时间',
  ready_Number       	 bigint(20)		 comment '阅读量',
  collection_Number   bigint(20) 		 comment '收藏人数',
  create_by         varchar(64)     default ''                 comment '创建者',
  relation_Id    varchar(30)        comment '关联富文本Id',
  update_time       datetime     comment '更新时间',
  PRIMARY KEY (`news_Id`)
) ENGINE=InnoDB auto_increment=100 comment = '新闻资讯表';

drop table if exists tongyu_news_comment;
create table `tongyu_news_comment` (
`id` int(11) not null auto_increment comment '主键id',
`user_Id` varchar(255) default null comment '评论者昵称',
`content` varchar(255) default null comment '评论的内容',
`news_id` int(11) default null comment '评论的新闻id',
 create_time       datetime     comment '创建时间',
primary key (`id`)

) ENGINE=InnoDB auto_increment=100 comment '评论表';


drop table if exists tongyu_rich_text;
create table `tongyu_rich_text` (
id int(11) not null auto_increment comment '主键id',
title  varchar(50)     default null   comment 'title',
create_Id varchar(20) default null comment '建立者ID',
content varchar(5000) default null comment '富文本内容',
create_Name varchar(255) default null comment '建立者名称',
 create_time       datetime     comment '创建时间',
 update_time       datetime     comment '更新时间',
primary key (`id`)
)ENGINE=InnoDB auto_increment=100 comment '富文本表';


drop table if exists tongyu_config_center;
create table `tongyu_config_center` (
id int(11) not null auto_increment comment '主键id',
title  varchar(50)     default null   comment '标题',
create_Id varchar(20) default null comment '建立者ID',
details  varchar(5000) default null comment '配置数据内容',
config_type varchar(2) default null comment '配置类型',
remarks     varchar(1000)  default null comment '备注信息',
create_time       datetime     comment '创建时间',
update_time       datetime     comment '更新时间',
primary key (`id`)
)ENGINE=InnoDB auto_increment=100 comment '配置中心表';