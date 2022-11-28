package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Post, Long> {

    Object findAllById(int i);
}
