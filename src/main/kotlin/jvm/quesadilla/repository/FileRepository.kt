package jvm.quesadilla.repository

import jvm.quesadilla.entity.FileEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository : MongoRepository<FileEntity, String>