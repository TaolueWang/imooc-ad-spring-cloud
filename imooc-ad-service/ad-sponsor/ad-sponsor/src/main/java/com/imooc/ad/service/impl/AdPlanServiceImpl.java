package com.imooc.ad.service.impl;

import com.imooc.ad.constant.CommonStatus;
import com.imooc.ad.constant.Constants;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUserRepository;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUser;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdPlanService;
import com.imooc.ad.utils.CommonUtils;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class AdPlanServiceImpl implements IAdPlanService {
    @Autowired
    private final AdUserRepository userRepository;
    @Autowired
    private final AdPlanRepository planRepository;

    public AdPlanServiceImpl(AdUserRepository userRepository, AdPlanRepository planRepository) {
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    @Override
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {
        if(!request.createValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        //确保
        Optional<AdUser> adUser = userRepository.findById(request.getUserId());
        if(!adUser.isPresent()){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        AdPlan oldPlan = planRepository.findByUserIdAndPlanName(request.getUserId(), request.getPlanName());
        if(oldPlan != null){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdPlan newAdPlan = planRepository.save(new AdPlan(request.getUserId(),
                request.getPlanName(),
                CommonUtils.parseerStringDate(request.getStarDate()),
                CommonUtils.parseerStringDate(request.getEndDate())));
        return new AdPlanResponse(newAdPlan.getId(), newAdPlan.getPlanName());
    }

    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        if(!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        return planRepository.findAllByIdInAndUserId(
                request.getIds(), request.getUserId()
        );
    }

    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {
        if(!request.updateValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdPlan plan = planRepository.findByIdandUserId(request.getId(),
                request.getUserId());
        if(plan == null){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        if(request.getPlanName() != null){
            plan.setPlanName(request.getPlanName());
        }
        if(request.getStarDate() != null){
            plan.setStartDate(
                    CommonUtils.parseerStringDate(request.getStarDate()));
        }
        if(request.getEndDate() != null){
            plan.setEndDate(
                    CommonUtils.parseerStringDate(request.getEndDate()));
        }
        plan.setUpdateTime(new Date());
        plan = planRepository.save(plan);
        return new AdPlanResponse(plan.getId(), plan.getPlanName());
    }

    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {
        if(request.deleteValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdPlan plan = planRepository.findByIdandUserId(
                request.getId(), request.getUserId()
        );
        if(plan == null){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        plan.setPlanStatus(CommonStatus.InVALID.getStatus());
        plan.setUpdateTime(new Date());
        plan = planRepository.save(plan);
    }
}
