package com.totvs.demo.api.mapper;

import com.totvs.demo.api.dto.MarkDTO;
import com.totvs.demo.domain.model.Mark;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarkMapper {

    List<MarkDTO> toMarkDTOs(List<Mark> marks);

    List<Mark> toMarks(List<MarkDTO> markDTOs);

    MarkDTO toMarkDTO(Mark mark);

    Mark toMark(MarkDTO markDTO);

}
