package br.com.contaazul.challengerobot.model.command;

import br.com.contaazul.challengerobot.model.RobotPosition;

public class TurnRightRobotCommand implements RobotCommand{

	@Override
	public RobotPosition execute(RobotPosition currentPosition) {
		return currentPosition;
	}

}
