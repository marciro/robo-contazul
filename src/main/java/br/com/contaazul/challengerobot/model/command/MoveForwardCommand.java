package br.com.contaazul.challengerobot.model.command;

import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.EAST_DIRECTION;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.NORTH_DIRECTION;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.ONE_STEP;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.SOUTH_DIRECTION;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.WEST_DIRECTION;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.contaazul.challengerobot.common.ChallengeRobotMessages;
import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.Valid;

/**
 * Classe responsável por executar o comando de mover para frente do robô
 * 
 */
@Validated
@Component
public class MoveForwardCommand implements RobotCommand {

	

	@Override
	public RobotPosition execute(@Valid RobotPosition currentState) {
		
		switch (currentState.getDirection()) {
		case NORTH_DIRECTION: {
			currentState.addAxisYPos(ONE_STEP);
			return currentState;
		}
		case SOUTH_DIRECTION: {
			currentState.subtractAxisYPos(ONE_STEP);
			return currentState;
		}
		case WEST_DIRECTION: {
			currentState.subtractAxisXPos(ONE_STEP);
			return currentState;
		}
		case EAST_DIRECTION: {
			currentState.addAxisXPos(ONE_STEP);
			return currentState;
		}

		default:
			throw new IllegalArgumentException(ChallengeRobotMessages.UNEXPECTED_DIRECTION + currentState.getDirection());
		}
		
		
		
	}

}
