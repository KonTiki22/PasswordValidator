import java.io.File

class RuleVocabularyWords(val path: String) : Rule("Lack of vocabulary words from \"$path\"") {
    override fun check(password: String): Boolean {
        return !File(path).readLines().any { it == password }
    }

    override fun equals(other: Any?): Boolean {
        if(super.equals(other)) {
            if(this.path == (other as RuleVocabularyWords).path) return true
            return File(this.path).readLines() == File(other.path).readLines()
        }
        return false
    }

    override fun hashCode(): Int {
        return File(path).readLines().sumBy { it.hashCode() }
    }
}