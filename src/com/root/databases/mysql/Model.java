package com.root.databases.mysql;

public class Model {

	private String name;
	private int id;

	public Model(String name) {
		this.name = name;
	}

	public Model() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Id: " + id + " & Name: " + name;
	}
}
