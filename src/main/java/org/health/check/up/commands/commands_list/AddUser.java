package org.health.check.up.commands.commands_list;

import org.health.check.up.commands.Command;
import org.health.check.up.model.User;
import org.health.check.up.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddUser extends Command {

    UserService userService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public UserService getUserService() {
        return userService;
    }

    @Override
    public void setName(String name) {
        super.setName("Новый пользователь");
    }

    @Override
    public void execute() {
        System.out.println("Введите email");
        String email = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = userService.createUser(email, password);

        System.out.println("Пользователь с email: " + user.getEmail() + " успешно создан");
    }
}
