package com.SpringBoot.webapp.Todo;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	
	@Size(min=10,message="Enter atleast 10 characters")
	private String description ;
	private LocalDate targetDate;
	private boolean done;
	
}
