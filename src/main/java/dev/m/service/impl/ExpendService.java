package dev.m.service.impl;

import dev.m.obj.ResponseApi;
import dev.m.obj.entity.Expend;
import dev.m.service.repo.ExpendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ExpendService {
    private final ExpendRepository repository;

    @Autowired
    public ExpendService(ExpendRepository repository) {
        this.repository = repository;
    }

    public ResponseApi add(Expend request) {
        log.info("ResponseApi {}", request);
        Expend expend = repository.save(request);
        if (expend.getId() != null) {
            log.info("add success: {}", expend);
            return new ResponseApi(true, "add successful", request);
        }
        return new ResponseApi(false, "add false", null);
    }

    public ResponseApi update(Expend request) {
        Optional<Expend> optionalUser = repository.findById(request.getId());
        if (optionalUser.isPresent()) {
            Expend expend = optionalUser.get();
            expend.setName(request.getName());
            expend.setDateCreate(request.getDateCreate());
            expend.setPrice(request.getPrice());
            expend.setTimeId(request.getTimeId());
            repository.save(expend);
            return new ResponseApi(true, "update successful", expend);
        } else {
            return new ResponseApi(false, "update false", null);
        }
    }

    public ResponseApi del(Expend request) {
        if (repository.existsById(request.getId())) {
            repository.deleteById(request.getId());
            log.info("del success: {}", request);
            return new ResponseApi(true, "del successful", request);
        } else {
            return new ResponseApi(false, "dell false", null);
        }
    }
}
