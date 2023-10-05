package br.com.contaazul.challengerobot.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RobotPosition {

	@NotNull(message = "{validation.axisx.NotNull}")
	@Positive(message = "{validation.axisx.Positive}")
    @Max(value = 5, message = "{validation.axisx.Maximum}")
	private Byte axisXPos; 
	
    @NotNull(message = "{validation.axisy.NotNull}")
    @Positive(message = "{validation.axisy.Positive}")
    @Max(value = 5, message = "{validation.axisy.Maximum}")
	private Byte axisYPos;
    
    @NotNull(message = "{validation.direction.NotNull}")
    @Pattern(regexp = "([N|n|S|s|W|w|E|e|M|m])\\w+", message = "Comandos só devem conter os caracteres N,n,S,s,W,w,E,e,M,m")
    private char direction;
    
	private UUID robotIdentifier;

}
