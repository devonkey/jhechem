-- MySQL dump 10.13  Distrib 5.7.18, for macos10.12 (x86_64)
--
-- Host: 139.224.72.39    Database: test
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `realname` varchar(32) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '用户手机号码',
  `salt` char(6) NOT NULL DEFAULT '' COMMENT '盐值',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '密码',
  `department` varchar(64) NOT NULL DEFAULT '' COMMENT '部门',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 管理员不可用 1 管理员状态正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20012 DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `admin_role_rel`
--

DROP TABLE IF EXISTS `admin_role_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_role_rel` (
  `admin_id` int(10) NOT NULL DEFAULT '0' COMMENT '管理员id',
  `role_id` int(10) NOT NULL DEFAULT '0' COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`,`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员与角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auth_group`
--

DROP TABLE IF EXISTS `auth_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_group` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限组id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '权限组名',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '权限组类型:0-功能权限,1-菜单权限',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8mb4 COMMENT='权限组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auth_group_rel`
--

DROP TABLE IF EXISTS `auth_group_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_group_rel` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限组id',
  `auth_id` int(10) NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`group_id`,`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8mb4 COMMENT='权限组与权限关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function_auth`
--

DROP TABLE IF EXISTS `function_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_auth` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '功能权限id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `url` varchar(32) NOT NULL DEFAULT '' COMMENT '目录url',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10012 DEFAULT CHARSET=utf8mb4 COMMENT='功能权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function_operate_range`
--

DROP TABLE IF EXISTS `function_operate_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_operate_range` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `function_auth_id` int(10) unsigned NOT NULL COMMENT '功能权限id',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  `range` tinyint(2) unsigned NOT NULL COMMENT '操作范围,具体接口自己定义',
  `content` varchar(100) NOT NULL DEFAULT '' COMMENT '操作范围具体意义描述',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_function_auth_id` (`function_auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8mb4 COMMENT='功能权限操作范围';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jh_order`
--

DROP TABLE IF EXISTS `jh_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jh_order` (
  `bookid` bigint(16) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `paixu` int(10) unsigned DEFAULT NULL COMMENT '排序',
  `casno` varchar(64) DEFAULT NULL COMMENT 'CAS编号',
  `bookname` varchar(256) DEFAULT NULL COMMENT '产品名称',
  `enbookname` varchar(256) DEFAULT NULL COMMENT '英文名称',
  `ordernum` varchar(64) DEFAULT NULL COMMENT '订单号码',
  `fapiaonum` varchar(64) DEFAULT NULL COMMENT '发票号码',
  `krname` varchar(64) DEFAULT NULL COMMENT '客户名称',
  `date1` datetime DEFAULT NULL COMMENT '订购日期',
  `date2` varchar(64) DEFAULT NULL COMMENT '订单交货日期',
  `cjsl` varchar(64) DEFAULT NULL COMMENT '成交数量',
  `style` varchar(64) DEFAULT NULL COMMENT '成交币种',
  `price1` varchar(64) DEFAULT NULL COMMENT '工厂价格',
  `price2` varchar(64) DEFAULT NULL COMMENT '给客人价格',
  `ysfs` varchar(64) DEFAULT NULL COMMENT '运输方式',
  `ysfy` varchar(64) DEFAULT NULL COMMENT '运费',
  `hl` varchar(64) DEFAULT NULL COMMENT '汇率',
  `zsh` varchar(64) DEFAULT NULL COMMENT '总收汇',
  `huokuan` varchar(64) DEFAULT NULL COMMENT '工厂货款',
  `lirun` varchar(64) DEFAULT NULL COMMENT '利润分析',
  `yundan` varchar(64) DEFAULT NULL COMMENT '外运单号码',
  `date3` varchar(64) DEFAULT NULL COMMENT '收汇日期',
  `cpgg` tinytext COMMENT '产品规格要求',
  `baozhuang` varchar(64) DEFAULT NULL COMMENT '包装要求',
  `isyp` varchar(64) DEFAULT NULL COMMENT '是否给客人样品',
  `gyscontact` varchar(64) DEFAULT NULL COMMENT '供应商联系方式',
  `gysname` varchar(64) DEFAULT NULL COMMENT '供应商名称',
  `iskucun` varchar(64) DEFAULT NULL COMMENT '是否有样品库存',
  `kucun` varchar(64) DEFAULT NULL COMMENT '库存数量',
  `fj1` varchar(64) DEFAULT NULL COMMENT '给客人',
  `fj2` varchar(64) DEFAULT NULL COMMENT '分析报告',
  `ywy` varchar(64) DEFAULT NULL COMMENT '业务员',
  `isjs` varchar(64) DEFAULT NULL COMMENT '业务员结算',
  `isdh` tinyint(1) DEFAULT NULL COMMENT '工厂货物是否已到货',
  `isfh` tinyint(1) DEFAULT NULL COMMENT '是否已经给客人发货',
  `isfp` tinyint(1) DEFAULT NULL COMMENT '是否已经给客人发票',
  `isfxbg` tinyint(1) DEFAULT NULL COMMENT '是否已经给客人分析报告',
  `zhfrom` varchar(64) DEFAULT NULL COMMENT '账户来源',
  `ists` tinyint(1) DEFAULT NULL COMMENT '是否要退税',
  `date4` varchar(64) DEFAULT NULL COMMENT '预计收汇日期',
  `issh` tinyint(1) DEFAULT NULL COMMENT '是否收汇',
  `iskp` tinyint(1) DEFAULT NULL COMMENT '工厂是否要开票',
  `isgcfp` tinyint(1) DEFAULT NULL COMMENT '是否收到工厂发票',
  `mylx` tinyint(2) DEFAULT '0' COMMENT '贸易类型, 0-外销 1-内销',
  `ishx` tinyint(1) DEFAULT NULL COMMENT '是否已经核销',
  `date5` varchar(64) DEFAULT NULL COMMENT '核销截止日期',
  `iswcts` tinyint(1) DEFAULT NULL COMMENT '是否已经完成退税',
  `ishkqf` tinyint(1) DEFAULT NULL COMMENT '工厂货款是否已经全付',
  `qgchk` varchar(64) DEFAULT NULL COMMENT '欠工厂部分货款',
  `krqk` varchar(64) DEFAULT NULL COMMENT '客人欠款部分',
  `isok` tinyint(1) DEFAULT NULL COMMENT '是否完成',
  `krkpdz` tinytext COMMENT '客人开票地址',
  `krfhdz` tinytext COMMENT '客人发货地址',
  `content` text COMMENT '备注',
  `status` tinyint(2) unsigned DEFAULT '1' COMMENT '1-正常，0-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `admin_id` int(10) unsigned DEFAULT '1' COMMENT '管理员id',
  PRIMARY KEY (`bookid`),
  KEY `idx_ywy` (`ywy`,`lirun`)
) ENGINE=InnoDB AUTO_INCREMENT=15842 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `menu_auth`
--

DROP TABLE IF EXISTS `menu_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_auth` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '目录id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `url` varchar(32) NOT NULL DEFAULT '' COMMENT '目录url',
  `parentId` varchar(16) NOT NULL DEFAULT '' COMMENT '父级目录',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='目录权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `phrasebook`
--

DROP TABLE IF EXISTS `phrasebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phrasebook` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `clazz` tinyint(2) NOT NULL DEFAULT '0' COMMENT '分类：0-拍卖审核常用语,1-拍卖专场审核常用语,2-直播审核常用语',
  `phrase` text NOT NULL COMMENT '常用语',
  PRIMARY KEY (`id`),
  KEY `class_index` (`clazz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='常用语配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名',
  `alias` varchar(32) NOT NULL DEFAULT '' COMMENT '角色别名',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_auth_group_rel`
--

DROP TABLE IF EXISTS `role_auth_group_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_auth_group_rel` (
  `auth_group_id` int(10) NOT NULL DEFAULT '0' COMMENT '权限组id',
  `role_id` int(10) NOT NULL DEFAULT '0' COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`auth_group_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限组与角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;
