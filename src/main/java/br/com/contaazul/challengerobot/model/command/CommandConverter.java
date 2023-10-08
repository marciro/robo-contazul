package br.com.contaazul.challengerobot.model.command;

import static br.com.contaazul.challengerobot.common.ChallengeRobotConstants.*;
import static org.apache.commons.lang.StringUtils.upperCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * Classe responsável por converter uma lista de comandos em String em sua implementação de comando.
 */
@Component
public class CommandConverter {



	public static final String COMANDO_INEXISTENTE = "Comando inexistente: ";

	/**
	 * Método conversor em uma lista de comandos em formato String para uma lista de comandos executáveis do robô
	 * @param rawCommandList Lista de comandos em formato String
	 * @return Lista de comandos executáveis do robô,
	 */
	public List<RobotCommand> convertToCommandList(String rawCommandList) {
		List<Character> splitteredCommands = convertStringToCharList(upperCase(rawCommandList));
		return splitteredCommands.stream().map(this::convertToRobotCommand).collect(Collectors.toList());
	}

	private List<Character> convertStringToCharList(String str) {

		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			chars.add(ch);
		}
		return chars;
	}

	private RobotCommand convertToRobotCommand(Character strCommand) {

		switch (strCommand) {
		case MOVE_FORWARD:
			return new MoveForwardCommand();
		case TURN_LEFT:
			return new TurnLeftRobotCommand();
		case TURN_RIGHT:
			return new TurnRightRobotCommand();
		default:
			throw new IllegalArgumentException(COMANDO_INEXISTENTE + strCommand);
		}
	}
}
