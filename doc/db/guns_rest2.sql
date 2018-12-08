/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : guns_rest

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 15/10/2018 17:17:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mooc_actor_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_actor_t`;
CREATE TABLE `mooc_actor_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `actor_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演员名称',
  `actor_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演员图片位置',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '演员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_actor_t
-- ----------------------------
INSERT INTO `mooc_actor_t` VALUES (1, '徐峥', 'actors/2b98c9d2e6d23a7eff25dcac8b584b0136045.jpg');
INSERT INTO `mooc_actor_t` VALUES (2, '王传君', 'actors/b782d497577baffb5ed14de52841dcb164365.jpg');
INSERT INTO `mooc_actor_t` VALUES (3, '谭卓', 'actors/acf7db57456cb1aed1a42f7ebffedaa842002.jpg');
INSERT INTO `mooc_actor_t` VALUES (4, '黄渤', 'actors/c6594ef2705dcaf7d9df857d228b5e1645712.jpg');
INSERT INTO `mooc_actor_t` VALUES (5, '舒淇', 'actors/6b32a489467283bb739a2bac3b2b929742175.jpg');
INSERT INTO `mooc_actor_t` VALUES (6, '张艺兴', 'actors/b738d5e78a1f5c3379d9d42a9b18286f32246.jpeg');
INSERT INTO `mooc_actor_t` VALUES (7, '强森', 'actors/7e3067d066c1e285b0cc17bfd5f1b34e108474.jpg');
INSERT INTO `mooc_actor_t` VALUES (8, '杰森·斯坦森', 'actors/7ec0c90aec03c7904c1db3af1153162f77864.jpg');
INSERT INTO `mooc_actor_t` VALUES (9, '李冰冰', 'actors/d2258cd0529950cf5099206519d91d0e51803.jpg');
INSERT INTO `mooc_actor_t` VALUES (10, '汤姆·克鲁斯', 'actors/6afaea1cb4ca2b346e86e265347c78b833970.jpg');

-- ----------------------------
-- Table structure for mooc_banner_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_banner_t`;
CREATE TABLE `mooc_banner_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `banner_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'banner图存放路径',
  `banner_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'banner点击跳转url',
  `is_valid` int(11) NULL DEFAULT 0 COMMENT '是否弃用 0-失效,1-失效',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'banner信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_banner_t
