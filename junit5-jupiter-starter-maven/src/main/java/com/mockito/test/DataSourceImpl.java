package com.mockito.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataSourceImpl implements DataSource {
	final List<Integer> datas = Stream.of(2, 5, 7, 8, 9, 10).collect(Collectors.toList());

	@Override
	public List<Integer> dbData() {
		return datas;
	}

	/*
	 * @Override public long getTotal() {
	 * System.out.println("DataSourceImpl.getTotal()"); return
	 * datas.stream().mapToLong(x->x).sum(); }
	 */

}
