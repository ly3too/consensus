package cn.ly3too.consensus.base

// config apis
trait Config {
    def getInt(string: String): Int
    def getConfig(string: String): Config
    def getString(string: String): String
    def getBoolean(string: String): Boolean
    def getDouble(string: String): Double
    def getList(string: String): List[AnyRef]
}
