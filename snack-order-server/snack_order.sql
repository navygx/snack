DROP DATABASE IF EXISTS snack_order;

-- 创建库
create database snack_order default character set utf8 collate utf8_bin;

-- 切换库
use snack_order;

-- ----------------------------
-- Table structure for `orderinfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `ono` varchar(100) COLLATE utf8_bin NOT NULL,
  `odate` datetime DEFAULT NULL COMMENT '下单日期',
  `mno` int(11) DEFAULT NULL COMMENT '会员编号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '收货人姓名',
  `tel` varchar(15) COLLATE utf8_bin NOT NULL COMMENT '收货人电话',
  `province` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '省份',
  `city` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '城市',
  `area` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '地区',
  `addr` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '详细地址',
  `sdate` datetime DEFAULT NULL COMMENT '发货日期',
  `rdate` datetime DEFAULT NULL COMMENT '收货日期',
  `status` int(11) DEFAULT NULL COMMENT '订单状态',
  `price` decimal(10,2) DEFAULT NULL COMMENT '订单总价',
  `invoice` int(11) DEFAULT NULL COMMENT '是否已开发票',
  PRIMARY KEY (`ono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for `orderiteminfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderiteminfo`;
CREATE TABLE `orderiteminfo` (
  `ino` int(11) NOT NULL AUTO_INCREMENT,
  `ono` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '订单编号',
  `gno` int(11) DEFAULT NULL  COMMENT '商品编号',
  `nums` int(11) DEFAULT NULL  COMMENT '购买数量',
  `price` decimal(8,2) DEFAULT NULL COMMENT '购买价格',
  `gname` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  `pic` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片',
  `weight` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '净重',
  `unit` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '单位',
  `intro` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '简介',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ino`),
  KEY `FK_orderItemInfo_ono` (`ono`),
  CONSTRAINT `FK_orderItemInfo_ono` FOREIGN KEY (`ono`) REFERENCES `orderinfo` (`ono`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
