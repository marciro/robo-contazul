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
    @Pattern(regexp = "([N|n|S|s|W|w|E|e])\\w+", message = "Comandos só devem conter os caracteres N,n,S,s,W,w,E,e")
    private String direction;
    
	private UUID robotIdentifier;
	
	
	public void addAxisXPos(byte step) {
		setAxisXPos(Byte.valueOf((byte)(getAxisXPos()+step)) ) ;
	}
	
	public void subtractAxisXPos(byte step) {
		setAxisXPos(Byte.valueOf((byte)(getAxisXPos()-step))) ;
	}

	public void subtractAxisYPos(byte step) {
		setAxisYPos(Byte.valueOf((byte)(getAxisYPos()-step)) ) ;
		
	}
	public void addAxisYPos(byte step) {
		setAxisYPos(Byte.valueOf((byte)(getAxisYPos()+step))) ;
	}

}
