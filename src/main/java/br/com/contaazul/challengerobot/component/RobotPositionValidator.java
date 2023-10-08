package br.com.contaazul.challengerobot.component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import br.com.contaazul.challengerobot.common.ChallengeRobotConstants;
import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * Classe responsável por executar as validações referentes aos comandos e posição do robô
 */
@Component
public class RobotPositionValidator {
	
	public String validate(RobotPosition position) {
		ValidatorFactory factory =  Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RobotPosition>> validate = validator.validate(position);
		List<String> collect = validate.stream().map(ConstraintViolation::getMessage).toList();
		return StringUtils.join(collect, ChallengeRobotConstants.NEW_LINE);
	}  
}
