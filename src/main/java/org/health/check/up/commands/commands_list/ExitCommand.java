package org.health.check.up.commands.commands_list;

import org.health.check.up.commands.Command;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends Command {

    public ExitCommand() {
        super("Выход");
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
