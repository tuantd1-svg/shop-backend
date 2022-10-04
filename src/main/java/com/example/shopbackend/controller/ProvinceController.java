package com.example.shopbackend.controller;

import com.example.commonapi.model.PageInfo;
import com.example.commonapi.model.PageResultMessage;
import com.example.commonapi.model.ResultMessage;
import com.example.commonapi.parameter.enumable.EMessage;
import com.example.commonapi.parameter.enumable.ETransactionStatus;
import com.example.shopbackend.model.ProvinceInfo;
import com.example.shopbackend.service.AddressService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "shop")
public class ProvinceController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "addAddress", method = RequestMethod.PUT)
    public void saveAddressFromApi() throws InterruptedException {
        addressService.saveDistinctFromApi();
        Thread.sleep(400);
        addressService.saveProvinceFromApi();
        Thread.sleep(500);
        addressService.saveWardsFromApi();
    }

    @RequestMapping(value = "address", method = RequestMethod.GET)
    public ResultMessage<List<ProvinceInfo>> getAllAddress() {
        try {
            List<ProvinceInfo> list = addressService.getAllProvince();
            return new ResultMessage(ETransactionStatus.SUCCESS.getStatus(), ETransactionStatus.SUCCESS.getMessage(), true, EMessage.EXECUTE, list);
        } catch (Exception e) {
            return new ResultMessage(ETransactionStatus.PROCESSING_ERROR.getStatus(), ETransactionStatus.PROCESSING_ERROR.getMessage() + " - " + e.getMessage(), false, EMessage.INTERNAL_ERROR);
        }
    }

    @RequestMapping(value = "address", method = RequestMethod.POST)
    public PageResultMessage<List<ProvinceInfo>> getAllAddressPage(@RequestBody PageInfo pageInfo) {
        try {
            List<ProvinceInfo> list = addressService.getAllProvince();
            List<List<ProvinceInfo>> map = Lists.partition(list, pageInfo.getPageSize());
            List<ProvinceInfo> get = map.get(pageInfo.getPageNumber() - 1);
            return new PageResultMessage(ETransactionStatus.SUCCESS.getStatus(), ETransactionStatus.SUCCESS.getMessage(), true, EMessage.EXECUTE, get, pageInfo.getPageSize(), pageInfo.getPageNumber(), list.size(), map.size(), pageInfo.getPageNumber() == map.size());
        } catch (Exception e) {
            return new PageResultMessage(ETransactionStatus.PROCESSING_ERROR.getStatus(), ETransactionStatus.PROCESSING_ERROR.getMessage() + " - " + e.getMessage(), false, EMessage.INTERNAL_ERROR, null, PageInfo.builder().build());
        }
    }
}
