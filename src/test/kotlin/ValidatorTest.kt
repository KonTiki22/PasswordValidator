import org.junit.jupiter.api.*

internal class ValidatorTest {

    @Test
    fun addRulesExceptions() {

        val rules = mutableListOf(RuleUpperLower(), RuleNumSpec(),
                RuleEntropyLevel(40.0), RulePasswordLen(8),
                RuleVocabularyWords("E:\\pswd-dict.txt"))
        val validator = Validator(rules)

    }

    @Test
    fun addRule() {
    }

    @Test
    fun checkPassword() {
    }

}