# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 8.0.24)
# Database: covidmanagement
# Generation Time: 2021-05-24 13:03:23 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table arrive_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `arrive_info`;

CREATE TABLE `arrive_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '' COMMENT '身份证号',
  `departure_location` varchar(50) NOT NULL DEFAULT '' COMMENT '身份证号',
  `arrive_time` varchar(50) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `arrive_info` WRITE;
/*!40000 ALTER TABLE `arrive_info` DISABLE KEYS */;

INSERT INTO `arrive_info` (`id`, `identity_id`, `departure_location`, `arrive_time`, `update_time`, `create_time`)
VALUES
	(43,'372929199801166317','北京','2021-01-27','2021-05-16 21:11:06','2021-05-16 21:11:06'),
	(44,'372929199801166317','营口','2021-05-21','2021-05-21 15:03:38','2021-05-21 15:03:38');

/*!40000 ALTER TABLE `arrive_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table aus_specific
# ------------------------------------------------------------

DROP TABLE IF EXISTS `aus_specific`;

CREATE TABLE `aus_specific` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '' COMMENT '身份证号',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  `info` varchar(50) NOT NULL DEFAULT '' COMMENT ' 内容',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `aus_specific` WRITE;
/*!40000 ALTER TABLE `aus_specific` DISABLE KEYS */;

INSERT INTO `aus_specific` (`id`, `identity_id`, `operator`, `info`, `update_time`, `create_time`)
VALUES
	(42,'123','huangchengTest','huangchengTest发起了注册管理员权限申请。','2021-05-24 21:00:29','2021-05-24 21:00:29'),
	(43,'123','koutei','koutei审核通过','2021-05-24 21:01:22','2021-05-24 21:01:22');

/*!40000 ALTER TABLE `aus_specific` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table city_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `city_info`;

CREATE TABLE `city_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `province` varchar(50) NOT NULL DEFAULT '',
  `city` varchar(50) NOT NULL DEFAULT '',
  `district` varchar(50) NOT NULL DEFAULT '',
  `picurl` varchar(2083) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `city_info` WRITE;
/*!40000 ALTER TABLE `city_info` DISABLE KEYS */;

INSERT INTO `city_info` (`id`, `province`, `city`, `district`, `picurl`)
VALUES
	(1,'山东','济南市','历下区','http://localhost:8181/images/shandong.png'),
	(2,'北京','北京市','海淀区','http://localhost:8181/images/beijing.png'),
	(3,'北京','北京市','朝阳区','http://localhost:8181/images/beijing.png'),
	(4,'北京','北京市','平谷区','http://localhost:8181/images/beijing.png'),
	(5,'天津','','','http://localhost:8181/images/tianjin.png'),
	(6,'河北','','','http://localhost:8181/images/hebei.png'),
	(7,'山西','','','http://localhost:8181/images/shanxichencu.png'),
	(8,'辽宁','','','http://localhost:8181/images/liaoning.png'),
	(9,'上海','','','http://localhost:8181/images/shanghai.png'),
	(10,'江苏','','','http://localhost:8181/images/jiangsu.png'),
	(11,'浙江','','','http://localhost:8181/images/zhejiang.png'),
	(12,'安徽','','','http://localhost:8181/images/anhui.png'),
	(13,'福建','','','http://localhost:8181/images/fujian.png'),
	(14,'江西','','','http://localhost:8181/images/jiangxi.png'),
	(15,'山东','','','http://localhost:8181/images/shandong.png'),
	(16,'河南','','','http://localhost:8181/images/henan.png'),
	(17,'湖北','','','http://localhost:8181/images/hubei.png'),
	(18,'湖南','','','http://localhost:8181/images/hunan.png'),
	(19,'广东','','','http://localhost:8181/images/guangdong.png'),
	(20,'海南','','','http://localhost:8181/images/hainan.png'),
	(21,'四川','','','http://localhost:8181/images/sichuan.png'),
	(22,'贵州','','','http://localhost:8181/images/guizhou.png'),
	(23,'云南','','','http://localhost:8181/images/yunnan.png'),
	(24,'陕西','','','http://localhost:8181/images/shanximianpi.png'),
	(25,'甘肃','','','http://localhost:8181/images/gansu.png'),
	(26,'青海','','','http://localhost:8181/images/qinghai.png'),
	(27,'台湾','','','http://localhost:8181/images/taiwan.png'),
	(28,'内蒙古','','','http://localhost:8181/images/neimenggu.png'),
	(29,'广西','','','http://localhost:8181/images/guangxi.png'),
	(30,'西藏','','','http://localhost:8181/images/xizang.png'),
	(31,'宁夏','','','http://localhost:8181/images/ningxia.png'),
	(32,'新疆','','','http://localhost:8181/images/xinjiang.png'),
	(33,'重庆','','','http://localhost:8181/images/chongqing.png'),
	(34,'香港','','','http://localhost:8181/images/xianggang.png'),
	(35,'澳门','','','http://localhost:8181/images/aomen.png'),
	(36,'吉林','','','http://localhost:8181/images/jilin.png'),
	(37,'黑龙江','','','http://localhost:8181/images/heilongjiang.png');

