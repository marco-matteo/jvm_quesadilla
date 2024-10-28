package jvm.quesadilla.entity

import org.bson.types.ObjectId

class CodeFile(id: ObjectId, path: String) : FileEntity(id, path, "CODE")
