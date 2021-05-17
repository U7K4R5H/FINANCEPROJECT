package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the BANK_TABLE database table.
 * 
 */
@Entity
@Table(name="BANK_TABLE")
@NamedQuery(name="BankTable.findAll", query="SELECT b FROM BankTable b")
public class BankTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNT_NO")
	private long accountNo;

	@Column(name="BANK_TYPE")
	private String bankType;

	@Column(name="IFSC_CODE")
	private String ifscCode;

	//bi-directional many-to-one association to ApprovalTable
	@OneToMany(mappedBy="bankTable1", fetch=FetchType.EAGER)
	private Set<ApprovalTable> approvalTables;

	//bi-directional many-to-one association to RegistrationTable
	@ManyToOne
	@JoinColumn(name="ADHAR_CARD")
	private RegistrationTable registrationTable1;

	//bi-directional one-to-one association to RegistrationTable
	@OneToOne(mappedBy="bankTable")
	private RegistrationTable registrationTable2;

	//bi-directional one-to-one association to ApprovalTable
	@OneToOne
	@JoinColumn(name="ACCOUNT_NO", referencedColumnName="ACCOUNT_NO")
	private ApprovalTable approvalTable;

	public BankTable() {
	}

	public long getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankType() {
		return this.bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Set<ApprovalTable> getApprovalTables() {
		return this.approvalTables;
	}

	public void setApprovalTables(Set<ApprovalTable> approvalTables) {
		this.approvalTables = approvalTables;
	}

	public ApprovalTable addApprovalTable(ApprovalTable approvalTable) {
		getApprovalTables().add(approvalTable);
		approvalTable.setBankTable1(this);

		return approvalTable;
	}

	public ApprovalTable removeApprovalTable(ApprovalTable approvalTable) {
		getApprovalTables().remove(approvalTable);
		approvalTable.setBankTable1(null);

		return approvalTable;
	}

	public RegistrationTable getRegistrationTable1() {
		return this.registrationTable1;
	}

	public void setRegistrationTable1(RegistrationTable registrationTable1) {
		this.registrationTable1 = registrationTable1;
	}

	public RegistrationTable getRegistrationTable2() {
		return this.registrationTable2;
	}

	public void setRegistrationTable2(RegistrationTable registrationTable2) {
		this.registrationTable2 = registrationTable2;
	}

	public ApprovalTable getApprovalTable() {
		return this.approvalTable;
	}

	public void setApprovalTable(ApprovalTable approvalTable) {
		this.approvalTable = approvalTable;
	}

}