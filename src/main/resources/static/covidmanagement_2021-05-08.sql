# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 8.0.24)
# Database: covidmanagement
# Generation Time: 2021-05-08 15:13:57 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


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
	(1,'山东省','济南市','历下区','http://localhost:8181/images/shandong.png'),
	(2,'北京市','北京市','海淀区','http://localhost:8181/images/beijing.png'),
	(3,'北京市','北京市','朝阳区','http://localhost:8181/images/beijing.png'),
	(4,'北京市','北京市','平谷区','http://localhost:8181/images/beijing.png'),
	(5,'天津市','','','http://localhost:8181/images/tianjin.png'),
	(6,'河北省','','','http://localhost:8181/images/hebei.png'),
	(7,'山西省','','','http://localhost:8181/images/shanxichencu.png'),
	(8,'辽宁省','','','http://localhost:8181/images/liaoning.png'),
	(9,'上海市','','','http://localhost:8181/images/shanghai.png'),
	(10,'江苏省','','','http://localhost:8181/images/jiangsu.png'),
	(11,'浙江省','','','http://localhost:8181/images/zhejiang.png'),
	(12,'安徽省','','','http://localhost:8181/images/anhui.png'),
	(13,'福建省','','','http://localhost:8181/images/fujian.png'),
	(14,'江西省','','','http://localhost:8181/images/jiangxi.png'),
	(15,'山东省','','','http://localhost:8181/images/shandong.png'),
	(16,'河南省','','','http://localhost:8181/images/henan.png'),
	(17,'湖北省','','','http://localhost:8181/images/hubei.png'),
	(18,'湖南省','','','http://localhost:8181/images/hunan.png'),
	(19,'广东省','','','http://localhost:8181/images/guangdong.png'),
	(20,'海南省','','','http://localhost:8181/images/hainan.png'),
	(21,'四川省','','','http://localhost:8181/images/sichuan.png'),
	(22,'贵州省','','','http://localhost:8181/images/guizhou.png'),
	(23,'云南省','','','http://localhost:8181/images/yunnan.png'),
	(24,'陕西省','','','http://localhost:8181/images/shanximianpi.png'),
	(25,'甘肃省','','','http://localhost:8181/images/gansu.png'),
	(26,'青海省','','','http://localhost:8181/images/qinghai.png'),
	(27,'台湾','','','http://localhost:8181/images/taiwan.png'),
	(28,'内蒙古自治区','','','http://localhost:8181/images/neimenggu.png'),
	(29,'广西壮族自治区','','','http://localhost:8181/images/guangxi.png'),
	(30,'西藏自治区','','','http://localhost:8181/images/xizang.png'),
	(31,'宁夏回族自治区','','','http://localhost:8181/images/ningxia.png'),
	(32,'新疆维吾尔自治区','','','http://localhost:8181/images/xinjiang.png'),
	(33,'重庆市','','','http://localhost:8181/images/chongqing.png'),
	(34,'香港','','','http://localhost:8181/images/xianggang.png'),
	(35,'澳门','','','http://localhost:8181/images/aomen.png'),
	(36,'吉林省','','','http://localhost:8181/images/jilin.png'),
	(37,'黑龙江省','','','http://localhost:8181/images/heilongjiang.png');

/*!40000 ALTER TABLE `city_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table community_manager
# ------------------------------------------------------------

DROP TABLE IF EXISTS `community_manager`;

CREATE TABLE `community_manager` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `community_manager` WRITE;
/*!40000 ALTER TABLE `community_manager` DISABLE KEYS */;

INSERT INTO `community_manager` (`id`, `username`, `password`)
VALUES
	(1,'372929199801166317','Y3NoY2hjc2gxOTk4MTk5OQ==');

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
	(1,'【测试公告】黄程毕业设计','这是黄程毕设设计测试公告1','2021-04-26 23:50:06','2021-04-26 23:50:06'),
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
	(4,'372929199801166320','头疼','2021-04-15','否',36.5,'未进行','2021-04-27 00:31:22','2021-04-27 00:31:22');

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
	(1,'372929199801166317','医疗应急物资','口罩',3,1,'','2021-04-27 00:04:24','2021-04-24 00:04:24'),
	(2,'372929199801166317','医疗应急物资','口罩',3,1,'','2021-04-27 00:04:24','2021-04-26 00:04:24'),
	(3,'372929199801166317','医疗应急物资','口罩',3,1,'','2021-04-27 00:04:24','2021-04-25 00:04:24'),
	(4,'372929199801166317','果蔬品','土豆',1,0,'','2021-04-27 00:05:05','2021-04-24 00:05:05'),
	(5,'372929199801166317','果蔬品','香蕉',3,0,'','2021-04-27 00:05:15','2021-04-23 00:05:15'),
	(6,'372929199801166317','医疗应急物资','消毒液',5,0,'','2021-04-27 00:05:24','2021-04-22 00:05:24'),
	(7,'372929199801166317','医疗应急物资','清洁剂',5,0,'','2021-04-27 00:05:27','2021-04-22 00:05:27'),
	(8,'372929199801166317','果蔬品','苹果',1,0,'','2021-04-27 00:06:15','2021-04-22 00:06:15'),
	(9,'372929199801166317','果蔬品','香蕉',1,0,'','2021-04-27 00:06:18','2021-04-22 00:06:18'),
	(10,'372929199801166317','水产品','鱼',1,0,'','2021-04-27 00:06:19','2021-04-24 00:06:19'),
	(11,'372929199801166317','果蔬品','油菜',2,0,'','2021-04-27 00:06:28','2021-04-25 00:06:28'),
	(12,'372929199801166317','果蔬品','油菜',2,0,'','2021-04-27 00:06:28','2021-04-26 00:06:28'),
	(13,'372929199801166317','果蔬品','油菜',2,0,'','2021-04-27 00:06:28','2021-04-22 00:06:28'),
	(14,'372929199801166317','医疗应急物资','红外式体温枪',3,0,'','2021-04-27 00:06:34','2021-04-22 00:06:34'),
	(15,'372929199801166317','医疗应急物资','红外式体温枪',3,0,'','2021-04-27 00:06:35','2021-04-23 00:06:35'),
	(16,'372929199801166317','医疗应急物资','红外式体温枪',3,0,'','2021-04-27 00:06:35','2021-04-24 00:06:35'),
	(17,'372929199801166317','调料','米油盐酱醋',4,0,'','2021-04-27 00:06:45','2021-04-25 00:06:45'),
	(18,'372929199801166317','调料','米油盐酱醋',4,0,'','2021-04-27 00:06:45','2021-04-26 00:06:45'),
	(19,'372929199801166317','生活物资','厨具',5,0,'','2021-04-27 00:06:52','2021-04-26 00:06:52');

/*!40000 ALTER TABLE `supply_need` ENABLE KEYS */;
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



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
