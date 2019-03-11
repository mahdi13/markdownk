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
    override fun toString(): String = items.mapIndexed { i, v -> "${i + 1}. $v" }.joinToString("\n")
}

class UnorderedList : MDElement {
    val items = ArrayList<ListItem>()
    override fun toString(): String = items.map { v -> "- $v" }.joinToString("\n")
}

class CheckList : MDElement {
    val items = ArrayList<CheckedItem>()
    override fun toString(): String = items.map { v -> "- [${if (v.isChecked) "x" else " "}] $v" }.joinToString("\n")
}

class Table : MDElement {
    var headers: TableRow = TableRow()
    val rows = ArrayList<TableRow>()
    override fun toString(): String = headers.toString() + "\n" +
            "| ----------- ".repeat(headers.cols.size) + "|" + "\n" +
            rows.map { it.toString() }.joinToString("\n")
}

class TableRow : MDElement {
    val cols = ArrayList<String>()
    override fun toString(): String = "| " + cols.joinToString(" | ") { it } + " |"
}
