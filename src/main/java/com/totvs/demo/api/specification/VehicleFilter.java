package com.totvs.demo.api.specification;

import com.totvs.demo.domain.model.Vehicle;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Joins;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;

@Joins({
        @Join(path = "mark", alias = "m", type = JoinType.LEFT),
})
@And({
        @Spec(path = "id", spec = Equal.class),
        @Spec(path = "name", spec = LikeIgnoreCase.class),
        @Spec(path = "model", spec = LikeIgnoreCase.class),
        @Spec(path = "m.id", params = "marks", paramSeparator = ',', spec = In.class),
        @Spec(
                path = "cityConsume",
                params = {"cityConsumeFrom", "cityConsumeTo"},
                spec = Between.class
        ),
        @Spec(
                path = "highwayConsume",
                params = {"highwayConsumeFrom", "highwayConsumeTo"},
                spec = Between.class
        ),
        @Spec(
                path = "createdAt",
                params = {"createdAtFrom", "createdAtTo"},
                spec = Between.class,
                config = {"yyyy-MM-dd hh:mm:ss"}
        ),
        @Spec(
                path = "updatedAt",
                params = {"updatedAtFrom", "updatedAtTo"},
                spec = Between.class,
                config = {"yyyy-MM-dd hh:mm:ss"}
        ),
})
public interface VehicleFilter extends Specification<Vehicle> {
}
