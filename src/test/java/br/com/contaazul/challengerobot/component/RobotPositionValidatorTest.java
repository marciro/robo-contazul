package br.com.contaazul.challengerobot.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.contaazul.challengerobot.common.ChallengeRobotConstants;
import br.com.contaazul.challengerobot.model.RobotPosition;

@ExtendWith(MockitoExtension.class)
public class RobotPositionValidatorTest {

	@InjectMocks
	private RobotPositionValidator robotPositionValidator;

	@Test
	void testValidateInitialPosition() {
		RobotPosition position = RobotPosition.builder().axisXPos((byte) 0).axisYPos((byte) 0)
				.direction(ChallengeRobotConstants.NORTH_DIRECTION).build();

		String result = robotPositionValidator.validate(position);
		assertEquals("", result);
	}

	@Test
	void testValidateTwoStepToEast() {

		RobotPosition position = RobotPosition.builder().axisXPos((byte) 2).axisYPos((byte) 0)
				.direction(ChallengeRobotConstants.EAST_DIRECTION).build();

		String result = robotPositionValidator.validate(position);

		assertEquals("", result);
	}

	@Test
	void testValidateOutOfBoundsX() {

		RobotPosition position = RobotPosition.builder().axisXPos((byte) 6).axisYPos((byte) 0)
				.direction(ChallengeRobotConstants.EAST_DIRECTION).build();

		String result = robotPositionValidator.validate(position);
		assertEquals("Posição no eixo X excedeu o máximo.", result);
	}

	@Test
	void testValidateOutOfBoundsY() {

		RobotPosition position = RobotPosition.builder().axisXPos((byte) 0).axisYPos((byte) 6)
				.direction(ChallengeRobotConstants.EAST_DIRECTION).build();

		String result = robotPositionValidator.validate(position);
		assertEquals("Posição no eixo Y excedeu o máximo.", result);
	}

	@Test
	void testValidateNegativeX() {

		RobotPosition position = RobotPosition.builder().axisXPos((byte) -1).axisYPos((byte) 0)
				.direction(ChallengeRobotConstants.EAST_DIRECTION).build();

		String result = robotPositionValidator.validate(position);
		assertEquals("Posição no eixo X deve ser positiva.", result);
	}

	@Test
	void testValidateNegativeY() {

		RobotPosition position = RobotPosition.builder().axisXPos((byte) 0).axisYPos((byte) -1)
				.direction(ChallengeRobotConstants.EAST_DIRECTION).build();

		String result = robotPositionValidator.validate(position);
		assertEquals("Posição no eixo Y deve ser positiva.", result);
	}

	@Test
	void testValidateDirection() {

		RobotPosition position = RobotPosition.builder().axisXPos((byte) 5).axisYPos((byte) 0)
				.direction("X").build();

		String result = robotPositionValidator.validate(position);
		assertEquals("Comandos só devem conter os caracteres N,n,S,s,W,w,E,e.", result);
	}

	
}
