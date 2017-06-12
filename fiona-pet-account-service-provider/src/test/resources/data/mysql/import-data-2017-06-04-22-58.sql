-- ----------------------------
-- Table data for t_role_menu
-- ----------------------------
-- 寄养管理 --
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0313','face');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0313','sales-staff');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0313','nurse');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0313','doctor');


insert into t_user_role (user_id,role_id) values('402881ce5b85710c015b98c1ad7a0003','59061794-7df9-49b5-a5e4-b786073c2b80');