package com.example.shopbackend.model;

import com.example.shopbackend.repository.dto.province.City;

import java.io.Serializable;
import java.util.List;

public class ProvinceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private City city;
    private List<DistrictsInfo> districts;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<DistrictsInfo> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictsInfo> districts) {
        this.districts = districts;
    }
}
