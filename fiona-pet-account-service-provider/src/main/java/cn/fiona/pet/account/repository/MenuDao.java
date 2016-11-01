/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.fiona.pet.account.repository;

import cn.fiona.pet.account.entity.Menu;
import cn.fiona.pet.account.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MenuDao extends PagingAndSortingRepository<Menu, String> {
	Menu findByCode(String code);

	List<Menu> findByParentMenuCodeOrderByOrderAsc(String code);
}
