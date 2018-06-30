/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pushan.elasticsearch.data.repository;

import com.pushan.elasticsearch.data.model.StudentDocument;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 *
 * @author Pushan
 */
public interface StudentElasticRepository
        extends ElasticsearchCrudRepository<StudentDocument, Long> {

    public List<StudentDocument> findByName(String name);

}
