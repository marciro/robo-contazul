package br.com.contaazul.challengerobot.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contaazul.challengerobot.model.Robot;
import br.com.contaazul.challengerobot.model.RobotResponse;
import br.com.contaazul.challengerobot.model.command.CommandConverter;

@RestController
@RequestMapping(value = "/rest")
public class RobotCommandController {

	@Autowired
	private CommandConverter commandConverter;
	
	@Autowired
	private Robot robot;

	
	
	@GetMapping("/mars/{commands}") 
	public ResponseEntity<RobotResponse> moveRobot(@PathVariable String robotCommands) {
		RobotResponse response = RobotResponse.fromPosition(robot.executeCommand(UUID.randomUUID(), commandConverter.convertToCommandList(robotCommands)));
		return ResponseEntity.ok(response);
	}

}
