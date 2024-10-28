package jvm.quesadilla.entity

import org.bson.types.ObjectId

class TextFile(id: ObjectId?, path: String) : FileEntity(id, path, "TEXT")
