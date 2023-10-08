package br.com.contaazul.challengerobot.component;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contaazul.challengerobot.common.ChallengeRobotMessages;
import br.com.contaazul.challengerobot.exception.RobotException;
import br.com.contaazul.challengerobot.model.RobotPosition;
import br.com.contaazul.challengerobot.model.command.CommandableRobot;
import br.com.contaazul.challengerobot.model.command.RobotCommand;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe responsável por gerenciar a comunicação do robô provendo execução de
 * comandos e validando seu estado.
 */
@Service
@Slf4j
public class RobotService implements CommandableRobot<RobotCommand> {

	@Autowired
	private RobotPositionValidator validator;

	@Override
	public RobotPosition executeCommand(UUID robotIdentifier, List<RobotCommand> commands) throws RobotException {
		log.info("Iniciando a execução dos comandos para o robô {}", robotIdentifier);

		RobotPosition executeCommand = CommandableRobot.super.executeCommand(robotIdentifier, commands);
		String validate = validator.validate(executeCommand);

		if (StringUtils.isNotEmpty(validate)) {
			log.error(ChallengeRobotMessages.INVALID_COMMAND_EXECUTION, validate);
			throw new RobotException(validate);
		}
		
		log.info("Comandos executados com sucesso para o robô {}", robotIdentifier);
		return executeCommand;
	}

}
