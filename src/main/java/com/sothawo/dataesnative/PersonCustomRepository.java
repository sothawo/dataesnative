/*
 * (c) Copyright 2020 sothawo
 */
package com.sothawo.dataesnative;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchPage;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
public interface PersonCustomRepository {
    SearchPage<Person> findByFirstNameWithLastNameCounts(String firstName, Pageable pageable);
}