/*!40000 ALTER TABLE `city_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table community_manager
# ------------------------------------------------------------

DROP TABLE IF EXISTS `community_manager`;

CREATE TABLE `community_manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '',
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `user_role` int NOT NULL DEFAULT '0',
  `picUrl` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `certificate` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `community_manager` WRITE;
/*!40000 ALTER TABLE `community_manager` DISABLE KEYS */;

INSERT INTO `community_manager` (`id`, `identity_id`, `username`, `password`, `user_role`, `picUrl`, `certificate`)
VALUES
	(1,'123456','黄程','Y3NoY2hjc2gxOTk4MTk5OQ==',0,'http://localhost:8181/images/98235f74-3394-4d68-8e60-30bb6d2e1f44.jpg',1),
	(2,'372929199801166317','koutei','MTIzNDU2',1,'http://localhost:8181/images/98235f74-3394-4d68-8e60-30bb6d2e1f44.jpg',1),
	(9,'11111','11111','MTExMTE=',0,'http://localhost:8181/images/766062ef-b705-4c35-826d-78c1626c8690.jpg',1),
	(11,'123','huangchengTest','MTIz',1,'http://localhost:8181/images/f872261c-a282-4d24-bbef-4358668eed60.jpg',1);

/*!40000 ALTER TABLE `community_manager` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table community_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `community_user`;

CREATE TABLE `community_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '',
  `real_name` varchar(50) NOT NULL DEFAULT '',
  `phone` varchar(50) NOT NULL DEFAULT '',
  `province` varchar(50) NOT NULL DEFAULT '',
  `city` varchar(50) NOT NULL DEFAULT '',
  `district` varchar(50) NOT NULL DEFAULT '',
  `emergency_name` varchar(50) NOT NULL DEFAULT '',
  `emergency_phone` varchar(50) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `community` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `community_user` WRITE;
/*!40000 ALTER TABLE `community_user` DISABLE KEYS */;

INSERT INTO `community_user` (`id`, `identity_id`, `real_name`, `phone`, `province`, `city`, `district`, `emergency_name`, `emergency_phone`, `update_time`, `create_time`, `community`)
VALUES
	(1,'372929199801166317','黄程','17852738980','山东省','济南市','历下区','黄先亮','13475910553','2021-04-26 23:33:04','2021-04-26 23:33:04','万科幸福里二期8-1-102'),
	(2,'372929199801166318','测试1','17852738980','北京市','北京市','海淀区','测试1','17852738980','2021-04-27 00:28:54','2021-04-27 00:28:54','测试地址'),
	(3,'372929199801166319','测试2','17852738980','北京市','北京市','海淀区','测试2','17852738980','2021-04-27 00:29:10','2021-04-27 00:29:10','测试地址2'),
	(4,'372929199801166320','测试3','17852738980','北京市','北京市','海淀区','测试3','17852738980','2021-04-27 00:29:17','2021-04-27 00:29:17','测试地址3'),
	(5,'372929199801166321','测试4','17852738980','北京市','北京市','海淀区','测试4','17852738980','2021-04-27 00:29:26','2021-04-27 00:29:26','测试地址4');

/*!40000 ALTER TABLE `community_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table news_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `news_info`;

CREATE TABLE `news_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `news_title` varchar(50) NOT NULL DEFAULT '',
  `news_content` text,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `news_info` WRITE;
/*!40000 ALTER TABLE `news_info` DISABLE KEYS */;

