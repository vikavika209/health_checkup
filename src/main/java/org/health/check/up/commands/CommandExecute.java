package org.health.check.up.commands;

import org.health.check.up.commands.commands_list.ExitCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandExecute {
    private CommandReader commandReader;
    private Menu menu;

    @Autowired
    public CommandExecute (CommandReader commandReader, Menu menu) {
        this.commandReader = commandReader;
        this.menu = menu;
    }

    public void start() {

        while (true) {

            try {

                menu.display();

                Command command = commandReader.readCommand();

                if (command == null) {
                    continue;

                }
                command.execute();
            } catch (IllegalArgumentException e){
                System.out.println("Неверный формат логина или пароля");
                continue;
            }
        }
    }
}
