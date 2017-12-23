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

-- 正在导出表  sinitial.sl_permission 的数据：~37 rows (大约)
/*!40000 ALTER TABLE `sl_permission` DISABLE KEYS */;
INSERT INTO `sl_permission` (`permission_id`, `permission_name`, `description`, `url`, `parent_id`, `is_parent`, `is_menu`) VALUES
	(60, '登陆管理', NULL, '/login', 0, 0, 0),
	(64, '用户角色管理', '用户角色', '/user/role/list', 95, 1, 0),
	(65, '添加用户角色', '添加用户角色', '/user/role/add', 64, 0, 0),
	(66, '删除用户角色', '删除用户角色', '/user/role/del', 64, 0, 0),
	(67, '角色管理', '角色管理', '/role/list', 0, 1, 1),
	(68, '添加角色', '添加角色', '/role/add', 67, 0, 0),
	(69, '删除角色', '删除角色', '/role/del', 67, 0, 0),
	(70, '修改角色', '修改角色', '/role/update', 67, 0, 0),
	(71, '角色权限', '角色权限', '/role/permission/list', 67, 1, 0),
	(72, '添加角色权限', '添加角色权限', '/role/permission/add', 71, 0, 0),
	(73, '删除角色权限', '删除角色权限', '/role/permission/del', 71, 0, 0),
	(74, '权限管理', '权限管理', '/permission/list', 0, 1, 1),
	(75, '添加权限', '添加权限', '/permission/add', 74, 0, 0),
	(76, '删除权限', '删除权限', '/permission/del', 74, 0, 0),
	(77, '修改权限', '修改权限', '/permission/update', 74, 0, 0),
	(78, '权限资源管理', '权限资源管理', '/permission/resources/list', 74, 1, 0),
	(79, '权限资源添加', '权限资源添加', '/permission/resources/add', 78, 0, 0),
	(80, '权限资源删除', '权限资源删除', '/permission/resources/del', 78, 0, 0),
	(81, '资源管理', '资源管理', '/resources/list', 0, 1, 0),
	(82, '添加资源', '添加资源', '/resources/add', 81, 0, 0),
	(83, '删除资源', '删除资源', '/resources/del', 81, 0, 0),
	(88, '菜单管理', '菜单管理', '/permission/menu/list', 0, 1, 0),
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_post 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sl_post` DISABLE KEYS */;
INSERT INTO `sl_post` (`post_id`, `post_title`, `post_status`, `post_author`, `post_content`, `post_mime_type`, `post_date`, `post_type`) VALUES
	(1, 'lambda 表达式', 'publish', 2, 'jdk 1.8中的一个重要改进就是引入了lambda表达式，这是种可传递的代码块，可以多次执行。接下来咱们就说说lambda表达式の存在意义和简明用法。\r\nPS. 至于读法，咱就给个小提示：这是个希腊字母(λ)。\r\n\r\n## 1. lambda表达式の存在意义\r\n\r\n在以前我们想实现一个功能，比如说交换两个int型整数a&amp;b，你可能会使用以下语句：\r\n\r\n```java\r\na = a + b;\r\nb = a - b;\r\na = a - b;\r\n```\r\nor\r\n```java\r\na = a^b;\r\nb = a^b;\r\na = a^b;\r\n```\r\n\r\n未完待续~', 'article', '2017-09-27 01:31:50', 'jdk 1.8中的一个重要改进就是引入了lambda表达式，这是种可传递的代码块，可以多次执行。接下来咱们就说说lambda表达式の存在意义和简明用法。\r\nPS. 至于读法，咱就给个小提示：这是个希腊字母(λ)。'),
	(2, 'I/O流：文件上传下载', 'publish', 2, '上一次咱说到了Java的I/O流操作，那么为了加深印象，接下来我们就做个简易版的网盘系统。\r\n\r\n用户界面基于jsp和servlet实现，不懂的同学可以看看咱之前的文章。\r\n\r\n## 1. 文件上传\r\n\r\n### 1.1. 准备工作\r\n\r\nAs we know，在网页中上传文件需要用`<input type="fileDemo">`来实现，然后用form表单的enctype=multipart/form-data属性来告诉浏览器，咱上传的是个文件，你要帮我转成二进制上传到服务器，数据流中包含文件的属性和内容。\r\n\r\n然而本文说的只是I/O流的小练习，具体过程就交给开源库处理，在此不再赘述。\r\n\r\njava中常用的来自Apache的开源工具commons-fileupload实现上传功能，它依赖于commons-io，在开始之前我们先下载这两个jar包，导入项目：\r\n- 下载上面两个jar包，可以用Google搜索Maven commons-fileupload下载最新版\r\n- 打开File > Project Structure\r\n- 在Modules中导入jar包，下方会有提示发布目录缺少jar包，fix一下或手动导入即可\r\n\r\n### 1.2. mariaDB数据库配置\r\n\r\n虽然使用Java里的Map等集合也能当作文件目录，但程序结束后内存中的数据也会丢失，为了下次使用还能找回数据，我们可以将文件目录数据实时保存到一个本地文件或直接存到数据库中，这里用的是MariaDB。\r\n\r\nMariaDB基于MySQL并遵循GPL v2授权使用的，mysql的完美替代品，有更多更好的新特性。\r\n\r\n先来建个表：\r\n\r\n```mysql\r\n-- auto-generated definition\r\ncreate table <数据库名>.file#_catalog\r\n(\r\n	id int auto#_increment primary key,\r\n	name varchar(32) not null,\r\n	date datetime not null,\r\n	constraint file#_catalog#_id#_uindex unique (id),\r\n	constraint file#_catalog#_name#_uindex unique (name)\r\n);\r\n```\r\n其中id是主键，name是文件名。\r\n\r\n### 1.3. file类\r\n\r\n为了方便起见，我们还要在java项目中写个文件类，用于临时存放文件属性，比如名称，大小，上传时间什么的。\r\n\r\n代码如下：\r\n\r\n```java\r\n//    文件类的私有属性，与mariaDB相对应\r\n    private int id;\r\n    private String name;\r\n    private Date date;\r\n    \r\n```\r\n有了文件类，接下来还要想办法把里面的数据存入数据库。在MVC设计模式中，Dao层直接操作数据库，Service层处理数据并通过Dao层存取数据库\r\n\r\n### 1.4. HTML代码\r\n\r\n用户交互界面咱用的是jsp，有上传、下载、删除、文件列表等功能，时间允许的话还会加上翻页。\r\n\r\n简易的jsp代码如下，用于测试：\r\n\r\n```html\r\n\r\n```\r\n\r\n\r\n## 2. 文件下载\r\n\r\n未完待续~', 'article', '2017-09-27 00:11:26', '上一次咱说到了Java的I/O流操作，那么为了加深印象，接下来我们就做个简易版的网盘系统。\r\n\r\n用户界面基于jsp和servlet实现，不懂的同学可以看看咱之前的文章。'),
	(3, '关于本博客的食用说明（详见gayhub）', 'publish', 2, '作为一个~~轻量级~~小巧的博客系统，本项目采用Spring+Spring-mvc+Mybatis构建。\r\n\r\n> Q: SSM轻量级？吾阅诗书甚少，你不要骗我。\r\n> A: 捂脸(*/ω＼*)，找工作需要嘛！所谓轻量是指对Java程序员而言。PS. 隔壁sgroup第一个项目没用任何框架，初学者可以拿去参考。\r\n\r\n> Q: 那你这个意义何在？\r\n> A: 自用，下面有食用说明。本项目的优点之一就是代码超规范（见名知意，参考alibaba的那本手册），注释超详细（覆盖率超过90%），RESTful风格API，二次开发也超轻松。\r\n\r\n```\r\nPS. 不懂java也没关系，可以直接跳到食用说明，理论上没问题！（有问题发issue）\r\n```\r\n\r\n本项目基于maven的标准目录结构，使用maven构建；框架是Spring，MVC框架是Spring-mvc，数据库是MariaDB，持久化是Mybatis，权限管理是自制的，如下所示：\r\n\r\nTODO 正在用Spring-boot写一个图床工具，搞定之后再来把这个也改成Spring-boot。\r\n\r\n```shell=\r\nsrc\r\n└─main\r\n    ├─java\r\n    │  └─com\r\n    │      └─sinitial\r\n    │          ├─aop\r\n    │          ├─controller\r\n    │          ├─dao\r\n    │          ├─domain\r\n    │          ├─interception\r\n    │          ├─service\r\n    │          │  └─Implement\r\n    │          └─utils\r\n    ├─notebook\r\n    ├─resources\r\n    │  ├─mybatis\r\n    │  │  ├─mariadb\r\n    │  │  └─oracle\r\n    │  └─spring\r\n    ├─test\r\n    └─webapp\r\n```\r\n\r\n本项目采用mvc架构，前端部分同时使用jsp和freemarker，目录结构如下：\r\n\r\nTODO 后续会将jsp全部改成freemarker，以配合Spring-boot和RESTful API实现前后端分离。\r\n\r\n```shell=\r\nwebapp\r\n├─META-INF\r\n├─resources\r\n│  ├─bootstrap-3.0\r\n│  │  ├─css\r\n│  │  ├─extension\r\n│  │  │  ├─bootbox\r\n│  │  │  └─datetimepicker\r\n│  │  │      ├─css\r\n│  │  │      └─js\r\n│  │  └─js\r\n│  ├─bootstrap-4.0.0-beta\r\n│  │  ├─css\r\n│  │  └─js\r\n│  ├─dataTables\r\n│  │  ├─css\r\n│  │  ├─images\r\n│  │  └─js\r\n│  ├─font-awesome-4.7.0\r\n│  │  ├─css\r\n│  │  └─fonts\r\n│  ├─img\r\n│  ├─jquery\r\n│  ├─panel\r\n│  │  ├─css\r\n│  │  └─js\r\n│  ├─post\r\n│  │  ├─css\r\n│  │  └─js\r\n│  ├─role\r\n│  │  ├─css\r\n│  │  └─js\r\n│  ├─showdown\r\n│  ├─user\r\n│  │  ├─css\r\n│  │  └─js\r\n│  └─ztree\r\n│      ├─css\r\n│      │  └─img\r\n│      └─js\r\n└─WEB-INF\r\n    ├─ftl\r\n    │  ├─surface\r\n    │  └─tag\r\n    └─jsp\r\n        ├─panel\r\n        ├─permission\r\n        ├─post\r\n        ├─role\r\n        └─user\r\n```\r\n\r\n食（shi）用（du）方法如下所述。\r\n\r\n## 1. 环境配置\r\n\r\n部署环境的配置如下（阿里云友情提供）：\r\n\r\nCPU： 1核\r\n\r\n内存： 1 GB\r\n\r\n硬盘： 40 GB\r\n\r\n操作系统： Ubuntu 16.04 64位\r\n\r\n### 1.1. 安装openjdk\r\n\r\n更新软件列表：\r\n\r\n```shell=\r\nroot@akari:~# apt update\r\n```\r\n\r\n安装openjdk-8-jdk：\r\n\r\n```shell=\r\nroot@akari:~# apt install openjdk-8-jdk -y\r\n```\r\n\r\n检查，成功则返回版本号：\r\n\r\n```shell=\r\nroot@akari:~# java -version\r\n```\r\n\r\n### 1.2. 安装git\r\n\r\n```shell=\r\nroot@akari:~# apt install git -y\r\n```\r\n\r\n检查git是否安装成功；输入如下命令，安装成功返回版本号。\r\n\r\n```shell=\r\nroot@akari:~# git --version\r\ngit version 2.7.4\r\n```\r\n\r\n### 1.3. 配置maven\r\n\r\n先下载最新版[maven](https://maven.apache.org/download.cgi)，右键Binary tar.gz archive获取下载地址，输入如下命令下载maven：\r\n\r\n```shell=\r\nroot@akari:~# cd /home\r\nroot@akari:/home# wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz\r\n# 解压\r\nroot@akari:/home# tar -zxvf apache-maven-3.5.0-bin.tar.gz\r\n```\r\n\r\n添加环境变量：\r\n\r\n```shell=\r\nroot@akari:/home# vim /etc/profile\r\n```\r\n\r\n在最后加上这些：\r\n\r\n```shell=\r\nMAVEN_HOME=/home/apache-maven-3.5.0\r\nexport MAVEN_HOME\r\nexport PATH=${PATH}:${MAVEN_HOME}/bin\r\n```\r\n\r\n保存，退出后重载文件：\r\n\r\n```shell=\r\nroot@akari:/home# source /etc/profile\r\n```\r\n\r\n验证maven配置，成功则返回版本号：\r\n\r\n```shell=\r\nroot@akari:/home# mvn -v\r\nApache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-04T03:39:06+08:00)\r\nMaven home: /home/apache-maven-3.5.0\r\nJava version: 1.8.0_131, vendor: Oracle Corporation\r\nJava home: /usr/lib/jvm/java-8-openjdk-amd64/jre\r\nDefault locale: en_US, platform encoding: UTF-8\r\nOS name: "linux", version: "4.4.0-47-generic", arch: "amd64", family: "unix"\r\n```\r\n\r\n### 1.4. 配置tomcat\r\n\r\n在这儿获取最新版[tomcat](http://tomcat.apache.org/download-90.cgi)下载地址（core版本的tar.gz），如下：\r\n\r\n```shell=\r\nroot@akari:~# cd /home\r\nroot@akari:/home# wget http://mirrors.shuosc.org/apache/tomcat/tomcat-9/v9.0.0.M26/bin/apache-tomcat-9.0.0.M26.tar.gz\r\n# 解压\r\nroot@akari:/home# tar -zxvf apache-tomcat-9.0.0.M26.tar.gz\r\n```\r\n\r\n启动tomcat：\r\n\r\n```shell=\r\nroot@akari:/home# sh apache-tomcat-9.0.0.M26/bin/startup.sh\r\nUsing CATALINA_BASE:   /home/apache-tomcat-9.0.0.M26\r\nUsing CATALINA_HOME:   /home/apache-tomcat-9.0.0.M26\r\nUsing CATALINA_TMPDIR: /home/apache-tomcat-9.0.0.M26/temp\r\nUsing JRE_HOME:        /usr\r\nUsing CLASSPATH:       /home/apache-tomcat-9.0.0.M26/bin/bootstrap.jar:/home/apache-tomcat-9.0.0.M26/bin/tomcat-juli.jar\r\nTomcat started.\r\n```\r\n### 1.5. 安装mariaDB数据库\r\n\r\nMariaDB是MySQL源代码的一个分支，在意识到Oracle会对MySQL许可做什么后分离了出来（有闭源的潜在风险）。作者Michael Widenius Monty也是Mysql创办者。MariaDB目的是完全兼容Mysql，也包括一些新特性优于MySQL。\r\n\r\n直接apt安装：\r\n\r\n```shell=\r\nroot@akari:/home# apt install mariadb-server -y\r\n```\r\nTo Be Continue...', 'article', '2017-08-04 00:04:02', '作为一个~~轻量级~~小巧的博客系统，本项目采用Spring+Spring-mvc+Mybatis构建。\r\n\r\n> Q: SSM轻量级？吾阅诗书甚少，你不要骗我。\r\n\r\n> A: 捂脸(*/ω＼*)，找工作需要嘛！所谓轻量是指对Java程序员而言。PS. 隔壁sgroup第一个项目没用任何框架，初学者可以拿去参考。\r\n\r\n> Q: 那你这个意义何在？\r\n\r\n> A: 自用，下面有食用说明。本项目的优点之一就是代码超规范（见名知意，参考alibaba的那本手册），注释超详细（覆盖率超过90%），RESTful风格API，二次开发也超轻松。\r\n\r\n```\r\nPS. 不懂java也没关系，可以直接跳到食用说明，理论上没问题！（有问题发issue）\r\n```'),
	(4, '快速排序の日常', 'publish', 2, '想象一个场景：有n本不相同的书，咱想把这些书按从高到低的顺序摆到书架上，以可靠的方式，如何操作？\r\n\r\n> 依次比较相邻书本的高度（从左至右依次名为1号~n号，若2号比1号高，则交换两者位置和序号；若1号比2号高，则不动。然后2号继续跟3号比较），直到最右。此时最右是最低的书，拿开，对剩下的书循环上述过程即可完成排序。\r\n\r\n此乃冒泡排序法，相信没人会这么干，那有没有更快的操作呢？\r\n\r\n> 随便选一本书，比这本书高的放左边，低的放右边；完成后以刚才选中的书为界分为2个部分；对每部分重复上述操作后划分为4部分；以此类推，直到每部分只有一本书，排序达成。\r\n\r\n此乃快速排序法，采用了分治的思想，分治法（Divide and conquer）用来将一个序列（list）分为两个子序列（sub-lists）。每次操作的对象比前一次少一半还多，效率远高于冒泡。\r\n\r\n快速排序最早由东尼·霍尔在1962提出。在平均状况下，排序n个项目要`Ο(N*logN)`次比较。在最坏状况下则需要`O`次比较，但这种状况并不常见。\r\n\r\n具体步骤为：\r\n\r\n1. 从数列中挑出一个元素，称为"基准"（pivot），\r\n2. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。\r\n3. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。\r\n\r\n递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。\r\n\r\n那么就决定是你了！回到现实，咱这里有个数组需要排序，那么如何将此方法用Java实现呢？\r\n\r\n```java\r\n// 快速排序\r\npublic int[] quickSort(int[] numbers, int low, int high) {\r\n    // 钦点中间为基准数\r\n    int pivot = numbers[low + (high - low) / 2];\r\n    // 默认为0\r\n    int i = low;\r\n    // 默认为数组长度-1\r\n    int j = high;\r\n    while (i <= j) {\r\n        while (numbers[i] < pivot) {\r\n            i++;\r\n        }\r\n        while (numbers[j] > pivot) {\r\n            j--;\r\n        }\r\n        if (i <= j) {\r\n            int temp = numbers[i];\r\n            numbers[i] = numbers[j];\r\n            numbers[j] = temp;\r\n            i++;\r\n            j--;\r\n        }\r\n    }\r\n    // 划分小区间，递归\r\n    if (i < high) {\r\n        quickSort(numbers, i, high);\r\n    }\r\n    if (low < j) {\r\n        quickSort(numbers, low, j);\r\n    }\r\n    return numbers;\r\n}\r\n```\r\n以上是最简单的写法，钦点基准数，采用递归实现。\r\n\r\n未完待续~', 'article', '2017-09-24 17:58:58', '想象一个场景：有n本不相同的书，咱想把这些书按从高到低的顺序摆到书架上，以可靠的方式，如何操作？\r\n\r\n> 依次比较相邻书本的高度（从左至右依次名为1号~n号，若2号比1号高，则交换两者位置和序号；若1号比2号高，则不动。然后2号继续跟3号比较），直到最右。此时最右是最低的书，拿开，对剩下的书循环上述过程即可完成排序。\r\n\r\n此乃冒泡排序法，相信没人会这么干，那有没有更快的操作呢？\r\n\r\n> 随便选一本书，比这本书高的放左边，低的放右边；完成后以刚才选中的书为界分为2个部分；对每部分重复上述操作后划分为4部分；以此类推，直到每部分只有一本书，排序达成。\r\n\r\n此乃快速排序法，采用了分治的思想，分治法（Divide and conquer）用来将一个序列（list）分为两个子序列（sub-lists）。每次操作的对象比前一次少一半还多，效率远高于冒泡。');
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
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_post_tag 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `sl_post_tag` DISABLE KEYS */;
INSERT INTO `sl_post_tag` (`post_tag_id`, `post_id`, `tag_id`) VALUES
	(143, 11, 3),
	(144, 11, 2),
	(160, 6, 5),
	(161, 6, 12),
	(162, 6, 2),
	(165, 10, 3),
	(166, 10, 1),
	(171, 1, 12),
	(172, 1, 3);
