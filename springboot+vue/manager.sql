/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : manager

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-08-01 16:56:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组件名称',
  `name` varchar(255) NOT NULL COMMENT '菜单名称',
  `url` varchar(255) NOT NULL COMMENT '菜单url',
  `component` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL COMMENT '组件路径',
  `icon` varchar(255) NOT NULL COMMENT '菜单图标',
  `pid` int(11) NOT NULL COMMENT '父菜单ID',
  `status` int(255) NOT NULL COMMENT '菜单可用状态 1可用 0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户管理', '/', 'Index', '/index', 'a', '0', '1');
INSERT INTO `menu` VALUES ('2', '用户列表', '/user/list', 'UserList', '/user/userList', 'a', '1', '1');
INSERT INTO `menu` VALUES ('3', '系统管理', '/', 'Index', '/index', 'a', '0', '1');
INSERT INTO `menu` VALUES ('4', '日志管理', '/system/log', 'Log', '/system/log', 'a', '3', '1');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) NOT NULL COMMENT '真实姓名',
  `username` varchar(255) NOT NULL COMMENT '账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `user_status` int(1) NOT NULL DEFAULT '0' COMMENT '1正常，0禁用',
  `phone` varchar(11) NOT NULL,
  `address` varchar(255) NOT NULL COMMENT '地址',
  `head_img` varchar(255) NOT NULL COMMENT '头像地址',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', '金斌斌', 'admin', '7C4A8D09CA3762AF61E59520943DC26494F8941B', '1', '13333333333', 'dsc德威', '强无敌', '2018-07-23 15:37:57');
INSERT INTO `m_user` VALUES ('2', '测试', 'test', '7C4A8D09CA3762AF61E59520943DC26494F8941B', '1', '13333333333', 'dsc德威', '强无敌', '2018-07-23 15:37:57');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL COMMENT '权限名称',
  `role_name_cn` varchar(255) NOT NULL COMMENT '权限名称中文',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'test', '测试人员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '权限ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '1', '2');
INSERT INTO `role_menu` VALUES ('3', '1', '3');
INSERT INTO `role_menu` VALUES ('4', '1', '4');
INSERT INTO `role_menu` VALUES ('5', '2', '1');
INSERT INTO `role_menu` VALUES ('6', '2', '2');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
