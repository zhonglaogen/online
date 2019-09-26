package com.zlx.resume.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.zlx.resume.dto.CuCheckState;
import com.zlx.resume.dto.Expirence;
import com.zlx.resume.dto.Expirences;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.ExperienceUser1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class AddExpirenceService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 添加工作经历，文档的数组内嵌文档
     * @param user
     * @param state
     * @param expirence
     */
    public void addExpir(Companyuser user, CuCheckState state, Expirence expirence){
        expirence.setuCard(state.getuCard());
        expirence.setCuId(String.valueOf(user.getCuId()));
//        mongoTemplate.insert(expirence,"expirences");
        //会增加一条记录ucard：
        Query query = Query.query(Criteria.where("ucard").is(state.getuCard()));
        Update update = new Update();//update.push("Students", student);
        // addToSet如果数据已经存在，则不做任何操作，而push会插入一条一样的数据
        update.addToSet("expir", expirence);
        mongoTemplate.upsert(query, update, Expirence.class,"expirences");
    }


    /**
     * 查询操作
     * @param user
     * @param state
     * @return
     */
    public List<Expirence> findExpir(Companyuser user, CuCheckState state){
        Query query=Query.query(Criteria.where("ucard").is(state.getuCard()));
//        query.fields().include("expir");
        Expirences expirences = mongoTemplate.findOne(query, Expirences.class, "expirences");

//        Aggregation agg = newAggregation(
//                unwind("$userInfo"),
//                match(Criteria.where("ucard").is(state.getuCard()))
//        );
//        AggregationResults<Expirence> expirences = mongoTemplate.aggregate(agg, "expirences", Expirence.class);
//        List<Expirence> mappedResults = expirences.getMappedResults();

        return expirences.getExpirences();
    }


    /**
     * 区别
     * 插入重复数据
     * 　　insert: 若新增数据的主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常提示主键重复，不保存当前数据。
     * 　　save: 若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作。
     *
     * 批操作
     * 　　insert: 可以一次性插入一整个列表，而不用进行遍历操作，效率相对较高
     * 　　save: 需要遍历列表，进行一个个的插入
     */
}
