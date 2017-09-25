# sinitial-blog 食用说明书

作为一个~~轻量级~~小巧的博客系统，本项目采用Spring+Spring-mvc+Mybatis构建。

Q: SSM轻量级？吾阅诗书甚少，你不要骗我。
A: 捂脸(*/ω＼*)，找工作需要嘛！SSM框架。PS. 隔壁sgroup第一个项目没用任何框架，初学者可以拿去参考。

Q: 那你这个意义何在？
A: 自用，下面有食用说明。本项目的优点之一就是代码超规范（见名知意，参考alibaba的那本手册），注释超详细（覆盖率超过90%），RESTful风格API，二次开发也超轻松。
```
PS. 不懂java也没关系，可以直接跳到食用说明，理论上没问题！（有问题发issue）
```
Windows系统配置要求如下：

<table>
	<thead>
		<tr>
			<th scope="row" style="width: 122.222px;"></th>
			<th scope="col" style="width: 244.444px;">最低配置</th>
			<th scope="col" style="width: 243.333px;">推荐配置</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">操作系统</th>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Windows® 7 / Windows® 8 / Windows® 10 64位系统 (或最新版本的 Service Pack)</span></div>
			</td>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Windows® 7 / Windows® 8 / Windows® 10 64位系统(最新版本的Service Pack)</span></div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">处理器</div>
			</th>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Intel® Core™ i3或是 AMD Phenom™ X3 8650</span></div>
			</td>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Intel® Core™ i9-7980XE或 AMD Ryzen™ ThreadRipper 1950X 处理器及以上</span></div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">显卡</div>
			</th>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">NVIDIA® GeForce® GTX 460,&nbsp;ATI Radeon™ HD 4850, 或是 Intel® HDGraphics 4400</span></div>
			</td>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">NVIDIA® GeForce® GTX 1080Ti or AMD Radeon™ R9 Fury 或以上</span></div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">内存</div>
			</th>
			<td>
			<div class="centered">4 GB RAM</div>
			</td>
			<td>
			<div class="centered">64 GB RAM</div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">储存空间</div>
			</th>
			<td colspan="2" rowspan="1">
			<div class="centered">30 GB 硬件空间</div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">网络</div>
			</th>
			<td colspan="2" rowspan="1">
			<div class="centered">宽带网络</div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">媒体</div>
			</th>
			<td colspan="2" rowspan="1">
			<div class="centered">无特殊需求</div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">分辨率</div>
			</th>
			<td colspan="2" rowspan="1">
			<div class="centered">最低 1024 x 768</div>
			</td>
		</tr>
	</tbody>
</table>

PS. 你至少知道了下一台主机的配件表，也不是白来一趟嘛！（有话好好说，别打脸）

本项目基于maven的标准目录结构，使用maven构建；框架是Spring，MVC框架是Spring-mvc，数据库是MariaDB，持久化是Mybatis，权限管理是自制的，如下所示：
TODO 正在用Spring-boot写一个图床工具，搞定之后再来把这个也改成Spring-boot。

```shell=
src
└─main
    ├─java
    │  └─com
    │      └─sinitial
    │          ├─aop
    │          ├─controller
    │          ├─dao
    │          ├─domain
    │          ├─interception
    │          ├─service
    │          │  └─Implement
    │          └─utils
    ├─notebook
    ├─resources
    │  ├─mybatis
    │  │  ├─mariadb
    │  │  └─oracle
    │  └─spring
    ├─test
    └─webapp
```

本项目采用mvc架构，前端部分同时使用jsp和freemarker，目录结构如下：
TODO 后续会将jsp全部改成freemarker，以配合Spring-boot和RESTful API实现前后端分离。

