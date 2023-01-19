package com.developerscorner.client.model;


import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "username is required field")
	private String username;

	@NotNull(message = "Tags is required field")
	private String tags;

	@NotNull(message = "Question is required field")
	private String question;

	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDate createdAt;

	@ManyToOne
	@JoinColumn(name = "userId")
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
