DROP DATABASE IF EXISTS snack_user;

-- 创建库
create database snack_user default character set utf8 collate utf8_bin;

-- 切换库
use snack_user;

-- ----------------------------
-- Table structure for `memberinfo`
-- ----------------------------
DROP TABLE IF EXISTS `memberinfo`;
CREATE TABLE `memberinfo` (
  `mno` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(100) COLLATE utf8_bin NOT NULL,
  `realName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `photo` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `regDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`mno`),
  UNIQUE KEY `nickName` (`nickName`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of memberinfo
-- ----------------------------
INSERT INTO memberinfo VALUES ('1', 'navy', '', 'c8837b23ff8aaa8a2dde915473ce0991', '15096098010', '278224978@qq.com', '', '2020-05-16 15:32:15', '1');
INSERT INTO memberinfo VALUES ('2', '源辰', '', 'c8837b23ff8aaa8a2dde915473ce0991', '15096098011', '278224976@qq.com', '', '2020-05-19 16:48:16', '1');
INSERT INTO memberinfo VALUES ('3', 'yc', '', 'c8837b23ff8aaa8a2dde915473ce0991', '15096098012', '278224977@qq.com', '', '2020-05-19 16:48:49', '1');
INSERT INTO memberinfo VALUES ('5', '麦嘟', '', 'c8837b23ff8aaa8a2dde915473ce0991', '15096096666', '3081799657@qq.com', '', '2020-09-29 10:30:05', '1');

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `addrinfo`
-- ----------------------------
DROP TABLE IF EXISTS `addrinfo`;
CREATE TABLE `addrinfo` (
  `ano` varchar(100) COLLATE utf8_bin NOT NULL,
  `mno` int(11) DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin NOT NULL,
  `province` varchar(100) COLLATE utf8_bin NOT NULL,
  `city` varchar(100) COLLATE utf8_bin NOT NULL,
  `area` varchar(100) COLLATE utf8_bin NOT NULL,
  `addr` varchar(100) COLLATE utf8_bin NOT NULL,
  `flag` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ano`),
  KEY `FK_addrInfo_mno` (`mno`),
  CONSTRAINT `FK_addrInfo_mno` FOREIGN KEY (`mno`) REFERENCES `memberinfo` (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of addrinfo
-- ----------------------------
INSERT INTO addrinfo VALUES ('1590052579423', '1', '周海军', '15096098010', '湖南省', '衡阳市', '珠晖区', '美的梧桐庄园', '0', '1');
INSERT INTO addrinfo VALUES ('1590053041766', '1', '源辰', '15096098010', '湖南省', '衡阳市', '珠晖区', '衡花路18号湖南工学院', '1', '1');
INSERT INTO addrinfo VALUES ('1590053187661', '1', '周天', '1509608011', '湖南省', '衡阳市', '珠晖区', '南华大学', '0', '1');
