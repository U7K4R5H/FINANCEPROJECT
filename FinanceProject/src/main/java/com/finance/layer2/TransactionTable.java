package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TRANSACTION_TABLE database table.
 * 
 */
@Entity
@Table(name="TRANSACTION_TABLE")
@NamedQuery(name="TransactionTable.findAll", query="SELECT t FROM TransactionTable t")
public class TransactionTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRANS_ID")
	private long transId;

	@Column(name="DUE_AMT")
	private Double dueAmt;

	private Double instalment;

	@Column(name="MONTH_NO")
	private Integer monthNo;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANS_DATE")
	private Date transDate;

	//bi-directional many-to-one association to OrderTable
	@ManyToOne
	@JoinColumn(name="ORD_ID")
	private OrderTable orderTable;

	public TransactionTable() {
	}

	public long getTransId() {
		return this.transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public Double getDueAmt() {
		return this.dueAmt;
	}

	public void setDueAmt(Double dueAmt) {
		this.dueAmt = dueAmt;
	}

	public Double getInstalment() {
		return this.instalment;
	}

	public void setInstalment(Double instalment) {
		this.instalment = instalment;
	}

	public Integer getMonthNo() {
		return this.monthNo;
	}

	public void setMonthNo(Integer monthNo) {
		this.monthNo = monthNo;
	}

	public Date getTransDate() {
		return this.transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public OrderTable getOrderTable() {
		return this.orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

}