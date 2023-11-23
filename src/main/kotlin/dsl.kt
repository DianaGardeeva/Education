fun main() {
//    Point(1,2)
//
//    val map = mutableMapOf<String, Int>()
//
//    val (x, y) = Point(0, 1)
//
//    println(x)
//    println(y)

    page {
        waitForLoad()
        field(".//div") {
            page {
                //ошибка компиляции, запрет на внешний контекст.
            }
            field("test") {

            }
            typeText("test")
            click()
        }
    }
}

object page {

    operator fun invoke(init: Page.() -> Unit) = Page().init()

}

@PageContext
class Page {
    fun waitForLoad() {
        println("wait for page to load")
    }

    fun field(locator: String, action: Field.() -> Unit): Field {
        val field = Field(locator)
        field.apply(action)
        return field
    }
}

@FieldContext
class Field(locator: String) {

    fun typeText(text: String) {

    }

    fun click() {
    }
}

@DslMarker
annotation class PageContext

@DslMarker
annotation class FieldContext
