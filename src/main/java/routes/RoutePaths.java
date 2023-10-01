package routes;

import jakarta.servlet.http.HttpServletRequest;

public class RoutePaths {

	public static String getPath(String page) {
		String cp = "/studyunity";
		String route= cp;
		
		switch (page) {
		case "login":
			route += "/login";
			break;
		case "register":
			route += "/register";
			break;
		case "gs":
			route += "/group_study";
			break;
		case "sm":
			route+= "/share_material";
			break;
		case "profile":
			route+= "/profile";
			break;
		case "logout":
			route+= "/logout";
			break;

		default:
			break;
		}
		
		return route;
	}
}
