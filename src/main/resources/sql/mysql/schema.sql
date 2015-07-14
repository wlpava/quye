/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50509
Source Host           : localhost:3306
Source Database       : mdmplatform

Target Server Type    : MYSQL
Target Server Version : 50509
File Encoding         : 65001

Date: 2014-09-02 15:39:14
*/

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `mdmplatform`;
CREATE DATABASE `mdmplatform` DEFAULT CHARSET=utf8;
USE `mdmplatform`;

-- ----------------------------
-- Table structure for `app_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `os_type` tinyint(4) NOT NULL COMMENT 'OS类型：1-Android；2-IOS；3-WP',
  `app_id` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '应用ID',
  `app_name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '应用名称',
  `icon_small` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '应用小图标',
  `icon_big` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '应用大图标',
  `version` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '版本号',
  `icon_start_small` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '开机图片[小尺寸]',
  `icon_start_middle` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '开机图片[中尺寸]',
  `icon_start_big` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '开机图片[大尺寸]',
  `www_path` varchar(45) COLLATE utf8_bin NOT NULL COMMENT 'www.zip项目压缩包路径',
  `download_path` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '打包文件下载路径',
  `provision_path` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '[IOS]授权文件路径',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` tinyint(4) NOT NULL COMMENT '状态：1-打包成功；2-打包失败',
  `sys_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_app_info_sys_user_idx` (`sys_user_id`),
  CONSTRAINT `fk_app_info_sys_user` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='APP信息表';

-- ----------------------------
-- Records of app_info
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `code` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '代码',
  `value` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '值',
  `description` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '操作人',
  `operate_time` datetime NOT NULL COMMENT '操作时间',
  `operate` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '操作业务：login,logout,add,update,delete...',
  `source` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '操作来源',
  `description` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '具体描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `login_name` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '登录名',
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `salt` varchar(45) COLLATE utf8_bin NOT NULL,
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `status` int(11) NOT NULL COMMENT '状态：0-锁定；1-正常',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `login_ip` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '登录IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '超级管理员', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', null, null, '1', '2014-05-12 10:00:00', null, null);