```shell=
webapp
├─META-INF
├─resources
│  ├─bootstrap-3.0
│  │  ├─css
│  │  ├─extension
│  │  │  ├─bootbox
│  │  │  └─datetimepicker
│  │  │      ├─css
│  │  │      └─js
│  │  └─js
│  ├─bootstrap-4.0.0-beta
│  │  ├─css
│  │  └─js
│  ├─dataTables
│  │  ├─css
│  │  ├─images
│  │  └─js
│  ├─font-awesome-4.7.0
│  │  ├─css
│  │  └─fonts
│  ├─img
│  ├─jquery
│  ├─panel
│  │  ├─css
│  │  └─js
│  ├─post
│  │  ├─css
│  │  └─js
│  ├─role
│  │  ├─css
│  │  └─js
│  ├─showdown
│  ├─user
│  │  ├─css
│  │  └─js
│  └─ztree
│      ├─css
│      │  └─img
│      └─js
└─WEB-INF
    ├─ftl
    │  ├─surface
    │  └─tag
    └─jsp
        ├─panel
        ├─permission
        ├─post
        ├─role
        └─user
```

食（shi）用（du）方法如下所述。

## 1. 环境配置

测试环境的配置如下：

CPU： 1核
内存： 1 GB
硬盘： 40 GB
操作系统： Ubuntu 16.04 64位

### 1.1. 安装openjdk

更新软件列表：

```shell=
root@akari:~# apt update
```

安装openjdk-8-jdk：

```shell=
root@akari:~# apt install openjdk-8-jdk -y
```

检查，成功则返回版本号：

```shell=
root@akari:~# java -version
```

### 1.2. 安装git

```shell=
root@akari:~# apt install git -y
```

检查git是否安装成功；输入如下命令，安装成功返回版本号。

```shell=
root@akari:~# git --version
git version 2.7.4
```

### 1.3. 配置maven

先下载最新版[maven](https://maven.apache.org/download.cgi)，右键Binary tar.gz archive获取下载地址，输入如下命令下载maven：

```shell=
root@akari:~# cd /home
root@akari:/home# wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz
# 解压
root@akari:/home# tar -zxvf apache-maven-3.5.0-bin.tar.gz
```

添加环境变量：

```shell=
root@akari:/home# vim /etc/profile
```

在最后加上这些：

```shell=
MAVEN_HOME=/home/apache-maven-3.5.0
export MAVEN_HOME
export PATH=${PATH}:${MAVEN_HOME}/bin
```

保存，退出后重载一下：

```shell=
root@akari:/home# source /etc/profile
```

验证maven配置，成功则返回版本号：

```shell=
root@akari:/home# mvn -v
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-04T03:39:06+08:00)
Maven home: /home/apache-maven-3.5.0
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-openjdk-amd64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.4.0-47-generic", arch: "amd64", family: "unix"
```

### 1.4. 配置tomcat

在这儿获取最新版[tomcat](http://tomcat.apache.org/download-90.cgi)下载地址（core版本的tar.gz），如下：

```shell=
root@akari:~# cd /home
root@akari:/home# wget http://mirrors.shuosc.org/apache/tomcat/tomcat-9/v9.0.0.M26/bin/apache-tomcat-9.0.0.M26.tar.gz
# 解压
root@akari:/home# tar -zxvf apache-tomcat-9.0.0.M26.tar.gz
```

启动tomcat：

```shell=
root@akari:/home# sh apache-tomcat-9.0.0.M26/bin/startup.sh
Using CATALINA_BASE:   /home/apache-tomcat-9.0.0.M26
Using CATALINA_HOME:   /home/apache-tomcat-9.0.0.M26
Using CATALINA_TMPDIR: /home/apache-tomcat-9.0.0.M26/temp
Using JRE_HOME:        /usr
Using CLASSPATH:       /home/apache-tomcat-9.0.0.M26/bin/bootstrap.jar:/home/apache-tomcat-9.0.0.M26/bin/tomcat-juli.jar
Tomcat started.
```
### 1.5. 安装mariaDB数据库

MariaDB是MySQL源代码的一个分支，在意识到Oracle会对MySQL许可做什么后分离了出来（有闭源的潜在风险）。作者Michael Widenius Monty也是Mysql创办者。MariaDB目的是完全兼容Mysql，也包括一些新特性优于MySQL。

直接apt安装：

```shell=
root@akari:/home# apt install mariadb-server -y
```

## 2. 快速开始
TODO

## 3. 自动化部署
TODO
