truncate function_auth;
#订单编辑
insert into function_auth(id,`name`,url,create_time,update_time) values (10000,'订单修改','/order/update',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10001,'订单删除','/order/delete',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10002,'添加订单','/order/add',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10003,'订单统计','/order/statistic',current_timestamp,current_timestamp);

insert into function_auth(id,`name`,url,create_time,update_time) values (10004,'设置发货状态','/order/fh/{bookid:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10005,'设置到货状态','/order/dh/{bookid:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10006,'设置结算状态','/order/js/{bookid:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10007,'设置收汇状态','/order/sh/{bookid:\\d+}',current_timestamp,current_timestamp);

#订单查看
insert into function_auth(id,`name`,url,create_time,update_time) values (10010,'订单详情','/order/{bookid:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10011,'订单列表','/order/list',current_timestamp,current_timestamp);

#管理员管理
insert into function_auth(id,`name`,url,create_time,update_time) values (10100,'新增管理员','/admin/add',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10101,'删除管理员','/admin/delete',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10102,'管理员修改','/admin/update',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10103,'管理员修改密码','/admin/password/update',current_timestamp,current_timestamp);

#普通管理员
insert into function_auth(id,`name`,url,create_time,update_time) values (10110,'管理员详情','/admin/{id:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10111,'管理员列表','/admin/list',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10112,'管理员修改自己的密码','/admin/password/update/self',current_timestamp,current_timestamp);

truncate auth_group;
#权限组
insert into auth_group (id,name,create_time,update_time) values (10000,'管理员管理',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10001,'管理员基本操作',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10002,'订单管理(管理员)',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10003,'订单管理(业务员)',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10004,'订单查询',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10005,'删除操作',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10006,'订单超级管理',current_timestamp,current_timestamp);


truncate `auth_group_rel`;
#功能权限分类
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10100,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10102,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10103,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10110,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10111,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10112,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10002,10000,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10002,10002,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10006,10003,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10006,10004,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10006,10005,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10006,10006,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10006,10007,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10003,10000,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10003,10002,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10004,10010,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10004,10011,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10005,10001,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10005,10101,current_timestamp);

truncate role;
#角色 分四级
## 超级管理员 任何操作;
## 普通管理员 查看不受限制,没有删除权限;
## 业务员 授予的操作添加本人限制,非本人订单数据仅查看部分字段;
## 实习生 基本读权限.
insert into role(id,`name`,`create_time`,`update_time`) values (10000,'超级管理员',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into role(id,`name`,`create_time`,`update_time`) values (10001,'业务员',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into role(id,`name`,`create_time`,`update_time`) values (10002,'实习生', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );
insert into role(id,`name`,`create_time`,`update_time`) values (10003,'普通管理员', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );

truncate role_auth_group_rel;
#权限组与角色的关系
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10000,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10002,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10004,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10005,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10006,10000,CURRENT_TIMESTAMP );

INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10001,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10003,10001,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10004,10001,CURRENT_TIMESTAMP );

INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10002,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10004,10002,CURRENT_TIMESTAMP );

INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10003,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10002,10003,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10004,10003,CURRENT_TIMESTAMP );

truncate function_operate_range;
INSERT INTO function_operate_range VALUES (1,10010,10000,1,'订单详情:1-无权限限制,其它-只能查询自己的数据和其余数据的部分字段',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
INSERT INTO function_operate_range VALUES (2,10010,10003,1,'订单详情:1-无权限限制,其它-只能查询自己的数据和其余数据的部分字段',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
INSERT INTO function_operate_range VALUES (3,10011,10000,1,'订单列表:1-无权限限制,其它-只能查询自己的数据和其余数据的部分字段',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
INSERT INTO function_operate_range VALUES (4,10011,10003,1,'订单详情:1-无权限限制,其它-只能查询自己的数据和其余数据的部分字段',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
INSERT INTO function_operate_range VALUES (5,10000,10000,1,'添加订单:1-无权限限制,其它-只能修改自己的订单',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
INSERT INTO function_operate_range VALUES (6,10002,10000,1,'修改订单:1-无权限限制,其它-只能添加自己的订单',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
INSERT INTO function_operate_range VALUES (7,10003,10000,1,'订单统计:1-无权限限制,其它-只能统计自己的订单',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );
