package com.finance.layer2;



import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the APPROVAL_TABLE database table.
 * 
 */
@Entity
@Table(name="APPROVAL_TABLE")
@NamedQuery(name="ApprovalTable.findAll", query="SELECT a FROM ApprovalTable a")
public class ApprovalTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="APPROVAL_NO")
	private long approvalNo;

	@Column(name="APPROVAL_STATUS")
	private String approvalStatus;

	@Column(name="CARD_FEE")
	private Double cardFee;

	//bi-directional many-to-one association to BankTable
	@ManyToOne
	@JoinColumn(name="ACCOUNT_NO")
	private BankTable bankTable1;

	//bi-directional many-to-one association to CardTable
	@OneToMany(mappedBy="approvalTable1", fetch=FetchType.EAGER)
	private Set<CardTable> cardTables;

	//bi-directional one-to-one association to BankTable
	@OneToOne(mappedBy="approvalTable")
	private BankTable bankTable2;

	//bi-directional one-to-one association to CardTable
	@OneToOne
	@JoinColumn(name="APPROVAL_NO", referencedColumnName="APPROVAL_NO")
	private CardTable cardTable;

	public ApprovalTable() {
	}

	public long getApprovalNo() {
		return this.approvalNo;
	}

	public void setApprovalNo(long approvalNo) {
		this.approvalNo = approvalNo;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Double getCardFee() {
		return this.cardFee;
	}

	public void setCardFee(Double cardFee) {
		this.cardFee = cardFee;
	}

	public BankTable getBankTable1() {
		return this.bankTable1;
	}

	public void setBankTable1(BankTable bankTable1) {
		this.bankTable1 = bankTable1;
	}

	public Set<CardTable> getCardTables() {
		return this.cardTables;
	}

	public void setCardTables(Set<CardTable> cardTables) {
		this.cardTables = cardTables;
	}

	public CardTable addCardTable(CardTable cardTable) {
		getCardTables().add(cardTable);
		cardTable.setApprovalTable1(this);

		return cardTable;
	}

	public CardTable removeCardTable(CardTable cardTable) {
		getCardTables().remove(cardTable);
		cardTable.setApprovalTable1(null);

		return cardTable;
	}

	public BankTable getBankTable2() {
		return this.bankTable2;
	}

	public void setBankTable2(BankTable bankTable2) {
		this.bankTable2 = bankTable2;
	}

	public CardTable getCardTable() {
		return this.cardTable;
	}

	public void setCardTable(CardTable cardTable) {
		this.cardTable = cardTable;
	}

}