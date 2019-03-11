@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class ContextDsl

@ContextDsl
fun document(builder: MDDocument.() -> Unit) = MDDocument().apply(builder)

@ContextDsl
fun MDDocument.b(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "**$content**"
        }
    )
}

@ContextDsl
fun MDDocument.i(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "*$content*"
        }
    )
}

@ContextDsl
fun MDDocument.h1(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "# $content"
        }
    )
}

@ContextDsl
fun MDDocument.h2(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "## $content"
        }
    )
}

@ContextDsl
fun MDDocument.h3(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "### $content"
        }
    )
}

@ContextDsl
fun MDDocument.code(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "`$content`"
        }
    )
}


@ContextDsl
fun MDDocument.codeBlock(language: String = "", builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "```$language\n$content\n```"
        }
    )
}

@ContextDsl
fun MDDocument.link(link: String = "", builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "[$content]($link)"
        }
    )
}

@ContextDsl
fun MDDocument.image(link: String = "", builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "![$content]($link)"
        }
    )
}

@ContextDsl
fun MDDocument.hr() {
    elements.add(
        object : MDElement {
            override fun toString(): String = "---"
        }
    )
}

@ContextDsl
fun MDDocument.br() {
    elements.add(
        object : MDElement {
            override fun toString(): String = "\n"
        }
    )
}

@ContextDsl
fun TableRow.item(builder: TableRow.() -> String) = cols.add(builder.invoke(this))

@ContextDsl
fun OrderedList.item(builder: ListItem.() -> String) = items.add(ListItem().apply { content = builder.invoke(this) })

@ContextDsl
fun UnorderedList.item(builder: ListItem.() -> String) = items.add(ListItem().apply { content = builder.invoke(this) })

@ContextDsl
fun CheckList.item(isChecked: Boolean = false, builder: CheckedItem.() -> String) =
    items.add(CheckedItem(isChecked).apply { content = builder.invoke(this) })

@ContextDsl
fun MDDocument.ol(builder: OrderedList.() -> Unit) = elements.add(OrderedList().apply(builder))

@ContextDsl
fun MDDocument.ul(builder: UnorderedList.() -> Unit) = elements.add(UnorderedList().apply(builder))

@ContextDsl
fun MDDocument.cl(builder: CheckList.() -> Unit) = elements.add(CheckList().apply(builder))

@ContextDsl
fun MDDocument.table(builder: Table.() -> Unit) = elements.add(Table().apply(builder))

@ContextDsl
fun Table.th(builder: TableRow.() -> Unit) {
    this.headers = TableRow().apply(builder)
}

@ContextDsl
fun Table.tr(builder: TableRow.() -> Unit) {
    this.rows.add(TableRow().apply(builder))
}
