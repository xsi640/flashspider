package com.suyang.service;

import com.suyang.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {
    Product get(String productId);

    Page<Product> findBySpiderId(String spiderId, int pageIndex, int pageSize, Sort.Direction direction, String... sort);

    Product save(Product product);

    List<Product> saveAll(List<Product> productList);

    void delete(String productId);
}
