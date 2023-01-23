package com.developerscorner.client.model;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "User ID is required field")
	private Long sender;
	
	@NotNull(message = "Reciever is required field")
	private Long reciever;
	
	@NotBlank(message = "Message is required field")
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSender() {
		return sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	public Long getReciever() {
		return reciever;
	}

	public void setReciever(Long reciever) {
		this.reciever = reciever;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message, reciever, sender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(id, other.id) && Objects.equals(message, other.message)
				&& Objects.equals(reciever, other.reciever) && Objects.equals(sender, other.sender);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", reciever=" + reciever + ", message=" + message + "]";
	}
	
}
