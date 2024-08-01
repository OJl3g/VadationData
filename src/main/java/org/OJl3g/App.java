package org.OJl3g;

import org.OJl3g.entity.User;
import org.OJl3g.userDAO.UserDAO;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        User user = new User("B2", 133,
                LocalDate.of(2024,12,01));

        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
    }
}
