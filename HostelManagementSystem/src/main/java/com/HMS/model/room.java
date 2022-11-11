package com.HMS.model;
//room model to declare room entity
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class room {

	@Id
	private int roomId;
	private String roomName;
	private String roomType;
	
}
