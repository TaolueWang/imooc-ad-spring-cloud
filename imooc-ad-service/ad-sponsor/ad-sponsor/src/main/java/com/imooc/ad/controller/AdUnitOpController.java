package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.entity.unitcondition.AdUnitDistrict;
import com.imooc.ad.entity.unitcondition.AdUnitKeyword;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdUnitService;
import com.imooc.ad.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.jar.JarEntry;

@Slf4j
@RestController
public class AdUnitOpController {
    private final IAdUnitService adUnitService;
    @Autowired
    public AdUnitOpController(IAdUnitService adUnitService) {
        this.adUnitService = adUnitService;
    }
    @PostMapping("/create/adUnit")
    public AdUnitResponse createUnit(
            @RequestBody AdUnitRequest request) throws AdException {
        log.info("ad-sponsor: createUnit->{}",
                JSON.toJSONString(request));
        return adUnitService.createUnit(request);
    }
    @PostMapping("/create/unitKeyword")
    public AdUnitKeyWordResponse createUnitKeyword(
            @RequestBody AdUnitKeyWordRequest request) throws AdException{
        log.info("ad-sponsor: createUnitKeyword -> {}"
        ,JSON.toJSONString(request));
        return adUnitService.createUnitKeyword(request);
    }
    @PostMapping("/create/unitIt")
    public AdUnitItResponse createUnitIt(
            @RequestBody AdUnitItRequest request) throws AdException{
        log.info("ad-sponsor: createUnitIt -> {}",
                JSON.toJSONString(request));
        return adUnitService.createUnitIt(request);

    }
    @PostMapping("/create/unitDistrict")
    public AdUnitDistrictResponse createUnitDistrict(
            @RequestBody AdUnitDistrictRequest request) throws  AdException{
        log.info("ad-sponsor: createDistrict -> {}",
                JSON.toJSONString(request));
        return adUnitService.createUnitDistrict(request);
    }
    @PostMapping("/create/creativeUnit")
    public CreativeUnitResponse creativeUnit(
            @RequestBody CreativeUnitRequest request) throws AdException{
        log.info("ad-sponsor: createCreativeUnit -> {}",
                JSON.toJSONString(request));
        return adUnitService.createCreativeUnit(request);
    }
}
