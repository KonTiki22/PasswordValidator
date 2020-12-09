class RuleNumSpec: RuleCheckChars("Presence of numbers and special characters",
        listOf(('0'..'9').joinToString(""), " !\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~")) {
}