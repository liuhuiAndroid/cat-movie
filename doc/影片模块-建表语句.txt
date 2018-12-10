-- ----------------------------
-- Table structure for mooc_banner_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_banner_t`;
CREATE TABLE mooc_banner_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  banner_address VARCHAR(50) COMMENT 'banner图存放路径',
  banner_url VARCHAR(200) COMMENT 'banner点击跳转url',
  is_valid INT DEFAULT 0 COMMENT '是否弃用 0-失效,1-失效'
) COMMENT 'banner信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_banner_t
-- ----------------------------
INSERT INTO mooc_banner_t(banner_address,banner_url) VALUES('banners/9d75708ae91d5fc918369b76e9e2edba197666.jpg','www.meetingshop.cn');
INSERT INTO mooc_banner_t(banner_address,banner_url) VALUES('banners/15b3730838f35d56a76d88a1787aaaa5186414.jpg','www.meetingshop.cn');
INSERT INTO mooc_banner_t(banner_address,banner_url) VALUES('banners/51afa73f0347e9b98957c53fa971d41491652.jpg','www.meetingshop.cn');
INSERT INTO mooc_banner_t(banner_address,banner_url) VALUES('banners/6605d3518e2bba10f29a6f9ae32b361987015.jpg','www.meetingshop.cn');
INSERT INTO mooc_banner_t(banner_address,banner_url) VALUES('banners/c1a713981cabef02c88ae5f42888de70183835.jpg','www.meetingshop.cn');



-- ----------------------------
-- Table structure for mooc_cat_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_cat_dict_t`;
CREATE TABLE mooc_cat_dict_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  show_name VARCHAR(100) COMMENT '显示名称'
) COMMENT '类型信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_cat_dict_t
-- ----------------------------
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(99,'全部');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(1,'爱情');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(2,'喜剧');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(3,'动画');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(4,'剧情');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(5,'恐怖');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(6,'惊悚');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(7,'科幻');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(8,'动作');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(9,'悬疑');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(10,'犯罪');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(11,'冒险');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(12,'战争');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(13,'奇幻');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(14,'运动');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(15,'家庭');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(16,'古装');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(17,'武侠');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(18,'西部');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(19,'历史');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(20,'传记');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(21,'歌舞');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(22,'短片');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(23,'纪录片');
INSERT INTO mooc_cat_dict_t(uuid,show_name) values(24,'黑色电影');





-- ----------------------------
-- Table structure for mooc_source_dict_t
-- ----------------------------
DROP TABLE IF EXISTS mooc_source_dict_t;
CREATE TABLE mooc_source_dict_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  show_name VARCHAR(100) COMMENT '显示名称'
) COMMENT '区域信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_source_dict_t
-- ----------------------------
INSERT INTO mooc_source_dict_t(uuid,show_name) values(99,'全部');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(1,'大陆');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(2,'美国');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(3,'韩国');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(4,'日本');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(5,'中国香港');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(6,'中国台湾');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(7,'印度');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(8,'法国');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(9,'英国');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(10,'俄罗斯');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(11,'意大利');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(12,'西班牙');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(13,'德国');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(14,'波兰');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(15,'澳大利亚');
INSERT INTO mooc_source_dict_t(uuid,show_name) values(16,'伊朗');


