package fr.iim.iwm.a5.mesfioui.camil.kotlin.models

import fr.iim.iwm.a5.mesfioui.camil.kotlin.ConnectionPool
import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article

class MysqlModel(url: String, user: String?, password: String?) : Model {

    val connectionPool = ConnectionPool(url, user, password)


    override fun getArticleList(): List<Article> {
        val articles = ArrayList<Article>()
        connectionPool.use { connection ->
            val stmt = connection.prepareStatement("SELECT * FROM articles")
            val results = stmt.executeQuery()

            while (results.next()) {
                articles.add(
                    Article(
                        results.getInt("id"),
                        results.getString("title")
                    )
                )
            }
        }
        return articles
    }

    override fun getArticle(id: Int): Article? {
        connectionPool.use { connection ->
            val stmt = connection.prepareStatement("SELECT * FROM articles WHERE id = ?")
            stmt.setInt(1, id)
            val results = stmt.executeQuery()
            val found = results.next()
            if (found) {
                return Article(
                    results.getInt("id"),
                    results.getString("title"),
                    results.getString("description")
                )
            }
        }
        return null
    }
}