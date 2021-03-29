/*
 * (c) Copyright 2019 sothawo
 */
package com.sothawo.dataesnative;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.lang.Nullable;

import java.time.Instant;
import java.time.LocalDate;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Document(indexName = "person")
public class Person implements Persistable<Long> {

    @Id
    @Nullable
    private Long id;

    @Field(type = FieldType.Text, fielddata = true)
    @Nullable
    private String lastName;

    @Field(type = FieldType.Text, fielddata = true)
    @Nullable
    private String firstName;

    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    @Nullable
    private LocalDate birthDate;

    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    @Nullable
    private Instant created;
    @CreatedBy
    @Nullable
    private String createdBy;
    @LastModifiedDate
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    @Nullable
    private Instant lastModified;
    @LastModifiedBy
    @Nullable
    private String lastModifiedBy;

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Nullable
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    @Nullable
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Nullable
    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    @Nullable
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return id == null || (createdBy == null && created == null);
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", birthDate=" + birthDate +
            ", created=" + created +
            ", createdBy='" + createdBy + '\'' +
            ", lastModified=" + lastModified +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            '}';
    }
}
