package com.global.book.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.global.book.entity.Author;
import com.global.book.repo.AuthorRepo;
import com.global.book.service.AuthorService;

public class StartUpApp implements CommandLineRunner {

	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private AuthorService authorService ;
	@Override
	public void run(String... args) throws Exception {

		if (authorRepo.findAll().isEmpty()) {
			Author auther1 = new Author();
			auther1.setName("mostafa salah");
			auther1.setEmail("memosalah553@gmail.com");
			auther1.setPhone("01118914120");

			Author auther2 = new Author();
			auther2.setName("salah");
			auther2.setEmail("mohamedavatar80@gmail.com");
			auther2.setPhone("01002934520");

			Author auther3 = new Author();
			auther3.setName("Medo");
			auther3.setEmail("Kemomemo138@gmail.com");
			auther3.setPhone("01149260391");

			authorService.insertAll(Arrays.asList(auther1 , auther2 ,auther3));
		}
	}

}
