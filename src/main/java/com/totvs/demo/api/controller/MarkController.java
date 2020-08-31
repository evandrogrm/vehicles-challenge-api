package com.totvs.demo.api.controller;

import com.totvs.demo.api.dto.MarkDTO;
import com.totvs.demo.api.service.MarkService;
import com.totvs.demo.api.specification.MarkFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @GetMapping("/v1/{id}")
    public ResponseEntity<MarkDTO> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(
                this.markService.get(id)
        );
    }

    @PostMapping(value = "/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MarkDTO> create(@RequestBody MarkDTO markDTO) {
        return ResponseEntity.ok(
                this.markService.create(markDTO)
        );
    }

    @PutMapping(value = "/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MarkDTO> update(@RequestBody MarkDTO markDTO) {
        return ResponseEntity.ok(
                this.markService.update(markDTO)
        );
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.markService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1")
    public Page<MarkDTO> search(MarkFilter markFilter, Pageable pageable) {
        return this.markService.search(markFilter, pageable);
    }

}
