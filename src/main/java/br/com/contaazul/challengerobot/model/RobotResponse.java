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
    
	@NotNull(message = "{validation.age.NotNull}")
	@Positive(message = "{validation.age.Positive}")
    @Max(value = 18, message = "{validation.age.Maximum}")
	private Byte axisXPos; 
	
    @NotNull(message = "{validation.age.NotNull}")
    @Positive(message = "{validation.age.Positive}")
    @Max(value = 18, message = "{validation.age.Maximum}")
	private Byte axisYPos;
	
    
	private UUID robotIdentifier;
	
	
	public static RobotResponse fromPosition(RobotPosition position){
		return new RobotResponse(position.getAxisXPos(), position.getAxisXPos(), position.getRobotIdentifier());
	}
	
}
