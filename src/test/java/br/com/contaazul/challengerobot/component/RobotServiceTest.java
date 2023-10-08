package br.com.contaazul.challengerobot.component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.contaazul.challengerobot.common.ChallengeRobotConstants;
import br.com.contaazul.challengerobot.exception.RobotException;
import br.com.contaazul.challengerobot.model.RobotPosition;
import br.com.contaazul.challengerobot.model.command.MoveForwardCommand;
import br.com.contaazul.challengerobot.model.command.RobotCommand;
import br.com.contaazul.challengerobot.model.command.TurnLeftRobotCommand;

@ExtendWith(MockitoExtension.class)
public class RobotServiceTest {

	@Mock
	private RobotPositionValidator validator;

	@InjectMocks
	private RobotService robotService;

	@Test
	public void testExecuteCommandWithValidCommands() throws RobotException {

		UUID robotIdentifier = UUID.randomUUID();
		MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
		List<RobotCommand> commands = Collections.singletonList(moveForwardCommand);
		RobotPosition robotPosition = RobotPosition.builder().axisXPos((byte) 0)
															 .axisYPos((byte) 1)
															 .direction(ChallengeRobotConstants.NORTH_DIRECTION).build();
		when(validator.validate(any(RobotPosition.class))).thenReturn("");

		RobotPosition result = robotService.executeCommand(robotIdentifier, commands);
        robotPosition.setRobotIdentifier(result.getRobotIdentifier());
		assertThat(result).isEqualTo(robotPosition);
		verify(validator, times(1)).validate(robotPosition);
	}

	@Test
	public void testExecuteCommandWithInvalidCommands() {
		UUID robotIdentifier = UUID.randomUUID();
		TurnLeftRobotCommand turnLeftCommand = new TurnLeftRobotCommand();
		List<RobotCommand> commands = Collections.singletonList(turnLeftCommand);

		String errorMessage = "Invalid command";

		when(validator.validate(any(RobotPosition.class))).thenReturn(errorMessage);

		try {
			robotService.executeCommand(robotIdentifier, commands);
		} catch (RobotException e) {
			assertThat(e.getMessage()).isEqualTo(errorMessage);
		}

		verify(validator, times(1)).validate(any(RobotPosition.class));
	}
}
