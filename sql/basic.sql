/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 101.37.83.15:49700
 Source Schema         : basic

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 29/05/2020 11:14:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`          bigint(0)                                              NOT NULL COMMENT 'id',
    `parent_id`   bigint(0)                                              NULL DEFAULT NULL COMMENT '上级id',
    `name`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名',
    `sort`        int(0)                                                 NULL DEFAULT NULL COMMENT '排序',
    `status`      tinyint(0)                                             NOT NULL COMMENT '状态  0：停用   1：正常',
    `creator`     bigint(0)                                              NULL DEFAULT NULL COMMENT '创建者',
    `create_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint(0)                                              NULL DEFAULT NULL COMMENT '更新者',
    `update_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `name` (`name`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '部门'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`          bigint(0)                                              NOT NULL COMMENT 'id',
    `name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
    `type`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型',
    `value`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典值',
    `status`      tinyint(0)                                             NOT NULL COMMENT '状态  0：停用   1：正常',
    `creator`     bigint(0)                                              NULL DEFAULT NULL COMMENT '创建者',
    `create_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint(0)                                              NULL DEFAULT NULL COMMENT '更新者',
    `update_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '字典表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`
(
    `id`          bigint(0)                                                NOT NULL COMMENT 'id',
    `name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '权限名',
    `url`         varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址',
    `type`        int(0)                                                   NOT NULL COMMENT '权限类型，页面:1，按钮:2',
    `permissions` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '权限表达式',
    `method`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '后端接口访问方式',
    `sort`        int(0)                                                   NULL DEFAULT NULL COMMENT '排序',
    `creator`     bigint(0)                                                NULL DEFAULT NULL COMMENT '创建者',
    `create_time` datetime(0)                                              NULL DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint(0)                                                NULL DEFAULT NULL COMMENT '更新者',
    `update_time` datetime(0)                                              NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '权限'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(0)                                              NOT NULL COMMENT 'id',
    `name`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
    `status`      tinyint(0)                                             NOT NULL COMMENT '状态  0：停用   1：正常',
    `dept_id`     bigint(0)                                              NOT NULL COMMENT '部门id',
    `creator`     bigint(0)                                              NULL DEFAULT NULL COMMENT '创建者',
    `create_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint(0)                                              NULL DEFAULT NULL COMMENT '更新者',
    `update_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `name` (`name`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`
(
    `id`          bigint(0)   NOT NULL COMMENT 'id',
    `role_id`     bigint(0)   NOT NULL COMMENT 'role_id',
    `dept_id`     bigint(0)   NOT NULL COMMENT 'dept_id',
    `creator`     bigint(0)   NULL DEFAULT NULL COMMENT '创建者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色-部门表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`
(
    `id`            bigint(0)   NOT NULL COMMENT 'id',
    `role_id`       bigint(0)   NOT NULL COMMENT 'role_id',
    `permission_id` bigint(0)   NOT NULL COMMENT 'permission_id',
    `creator`       bigint(0)   NULL DEFAULT NULL COMMENT '创建者',
    `create_time`   datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色-权限表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(0)                                               NOT NULL COMMENT 'id',
    `user_name`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '账户名',
    `real_name`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '真实姓名',
    `password`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
    `head_url`    varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `gender`      tinyint(0)                                              NULL DEFAULT NULL COMMENT '1：男0：女',
    `phone`       varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '手机号',
    `mail`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `status`      tinyint(0)                                              NOT NULL COMMENT '状态  0：停用   1：正常',
    `dept_id`     bigint(0)                                               NOT NULL COMMENT '部门id',
    `creator`     bigint(0)                                               NULL DEFAULT NULL COMMENT '创建者',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `updater`     bigint(0)                                               NULL DEFAULT NULL COMMENT '更新者',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `user_name` (`user_name`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`          bigint(0)   NOT NULL COMMENT 'id',
    `user_id`     bigint(0)   NOT NULL COMMENT 'user_id',
    `role_id`     bigint(0)   NOT NULL COMMENT 'role_id',
    `creator`     bigint(0)   NULL DEFAULT NULL COMMENT '创建者',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户-角色表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
