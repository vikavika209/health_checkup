package org.health.check.up.commands;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Component
public class Menu {

    private Set<Command> commands = new HashSet<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void display() {
        System.out.println("Меню");
        for (Command command : commands) {
            System.out.println(command.getRowNumber() + ". " + command.getName());
        }
        System.out.println("Введите порядковый номер команды");
    }
}
