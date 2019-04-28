DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键uid',
  `username` varchar(36) NOT NULL COMMENT '用户名，账号',
  `password` varchar(36) NOT NULL COMMENT '密码',
  `name` varchar(36) NOT NULL COMMENT '真实姓名',
  `birthday` varchar(36) NOT NULL COMMENT '出生日期',
  `sex` varchar(8) NOT NULL COMMENT '男或女',
  `telephone` varchar(20) NOT NULL COMMENT '手机号',
  `email` varchar(36) NOT NULL COMMENT '邮箱',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';
INSERT INTO `user` VALUES ('1', 'balance', '81dc9bdb52d04dc20036dbd8313ed055', '胡棋', '1997-10-17', '男', '18895310288', '1079942151@qq.com');
INSERT INTO `user` VALUES ('2', 'didi', '81dc9bdb52d04dc20036dbd8313ed055', '操浩东', '1996-07-16', '女', '15720579211', '787868789@qq.com');

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键bid',
  `bname` varchar(36) NOT NULL COMMENT '品牌名称',
  PRIMARY KEY (`bid`),
  UNIQUE KEY `AK_brandname` (`bname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '品牌表';
INSERT INTO `brand` VALUES ('1', '圣象地板');
INSERT INTO `brand` VALUES ('2', '大自然地板');
INSERT INTO `brand` VALUES ('3', '扬子地板');
INSERT INTO `brand` VALUES ('4', '生活家地板');
INSERT INTO `brand` VALUES ('5', '久盛地板');
INSERT INTO `brand` VALUES ('6', '世和地板');
INSERT INTO `brand` VALUES ('7', '德尔地板');
INSERT INTO `brand` VALUES ('8', '西塞罗地板');

DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键sid',
  `sname` varchar(200) NOT NULL COMMENT '卖家名称',
  `telephone` varchar(20) NOT NULL COMMENT '电话',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `AK_sellername` (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '卖家表';
INSERT INTO `seller` VALUES ('1', '胡棋', '18895310288', '宿州学院');

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键rid' ,
  `rname` varchar(500) NOT NULL COMMENT '线路名称' ,
  `price` double NOT NULL COMMENT '价格' ,
  `route_introduce` varchar(1000) DEFAULT NULL COMMENT '线路介绍' ,
  `rflag` varchar(10) NOT NULL COMMENT '是否上架' ,
  `rdate` varchar(19) DEFAULT NULL COMMENT '上架时间' ,
  `isdiscount` varchar(10) NOT NULL COMMENT '是否优惠' ,
  `count` int(11) DEFAULT '0' COMMENT '收藏数量' ,
  `bid` int(11) NOT NULL COMMENT '所属分类' ,
  `rimage` varchar(200) DEFAULT NULL COMMENT '缩略图' ,
  `sid` int(11) DEFAULT NULL COMMENT '所属商家' ,
  `source_id` varchar(50) DEFAULT NULL COMMENT '抓取数据的来源id' ,
  `isdelete` int(10) NOT NULL COMMENT '是否删除' ,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `AK_source_id` (`source_id`),
  KEY `FK_brand_route` (`bid`),
  KEY `FK_seller_route` (`sid`),
  CONSTRAINT `FK_brand_route` FOREIGN KEY (`bid`) REFERENCES `brand` (`bid`),
  CONSTRAINT `FK_seller_route` FOREIGN KEY (`sid`) REFERENCES `seller` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=521 DEFAULT CHARSET=utf8 COMMENT '地板线路表';
INSERT INTO `route` VALUES ('1', '圣象地板 F4星环保浮雕面强化复合耐磨北欧卧室客厅家用木地板 F4星级摩登夜色NF1103-全包价', '140', '圣象强化复合木地板精选百年以上珍贵硬木，历经年份的沉淀，充分发挥原木本身的柔和色彩、细密质感以及天然纹理，并融入时尚百搭的设计，是简单结构与舒适功能的完美结合。', '1', '2019-02-09 07:13:16', '0', '73', '1', 'img/product/small/m304b69a4c8328f7d6b8d5dadef020fe07.jpg', '1', '23677', '1');
INSERT INTO `route` VALUES ('2', '大自然（Nature） 实木多层复合地板15mm 番龙眼2色（裸板） DJX66Z', '194', '大自然实木多层复合地板结构稳固，环保健康，是不可多得的品质之选，其引进使用德国高端技术，78道工序工匠品质地板保驾护航，可以说是为高品质生活量身定制。', '1', '2019-02-09 08:32:47', '1', '86', '2', 'img/product/small/m34866f055de8630e94e25c40f277a79ba.jpg', '1', '22066', '0');
INSERT INTO `route` VALUES ('3', '生活家巴洛克地板桦木多层实木复合木地板家用地热环保木地板15mm 地板木地板复合地板 黄金贵族', '189', '生活家地热环保地板继承北欧北欧百年精工制木的良匠工艺，采用了欧洲专利锁扣技术，保证地板连接处的无缝和超抗变形能力，安装时只需将两块地板上下对合，就能精密地扣合。', '1', '2019-02-09 09:56:12', '0', '62', '4', 'img/product/small/m3db4d2277b5df3d98597f79082ef92d6d.jpg', '1', '21998', '0');

DROP TABLE IF EXISTS `route_img`;
CREATE TABLE `route_img` (
  `rgid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键rgid',
  `rid` int(11) NOT NULL COMMENT '地板id',
  `big_pic` varchar(200) NOT NULL COMMENT '详情商品大图',
  `small_pic` varchar(200) DEFAULT NULL COMMENT '详情商品小图',
  PRIMARY KEY (`rgid`),
  KEY `FK_route_routeimg` (`rid`),
  CONSTRAINT `FK_route_routeimg` FOREIGN KEY (`rid`) REFERENCES `route` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '地板图片列表';
INSERT INTO `route_img` VALUES ('1', '1', 'img/product/size4/m421d66d4446940b1c80a0092c91e75184.jpg', 'img/product/size2/m221d66d4446940b1c80a0092c91e75184.jpg');
INSERT INTO `route_img` VALUES ('2', '1', 'img/product/size4/m4227f0cde1b021a77c56c1c18a8f2e7fd.jpg', 'img/product/size2/m2227f0cde1b021a77c56c1c18a8f2e7fd.jpg');
INSERT INTO `route_img` VALUES ('3', '1', 'img/product/size4/m412cf97538027a813a4fb0bd6980a7fea.jpg', 'img/product/size2/m212cf97538027a813a4fb0bd6980a7fea.jpg');
INSERT INTO `route_img` VALUES ('4', '1', 'img/product/size4/m47fe3031a3df75ab5e6711ae2338c18f7.jpg', 'img/product/size2/m27fe3031a3df75ab5e6711ae2338c18f7.jpg');
INSERT INTO `route_img` VALUES ('5', '2', 'img/product/size4/m44866f055de8630e94e25c40f277a79ba.jpg', 'img/product/size2/m24866f055de8630e94e25c40f277a79ba.jpg');
INSERT INTO `route_img` VALUES ('6', '3', 'img/product/size4/m4db4d2277b5df3d98597f79082ef92d6d.jpg', 'img/product/size2/m2db4d2277b5df3d98597f79082ef92d6d.jpg');

DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `rid` int(11) NOT NULL COMMENT '主键rid',
  `date` date NOT NULL COMMENT '收藏日期',
  `uid` int(11) NOT NULL COMMENT '主键uid',
  PRIMARY KEY (`rid`,`uid`),
  KEY `FK_route_favorite` (`rid`),
  KEY `FK_user_favorite` (`uid`),
  CONSTRAINT `FK_route_favorite` FOREIGN KEY (`rid`) REFERENCES `route` (`rid`),
  CONSTRAINT `FK_user_favorite` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '收藏表';
INSERT INTO `favorite` VALUES ('1', '2019-2-23', '1');
INSERT INTO `favorite` VALUES ('1', '2019-2-23', '2');
INSERT INTO `favorite` VALUES ('2', '2019-2-23', '1');
INSERT INTO `favorite` VALUES ('3', '2019-2-23', '1');
INSERT INTO `favorite` VALUES ('3', '2019-2-24', '2');
