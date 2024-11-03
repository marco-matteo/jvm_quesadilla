package jvm.quesadilla.controller

import jvm.quesadilla.entity.FileEntity
import jvm.quesadilla.filesystem.FileSystemReader
import jvm.quesadilla.service.CacheService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.Charset
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@RestController
@RequestMapping("/cache")
class CacheController(private val service: CacheService) {
    @OptIn(ExperimentalEncodingApi::class)
    @PutMapping("/update/{dirBase64}")
    fun update(@PathVariable dirBase64: String): MutableList<FileEntity> {
        val dir = Base64.decode(dirBase64).toString(Charset.defaultCharset())
        println(dir)
        return service.updateCache(dir)
    }
}
