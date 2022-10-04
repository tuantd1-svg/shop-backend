package com.example.shopbackend.model;

import com.example.shopbackend.repository.dto.province.Districts;
import com.example.shopbackend.repository.dto.province.Ward;

import java.io.Serializable;
import java.util.List;

public class DistrictsInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Districts districts;
    private List<Ward> wards;

    public Districts getDistricts() {
        return districts;
    }

    public void setDistricts(Districts districts) {
        this.districts = districts;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }
}
