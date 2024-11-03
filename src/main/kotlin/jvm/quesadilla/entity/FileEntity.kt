package jvm.quesadilla.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "files")
open class FileEntity(
    @Id
    @Field("_id")
    var id: ObjectId? = null,

    @Field("path")
    @Indexed(unique = true)
    val path: String,

    @Field("type")
    var type: String = "UNKNOWN"
) {
    override fun toString(): String {
        return "FileEntity(id=$id, path='$path', type='$type')"
    }
}
