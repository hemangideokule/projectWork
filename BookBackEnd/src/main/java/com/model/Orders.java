package com.model;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Orders implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue 
	private int orderId;
	@ManyToOne
	@JoinColumn
	private User user;
	private String payment;
	private Double total;
	

	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
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
