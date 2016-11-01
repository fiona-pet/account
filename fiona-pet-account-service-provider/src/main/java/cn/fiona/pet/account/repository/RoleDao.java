/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.fiona.pet.account.repository;

import cn.fiona.pet.account.entity.Role;
import cn.fiona.pet.account.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleDao extends PagingAndSortingRepository<Role, String> {
	Role findByName(String name);

	Role findByCode(String code);
}
