package br.com.contaazul.challengerobot.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.contaazul.challengerobot.common.ChallengeRobotConstants;
import br.com.contaazul.challengerobot.model.RobotPosition;

public class MoveForwardCommandTest {


    @Test
    public void testExecuteMoveForwardNorth() {
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				 											   .axisYPos((byte) 0)
				 											   .direction(ChallengeRobotConstants.NORTH_DIRECTION).build();
        

        RobotPosition result = moveForwardCommand.execute(currentPosition);

        assertEquals(0, result.getAxisXPos());
        assertEquals(1, result.getAxisYPos());
        assertEquals(ChallengeRobotConstants.NORTH_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteMoveForwardSouth() {
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   											   .axisYPos((byte) 0)
				   											   .direction(ChallengeRobotConstants.SOUTH_DIRECTION).build();

        RobotPosition result = moveForwardCommand.execute(currentPosition);

        assertEquals(0, result.getAxisXPos());
        assertEquals(-1, result.getAxisYPos());
        assertEquals(ChallengeRobotConstants.SOUTH_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteMoveForwardWest() {
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   											   .axisYPos((byte) 0)
				   											   .direction(ChallengeRobotConstants.WEST_DIRECTION).build();

        RobotPosition result = moveForwardCommand.execute(currentPosition);

        assertEquals(-1, result.getAxisXPos());
        assertEquals(0, result.getAxisYPos());
        assertEquals(ChallengeRobotConstants.WEST_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteMoveForwardEast() {
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   											   .axisYPos((byte) 0)
				   											   .direction(ChallengeRobotConstants.EAST_DIRECTION).build();

        RobotPosition result = moveForwardCommand.execute(currentPosition);

        assertEquals(1, result.getAxisXPos());
        assertEquals(0, result.getAxisYPos());
        assertEquals(ChallengeRobotConstants.EAST_DIRECTION, result.getDirection());
    }

    @Test
    public void testExecuteMoveForwardInvalidDirection() {
        MoveForwardCommand moveForwardCommand = new MoveForwardCommand();
		RobotPosition currentPosition = RobotPosition.builder().axisXPos((byte) 0)
				   .axisYPos((byte) 0)
				   .direction("U").build();

        assertThrows(IllegalArgumentException.class, () -> {moveForwardCommand.execute(currentPosition);});
    }
}
