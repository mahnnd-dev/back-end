package dev.m.backend.controller;

import dev.m.backend.obj.ResponseApi;
import dev.m.backend.obj.entity.Expend;
import dev.m.backend.service.impl.ExpendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/api/expend")
public class ExpendController {
    private final ExpendService service;

    @Autowired
    public ExpendController(ExpendService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/add")
    public ResponseApi add(@RequestBody Expend request) {
        return service.add(request);
    }

    @ResponseBody
    @PostMapping("/update")
    public ResponseApi update(@RequestBody Expend request) {
        return service.update(request);
    }

    @ResponseBody
    @PostMapping("/del")
    public ResponseApi del(@RequestBody Expend request) {
        return service.del(request);
    }
}