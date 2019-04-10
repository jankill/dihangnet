package com.szdihang.dhome.repository;

import com.szdihang.dhome.model.GatherDataDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @author glory
 * @version V1.0
 * @Title: GatherDataDictRepository
 * @Package: com.szdihang.dhome.repository
 * @Description: TODO
 * @date 2019/4/7 10:48
 **/
@Repository
public class GatherDataDictRepository implements CrudRepository<GatherDataDict, Long> {

    private final MongoTemplate mongoTemplate;

    /**
     * @return
     * @Author glory
     * @Description //TODO
     * @Date 11:00 2019/4/7
     * @Param [operations]
     **/
    @Autowired
    public GatherDataDictRepository(MongoTemplate mongoTemplate) {
        Assert.notNull(mongoTemplate, "MongoTemplate 不能为空！");
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public <S extends GatherDataDict> S save(S entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public <S extends GatherDataDict> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<GatherDataDict> findById(Long id) {
        GatherDataDict gatherDataDict = mongoTemplate.findById(id, GatherDataDict.class);
        return Optional.ofNullable(gatherDataDict);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<GatherDataDict> findAll() {
        return mongoTemplate.findAll(GatherDataDict.class);
    }

    @Override
    public Iterable<GatherDataDict> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        Optional<GatherDataDict> gatherDataDict = findById(id);
        if (gatherDataDict.isPresent()) {
            mongoTemplate.remove(gatherDataDict.get());
        }
    }

    @Override
    public void delete(GatherDataDict entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends GatherDataDict> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
