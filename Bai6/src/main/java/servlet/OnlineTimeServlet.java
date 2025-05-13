package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OnlineTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long startTime = (Long) session.getAttribute("startTime");

        if (startTime == null) {
            startTime = System.currentTimeMillis();
            session.setAttribute("startTime", startTime);
        }

        long currentTime = System.currentTimeMillis();
        int onlineTime = (int) ((currentTime - startTime) / 1000); // tính bằng giây
        session.setAttribute("onlineTime", onlineTime);

        request.getRequestDispatcher("/online.jsp").forward(request, response);
    }
}
