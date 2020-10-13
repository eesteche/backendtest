package com.eesteche.demo.loans;

import java.util.List;

public class LoanDto {

	int total;
	Long size;
	int page;
	private List<Loan> items;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Loan> getItems() {
		return items;
	}
	public void setItems(List<Loan> items) {
		this.items = items;
	}
}
