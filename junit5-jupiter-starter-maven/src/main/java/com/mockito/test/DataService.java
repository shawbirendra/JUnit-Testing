package com.mockito.test;

import java.util.List;

public class DataService {

	DataSource ds = null;

	public DataService(DataSource ds) {
		this.ds = ds;
	}

	public long getTotal() {
		List<Integer> ints = ds.dbData();
		return ints.stream().mapToInt(x -> x).sum();
	}
}