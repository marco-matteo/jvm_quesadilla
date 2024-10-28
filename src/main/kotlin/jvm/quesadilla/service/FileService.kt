package jvm.quesadilla.service

import jvm.quesadilla.entity.FileEntity
import jvm.quesadilla.repository.FileRepository
import org.springframework.stereotype.Service

@Service
class FileService(val repository: FileRepository) {
    fun find(query: String): List<FileEntity> {
        return repository.findAll().filter { it.path == query }
    }
}