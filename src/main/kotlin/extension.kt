
class User {
    val name: String = "user"
    val phone: Int = 123

    fun test() {
        println()
        println(name)
    }
}

fun main() {
//    val user = User()
//    user.printAll()
    val str = "Testing"
    str.printLog()

}

fun User.printAll() {
    println(this.phone)
    println(this.name)
}

fun String.printLog(): String {
    return this.drop(1)
}
