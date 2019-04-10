package com.szdihang.dhome.service.impl;

import com.szdihang.dhome.dto.GatherDataDictDto;
import com.szdihang.dhome.dto.ProductLineDto;
import com.szdihang.dhome.model.GatherDataDict;
import com.szdihang.dhome.model.ProductLine;
import com.szdihang.dhome.repository.GatherDataDictRepository;
import com.szdihang.dhome.repository.ProductLineRepository;
import com.szdihang.dhome.service.IGatherDataDictService;
import com.szdihang.dhome.service.IProductLineService;
import com.szdihang.dhome.vo.GatherDataDicSaveVo;
import com.szdihang.dhome.vo.ProductLineSaveVo;
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
 * @Title: ProductLineServiceImpl
 * @Package: com.szdihang.dhome.service
 * @Description: 产品系列
 * @date 2019/4/7 10:25
 **/

@Service
public class ProductLineServiceImpl implements IProductLineService {
    private final ProductLineRepository repository;

    @Autowired
    public ProductLineServiceImpl(ProductLineRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ProductLineDto save(ProductLineSaveVo saveVo) {
        ProductLine productLine = new ProductLine();
        BeanUtils.copyProperties(saveVo, productLine);
        ProductLine tempProd = repository.save(productLine);
        if (Optional.ofNullable(tempProd).isPresent()) {
            ProductLineDto dto = new ProductLineDto();
            BeanUtils.copyProperties(tempProd, dto);
            return dto;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<ProductLineDto> insertAll(List<ProductLineSaveVo> saveVoList) {
        if (!Optional.ofNullable(saveVoList).isPresent()) {
            return null;
        }
        ProductLine productLine;
        List<ProductLine> productLines = new ArrayList<>(saveVoList.size());
        for (ProductLineSaveVo productLineSaveVo : saveVoList) {
            productLine = new ProductLine();
            BeanUtils.copyProperties(productLineSaveVo, productLine);
            productLines.add(productLine);
        }

        Iterable<ProductLine> tmpProd = repository.saveAll(productLines);
        if (Optional.ofNullable(tmpProd).isPresent()) {
            ProductLineDto dto;
            List<ProductLineDto> dtos = new ArrayList<>();
            for (ProductLine prod : tmpProd) {
                dto = new ProductLineDto();
                BeanUtils.copyProperties(prod, dto);
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
    public ProductLineDto findById(Long id) {
        Optional<ProductLine> productLine = repository.findById(id);
        if (productLine.isPresent()) {
            ProductLineDto dto = new ProductLineDto();
            ProductLine tmpProd = productLine.get();
            BeanUtils.copyProperties(tmpProd, dto);
            return dto;
        }
        return null;
    }

    @Override
    public List<ProductLineDto> findAll() {
        Iterable<ProductLine> all = repository.findAll();
        if (Optional.ofNullable(all).isPresent()) {
            ArrayList<ProductLineDto> dtos = new ArrayList<>();
            ProductLineDto dto = new ProductLineDto();
            for (ProductLine productLine : all) {
                BeanUtils.copyProperties(productLine, dto);
                dtos.add(dto);
            }
            return dtos;
        }
        return null;
    }
}
