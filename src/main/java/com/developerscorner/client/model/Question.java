package com.developerscorner.client.model;


import java.time.LocalDate;
import java.util.Objects;

public class Question {

	private Long id;
	private String username;
	private String tags;
	private String question;
	private LocalDate createdAt;
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, id, question, tags, user, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(id, other.id)
				&& Objects.equals(question, other.question) && Objects.equals(tags, other.tags)
				&& Objects.equals(user, other.user) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", username=" + username + ", tags=" + tags + ", question=" + question
				+ ", createdAt=" + createdAt + ", user=" + user + "]";
	}
	
	
}
