update jh_order set ywy ='吴星星' where ywy='吴';
update jh_order set ywy ='郑嫣娜' where ywy='啊娜';
update jh_order set ywy ='郑嫣娜' where ywy='娜';
update jh_order set ywy ='任如意' where ywy='小任';
update jh_order set ywy ='叶群芳' where ywy='小叶';
update jh_order set ywy ='吴星星' where ywy='小吴';
update jh_order set ywy ='张哲杰' where ywy='小张';
update jh_order set ywy ='梅丽燕' where ywy='小梅';
update jh_order set ywy ='胡振杭' where ywy='小胡';
update jh_order set ywy ='薛奇汶' where ywy='小薛';
update jh_order set ywy ='郑瑞笔' where ywy='小郑';
update jh_order set ywy ='吴星星' where ywy='星星';
update jh_order set ywy ='梅丽燕' where ywy='梅';
update jh_order set ywy ='胡珊珊' where ywy='珊珊';
update jh_order set ywy ='郑瑞笔' where ywy='笔';
update jh_order set ywy ='薛奇汶' where ywy='薛';
update jh_order set ywy ='赵国樑' where ywy='赵';
update jh_order set ywy ='赵国梁' where ywy='赵国樑';

update jh_order set ywy ='黄玲丽' where ywy='黄铃丽';
update jh_order set ywy ='郑嫣娜' where ywy='郑燕娜';
update jh_order set ywy ='胡姗姗' where ywy='胡珊珊';
update jh_order set ywy ='曾科' where ywy='曾科(不能算定单)';

update jh_order set ywy ='杨波' where ywy='杨';
update jh_order set ywy ='杨波' where ywy='小杨';
update jh_order set ywy ='胡振杭' where ywy='胡振杭/罗琴';

update jh_order set ywy ='郑瑞笔' where ywy='郑';
update jh_order set ywy ='胡振杭' where ywy='胡';
update jh_order set ywy ='罗琴' where ywy='罗';
update jh_order set ywy ='胡振杭' where ywy='罗琴 胡';
 update jh_order set ywy = '郑瑞笔' where ywy= '郑润笔';
update jh_order set ywy ='匿名' where (ywy='无' OR ywy IS NULL OR ywy = '') AND admin_id = 1 ;



#insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '\1','\1','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '\1');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '任如意','任如意','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '任如意');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '倪华英','倪华英','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '倪华英');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '匿名','匿名','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '匿名');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '叶群芳','叶群芳','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '叶群芳');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '吴星星','吴星星','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '吴星星');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '吴月芹','吴月芹','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '吴月芹');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '尚迎','尚迎','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '尚迎');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '张哲杰','张哲杰','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '张哲杰');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '张巧俏','张巧俏','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '张巧俏');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '张雪','张雪','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '张雪');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '徐哲晴','徐哲晴','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '徐哲晴');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '徐经理','徐经理','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '徐经理');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '曾科','曾科','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '曾科');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '李倩','李倩','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '李倩');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '杨波','杨波','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '杨波');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '梅丽燕','梅丽燕','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '梅丽燕');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '楼','楼','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '楼');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '江长冲','江长冲','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '江长冲');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '罗琴','罗琴','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '罗琴');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '胡佳瑶','胡佳瑶','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '胡佳瑶');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '胡俏倩','胡俏倩','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '胡俏倩');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '胡姗姗','胡姗姗','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '胡姗姗');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '胡振杭','胡振杭','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '胡振杭');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '胡振航','胡振航','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '胡振航');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '胡敏达','胡敏达','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '胡敏达');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '蓝海霞','蓝海霞','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '蓝海霞');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '薛奇汶','薛奇汶','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '薛奇汶');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '詹彪','詹彪','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '詹彪');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '许航飞','许航飞','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '许航飞');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '赵国梁','赵国梁','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '赵国梁');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '郑嫣娜','郑嫣娜','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '郑嫣娜');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '郑瑞笔','郑瑞笔','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '郑瑞笔');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '阿娜','阿娜','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '阿娜');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '陈然','陈然','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '陈然');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '马燕芬','马燕芬','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '马燕芬');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '黄淑芬','黄淑芬','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '黄淑芬');
insert into admin(username,realname,mobile,salt,password,create_time,update_time,status) select '黄玲丽','黄玲丽','','1234','8d421e892a47dff539f46142eb09e56b',current_timestamp,current_timestamp,0 from dual where not exists (select 1 from admin where username = '黄玲丽');

UPDATE jh_order o,admin a SET o.admin_id = a.id WHERE o.admin_id = 1 AND o.ywy = a.username;



