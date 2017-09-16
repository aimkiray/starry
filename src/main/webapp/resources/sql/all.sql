-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.2.6-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 mybatis 的数据库结构
CREATE DATABASE IF NOT EXISTS `mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mybatis`;

-- 导出  表 mybatis.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `adminId` int(11) DEFAULT NULL,
  `admin_name` varchar(50) DEFAULT NULL,
  `adminAge` int(11) DEFAULT NULL,
  `admin_password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mybatis.admin 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


-- 导出 sgroup 的数据库结构
CREATE DATABASE IF NOT EXISTS `sgroup` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sgroup`;

-- 导出  表 sgroup.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_password` varchar(32) NOT NULL,
  `admin_name` varchar(32) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.admin 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`admin_id`, `admin_password`, `admin_name`) VALUES
	(3, '123456', 'admin'),
	(4, '123456', 'root2'),
	(5, '123456', 'root3'),
	(6, '1234', 'root'),
	(7, '123456', '路西法'),
	(8, '123456', '阿卡林');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 导出  表 sgroup.boss 结构
CREATE TABLE IF NOT EXISTS `boss` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(32) NOT NULL,
  `bpassword` varchar(32) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.boss 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `boss` DISABLE KEYS */;
INSERT INTO `boss` (`bid`, `bname`, `bpassword`) VALUES
	(1, 'boss', '123456');
/*!40000 ALTER TABLE `boss` ENABLE KEYS */;

-- 导出  表 sgroup.category 结构
CREATE TABLE IF NOT EXISTS `category` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`categoryID`),
  UNIQUE KEY `category_categoryID_uindex` (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.category 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 导出  表 sgroup.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  PRIMARY KEY (`customerID`),
  UNIQUE KEY `customer_customerID_uindex` (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.customer 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customerID`, `customer_name`) VALUES
	(1, '小黑'),
	(2, '小白'),
	(3, '小红'),
	(5, '小智'),
	(6, '少女A');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 导出  表 sgroup.employee 结构
CREATE TABLE IF NOT EXISTS `employee` (
  `empID` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) NOT NULL,
  PRIMARY KEY (`empID`),
  UNIQUE KEY `employee_empID_uindex` (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.employee 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`empID`, `emp_name`) VALUES
	(1, '店员'),
	(2, '店长'),
	(3, '社长');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- 导出  表 sgroup.file_catalog 结构
CREATE TABLE IF NOT EXISTS `file_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `file_catalog_id_uindex` (`id`),
  UNIQUE KEY `file_catalog_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.file_catalog 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `file_catalog` DISABLE KEYS */;
INSERT INTO `file_catalog` (`id`, `name`, `date`) VALUES
	(1, '201707151510239649.png', '2017-07-16 20:20:38'),
	(2, '201707162142007142.png', '2017-07-16 21:42:20'),
	(3, '201707162233362422.exe', '2017-07-16 22:33:43'),
	(4, '201707162233555307.jar', '2017-07-16 22:33:55'),
	(5, '201707162234341357.png', '2017-07-16 22:34:34'),
	(6, '201707162235294527.msi', '2017-07-16 22:35:29'),
	(7, '201707162235509405.jar', '2017-07-16 22:36:01'),
	(8, '201707162237106562.exe', '2017-07-16 22:37:17'),
	(9, '201707271100402888.jpg', '2017-07-27 11:00:40');
/*!40000 ALTER TABLE `file_catalog` ENABLE KEYS */;

