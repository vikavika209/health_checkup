package org.health.check.up.commands;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandRegistry {
    private final Menu menu;
    private final List<Command> commands;

    @Autowired
    public CommandRegistry(Menu menu, List<Command> commands) {
        this.menu = menu;
        this.commands = commands;
    }

    @PostConstruct
    public void registerCommands() {
        for (Command command : commands) {
            menu.addCommand(command);
        }
    }

}
