package com.malygos.gnemesuser.repository

import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

@Repository
class MongoDao {

    fun likeCollection(mongoTemplate: MongoOperations, likedCollectionId:String, userEmail:String):Boolean{
        val update = Update()
        update.addToSet("likedCollection", likedCollectionId)
        val criteria = Criteria.where("email").`is`(userEmail)
        val updateFirst = mongoTemplate.updateFirst(Query.query(criteria), update, "GnemesUser")
        return updateFirst.modifiedCount>0
    }
    fun saveCollection(mongoTemplate: MongoOperations, savedCollection:String, userEmail:String):Boolean{
        val update = Update()
        update.addToSet("savedCollection", savedCollection)
        val criteria = Criteria.where("email").`is`(userEmail)
        val updateFirst = mongoTemplate.updateFirst(Query.query(criteria), update, "GnemesUser")
        return updateFirst.modifiedCount>0
    }
}