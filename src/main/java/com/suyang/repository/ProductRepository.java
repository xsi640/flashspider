package com.suyang.repository;

import com.suyang.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findBySpiderId(String spiderId, PageRequest pageRequest);
}
