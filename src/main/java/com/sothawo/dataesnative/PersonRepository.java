package com.sothawo.dataesnative;

import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person, Long>, PersonCustomRepository {
    SearchHits<Person> findByLastName(final String lastName);
}
