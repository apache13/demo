package com.apache13.demo.session.dto;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SessionDto {
	private String id;
	private boolean isNew;
	private LocalDateTime localCreateDateTime;
	private LocalDateTime localLastAccessDateTime;
	private Duration maxInactive;
	private Duration inactive;
	private Duration age;

	private Map<String, Object> attribute = new HashMap<String, Object>();

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return super.toString();
		}
	}

	public SessionDto(HttpSession session) {
		this.id = session.getId();
		this.isNew = session.isNew();
		this.localCreateDateTime = Instant.ofEpochMilli(session.getCreationTime()).atZone(ZoneId.systemDefault())
				.toLocalDateTime();
		this.localLastAccessDateTime = Instant.ofEpochMilli(session.getLastAccessedTime())
				.atZone(ZoneId.systemDefault()).toLocalDateTime();

		age = Duration.between(this.localCreateDateTime, LocalDateTime.now());
		maxInactive = Duration.ofSeconds(session.getMaxInactiveInterval());
		inactive = Duration.between(this.localLastAccessDateTime, LocalDateTime.now());
		session.getAttributeNames().asIterator()
				.forEachRemaining(a -> attribute.put(a, session.getAttribute(a).toString()));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public Map<String, Object> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, Object> attribute) {
		this.attribute = attribute;
	}

	public LocalDateTime getLocalCreateDateTime() {
		return localCreateDateTime;
	}

	public void setLocalCreateDateTime(LocalDateTime localCreateDateTime) {
		this.localCreateDateTime = localCreateDateTime;
	}

	public LocalDateTime getLocalLastAccessDateTime() {
		return localLastAccessDateTime;
	}

	public void setLocalLastAccessDateTime(LocalDateTime localLastAccessDateTime) {
		this.localLastAccessDateTime = localLastAccessDateTime;
	}

	public Duration getAge() {
		return age;
	}

	public void setAge(Duration age) {
		this.age = age;
	}

	public Duration getMaxInactive() {
		return maxInactive;
	}

	public void setMaxInactive(Duration maxInactive) {
		this.maxInactive = maxInactive;
	}

	public Duration getInactive() {
		return inactive;
	}

	public void setInactive(Duration inactive) {
		this.inactive = inactive;
	}

}
