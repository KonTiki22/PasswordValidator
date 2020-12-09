class RulePasswordLen(val len: Int) : Rule("Password length >= $len") {
    override fun check(password: String): Boolean {
        return password.length >= len
    }

    override fun equals(other: Any?): Boolean {
        if(super.equals(other)) {
            return this.len == (other as RulePasswordLen).len
        }
        return false
    }

    override fun hashCode(): Int {
        return len.hashCode()
    }
}