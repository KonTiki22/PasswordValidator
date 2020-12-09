class ValidatorException(message: String): Exception(message)

class Validator() {
    var rules: MutableList<Rule> = mutableListOf()
    constructor(rules_list: MutableList<Rule>): this() {
        if(rules_list.groupingBy { it }.eachCount().any { it.value > 1 }) {
            throw ValidatorException("Your validator it can't contain two identical rules.")
        }
        rules = (rules + rules_list).toMutableList()
    }
    fun addRule(rule: Rule) {
        if(!rules.any { it == rule}) rules.add(rule)
        else throw ValidatorException("Your validator can't contain two identical rules.")
    }
    fun checkPassword(password: String): Int {
        if(rules.isEmpty()) throw ValidatorException("Your validator contains no rules for password validation.")
        var count = 0
        println("\nCheck password \"$password\" by validator:")
        for(rule in rules) {
            if (rule.check(password)) {
                println("Password \"${password}\" passes the rule \"${rule.name}\".")
                count += 1
            }
            else {
                println("Password \"${password}\" doesn't pass the rule \"${rule.name}\".")
            }
        }
        if(count == rules.size) println("Password \"${password}\" passes ${if(count == 1) "rule" else "all rules"}.")
        else println("Password \"${password}\" passes ${count} ${if(count == 1) "rule" else "rules"} out of ${rules.size}.")
        return count
    }
}