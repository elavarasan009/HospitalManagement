package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.User;
import com.Repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public User registerUser(User user) {

		return repository.save(user);

	}

	public User loginUser(String fullname, String password) {
		User user = repository.findByFullname(fullname);
		if (user != null && user.getPassword().equals(password)) {

			return user;
		}
		return null;

	}

}
