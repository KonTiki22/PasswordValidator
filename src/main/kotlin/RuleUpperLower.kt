class RuleUpperLower: RuleCheckChars("Presence of lower and upper case characters",
        listOf(('a'..'z').joinToString(""), ('A'..'Z').joinToString(""))) {
}