package net.bp.onlineshoppingBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class Payment implements Serializable 
{
	private static final long serialVersionUID = 6467634240249641816L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@Email
	private String email;
	@NotEmpty(message="user mobile number should be between 1 to 13 characters long")
	private String phone;
	@Digits(fraction=0,integer=6,message="user card number should be 16 characters long")
//	@CreditCardNumber
	private String cardNo;
	@Digits(fraction=0,integer=6,message="user cvv should be 3 characters long")
	private String cvv;
	@NotEmpty(message="user name should be between 1 to 20 characters long")
	private String cardName;
	private int totalPayment=0;
	public int getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private int mm;
	private int yy;

	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getYy() {
		return yy;
	}
	public void setYy(int yy) {
		this.yy = yy;
	}
	public Payment(int paymentId, String email, String phone, String cardNo, String cvv, String cardName, int mm,
			int yy) {
		super();
		this.paymentId = paymentId;
		this.email = email;
		this.phone = phone;
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.cardName = cardName;
		this.mm = mm;
		this.yy = yy;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
