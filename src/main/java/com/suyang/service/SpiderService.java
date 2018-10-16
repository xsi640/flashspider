package com.suyang.service;

import com.suyang.domain.Spider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface SpiderService {
    Spider get(String spiderId);

    Page<Spider> findAll(int pageIndex, int pageSize, Sort.Direction direction, String... sort);

    Spider save(Spider spider);

    void delete(String spiderId);
}
