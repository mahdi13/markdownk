package com.perfect.markdownk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DslTest {

    @Test
    fun `Test simple text`() {
        assertEquals(
            "Hi" +
                    "Baby",
            document {
                t { "Hi" }
                t { "Baby" }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Bold-Italic element`() {
        assertEquals(
            "**Hi!**",
            document {
                b { "Hi!" }
            }.exportAsText()
        )
        assertEquals(
            "*Hi!*",
            document {
                i { "Hi!" }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Header element`() {
        assertEquals(
            "# Hi!",
            document {
                h1 { "Hi!" }
            }.exportAsText()
        )
        assertEquals(
            "## Hi!",
            document {
                h2 { "Hi!" }
            }.exportAsText()
        )
        assertEquals(
            "### Hi!",
            document {
                h3 { "Hi!" }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Code element`() {
        assertEquals(
            "`print(Hello World!)`",
            document {
                code { "print(Hello World!)" }
            }.exportAsText()
        )
    }

    @Test
    fun `Test CodeBlock element`() {
        assertEquals(
            """
                ```python
                print(Hello World!)
                ```
            """.trimIndent(),
            document {
                codeBlock("python") { "print(Hello World!)" }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Rule element`() {
        assertEquals(
            "---".trimIndent(),
            document {
                hr()
            }.exportAsText()
        )
    }

    @Test
    fun `Test Image element`() {
        assertEquals(
            "![alt text](com.perfect.markdownk.image.jpg)".trimIndent(),
            document {
                image("com.perfect.markdownk.image.jpg") {
                    "alt text"
                }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Link element`() {
        assertEquals(
            "[title](https://www.example.com)".trimIndent(),
            document {
                link("https://www.example.com") {
                    "title"
                }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Ordered List`() {
        assertEquals(
            """
                1. one
                2. and two
            """.trimIndent(),
            document {
                ol {
                    item { "one" }
                    item { "and two" }
                }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Unordered List`() {
        assertEquals(
            """
                - one
                - and two
            """.trimIndent(),
            document {
                ul {
                    item { "one" }
                    item { "and two" }
                }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Check List`() {
        assertEquals(
            """
                - [x] done
                - [ ] not done
            """.trimIndent(),
            document {
                cl {
                    item(true) { "done" }
                    item(false) { "not done" }
                }
            }.exportAsText()
        )
    }

    @Test
    fun `Test Table`() {
        assertEquals(
            """
                | Syntax | Description |
                | ----------- | ----------- |
                | Header | Title |
                | Paragraph | Text |
            """.trimIndent(),
            document {
                table {
                    th { item { "Syntax" }; item { "Description" } }
                    tr { item { "Header" }; item { "Title" } }
                    tr { item { "Paragraph" }; item { "Text" } }
                }
            }.exportAsText()
        )
    }

}