/*!40000 ALTER TABLE `sl_post_tag` ENABLE KEYS */;

-- 导出  表 sinitial.sl_role 结构
CREATE TABLE IF NOT EXISTS `sl_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  `role_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `sl_role_role_id_uindex` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sl_role` DISABLE KEYS */;
INSERT INTO `sl_role` (`role_id`, `role_name`, `role_info`) VALUES
	(1, 'root', 'BOSS'),
	(2, 'author', '上帝'),
	(5, 'admin', '管理员');
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
) ENGINE=InnoDB AUTO_INCREMENT=537 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_role_permission 的数据：~65 rows (大约)
/*!40000 ALTER TABLE `sl_role_permission` DISABLE KEYS */;
INSERT INTO `sl_role_permission` (`id`, `role_id`, `permission_id`) VALUES
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
	(508, 2, 60),
	(509, 2, 81),
	(510, 2, 82),
	(511, 2, 83),
	(512, 2, 100),
	(513, 2, 101),
	(514, 2, 102),
	(515, 2, 103),
	(516, 2, 104),
	(517, 2, 105),
	(518, 2, 106),
	(519, 2, 107),
	(520, 5, 60),
	(521, 5, 81),
	(522, 5, 82),
	(523, 5, 83),
	(524, 5, 88),
	(525, 5, 89),
	(526, 5, 90),
	(527, 5, 93),
	(528, 5, 100),
	(529, 5, 101),
	(530, 5, 102),
	(531, 5, 103),
	(532, 5, 104),
	(533, 5, 105),
	(534, 5, 106),
	(535, 5, 107);
/*!40000 ALTER TABLE `sl_role_permission` ENABLE KEYS */;

-- 导出  表 sinitial.sl_tag 结构
CREATE TABLE IF NOT EXISTS `sl_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `sl_tag_tag_id_uindex` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_tag 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `sl_tag` DISABLE KEYS */;
INSERT INTO `sl_tag` (`tag_id`, `tag_name`) VALUES
	(1, 'IDEA'),
	(2, 'Java'),
	(3, '算法'),
	(5, '测试'),
	(10, '线程'),
	(12, '日常'),
	(13, '动漫');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  sinitial.sl_user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sl_user` DISABLE KEYS */;
INSERT INTO `sl_user` (`user_id`, `user_name`, `user_password`, `nick_name`, `email`, `gender`, `sign_date`, `user_role`, `user_info`, `headshot`) VALUES
	(2, 'test', '1234', '阿卡林', 'root@meowwoo.com', 0, '2017-11-14 17:28:25', 1, '你就不再问我签订契约的事？', '201711141724542402.jpg');
/*!40000 ALTER TABLE `sl_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
