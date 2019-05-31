package ayds.ak3.discogs

class Album(var text: String?, var path: String?) {

    fun hasPathAndText(): Boolean {
        return path != null && text != null
    }
}