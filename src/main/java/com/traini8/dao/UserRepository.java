package com.traini8.dao;


import org.springframework.data.repository.CrudRepository;

import com.traini8.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>
{
	
}
