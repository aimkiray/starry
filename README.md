# starry 食用指南

作为一个~~轻量级~~小巧的博客系统，本项目采用 Spring + Spring MVC + MyBatis 构建。

> Q: SSM 轻量级？吾阅诗书甚少，汝勿欺我。

> A: 捂脸 (\*/ω＼\*)，找工作需要嘛！所谓轻量是指对 Java 程序员而言。PS. 隔壁 sgroup 第一个项目没用任何框架，初学者可以拿去参考。

> Q: 那你这个意义何在？

> A: 可以魔改，有详细食用说明。本项目的优点之一就是代码超规范（见名知意，参考 alibaba 的那本手册），注释超详细（覆盖率超过 90%），RESTful 风格 API，二次开发也超轻松。

```
PS. 不懂 java 也没关系，可以直接跳到食用说明，理论上没问题！（有问题发 issue）
```

本项目基于 maven 的标准目录结构，使用 maven 构建；框架是 Spring，MVC 框架是 Spring MVC，数据库是 MariaDB，持久化是 MyBatis，权限管理是自制的，如下所示：

TODO 正在用 Spring Boot 写一个图床工具，搞定之后再来考虑是否改 Spring Boot。

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

本项目采用 MVC 架构，前端部分同时使用 JSP 和 Freemarker，目录结构如下：

TODO 后续考虑将 JSP 全部改成 Freemarker，以配合 Spring Boot 和 RESTful API 实现前后端分离。

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

食（shi）用（du）方法如下。

## 1. 环境配置

部署环境的配置如下（阿里云友情提供）：

CPU： 1 核

内存： 1 GB

硬盘： 40 GB

操作系统： Ubuntu 16.04 64 位

### 1.1. 安装 openjdk

更新软件列表：

```shell=
root@akari:~# apt update
```

安装 openjdk-8-jdk：

```shell=
root@akari:~# apt install openjdk-8-jdk -y
```

检查，成功则返回版本号：

```shell=
root@akari:~# java -version
```

### 1.2. 安装 Git

```shell=
root@akari:~# apt install git -y
```

检查 Git 是否安装成功；输入如下命令，安装成功返回版本号。

```shell=
root@akari:~# git --version
git version 2.7.4
```

### 1.3. 配置 maven

