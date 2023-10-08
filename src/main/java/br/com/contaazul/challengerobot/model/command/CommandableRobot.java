package br.com.contaazul.challengerobot.model.command;

import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.NORTH_DIRECTION;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.START_POSITION_X;
import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.START_POSITION_Y;

import java.util.List;
import java.util.UUID;

import br.com.contaazul.challengerobot.exception.RobotException;
import br.com.contaazul.challengerobot.model.RobotPosition;


/**
 * Interface que define um robô comandável
 * @param <C> Classe que implementa um comando válido para o robô
 */
public interface CommandableRobot<C extends RobotCommand> {
	
	/**
	 * Executa uma lista de comandos para um determinado robô.
	 * 
	 * @param robotIdentifier Identificador do robô que executará os comandos enviados.
	 * @param commands Lista de comandos para serem executados.  
	 * @return Posição final do robô após a execução dos comandos.
	 * @throws RobotException
	 */
	default RobotPosition executeCommand(UUID robotIdentifier,List<C> commands) throws RobotException {
		
		//Definindo a posição inicial do robô antes de executar os comandos
		RobotPosition current = RobotPosition.builder().axisXPos(START_POSITION_X)
													   .axisYPos(START_POSITION_Y)
													   .direction(NORTH_DIRECTION)
													   .robotIdentifier(robotIdentifier)
													   .build();
		
		for (C command : commands) {
			current = command.execute(current);
		}
		return current;
	}	
}
