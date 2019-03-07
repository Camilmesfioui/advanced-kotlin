package fr.iim.iwm.a5.mesfioui.camil.kotlin.templates

import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article
import kotlinx.html.*

fun HTML.ArticleTemplate(article: Article) {
    head{
        title("liste des article")
    }

    body {
        p(article.title)
        p {
            a(href = "/article/") {
                +article.title
            }
        }
    }
}