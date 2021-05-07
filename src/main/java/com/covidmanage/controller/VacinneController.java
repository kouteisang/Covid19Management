package com.covidmanage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.dto.VaccineSituationDataDTO;
import com.covidmanage.enums.VaccineStatusEnum;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.VaccineReservation;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.service.VaccineService;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import com.github.pagehelper.PageHelper;
import jdk.nashorn.internal.scripts.JO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@CrossOrigin(origins = "http://192.168.0.9:8080", allowCredentials = "true")
@RestController
@RequestMapping("/vacinne")
public class VacinneController {

    @Autowired
    private VaccineService vaccineService;
    @Autowired
    private CommunityUserService communityUserService;

    @GetMapping("/getChinaVacinneData")
    public ResponseTemplate getChinaVacinneData(){
        Map<Object, Object> map = new HashMap<>();
        String chinaData = HttpUtil.doGet("https://api.inews.qq.com/newsqa/v1/automation/modules/list?modules=ChinaVaccineTrendData", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(chinaData);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray chinaVaccineTrendData = data.getJSONArray("ChinaVaccineTrendData");
        List<Integer> totalVaccinationsList = new ArrayList<>();
        List<Double> totalVaccinationsPerHundredList = new ArrayList<>();
        List<String> dateList = new ArrayList<>();
        int len = chinaVaccineTrendData.size();
        for(int i = len-1; i >= len - 17; i --){
            JSONObject coviddata = chinaVaccineTrendData.getJSONObject(i);
            String date = coviddata.getString("date");
            Integer totalVaccinations = coviddata.getInteger("total_vaccinations");
            Double totalVaccinationsPerHundred = coviddata.getDouble("total_vaccinations_per_hundred");
            dateList.add(date);
            totalVaccinationsList.add(totalVaccinations);
            totalVaccinationsPerHundredList.add(totalVaccinationsPerHundred);
        }
        Collections.reverse(dateList);
        Collections.reverse(totalVaccinationsList);
        Collections.reverse(totalVaccinationsPerHundredList);
        map.put("dateList", dateList);
        map.put("totalVaccinationsList",totalVaccinationsList);
        map.put("totalVaccinationsPerHundredList",totalVaccinationsPerHundredList);
        return ResponseTemplate.success(map);
    }

    @GetMapping("/getAllCountryVaccineSituationData")
    public ResponseTemplate getAllCountryVaccineSituationData(){
        String vaccineSituationData = HttpUtil.doGet("https://api.inews.qq.com/newsqa/v1/automation/modules/list?modules=VaccineSituationData", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(vaccineSituationData);
        JSONArray vaccineDate = jsonObject.getJSONObject("data").getJSONArray("VaccineSituationData");
        List<VaccineSituationDataDTO> list = new ArrayList<>();
        for (int i = 0; i < vaccineDate.size(); i ++){
            String country = vaccineDate.getJSONObject(i).getString("country");
            String date = vaccineDate.getJSONObject(i).getString("date");
            String vaccinations = vaccineDate.getJSONObject(i).getString("vaccinations");
            Integer totalVaccinations = vaccineDate.getJSONObject(i).getInteger("total_vaccinations");
            Double totalVaccinationsPerHundred = vaccineDate.getJSONObject(i).getDouble("total_vaccinations_per_hundred");
            VaccineSituationDataDTO vaccineSituation = VaccineSituationDataDTO.builder()
                    .country(country)
                    .date(date)
                    .vaccinations(vaccinations)
                    .totalVaccinations(totalVaccinations)
                    .totalVaccinationsPerHundred(totalVaccinationsPerHundred)
                    .build();
            list.add(vaccineSituation);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("list", list);
        return ResponseTemplate.success(map);
    }

    @PostMapping("/addVaccineLocation")
    public ResponseTemplate addVaccineLocation(@RequestParam(value = "hospitalName") String hospitalName,
                                               @RequestParam(value = "hospitalLocation") String hospitalLocation,
                                               @RequestParam(value = "hospitalTel") String hospitalTel,
                                               @RequestParam(value = "type") String type,
                                               @RequestParam(value = "picUrl") String picUrl){
        vaccineService.addVaccineLocation(hospitalName, hospitalLocation, hospitalTel, type, picUrl);
        return ResponseTemplate.success(ResponseCode.SUCCESS.msg(), ResponseCode.SUCCESS.val());
    }


    @GetMapping("/getVaccineList")
    public ResponseTemplate getVaccineList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                           @RequestParam(value = "hospitalName", required = false, defaultValue = "") String hospitalName,
                                           @RequestParam(value = "hospitalLocation", required = false, defaultValue = "") String hospitalLocation,
                                           @RequestParam(value = "hospitalTel", required = false, defaultValue = "") String hospitalTel){
        PageHelper.startPage(page, size);
        Map<Object, Object> vaccineList = vaccineService.getVaccineList(page, size, hospitalName, hospitalLocation, hospitalTel);
        return ResponseTemplate.success(vaccineList);
    }


    /**
     * vaccineService
     * 身份证号
     * 姓名
     * 联系电话
     * 医院名称
     * 接种状态
     * 疫苗品种
     * 接种截图信息
     */
    @PostMapping("/reserveVaccine")
    public ResponseTemplate reserveVaccine(@RequestParam(value = "identityId") String identityId,
                                           @RequestParam(value = "hospitalName") String hospitalName,
                                           @RequestParam(value = "vaccineStatus") Integer vaccineStatus,
                                           @RequestParam(value = "vaccineType") Integer vaccineType){
        if(vaccineStatus.equals(VaccineStatusEnum.two.getKey())){

        }
        boolean vaccineReservation = vaccineService.selectByIdentityId(identityId);
        if(vaccineReservation == false){
            return ResponseTemplate.fail(ResponseCode.ERROR.val(), ResponseCode.ERROR.msg());
        }
        CommunityUser userInfo = communityUserService.findUserByIndentityId(identityId);
        vaccineService.reserveVaccine(userInfo.getIdentityId(), userInfo.getRealName(), userInfo.getPhone(), hospitalName, vaccineStatus, vaccineType,"");
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }
}
