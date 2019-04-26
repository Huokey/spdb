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