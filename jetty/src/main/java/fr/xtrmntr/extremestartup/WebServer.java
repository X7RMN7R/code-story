package fr.xtrmntr.extremestartup;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WebServer extends AbstractHandler {

    public static final String QUERY_PARAMETER = "q";

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
            throws IOException, ServletException {
        String question = request.getParameter(QUERY_PARAMETER);
        System.out.println(question);

		String answer = "Could you repeat the question ?";
		if ("Quelle est ton adresse email".equals(question)) {
            answer = "uv0.xtr@gmail.com";
        }
        response.setContentType("text/plain;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        writer.println(answer);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new WebServer());
        server.start();
        server.join();
    }

}