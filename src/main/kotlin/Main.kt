
fun main() {

    println("======================== Test 1 ========================")
    println("Check validator")
    val rules = mutableListOf(RuleUpperLower(), RuleNumSpec(),
            RuleEntropyLevel(40.0), RulePasswordLen(8),
            RuleVocabularyWords("E:\\pswd-dict.txt"))
    val validator = Validator(rules)
    validator.checkPassword("cjyb'h")
    validator.checkPassword("cjyAb'hbfB")
    validator.checkPassword("cjyb'h0brAjy")

    println("======================== Test 2 ========================")
    println("Check validator exceptions")
    try {
        val r2 = rules.map { it }.toMutableList()
        r2.add(RuleEntropyLevel(40.0))
        val validator = Validator(r2)
    }
    catch (e: ValidatorException) {
        println(e.message)
    }

    for (rule in rules) {
        try {
            validator.addRule(rule)
        }
        catch (e: ValidatorException) {
            println(e.message)
        }
    }


}