先下载最新版 [maven](https://maven.apache.org/download.cgi)，右键 Binary tar.gz archive 获取下载地址，输入如下命令下载 maven：

```shell=
root@akari:~# cd ~
# 若地址失效，请自行替换最新地址
root@akari:~# wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.2-bin.tar.gz
# 解压
root@akari:~# tar -zxvf apache-maven-3.5.2-bin.tar.gz
# 重命名
root@akari:~# mv apache-maven-3.5.2 apache-maven
```

添加环境变量：

```shell=
root@akari:~# vim /etc/profile
```

在最后加上这些：

```shell=
MAVEN_HOME=~/apache-maven
export MAVEN_HOME
export PATH=${PATH}:${MAVEN_HOME}/bin
```

保存，退出后重载文件：

```shell=
root@akari:~# source /etc/profile
```

验证 maven 配置，成功则返回版本号：

```shell=
root@akari:~# mvn -v
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-04T03:39:06+08:00)
Maven home: ~/apache-maven-3.5.0
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-openjdk-amd64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.4.0-47-generic", arch: "amd64", family: "unix"
```

### 1.4. 配置 Tomcat

在这儿获取最新版 [tomcat](http://tomcat.apache.org/download-90.cgi) 下载地址（core 版本的 tar.gz），如下：

```shell=
root@akari:~# cd ~
root@akari:~# wget http://mirrors.shuosc.org/apache/tomcat/tomcat-9/v9.0.0.M26/bin/apache-tomcat-9.0.1.tar.gz
# 解压
root@akari:~# tar -zxvf apache-tomcat-9.0.1.tar.gz
# 重命名
root@akari:~# mv apache-tomcat-9.0.1 apache-tomcat
```

启动 Tomcat：

```shell=
root@akari:~# sh apache-tomcat/bin/startup.sh
Using CATALINA_BASE:   ~/apache-tomcat-9.0.1
Using CATALINA_HOME:   ~/apache-tomcat-9.0.1
Using CATALINA_TMPDIR: ~/apache-tomcat-9.0.1/temp
Using JRE_HOME:        /usr
Using CLASSPATH:       ~/apache-tomcat-9.0.1/bin/bootstrap.jar:~/apache-tomcat-9.0.1/bin/tomcat-juli.jar
Tomcat started.
```
### 1.5. 安装 MariaDB 数据库

MariaDB 是 MySQL 源代码的一个分支，在意识到 Oracle 会对 MySQL 许可做什么后分离了出来（有闭源的潜在风险）。作者 Michael Widenius Monty 也是 MySQL 创办者。MariaDB 目的是完全兼容 MySQL，也包括一些新特性优于 MySQL。

直接 apt 安装：

```shell=
root@akari:~# apt install mariadb-server -y
```

## 2. 快速开始

首先 clone 本项目（注意路径，之后要用到）：

```shell=
root@akari:~# cd ~
root@akari:~# git clone https://github.com/nekuata/starry.git
```

接着配置数据库，配置 root 密码：

```shell=
root@akari:~# mysql_secure_installation
```

然后使用 root 用户登入数据库，导入本项目的表结构：

```shell=
# 登录数据库
root@akari:~/starry/src/main# mysql -u root -p
# 导入表结构
MariaDB [(none)]> source ~/starry/src/main/notebook/starry.sql
```

新建一个用户，赋予表 sinitial 的所有权限：

```shell=
MariaDB [(none)]> CREATE USER 'starry'@'localhost' IDENTIFIED BY 'starry12138';
MariaDB [(none)]> GRANT ALL PRIVILEGES ON `sinitial`.* TO 'starry'@'localhost' WITH GRANT OPTION;
MariaDB [(none)]> FLUSH PRIVILEGES;
# 退出 mariadb
MariaDB [(none)]> exit
```
> 其中 \`sinitial\`.* 是刚才导入的表名，starry 是默认用户名，starry12138 是默认密码，为了安全起见最好改成自己的。

使用 maven 下载依赖包并打包：

```shell=
root@akari:~# cd ~/starry
root@akari:~/starry# mvn install
```

> 以下内容不是必须的。

——————————————————start—————————————————————

生成 Druid 数据库密钥

本项目采用 Druid 数据库连接池，数据库明文密码直接写在配置里。Druid 为此提供一种数据库密码加密的手段 ConfigFilter，首先找到 Druid 的 jar 包：

```shell=
root@akari:~# cd ~/.m2/repository/com/alibaba/druid/1.1.2
```
执行如下命令：

```shell=
root@akari:~/.m2/repository/com/alibaba/druid/1.1.2# java -cp druid-1.1.2.jar com.alibaba.druid.filter.config.ConfigTools starry12138
```
输出：

```shell=
privateKey:MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAvMTUk4bMbDkg3U6SG5ErHb8b0B4CCOqQn/7kLWVyZgJyA6tFmrfvL3DFP/S7qt3pdoEisebBpJonQK07HM/fBwIDAQABAkBgrncp8Bp3O3NHpdxTXjC1FZKLLzNfmbPlHkmDrre+4pSNPZAJBfqsEXOCfduAXuvooeXPMJ2cXCy49402TujBAiEA3fTKJK1UdvBodp8+F/kz5iU186cjfeH2cYnQdacCIfcCIQDZuOzFyHHDvE8KfZ6xAjMUPLPxDwPnLd+aKGCHq0/ncQIhAMEhuatEb1S3SA6/7cXqf/BovJNxAf8NWeXdp1hYpBBtAiArMb73tj6rwI5F3IpBP9h2aVyhtILnuHgmE2CjSd9+YQIgPcfa3J5KjjWnCYLDRDtLMcGCJ2LCqB2ZyQPC+hA3VNY=
publicKey:MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALzE1JOGzGw5IN1OkhuRKx2/G9AeAgjqkJ/+5C1lcmYCcgOrRZq37y9wxT/0u6rd6XaBIrHmwaSaJ0CtOxzP3wcCAwEAAQ==
password:gNfnXJUtBokb9yuIGxw0a5FtRlM5+yuhJ+QM/sL9S1bps/zqAd2daBePWGNqdWirsZQtXbBg0sBVMaLX2ELzYw==
```

> 其中 starry12138 是刚才新建 mariadb 用户的密码

修改 Druid 配置文件：

```shell=
root@akari:~# vim ~/starry/src/main/resources/spring/druid.properties
```
输入 `i` 开启编辑模式，在这里填入数据库用户名和上面生成的密钥：
```shell=
jdbc_username = starry
jdbc_password = gNfnXJUtBokb9yuIGxw0a5FtRlM5+yuhJ+QM/sL9S1bps/zqAd2daBePWGNqdWirsZQtXbBg0sBVMaLX2ELzYw==
jdbc_publicKey = MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALzE1JOGzGw5IN1OkhuRKx2/G9AeAgjqkJ/+5C1lcmYCcgOrRZq37y9wxT/0u6rd6XaBIrHmwaSaJ0CtOxzP3wcCAwEAAQ==
```
点击 esc，输入 `:wq` 保存退出。

再次使用 maven 打包：

```shell=
root@akari:~# cd ~/starry
root@akari:~/starry# mvn install
```

——————————————————end—————————————————————

完成后，把打好的 war 包重命名，丢到 Tomcat 服务器里：

```shell=
# 进入 war 包目录
root@akari:~/starry# cd ~/starry/target
# 改名
root@akari:~/starry/target# mv starry.war ROOT.war
# 关闭 tomcat
root@akari:~/starry/target# sh ~/apache-tomcat/bin/shutdown.sh
# 删除旧包
root@akari:~/starry/target# rm -rf ~/apache-tomcat/webapps/ROOT
# 添加新包
root@akari:~/starry/target# mv ROOT.war ~/apache-tomcat/webapps/
# 启动 tomcat
root@akari:~/starry/target# sh ~/apache-tomcat/bin/startup.sh
```
大功告成！

现在地址栏输入 `http:// 你的 ip 地址:8080`try it~

PS. 关于更改 tomcat 端口

- root 用户：`vim ~/apache-tomcat/conf/server.xml`，搜索8080将其改为80，保存，重启 tomcat 即可。

- 非 root 用户：试试 iptables 的端口转发功能。`sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-ports 8080`

## 3. 自动化部署

执行脚本：

```shell=
# 执行脚本
root@akari:~# sh ~/starry/src/main/notebook/deploy.sh
```
or
```shell=
# 赋予脚本执行权限
root@akari:~# chmod +x ~/starry/src/main/notebook/deploy.sh
# 执行脚本
root@akari:~# .~/starry/src/main/notebook/deploy.sh
```

To Be Continue...

## 4. 致谢

- [spring-framework](https://github.com/spring-projects/spring-framework)
- [MyBatis](https://github.com/mybatis/mybatis-3)
- [druid](https://github.com/alibaba/druid)
- [bootstrap](https://github.com/twbs/bootstrap)
- [DataTables](https://github.com/DataTables/DataTables)
- [MariaDB](https://github.com/MariaDB)
- [freemarker](https://github.com/freemarker)
- [tomcat](https://github.com/apache/tomcat)
- [maven](https://github.com/apache/maven)
- [jquery](https://github.com/jquery/jquery)
- [markdown-it](https://github.com/markdown-it/markdown-it)

> PS. 不完全统计，排名不分先后，大小写依据 Official 项目名

附：Windows 系统配置要求如下：

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
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Windows® 7 / Windows® 8 / Windows® 10 64 位系统 (或最新版本的 Service Pack)</span></div>
			</td>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Windows® 7 / Windows® 8 / Windows® 10 64 位系统 (最新版本的 Service Pack)</span></div>
			</td>
		</tr>
		<tr>
			<th scope="row">
			<div class="centered">处理器</div>
			</th>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Intel® Core™ i3 或是 AMD Phenom™ X3 8650</span></div>
			</td>
			<td>
			<div class="centered"><span lang="EN-US" style="font-size: 9pt; line-height: 107%; font-family: Arial, sans-serif;">Intel® Core™ i9-7980XE 或 AMD Ryzen™ ThreadRipper 1950X 处理器及以上</span></div>
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

（有话好好说，别打脸）PS. 你至少知道了下一台主机的配件表，也不是白来一趟嘛！
