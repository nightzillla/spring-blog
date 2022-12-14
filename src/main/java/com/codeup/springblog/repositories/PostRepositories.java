package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositories extends JpaRepository<Post, Long> {
    Post findById(long id);

}
