drop table if exists tongyu_shop;
CREATE TABLE `tongyu_shop` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` bigint DEFAULT NULL COMMENT '原价：分',
  `discount` bigint DEFAULT NULL COMMENT '折扣价：分',
  `sum` int DEFAULT NULL COMMENT '剩余总数',
  `sell` int DEFAULT NULL COMMENT '卖出数量',
  `carousel` json DEFAULT NULL COMMENT '轮播',
  `detail` json DEFAULT NULL COMMENT '图文详情',
  `richText_id` varchar(50) DEFAULT NULL COMMENT '富文本id；旅游才有',
  `json` json DEFAULT NULL,
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
  `id` varchar(50) NOT NULL,
  `prices` bigint DEFAULT NULL COMMENT '总计价格：分',
  `pay` bigint DEFAULT NULL COMMENT '支付价格：分',
  `sum` int DEFAULT NULL COMMENT '购买总数',
  `shop_id` varchar(50) DEFAULT NULL COMMENT '商品id',
  `order_status` varchar(50) DEFAULT NULL COMMENT '订单状态',
  `type` varchar(50)  DEFAULT NULL COMMENT '类型；普通商品，门票',
  `user_id` varchar(50) DEFAULT NULL COMMENT '下单人id',
  `json` json DEFAULT NULL,
  `payTime` datetime DEFAULT NULL COMMENT '支付时间',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '用户手机',
  `create_date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
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
  details        varchar(2000)   COMMENT '新闻详情富文本文件名称',
  create_time       datetime     comment '创建时间',
  ready_Number       	 bigint(20)		 comment '阅读量',
  collection_Number   bigint(20) 		 comment '收藏人数',
  create_by         varchar(64)     default ''                 comment '创建者',
	update_time       datetime     comment '更新时间',
  PRIMARY KEY (`news_Id`)
) ENGINE=InnoDB auto_increment=100 comment = '新闻资讯表';