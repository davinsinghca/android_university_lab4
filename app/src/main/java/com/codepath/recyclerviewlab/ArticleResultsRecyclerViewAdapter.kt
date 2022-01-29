package com.codepath.recyclerviewlab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.recyclerviewlab.models.Article


class ArticleResultsRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val articleList: MutableList<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_article_result, parent, false)
        return ArticleViewHolder(view)
    }

    internal class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headlineView: TextView = view.findViewById(R.id.article_headline)
        val snippetView: TextView = view.findViewById(R.id.article_snippet)
        val dateView: TextView = view.findViewById(R.id.article_pub_date)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ArticleViewHolder) {
            val article: Article = articleList[position]
            holder.headlineView.text = article.headline!!.main
            holder.snippetView.text = article.snippet
            // Bonus try searching up how to format dates using SimpleDateFormat. You will need to parse the date and reformat the date
            holder.dateView.text = article.publishDate
        }
    }

    // This method clears the existing dataset and adds new articles
    fun setNewArticles(articles: List<Article>) {
        articleList.clear()
        articleList.addAll(articles)
    }

    // This method adds all articles to the existing dataset
    fun addArticles(articles: List<Article>) {
        articleList.addAll(articles)
    }

}