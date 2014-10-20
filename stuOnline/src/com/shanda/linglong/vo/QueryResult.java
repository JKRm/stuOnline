package com.shanda.linglong.vo;

import java.util.List;

public class QueryResult<T> {
	
	private List<T> resultlist;
	
	private long totalrecord;

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public List<T> getResultlist() {
		return resultlist;
	}

	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}

	public long getTotalrecord() {
		return totalrecord;
	}
}
	