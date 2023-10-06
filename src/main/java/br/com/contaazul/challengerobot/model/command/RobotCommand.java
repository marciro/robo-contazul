package br.com.contaazul.challengerobot.model.command;

import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.Valid;

public interface RobotCommand {
	
	public RobotPosition execute(RobotPosition currentState );

}
