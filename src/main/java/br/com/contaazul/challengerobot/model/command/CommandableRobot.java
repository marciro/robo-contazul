package br.com.contaazul.challengerobot.model.command;

import static br.com.contaazul.challengerobot.ChallengeRobotConstants.NORTH_DIRECTION;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.START_POSITION_X;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.START_POSITION_Y;

import java.util.List;
import java.util.UUID;

import br.com.contaazul.challengerobot.exception.RobotException;
import br.com.contaazul.challengerobot.model.RobotPosition;


public interface CommandableRobot<C extends RobotCommand> {
	
	default RobotPosition executeCommand(UUID robotIdentifier,List<C> commands) throws RobotException {
		
		RobotPosition current = new RobotPosition(START_POSITION_X,START_POSITION_Y,NORTH_DIRECTION,robotIdentifier);
		
		for (C command : commands) {
			current = command.execute(current);
		}
		return current;
	}	
}
