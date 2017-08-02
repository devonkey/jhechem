truncate function_auth;
#订单查看
insert into function_auth(id,`name`,url,create_time,update_time) values (10000,'订单详情','/order/{bookid:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10001,'订单列表','/order/list',current_timestamp,current_timestamp);
#订单编辑
insert into function_auth(id,`name`,url,create_time,update_time) values (10002,'订单修改','/order/update',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10003,'订单删除','/order/delete/{bookid:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10004,'添加订单','/order/add',current_timestamp,current_timestamp);

#管理员管理
insert into function_auth(id,`name`,url,create_time,update_time) values (10005,'新增管理员','/admin/add',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10006,'删除管理员','/admin/delete/{id:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10007,'管理员修改','/admin/update',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10008,'管理员修改密码','/admin/password/update',current_timestamp,current_timestamp);

#普通管理员
insert into function_auth(id,`name`,url,create_time,update_time) values (10009,'管理员详情','/admin/{id:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10010,'管理员列表','/admin/list',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10011,'管理员修改自己的密码','/admin/password/update/self',current_timestamp,current_timestamp);

truncate auth_group;
#权限组
insert into auth_group (id,name,create_time,update_time) values (10000,'管理员管理',current_timestamp,current_timestamp;
insert into auth_group (id,name,create_time,update_time) values (10001,'管理员查询',current_timestamp,current_timestamp;
insert into auth_group (id,name,create_time,update_time) values (10002,'订单管理',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10003,'订单查询',current_timestamp,current_timestamp);

truncate `auth_group_rel`;
#功能权限分类
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10005,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10006,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10007,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10008,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10009,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10010,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10011,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10002,10002,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10002,10003,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10002,10004,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10003,10000,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10003,10001,current_timestamp);

truncate role;
#角色
insert into role(id,`name`,`create_time`,`update_time`) values (10000,'超级管理员',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into role(id,`name`,`create_time`,`update_time`) values (10001,'业务员',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into role(id,`name`,`create_time`,`update_time`) values (10002,'实习生', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );

truncate role_auth_group_rel;
#权限组与角色的关系
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10000,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10002,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10003,10000,CURRENT_TIMESTAMP );

INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10001,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10002,10001,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10003,10001,CURRENT_TIMESTAMP );

INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10002,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10003,10002,CURRENT_TIMESTAMP );

truncate admin_role_rel;
#管理员角色关系
insert into admin_role_rel(admin_id,role_id,create_time) values(10000,10000,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10001,10000,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10002,10001,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10003,10002,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10003,10000,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10004,10002,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10005,10002,CURRENT_TIMESTAMP );
