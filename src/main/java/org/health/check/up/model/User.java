package org.health.check.up.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Email(message = "Неверный формат email")
    private String email;

    @Column(nullable = false)
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
    private String password;

    @OneToMany (mappedBy = "user")
    List<Entry> entries;



}
