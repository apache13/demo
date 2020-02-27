package com.apache13.demo.session.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apache13.demo.session.dto.SessionDto;

@RestController
@RequestMapping("/api")
public class ApiController {

	public static final String VISITED = "VISITED";

	private SessionDto counter(HttpSession session) {
		if (session.getAttribute(VISITED) == null) {
			session.setAttribute(VISITED, 1);
		} else {
			int count = Integer.parseInt(session.getAttribute(VISITED).toString()) + 1;
			session.setAttribute(VISITED, count);

		}
		return new SessionDto(session);
	}

	@GetMapping(value = "/anonymous")
	public SessionDto anonymous(HttpSession session, Model model) {
		return counter(session);
	}

	@GetMapping(value = "/admin")
	public SessionDto admin(HttpSession session, Model model) {
		return counter(session);
	}

}
