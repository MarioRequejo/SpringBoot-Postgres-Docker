package com.example.postgres.springpostgresdocker.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Employee extends EmployeeAudit{
	
	@Id
    @GeneratedValue
    private int id;
	
	
    private String name;

    
	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