INSERT INTO `news_info` (`id`, `news_title`, `news_content`, `update_time`, `create_time`)
VALUES
	(1,'【测试公告】黄程毕业设计','这是黄程毕设设计测试公告100','2021-04-26 23:50:06','2021-04-26 23:50:06'),
	(2,'【测试公告】黄程毕业设计1','这里是黄程毕业设计测试公告','2021-04-27 00:24:37','2021-04-27 00:24:37'),
	(3,'【测试公告】黄程毕业设计2','这里是黄程毕业设计测试公告','2021-04-27 00:24:40','2021-04-27 00:24:40'),
	(4,'【测试公告】黄程毕业设计3','这里是黄程毕业设计测试公告','2021-04-27 00:24:43','2021-04-27 00:24:43'),
	(5,'【测试公告】黄程毕业设计4','这里是黄程毕业设计测试公告','2021-04-27 00:24:45','2021-04-27 00:24:45'),
	(6,'【测试公告】黄程毕业设计5','这里是黄程毕业设计测试公告','2021-04-27 00:24:47','2021-04-27 00:24:47'),
	(7,'【测试公告】黄程毕业设计6','这里是黄程毕业设计测试公告','2021-04-27 00:24:49','2021-04-27 00:24:49');

/*!40000 ALTER TABLE `news_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table reservation_specific
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reservation_specific`;

CREATE TABLE `reservation_specific` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '' COMMENT '身份证号',
  `real_name` varchar(50) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `hospital_name` varchar(50) NOT NULL DEFAULT '' COMMENT '接种医院',
  `vaccine_status` int NOT NULL DEFAULT '0' COMMENT '疫苗针数',
  `is_deleted` int NOT NULL DEFAULT '0' COMMENT '是否接种',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `reservation_specific` WRITE;
/*!40000 ALTER TABLE `reservation_specific` DISABLE KEYS */;

INSERT INTO `reservation_specific` (`id`, `identity_id`, `real_name`, `hospital_name`, `vaccine_status`, `is_deleted`, `update_time`, `create_time`)
VALUES
	(36,'372929199801166317','黄程','1',1,0,'2021-05-08 20:32:26','2021-05-08 20:32:26'),
	(37,'372929199801166317','黄程','1',3,0,'2021-05-08 20:33:12','2021-05-08 20:33:12'),
	(38,'372929199801166317','黄程','济南医院',2,1,'2021-05-08 20:33:59','2021-05-08 20:33:59'),
	(39,'372929199801166317','黄程','济南医院',2,0,'2021-05-08 20:34:41','2021-05-08 20:34:41'),
	(40,'372929199801166317','黄程','济南医院',4,0,'2021-05-08 20:35:03','2021-05-08 20:35:03');

/*!40000 ALTER TABLE `reservation_specific` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sick_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sick_user`;

CREATE TABLE `sick_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '',
  `sick_reason` varchar(50) NOT NULL DEFAULT '',
  `when_sick` varchar(50) NOT NULL DEFAULT '',
  `if_favour` varchar(50) NOT NULL DEFAULT '',
  `body_temperature` double NOT NULL DEFAULT '36.5',
  `covid_test` varchar(50) NOT NULL DEFAULT '否',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `sick_user` WRITE;
/*!40000 ALTER TABLE `sick_user` DISABLE KEYS */;

INSERT INTO `sick_user` (`id`, `identity_id`, `sick_reason`, `when_sick`, `if_favour`, `body_temperature`, `covid_test`, `update_time`, `create_time`)
VALUES
	(2,'372929199801166317','感冒','2021-04-13','否',36.5,'未进行','2021-04-27 00:30:49','2021-04-27 00:30:49'),
	(3,'372929199801166318','发烧','2021-04-06','是',37.8,'阴性','2021-04-27 00:31:05','2021-04-27 00:31:05'),
	(4,'372929199801166320','头疼','2021-04-15','否',36.5,'未进行','2021-04-27 00:31:22','2021-04-27 00:31:22'),
	(5,'372929199801166317','感冒','2021-05-12','否',36.5,'阴性','2021-05-19 14:40:37','2021-05-19 14:40:37');

/*!40000 ALTER TABLE `sick_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table supply_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `supply_info`;

CREATE TABLE `supply_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supply_kind` varchar(50) NOT NULL DEFAULT '',
  `supply_content` varchar(50) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `supply_info` WRITE;
/*!40000 ALTER TABLE `supply_info` DISABLE KEYS */;

