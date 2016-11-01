///*******************************************************************************
// * Copyright (c) 2005, 2014 springside.github.io
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// *******************************************************************************/
//package cn.fiona.pet.account.entity;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * saas模式采用uuid
// * @author baiqw
// */
//// JPA 基类的标识
//@MappedSuperclass
//public abstract class IdEntity implements Serializable {
//	protected String uuid;
//
//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
//	@Column(name = "uuid", length = 32)
//	public String getUuid() {
//		return uuid;
//	}
//
//	public void setUuid(String uuid) {
//		this.uuid = uuid;
//	}
//}
