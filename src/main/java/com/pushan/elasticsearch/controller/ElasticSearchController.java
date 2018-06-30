/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pushan.elasticsearch.controller;

import com.pushan.elasticsearch.data.model.StudentDocument;
import com.pushan.elasticsearch.data.repository.StudentElasticRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pushan
 */
@RestController
@RequestMapping("/elastic/search")
public class ElasticSearchController {

    @Autowired
    StudentElasticRepository elasticRepository;

    @GetMapping("/students")
    public List<StudentDocument> getAllStudents() {
        List<StudentDocument> studentDocumentList = new ArrayList<>();

        elasticRepository.findAll().forEach(studentDocumentList::add);

        return studentDocumentList;
    }

    @GetMapping("/students/names/{name}")
    public List<StudentDocument> getStudentByName(@PathVariable final String name) {
        return elasticRepository.findByName(name);
    }
}
