package com.covidmanage.controller;

import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.VerifyUser;
import com.covidmanage.service.CommonService;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.service.SupplyService;
import com.covidmanage.service.VerifyService;
import com.covidmanage.utils.CommonUtil;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/user/supply")
public class SupplyController {

    @Autowired
    public CommunityUserService communityUserService;
    @Autowired
    public SupplyService supplyService;
    @Autowired
    public CommonService commonService;
    @Autowired
    public VerifyService verifyService;
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
                                        @RequestParam(value = "suggestion",defaultValue = "暂无建议") String suggestion){
        VerifyUser userInfo = verifyService.getUserInfo(identityId);
        if(userInfo == null){
            return ResponseTemplate.fail(ResponseCode.NO_VERIFY.val(), ResponseCode.NO_VERIFY.msg());
        }
        if(!CommonUtil.isIDNumber(identityId)){
            return ResponseTemplate.fail(ResponseCode.ERROR.val(),ResponseCode.ERROR.msg());
        }
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

    /**
     * 得到每个年龄段最想要的物资
     * @return
     */
    @GetMapping("/getSupplyContentByAge")
    public ResponseTemplate getSupplyContentByAge(){
        List<String> supplyContent = new ArrayList<>();
        List<Integer> supplyCount = new ArrayList<>();
        for(Integer i = 1; i <= 5; i ++){
            String supplyContentByAge = supplyService.getSupplyContentByAge(i);
            supplyContent.add(supplyContentByAge);
            Integer supplyCountByAge = supplyService.getSupplyCountByAge(i);
            supplyCount.add(supplyCountByAge);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("supplyContent", supplyContent);
        map.put("supplyCount", supplyCount);
        return ResponseTemplate.success(map);
    }

    /**
     * 近五日缺少物品种类统计
     */
    @GetMapping("/getSupplyKindByDay")
    public ResponseTemplate getSupplyKindByDay(){
        List<String> supplyKinds = commonService.getAllSupplyKind();
        List<String> days = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        int num = 0;
        for(String sk : supplyKinds){
            List<Integer> list = new ArrayList<>();
            num ++;
            for(int i = 5; i >= 1; i --){
                int mus = -1 * i;
                String day = LocalDateTime.now().plusDays(mus).toString();
                String day0 = day.split("T")[0];
                Integer supplyKindCountByDay = supplyService.getSupplyKindCountByDay(sk, day0);
                list.add(supplyKindCountByDay);
                if(num == 1)
                    days.add(day0);
            }
            map.put(sk, list);
        }
        map.put("days", days);
        return ResponseTemplate.success(map);
    }
}