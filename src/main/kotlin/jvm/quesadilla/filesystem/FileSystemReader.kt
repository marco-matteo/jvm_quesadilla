package jvm.quesadilla.filesystem

import jvm.quesadilla.entity.CodeFile
import jvm.quesadilla.entity.FileEntity
import jvm.quesadilla.entity.ImageFile
import jvm.quesadilla.entity.TextFile
import java.io.File

object FileSystemReader {
    fun getFiles(baseDir: String): List<FileEntity> {
        val baseFile = File(baseDir).canonicalFile

        if (!baseFile.exists()) throw InvalidPathException("Base Directory does not exist")

        return baseFile.walkTopDown().filter { it.isFile }.map { file -> when (file.extension) {
            in FileExtensions.CODE.extensions ->
                CodeFile(null, file.path)

            in FileExtensions.TEXT.extensions ->
                TextFile(null, file.path)

            in FileExtensions.IMAGE.extensions ->
                ImageFile(null, file.path)

            else ->
                FileEntity(null, file.path)
        }
        }.toList()
    }
}
