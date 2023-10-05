package br.com.contaazul.challengerobot.model.command;

import static org.apache.commons.lang.StringUtils.split;
import static org.apache.commons.lang.StringUtils.upperCase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class CommandConverter {

	public List<RobotCommand> convertToCommandList(String rawCommandList) {
		String[] splitteredCommands = split(upperCase(rawCommandList));
		return Stream.of(splitteredCommands).map(this::convertToRobotCommand).collect(Collectors.toList());
	}

	private RobotCommand convertToRobotCommand(String strCommand) {

		switch (strCommand) {
		case "M":
			return new MoveForwardCommand();
		case "L":
			return new TurnLeftRobotCommand();
		case "R":
			return new TurnRightRobotCommand();

		default:
			throw new IllegalArgumentException("Unexpected value: " + strCommand);
		}
	}
}
