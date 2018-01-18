package com.model;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Orders 
{
	@Id
	@GeneratedValue 
	private int orderId;
	@ManyToOne
	@JoinColumn
	private User user;
	private String payment;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	

}
