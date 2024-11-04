package jvm.quesadilla.service

import jvm.quesadilla.entity.FileEntity
import jvm.quesadilla.repository.FileRepository
import jvm.quesadilla.search.Search
import org.springframework.stereotype.Service

@Service
class FileService(val repository: FileRepository) {
    fun find(query: String): List<FileEntity> {
        return Search.searchFile(query, repository.findAll())
    }
}