package jvm.quesadilla.controller

import jvm.quesadilla.entity.FileEntity
import jvm.quesadilla.service.FileService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/file")
class FileController(val service: FileService) {
    @GetMapping("/{query}")
    fun find(@PathVariable query: String): List<FileEntity> {
        return service.find(query)
    }
}