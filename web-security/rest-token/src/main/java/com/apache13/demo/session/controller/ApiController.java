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

	public static final String WMSL_VISITED = "WMSL_VISITED";

	private SessionDto counter(HttpSession session) {
		if (session.getAttribute(WMSL_VISITED) == null) {
			session.setAttribute(WMSL_VISITED, 1);
		} else {
			int count = Integer.parseInt(session.getAttribute(WMSL_VISITED).toString()) + 1;
			session.setAttribute(WMSL_VISITED, count);

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
