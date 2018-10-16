package com.suyang.service.impl;

import com.suyang.domain.Product;
import com.suyang.repository.ProductRepository;
import com.suyang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product get(String productId) {
        return productRepository.getOne(productId);
    }

    @Override
    public Page<Product> findBySpiderId(String spiderId, int pageIndex, int pageSize, Sort.Direction direction, String... sort) {
        return productRepository.findBySpiderId(spiderId, PageRequest.of(pageIndex - 1, pageSize, direction, sort));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    @Override
    public void delete(String productId) {
        productRepository.deleteById(productId);
    }
}
