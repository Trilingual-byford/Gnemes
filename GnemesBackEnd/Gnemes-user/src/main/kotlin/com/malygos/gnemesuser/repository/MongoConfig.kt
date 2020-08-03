package com.malygos.gnemesuser.repository

import com.malygos.gnemesuser.domin.GnemesUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.index.Index
import org.springframework.data.mongodb.core.query.Collation


@Configuration
class MongoConfig {
    @Autowired
    lateinit var mongoOperations: MongoOperations

    @EventListener(ApplicationReadyEvent::class)
    fun initMongo() {
        mongoOperations
                .indexOps(GnemesUser::class.java)
                .ensureIndex(Index()
                        .on("email", Sort.Direction.ASC)
                        .unique()
                        .collation(Collation.of("en").strength(2)))
    }

}