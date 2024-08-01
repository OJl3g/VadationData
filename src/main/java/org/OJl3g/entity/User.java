package org.OJl3g.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "users")
//@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 16) //минимальная длина логина, которую можно добавлять
    @Column(unique = true, nullable = false)
    @NotBlank //при вводе пустоты не будет работать
    private String login;

    @Column(nullable = false)
//    @NotBlank
    private int password;

    @Past //означает, что дата находится в прошлом
    private LocalDate birthDate;

    @Future //означает, что дата находится в будущем
    private LocalDate futureDateSubscription;

    @Email //проверяет, что в данном поле именно email
    private String email;

    @Digits(integer = 6, fraction = 2) //проверка, что числовое значение имеет определенное кол-во цифр
    private double balance;

    @Pattern(regexp = "[а-яА-Я] +") //проверка, что строка соответствует данному регулярному выражению
    private String theKeyWord;

    public User(String login, int password, LocalDate birthDate) {
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }
}
