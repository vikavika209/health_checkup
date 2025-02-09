package org.health.check.up.commands;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.Set;


@Component
@Getter
@Setter
public class CommandReader {

    private final Menu menu;
    private final Scanner scanner;

    @Autowired
    public CommandReader(Menu menu) {
        this.menu = menu;
        this.scanner = new Scanner(System.in);
    }

    public Command readCommand(){
        try {

            int commandNumber = Integer.getInteger(scanner.nextLine());
            Set<Command> commands = menu.getCommands();
            return commands.stream()
                    .filter(command -> command.getRowNumber() == commandNumber)
                    .findFirst().orElse(null);

        }catch (Exception e){
            System.out.println("Введите корректное число.");
            throw new RuntimeException("Введено некорректное число");
        }
    }
}
