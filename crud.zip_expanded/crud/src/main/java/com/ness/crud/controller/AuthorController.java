package com.ness.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ness.crud.model.Author;
import com.ness.crud.service.AuthorService;

@RequestMapping("author")
@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	//AuthorService authorService=new AuthorServiceImpl();
	
	
	@PostMapping
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author)
	{
		Author savedAuthor=authorService.saveAuthor(author);
		return new ResponseEntity<Author>(savedAuthor,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Author>> getAuthors()
	{
		List<Author> authors=authorService.getAllAuthors();
		return new ResponseEntity<List<Author>>(authors,HttpStatus.FOUND);
	}
	
	
	
	@GetMapping("{authorName}")
	public ResponseEntity<Author> getAuthor(@PathVariable String authorName)
	{
		Author author=authorService.getAuthorByName(authorName);
		return new ResponseEntity<Author>(author,HttpStatus.FOUND);
	}

	
	@GetMapping("{authorName}/{bookTitle}")
	public ResponseEntity<List<Author>> getAuthorsBynameOrTitle(@PathVariable String authorName,@PathVariable String bookTitle)
	{
		List<Author> authors=authorService.findByAuthorNameOrBookTitle(authorName, bookTitle);
		return new ResponseEntity<List<Author>>(authors,HttpStatus.FOUND);
	}

	@PutMapping("{authorId}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author,@PathVariable int authorId)
	{
		Author savedAuthor = authorService.updateAuthor(author, authorId);
		return new ResponseEntity<Author>(savedAuthor,HttpStatus.CREATED);
		
		
	}

	@DeleteMapping("{authorId}")
	public ResponseEntity<String> Alreadydelete(@PathVariable int authorId)
	{
		String status=authorService.Alreadydelete(authorId);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}

	
	
}




