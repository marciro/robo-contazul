package br.com.contaazul.challengerobot.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RobotPosition {

	@NotNull(message = "{validation.axisx.NotNull}")
	@Min(value = 0, message = "{validation.axisx.Positive}")
    @Max(value = 5, message = "{validation.axisx.Maximum}")
	private byte axisXPos; 
	
    @NotNull(message = "{validation.axisy.NotNull}")
    @Min(value = 0, message = "{validation.axisy.Positive}")
    @Max(value = 5, message = "{validation.axisy.Maximum}")
	private byte axisYPos;
    
    @NotNull(message = "{validation.direction.NotNull}")
    @Pattern(regexp = "([N|n|S|s|W|w|E|e])", message = "{validation.axisy.Direction}")
    private String direction;
    
	private UUID robotIdentifier;

	public void addAxisXPos(byte step) {
		setAxisXPos((byte)(getAxisXPos()+step)) ;
	}
	
	public void subtractAxisXPos(byte step) {
		setAxisXPos((byte)(getAxisXPos()-step)) ;
	}

	public void subtractAxisYPos(byte step) {
		setAxisYPos((byte)(getAxisYPos()-step)) ;
		
	}
	public void addAxisYPos(byte step) {
		setAxisYPos((byte)(getAxisYPos()+step)) ;
	}

}
