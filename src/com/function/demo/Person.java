package com.function.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class Person {

	private Long id;

	private String name;

	private Integer sex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	static final int MAXIMUM_CAPACITY = 1 << 30;

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}
	
	public static void main(String[] args) {
		BigDecimal val = new BigDecimal("15.6");
		Map<Integer,Integer> map = new HashMap<>(1);
		map.put(1,1);
		System.out.println(val);
		System.out.println(map);
		System.out.println(1 << 30);

		System.out.println(tableSizeFor(65));
	}

}