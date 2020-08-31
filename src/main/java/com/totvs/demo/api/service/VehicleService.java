package com.totvs.demo.api.service;

import com.totvs.demo.api.dto.VehicleDTO;
import com.totvs.demo.api.helper.VehicleHelper;
import com.totvs.demo.api.repository.VehicleRepository;
import com.totvs.demo.domain.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleDTO get(Integer id) {
        Vehicle vehicle = this.getVehicle(id);
        return VehicleHelper.toVehicleDTO(vehicle);
    }

    public VehicleDTO create(VehicleDTO vehicleDTO) {
        if (vehicleDTO.getId() != null) {
            throw new Error("vehicle.id.present");
        }

        return this.save(vehicleDTO);
    }

    public VehicleDTO update(VehicleDTO vehicleDTO) {
        if (vehicleDTO.getId() == null) {
            throw new Error("vehicle.id.notPresent");
        }

        this.getVehicle(vehicleDTO.getId());
        return this.save(vehicleDTO);
    }

    private VehicleDTO save(VehicleDTO vehicleDTO) {
        if (vehicleDTO.getName() == null || vehicleDTO.getName().isEmpty()) {
            throw new Error("vehicle.name.notPresent");
        }
        if (vehicleDTO.getModel() == null || vehicleDTO.getModel().isEmpty()) {
            throw new Error("vehicle.model.notPresent");
        }
        if (vehicleDTO.getMark() == null) {
            throw new Error("vehicle.mark.notPresent");
        }

        Vehicle vehicle = VehicleHelper.toVehicle(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        return VehicleHelper.toVehicleDTO(vehicle);
    }

    public void delete(Integer id) {
        try {
            Vehicle vehicle = this.getVehicle(id);
            vehicleRepository.delete(vehicle);
        } catch (Exception e) {
            throw new Error("vehicle.delete.connected");
        }
    }

    public Page<VehicleDTO> search(Specification<Vehicle> vehicleFilter, Pageable pageable) {
        Page<Vehicle> vehicles = vehicleRepository.findAll(vehicleFilter, pageable);
        Page<VehicleDTO> vehicleDTOs = vehicles.map(v -> VehicleHelper.toVehicleDTO(v));
        return vehicleDTOs;
    }

    public Vehicle getVehicle(Integer id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (!vehicle.isPresent()) {
            throw new Error("vehicle.notFound");
        }
        return vehicle.get();
    }
}
