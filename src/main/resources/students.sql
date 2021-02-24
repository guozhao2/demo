DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `stu_name` varchar(20) NOT NULL ,
    `stu_sex` varchar(10)  NOT NULL ,
    `class_id` int(10)  NOT NULL ,
    `age` int(10) NOT NULL  DEFAULT 18,
    `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

insert into students (stu_name,stu_sex,class_id,age) values
('张三','男',1001,18),
('王晓红','女',2001,20),
('李清乐','男',1001,23),
('赵倚天','男',3001,23);