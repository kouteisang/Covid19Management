package com.covidmanage.controller;

import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.service.ArrivalService;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://192.168.0.9:8080", allowCredentials = "true")
@RestController
@RequestMapping("/arrival")
public class ArrivalController {

    @Autowired
    private ArrivalService arrivalService;
    @Autowired
    private CommunityUserService communityUserService;

    @PostMapping("/addArrival")
    public ResponseTemplate addArrival(@RequestParam(value = "identityId") String identityId,
                                       @RequestParam(value = "departureLocation") String departureLocation,
                                       @RequestParam(value = "arriveTime") String arriveTime){
        CommunityUser userByIndentityId = communityUserService.findUserByIndentityId(identityId);
        if (userByIndentityId == null){
            return ResponseTemplate.fail(ResponseCode.NO_THIS_PERSON.val(), ResponseCode.NO_THIS_PERSON.msg());
        }
        arrivalService.addArrival(identityId, departureLocation, arriveTime);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }
}
