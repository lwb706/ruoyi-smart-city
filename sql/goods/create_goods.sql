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
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型；普通商品，门票',
  `user_id` varchar(50) DEFAULT NULL COMMENT '下单人id',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
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