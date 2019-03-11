# markdownk
[![](https://jitpack.io/v/mahdi13/markdownk.svg)](https://jitpack.io/#mahdi13/markdownk)


### Dependency
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.mahdi13:markdownk:v1.4'
	}


### Showcase
This a simple markdown DSL. Here is how it works:

```kotlin
fun main() {
    print(
        document {

            h2 { "MarkdownK!" }

            cl {
                item(true) { "Easy" }
                item(true) { "Flexible" }
                item(true) { "Light" }
                item(false) { "Complicated" }
            }

            i { "Let me show you something:" }

            table {
                th { item { "Key" }; item { "Value" } }
                tr { item { "Here" }; item { "Is" } }
                tr { item { "The" }; item { "Magic!" } }
            }

        }.exportAsText()
    )

}
```

Here is the result:

```markdown
## MarkdownK!
- [x] Easy
- [x] Flexible
- [x] Light
- [ ] Complicated

*Let me show you something:*

| Key | Value |
| ----------- | ----------- |
| Here | Is |
| The | Magic! |

```

And you will see it like this:

## MarkdownK!
- [x] Easy
- [x] Flexible
- [x] Light
- [ ] Complicated

*Let me show you something:*

| Key | Value |
| ----------- | ----------- |
| Here | Is |
| The | Magic! |
