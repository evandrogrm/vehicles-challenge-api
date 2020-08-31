package com.totvs.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vehicle")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @Column(name = "city_consume")
    private BigDecimal cityConsume;

    @Column(name = "highway_consume")
    private BigDecimal highwayConsume;

    @Column(name = "fabrication")
    private Date fabrication;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

}

