package com.mvistudy.ui.cognizant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*

import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.mvistudy.R
import com.mvistudy.models.CognizantPost
import com.mvistudy.utils.GenericViewHolder
import kotlinx.android.synthetic.main.layout_cogzi_list_item.view.*

class CognizantListAdapter(private val requestManager: RequestManager,private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = "CognizantListAdapter"
    private val NO_MORE_RESULTS = -1
    private val BLOG_ITEM = 0
    private val NO_MORE_RESULTS_BLOG_MARKER = CognizantPost(
        NO_MORE_RESULTS,
        "" ,
        "",
        ""
    )

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CognizantPost>() {

        override fun areItemsTheSame(oldItem: CognizantPost, newItem: CognizantPost): Boolean {
            return oldItem.pk == newItem.pk
        }

        override fun areContentsTheSame(oldItem: CognizantPost, newItem: CognizantPost): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(CognizantRecyclerChangeCallback(this),
        AsyncDifferConfig.Builder(DIFF_CALLBACK).build())


    override fun getItemViewType(position: Int): Int {
        if(differ.currentList.get(position).pk > -1){
            return BLOG_ITEM
        }
        return differ.currentList.get(position).pk
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){

            NO_MORE_RESULTS ->{
                Log.e(TAG, "onCreateViewHolder: No more results...")
                return GenericViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.layout_nomore_item,
                        parent,
                        false
                    )
                )
            }

            BLOG_ITEM ->{
                return CognizantViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_cogzi_list_item, parent, false),
                    interaction = interaction,
                    requestManager = requestManager
                )
            }
            else -> {
                return CognizantViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.layout_cogzi_list_item, parent, false),
                    interaction = interaction,
                    requestManager = requestManager
                )
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CognizantViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(blogList: List<CognizantPost>?, isQueryExhausted: Boolean){
        val newList = blogList?.toMutableList()
        if (isQueryExhausted)
            newList?.add(NO_MORE_RESULTS_BLOG_MARKER)
        differ.submitList(newList)
    }

    class CognizantViewHolder
    constructor(
        itemView: View,
        val requestManager: RequestManager,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: CognizantPost) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            requestManager
                .load(item.imageHref)
                .transition(withCrossFade())
                .into(itemView.img_post)
            itemView.tv_title.text = item.title
            itemView.tv_des.text = item.description
        }
    }

    internal inner class CognizantRecyclerChangeCallback(
        private val adapter: CognizantListAdapter
    ) : ListUpdateCallback {

        override fun onChanged(position: Int, count: Int, payload: Any?) {
            adapter.notifyItemRangeChanged(position, count, payload)
        }

        override fun onInserted(position: Int, count: Int) {
            adapter.notifyItemRangeChanged(position, count)
        }

        override fun onMoved(fromPosition: Int, toPosition: Int) {
            adapter.notifyDataSetChanged()
        }

        override fun onRemoved(position: Int, count: Int) {
            adapter.notifyDataSetChanged()
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: CognizantPost)
    }
}