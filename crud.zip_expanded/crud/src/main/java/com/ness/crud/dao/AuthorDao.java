package com.ness.crud.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ness.crud.model.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
	public Author findByAuthorName(String AuthorName);
	
	
	//select * from author where authorName = ? or bookTitle =? 
	public List<Author> findByAuthorNameOrBookTitle(String authorName, String bookTitle);
	

	
		
	

}
