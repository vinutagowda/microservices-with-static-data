package com.w.training.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.w.training.beans.BookCatalogItem;

@Service
public class BookService {
	
	
	public BookCatalogItem getBook() {
		return new BookCatalogItem("Alchemist", "A Book about life", 4);
	}

	public List<Object> getAllBooks() {
//		The URL to hit for the second micro-service
		String urlToHit = "http://localhost:8081/info/all";
		
//		Call the other micro service to fetch data of all books
		return  Arrays.asList(new RestTemplate().getForObject(urlToHit, Object[].class));
	}
}
