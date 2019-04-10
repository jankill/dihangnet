package com.szdihang.dhome.service.impl;

import com.szdihang.dhome.controller.GatherDataDictController;
import com.szdihang.dhome.dto.GatherDataDictDto;
import com.szdihang.dhome.model.GatherDataDict;
import com.szdihang.dhome.repository.GatherDataDictRepository;
import com.szdihang.dhome.service.IGatherDataDictService;
import com.szdihang.dhome.vo.GatherDataDicSaveVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author glory
 * @version V1.0
 * @Title: GatherDataDictServiceImpl
 * @Package: com.szdihang.dhome.service
 * @Description: TODO
 * @date 2019/4/7 10:25
 **/

@Service
public class GatherDataDictServiceImpl implements IGatherDataDictService {
    private final GatherDataDictRepository repository;

    @Autowired
    public GatherDataDictServiceImpl(GatherDataDictRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GatherDataDictDto save(GatherDataDicSaveVo saveVo) {
        GatherDataDict gatherDataDict = new GatherDataDict();
        BeanUtils.copyProperties(saveVo, gatherDataDict);
        GatherDataDict gatherDataDict1 = repository.save(gatherDataDict);
        if (Optional.ofNullable(gatherDataDict1).isPresent()) {
            GatherDataDictDto dto = new GatherDataDictDto();
            BeanUtils.copyProperties(gatherDataDict1, dto);
            return dto;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<GatherDataDictDto> insertAll(List<GatherDataDicSaveVo> saveVoList) {
        if (!Optional.ofNullable(saveVoList).isPresent()) {
            return null;
        }
        GatherDataDict gatherDataDict;
        List<GatherDataDict> gatherDataDicts = new ArrayList<>(saveVoList.size());
        for (GatherDataDicSaveVo gatherDataDicSaveVo : saveVoList) {
            gatherDataDict = new GatherDataDict();
            BeanUtils.copyProperties(gatherDataDicSaveVo, gatherDataDict);
            gatherDataDicts.add(gatherDataDict);
        }

        Iterable<GatherDataDict> gatherDataDicts1 = repository.saveAll(gatherDataDicts);
        if (Optional.ofNullable(gatherDataDicts1).isPresent()) {
            GatherDataDictDto dto;
            List<GatherDataDictDto> dtos = new ArrayList<>();
            for (GatherDataDict dataDict : gatherDataDicts1) {
                dto = new GatherDataDictDto();
                BeanUtils.copyProperties(dataDict, dto);
                dtos.add(dto);
            }
            return dtos;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public GatherDataDictDto findById(Long id) {
        Optional<GatherDataDict> dataDict = repository.findById(id);
        if (dataDict.isPresent()) {
            GatherDataDictDto dto = new GatherDataDictDto();
            GatherDataDict gatherDataDict = dataDict.get();
            BeanUtils.copyProperties(gatherDataDict, dto);
            return dto;
        }
        return null;
    }

    @Override
    public List<GatherDataDictDto> findAll() {
        Iterable<GatherDataDict> all = repository.findAll();
        if (Optional.ofNullable(all).isPresent()) {
            ArrayList<GatherDataDictDto> dtos = new ArrayList<>();
            GatherDataDictDto dto = new GatherDataDictDto();
            for (GatherDataDict gatherDataDict : all) {
                BeanUtils.copyProperties(gatherDataDict, dto);
                dtos.add(dto);
            }
            return dtos;
        }
        return null;
    }
}
