package br.com.contaazul.challengerobot.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contaazul.challengerobot.common.ChallengeRobotConstants;
import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TurnLeftRobotCommandTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testExecuteTurnLeftFromNorth() {
        TurnLeftRobotCommand turnLeftRobotCommand = new TurnLeftRobotCommand();
        
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.NORTH_DIRECTION).build();


        RobotPosition result = turnLeftRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.WEST_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnLeftFromSouth() {
        TurnLeftRobotCommand turnLeftRobotCommand = new TurnLeftRobotCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.SOUTH_DIRECTION).build();

        RobotPosition result = turnLeftRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.EAST_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnLeftFromWest() {
        TurnLeftRobotCommand turnLeftRobotCommand = new TurnLeftRobotCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.WEST_DIRECTION).build();


        RobotPosition result = turnLeftRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.SOUTH_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnLeftFromEast() {
        TurnLeftRobotCommand turnLeftRobotCommand = new TurnLeftRobotCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.EAST_DIRECTION).build();

        RobotPosition result = turnLeftRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.NORTH_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnLeftInvalidDirection() {
        TurnLeftRobotCommand turnLeftRobotCommand = new TurnLeftRobotCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction("UNKNOWN").build();


        assertThrows(IllegalArgumentException.class, () -> {
            turnLeftRobotCommand.execute(currentPosition);
        });
    }
}

