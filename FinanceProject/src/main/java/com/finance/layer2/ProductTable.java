package com.finance.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the PRODUCT_TABLE database table.
 * 
 */
@Entity
@Table(name="PRODUCT_TABLE")
@NamedQuery(name="ProductTable.findAll", query="SELECT p FROM ProductTable p")
public class ProductTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRODUCT_ID")
	private long productId;

	@Column(name="PRODUCT_NAME")
	private String productName;

	//bi-directional many-to-one association to OrderTable
	@OneToMany(mappedBy="productTable", fetch=FetchType.EAGER)
	private Set<OrderTable> orderTables;

	public ProductTable() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Set<OrderTable> getOrderTables() {
		return this.orderTables;
	}

	public void setOrderTables(Set<OrderTable> orderTables) {
		this.orderTables = orderTables;
	}

	public OrderTable addOrderTable(OrderTable orderTable) {
		getOrderTables().add(orderTable);
		orderTable.setProductTable(this);

		return orderTable;
	}

	public OrderTable removeOrderTable(OrderTable orderTable) {
		getOrderTables().remove(orderTable);
		orderTable.setProductTable(null);

		return orderTable;
	}

}