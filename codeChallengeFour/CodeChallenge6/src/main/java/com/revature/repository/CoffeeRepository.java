package com.revature.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.bean.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

	//public Coffee getCoffeeById(int coffeeId);
}
