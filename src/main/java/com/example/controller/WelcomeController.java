package com.example.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	public String welcome() {
		return "welcome";
	}

	@SneakyThrows
	@PostMapping
	public void setUserName(HttpServletRequest req, HttpServletResponse response) {
		String userName = req.getParameter("user_name");
		if (userName.isEmpty()){
			response.sendRedirect("welcome");
			return;
		}
		String user_name = userName.replaceAll(" ", "+");
		Cookie cookie = new Cookie("user_name", user_name);
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		response.sendRedirect("index");
	}

}