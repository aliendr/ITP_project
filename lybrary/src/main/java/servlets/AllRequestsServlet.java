package servlets;

import freemarker.template.TemplateException;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllRequestsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = createPageVariablesMap(request);
        pageVariables.put("email", "Hello Kitty!");
        pageVariables.put("password", "Hello Kitty!");
        pageVariables.put("surname", "Hello Kitty!");
        pageVariables.put("name", "Hello Kitty!");

        try {//new Try/Catch ....
            response.getWriter().println(PageGenerator.instance().getPage("/site/index.html", pageVariables));
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(request);

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        response.setContentType("text/html;charset=utf-8");

//        if (message == null || message.isEmpty()) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        } else {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
        pageVariables.put("name", name == null ? "" : name);
        pageVariables.put("surname", surname == null ? "" : surname);
        pageVariables.put("password", surname == null ? "" : password);
        pageVariables.put("email", surname == null ? "" : email);

//        try {//New Try/Catch ....
//            response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }

        response.getWriter().println("Строка ответа");
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        pageVariables.put("pathInfo", request.getPathInfo());
        pageVariables.put("sessionId", request.getSession().getId());
        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }
}
