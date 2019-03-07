package fr.iim.iwm.a5.mesfioui.camil.kotlin.models

import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article

interface Model {
    fun getArticleList(): List<Article>
    fun getArticle(id: Int): Article?
}