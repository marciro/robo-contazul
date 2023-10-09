package br.com.contaazul.challengerobot.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.contaazul.challengerobot.common.ChallengeRobotConstants;
import br.com.contaazul.challengerobot.model.RobotPosition;

public class TurnRightRobotCommandTest {

    @Test
    public void testExecuteTurnRightFromNorth() {
        TurnRightRobotCommand turnRightRobotCommand = new TurnRightRobotCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.NORTH_DIRECTION).build();


        RobotPosition result = turnRightRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.EAST_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnRightFromSouth() {
        TurnRightRobotCommand turnRightRobotCommand = new TurnRightRobotCommand();

		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.SOUTH_DIRECTION).build();


        RobotPosition result = turnRightRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.WEST_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnRightFromWest() {
        TurnRightRobotCommand turnRightRobotCommand = new TurnRightRobotCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.WEST_DIRECTION).build();


        RobotPosition result = turnRightRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.NORTH_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnRightFromEast() {
        TurnRightRobotCommand turnRightRobotCommand = new TurnRightRobotCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction(ChallengeRobotConstants.EAST_DIRECTION).build();


        RobotPosition result = turnRightRobotCommand.execute(currentPosition);

        assertEquals(ChallengeRobotConstants.SOUTH_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteTurnRightInvalidDirection() {
        TurnRightRobotCommand turnRightRobotCommand = new TurnRightRobotCommand();
        RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction("UNKNOWN").build();


        assertThrows(IllegalArgumentException.class, () -> {
            turnRightRobotCommand.execute(currentPosition);
        });
    }
}
