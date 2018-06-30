/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pushan.elasticsearch.data.repository;

import com.pushan.elasticsearch.data.model.StudentDao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Pushan
 */
public interface StudentDaoRepository
        extends CrudRepository<StudentDao, Long> {

}
