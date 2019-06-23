package id.erwinka.madesubmission2.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.erwinka.madesubmission2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.inflater_film.view.*

class FilmAdapter(
    private val context: Context,
    private val data: MutableList<FilmModel>,
    private val onClickListener: (FilmModel) -> Unit
) :
    RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(
                context
            ).inflate(R.layout.inflater_film, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(context, data[position], onClickListener)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(
            context: Context,
            data: FilmModel,
            onClickListener: (FilmModel) -> Unit
        ) {
            itemView.tv_film_title.text = data.title
            Glide.with(context).load(data.poster).into(itemView.iv_film_poster)
            containerView.setOnClickListener { onClickListener(data) }
        }
    }

}