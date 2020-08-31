package com.totvs.demo.api.helper;

import com.totvs.demo.api.dto.VehicleDTO;
import com.totvs.demo.domain.model.Vehicle;

public final class VehicleHelper {
    public static VehicleDTO toVehicleDTO(Vehicle vehicle) {
        return VehicleDTO.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .model(vehicle.getModel())
                .mark(MarkHelper.toMarkDTO(vehicle.getMark()))
                .cityConsume(vehicle.getCityConsume())
                .highwayConsume(vehicle.getHighwayConsume())
                .fabrication(vehicle.getFabrication())
                .createdAt(vehicle.getCreatedAt())
                .updatedAt(vehicle.getUpdatedAt())
                .build();
    }

    public static Vehicle toVehicle(VehicleDTO dto) {
        return Vehicle.builder()
                .id(dto.getId())
                .name(dto.getName())
                .model(dto.getModel())
                .mark(MarkHelper.toMark(dto.getMark()))
                .cityConsume(dto.getCityConsume())
                .highwayConsume(dto.getHighwayConsume())
                .fabrication(dto.getFabrication())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
