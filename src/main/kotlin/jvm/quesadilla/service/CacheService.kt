package jvm.quesadilla.service

import jvm.quesadilla.entity.FileEntity
import jvm.quesadilla.filesystem.FileSystemReader
import jvm.quesadilla.repository.FileRepository
import org.springframework.stereotype.Service

@Service
class CacheService(val repository: FileRepository) {
    fun updateCache(baseDir: String): MutableList<FileEntity> {
        val files = FileSystemReader.getFiles(baseDir)
        repository.deleteAll()
        return repository.insert(files)
    }
}
