package com.sothawo.dataesnative;

import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.auditing.AuditingHandlerSupport;
import org.springframework.data.auditing.IsNewAwareAuditingHandler;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
import org.springframework.data.elasticsearch.core.event.AuditingEntityCallback;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.hint.TypeHint;


@NativeHint(
    types = {
        // auditing stuff
        @TypeHint(typeNames = {"org.springframework.data.elasticsearch.config.PersistentEntitiesFactoryBean"}),
        @TypeHint(types = {ObjectFactoryCreatingFactoryBean.class}),
        @TypeHint(types = {AuditingEntityCallback.class}),
        @TypeHint(types = {AuditingHandlerSupport.class}),
        @TypeHint(types = {IsNewAwareAuditingHandler.class}),
    },
    resources = {
        // for the Faker data
        @ResourceHint(patterns = {".*.yml", "en/.*.yml"})
    }
)
@SpringBootApplication
@EnableElasticsearchAuditing
public class DataesnativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataesnativeApplication.class, args);
    }

}
