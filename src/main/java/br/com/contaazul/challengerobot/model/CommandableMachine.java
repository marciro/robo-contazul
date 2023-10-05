package br.com.contaazul.challengerobot.model;

import java.util.List;

public interface CommandableMachine<C,R> {
	
	R executeCommand(List<C> commands);

}
