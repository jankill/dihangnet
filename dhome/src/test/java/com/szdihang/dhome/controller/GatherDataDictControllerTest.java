package com.szdihang.dhome.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.szdihang.dhome.DhomeApplication;
import com.szdihang.dhome.service.IGatherDataDictService;
import com.szdihang.dhome.vo.GatherDataDicSaveVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author glory
 * @version V1.0
 * @Title: GatherDataDictControllerTest
 * @Package: com.szdihang.dhome.controller
 * @Description: TODO
 * @date 2019/4/7 15:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DhomeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GatherDataDictControllerTest {
    @Autowired
    IGatherDataDictService iGatherDataDictService;

    @Test
    public void saveAll() {
        ArrayList<GatherDataDicSaveVo> list = new ArrayList<>();
        List<String> datas = new ArrayList<>();
        datas.add("长");
        datas.add("宽度");
        datas.add("高");

        String date = LocalDateTime.now(ZoneId.systemDefault()).toString();
        GatherDataDicSaveVo vo = new GatherDataDicSaveVo();
        vo.setId(1554622951259L);
        vo.setName("阳台");
        vo.setDel_flg("1");
        vo.setC_date(date);
        vo.setGatherDatas(datas);
        GatherDataDicSaveVo vo1 = new GatherDataDicSaveVo();
        vo1.setId(System.currentTimeMillis());
        vo1.setName("阳台1");
        vo1.setDel_flg("1");
        vo1.setC_date(date);
        vo1.setGatherDatas(datas);
        GatherDataDicSaveVo vo2 = new GatherDataDicSaveVo();
        vo2.setId(System.currentTimeMillis());
        vo2.setName("阳台2");
        vo2.setDel_flg("1");
        vo2.setC_date(date);
        vo2.setGatherDatas(datas);

        list.add(vo);
        list.add(vo1);
        list.add(vo2);
        iGatherDataDictService.save(vo);
        Gson gson = new GsonBuilder().create();
        gson.toJson(vo);
        System.out.println(gson.toJson(vo));
    }
}