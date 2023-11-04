/*
 Navicat Premium Data Transfer

 Source Server         : javaweb
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : web-soft

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 04/11/2023 14:16:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `bid` int NOT NULL AUTO_INCREMENT,
  `bookImg` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `bookName` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `author` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `saleCount` int NULL DEFAULT NULL,
  `bookCount` int NULL DEFAULT NULL,
  `bookStatus` int NULL DEFAULT 0,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'cyuyanrumenjingdian.jpg', 'C语言入门经典', 99.00, '亚历山大', 8, 197, 0);
INSERT INTO `t_book` VALUES (2, 'santi.jpg', '三体', 48.95, '周杰伦', 18, 892, 0);
INSERT INTO `t_book` VALUES (3, 'ailuntulingzhuan.jpg', '艾伦图灵传', 50.00, '刘若英', 12, 143, 0);
INSERT INTO `t_book` VALUES (4, 'bainiangudu.jpg', '百年孤独', 40.00, '王力宏', 3, 98, 0);
INSERT INTO `t_book` VALUES (5, 'biancheng.jpg', '边城', 30.00, '刘德华', 2, 99, 0);
INSERT INTO `t_book` VALUES (6, 'jieyouzahuodian.jpg', '解忧杂货店', 27.00, '东野圭吾', 5, 100, 0);
INSERT INTO `t_book` VALUES (7, 'zhongguozhexueshi.jpg', '中国哲学史', 45.00, '冯友兰', 3, 100, 0);
INSERT INTO `t_book` VALUES (8, 'huranqiri.jpg', '忽然七日', 19.00, '劳伦', 50, 200, 0);
INSERT INTO `t_book` VALUES (9, 'sudongpozhuan.jpg', '苏东坡传', 20.00, '林语堂', 50, 300, 0);
INSERT INTO `t_book` VALUES (10, 'fusang.jpg', '扶桑', 20.00, '严歌岑', 10, 89, 0);
INSERT INTO `t_book` VALUES (11, 'geihaizideshi.jpg', '给孩子的诗', 23.00, '北岛', 5, 99, 0);

-- ----------------------------
-- Table structure for t_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `t_cart_item`;
CREATE TABLE `t_cart_item`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `book` int NULL DEFAULT NULL,
  `buyCount` int NULL DEFAULT NULL,
  `userBean` int NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `FK_cart_book`(`book` ASC) USING BTREE,
  INDEX `FK_cart_user`(`userBean` ASC) USING BTREE,
  CONSTRAINT `FK_cart_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_cart_user` FOREIGN KEY (`userBean`) REFERENCES `t_user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_cart_item
-- ----------------------------
INSERT INTO `t_cart_item` VALUES (45, 10, 2, 1);
INSERT INTO `t_cart_item` VALUES (46, 8, 1, 1);
INSERT INTO `t_cart_item` VALUES (47, 3, 1, 1);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `oid` int NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `orderDate` date NULL DEFAULT NULL,
  `orderUser` int NULL DEFAULT NULL,
  `orderMoney` double(10, 2) NULL DEFAULT NULL,
  `orderStatus` int NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `orderNo`(`orderNo` ASC) USING BTREE,
  INDEX `FK_order_user`(`orderUser` ASC) USING BTREE,
  CONSTRAINT `FK_order_user` FOREIGN KEY (`orderUser`) REFERENCES `t_user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (17, '506d9c96-9aa9-4728-bbb9-d6f212176a6d_123104234317', '2023-11-02', 1, 929.90, 0);
INSERT INTO `t_order` VALUES (18, 'ccc7a32d-e7aa-45d1-bf8d-82a069ffcca2_123104234415', '2023-11-02', 1, 929.90, 0);
INSERT INTO `t_order` VALUES (19, '67166ca0-b232-4ec9-92b8-ab247dcec058_123104234520', '2023-11-02', 1, 99.00, 0);
INSERT INTO `t_order` VALUES (20, '8235b143-554b-45fe-a025-ef1f14f54e8f_123102235234', '2023-11-02', 1, 99.00, 0);
INSERT INTO `t_order` VALUES (21, 'af95bb1a-df19-4d98-9e17-779443c1c120_1231030324', '2023-11-02', 1, 99.00, 0);
INSERT INTO `t_order` VALUES (22, 'cd0cad0e-ba0f-4840-9ba0-afb8ddb7889a_1231050634', '2023-11-02', 1, 48.95, 0);
INSERT INTO `t_order` VALUES (23, '0b4af366-fb54-4c3f-91b9-6d172258e96b_20231030106', '2023-11-02', 1, 48.95, 0);
INSERT INTO `t_order` VALUES (24, '8163c9f0-1132-482d-b021-4fa51ed84297_202311301139', '2023-11-02', 1, 50.00, 0);
INSERT INTO `t_order` VALUES (25, '1e402239-415e-4752-adeb-3d6352b3041c_202311301410', '2023-11-02', 1, 45.00, 0);
INSERT INTO `t_order` VALUES (26, 'eadb81c4-d745-4878-9197-4f5bf03551a1_202311302053', '2023-11-02', 1, 48.95, 0);
INSERT INTO `t_order` VALUES (27, '36483b2d-b0d5-4c59-b3a2-3dca7f9e7691_20231130216', '2023-11-02', 1, 99.00, 0);
INSERT INTO `t_order` VALUES (28, '4d16a368-75ef-46ef-aa77-d3d4baf19c39_2023104125915', '2023-11-04', 1, 19.00, 0);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `ooid` int NOT NULL AUTO_INCREMENT,
  `book` int NULL DEFAULT NULL,
  `buyCount` int NULL DEFAULT NULL,
  `orderBean` int NULL DEFAULT NULL,
  PRIMARY KEY (`ooid`) USING BTREE,
  INDEX `FK_detail_book`(`book` ASC) USING BTREE,
  INDEX `FK_detail_order`(`orderBean` ASC) USING BTREE,
  CONSTRAINT `FK_detail_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_detail_order` FOREIGN KEY (`orderBean`) REFERENCES `t_order` (`oid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (35, 1, 8, 17);
INSERT INTO `t_order_item` VALUES (36, 2, 2, 17);
INSERT INTO `t_order_item` VALUES (37, 4, 1, 17);
INSERT INTO `t_order_item` VALUES (38, 1, 8, 18);
INSERT INTO `t_order_item` VALUES (39, 2, 2, 18);
INSERT INTO `t_order_item` VALUES (40, 4, 1, 18);
INSERT INTO `t_order_item` VALUES (41, 1, 1, 19);
INSERT INTO `t_order_item` VALUES (42, 1, 1, 20);
INSERT INTO `t_order_item` VALUES (43, 1, 1, 21);
INSERT INTO `t_order_item` VALUES (44, 2, 1, 22);
INSERT INTO `t_order_item` VALUES (45, 2, 1, 23);
INSERT INTO `t_order_item` VALUES (46, 3, 1, 24);
INSERT INTO `t_order_item` VALUES (47, 7, 1, 25);
INSERT INTO `t_order_item` VALUES (48, 2, 1, 26);
INSERT INTO `t_order_item` VALUES (49, 1, 1, 27);
INSERT INTO `t_order_item` VALUES (50, 8, 1, 28);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `pwd` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `role` int NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'lina', 'ok', 'lina@sina.com.cn', 0);
INSERT INTO `t_user` VALUES (2, 'kate', 'ok', 'hello_kate@126.com', 1);
INSERT INTO `t_user` VALUES (3, '鸠摩智', 'ok', 'jiujiu@126.com', 0);
INSERT INTO `t_user` VALUES (4, '宝2021', 'ok', 'bao2021@sohu.com.cn', 0);
INSERT INTO `t_user` VALUES (5, '宝2022', '123', 'bao2022@sohu.com.cn', 0);

SET FOREIGN_KEY_CHECKS = 1;
