class MDDocument {
    val elements = ArrayList<MDElement>()

    fun exportAsText(): String = StringBuilder().apply {
        elements.forEach { append(it.toString()).append("\n") }
    }.toString().trimIndent()
}

