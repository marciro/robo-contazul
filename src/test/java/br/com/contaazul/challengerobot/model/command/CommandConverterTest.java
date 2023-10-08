package br.com.contaazul.challengerobot.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommandConverterTest {

    private CommandConverter commandConverter;

    @BeforeEach
    public void setUp() {
        commandConverter = new CommandConverter();
    }

    @Test
    void testConvertToCommandList() {
        String rawCommandList = "MMLR";
        List<RobotCommand> result = commandConverter.convertToCommandList(rawCommandList);

        assertEquals(4, result.size());
        assertTrue(result.get(0) instanceof MoveForwardCommand);
        assertTrue(result.get(1) instanceof MoveForwardCommand);
        assertTrue(result.get(2) instanceof TurnLeftRobotCommand);
        assertTrue(result.get(3) instanceof TurnRightRobotCommand);
    }

    @Test
    void testConvertToCommandListWithInvalidCommand() {
        String rawCommandList = "XYZ";
        assertThrows(IllegalArgumentException.class, () -> {
            commandConverter.convertToCommandList(rawCommandList);
        });
    }
}
