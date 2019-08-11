/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : db_nb

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2019-07-28 22:44:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_api_method
-- ----------------------------
DROP TABLE IF EXISTS `tb_api_method`;
CREATE TABLE `tb_api_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `method` int(11) DEFAULT NULL COMMENT '方法',
  `is_login` tinyint(4) DEFAULT NULL COMMENT '黑名单标识:0-黑白名单;1-黑名单;2-白名单',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_api_method` (`method`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_api_method
-- ----------------------------
INSERT INTO `tb_api_method` VALUES ('1', '10020101', '1');
INSERT INTO `tb_api_method` VALUES ('2', '10130101', '2');

-- ----------------------------
-- Table structure for tb_demo
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo`;
CREATE TABLE `tb_demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_demo
-- ----------------------------
INSERT INTO `tb_demo` VALUES ('1', 'NBjava', '26', '1', '信阳潢川县破石磙');
INSERT INTO `tb_demo` VALUES ('2', 'LHY', '21', '1', '圈刘村');
INSERT INTO `tb_demo` VALUES ('3', 'QiuFeng', '18', '0', '南阳新野小山村');

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES ('1', 'aaa', '123');
INSERT INTO `tb_member` VALUES ('2', 'bbb', null);
INSERT INTO `tb_member` VALUES ('3', 'ccc', null);

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增长 ',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `access_token` varchar(50) DEFAULT NULL COMMENT 'Token/索引 ',
  `app_secret` varchar(50) DEFAULT NULL COMMENT '密钥 ',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间 ',
  `expire_time` datetime DEFAULT NULL COMMENT '有效期至 ',
  `client_ip` varchar(20) DEFAULT NULL COMMENT '客户端IP ',
  `client_type` varchar(20) DEFAULT NULL COMMENT '客户端类别 ',
  `e_code` varchar(50) DEFAULT NULL COMMENT '设备标识 ',
  `u_code` varchar(50) DEFAULT NULL COMMENT '设备用户标识',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_token` (`access_token`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_token
-- ----------------------------
INSERT INTO `tb_token` VALUES ('1', '1', '75930017-cf91-4fb7-8648-e3ae142da7ac', '24b746a0-6f7c-4f57-bb4c-a6247ffade05', '2019-07-26 03:25:35', '2019-08-25 03:25:35', '127.0.0.1', 'PC', 'xxxx', 'xasd');
