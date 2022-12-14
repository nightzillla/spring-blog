package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepositories extends JpaRepository<Coffee, Long> {
    
    Coffee findById(long id);

}
