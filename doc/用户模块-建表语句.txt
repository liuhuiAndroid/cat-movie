DROP TABLE IF EXISTS mooc_user_t;
CREATE TABLE mooc_user_t(
   UUID INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
   user_name VARCHAR(50) COMMENT '用户账号',
   user_pwd VARCHAR(50) COMMENT '用户密码',
   nick_name VARCHAR(50) COMMENT '用户昵称',
   user_sex INT COMMENT '用户性别 0-男，1-女',
   birthday VARCHAR(50) COMMENT '出生日期',
   email VARCHAR(50) COMMENT '用户邮箱',
   user_phone VARCHAR(50) COMMENT '用户手机号',
   address VARCHAR(50) COMMENT '用户住址',
   head_url VARCHAR(50) COMMENT '头像URL',
   biography VARCHAR(200) COMMENT '个人介绍',
   life_state INT COMMENT '生活状态 0-单身，1-热恋中，2-已婚，3-为人父母',
   begin_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '用户表' ENGINE = INNODB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

insert into mooc_user_t(user_name,user_pwd,nick_name,user_sex,birthday,email,user_phone,address,head_url,life_state,biography) values('admin','0192023a7bbd73250516f069df18b500','隔壁泰山',0,'2018-07-31','admin@mooc.com','13888888888','北京市海淀区朝阳北路中南海国宾馆','films/img/head-img.jpg',0,'没有合适的伞，我宁可淋着雨');
insert into mooc_user_t(user_name,user_pwd,nick_name,user_sex,birthday,email,user_phone,address,head_url,life_state,biography) values('jiangzh','5e2de6bd1c9b50f6e27d4e55da43b917','阿里郎',0,'2018-08-20','jiangzh@mooc.com','13866666666','北京市朝阳区大望路万达广场','films/img/head-img.jpg',1,'我喜欢隔壁泰山');