-- ----------------------------
-- Table structure for mooc_year_dict_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_year_dict_t`;
CREATE TABLE mooc_year_dict_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  show_name VARCHAR(100) COMMENT '显示名称'
) COMMENT '年代信息表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_year_dict_t
-- ----------------------------
INSERT INTO mooc_year_dict_t(uuid,show_name) values(99,'全部');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(1,'更早');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(2,'70年代');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(3,'80年代');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(4,'90年代');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(5,'2000-2010');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(6,'2011');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(7,'2012');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(8,'2013');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(9,'2014');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(10,'2015');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(11,'2016');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(12,'2017');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(13,'2018');
INSERT INTO mooc_year_dict_t(uuid,show_name) values(14,'2018以后');



-- ----------------------------
-- Table structure for mooc_film_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_film_t`;
CREATE TABLE mooc_film_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  film_name VARCHAR(100) COMMENT '影片名称',
  film_type INT COMMENT '片源类型: 0-2D,1-3D,2-3DIMAX,4-无',
  img_address VARCHAR(200) COMMENT '影片主图地址',
  film_score VARCHAR(20) COMMENT '影片评分',
  film_preSaleNum INT COMMENT '影片预售数量',
  film_box_office INT COMMENT '影片票房：每日更新，以万为单位',
  film_source INT COMMENT '影片片源，参照片源字典表',
  film_cats VARCHAR(50) COMMENT '影片分类，参照分类表,多个分类以#分割',
  film_area INT COMMENT '影片区域，参照区域表',
  film_date INT COMMENT '影片上映年代，参照年代表',
  film_time TIMESTAMP COMMENT '影片上映时间',
  film_status INT COMMENT '影片状态,1-正在热映，2-即将上映，3-经典影片'
) COMMENT '影片主表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_film_t
-- ----------------------------
INSERT INTO mooc_film_t(uuid,film_name,film_source,film_type,film_cats,film_area,film_date,film_time,film_preSaleNum,film_box_office,film_score,film_status,img_address)
			values(2,'我不是药神',1,0,'#2#4#22#',1,13,'2018-07-05',231432491,309600,'9.7',1,'films/238e2dc36beae55a71cabfc14069fe78236351.jpg');



-- ----------------------------
-- Table structure for mooc_film_info_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_film_info_t`;
CREATE TABLE mooc_film_info_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  film_id VARCHAR(100) COMMENT '影片编号',
  film_en_name VARCHAR(50) COMMENT '影片英文名称',
  film_score VARCHAR(20) COMMENT '影片评分',
  film_score_num INT COMMENT '评分人数,以万为单位',
  film_length INT COMMENT '播放时长，以分钟为单位，不足取整',
  biography TEXT COMMENT '影片介绍',
  director_id INT COMMENT '导演编号',
  film_imgs TEXT COMMENT '影片图片集地址,多个图片以逗号分隔'
) COMMENT '影片主表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_film_info_t
-- ----------------------------
INSERT INTO mooc_film_info_t(film_id,film_en_name,film_score,film_score_num,film_length,director_id,film_imgs,biography)
	values(2,'Dying To Survive','9.7',225,117,1,
		'films/3065271341357040f5f5dd988550951e586199.jpg,films/6b2b3fd6260ac37e5ad44d00ea474ea3651419.jpg,films/4633dd44c51ff15fc7e939679d7cdb67561602.jpg,films/df2d30b1a3bd58fb1d38b978662ae844648169.jpg,films/c845f6b04aa49059951fd55e6b0eddac454036.jpg',
		'一位不速之客的意外到访，打破了神油店老板程勇（徐峥 饰）的平凡人生，他从一个交不起房租的男性保健品商贩，一跃成为印度仿制药“格列宁”的独家代理商。收获巨额利润的他，生活剧烈变化，被病患们冠以“药神”的称号。但是，一场关于救赎的拉锯战也在波涛暗涌中慢慢展开......'
	);


-- ----------------------------
-- Table structure for mooc_actor_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_actor_t`;
CREATE TABLE mooc_actor_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  actor_name VARCHAR(50) COMMENT '演员名称',
  actor_img  VARCHAR(200) COMMENT '演员图片位置'
) COMMENT '演员表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_actor_t
-- ----------------------------
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(1,'徐峥','actors/2b98c9d2e6d23a7eff25dcac8b584b0136045.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(2,'王传君','actors/b782d497577baffb5ed14de52841dcb164365.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(3,'谭卓','actors/acf7db57456cb1aed1a42f7ebffedaa842002.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(4,'黄渤','actors/c6594ef2705dcaf7d9df857d228b5e1645712.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(5,'舒淇','actors/6b32a489467283bb739a2bac3b2b929742175.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(6,'张艺兴','actors/b738d5e78a1f5c3379d9d42a9b18286f32246.jpeg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(7,'强森','actors/7e3067d066c1e285b0cc17bfd5f1b34e108474.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(8,'杰森·斯坦森','actors/7ec0c90aec03c7904c1db3af1153162f77864.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(9,'李冰冰','actors/d2258cd0529950cf5099206519d91d0e51803.jpg');
INSERT INTO mooc_actor_t(uuid,actor_name,actor_img) value(10,'汤姆·克鲁斯','actors/6afaea1cb4ca2b346e86e265347c78b833970.jpg');