import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Student {

    val name: String by lazy {
        println("lazy delegate activated")
        "name"
    }

    var surname: String by NameDelegate()
    val phone = 123

    var course: String by Delegates.observable("first") {
            property, oldValue, newValue -> println("$oldValue -> $newValue" )
    }

    var age: Int by Delegates.vetoable(18) {
            property, oldValue, newValue ->  newValue > oldValue
    }
}

fun main() {
    val student = Student()
    println(student.surname)
    student.surname = "test"
    println(student.surname)
//    println(student.age)
//    student.age = 20
//    println(student.age)
//    student.age = 21
//    println(student.age)
//    student.age = 17

//    val map = mapOf("name" to "test", "phone" to "123")
//    val human = Human(map)
//    println(human.name)
//    println(human.phone)
}

val topLevelInt = 0

class ClassWithDelegate(val anotherClassInt: Int)

class MyClass(val memberInt: Int, val anotherClass: ClassWithDelegate) {
    val delegatedToMember: Int by this::memberInt
    val delegatedToAnotherClass: Int by anotherClass::anotherClassInt
    val delegateToTopLevel: Int by ::topLevelInt
}

class Human(val map: Map<String, String>) {
    val name: String by map
    val phone: String by map
}

class NameDelegate {

    private var name: String = "defaultName"

    operator fun getValue(thisRef: Student?, property: KProperty<*>): String {
        return name
    }

    operator fun setValue(thisRef: Student?, property: KProperty<*>, value: String) {
        name = value
    }
}