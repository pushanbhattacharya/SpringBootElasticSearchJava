/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pushan.elasticsearch.load;

import com.pushan.elasticsearch.data.model.StudentDocument;
import com.pushan.elasticsearch.data.repository.StudentDaoRepository;
import com.pushan.elasticsearch.data.repository.StudentElasticRepository;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

/**
 *
 * @author Pushan
 */
@Component
public class Loaders {

    @Autowired
    StudentElasticRepository elasticRepository;

    @Autowired
    StudentDaoRepository daoRepository;

    @Autowired
    ElasticsearchOperations operations;

    @PostConstruct
    @Transactional
    public void loadFromDB() {
        operations.putMapping(StudentDocument.class);

        daoRepository
                .findAll()
                .forEach(stu -> elasticRepository.save(new StudentDocument(stu.getId(), stu.getName(), stu.getRollNo(), stu.getMarks(), stu.getDepartment())));
    }
}
