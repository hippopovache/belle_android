package com.bellemaxime.github.presentation.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bellemaxime.github.R
import com.bellemaxime.github.domain.model.UserDetail

class DetailAdapter(context: Context) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    private val userDetail: ArrayList<UserDetail> = ArrayList()

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount() = userDetail.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_user_detail, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userDetail[position])
    }

    fun setData(userDetails: List<UserDetail>?) {
        this.userDetail.clear()

        userDetails?.let {
            this.userDetail.addAll(userDetails)
            //pas sur pour listOf
        }

        notifyDataSetChanged()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nom: TextView = view.findViewById(R.id.nom_detail)
        private val description: TextView = view.findViewById(R.id.description_detail)
        private val forks: TextView = view.findViewById(R.id.forks_detail)
        private val language: TextView = view.findViewById(R.id.language_detail)
        private val license: TextView = view.findViewById(R.id.license_detail)
        private val watchers: TextView = view.findViewById(R.id.watchers_detail)


        /*init {
            view.setOnClickListener {
                listener.onSearchItemClick(userDetail[adapterPosition].id)
            }
        }*/

        fun bind(userDetail: UserDetail) {
            nom.text = userDetail.name
            if (userDetail.description !== null) {
                description.text = userDetail.description
            }
            if (userDetail.forks !== null) {
                forks.text = userDetail.forks
            }
            if (userDetail.language !== null) {
                language.text = userDetail.language
            }
            if (userDetail.license !== null) {
                license.text = userDetail.license?.name
            }
            if (userDetail.watchers !== null) {
                watchers.text = userDetail.watchers
            }
        }

    }
}