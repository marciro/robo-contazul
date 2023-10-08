package br.com.contaazul.challengerobot.model.command;

import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.EAST_DIRECTION;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.NORTH_DIRECTION;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.SOUTH_DIRECTION;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.WEST_DIRECTION;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.contaazul.challengerobot.common.ChallengeRobotMessages;
import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.Valid;



/**
 * Comando para execução do comando para virar 90 graus a direita
 */
@Validated
@Component
public class TurnRightRobotCommand implements RobotCommand{

	

	@Override
	public RobotPosition execute(@Valid RobotPosition currentState) {
		switch (currentState.getDirection()) {
		case NORTH_DIRECTION: {
			currentState.setDirection(EAST_DIRECTION);
			return currentState;
		}
		case SOUTH_DIRECTION: {
			currentState.setDirection(WEST_DIRECTION);
			return currentState;
		}
		case WEST_DIRECTION: {
			currentState.setDirection(NORTH_DIRECTION);
			return currentState;
		}
		case EAST_DIRECTION: {
			currentState.setDirection(SOUTH_DIRECTION);
			return currentState;
		}

		default:
			throw new IllegalArgumentException(ChallengeRobotMessages.UNEXPECTED_VALUE + currentState.getDirection());
		}

	}

}
