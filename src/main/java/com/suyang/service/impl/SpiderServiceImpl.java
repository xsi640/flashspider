package com.suyang.service.impl;

import com.suyang.domain.Spider;
import com.suyang.repository.SpiderRepository;
import com.suyang.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpiderServiceImpl implements SpiderService {

    @Autowired
    private SpiderRepository spiderRepository;

    @Override
    public Spider get(String spiderId) {
        return spiderRepository.getOne(spiderId);
    }

    @Override
    public Page<Spider> findAll(int pageIndex, int pageSize, Sort.Direction direction, String... sort) {
        return spiderRepository.findAll(PageRequest.of(pageIndex - 1, pageSize, direction, sort));
    }

    @Override
    public Spider save(Spider spider) {
        return spiderRepository.save(spider);
    }

    @Override
    public void delete(String spiderId) {
        spiderRepository.deleteById(spiderId);
    }
}