INSERT INTO `supply_info` (`id`, `supply_kind`, `supply_content`, `update_time`, `create_time`)
VALUES
	(1,'医疗应急物资','口罩','2021-04-26 23:51:08','2021-04-26 23:51:08'),
	(2,'医疗应急物资','手套','2021-04-26 23:51:09','2021-04-26 23:51:09'),
	(3,'医疗应急物资','红外式体温枪','2021-04-26 23:51:10','2021-04-26 23:51:10'),
	(4,'医疗应急物资','消毒液','2021-04-26 23:51:11','2021-04-26 23:51:11'),
	(5,'医疗应急物资','75%酒精','2021-04-26 23:51:12','2021-04-26 23:51:12'),
	(6,'医疗应急物资','清洁剂','2021-04-26 23:51:13','2021-04-26 23:51:13'),
	(7,'医疗应急物资','消毒柜','2021-04-26 23:51:14','2021-04-26 23:51:14'),
	(8,'医疗应急物资','消毒喷雾剂','2021-04-26 23:51:14','2021-04-26 23:51:14'),
	(9,'医疗应急物资','水银体温计','2021-04-26 23:51:16','2021-04-26 23:51:16'),
	(10,'果蔬品','白菜','2021-04-26 23:51:17','2021-04-26 23:51:17'),
	(11,'果蔬品','土豆','2021-04-26 23:51:18','2021-04-26 23:51:18'),
	(12,'果蔬品','西红柿','2021-04-26 23:51:19','2021-04-26 23:51:19'),
	(13,'果蔬品','黄瓜','2021-04-26 23:51:21','2021-04-26 23:51:21'),
	(14,'果蔬品','韭菜','2021-04-26 23:51:22','2021-04-26 23:51:22'),
	(15,'果蔬品','洋葱','2021-04-26 23:51:24','2021-04-26 23:51:24'),
	(16,'果蔬品','葱姜蒜','2021-04-26 23:51:26','2021-04-26 23:51:26'),
	(17,'果蔬品','油菜','2021-04-26 23:51:27','2021-04-26 23:51:27'),
	(18,'果蔬品','苹果','2021-04-26 23:58:43','2021-04-26 23:58:43'),
	(19,'果蔬品','香蕉','2021-04-26 23:58:46','2021-04-26 23:58:46'),
	(20,'果蔬品','梨','2021-04-26 23:58:47','2021-04-26 23:58:47'),
	(21,'果蔬品','桃子','2021-04-26 23:58:49','2021-04-26 23:58:49'),
	(22,'生活物资','厨具','2021-04-26 23:58:50','2021-04-26 23:58:50'),
	(23,'调料','油盐酱醋','2021-04-26 23:58:52','2021-04-26 23:58:52'),
	(28,'生活物资','大米','2021-04-27 00:21:28','2021-04-27 00:21:28'),
	(29,'生活物资','面粉','2021-04-27 00:21:52','2021-04-27 00:21:52'),
	(30,'水产品','鱼','2021-04-27 00:22:13','2021-04-27 00:22:13'),
	(31,'水产品','虾','2021-04-27 00:22:36','2021-04-27 00:22:36');

/*!40000 ALTER TABLE `supply_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table supply_need
# ------------------------------------------------------------

DROP TABLE IF EXISTS `supply_need`;

CREATE TABLE `supply_need` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '',
  `supply_type` varchar(50) NOT NULL DEFAULT '',
  `supply_content` varchar(50) NOT NULL DEFAULT '',
  `age` int NOT NULL DEFAULT '0',
  `is_emergency` int NOT NULL DEFAULT '0',
  `suggestion` varchar(255) NOT NULL DEFAULT '',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `supply_need` WRITE;
/*!40000 ALTER TABLE `supply_need` DISABLE KEYS */;

