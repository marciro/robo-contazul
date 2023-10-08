package br.com.contaazul.challengerobot.model.command;

import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.Valid;

/**
 * Interface que define um comando executável do robô.
 */
public interface RobotCommand {
	
	/**
	 * Método que executa um comando para o robô a partir de um estado corrente
	 * @param currentState Estado atual do robô
	 * @return Novo estado do robô após a execução do comando.
	 */
	public RobotPosition execute(RobotPosition currentState );

}
