package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Puppy on 09.04.2016.
 */

public class MirrorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println(ваше значение);
        //и еще не забываем писать в конце
        //response.setContentType("text/html;charset=utf-8");
        //response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> pageVariables = createPageVariablesMap(request);
        //pageVariables.put("message", "");
        response.getWriter().println(PageGenerator.instance().getPage("page_mirror.html", pageVariables));
        //response.getWriter().println(request.getParameter(pageVariables).toString());
        //String result= request.getQueryString().toString();
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("parameters", request.getQueryString().toString()); //
        return pageVariables;

    }
   /** public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    } **/
}
