package br.com.contaazul.challengerobot.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class RobotResponse {
    
	private Byte axisXPos; 
	private Byte axisYPos;
	private String direction;
	private UUID robotIdentifier;
	
	public static RobotResponse fromPosition(RobotPosition position){
		return new RobotResponse(position.getAxisXPos(), position.getAxisYPos(),position.getDirection(),position.getRobotIdentifier());
	}
	
}
