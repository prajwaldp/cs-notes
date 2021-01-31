// 792ms
class Codec {
    fun encode(strs: List<String>): String {
        return strs.size.toString() + "STRING = " + strs.map {
            it.replace("\"", "\\\"").replace(", ", "<DELIMITER>")
        }.joinToString(", ")
    }

    fun decode(s: String): List<String> {
        val split = s.split("STRING = ")
        if (split[0] == "0") return listOf<String>()

        return split[1].split(", ").map {
            it.replace("\\\"", "\"").replace("<DELIMITER>", ", ")
        }
    }
}
