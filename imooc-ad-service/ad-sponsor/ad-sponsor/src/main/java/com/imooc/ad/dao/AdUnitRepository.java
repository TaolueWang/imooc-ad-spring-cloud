package com.imooc.ad.dao;

import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {
    AdUnit findPlanIdAndUnitName(Long planId, String unitName);
    List<AdUnit> findAllByUnitStatus(Integer unitStatus);

//    boolean findById(List<Long> unitIds);
}
