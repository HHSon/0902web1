package helloworld.net;

import helloworld.common.config.Configuration;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import org.json.JSONObject;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DiagnosticServlet extends HttpServlet {
	
	public static final String HEALTH_PATH = "/health";
	
	private Logger logger = LogManager.getLogger(DiagnosticServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		directRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		directRequest(req, resp);
	}
	
	protected void directRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if (pathInfo == null) {
			pathInfo = "";
		}
		
		switch (pathInfo) {
		case HEALTH_PATH:
				getSystemHealth(req, resp);
			break;
			
		default:
			logger.error("Unknow request path: " + pathInfo);
			resp.getWriter().println("Error: Unknown request path" + pathInfo);
		}
	}
	
	protected void getSystemHealth(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", Configuration.getProjectName());
		jsonObj.put("version", Configuration.getProjectVersion());
		jsonObj.put("javaVersion", Configuration.getJavaVersion());
		jsonObj.put("logStoredDuration", Configuration.getLogStoredDuration());
		
		resp.getWriter().println(jsonObj.toString());
	}
}
