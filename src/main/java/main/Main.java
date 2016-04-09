package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.MirrorServlet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
       // AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        MirrorServlet mirrorServlet = new MirrorServlet();
        //ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ServletContextHandler context1 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.addServlet(new ServletHolder(allRequestsServlet), "/*");
        context1.addServlet(new ServletHolder(mirrorServlet), "/mirror");
        Server server = new Server(8080);
        server.setHandler(context1);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
        //java.util.logging.Logger.getGlobal().info("Server started");
        //хуйухйухйху

    }
}