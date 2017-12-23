-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.2.8-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 sinitial 的数据库结构
CREATE DATABASE IF NOT EXISTS `sinitial` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sinitial`;

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
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sinitial.sl_post 结构
CREATE TABLE IF NOT EXISTS `sl_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(100) DEFAULT NULL,
  `post_status` varchar(30) DEFAULT NULL,
  `post_author` int(11) DEFAULT NULL,
  `post_content` longtext DEFAULT NULL,
  `post_mime_type` varchar(30) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `post_type` varchar(6666) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  UNIQUE KEY `sl_post_post_id_uindex` (`post_id`),
  KEY `sl_post_sl_user_user_id_fk` (`post_author`),
  CONSTRAINT `sl_post_sl_user_user_id_fk` FOREIGN KEY (`post_author`) REFERENCES `sl_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sinitial.sl_role 结构
CREATE TABLE IF NOT EXISTS `sl_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  `role_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `sl_role_role_id_uindex` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
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
) ENGINE=InnoDB AUTO_INCREMENT=452 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 sinitial.sl_tag 结构
CREATE TABLE IF NOT EXISTS `sl_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `sl_tag_tag_id_uindex` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
