package org.health.check.up.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandExecute {
    CommandReader commandReader;

    @Autowired
    public CommandReader getCommandReader() {
        return commandReader;
    }

    public void executeCommand(){
        Command command = commandReader.readCommand();
        command.execute();
    }
}
