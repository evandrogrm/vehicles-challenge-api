package com.totvs.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDTO {
    private Integer id;
    private String name;
    private String model;
    private MarkDTO mark;
    private BigDecimal cityConsume;
    private BigDecimal highwayConsume;
    private Date fabrication;
    private Date createdAt;
    private Date updatedAt;
}
