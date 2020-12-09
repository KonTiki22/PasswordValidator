import kotlin.math.log2

class RuleEntropyLevel(val thresh: Double) : Rule("Entropy level >= $thresh") {
    val chars = RuleUpperLower().chars + RuleNumSpec().chars
    override fun check(password: String): Boolean {
        var charNum = chars.filter { it.any { ch -> ch in password } }.sumBy { it.length }
        val p = 1/charNum.toDouble()
        val H = -(password.length * charNum * p * log2(p))
        return H >= thresh

    }

    override fun hashCode(): Int {
        return thresh.hashCode()
    }
}