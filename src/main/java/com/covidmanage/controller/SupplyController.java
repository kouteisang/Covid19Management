package com.covidmanage.controller;

import com.covidmanage.dto.AskSupplyNeed;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.service.SupplyService;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://10.151.60.110:8080", maxAge = 3600)
@RestController
@RequestMapping("/user/supply")
public class SupplyController {

    @Autowired
    public CommunityUserService communityUserService;
    @Autowired
    public SupplyService supplyService;
    /**
     * 物资申请
     * @param identityId
     * @param supplyType
     * @param supplyContent
     * @param age
     * @param isEmergency
     * @param suggestion
     * @return
     */
    @PostMapping("/applySupply")
    public ResponseTemplate applySupply(@RequestParam(value = "identityId") String identityId,
                                        @RequestParam(value = "supplyType") String supplyType,
                                        @RequestParam(value = "supplyContent") String supplyContent,
                                        @RequestParam(value = "age") Integer age,
                                        @RequestParam(value = "isEmergency") Integer isEmergency,
                                        @RequestParam(value = "suggestion", required = false) String suggestion){
        CommunityUser user = communityUserService.findUserByIndentityId(identityId);
        if(user == null)
            return ResponseTemplate.fail(ResponseCode.NO_THIS_PERSON.val(), ResponseCode.NO_THIS_PERSON.msg());
        int i = supplyService.applySupply(identityId, supplyType, supplyContent, age, isEmergency, suggestion);
        if(i > 0)
            return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
        return ResponseTemplate.fail(ResponseCode.ERROR.val(), ResponseCode.ERROR.msg());
    }

    /**
     * 得到需要求助物资列表
     * @param supplyType
     * @param supplyContent
     * @param isEmergency
     * @return
     */
    @GetMapping("/getAskForSupplyList")
    public ResponseTemplate getAskForSupplyList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                                @RequestParam(value = "supplyType", required = false) String supplyType,
                                                @RequestParam(value = "supplyContent", required = false) String supplyContent,
                                                @RequestParam(value = "isEmergency",  required = false) Integer isEmergency){
        PageHelper.startPage(page, size);
        Map<Object, Object> map = supplyService.getAskForSupplyList(page, size, supplyType, supplyContent, isEmergency);
        return ResponseTemplate.success(map);
    }
}
