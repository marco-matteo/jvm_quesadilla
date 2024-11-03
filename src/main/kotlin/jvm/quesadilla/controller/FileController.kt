package jvm.quesadilla.controller

import jvm.quesadilla.entity.FileEntity
import jvm.quesadilla.service.FileService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.Charset
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@RestController
@RequestMapping("/file")
class FileController(val service: FileService) {
    @OptIn(ExperimentalEncodingApi::class)
    @GetMapping("/{queryBase64}")
    fun find(@PathVariable queryBase64: String): List<FileEntity> {
        val query = Base64.decode(queryBase64).toString(Charset.defaultCharset())
        return service.find(query)
    }
}