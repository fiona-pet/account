-- ----------------------------
-- Table data for t_role_menu
-- ----------------------------

-- 病例管理 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0312','nurse');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0312','doctor');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0312','face');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0312','sales-staff');

-- 直接销售 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0303','face');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0303','sales-staff');

-- 销售查询 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0317','face');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0317','sales-staff');
