package org.example.app.service;

import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class);

    public boolean authenticate(LoginForm loginForm) {
        logger.info("Trying authorization with user-form: " + loginForm);
        return loginForm.getUsername().equals("root") && loginForm.getPassword().equals("123");
    }
}