-- ----------------------------
INSERT INTO `mooc_banner_t` VALUES (2, 'banners/9d75708ae91d5fc918369b76e9e2edba197666.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `mooc_banner_t` VALUES (3, 'banners/15b3730838f35d56a76d88a1787aaaa5186414.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `mooc_banner_t` VALUES (4, 'banners/51afa73f0347e9b98957c53fa971d41491652.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `mooc_banner_t` VALUES (5, 'banners/6605d3518e2bba10f29a6f9ae32b361987015.jpg', 'www.meetingshop.cn', 0);
INSERT INTO `mooc_banner_t` VALUES (6, 'banners/c1a713981cabef02c88ae5f42888de70183835.jpg', 'www.meetingshop.cn', 0);

-- ----------------------------
-- Table structure for mooc_cat_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_cat_dict_t`;
CREATE TABLE `mooc_cat_dict_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `show_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示名称',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类型信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_cat_dict_t
-- ----------------------------
INSERT INTO `mooc_cat_dict_t` VALUES (1, '爱情');
INSERT INTO `mooc_cat_dict_t` VALUES (2, '喜剧');
INSERT INTO `mooc_cat_dict_t` VALUES (3, '动画');
INSERT INTO `mooc_cat_dict_t` VALUES (4, '剧情');
INSERT INTO `mooc_cat_dict_t` VALUES (5, '恐怖');
INSERT INTO `mooc_cat_dict_t` VALUES (6, '惊悚');
INSERT INTO `mooc_cat_dict_t` VALUES (7, '科幻');
INSERT INTO `mooc_cat_dict_t` VALUES (8, '动作');
INSERT INTO `mooc_cat_dict_t` VALUES (9, '悬疑');
INSERT INTO `mooc_cat_dict_t` VALUES (10, '犯罪');
INSERT INTO `mooc_cat_dict_t` VALUES (11, '冒险');
INSERT INTO `mooc_cat_dict_t` VALUES (12, '战争');
INSERT INTO `mooc_cat_dict_t` VALUES (13, '奇幻');
INSERT INTO `mooc_cat_dict_t` VALUES (14, '运动');
INSERT INTO `mooc_cat_dict_t` VALUES (15, '家庭');
INSERT INTO `mooc_cat_dict_t` VALUES (16, '古装');
INSERT INTO `mooc_cat_dict_t` VALUES (17, '武侠');
INSERT INTO `mooc_cat_dict_t` VALUES (18, '西部');
INSERT INTO `mooc_cat_dict_t` VALUES (19, '历史');
INSERT INTO `mooc_cat_dict_t` VALUES (20, '传记');
INSERT INTO `mooc_cat_dict_t` VALUES (21, '歌舞');
INSERT INTO `mooc_cat_dict_t` VALUES (22, '短片');
INSERT INTO `mooc_cat_dict_t` VALUES (23, '纪录片');
INSERT INTO `mooc_cat_dict_t` VALUES (24, '黑色电影');
INSERT INTO `mooc_cat_dict_t` VALUES (99, '全部');

-- ----------------------------
-- Table structure for mooc_film_info_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_film_info_t`;
CREATE TABLE `mooc_film_info_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `film_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影片编号',
  `film_en_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影片英文名称',
  `film_score` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影片评分',
  `film_score_num` int(11) NULL DEFAULT NULL COMMENT '评分人数,以万为单位',
  `film_length` int(11) NULL DEFAULT NULL COMMENT '播放时长，以分钟为单位，不足取整',
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '影片介绍',
  `director_id` int(11) NULL DEFAULT NULL COMMENT '导演编号',
  `film_imgs` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '影片图片集地址,多个图片以逗号分隔',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '影片主表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_film_info_t
-- ----------------------------
INSERT INTO `mooc_film_info_t` VALUES (2, '2', 'Dying To Survive', '9.7', 225, 117, '一位不速之客的意外到访，打破了神油店老板程勇（徐峥 饰）的平凡人生，他从一个交不起房租的男性保健品商贩，一跃成为印度仿制药“格列宁”的独家代理商。收获巨额利润的他，生活剧烈变化，被病患们冠以“药神”的称号。但是，一场关于救赎的拉锯战也在波涛暗涌中慢慢展开......', 1, 'films/3065271341357040f5f5dd988550951e586199.jpg,films/6b2b3fd6260ac37e5ad44d00ea474ea3651419.jpg,films/4633dd44c51ff15fc7e939679d7cdb67561602.jpg,films/df2d30b1a3bd58fb1d38b978662ae844648169.jpg,films/c845f6b04aa49059951fd55e6b0eddac454036.jpg');

-- ----------------------------
-- Table structure for mooc_film_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_film_t`;
CREATE TABLE `mooc_film_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `film_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影片名称',
  `film_type` int(11) NULL DEFAULT NULL COMMENT '片源类型: 0-2D,1-3D,2-3DIMAX,4-无',
  `img_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影片主图地址',
  `film_score` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影片评分',
  `film_preSaleNum` int(11) NULL DEFAULT NULL COMMENT '影片预售数量',
  `film_box_office` int(11) NULL DEFAULT NULL COMMENT '影片票房：每日更新，以万为单位',
  `film_source` int(11) NULL DEFAULT NULL COMMENT '影片片源，参照片源字典表',
  `film_cats` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影片分类，参照分类表,多个分类以#分割',
  `film_area` int(11) NULL DEFAULT NULL COMMENT '影片区域，参照区域表',
  `film_date` int(11) NULL DEFAULT NULL COMMENT '影片上映年代，参照年代表',
  `film_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '影片上映时间',
  `film_status` int(11) NULL DEFAULT NULL COMMENT '影片状态,1-正在热映，2-即将上映，3-经典影片',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '影片主表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_film_t
-- ----------------------------
INSERT INTO `mooc_film_t` VALUES (2, '我不是药神', 0, 'films/238e2dc36beae55a71cabfc14069fe78236351.jpg', '9.7', 231432491, 309600, 1, '#2#4#22#', 1, 13, '2018-07-05 00:00:00', 1);

-- ----------------------------
-- Table structure for mooc_source_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_source_dict_t`;
CREATE TABLE `mooc_source_dict_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `show_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示名称',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '区域信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_source_dict_t
-- ----------------------------
INSERT INTO `mooc_source_dict_t` VALUES (1, '大陆');
INSERT INTO `mooc_source_dict_t` VALUES (2, '美国');
INSERT INTO `mooc_source_dict_t` VALUES (3, '韩国');
INSERT INTO `mooc_source_dict_t` VALUES (4, '日本');
INSERT INTO `mooc_source_dict_t` VALUES (5, '中国香港');
INSERT INTO `mooc_source_dict_t` VALUES (6, '中国台湾');
INSERT INTO `mooc_source_dict_t` VALUES (7, '印度');
INSERT INTO `mooc_source_dict_t` VALUES (8, '法国');
INSERT INTO `mooc_source_dict_t` VALUES (9, '英国');
INSERT INTO `mooc_source_dict_t` VALUES (10, '俄罗斯');
INSERT INTO `mooc_source_dict_t` VALUES (11, '意大利');
INSERT INTO `mooc_source_dict_t` VALUES (12, '西班牙');
INSERT INTO `mooc_source_dict_t` VALUES (13, '德国');
INSERT INTO `mooc_source_dict_t` VALUES (14, '波兰');
INSERT INTO `mooc_source_dict_t` VALUES (15, '澳大利亚');
INSERT INTO `mooc_source_dict_t` VALUES (16, '伊朗');
INSERT INTO `mooc_source_dict_t` VALUES (99, '全部');

-- ----------------------------
-- Table structure for mooc_user_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_user_t`;
CREATE TABLE `mooc_user_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_sex` int(11) NULL DEFAULT NULL COMMENT '用户性别 0-男，1-女',
  `birthday` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户住址',
  `head_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像URL',
  `biography` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `life_state` int(11) NULL DEFAULT NULL COMMENT '生活状态 0-单身，1-热恋中，2-已婚，3-为人父母',
  `begin_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_user_t
-- ----------------------------
INSERT INTO `mooc_user_t` VALUES (2, 'admin', '0192023a7bbd73250516f069df18b500', '慕课', 1, '2018-5-8', '86571972@qq.com', '1306319505', '北京', 'films/img/head-img.jpg', '个人介绍', 2, '2018-10-12 09:14:15', '2018-10-12 12:19:28');
INSERT INTO `mooc_user_t` VALUES (3, 'jiangzh', '5e2de6bd1c9b50f6e27d4e55da43b917', '阿里郎', 0, '2018-08-20', 'jiangzh@mooc.com', '13866666666', '北京市朝阳区大望路万达广场', 'films/img/head-img.jpg', '我喜欢隔壁泰山', 1, '2018-10-12 09:14:18', '2018-10-12 09:14:21');
INSERT INTO `mooc_user_t` VALUES (4, '123', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, '', '', '', NULL, NULL, NULL, '2018-10-12 12:06:48', '2018-10-12 12:06:50');
INSERT INTO `mooc_user_t` VALUES (5, '123', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, '86571972@qq.com', '1306319505', '北京', NULL, NULL, NULL, '2018-10-12 12:06:55', '2018-10-12 12:06:57');
INSERT INTO `mooc_user_t` VALUES (6, '12355', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, '86571972@qq.com', '1306319505', '福建北京', NULL, NULL, NULL, '0000-00-00 00:00:00', '2018-10-12 12:08:36');

-- ----------------------------
-- Table structure for mooc_year_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_year_dict_t`;
CREATE TABLE `mooc_year_dict_t`  (
  `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `show_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示名称',
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '年代信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mooc_year_dict_t
-- ----------------------------
INSERT INTO `mooc_year_dict_t` VALUES (1, '更早');
INSERT INTO `mooc_year_dict_t` VALUES (2, '70年代');
INSERT INTO `mooc_year_dict_t` VALUES (3, '80年代');
INSERT INTO `mooc_year_dict_t` VALUES (4, '90年代');
INSERT INTO `mooc_year_dict_t` VALUES (5, '2000-2010');
INSERT INTO `mooc_year_dict_t` VALUES (6, '2011');
INSERT INTO `mooc_year_dict_t` VALUES (7, '2012');
INSERT INTO `mooc_year_dict_t` VALUES (8, '2013');
INSERT INTO `mooc_year_dict_t` VALUES (9, '2014');
INSERT INTO `mooc_year_dict_t` VALUES (10, '2015');
INSERT INTO `mooc_year_dict_t` VALUES (11, '2016');
INSERT INTO `mooc_year_dict_t` VALUES (12, '2017');
INSERT INTO `mooc_year_dict_t` VALUES (13, '2018');
INSERT INTO `mooc_year_dict_t` VALUES (14, '2018以后');
INSERT INTO `mooc_year_dict_t` VALUES (99, '全部');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin');

SET FOREIGN_KEY_CHECKS = 1;
