package com.totvs.demo.api.controller;

import com.totvs.demo.api.dto.VehicleDTO;
import com.totvs.demo.api.service.VehicleService;
import com.totvs.demo.api.specification.VehicleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/v1/{id}")
    public ResponseEntity<VehicleDTO> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(
                this.vehicleService.get(id)
        );
    }

    @PostMapping(value = "/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> create(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(
                this.vehicleService.create(vehicleDTO)
        );
    }

    @PutMapping(value = "/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> update(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(
                this.vehicleService.update(vehicleDTO)
        );
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.vehicleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1")
    public Page<VehicleDTO> search(VehicleFilter vehicleFilter, Pageable pageable) {
        return this.vehicleService.search(vehicleFilter, pageable);
    }

}
