-- ----------------------------
-- uuid https://www.uuidgenerator.net/
-- ----------------------------

-- ----------------------------
-- Table data for t_user
-- ----------------------------
insert into t_user (id,enterprise_id, login_name, name, password, salt, register_date) values('fc5db3b3-4063-4a12-a511-880ba19e4b58','9b06d376-44ff-4153-9b31-c29a19b8da29','admin','Admin','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','2012-06-04 01:00:00');
insert into t_user (id,enterprise_id, login_name, name, password, salt, register_date) values('f7419766-8544-47f7-8aca-b8b48e7698fc','9b06d376-44ff-4153-9b31-c29a19b8da29','user','Calvin','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00');
-- ----------------------------
-- Table data for t_role
-- ----------------------------
insert into t_role (id,name,code,`describe`) values('8890e122-d989-4800-8bee-23cc345e13ba','admin','admin','系统管理员');
insert into t_role (id,name,code,`describe`) values('b57c2d66-4ebf-4a20-9eb1-e47c8ede27c8','销售员','sales-staff','挂号,结帐,会员注册登记');
insert into t_role (id,name,code,`describe`) values('59061794-7df9-49b5-a5e4-b786073c2b80','医生','doctor','就诊,开单,化验,检查');
insert into t_role (id,name,code,`describe`) values('42ed144b-76ef-4634-ba6b-b6664105401c','护士','nurse','出药,打针,盘点');
-- ----------------------------
-- Table data for t_user_role
-- ----------------------------
insert into t_user_role (user_id,role_id) values('fc5db3b3-4063-4a12-a511-880ba19e4b58','8890e122-d989-4800-8bee-23cc345e13ba');
-- ----------------------------
-- Table data for t_menu
-- ----------------------------
-- 业务办理 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf) values(uuid(),'业务办理','M00000','#','nav-item','业务办理','M',false);
--  诊疗服务 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'诊疗服务','M00350','javascript:;','fa fa-medkit','诊疗服务','M00000',FALSE,2);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'就诊管理','FM0306','#/curemanager/list','fa fa-stethoscope','就诊管理','M00350');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'驱虫疫苗','FM0310','fa fa-stethoscope','#/invaccine/list','驱虫疫苗','M00350');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'病案管理','FM0312','#/medicalrecord/list','fa fa-sticky-note','病案管理','M00350');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'处方模板管理','FM0608','#/prescription/list','fa fa-stethoscope','处方模板管理','M00350');
--  诊疗服务 --
--  前台服务 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'前台服务','M00300','javascript:;','fa fa-file-text','前台服务','M00000',false, 1);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'门诊挂号','FM0301','#/register/search','/register/search','门诊挂号','M00300');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'门诊收费','FM0302','#/payment/list','fa fa-th-large','门诊收费','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'直接销售','FM0303','#/saleplatedetail','fa fa-suitcase','直接销售','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'挂号查询','FM0304','#/register/search','fa fa-th-large','挂号查询','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'收费管理','FM0305','#/payment/list','fa fa-th-large','收费管理','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'寄养管理','FM0313','#/fosterage/list','fa fa-th-large','寄养管理','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'住院管理','FM0314','#/inhospital/list','fa fa-hospital-o','住院管理','M00300');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'自助短信','FM0315','Business/SMSBySelf','nav-item','自助短信','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'销售查询','FM0317','#/saleplate','fa fa-suitcase','销售查询','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'结算单管理','FM0316','#/statement/list','fa fa-th-large','结算单管理','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'挂号查询','FM0318','#/register/search','fa fa-th-large','挂号查询','M00300');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'快捷挂号','FM0319','TR.PHM.WPFClient.WinRandomGestRegist','nav-item','快捷挂号','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'美容服务','FM0320','#/beauty/list','fa fa-th-large','美容服务','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'预约管理','FM0370','#/bespeak/list','fa fa-th-large','预约管理','M00300');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'销售退货','FM0321','#/itback/list','fa fa-th-large','销售退货','M00300');
--  前台服务 --
--  化验影像 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'化验影像','M00380','#','fa fa-flask','化验影像','M00000',FALSE,3);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'化验管理','FM0307','#/analysed/list','fa fa-flask','化验管理','M00350');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'影像管理','FM0308','#/film/list','fa fa-camera-retro','影像管理','M00350');
--  化验影像 --
--  护士工作站 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'护士工作站','M00390','#','nav-item','','M00000',FALSE,4);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'处方执行','FM0309','#/execute/execute_list','fa fa-camera-retro','处方执行','M00350');
--  护士工作站 --
--  短信&微信营销 --
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'短信&微信营销','FM0900','#','nav-item','','M00000',FALSE,5);
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'自助短信','FM0902','SMSManagement/SMSSendList','nav-item','自助短信','FM0900');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'短信设置','FM0903','SMSManagement/SMSConfigPage','nav-item','短信设置','FM0900');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'微信设置','FM1002','MicroSMS/MicroSMSConfigPage','nav-item','微信设置','FM0900');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'微网站管理','FM1011','MicroSMS/MicroWeb','nav-item','微网站管理','FM0900');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'会员关注','FM1001','MicroSMS/VIPSMSManageList','nav-item','会员关注','FM0900');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'短信查询','FM0901','SMSManagement/SMSManage','nav-item','短信查询','FM0900');
-- --  短信&微信营销 --
--  经营管理 --
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'经营管理','FM0700','#','nav-item','','M00000',FALSE,6);
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'支出管理','FM0701','OperateManagement/ExpenseManageList','nav-item','支出管理','FM0700');
--  经营管理 --
--  会员信息 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'会员信息','FM0100','javascript:;','glyphicon glyphicon-credit-card','','M00000',FALSE,7);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'宠物管理','FM0102','#/pet/list','fa fa-paw','宠物管理','FM0100');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'会员管理','FM0101','#/vip/list','fa fa-user','会员管理','FM0100');
--  会员信息 --
--  统计报表 --
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf,`order`) values(uuid(),'统计报表','FM0400','#','nav-item','','M00000',FALSE,8);
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'库存资产统计','FM0401','StatisticsBusiness/CurrentProperty','nav-item','库存资产统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'营业收入统计','FM0402','StatisticsBusiness/TotalEarnMoney','nav-item','营业收入统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'挂号就诊统计','FM0403','StatisticsBusiness/TotalRegisterRecord','nav-item','挂号就诊统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'就诊分期统计','FM0404','StatisticsBusiness/RegisterRecordCount','nav-item','就诊分期统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'效绩考核统计','FM0702','StatisticsBusiness/CountAchievement','nav-item','效绩考核统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'门店收支统计','FM0703','StatisticsBusiness/CountInCome','nav-item','门店收支统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'会员消费统计','FM0704','StatisticsBusiness/CountVIPCost','nav-item','会员消费统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'病例统计','FM0405','StatisticsBusiness/TotalMedicalRecord','nav-item','病例统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'毛利统计','FM0707','StatisticsBusiness/CountMargin','nav-item','毛利统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'商品销售统计','FM0708','StatisticsBusiness/CountItemSell','nav-item','商品销售统计','FM0400');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'商品采购统计','FM0709','StatisticsBusiness/CountItemPurchase','nav-item','商品采购统计','FM0400');
--  统计报表 --
--  会员信息 --
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf) values(uuid(),'系统管理','FM0500','#','nav-item','','M00000',FALSE);
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'登录日志','FM0501','Maintain/LoginLog','nav-item','登录日志','FM0500');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'密码变更','FM0505','TR.PHM.WpfClient.Maintain.PWChange','nav-item','密码变更','FM0500');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'备份还原','FM0506','TR.PHM.WPFClient.DBChooseMenu','nav-item','备份还原','FM0500');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'设置向导','FM0507','TR.PHM.WPFClient.WinNavigation','nav-item','设置向导','FM0500');
--  会员信息 --
--  基础数据 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf) values(uuid(),'基础数据','FM0600','javascript:;','glyphicon glyphicon-hdd','','M00000',FALSE);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'经销商与生产商','FM0601','#/dealer/list','glyphicon glyphicon-compressed','经销商与生产商','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'仓库信息管理','FM0602','#/storage/list','fa fa-university','仓库信息管理','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'商品与服务管理','FM0603','#/product/list','fa fa-shopping-bag','商品与服务管理','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'会员等级管理','FM0604','#/grade/list','fa fa-signal','会员等级管理','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'数据字典管理','FM0605','#/dictionary/list','fa fa-book','数据字典管理','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'员工管理','FM0606','#/personnel/list','fa fa-user-md','','FM0600');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'按钮配置','FM0607','SetButton','nav-item','','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'化验项目管理','FM0609','#/labwork/list','fa fa-flask','','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'宠物品种管理','FM0610','#/varietie/list','fa fa-paw','','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'医院信息','FM0502','#/hospital/list','fa fa-hospital-o','','FM0600');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'应用参数','FM0503','BaseDataManagement/ConfigPage','nav-item','','FM0600');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'角色管理','FM0504','/role/list','icon-eyeglasses','','FM0600');
--  基础数据 --
--  仓库管理 --
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id,leaf) values(uuid(),'仓库管理','FM0200','javascript:;','fa fa-university','','M00000',FALSE);
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'库存查询','FM0201','#/stock/list','fa fa-th-large','','FM0200');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'入库管理','FM0202','#/instorage/list','fa fa-th-large','','FM0200');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'出库管理','FM0203','#/outstorage/list','fa fa-th-large','','FM0200');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'移库管理','FM0204','#/movestorage/list','fa fa-th-large','','FM0200');
-- insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'盘点管理','FM0205','WarehouseManagement/CheckWarehouseList','nav-item','','FM0200');
insert into t_menu (id,name,code,uri,icon_class,`describe`,parent_id) values(uuid(),'退货管理','FM0206','#/backstorage/list','fa fa-th-large','','FM0200');
--  仓库管理 --
-- 系统应用模块 --


-- ----------------------------
-- Table data for t_role_menu
-- ----------------------------
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0306','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0310','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0312','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0608','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0301','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0303','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0304','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0305','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0313','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0314','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0317','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0316','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0318','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0320','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0370','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0321','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0307','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0308','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0309','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0102','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0101','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0601','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0602','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0603','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0604','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0605','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0606','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0609','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0610','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0502','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0504','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0201','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0202','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0203','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0204','admin');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0206','admin');


insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0306','doctor');
insert into t_role_menu (id,menu_code,role_code) values(uuid(),'FM0318','doctor');



-- ----------------------------
-- Table data for t_organize
-- ----------------------------
insert into t_organize (id, name, code) values('9b06d376-44ff-4153-9b31-c29a19b8da29','北京福莱','default');