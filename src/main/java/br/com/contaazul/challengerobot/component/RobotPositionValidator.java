package br.com.contaazul.challengerobot.component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import br.com.contaazul.challengerobot.model.RobotPosition;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@Component
public class RobotPositionValidator {
	
	public String validate(RobotPosition position) {
		ValidatorFactory factory =  Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<RobotPosition>> validate = validator.validate(position);
		List<String> collect = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
		String join = StringUtils.join(collect, "\r\n");
		return join;
	}  
}
