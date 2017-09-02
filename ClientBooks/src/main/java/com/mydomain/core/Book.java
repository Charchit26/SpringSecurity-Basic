package com.mydomain.core;

import java.util.ArrayList;
import java.util.List;

public class Book {
	String series_t;
	int pages_i;
	String author;
	float price;
	String name;
	public String getSeries_t() {
		return series_t;
	}
	public void setSeries_t(String series_t) {
		this.series_t = series_t;
	}
	public int getPages_i() {
		return pages_i;
	}
	public void setPages_i(int pages_i) {
		this.pages_i = pages_i;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Book [series_t=" + series_t + ", pages_i=" + pages_i + ", author=" + author + ", price=" + price
				+ ", name=" + name + "]";
	}
	
}
