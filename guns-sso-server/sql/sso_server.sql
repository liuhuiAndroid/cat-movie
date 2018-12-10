/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : sso_server

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 29/08/2018 16:28:41
*/
DROP DATABASE IF EXISTS sso_server;
CREATE DATABASE IF NOT EXISTS sso_server DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

use sso_server;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` int(11) NOT NULL COMMENT '主键id',
  `AVATAR` varchar(255) DEFAULT NULL COMMENT '头像',
  `ACCOUNT` varchar(45) DEFAULT NULL COMMENT '账号',
  `PASSWORD` varchar(45) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `NAME` varchar(45) DEFAULT NULL COMMENT '名字',
  `BIRTHDAY` datetime DEFAULT NULL COMMENT '生日',
  `SEX` char(1) DEFAULT NULL COMMENT '性别（M：男 F：女）',
  `EMAIL` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `PHONE` varchar(45) DEFAULT NULL COMMENT '电话',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user`(`USER_ID`, `AVATAR`, `ACCOUNT`, `PASSWORD`, `SALT`, `NAME`, `BIRTHDAY`, `SEX`, `EMAIL`, `PHONE`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) VALUES (1, 'xxx', 'admin', '5913e127660a9276fdac4079f19e5c98', '1gaf42', 'feng', '2018-08-26 15:12:16', 'M', 'qq.com', '18888888888', 1, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
