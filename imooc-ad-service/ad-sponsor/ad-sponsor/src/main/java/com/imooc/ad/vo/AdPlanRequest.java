package com.imooc.ad.vo;

import com.netflix.discovery.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanRequest {
    private Long id;
    private Long userId;
    private String planName;
    private String starDate;
    private String endDate;
    public boolean createValidate() {
        return userId != null
                && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(starDate)
                && !StringUtils.isEmpty(endDate);
    }
    public boolean updateValidate(){
        return id != null && userId != null;
    }
    public boolean deleteValidate(){
        return id != null && userId != null;
    }
}
