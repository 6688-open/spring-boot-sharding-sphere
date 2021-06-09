/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : ds_0001

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2021-06-09 16:08:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tab_user_001
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_001`;
CREATE TABLE `tab_user_001` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否删除 1删除 0未删除',
  `wb_no` varchar(64) DEFAULT NULL COMMENT '运单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_user_002
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_002`;
CREATE TABLE `tab_user_002` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否删除 1删除 0未删除',
  `wb_no` varchar(64) DEFAULT NULL COMMENT '运单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_user_003
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_003`;
CREATE TABLE `tab_user_003` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否删除 1删除 0未删除',
  `wb_no` varchar(64) DEFAULT NULL COMMENT '运单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_user_004
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_004`;
CREATE TABLE `tab_user_004` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否删除 1删除 0未删除',
  `wb_no` varchar(64) DEFAULT NULL COMMENT '运单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
