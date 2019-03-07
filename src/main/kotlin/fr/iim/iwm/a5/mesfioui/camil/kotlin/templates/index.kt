package fr.iim.iwm.a5.mesfioui.camil.kotlin.templates

import fr.iim.iwm.a5.mesfioui.camil.kotlin.data.Article
import kotlinx.html.*

fun HTML.indexTemplate(articles: List<Article>) {
    head{
        title("liste des article")
    }

    body {
        articles.forEach{
            p {
                a(href = "/article/${it.id}") {
                    +it.title
                }
            }
        }
    }
}