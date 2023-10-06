package br.com.contaazul.challengerobot.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contaazul.challengerobot.component.RobotService;
import br.com.contaazul.challengerobot.model.RobotResponse;
import br.com.contaazul.challengerobot.model.command.CommandConverter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping(value = "/rest")
public class RobotCommandController {

	@Autowired
	private CommandConverter commandConverter;
	
	@Autowired
	private RobotService robot;

	@GetMapping("/mars/{commands}") 
	public ResponseEntity<RobotResponse> moveRobot(@Valid @PathVariable("commands") @NotBlank @Pattern(regexp = "([L|l|R|r|M|m])\\w+", message = "Comandos só devem conter os caracteres R,r,L,l,M,m") String robotCommands) {
		RobotResponse response = RobotResponse.fromPosition(robot.executeCommand(UUID.randomUUID(), commandConverter.convertToCommandList(robotCommands)));
		return ResponseEntity.ok(response);
	}

}
