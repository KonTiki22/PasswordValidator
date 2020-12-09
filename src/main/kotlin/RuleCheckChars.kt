abstract class RuleCheckChars(name: String, val chars: List<String>): Rule(name) {

    override fun check(password: String): Boolean {
        return chars.all { it.any { ch -> ch in password } }
    }

    override fun equals(other: Any?): Boolean {
        if(super.equals(other)) {
            return this.chars.sorted() == (other as RuleCheckChars).chars.sorted()
        }
        return false
    }

    override fun hashCode(): Int {
        return chars.sumBy { it.hashCode() }
    }
}