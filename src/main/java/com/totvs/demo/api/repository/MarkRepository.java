package com.totvs.demo.api.repository;


import com.totvs.demo.domain.model.Mark;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends PagingAndSortingRepository<Mark, Integer>, JpaSpecificationExecutor<Mark> {
}
