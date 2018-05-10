/*
 Navicat Premium Data Transfer

 Source Server         : Mysql57_3357
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3357
 Source Schema         : jsp_demo

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 10/05/2018 19:56:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `publishHouse` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` int(5) NOT NULL,
  `nums` int(5) NOT NULL DEFAULT 1000,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'jsp应用开发详解', '小风', '电子工业出版社', 59, 400);
INSERT INTO `book` VALUES (2, 'JAVA WEB 开发', '小黄', '电子工业出版社', 43, 734);
INSERT INTO `book` VALUES (3, 'java 编程思想', '小花', '电子工业出版社', 120, 130);
INSERT INTO `book` VALUES (4, 'j2ee指南', '小王', '电子工业出版社', 65, 1320);
INSERT INTO `book` VALUES (5, 'ps教程', '小钱', '电子工业出版社', 44, 800);
INSERT INTO `book` VALUES (6, 'html基础', '小刘', '电子工业出版社', 38, 450);
INSERT INTO `book` VALUES (7, 'css拓展', '小青', '电子工业出版社', 75, 870);
INSERT INTO `book` VALUES (8, '深入jva虚拟机', '小吴', '电子工业出版社', 23, 870);
INSERT INTO `book` VALUES (9, '永远的js', '小贺', '电子工业出版社', 66, 480);

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ordersId` int(5) UNSIGNED NOT NULL,
  `bookId` int(5) UNSIGNED NOT NULL,
  `bookNum` int(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `orderId`(`ordersId`) USING BTREE,
  INDEX `bookId`(`bookId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userId` int(5) UNSIGNED NOT NULL,
  `totalPrice` decimal(5, 2) UNSIGNED NOT NULL DEFAULT 0.00,
  `orderDate` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grade` tinyint(2) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'test', '111', '110@qq.com', '110', 1);
INSERT INTO `users` VALUES (2, '宋江', '222', '111@qq.com', '111', 1);

SET FOREIGN_KEY_CHECKS = 1;
