/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pushan.elasticsearch.config;

import com.pushan.elasticsearch.data.model.StudentDocument;
import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 *
 * @author Pushan
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.pushan.elasticsearch.data.repository")
public class ElasticSearchConfiguration {

    private static final Logger LOG = Logger.getLogger(ElasticSearchConfiguration.class.getName());

    @Autowired ElasticsearchOperations operations;

    @Bean
    public NodeClientFactoryBean client() {
        File tempDir = new File("temp-elastic");

        NodeClientFactoryBean bean = new NodeClientFactoryBean(true);

        bean.setClusterName(UUID.randomUUID().toString());
        bean.setEnableHttp(true);
        bean.setPathData(new File(tempDir, "logs").getPath());
        bean.setPathHome(tempDir.getPath());

        return bean;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client)
            throws Exception {
        return new ElasticsearchTemplate(client);
    }

    @PreDestroy
    public void deleteIndex() {
        operations.deleteIndex(StudentDocument.class);
    }
}
