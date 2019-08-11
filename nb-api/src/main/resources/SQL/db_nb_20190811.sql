/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : db_nb

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2019-08-11 16:17:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for crc_project
-- ----------------------------
DROP TABLE IF EXISTS `crc_project`;
CREATE TABLE `crc_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `hospital_id` int(11) DEFAULT NULL COMMENT '医院id',
  `hospital_name` varchar(50) DEFAULT NULL COMMENT '医院名称',
  `sponsor_id` int(11) DEFAULT NULL COMMENT '申办方id',
  `sponsor_name` varchar(50) DEFAULT NULL COMMENT '申办方名称',
  `phase` tinyint(4) DEFAULT NULL COMMENT '几期1,2,3,4的',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名',
  `speciality_id` int(11) DEFAULT NULL COMMENT '专业Id(引用专业表)',
  `speciality_name` varchar(50) DEFAULT NULL COMMENT '专业名',
  `start_date` varchar(20) DEFAULT NULL COMMENT '项目开始时间',
  `end_date` varchar(20) DEFAULT NULL COMMENT '项目结束时间',
  `state` tinyint(4) DEFAULT NULL COMMENT '项目状态1进行中2已完成',
  `manager_id` int(11) DEFAULT NULL COMMENT '负责人id',
  `manager_name` varchar(20) DEFAULT NULL COMMENT '负责人姓名',
  `smo_id` int(11) DEFAULT NULL COMMENT 'smo_id',
  `smo_name` varchar(50) DEFAULT NULL COMMENT 'smo_name',
  `smo_province` varchar(20) DEFAULT NULL COMMENT 'smo所在省份',
  `smo_city` varchar(20) DEFAULT NULL COMMENT 'smo所在城市',
  `is_confirm` tinyint(4) DEFAULT NULL COMMENT '是否确认0否1是',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` int(11) DEFAULT NULL COMMENT '修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` tinyint(4) DEFAULT '0' COMMENT '是否删除0否1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='试验项目表';

-- ----------------------------
-- Records of crc_project
-- ----------------------------
INSERT INTO `crc_project` VALUES ('1', '5', '阜外医院', '4', '福森药业', '1', '黄连上清片I期临床试验', null, null, '2019-06-19', null, null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `crc_project` VALUES ('2', '5', '阜外医院', '4', '福森药业', '1', '三黄片片片I期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '1', '2', '2019-05-16 17:11:36', null, '2019-06-20 17:32:19', '1');
INSERT INTO `crc_project` VALUES ('3', '5', '阜外医院', '4', '福森药业', '1', '感冒痛I期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '1', '2', '2019-05-18 17:12:42', null, '2019-06-21 15:00:36', '0');
INSERT INTO `crc_project` VALUES ('4', '5', '阜外医院', '4', '福森药业', '1', '双黄连I期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '1', '2', '2019-05-30 17:12:54', null, null, '0');
INSERT INTO `crc_project` VALUES ('5', '5', '阜外医院', '4', '福森药业', '1', '风油精I期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-01 17:13:06', null, null, '0');
INSERT INTO `crc_project` VALUES ('6', '5', '阜外医院', '4', '福森药业', '1', '风油精2期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-02 17:13:12', null, null, '0');
INSERT INTO `crc_project` VALUES ('7', '5', '阜外医院', '4', '福森药业', '1', '小行星2期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-12 17:13:19', null, null, '0');
INSERT INTO `crc_project` VALUES ('8', '5', '阜外医院', '4', '福森药业', '1', '发烧药2期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-15 17:13:34', null, null, '0');
INSERT INTO `crc_project` VALUES ('9', '5', '阜外医院', '4', '福森药业', '1', '发烧药1期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-16 17:13:37', null, null, '0');
INSERT INTO `crc_project` VALUES ('10', '5', '阜外医院', '4', '福森药业', '1', '感康1期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-17 17:14:01', null, null, '0');
INSERT INTO `crc_project` VALUES ('11', '5', '阜外医院', '4', '福森药业', '1', '咳嗽药I期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-18 17:14:15', null, null, '0');
INSERT INTO `crc_project` VALUES ('12', '5', '阜外医院', '4', '福森药业', '1', '咳嗽糖浆I期等效性试验', '3', '变态反应', '2019-06-20', null, '1', '2', '机构管理员', '6', '中兴正远', '北京市', '北京市', '0', '2', '2019-06-20 17:14:24', null, null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES ('1', 'aaa', '123');

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
INSERT INTO `tb_token` VALUES ('1', '1', '9007c19e-da96-4ddd-84d0-93c6eba22e68', 'af521f54-8bc0-4837-b1f4-3948f899d35f', '2019-08-10 11:35:14', '2019-09-20 11:35:14', '127.0.0.1', 'APP', 'xxxx', 'xasd');
