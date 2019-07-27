-- ----------------------------
-- Table data for t_role_menu
-- ----------------------------
-- 缺货订单 --
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'缺货订单','FM0207','#/backstorage/order','fa fa-th-large','','FM0200');
-- insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0207','admin');

-- 商品统计 --
INSERT INTO `fiona_pet_account`.`t_menu` (`id`, `name`, `code`, `uri`, `icon_class`, `describe`, `status`, `leaf`, `order`, `parent_id`)
VALUES ('b001d129-0707-11e7-837f-f01e3411d8f5', '商品统计', 'FM00805', '#/item/dashboard', 'fa fa-th-large', '商品统计', 'OK', '1', '0', 'M00800');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM00805','admin');