INSERT INTO `supply_need` (`id`, `identity_id`, `supply_type`, `supply_content`, `age`, `is_emergency`, `suggestion`, `update_time`, `create_time`)
VALUES
	(1,'372929199801166317','医疗应急物资','口罩',3,1,'','2021-04-27 00:04:24','2021-05-16 00:04:24'),
	(2,'372929199801166317','医疗应急物资','口罩',3,1,'','2021-04-27 00:04:24','2021-05-17 00:04:24'),
	(3,'372929199801166317','医疗应急物资','口罩',3,1,'','2021-04-27 00:04:24','2021-05-18 00:04:24'),
	(4,'372929199801166317','果蔬品','土豆',1,0,'','2021-04-27 00:05:05','2021-05-19 00:05:05'),
	(5,'372929199801166317','果蔬品','香蕉',3,0,'','2021-04-27 00:05:15','2021-05-20 00:05:15'),
	(6,'372929199801166317','医疗应急物资','消毒液',5,0,'','2021-04-27 00:05:24','2021-05-16 00:05:24'),
	(7,'372929199801166317','医疗应急物资','清洁剂',5,0,'','2021-04-27 00:05:27','2021-05-17 00:05:27'),
	(8,'372929199801166317','果蔬品','苹果',1,0,'','2021-04-27 00:06:15','2021-05-18 00:06:15'),
	(9,'372929199801166317','果蔬品','香蕉',1,0,'','2021-04-27 00:06:18','2021-05-19 00:06:18'),
	(10,'372929199801166317','水产品','鱼',1,0,'','2021-04-27 00:06:19','2021-05-20 00:06:19'),
	(11,'372929199801166317','果蔬品','油菜',2,0,'','2021-04-27 00:06:28','2021-05-16 00:06:28'),
	(12,'372929199801166317','果蔬品','油菜',2,0,'','2021-04-27 00:06:28','2021-05-17 00:06:28'),
	(13,'372929199801166317','果蔬品','油菜',2,0,'','2021-04-27 00:06:28','2021-05-17 00:06:28'),
	(14,'372929199801166317','医疗应急物资','红外式体温枪',3,0,'','2021-04-27 00:06:34','2021-05-20 00:06:34'),
	(15,'372929199801166317','医疗应急物资','红外式体温枪',3,0,'','2021-04-27 00:06:35','2021-05-20 00:06:35'),
	(16,'372929199801166317','医疗应急物资','红外式体温枪',3,0,'','2021-04-27 00:06:35','2021-05-19 00:06:35'),
	(17,'372929199801166317','调料','米油盐酱醋',4,0,'','2021-04-27 00:06:45','2021-05-20 00:06:45'),
	(18,'372929199801166317','调料','米油盐酱醋',4,0,'','2021-04-27 00:06:45','2021-05-17 00:06:45'),
	(19,'372929199801166317','生活物资','厨具',5,0,'','2021-04-27 00:06:52','2021-05-17 00:06:52'),
	(20,'372929199801166317','医疗应急物资','口罩',3,0,'','2021-05-18 00:06:52','2021-05-18 00:06:52'),
	(21,'372929199801166317','医疗应急物资','口罩',3,0,'','2021-05-19 00:06:52','2021-05-19 00:06:52'),
	(22,'372929199801166317','医疗应急物资','口罩',3,0,'','2021-05-20 14:26:39','2021-05-20 14:26:39'),
	(23,'372929199801166317','医疗应急物资','医疗应急物资',2,0,'','2021-05-21 14:29:21','2021-05-21 14:29:21');

/*!40000 ALTER TABLE `supply_need` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table todo_list
# ------------------------------------------------------------

DROP TABLE IF EXISTS `todo_list`;

CREATE TABLE `todo_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '',
  `todo_thing` varchar(1023) NOT NULL DEFAULT '',
  `is_deleted` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `todo_list` WRITE;
/*!40000 ALTER TABLE `todo_list` DISABLE KEYS */;

INSERT INTO `todo_list` (`id`, `identity_id`, `todo_thing`, `is_deleted`)
VALUES
	(3,'372929199801166317','我需要开发完主页面',1),
	(4,'372929199801166317','我要把论文写好',0),
	(6,'372929199801166317','我要完成毕业答辩',0),
	(7,'372929199801166317','致谢需要写完',0),
	(8,'372929199801166317','我还需要洗衣服',0),
	(10,'372929199801166317','记得按时吃饭哦',0),
	(11,'372929199801166317','测试',1),
	(13,'372929199801166317','我要修改论文内容',1);

/*!40000 ALTER TABLE `todo_list` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table travel_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `travel_info`;

CREATE TABLE `travel_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `picUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `province` varchar(50) NOT NULL DEFAULT '',
  `travel_score` int NOT NULL DEFAULT '0',
  `a5_num` int NOT NULL DEFAULT '0',
  `info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `travel_info` WRITE;
/*!40000 ALTER TABLE `travel_info` DISABLE KEYS */;

