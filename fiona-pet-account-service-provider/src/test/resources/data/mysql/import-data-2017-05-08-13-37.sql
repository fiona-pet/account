insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'业绩报表','FM00802','#/doctor/dashboard','fa fa-th-large','业绩报表','M00800');
-- ----------------------------
-- Table data for t_role_menu
-- ----------------------------

-- 统计报表 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM00802','doctor');
