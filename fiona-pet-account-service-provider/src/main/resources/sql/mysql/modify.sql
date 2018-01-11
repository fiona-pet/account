ALTER TABLE fiona_pet_account.t_user ADD person_id VARCHAR(36) NULL;
update fiona_pet_account.t_user set person_id = id;