INSERT INTO `travel_info` (`id`, `picUrl`, `province`, `travel_score`, `a5_num`, `info`)
VALUES
	(3,'http://localhost:8181/images/travelanhui.png','安徽',60,110,'主要景点：合肥的三国胜迹、芜湖的滨江湖影、安庆的皖江文化、蚌埠的淮畔明珠、黄山的名山古城、马鞍山的江水诗城、宣城的名村古镇、铜陵的铜都风光、宿州的楚风汉韵、淮南的八公山、阜阳的淮河生态、滁州的山水名亭、六安的革命红区、淮北的隋唐山水、池州的佛教圣地、亳州的曹操故里'),
	(4,'http://localhost:8181/images/travelaomen.jpg','澳门',80,100,'主要景点：澳门历史城区是一片以澳门旧城区为核心的历史街区，其间以相邻的广场和街道连接而成，包括22座建筑及8个广场前地。包括众多世界遗产、博物馆及展览厅、教堂、庙宇、公园、炮台等。'),
	(5,'http://localhost:8181/images/travelbeijing.jpg','北京',100,140,'主要景点：北京是全球拥有世界遗产（7处）最多的城市，是全球首个拥有世界地质公园的首都城市。北京对外开放的旅游景点达200多处，有世界上最大的皇宫紫禁城、祭天神庙天坛、皇家园林北海公园、颐和园和圆明园，还有八达岭长城、慕田峪长城以及世界上最大的四合院恭王府等名胜古迹。北京市共有文物古迹7309项，99处全国重点文物保护单位（含长城和京杭大运河的北京段）、326处市级文物保护单位、5处国家地质公园、15处国家森林公园。'),
	(6,'http://localhost:8181/images/travelchongqing.jpg','重庆',100,160,'主要景点：重庆拥有山、水、林、泉、瀑、峡、洞等自然景色，共有自然、人文景点300余处，其中有世界文化遗产1个（大足石刻），世界自然遗产2个（重庆武隆喀斯特旅游区、重庆金佛山喀斯特 [137]  ），国家重点风景名胜区6个，国家森林公园24个，国家地质公园6个，国家级自然保护区4个，全国重点文物保护单位20个。'),
	(7,'http://localhost:8181/images/travelfujian.jpg','福建',80,100,'主要景点：福建的旅游资源丰富而且独特。厦门市鼓浪屿风景名胜区（2007年）、南平市武夷山风景名胜区（2007年）、福建土楼（永定·南靖）旅游景区（2011年）、福建省三明市泰宁风景名胜区（2011年）、泉州市清源山景区（2012年）、宁德市白水洋鸳鸯溪旅游区（2012年）、宁德市福鼎太姥山旅游区（2013年）、福建省龙岩市古田旅游区（2015年）、福州市三坊七巷景区（2015年）、湄洲岛妈祖文化旅游区（2021年）等10个国家AAAAA级旅游景区景色奇异秀丽。 [49]  [65]  福建省是全国第二个每个设区市都有国家5A级旅游景区的省份。'),
	(8,'http://localhost:8181/images/travelgansu.png','甘肃',70,40,'主要景点：嘉峪关文物景区（嘉峪关市）、崆峒山风景名胜区（平凉市）、七彩丹霞风景区（张掖市）、麦积山景区（天水市）、鸣沙山月牙泉风景名胜区（敦煌市）'),
	(9,'http://localhost:8181/images/travelguangdong.jpg','广东',100,130,'主要景点：广州市长隆旅游度假区、深圳市观澜湖休闲旅游区、深圳华侨城旅游度假区、佛山市西樵山风景名胜区、佛山市长鹿旅游休博园、韶关市丹霞山、风景名胜区、梅州市雁南飞茶田度假村、惠州市罗浮山风景名胜区、惠州市西湖风景名胜区、中山市孙中山故里旅游区、阳江市海陵岛大角湾'),
	(10,'http://localhost:8181/images/travelguangxi.png','广西',90,60,'主要景点：柳州百里柳江沿江风景带、柳州大龙潭风景区、柳州都乐岩风景区、柳州鱼峰公园、容县都峤山风景区、钦州三娘湾旅游区、钦州八寨沟风景区、南宁青秀山风景区等'),
	(11,'http://localhost:8181/images/travelguizhou.png','贵州',85,60,'主要景点：黄果树瀑布、龙宫风景区、西江千户苗寨、赤水、马岭河峡谷、万峰林、百里杜鹃、织金洞、威宁草海、遵义会议会址、小七孔、红枫湖景区、天河潭、青岩古镇、玉舍国家森林公园、瓮安县草塘千年古邑旅游区'),
	(12,'http://localhost:8181/images/travelhainan.png','海南',85,60,NULL),
	(13,'http://localhost:8181/images/travelhebei.png','河北',60,90,'主要景点：河北是文物大省，省级以上文物保护单位达930处，居全国第一位。拥有长城、承德避暑山庄及周围寺庙、清东陵和清西陵3项世界文化遗产；拥有邯郸、保定、承德、正定、山海关5个国家级历史文化名城。河北是长城途经距离最长、保存最完好、建筑风格最具代表性的省份，境内长城遗存达2000多公里，老龙头、山海关、金山岭长城等长城精华均在河北境内。承德避暑山庄是世界现存最大的皇家园林，其周围的外八庙是中国最大的皇家寺庙群。清东陵和清西陵是中国现存规模最大、保存最完整的皇家陵墓群。赵州桥被誉为“世界拱桥之祖”，是世界最古老的敞肩石拱桥，迄今已有1400余年的历史。'),
	(14,'http://localhost:8181/images/travelheilongjiang.jpg','黑龙江',75,50,NULL),
	(15,'http://localhost:8181/images/travelhenan.png','河南',0,130,NULL),
	(16,'http://localhost:8181/images/travelhk.png','香港',0,100,NULL),
	(17,'http://localhost:8181/images/travelhubei.jpg','湖北',100,110,NULL),
	(18,'http://localhost:8181/images/travelhunan.png','湖南',90,80,NULL),
	(19,'http://localhost:8181/images/traveljiangsu.png','江苏',80,230,'主要景区：截至2019年12月，江苏有4处世界遗产（另有3处正申遗中）、5A级景区24家、4A级景区超100家、4处国家级旅游度假区、3处国家级自然保护区、4处国家地质公园、21处国家森林公园、3处国家海洋公园、27处国家湿地公园、60处国家级水利风景区、5处国家重点风景名胜区、28座全国优秀旅游城市、120处全国重点文物保护单位、645处省级文物保护单位。'),
	(20,'http://localhost:8181/images/traveljiangxi.jpg','江西',60,110,'主要景点：滕王阁、井冈山、共和国摇篮景区、鬼峰风景名胜区、大觉山旅游风景区、武功山、明月山旅游区、景德镇古窑民俗博览区、鹰潭龙虎山、庐山等'),
	(21,'http://localhost:8181/images/traveljilin.png','吉林',75,60,'主要景点：长白山、高句丽古迹、向海国家级自然保护区、防川风景名胜区、伪满皇宫博物院、松花湖、净月潭国家森林公园、查干湖。'),
	(22,'http://localhost:8181/images/travelliaoning.png','辽宁',75,50,NULL),
	(23,'http://localhost:8181/images/travelneimenggu.png','内蒙古',80,50,NULL),
	(24,'http://localhost:8181/images/travelningxia.png','宁夏',80,40,NULL),
	(25,'http://localhost:8181/images/travelqinghai.png','青海',80,30,'主要景点：青海湖、孟达林区、塔尔寺、三江源茶卡盐湖、东北清真大寺'),
	(26,'http://localhost:8181/images/travelshandong.png','山东',70,110,NULL),
	(27,'http://localhost:8181/images/travelshanghai.png','上海',100,60,NULL),
	(28,'http://localhost:8181/images/travelshanxicu.png','山西',60,80,NULL),
	(29,'http://localhost:8181/images/travelshanximian.png','陕西',90,90,NULL),
	(30,'http://localhost:8181/images/travelsichuan.jpg','四川',100,120,NULL),
	(31,'http://localhost:8181/images/traveltaiwan.jpg','台湾',80,0,NULL),
	(32,'http://localhost:8181/images/traveltianjin.jpg','天津',70,40,NULL),
	(33,'http://localhost:8181/images/travelxinjiang.jpg','新疆',100,120,'主要景点：新疆是歌舞之乡、瓜果之乡、黄金玉石之邦。新疆就有56种全国旅游资源类型，占全国旅游资源类型的83%。全疆共有景点一千一百余处，居全国首位。这里有海拔8600米的世界第二高峰，又有低于海平面154米的中国最低洼地。'),
	(34,'http://localhost:8181/images/travelxizang.png','西藏',90,40,'主要景点：西藏名胜古迹众多。全区有各级文物保护单位251处，其中，国家级重点文物保护单位27处，自治区级重点文物保护单位55处，地（市）、县级文物保护单位169处。\n玛旁雍错湿地国家级自然保护区（2017年7月设立）。 \n2020年11月9日，雅鲁藏布大峡谷旅游景区被授予国家5A级旅游景区 。'),
	(35,'http://localhost:8181/images/travelyunnan.png','云南',100,80,NULL),
	(36,'http://localhost:8181/images/travelzhejiang.png','浙江',80,170,'主要景点：浙江省有重要地貌景观800多处，水域景观200多处，生物景观100多处，人文景观100多处；18个国家级重点风景名胜区，42个省级风景名胜区；6座国家级历史文化名城，12座省级历史文化名城；全国重点文物保护单位134处，省级重点文物保护单位279个；国家级自然保护区10个，国家森林公园35个。浙江省有国家级风景名胜区127处，国家自然保护区65处，是森林公园最多的省，有丝绸、茶叶、服装、南宋官窑等博物馆。');

