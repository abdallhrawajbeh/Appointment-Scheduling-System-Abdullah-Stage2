package com.appointment.service;

import com.appointment.domain.Administrator;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Objects;

public class AuthService {

    private Administrator loggedInAdmin;

    private final Dotenv dotenv = Dotenv.configure()
            .directory("./")
            .filename(".env")
            .ignoreIfMissing()
            .load();

    private final String adminUsername = dotenv.get("ADMIN_USERNAME");
    private final String adminPassword = dotenv.get("ADMIN_PASSWORD");

    public boolean login(String username, String password) {
        if (Objects.equals(username, adminUsername) && Objects.equals(password, adminPassword)) {
            loggedInAdmin = new Administrator(username, password);
            return true;
        }

        return false;
    }

    public void logout() {
        loggedInAdmin = null;
    }

    public boolean isLoggedIn() {
        return loggedInAdmin != null;
    }
}