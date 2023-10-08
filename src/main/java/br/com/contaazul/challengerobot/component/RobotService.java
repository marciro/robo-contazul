package br.com.contaazul.challengerobot.component;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contaazul.challengerobot.exception.RobotException;
import br.com.contaazul.challengerobot.model.RobotPosition;
import br.com.contaazul.challengerobot.model.command.CommandableRobot;
import br.com.contaazul.challengerobot.model.command.RobotCommand;
import io.micrometer.common.util.StringUtils;

@Service
public class RobotService implements CommandableRobot<RobotCommand> {

	@Autowired
	private RobotPositionValidator validator;
	
	
	@Override
	public RobotPosition executeCommand(UUID robotIdentifier, List<RobotCommand> commands) throws RobotException {
	
		RobotPosition executeCommand = CommandableRobot.super.executeCommand(robotIdentifier, commands);
        String validate = validator.validate(executeCommand);
        
        if(StringUtils.isNotEmpty(validate)) {
        	throw new RobotException(validate);
        }
        	return executeCommand;
	}
	
	
}
