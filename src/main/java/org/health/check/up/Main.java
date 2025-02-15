package org.health.check.up;

import org.health.check.up.commands.CommandExecute;
import org.health.check.up.commands.CommandReader;
import org.health.check.up.commands.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);

        CommandExecute commandExecute = context.getBean(CommandExecute.class);

        commandExecute.start();
    }
}
