package org.health.check.up.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Command {

    private static int counter = 0;

    private int rowNumber;

    @Setter
    private String name;

    public Command() {
    }

    public Command(String name) {
        this.rowNumber = ++counter;
        this.name = name;
    }

    public abstract void execute();

}
