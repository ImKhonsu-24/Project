package listener;

import javax.servlet.http.*;
import javax.servlet.*;

public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("sessionCount");
        if (count == null) count = 0;
        context.setAttribute("sessionCount", ++count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("sessionCount");
        if (count != null && count > 0) {
            context.setAttribute("sessionCount", --count);
        }
    }
}
