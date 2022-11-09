package com.imooc.ad.service;

import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.unitcondition.AdUnitDistrict;
import com.imooc.ad.entity.unitcondition.CreativeUnit;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.*;

public interface IAdUnitService {
    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;
    AdUnitKeyWordResponse createUnitKeyword(AdUnitKeyWordRequest request) throws AdException;
    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException;
    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException;
    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest Request) throws AdException;
}