/*!40000 ALTER TABLE `travel_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table vaccine_location
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vaccine_location`;

CREATE TABLE `vaccine_location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hospital_name` varchar(50) NOT NULL DEFAULT '' COMMENT '接种点名称',
  `hospital_location` varchar(50) NOT NULL DEFAULT '' COMMENT '接种点位置',
  `hostipal_tel` varchar(50) NOT NULL DEFAULT '' COMMENT '接种点联系电话',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '疫苗种类',
  `picUrl` varchar(150) NOT NULL DEFAULT '' COMMENT '图片路径url',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `vaccine_location` WRITE;
/*!40000 ALTER TABLE `vaccine_location` DISABLE KEYS */;

INSERT INTO `vaccine_location` (`id`, `hospital_name`, `hospital_location`, `hostipal_tel`, `type`, `picUrl`, `update_time`, `create_time`)
VALUES
	(21,'1','1','1','北京生物,北京科兴,武汉生物','http://localhost:8181/images/da7e2c1b-3867-4364-8be3-b73c00eb26f9.png','2021-05-04 21:04:01','2021-05-04 21:04:01'),
	(22,'济南医院','济南市历山路63-1号','0531-55739999 ','北京生物,北京科兴','http://localhost:8181/images/176feba2-10e0-47b4-9bf8-ebf8ed289efd.png','2021-05-07 17:07:24','2021-05-07 17:07:24');

