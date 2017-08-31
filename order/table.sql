DROP TABLE IF EXISTS `jh_order`;
CREATE TABLE `jh_order` (
`bookid` BIGINT(16) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',  
`paixu` int(10) unsigned DEFAULT NULL COMMENT '排序', 
`casno` VARCHAR(64) DEFAULT NULL COMMENT 'CAS编号', 
`bookname` VARCHAR(256) DEFAULT NULL COMMENT '产品名称',
`enbookname` VARCHAR(256) DEFAULT NULL COMMENT '英文名称',
`ordernum` VARCHAR(64) DEFAULT NULL COMMENT '订单号码', 
`fapiaonum` VARCHAR(64) DEFAULT NULL COMMENT '发票号码', 
`krname` VARCHAR(64) DEFAULT NULL COMMENT '客户名称', 
`date1` DATETIME DEFAULT NULL COMMENT '订购日期',
`date2` VARCHAR(64) DEFAULT NULL COMMENT '订单交货日期',
`cjsl` VARCHAR(64) DEFAULT NULL COMMENT '成交数量',
`style` VARCHAR(64) DEFAULT NULL COMMENT '成交币种', 
`price1` VARCHAR(64) DEFAULT NULL COMMENT '工厂价格', 
`price2` VARCHAR(64) DEFAULT NULL COMMENT '给客人价格', 
`ysfs` VARCHAR(64) DEFAULT NULL COMMENT '运输方式', 
`ysfy` VARCHAR(64) DEFAULT NULL COMMENT '运费', 
`hl` VARCHAR(64) DEFAULT NULL COMMENT '汇率', 
`zsh` VARCHAR(64) DEFAULT NULL COMMENT '总收汇', 
`huokuan` VARCHAR(64) DEFAULT NULL COMMENT '工厂货款', 
`lirun` VARCHAR(64) DEFAULT NULL COMMENT '利润分析', 
`yundan` VARCHAR(64) DEFAULT NULL COMMENT '外运单号码', 
`date3` VARCHAR(64) DEFAULT NULL COMMENT '收汇日期',
`cpgg` TEXT DEFAULT NULL COMMENT '产品规格要求',
`baozhuang` VARCHAR(64) DEFAULT NULL COMMENT '包装要求', 
`isyp` VARCHAR(64) DEFAULT NULL COMMENT '是否给客人样品', 
`gyscontact` VARCHAR(64) DEFAULT NULL COMMENT '供应商联系方式', 
`gysname` VARCHAR(64) DEFAULT NULL COMMENT '供应商名称', 
`iskucun` VARCHAR(64) DEFAULT NULL COMMENT '是否有样品库存', 
`kucun` VARCHAR(64) DEFAULT NULL COMMENT '库存数量',
`fj1` VARCHAR(64) DEFAULT NULL COMMENT '给客人', 
`fj2` VARCHAR(64) DEFAULT NULL COMMENT '分析报告', 
`ywy` VARCHAR(64) DEFAULT NULL COMMENT '业务员', 
`isjs` VARCHAR(64) DEFAULT NULL COMMENT '业务员结算', 
`isdh` tinyint(1) DEFAULT NULL COMMENT '工厂货物是否已到货', 
`isfh` tinyint(1) DEFAULT NULL COMMENT '是否已经给客人发货', 
`isfp` tinyint(1) DEFAULT NULL COMMENT '是否已经给客人发票', 
`isfxbg` tinyint(1) DEFAULT NULL COMMENT '是否已经给客人分析报告', 
`zhfrom` VARCHAR(64) DEFAULT NULL COMMENT '账户来源', 
`ists` tinyint(1) DEFAULT NULL COMMENT '是否要退税', 
`date4` VARCHAR(64) DEFAULT NULL COMMENT '预计收汇日期',
`issh` tinyint(1) DEFAULT NULL COMMENT '是否收汇', 
`iskp` tinyint(1) DEFAULT NULL COMMENT '工厂是否要开票', 
`isgcfp` tinyint(1) DEFAULT NULL COMMENT '是否收到工厂发票', 
`mylx` tinyint(2) DEFAULT '0' COMMENT '贸易类型, 0-外销 1-内销', 
`ishx` tinyint(1) DEFAULT NULL COMMENT '是否已经核销', 
`date5` VARCHAR(64) DEFAULT NULL COMMENT '核销截止日期',
`iswcts` tinyint(1) DEFAULT NULL COMMENT '是否已经完成退税', 
`ishkqf` tinyint(1) DEFAULT NULL COMMENT '工厂货款是否已经全付', 
`qgchk` VARCHAR(64) DEFAULT NULL COMMENT '欠工厂部分货款', 
`krqk` VARCHAR(64) DEFAULT NULL COMMENT '客人欠款部分', 
`isok` tinyint(1) DEFAULT NULL COMMENT '是否完成', 
`krkpdz` TINYTEXT DEFAULT NULL COMMENT '客人开票地址', 
`krfhdz` TINYTEXT DEFAULT NULL COMMENT '客人发货地址', 
`content` TEXT DEFAULT NULL COMMENT '备注',
PRIMARY KEY (`bookid`),
KEY `idx_ywy` (`ywy`,`lirun`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';


ALTER TABLE jh_order ADD COLUMN `admin_id` int(10) unsigned DEFAULT '1' COMMENT '管理员id';
ALTER TABLE jh_order ADD COLUMN `status` tinyint(2) unsigned DEFAULT '1' COMMENT '1-正常，0-删除';
alter table jh_order MODIFY `lirun` int  DEFAULT 0 COMMENT '利润分析';
ALTER TABLE jh_order ADD COLUMN `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间';
ALTER TABLE jh_order ADD COLUMN `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间';
ALTER TABLE jh_order ADD INDEX idx_date1 (`date1`);