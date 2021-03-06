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
    	System.out.println(request);
    	if ("GET".equals(request.getMethod())) {
	    	String question = request.getParameter(QUERY_PARAMETER);
	        String answer = "Could you repeat the question ?";
			
			QuestionsEnum questionEnum = QuestionsEnum.fromQuestion(question);
			if (questionEnum != null) {
				System.out.println(question);
				answer = questionEnum.getAnswer();
			}
			
	        response.setContentType("text/plain;charset=utf-8");
	        response.setStatus(HttpServletResponse.SC_OK);
	        PrintWriter writer = response.getWriter();
	        writer.println(answer);
	        writer.close();
    	}
    	if ("POST".equals(request.getMethod())) {
    		// POST request - return 201
    		response.setStatus(HttpServletResponse.SC_CREATED);
    	}
    }

    public static void main(String[] args) throws Exception {
		int port = Integer.parseInt(System.getenv("PORT"));
        Server server = new Server(port);
        server.setHandler(new WebServer());
        server.start();
        server.join();
    }

}