package com.sothawo.dataesnative;

import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.stream.Stream;

public interface PersonRepository extends ElasticsearchRepository<Person, Long>, PersonCustomRepository {
    Stream<Person> findAllBy();
    Stream<SearchHit<Person>> findByLastName(final String lastName);
}
