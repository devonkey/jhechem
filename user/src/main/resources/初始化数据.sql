insert into function_auth(id,`name`,url,create_time,update_time) values (10000,'订单详情','/order/{bookid:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10001,'订单列表','/order/list',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10002,'订单修改','/order/update',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10009,'订单删除','/order/delete',current_timestamp,current_timestamp);

insert into function_auth(id,`name`,url,create_time,update_time) values (10003,'新增管理员','/admin/add',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10004,'删除管理员','/admin/delete',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10005,'管理员修改','/admin/update',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10006,'管理员修改密码','/admin/password/update',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10007,'管理员详情','/admin/{id:\\d+}',current_timestamp,current_timestamp);
insert into function_auth(id,`name`,url,create_time,update_time) values (10008,'管理员列表','/admin/list',current_timestamp,current_timestamp);

insert into auth_group (id,name,create_time,update_time) values (10000,'管理员管理',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10001,'订单管理',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10002,'查询订单',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10003,'权限管理',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10004,'角色管理',current_timestamp,current_timestamp);
insert into auth_group (id,name,create_time,update_time) values (10005,'角色权限组关系管理',current_timestamp,current_timestamp);

insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10003,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10004,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10005,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10006,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10007,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10000,10008,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10000,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10001,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10002,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10001,10009,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10002,10000,current_timestamp);
insert into auth_group_rel(group_id,auth_id,create_time) values (10002,10001,current_timestamp);

insert into role(id,`name`,`create_time`,`update_time`) values (10000,'超级管理员', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );
insert into role(id,`name`,`create_time`,`update_time`) values (10001,'订单管理员', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );
insert into role(id,`name`,`create_time`,`update_time`) values (10002,'业务员', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );
insert into role(id,`name`,`create_time`,`update_time`) values (10003,'实习生', CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP );

insert into admin_role_rel(admin_id,role_id,create_time) values(10000,10000,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10001,10000,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10002,10001,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10003,10001,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10004,10002,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10003,10003,CURRENT_TIMESTAMP );
insert into admin_role_rel(admin_id,role_id,create_time) values(10005,10003,CURRENT_TIMESTAMP );

INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10000,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10000,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10001,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10002,10001,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10001,10002,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10002,10002,CURRENT_TIMESTAMP );
INSERT INTO `role_auth_group_rel`(`auth_group_id`,`role_id`,`create_time`) VALUE (10002,10003,CURRENT_TIMESTAMP );
