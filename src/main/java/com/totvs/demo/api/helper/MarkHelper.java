package com.totvs.demo.api.helper;

import com.totvs.demo.api.dto.MarkDTO;
import com.totvs.demo.domain.model.Mark;

public final class MarkHelper {
    public static MarkDTO toMarkDTO(Mark mark) {
        return MarkDTO.builder()
                .id(mark.getId())
                .name(mark.getName())
                .createdAt(mark.getCreatedAt())
                .updatedAt(mark.getUpdatedAt())
                .build();
    }

    public static Mark toMark(MarkDTO dto) {
        return Mark.builder()
                .id(dto.getId())
                .name(dto.getName())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