-- 导出  表 sgroup.order_detail 结构
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` varchar(255) NOT NULL,
  `productID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_detail_id_uindex` (`id`),
  KEY `order_detail_product_pid_fk` (`productID`),
  KEY `order_detail_order_info_orderID_fk` (`orderID`),
  CONSTRAINT `order_detail_order_info_orderID_fk` FOREIGN KEY (`orderID`) REFERENCES `order_info` (`orderID`),
  CONSTRAINT `order_detail_product_pid_fk` FOREIGN KEY (`productID`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.order_detail 的数据：~31 rows (大约)
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` (`id`, `orderID`, `productID`, `quantity`, `discount`) VALUES
	(46, '201707261350393179', 58, 1, 9),
	(47, '201707261350393179', 59, 2, 10),
	(48, '201707261457183158', 59, 2, 10),
	(49, '201707262301113637', 57, 3, 10),
	(50, '201707262301113637', 58, 1, 10),
	(51, '201707262301113637', 59, 2, 10),
	(97, '201707270031093177', 57, 1, 10),
	(98, '201707270031093177', 58, 2, 10),
	(99, '201707270031093177', 59, 1, 10),
	(100, '201707270031093177', 43, 1, 10),
	(101, '201707270829554043', 57, 1, 10),
	(102, '201707270829554043', 58, 2, 10),
	(103, '201707270829554043', 59, 1, 10),
	(104, '201707270829554043', 43, 1, 10),
	(138, '201707270944127347', 56, 2, 10),
	(139, '201707270948185779', 56, 2, 10),
	(140, '201707270948185779', 69, 1, 10),
	(141, '201707270948185779', 70, 2, 10),
	(142, '201707270948185779', 42, 1, 10),
	(143, '201707270948185779', 43, 1, 10),
	(149, '201707271059557375', 33, 1, 9),
	(150, '201707271059557375', 67, 2, 10),
	(151, '201707271059557375', 2, 3, 10),
	(152, '201707271059557375', 68, 1, 10),
	(153, '201707271059557375', 42, 1, 10),
	(154, '201707272126529945', 33, 2, 10),
	(155, '201707272126529945', 72, 2, 10),
	(156, '201707272126529945', 42, 2, 10),
	(169, '201707261346582294', 67, 1, 10),
	(170, '201707261346582294', 68, 2, 10),
	(171, '201707261346582294', 60, 2, 10);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;

