package com.suyang.controller;

import com.suyang.domain.Spider;
import com.suyang.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/spider")
@RestController
public class SpiderController {

    @Autowired
    private SpiderService spiderService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Spider findOne(@PathVariable("id") String id) {
        return spiderService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Spider> findAll(@RequestParam(name = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return spiderService.findAll(pageIndex, pageSize, Sort.Direction.DESC, "createTime");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Spider create(@RequestBody Spider spider) {
        return spiderService.save(spider);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        spiderService.delete(id);
    }
}
