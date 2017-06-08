insert into t_role (id,name,code,`describe`) values('42ed144b-76ef-4634-ba6b-b6664105401d','美容','service','洗澡,修剪');

-- ----------------------------
-- Table data for t_role_menu
-- ----------------------------
-- 美容 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0320','nurse');
INSERT INTO t_role_menu (id, menu_code, role_code) VALUES (uuid(), 'FM0320', 'face');
INSERT INTO t_role_menu (id, menu_code, role_code) VALUES (uuid(), 'FM0320', 'sales-staff');


