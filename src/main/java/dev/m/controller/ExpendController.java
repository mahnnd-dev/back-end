package dev.m.controller;

import dev.m.obj.ResponseApi;
import dev.m.obj.entity.Expend;
import dev.m.service.impl.ExpendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Payment Gateway Controller", description = "API Gateway")
public class ExpendController {
    private final ExpendService service;

    @Autowired
    public ExpendController(ExpendService service) {
        this.service = service;
    }
    @Operation(summary = "Tiếp nhận thông tin từ nghiệp vụ", description = "Trả về thông tin / kết quả")
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