/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2022-06-18 16:44:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_source
-- ----------------------------
DROP TABLE IF EXISTS `tb_source`;
CREATE TABLE `tb_source` (
  `sno` int(20) NOT NULL COMMENT '学号',
  `name` varchar(255) DEFAULT '' COMMENT '姓名',
  `classz` varchar(255) DEFAULT '' COMMENT '班级',
  `chinese` int(20) DEFAULT NULL COMMENT '语文',
  `math` int(20) DEFAULT NULL,
  `english` int(20) DEFAULT NULL,
  `physics` int(20) DEFAULT NULL,
  `chemistry` int(20) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tb_source
-- ----------------------------
INSERT INTO `tb_source` VALUES ('1', '你好', '你好', '1', '1', '1', '1', '1');
INSERT INTO `tb_source` VALUES ('102', '李明', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('103', '立碑', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('104', '刘备', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('110', '杨帨', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('111', '秦始皇', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('112', '李世民', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('113', '赵盼儿', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('114', '故遣军', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('115', '宋引章', '软件A2004班', '100', '100', '100', '100', '100');
INSERT INTO `tb_source` VALUES ('116', '皇太明', '软件A2004班', '100', '100', '100', '100', '100');

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `sno` int(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('101', '101', '杨森喜', '老师');
INSERT INTO `tb_users` VALUES ('102', '102', '李明', '学生');
INSERT INTO `tb_users` VALUES ('103', '103', '立碑', '学生');
INSERT INTO `tb_users` VALUES ('104', '104', '刘备', '学生');
INSERT INTO `tb_users` VALUES ('105', '105', '项羽', '学生');
INSERT INTO `tb_users` VALUES ('106', '106', '诸葛亮', '学生');
INSERT INTO `tb_users` VALUES ('107', '107', '关羽', '学生');
INSERT INTO `tb_users` VALUES ('108', '108', '河童', '学生');
INSERT INTO `tb_users` VALUES ('109', '109', '郑州', '学生');
INSERT INTO `tb_users` VALUES ('110', '110', '杨锐', '学生');
INSERT INTO `tb_users` VALUES ('111', '111', '秦始皇', '学生');
INSERT INTO `tb_users` VALUES ('112', '112', '李世民', '学生');
INSERT INTO `tb_users` VALUES ('113', '113', '赵盼儿', '学生');
INSERT INTO `tb_users` VALUES ('114', '114', '故遣军', '学生');
INSERT INTO `tb_users` VALUES ('115', '115', '宋引章', '学生');
INSERT INTO `tb_users` VALUES ('116', '116', '皇太明', '学生');
