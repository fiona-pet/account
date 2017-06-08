insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'统计报表','M00800','javascript:;','fa fa-file-text','统计报表','M00000',false, 1);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'统计报表','FM00801','#/amchart/dashboard','fa fa-th-large','统计报表','M00800');
-- ----------------------------
-- Table data for t_role_menu
-- ----------------------------
-- 住院管理 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0314','face');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0314','sales-staff');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0314','nurse');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0314','doctor');

-- 统计报表 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM00801','admin');
