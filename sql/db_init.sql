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
INSERT INTO `brand` VALUES ('8', '其他');

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
INSERT INTO `route` VALUES ('1', '圣象地板强化复合地板F4星环保地板浮雕耐磨家用NF11地暖木地板', '108', 'F4星环保大浮雕耐磨地板易打理不开裂', '1', '2019-02-10 09:56:12', '1', '62', '1', 'img/product/small/s20190429134001.jpg', '1', '21996', '0');
INSERT INTO `route` VALUES ('2', '圣象地板 三层实木复合蓝山橡木无缝拼接客厅卧室北欧地暖木地板', '368', '热销爆款 橡木地板 主流百搭 北欧风格', '1', '2019-02-11 09:56:12', '0', '52', '1', 'img/product/small/s20190429142301.jpg', '1', '21596', '0');
INSERT INTO `route` VALUES ('3', '圣象地板家用强化复合地板F4星环保浮雕耐磨木地板客厅卧室', '118', 'F4星大浮雕耐磨环保 升级安装补贴50%安装费', '1', '2019-02-12 09:56:12', '1', '48', '1', 'img/product/small/s20190429144401.jpg', '1', '22586', '0');
INSERT INTO `route` VALUES ('4', '圣象地板 多层实木复合橡木（柞木）15mm北欧浅色地暖环保木地板', '248', '圣象23年品质护航', '1', '2019-02-13 09:56:12', '1', '66', '1', 'img/product/small/s20190429151401.jpg', '1', '23586', '0');

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
INSERT INTO `route_img` VALUES ('1', '1', 'img/product/size4/420190429134001.jpg', 'img/product/size2/220190429134001.jpg');
INSERT INTO `route_img` VALUES ('2', '1', 'img/product/size4/420190429132801.jpg', 'img/product/size2/220190429132801.jpg');
INSERT INTO `route_img` VALUES ('3', '1', 'img/product/size4/420190429133801.jpg', 'img/product/size2/220190429133801.jpg');
INSERT INTO `route_img` VALUES ('4', '1', 'img/product/size4/420190429134201.jpg', 'img/product/size2/220190429134201.jpg');
INSERT INTO `route_img` VALUES ('5', '2', 'img/product/size4/420190429142301.jpg', 'img/product/size2/220190429142301.jpg');
INSERT INTO `route_img` VALUES ('6', '2', 'img/product/size4/420190429142501.jpg', 'img/product/size2/220190429142501.jpg');
INSERT INTO `route_img` VALUES ('7', '2', 'img/product/size4/420190429142601.jpg', 'img/product/size2/220190429142601.jpg');
INSERT INTO `route_img` VALUES ('8', '2', 'img/product/size4/420190429142701.jpg', 'img/product/size2/220190429142701.jpg');
INSERT INTO `route_img` VALUES ('9', '3', 'img/product/size4/420190429144401.jpg', 'img/product/size2/220190429144401.jpg');
INSERT INTO `route_img` VALUES ('10', '3', 'img/product/size4/420190429144601.jpg', 'img/product/size2/220190429144601.jpg');
INSERT INTO `route_img` VALUES ('11', '3', 'img/product/size4/420190429144701.jpg', 'img/product/size2/220190429144701.jpg');
INSERT INTO `route_img` VALUES ('12', '3', 'img/product/size4/420190429144901.jpg', 'img/product/size2/220190429144901.jpg');
INSERT INTO `route_img` VALUES ('13', '4', 'img/product/size4/420190429151401.jpg', 'img/product/size2/220190429151401.jpg');
INSERT INTO `route_img` VALUES ('14', '4', 'img/product/size4/420190429151701.jpg', 'img/product/size2/220190429151701.jpg');
INSERT INTO `route_img` VALUES ('15', '4', 'img/product/size4/420190429151801.jpg', 'img/product/size2/220190429151801.jpg');
INSERT INTO `route_img` VALUES ('16', '4', 'img/product/size4/420190429152001.jpg', 'img/product/size2/220190429152001.jpg');

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