-- 导出  表 sgroup.order_info 结构
CREATE TABLE IF NOT EXISTS `order_info` (
  `orderID` varchar(255) NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `customerID` int(11) NOT NULL,
  `empID` int(11) NOT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `order_orderID_uindex` (`orderID`),
  KEY `order_customer_customerID_fk` (`customerID`),
  KEY `order_employee_empID_fk` (`empID`),
  CONSTRAINT `order_customer_customerID_fk` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  CONSTRAINT `order_employee_empID_fk` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.order_info 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
INSERT INTO `order_info` (`orderID`, `order_date`, `customerID`, `empID`) VALUES
	('201707261346582294', '2017-07-26 13:46:49', 5, 3),
	('201707261350393179', '2017-07-26 13:50:10', 2, 3),
	('201707261457183158', '2017-07-26 14:57:02', 5, 2),
	('201707262301113637', '2017-07-26 10:54:37', 5, 3),
	('201707270031093177', '2017-07-26 12:39:17', 3, 2),
	('201707270829554043', '2017-07-26 12:39:17', 5, 2),
	('201707270944127347', '2017-07-26 12:39:17', 3, 2),
	('201707270948185779', '2017-07-26 12:46:03', 3, 2),
	('201707271059557375', '2017-07-27 10:57:20', 5, 3),
	('201707272126529945', '2017-07-27 21:26:29', 2, 1);
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;

-- 导出  表 sgroup.product 结构
CREATE TABLE IF NOT EXISTS `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(32) NOT NULL,
  `pprice` int(11) NOT NULL,
  `pnumber` int(11) NOT NULL,
  `ptype` int(11) NOT NULL,
  `producttime` datetime DEFAULT NULL,
  `id` int(11) NOT NULL,
  `filename` varchar(32) DEFAULT NULL,
  `categoryID` int(11) DEFAULT NULL,
  `providerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `product_filename_uindex` (`filename`),
  KEY `product_product_type_typeid_fk` (`ptype`),
  CONSTRAINT `product_product_type_typeid_fk` FOREIGN KEY (`ptype`) REFERENCES `product_type` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.product 的数据：~18 rows (大约)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pid`, `pname`, `pprice`, `pnumber`, `ptype`, `producttime`, `id`, `filename`, `categoryID`, `providerID`) VALUES
	(2, '阿卡林', 999, 100, 26, '2017-07-06 21:27:21', 0, '201707272127271013.jpg', 0, 0),
	(3, '金坷垃', 998, 1, 5, '2017-07-06 21:27:22', 0, '201707181911444282.jpg', 0, 0),
	(33, '3ds', 100, 1, 20, '2017-07-06 21:27:29', 0, '201707181911571656.jpg', 0, 0),
	(42, '奥利奥', 1, 1, 4, '2017-07-06 21:28:47', 0, '201707181913091502.jpg', 0, 0),
	(43, 'switch', 999, 1, 20, '2017-07-07 08:38:14', 0, '201707181124370383.gif', 0, 0),
	(56, 'psp1000', 222, 11, 20, '2017-07-12 17:11:00', 7, '7', 0, 0),
	(57, 'psp2000', 333, 23, 20, '2017-07-12 17:11:18', 8, '8', 0, 0),
	(58, 'psp3000', 323, 23, 20, '2017-07-12 18:37:02', 9, '9', 0, 0),
	(59, 'psv1000', 2, 32, 20, '2017-07-12 18:37:17', 10, '10', 0, 0),
	(60, 'psv2000', 3213, 2, 20, '2017-07-12 18:37:34', 11, '11', 0, 0),
	(65, 'psv3000', 3, 2, 2, '2017-07-19 20:15:13', 12, '12', 0, 0),
	(66, 'psp5000', 222, 23, 20, '2017-07-22 09:14:44', 1, '201707220914436575.gif', NULL, NULL),
	(67, 'psp7000', 333, 11, 20, '2017-07-22 14:44:25', 1, '201707221444242801.jpg', NULL, NULL),
	(68, 'psp8000', 333, 11, 20, '2017-07-22 14:51:04', 1, '201707221451003281.jpg', NULL, NULL),
	(69, 'psp9000', 222, 11, 20, '2017-07-22 15:01:00', 1, '201707221500576857.jpg', NULL, NULL),
	(70, 'psv4000', 222, 11, 20, '2017-07-22 15:03:16', 1, '201707221502388205.jpg', NULL, NULL),
	(71, 'psv5000', 222, 23, 20, '2017-07-22 15:04:08', 1, '201707221504213861.jpg', NULL, NULL),
	(72, 'psp11', 222, 23, 2, '2017-07-27 10:56:32', 0, '201707271057005130.jpg', NULL, NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 导出  表 sgroup.product_type 结构
CREATE TABLE IF NOT EXISTS `product_type` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(32) NOT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.product_type 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` (`typeid`, `typename`) VALUES
	(1, '勇者'),
	(2, '魔王'),
	(3, '大神'),
	(4, '化肥'),
	(5, '可以吃的'),
	(6, '不能吃的'),
	(17, '饮料'),
	(20, '游戏机'),
	(26, '公主'),
	(37, '王子');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;

-- 导出  表 sgroup.provider 结构
CREATE TABLE IF NOT EXISTS `provider` (
  `providerID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`providerID`),
  UNIQUE KEY `provider_providerID_uindex` (`providerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.provider 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;

-- 导出  表 sgroup.user_info 结构
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` int(11) NOT NULL,
  `sign_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_userId_uindex` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  sgroup.user_info 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`user_id`, `user_name`, `user_password`, `real_name`, `email`, `gender`, `sign_date`) VALUES
	(1, 'test1', '1234', 'guess', '31341@gmail.com', 1, '2017-08-01 16:08:37'),
	(2, 'test2', '1234', 'who', 'whofawea@gmail.com', 0, '2017-08-01 16:09:30'),
	(3, 'test3', '1234', 'am', 'afaegfa@gmail.com', 1, '2017-08-01 16:10:15');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;


-- 导出 sinitial 的数据库结构
CREATE DATABASE IF NOT EXISTS `sinitial` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sinitial`;

-- 导出  表 sinitial.sl_admin 结构
CREATE TABLE IF NOT EXISTS `sl_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(38) DEFAULT NULL,
  `admin_password` varchar(38) DEFAULT NULL,
  `admin_email` varchar(138) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `sl_admin_admin_id_uindex` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_admin 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sl_admin` DISABLE KEYS */;
INSERT INTO `sl_admin` (`admin_id`, `admin_name`, `admin_password`, `admin_email`) VALUES
	(2, '阿卡林', '123456', 'aaaaa@gmail.com'),
	(4, '&#38463;&#24211;&#23045;', '123456', 'mdzz@sb.com'),
	(5, 'test', '123456', 'mdzz@sb.com');
/*!40000 ALTER TABLE `sl_admin` ENABLE KEYS */;

-- 导出  表 sinitial.sl_author 结构
CREATE TABLE IF NOT EXISTS `sl_author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(30) DEFAULT NULL,
  `author_date` datetime DEFAULT NULL,
  `author_info` varchar(300) DEFAULT NULL,
  `author_password` varchar(30) DEFAULT NULL,
  `nick_name` varchar(30) DEFAULT NULL,
  `headshot` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`author_id`),
  UNIQUE KEY `sl_author_author_id_uindex` (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_author 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `sl_author` DISABLE KEYS */;
INSERT INTO `sl_author` (`author_id`, `author_name`, `author_date`, `author_info`, `author_password`, `nick_name`, `headshot`) VALUES
	(1, '魔理沙', '2017-08-04 09:10:02', '魔法使', '1234', '雾雨', '201708161244304319.jpg'),
	(2, '博丽灵梦', '2017-08-04 20:06:17', '巫女', '1234', '红白', '201708161421454971.gif'),
	(6, '魔理沙10', '2017-08-15 00:00:00', '普通的', '1234', '雾雨', '201708152001560427.jpg'),
	(7, '魔理沙2', '2017-08-15 00:00:00', '普通的', '1234', '雾雨', '201708161243430824.jpg'),
	(12, '魔理沙7', '2017-08-15 00:00:00', '普通的', '1234', '雾雨', '201708161243096958.jpg'),
	(18, '琪露诺', '2017-08-15 20:48:23', '妖精', '1234', '妖精', '201708152048396905.jpg'),
	(21, 'test', '2017-08-17 09:25:45', 'test', '1234', 'test', NULL);
/*!40000 ALTER TABLE `sl_author` ENABLE KEYS */;

-- 导出  表 sinitial.sl_permission 结构
CREATE TABLE IF NOT EXISTS `sl_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(30) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `is_parent` tinyint(1) DEFAULT NULL,
  `is_menu` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  UNIQUE KEY `sl_permission_permission_id_uindex` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_permission 的数据：~37 rows (大约)
/*!40000 ALTER TABLE `sl_permission` DISABLE KEYS */;
INSERT INTO `sl_permission` (`permission_id`, `permission_name`, `description`, `url`, `parent_id`, `is_parent`, `is_menu`) VALUES
	(60, '登陆管理', '登陆权限', '/login', 0, 0, 0),
	(64, '用户角色管理', '用户角色', '/user/role/list', 95, 1, 1),
	(65, '添加用户角色', '添加用户角色', '/user/role/add', 64, 0, 0),
	(66, '删除用户角色', '删除用户角色', '/user/role/del', 64, 0, 0),
	(67, '角色管理', '角色管理', '/role/list', 0, 1, 1),
	(68, '添加角色', '添加角色', '/role/add', 67, 0, 0),
	(69, '删除角色', '删除角色', '/role/del', 67, 0, 0),
	(70, '修改角色', '修改角色', '/role/update', 67, 0, 0),
	(71, '角色权限', '角色权限', '/role/permission/list', 67, 1, 1),
	(72, '添加角色权限', '添加角色权限', '/role/permission/add', 71, 0, 0),
	(73, '删除角色权限', '删除角色权限', '/role/permission/del', 71, 0, 0),
	(74, '权限管理', '权限管理', '/permission/list', 0, 1, 1),
	(75, '添加权限', '添加权限', '/permission/add', 74, 0, 0),
	(76, '删除权限', '删除权限', '/permission/del', 74, 0, 0),
	(77, '修改权限', '修改权限', '/permission/update', 74, 0, 0),
	(78, '权限资源管理', '权限资源管理', '/permission/resources/list', 74, 1, 1),
	(79, '权限资源添加', '权限资源添加', '/permission/resources/add', 78, 0, 0),
	(80, '权限资源删除', '权限资源删除', '/permission/resources/del', 78, 0, 0),
	(81, '资源管理', '资源管理', '/resources/list', 0, 1, 1),
	(82, '添加资源', '添加资源', '/resources/add', 81, 0, 0),
	(83, '删除资源', '删除资源', '/resources/del', 81, 0, 0),
	(88, '菜单管理', '菜单管理', '/permission/menu/list', 0, 1, 1),
	(89, '添加菜单', '添加菜单', '/permission/menu/add', 88, 0, 0),
	(90, '删除菜单', '删除菜单', '/permission/menu/del', 88, 0, 0),
	(93, '修改菜单', '修改菜单', '/permission/menu/update', 88, 0, 0),
	(95, '用户管理', '用户管理', '/user/list', 0, 1, 1),
	(96, '添加用户', '添加用户', '/user/add', 95, 0, 0),
	(97, '删除用户', '删除用户', '/user/del', 95, 0, 0),
	(98, '修改用户', '修改用户', '/user/update', 95, 0, 0),
	(100, '文章管理', '文章管理', '/post/list', 0, 1, 1),
	(101, '添加文章', '添加文章', '/post/add', 100, 0, 0),
	(102, '删除文章', '删除文章', '/post/del', 100, 0, 0),
	(103, '修改文章', '修改文章', '/post/update', 100, 0, 0),
	(104, '标签管理', '标签管理', '/tag/list', 0, 1, 1),
	(105, '增加标签', '增加标签', '/tag/add', 104, 0, 0),
	(106, '删除标签', '删除标签', '/tag/del', 104, 0, 0),
	(107, '修改标签', '修改标签', '/tag/update', 104, 0, 0);
/*!40000 ALTER TABLE `sl_permission` ENABLE KEYS */;

-- 导出  表 sinitial.sl_post 结构
CREATE TABLE IF NOT EXISTS `sl_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(30) DEFAULT NULL,
  `post_status` varchar(30) DEFAULT NULL,
  `post_type` varchar(30) DEFAULT NULL,
  `post_author` int(11) DEFAULT NULL,
  `post_content` longtext DEFAULT NULL,
  `post_mime_type` varchar(30) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  UNIQUE KEY `sl_post_post_id_uindex` (`post_id`),
  KEY `sl_post_sl_author_author_id_fk` (`post_author`),
  CONSTRAINT `sl_post_sl_author_author_id_fk` FOREIGN KEY (`post_author`) REFERENCES `sl_author` (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_post 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sl_post` DISABLE KEYS */;
INSERT INTO `sl_post` (`post_id`, `post_title`, `post_status`, `post_type`, `post_author`, `post_content`, `post_mime_type`, `post_date`) VALUES
	(1, '魔理沙の日常', 'publish', 'post', 1, '是咱赢了', '', '2016-08-09 08:33:45'),
	(6, '9の日常', 'publish', 'post', 2, '提问，9是什么？', '', '2017-08-04 00:04:02'),
	(10, '9の日常', 'publish', 'post', 2, '提问，9是什么？', '', '2017-08-05 11:35:07');
/*!40000 ALTER TABLE `sl_post` ENABLE KEYS */;

-- 导出  表 sinitial.sl_post_tag 结构
CREATE TABLE IF NOT EXISTS `sl_post_tag` (
  `post_tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`post_tag_id`),
  UNIQUE KEY `sl_post_tag_post_tag_id_uindex` (`post_tag_id`),
  KEY `sl_post_tag_sl_post_post_id_fk` (`post_id`),
  KEY `sl_post_tag_sl_tag_tag_id_fk` (`tag_id`),
  CONSTRAINT `sl_post_tag_sl_post_post_id_fk` FOREIGN KEY (`post_id`) REFERENCES `sl_post` (`post_id`),
  CONSTRAINT `sl_post_tag_sl_tag_tag_id_fk` FOREIGN KEY (`tag_id`) REFERENCES `sl_tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_post_tag 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sl_post_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `sl_post_tag` ENABLE KEYS */;

-- 导出  表 sinitial.sl_role 结构
CREATE TABLE IF NOT EXISTS `sl_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  `role_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `sl_role_role_id_uindex` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_role 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sl_role` DISABLE KEYS */;
INSERT INTO `sl_role` (`role_id`, `role_name`, `role_info`) VALUES
	(1, 'root', 'BOSS'),
	(2, 'author', '上帝'),
	(5, 'admin', '权限狗'),
	(6, 'test001', '001');
/*!40000 ALTER TABLE `sl_role` ENABLE KEYS */;

-- 导出  表 sinitial.sl_role_permission 结构
CREATE TABLE IF NOT EXISTS `sl_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sl_role_permission_id_uindex` (`id`),
  KEY `sl_role_permission_sl_role_role_id_fk` (`role_id`),
  KEY `sl_role_permission_sl_permission_permission_id_fk` (`permission_id`),
  CONSTRAINT `sl_role_permission_sl_permission_permission_id_fk` FOREIGN KEY (`permission_id`) REFERENCES `sl_permission` (`permission_id`),
  CONSTRAINT `sl_role_permission_sl_role_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `sl_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=444 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_role_permission 的数据：~57 rows (大约)
/*!40000 ALTER TABLE `sl_role_permission` DISABLE KEYS */;
INSERT INTO `sl_role_permission` (`id`, `role_id`, `permission_id`) VALUES
	(249, 2, 60),
	(250, 2, 81),
	(251, 2, 82),
	(252, 2, 83),
	(253, 2, 100),
	(254, 2, 101),
	(255, 2, 102),
	(256, 2, 103),
	(257, 2, 104),
	(258, 2, 105),
	(259, 2, 106),
	(260, 2, 107),
	(381, 1, 60),
	(382, 1, 67),
	(383, 1, 68),
	(384, 1, 69),
	(385, 1, 70),
	(386, 1, 71),
	(387, 1, 72),
	(388, 1, 73),
	(392, 1, 74),
	(393, 1, 75),
	(394, 1, 76),
	(395, 1, 77),
	(396, 1, 78),
	(397, 1, 79),
	(398, 1, 80),
	(399, 1, 81),
	(400, 1, 82),
	(401, 1, 83),
	(402, 1, 88),
	(403, 1, 89),
	(404, 1, 90),
	(405, 1, 93),
	(406, 1, 95),
	(407, 1, 64),
	(408, 1, 65),
	(409, 1, 66),
	(410, 1, 96),
	(411, 1, 97),
	(412, 1, 98),
	(413, 1, 100),
	(414, 1, 101),
	(415, 1, 102),
	(416, 1, 103),
	(417, 1, 104),
	(418, 1, 105),
	(419, 1, 106),
	(420, 1, 107),
	(421, 6, 60),
	(422, 6, 67),
	(423, 6, 68),
	(424, 6, 69),
	(425, 6, 70),
	(426, 6, 71),
	(427, 6, 72),
	(428, 6, 73);
/*!40000 ALTER TABLE `sl_role_permission` ENABLE KEYS */;

-- 导出  表 sinitial.sl_tag 结构
CREATE TABLE IF NOT EXISTS `sl_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `sl_tag_tag_id_uindex` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_tag 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sl_tag` DISABLE KEYS */;
INSERT INTO `sl_tag` (`tag_id`, `tag_name`) VALUES
	(1, 'IDEA'),
	(2, 'Java'),
	(3, '算法');
/*!40000 ALTER TABLE `sl_tag` ENABLE KEYS */;

-- 导出  表 sinitial.sl_user 结构
CREATE TABLE IF NOT EXISTS `sl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `nick_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` int(11) NOT NULL,
  `sign_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `user_role` int(11) NOT NULL,
  `user_info` varchar(300) DEFAULT NULL,
  `headshot` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_userId_uindex` (`user_id`),
  KEY `sl_user_sl_role_role_id_fk` (`user_role`),
  CONSTRAINT `sl_user_sl_role_role_id_fk` FOREIGN KEY (`user_role`) REFERENCES `sl_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sl_user` DISABLE KEYS */;
INSERT INTO `sl_user` (`user_id`, `user_name`, `user_password`, `nick_name`, `email`, `gender`, `sign_date`, `user_role`, `user_info`, `headshot`) VALUES
	(2, 'test2', '1234', 'test2', 'whofawea@gmail.com', 0, '2017-09-05 17:04:09', 1, 'test', '201709021458499212.gif'),
	(4, '魔理沙', '1234', '魔理沙', '233@gmail.com', 1, '2017-09-05 17:04:09', 2, '魔法使', '201709021610015278.gif'),
	(5, '红白', '1234', '红白', 'jc@gmail.com', 1, '2017-09-05 17:04:09', 1, '巫女', '201709021628370497.gif'),
	(6, '阿卡林', '1234', '阿卡林', 'nekuata@gmail.com', 1, '2017-09-05 17:04:09', 1, '不存在', '201709021712391033.gif');
/*!40000 ALTER TABLE `sl_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
