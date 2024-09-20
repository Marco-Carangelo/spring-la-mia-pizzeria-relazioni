package org.lessons.java.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Role {
	
	@Id
	private Integer id;
	
	@NotNull
	private String name;
	

}
