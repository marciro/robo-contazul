package br.com.contaazul.challengerobot.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

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
	
	public RobotPosition(
			@NotNull(message = "{validation.axisx.NotNull}") @Positive(message = "{validation.axisx.Positive}") @Max(value = 5, message = "{validation.axisx.Maximum}") Byte axisXPos,
			@NotNull(message = "{validation.axisy.NotNull}") @Positive(message = "{validation.axisy.Positive}") @Max(value = 5, message = "{validation.axisy.Maximum}") Byte axisYPos,
			@NotNull(message = "{validation.direction.NotNull}") @Pattern(regexp = "([N|n|S|s|W|w|E|e])\\w+", message = "Comandos só devem conter os caracteres N,n,S,s,W,w,E,e") String direction,
			UUID robotIdentifier) {
		super();
		this.axisXPos = axisXPos;
		this.axisYPos = axisYPos;
		this.direction = direction;
		this.robotIdentifier = robotIdentifier;
	}

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

	public Byte getAxisXPos() {
		return axisXPos;
	}

	public void setAxisXPos(Byte axisXPos) {
		this.axisXPos = axisXPos;
	}

	public Byte getAxisYPos() {
		return axisYPos;
	}

	public void setAxisYPos(Byte axisYPos) {
		this.axisYPos = axisYPos;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public UUID getRobotIdentifier() {
		return robotIdentifier;
	}

	public void setRobotIdentifier(UUID robotIdentifier) {
		this.robotIdentifier = robotIdentifier;
	}

}
