package me.belk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("HelloServlet.init");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws HttpServlet {
        System.out.println("HelloServlet.doGet");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Hello Servlet</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("</html>");

    }

    @Override
    public void destroy(){
        System.out.println("HelloServlet.destroy");
    }
}

