package com.totvs.demo.api.specification;

import com.totvs.demo.domain.model.Mark;
import net.kaczmarzyk.spring.data.jpa.domain.DateBetween;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "id", spec = Equal.class),
        @Spec(path = "name", spec = LikeIgnoreCase.class),
        @Spec(
                path = "createdAt",
                params = {"createdAtFrom", "createdAtTo"},
                spec = DateBetween.class,
                config = {"yyyy-MM-dd hh:mm:ss"}
        ),
        @Spec(
                path = "updatedAt",
                params = {"updatedAtFrom", "updatedAtTo"},
                spec = DateBetween.class,
                config = {"yyyy-MM-dd hh:mm:ss"}
        ),
})
public interface MarkFilter extends Specification<Mark> {
}
