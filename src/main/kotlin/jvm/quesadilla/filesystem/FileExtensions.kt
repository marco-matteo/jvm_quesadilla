package jvm.quesadilla.filesystem

enum class FileExtensions(val extensions: List<String>) {
    IMAGE(listOf("jpg", "jpeg", "png", "gif")),
    TEXT(listOf("txt", "md", "log")),
    CODE(listOf("c", "cpp", "java", "kt", "js", "ts", "php", "rb", "hs", "cs", "css", "html"))
}