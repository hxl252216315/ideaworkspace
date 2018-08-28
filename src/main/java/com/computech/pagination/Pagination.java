package com.computech.pagination;

import java.util.List;

public class Pagination<T>{
	
	private int pageNumber;
	private long totalSize;
	private int pageSize;
	private long total;
	private List<T> result;
	public int getPageNumber() {
		return pageNumber;
	}
	public Pagination<T> setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}
	public int getPageSize() {
		return pageSize;
	}
	public Pagination<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	public long getTotal() {
		return total;
	}
	public Pagination<T> setTotal(long total) {
		this.total = total;
		return this;
	}
	public List<T> getResult() {
		return result;
	}
	public Pagination<T> setResult(List<T> result) {
		this.result = result;
		return this;
	}
	public long getTotalSize() {
		return totalSize;
	}
	public Pagination<T> setTotalSize(long totalSize) {
		this.totalSize = totalSize;
		return this;
	}

}
