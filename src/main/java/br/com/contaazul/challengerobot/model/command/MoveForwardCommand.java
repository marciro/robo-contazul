package br.com.contaazul.challengerobot.model.command;

import static br.com.contaazul.challengerobot.ChallengeRobotConstants.EAST_DIRECTION;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.NORTH_DIRECTION;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.ONE_STEP;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.SOUTH_DIRECTION;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.WEST_DIRECTION;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.Valid;

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
			throw new IllegalArgumentException("Unexpected value: " + currentState.getDirection());
		}
		
		
		
	}

}
