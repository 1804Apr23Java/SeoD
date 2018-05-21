package util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class MasterRedirect {

	public static String process(HttpServletRequest request) throws IOException {
		switch (request.getParameter("destination")) {
		case "bears":
			return "bear";
		case "caves":
			return "cave";
		default:
			return "error";
		}
	}

}
