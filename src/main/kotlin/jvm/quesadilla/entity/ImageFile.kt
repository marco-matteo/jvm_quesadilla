package jvm.quesadilla.entity

import org.bson.types.ObjectId

class ImageFile(id: ObjectId, path: String) : FileEntity(id, path, "IMAGE")
