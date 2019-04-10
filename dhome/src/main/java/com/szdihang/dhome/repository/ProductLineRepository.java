package com.szdihang.dhome.repository;

import com.szdihang.dhome.model.GatherDataDict;
import com.szdihang.dhome.model.ProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @author glory
 * @version V1.0
 * @Title: ProductLineRepository
 * @Package: com.szdihang.dhome.repository
 * @Description: 产品系列
 * @date 2019/4/7 10:48
 **/
@Repository
public class ProductLineRepository implements CrudRepository<ProductLine, Long> {

    private final MongoTemplate mongoTemplate;

    /**
     * @return
     * @Author glory
     * @Description //TODO
     * @Date 11:00 2019/4/7
     * @Param [operations]
     **/
    @Autowired
    public ProductLineRepository(MongoTemplate mongoTemplate) {
        Assert.notNull(mongoTemplate, "MongoTemplate 不能为空！");
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public <S extends ProductLine> S save(S entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public <S extends ProductLine> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProductLine> findById(Long id) {
        ProductLine productLine = mongoTemplate.findById(id, ProductLine.class);
        return Optional.ofNullable(productLine);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ProductLine> findAll() {
        return mongoTemplate.findAll(ProductLine.class);
    }

    @Override
    public Iterable<ProductLine> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        Optional<ProductLine> productLine = findById(id);
        if (productLine.isPresent()) {
            mongoTemplate.remove(productLine.get());
        }
    }

    @Override
    public void delete(ProductLine entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductLine> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