/*!40000 ALTER TABLE `vaccine_location` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table vaccine_reservation
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vaccine_reservation`;

CREATE TABLE `vaccine_reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identity_id` varchar(50) NOT NULL DEFAULT '' COMMENT '身份证号',
  `real_name` varchar(50) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `phone` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `hospital_name` varchar(50) NOT NULL DEFAULT '' COMMENT '医院名称',
  `vaccine_status` int NOT NULL DEFAULT '0' COMMENT '接种状态',
  `vaccine_type` int NOT NULL DEFAULT '0' COMMENT '疫苗品种',
  `picUrl` varchar(2083) NOT NULL DEFAULT '' COMMENT '接种截图信息',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `vaccine_reservation` WRITE;
/*!40000 ALTER TABLE `vaccine_reservation` DISABLE KEYS */;

INSERT INTO `vaccine_reservation` (`id`, `identity_id`, `real_name`, `phone`, `hospital_name`, `vaccine_status`, `vaccine_type`, `picUrl`, `update_time`, `create_time`)
VALUES
	(41,'372929199801166317','黄程','17852738980','济南医院',4,2,'http://localhost:8181/images/46f87179-cec3-4978-9710-446eae6f02b6.jpg','2021-05-08 20:32:26','2021-05-08 20:32:26');

/*!40000 ALTER TABLE `vaccine_reservation` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table verify_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `verify_user`;

CREATE TABLE `verify_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `identity_id` varchar(50) NOT NULL DEFAULT '',
  `sex` varchar(50) NOT NULL DEFAULT '',
  `nationality` varchar(50) NOT NULL DEFAULT '',
  `birth` varchar(50) NOT NULL DEFAULT '',
  `start_date` varchar(50) NOT NULL DEFAULT '',
  `end_date` varchar(50) NOT NULL DEFAULT '',
  `issue` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  `face_url` varchar(100) NOT NULL DEFAULT '',
  `back_url` varchar(100) NOT NULL DEFAULT '',
  `sign_url` varchar(100) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
