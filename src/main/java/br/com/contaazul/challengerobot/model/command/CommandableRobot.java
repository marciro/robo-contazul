package br.com.contaazul.challengerobot.model.command;

import java.util.List;
import java.util.UUID;

import br.com.contaazul.challengerobot.model.RobotPosition;

public interface CommandableRobot<C extends RobotCommand> {
	
	public static final char START_DIRECTION = 'N';
	public static final byte START_POSITION_X = (byte) 0;
	public static final byte START_POSITION_Y = (byte) 0;

	default RobotPosition executeCommand(UUID robotIdentifier,List<C> commands) {
		
		RobotPosition current = RobotPosition.builder().axisXPos(START_POSITION_X)
													   .axisYPos(START_POSITION_Y)
													   .direction(START_DIRECTION)
													   .robotIdentifier(robotIdentifier)
													   .build();
		
		for (C command : commands) {
			current = command.execute(current);
		}
		return current;
	}	
}
