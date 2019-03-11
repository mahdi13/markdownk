interface MDElement {
    override fun toString(): String
}

class ListItem : MDElement {
    lateinit var content: String
    override fun toString(): String = content
}

class CheckedItem(val isChecked: Boolean) : MDElement {
    lateinit var content: String
    override fun toString(): String = content
}

class OrderedList : MDElement {
    val items = ArrayList<ListItem>()
    override fun toString(): String = items.mapIndexed { i, v -> "${i + 1}. $v" }.joinToString("\n") + "\n"
}

class UnorderedList : MDElement {
    val items = ArrayList<ListItem>()
    override fun toString(): String = items.map { v -> "- $v" }.joinToString("\n") + "\n"
}

class CheckList : MDElement {
    val items = ArrayList<CheckedItem>()
    override fun toString(): String =
        items.map { v -> "- [${if (v.isChecked) "x" else " "}] $v" }.joinToString("\n") + "\n"
}

class Table : MDElement {
    var headers: TableRow = TableRow()
    val rows = ArrayList<TableRow>()
    override fun toString(): String = "\n" + headers.toString() + "\n" +
            "| ----------- ".repeat(headers.cols.size) + "|" + "\n" +
            rows.map { it.toString() }.joinToString("\n") + "\n"
}

class TableRow : MDElement {
    val cols = ArrayList<String>()
    override fun toString(): String = "| " + cols.joinToString(" | ") { it } + " |"
}

