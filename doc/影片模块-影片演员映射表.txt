-- ----------------------------
-- Table structure for mooc_film_actor_t
-- ----------------------------
DROP TABLE IF EXISTS `mooc_film_actor_t`;
CREATE TABLE mooc_film_actor_t(
  UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
  film_id INT COMMENT '影片编号,对应mooc_film_t',
  actor_id INT COMMENT '演员编号,对应mooc_actor_t',
  role_name VARCHAR(100) COMMENT '角色名称'
) COMMENT '影片与演员映射表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of mooc_film_actor_t
-- ----------------------------
INSERT INTO mooc_film_actor_t(UUID,film_id,actor_id,role_name)
	values(1,2,1,'演员1');
INSERT INTO mooc_film_actor_t(UUID,film_id,actor_id,role_name)
	values(2,2,2,'演员2');
INSERT INTO mooc_film_actor_t(UUID,film_id,actor_id,role_name)
	values(3,2,3,'演员3');
INSERT INTO mooc_film_actor_t(UUID,film_id,actor_id,role_name)
	values(4,2,4,'演员4');