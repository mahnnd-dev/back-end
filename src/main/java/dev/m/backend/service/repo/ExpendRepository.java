package dev.m.backend.service.repo;

import dev.m.backend.obj.entity.Expend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpendRepository extends JpaRepository<Expend, Long> {
}
