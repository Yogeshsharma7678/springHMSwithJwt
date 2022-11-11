package com.HMS.dto;

//To validate the variables of room 

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class roomDTO {

	@NotNull(message ="room id can't be  null")
	private int roomId;
	
    @NotNull(message = "roomname can''t be null")
	private String roomName;
	
    @NotNull(message ="room id can't be  null")
    private String roomType;
	
}
