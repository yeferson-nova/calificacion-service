package com.ynova.msvc.calificacion.config;

import com.ynova.msvc.calificacion.config.codec.ZonedDateTimeCodec;
import com.ynova.msvc.calificacion.converter.ZonedDateTimeReadConverter;
import com.ynova.msvc.calificacion.converter.ZonedDateTimeWriteConverter;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.Arrays;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                CodecRegistries.fromCodecs(new ZonedDateTimeCodec()),
                MongoClientSettings.getDefaultCodecRegistry());

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(
                        new com.mongodb.ConnectionString("mongodb://localhost:27017/msvc-calificaciones"))
                .codecRegistry(codecRegistry)
                .build();

        return MongoClients.create(settings);
    }

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDatabaseFactory(MongoClient mongoClient) {
        return new SimpleMongoClientDatabaseFactory(mongoClient, "msvc-calificaciones");
    }

    @Bean
    public MongoTemplate mongoTemplate(SimpleMongoClientDatabaseFactory databaseFactory,
            MappingMongoConverter converter) {
        return new MongoTemplate(databaseFactory, converter);
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter(SimpleMongoClientDatabaseFactory databaseFactory,
            MongoMappingContext context) {
        MappingMongoConverter converter = new MappingMongoConverter(databaseFactory, context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        converter.setCustomConversions(customConversions());
        converter.afterPropertiesSet();
        return converter;
    }

    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(
                new ZonedDateTimeReadConverter(),
                new ZonedDateTimeWriteConverter()));
    }
}