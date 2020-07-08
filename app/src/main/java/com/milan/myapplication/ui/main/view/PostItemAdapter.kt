package com.milan.myapplication.ui.main.view

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.milan.myapplication.R
import com.milan.myapplication.listner.OnRVItemClickListener
import com.milan.myapplication.model.PostModel
import com.milan.myapplication.network.AppUrls
import com.milan.myapplication.ui.main.model.PostRespoItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.raw_post_item.view.*
import java.io.File

class PostItemAdapter(
    val mContext: Context,
    val postList: ArrayList<PostRespoItem>,
    val onRvItemClick: OnRVItemClickListener
) : RecyclerView.Adapter<PostItemAdapter.PostItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.raw_post_item, parent, false)
        return PostItemViewHolder(
            view,
            onRvItemClick
        )
    }

    override fun getItemCount() = postList.size


    fun clear() {
        postList.clear()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        val postModel = postList[position]
        holder.atvUserName.text = postModel.title
        holder.atvPostDate.text = postModel.createDt
        holder.atvHeartCount.text = postModel.userId
        holder.atvCommentCount.text = postModel.id
        holder.atvShareCount.text = postModel.trend
        holder.aimgHeart.setColorFilter(
            if (postModel.isActive.equals("1")) ContextCompat.getColor(
                mContext,
                R.color.red
            ) else ContextCompat.getColor(mContext, R.color.black)
        )
        if (!postModel.image.isBlank()) {
            Picasso.get().load(AppUrls.BASE_URL + postModel.image)
                .placeholder(R.drawable.placeholder).error(R.drawable.placeholder)
                .into(holder.aimgPostImage)
        } else {
            holder.aimgPostImage.setImageResource(R.drawable.placeholder)
        }
    }


    class PostItemViewHolder(itemView: View, onRvItemClick: OnRVItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val onRVItemClickListener = onRvItemClick
        val aimgUserAvatar: AppCompatImageView = itemView.aimgUserAvatar
        val aimgPostImage: AppCompatImageView = itemView.aimgPostImage
        val atvUserName: AppCompatTextView = itemView.atvUserName
        val atvPostDate: AppCompatTextView = itemView.atvPostDate
        val aimgMore: AppCompatImageView = itemView.aimgMore
        val aimgHeart: AppCompatImageView = itemView.aimgHeart
        val llHeart: LinearLayout = itemView.llHeart
        val atvHeartCount: AppCompatTextView = itemView.atvHeartCount
        val llComment: LinearLayout = itemView.llComment
        val aimgComment: AppCompatImageView = itemView.aimgComment
        val atvCommentCount: AppCompatTextView = itemView.atvCommentCount
        val llShare: LinearLayout = itemView.llShare
        val aimgShare: AppCompatImageView = itemView.aimgShare
        val atvShareCount: AppCompatTextView = itemView.atvShareCount

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view != null) {
                onRVItemClickListener.onItemClick(view, adapterPosition)
            }
        }
    }
}