package br.com.contaazul.challengerobot.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RobotResponse {
    
	private Byte axisXPos; 
	private Byte axisYPos;
	private UUID robotIdentifier;
	
	
	public static RobotResponse fromPosition(RobotPosition position){
		return new RobotResponse(position.getAxisXPos(), position.getAxisXPos(), position.getRobotIdentifier());
	}
	
}
