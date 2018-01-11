delete from fiona_pet_account.t_organize where id='9b06d376-44ff-4153-9b31-c29a19b8da29';
INSERT INTO fiona_pet_account.t_organize (id, name, code) VALUES ('bj', '北京福莱', 'default');
INSERT INTO fiona_pet_account.t_organize (id, name, code) VALUES ('lf', '廊坊福莱', 'lf');

update t_user set enterprise_id='bj' where enterprise_id = '9b06d376-44ff-4153-9b31-c29a19b8da29';

INSERT INTO `fiona_pet_account`.`t_user` (`id`, `enterprise_id`, `login_name`, `name`, `password`, `salt`, `register_date`, `status`) VALUES ('fc5db3b3-4063-4a12-a511-880ba19e4b10', 'bj', 'bjadmin', '北京院长', '179fed1ed04a762cd998897c5efbcc787c441463', '7efbd59d9741d34f', '2018-01-11 10:20:47', 'OK');
INSERT INTO `fiona_pet_account`.`t_user` (`id`, `enterprise_id`, `login_name`, `name`, `password`, `salt`, `register_date`, `status`) VALUES ('fc5db3b3-4063-4a12-a511-880ba19e4b11', 'lf', 'lfadmin', '廊坊院长', '179fed1ed04a762cd998897c5efbcc787c441463', '7efbd59d9741d34f', '2018-01-11 10:20:47', 'OK');

INSERT INTO `fiona_pet_account`.`t_user_role` (`user_id`, `role_id`) VALUES ('fc5db3b3-4063-4a12-a511-880ba19e4b10', '8890e122-d989-4800-8bee-23cc345e13ba');
INSERT INTO `fiona_pet_account`.`t_user_role` (`user_id`, `role_id`) VALUES ('fc5db3b3-4063-4a12-a511-880ba19e4b11', '8890e122-d989-4800-8bee-23cc345e13ba');

