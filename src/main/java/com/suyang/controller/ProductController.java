package com.suyang.controller;

import com.suyang.domain.Product;
import com.suyang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Product findOne(@PathVariable("id") String id) {
        return productService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> findAll(@RequestParam(name = "spiderId") String spiderId,
                                 @RequestParam(name = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return productService.findBySpiderId(spiderId, pageIndex, pageSize, Sort.Direction.DESC, "createTime");
    }
}
