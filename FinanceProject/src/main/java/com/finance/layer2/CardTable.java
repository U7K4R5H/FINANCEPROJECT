package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the CARD_TABLE database table.
 * 
 */
@Entity
@Table(name="CARD_TABLE")
@NamedQuery(name="CardTable.findAll", query="SELECT c FROM CardTable c")
public class CardTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CARD_NO")
	private long cardNo;

	@Column(name="CARD_LIMIT")
	private Double cardLimit;

	@Column(name="CUST_NAME")
	private String custName;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	//bi-directional many-to-one association to ApprovalTable
	@ManyToOne
	@JoinColumn(name="APPROVAL_NO")
	private ApprovalTable approvalTable1;

	//bi-directional many-to-one association to OrderTable
	@OneToMany(mappedBy="cardTable", fetch=FetchType.EAGER)
	private Set<OrderTable> orderTables;

	//bi-directional one-to-one association to ApprovalTable
	@OneToOne(mappedBy="cardTable")
	private ApprovalTable approvalTable2;

	public CardTable() {
	}

	public long getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public Double getCardLimit() {
		return this.cardLimit;
	}

	public void setCardLimit(Double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ApprovalTable getApprovalTable1() {
		return this.approvalTable1;
	}

	public void setApprovalTable1(ApprovalTable approvalTable1) {
		this.approvalTable1 = approvalTable1;
	}

	public Set<OrderTable> getOrderTables() {
		return this.orderTables;
	}

	public void setOrderTables(Set<OrderTable> orderTables) {
		this.orderTables = orderTables;
	}

	public OrderTable addOrderTable(OrderTable orderTable) {
		getOrderTables().add(orderTable);
		orderTable.setCardTable(this);

		return orderTable;
	}

	public OrderTable removeOrderTable(OrderTable orderTable) {
		getOrderTables().remove(orderTable);
		orderTable.setCardTable(null);

		return orderTable;
	}

	public ApprovalTable getApprovalTable2() {
		return this.approvalTable2;
	}

	public void setApprovalTable2(ApprovalTable approvalTable2) {
		this.approvalTable2 = approvalTable2;
	}

}