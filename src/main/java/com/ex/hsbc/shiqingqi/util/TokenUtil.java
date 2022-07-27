package com.ex.hsbc.shiqingqi.util;

import com.ex.hsbc.shiqingqi.entity.Token;
import com.ex.hsbc.shiqingqi.entity.User;

import javax.servlet.ServletContext;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Cliff
 */
public class TokenUtil {
    public static Token create(ServletContext servletContext, User user) {
        Token token = new Token();
        LocalDateTime tokenTime = LocalDateTime.now();
        token.setTokenTime(tokenTime).setValue(user.getUserName());

        servletContext.setAttribute(user.getUserName() + "_token", token);

        return token;
    }

    public static boolean verifyToken(Token token) {
        Duration between = Duration.between(token.getTokenTime(), LocalDateTime.now());
        return between.toHours() < 2;
    }
}
