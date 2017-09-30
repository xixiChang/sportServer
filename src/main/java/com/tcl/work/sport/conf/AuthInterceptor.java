package com.tcl.work.sport.conf;

import com.tcl.work.sport.ApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sID = request.getHeader("user_id");

        if (sID == null){
            PrintWriter printWriter = response.getWriter();
            printWriter.append("no user id");
            printWriter.flush();
            printWriter.close();
            return false;
        }
        int user_id = Integer.parseInt(sID);
        String session = request.getHeader("session");
        if (session != null){
            if (ApplicationContext.UserSessions.get(user_id).equals(session))

                return true;
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.append("illegal user!");
        printWriter.flush();
        printWriter.close();
        return false;
    }
}
