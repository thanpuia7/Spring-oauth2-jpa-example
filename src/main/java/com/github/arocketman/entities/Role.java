package com.github.arocketman.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Role {

	@Id
	@GeneratedValue
	private Integer role_id;

	private String role;

	public Role(String role) {
		
		this.role = role;
	}
	
	


}


