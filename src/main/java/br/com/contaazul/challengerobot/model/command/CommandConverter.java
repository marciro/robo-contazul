package br.com.contaazul.challengerobot.model.command;

import static org.apache.commons.lang.StringUtils.upperCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import static br.com.contaazul.challengerobot.ChallengeRobotConstants.*;

@Component
public class CommandConverter {



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
			throw new IllegalArgumentException("Comando inexistente: " + strCommand);
		}
	}
}
