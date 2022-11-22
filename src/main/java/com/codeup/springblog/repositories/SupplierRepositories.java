package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepositories extends JpaRepository<Supplier, Long> {
}
