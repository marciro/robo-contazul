package br.com.contaazul.challengerobot.model.command;

import static br.com.contaazul.challengerobot.ChallengeRobotConstants.EAST_DIRECTION;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.NORTH_DIRECTION;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.SOUTH_DIRECTION;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.WEST_DIRECTION;

import org.springframework.validation.annotation.Validated;

import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.Valid;

@Validated
public class TurnLeftRobotCommand implements RobotCommand {

	@Override
	public RobotPosition execute(@Valid RobotPosition currentState) {
		switch (currentState.getDirection()) {
		case NORTH_DIRECTION: {
			currentState.setDirection(WEST_DIRECTION);
			return currentState;
		}
		case SOUTH_DIRECTION: {
			currentState.setDirection(EAST_DIRECTION);
			return currentState;
		}
		case WEST_DIRECTION: {
			currentState.setDirection(SOUTH_DIRECTION);
			return currentState;
		}
		case EAST_DIRECTION: {
			currentState.setDirection(NORTH_DIRECTION);
			return currentState;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + currentState.getDirection());
		}

	}

}
