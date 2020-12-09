class RuleException(message: String): Exception(message)

abstract class Rule(val name: String) {

    abstract fun check(password: String): Boolean

    override fun equals(other: Any?): Boolean {
        if(other is Rule) {
            return this::class == other!!::class
        }
        return false
    }

    abstract override fun hashCode(): Int
}