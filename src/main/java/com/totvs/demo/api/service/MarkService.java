package com.totvs.demo.api.service;

import com.totvs.demo.api.dto.MarkDTO;
import com.totvs.demo.api.helper.MarkHelper;
import com.totvs.demo.api.repository.MarkRepository;
import com.totvs.demo.domain.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    public MarkDTO get(Integer id) {
        Mark mark = this.getMark(id);
        return MarkHelper.toMarkDTO(mark);
    }

    public MarkDTO create(MarkDTO markDTO) {
        if (markDTO.getName() == null || markDTO.getName().isEmpty()) {
            throw new Error("mark.name.notPresent");
        }
        if (markDTO.getId() != null) {
            throw new Error("mark.id.present");
        }

        Mark mark = MarkHelper.toMark(markDTO);
        mark = markRepository.save(mark);

        return MarkHelper.toMarkDTO(mark);
    }

    public MarkDTO update(MarkDTO markDTO) {
        if (markDTO.getId() == null) {
            throw new Error("mark.id.notPresent");
        }

        Mark mark = this.getMark(markDTO.getId());
        mark.setName(markDTO.getName());

        return MarkHelper.toMarkDTO(mark);
    }

    public void delete(Integer id) {
        try {
            Mark mark = this.getMark(id);
            markRepository.delete(mark);
        } catch (Exception e) {
            throw new Error("mark.delete.connected");
        }
    }

    public Page<MarkDTO> search(Specification<Mark> markFilter, Pageable pageable) {
        Page<Mark> marks = markRepository.findAll(markFilter, pageable);
        Page<MarkDTO> markDTOs = marks.map(m -> MarkHelper.toMarkDTO(m));
        return markDTOs;
    }

    private Mark getMark(Integer id) {
        Optional<Mark> mark = markRepository.findById(id);
        if (!mark.isPresent()) {
            throw new Error("mark.notFound");
        }
        return mark.get();
    }
}
