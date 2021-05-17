package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the REGISTRATION_TABLE database table.
 * 
 */
@Entity
@Table(name="REGISTRATION_TABLE")
@NamedQuery(name="RegistrationTable.findAll", query="SELECT r FROM RegistrationTable r")
public class RegistrationTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADHAR_CARD")
	private long adharCard;

	private String address;

	@Column(name="CARD_TYPE")
	private String cardType;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="EMAIL_ID")
	private String emailId;

	private String name;

	private String password;

	@Column(name="PHONE_NO")
	private Long phoneNo;

	@Temporal(TemporalType.DATE)
	@Column(name="REGISTRATION_DATE")
	private Date registrationDate;

	private String username;

	//bi-directional many-to-one association to BankTable
	@OneToMany(mappedBy="registrationTable1", fetch=FetchType.EAGER)
	private Set<BankTable> bankTables;

	//bi-directional one-to-one association to BankTable
	@OneToOne
	@JoinColumn(name="ADHAR_CARD", referencedColumnName="ADHAR_CARD")
	private BankTable bankTable;

	public RegistrationTable() {
	}

	public long getAdharCard() {
		return this.adharCard;
	}

	public void setAdharCard(long adharCard) {
		this.adharCard = adharCard;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<BankTable> getBankTables() {
		return this.bankTables;
	}

	public void setBankTables(Set<BankTable> bankTables) {
		this.bankTables = bankTables;
	}

	public BankTable addBankTable(BankTable bankTable) {
		getBankTables().add(bankTable);
		bankTable.setRegistrationTable1(this);

		return bankTable;
	}

	public BankTable removeBankTable(BankTable bankTable) {
		getBankTables().remove(bankTable);
		bankTable.setRegistrationTable1(null);

		return bankTable;
	}

	public BankTable getBankTable() {
		return this.bankTable;
	}

	public void setBankTable(BankTable bankTable) {
		this.bankTable = bankTable;
	}

}