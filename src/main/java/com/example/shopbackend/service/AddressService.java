package com.example.shopbackend.service;

import com.example.shopbackend.model.DistrictsInfo;
import com.example.shopbackend.model.ProvinceInfo;
import com.example.shopbackend.repository.CityRepository;
import com.example.shopbackend.repository.DistrictRepository;
import com.example.shopbackend.repository.WardRepository;
import com.example.shopbackend.repository.dto.province.City;
import com.example.shopbackend.repository.dto.province.Districts;
import com.example.shopbackend.repository.dto.province.Ward;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private WardRepository wardRepository;

    public void saveProvinceFromApi() {

        String url = "https://provinces.open-api.vn/api/p";
        String response = restTemplate.getForObject(url, String.class);
        JSONArray jsonArray = new JSONArray(response);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            City city = new City();
            city.setId(Long.valueOf(i+1));
            city.setName(jsonObject.getString("name"));
            city.setPhoneCode(jsonObject.getInt("phone_code"));
            city.setDivisionType(jsonObject.getString("division_type"));
            city.setCodeName(jsonObject.getString("codename"));
            city.setCode(jsonObject.getInt("code"));
            cityRepository.save(city);


        }
    }
    public void saveDistinctFromApi() {

        String url = "https://provinces.open-api.vn/api/d";
        String response = restTemplate.getForObject(url, String.class);
        JSONArray jsonArray = new JSONArray(response);
        System.out.println(jsonArray.length());
        System.out.println(jsonArray.getJSONObject(0));
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Districts districts = new Districts();
            districts.setId(Long.valueOf(i+1));
            districts.setName(jsonObject.getString("name"));
            districts.setDivisionType(jsonObject.getString("division_type"));
            districts.setCodeName(jsonObject.getString("codename"));
            districts.setCode(jsonObject.getInt("code"));
            districts.setProvinceCode(jsonObject.getInt("province_code"));
            districtRepository.save(districts);

        }
    }
    public void saveWardsFromApi() {

        String url = "https://provinces.open-api.vn/api/w";
        String response = restTemplate.getForObject(url, String.class);
        JSONArray jsonArray = new JSONArray(response);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Ward ward = new Ward();
            ward.setId(Long.valueOf(i + 1));
            ward.setName(jsonObject.getString("name"));
            ward.setDivisionType(jsonObject.getString("division_type"));
            ward.setCodeName(jsonObject.getString("codename"));
            ward.setCode(jsonObject.getInt("code"));
            ward.setDistrictCode(jsonObject.getInt("district_code"));
            wardRepository.save(ward);
        }

    }

    @Cacheable(value = "address",cacheManager = "cacheManager3")
    public List<ProvinceInfo> getAllProvince() {

        List<ProvinceInfo> provinceInfoList = new ArrayList<>();
        List<City> cities= cityRepository.findAll();
        for(City city:cities)
        {
            ProvinceInfo provinceInfo = new ProvinceInfo();
            provinceInfo.setCity(city);
            List<Districts> districts=districtRepository.findAllByProvinceCode(city.getCode());
            List<DistrictsInfo> districtsInfos =new ArrayList<>();
            for(Districts dic: districts)
            {
                DistrictsInfo districtsInfo =new DistrictsInfo();
                districtsInfo.setDistricts(dic);
                List<Ward> wards = wardRepository.findAllByDistrictCode(dic.getCode());
                districtsInfo.setWards(wards);
                districtsInfos.add(districtsInfo);
                provinceInfo.setDistricts(districtsInfos);
            }
            provinceInfoList.add(provinceInfo);
        }

        return provinceInfoList;
    }
}
