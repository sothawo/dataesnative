/*
 * (c) Copyright 2020 sothawo
 */
package com.sothawo.dataesnative;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

import static org.elasticsearch.search.aggregations.AggregationBuilders.*;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Component
public class PersonCustomRepositoryImpl implements PersonCustomRepository {

    private final ElasticsearchOperations operations;

    public PersonCustomRepositoryImpl(ElasticsearchOperations operations) {
        this.operations = operations;
    }

    @Override
    public SearchPage<Person> findByFirstNameWithLastNameCounts(String firstName, Pageable pageable) {

        Query query = new NativeSearchQueryBuilder()
            .addAggregation(terms("lastNames").field("lastName").size(10)) //
            .withQuery(QueryBuilders.matchQuery("firstName", firstName))
            .withPageable(pageable)
            .build();

        SearchHits<Person> searchHits = operations.search(query, Person.class);

        return SearchHitSupport.searchPageFor(searchHits, pageable);
    }
}
