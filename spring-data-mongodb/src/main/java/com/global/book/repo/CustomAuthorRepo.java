package com.global.book.repo;

public interface CustomAuthorRepo {

	void updateEmail(String email, String name , String phone);
	void updateId(String id , String email, String name , String phone);

}
