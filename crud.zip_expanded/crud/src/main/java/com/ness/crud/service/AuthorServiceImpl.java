package com.ness.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.crud.dao.AuthorDao;
import com.ness.crud.exception.AuthorAlreadyDeleted;
import com.ness.crud.exception.AuthorAlreadyExists;
import com.ness.crud.model.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorDao authorDao;


	@Override	
	public Author saveAuthor(Author author)
	{
		
			Author found=getAuthorById(author.getAuthorId());
		
			if(found!=null)
			throw new AuthorAlreadyExists("author already exists");
		
				
				return authorDao.save(author);


			}
	
	public String Alreadydelete(int authorId) {
		Author found=getAuthorById(authorId);
		if(found==null) {
			throw new AuthorAlreadyDeleted("Author doesn't exist");
		}
		
		else {
			authorDao.delete(found);
			return "author deleted";
		}	
	}
	
	public Author getAuthorById(int authorId)
	{
		
		Optional<Author> optAuhtor= authorDao.findById(authorId);
		 if(optAuhtor.isPresent())
		 {
				return optAuhtor.get();		 
		 }
	
		 return null;
	}


	public List<Author> getAllAuthors()
	{
		return  (List<Author>)authorDao.findAll();
	}

	public Author getAuthorByName(String authorName)
	{
		
		return  authorDao.findByAuthorName(authorName);
	}

	@Override
	public List<Author> findByAuthorNameOrBookTitle(String authorName, String bookTitle) {
		// TODO Auto-generated method stub
		return authorDao.findByAuthorNameOrBookTitle(authorName, bookTitle);
	}


	public Author updateAuthor(Author author, int authorId)
	{
		return authorDao.save(author);
	}




	public String deleteAuthor(int authorId) {
		
		authorDao.deleteById(authorId);
		return "Author Deleted";
	}


	}


