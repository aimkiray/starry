# sinitial-blog
咱亲手推的博客项目，主要用于提高姿势水平。
食（shi）用（du）方法如下所述。

## 1. 环境配置（Ubuntu 16.04）

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
