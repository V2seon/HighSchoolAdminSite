package com.example.HighSchoolAdminSite.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionCheck {
    public boolean loginSessionCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user_signature") == null) {
            return false;
        } else {
            return true;
        }
    }
}