#权限管理sql

DROP TABLE IF EXISTS `admin`;
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
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';

DROP TABLE IF EXISTS `menu_auth`;
CREATE TABLE `menu_auth` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '目录id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `url` varchar(32) NOT NULL DEFAULT '' COMMENT '目录url',
  `parentId` varchar(16) NOT NULL DEFAULT '' COMMENT '父级目录',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='目录权限表';

DROP TABLE IF EXISTS `function_auth`;
CREATE TABLE `function_auth` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '功能权限id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `url` varchar(32) NOT NULL DEFAULT '' COMMENT '目录url',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='功能权限表';

DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限组id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '权限组名',
  `type` tinyint(2) NOT NULL DEFAULT '' COMMENT '权限组类型:0-功能权限,1-菜单权限',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='权限组表';

DROP TABLE IF EXISTS `auth_group_rel`;
CREATE TABLE `auth_group_rel` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限组id',
  `auth_id` int(10) NOT NULL DEFAULT '' COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`group_id`,`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='权限组与权限关系表';


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名',
  `alias` varchar(32) NOT NULL DEFAULT '' COMMENT '角色别名',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态:0-无效,1-有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

DROP TABLE IF EXISTS `admin_role_rel`;
CREATE TABLE `admin_role_rel` (
  `admin_id` int(10) NOT NULL DEFAULT '0' COMMENT '管理员id',
  `role_id` int(10) NOT NULL DEFAULT '0' COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`,`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='管理员与角色关系表';

DROP TABLE IF EXISTS `role_auth_group_rel`;
CREATE TABLE `role_auth_group_rel` (
  `auth_group_id` int(10) NOT NULL DEFAULT '0' COMMENT '权限组id',
  `role_id` int(10) NOT NULL DEFAULT '0' COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`auth_group_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='权限组与角色关系表';