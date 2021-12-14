package com.example.makeupbeauty.TryOn

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeupbeauty.R
import com.shehuan.niv.NiceImageView
import java.util.*


/**
 * Created by ivan on 2017/6/9.
 */
class TryOn : AppCompatActivity() {

    private val data = ArrayList<Pair<Int, String>>()

    fun goBack(view: View) {
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_try_on)

        // Todo: Get data from api
        for (index in 1..20) {
            val item = Pair<Int, String>(R.drawable.dior1, "口红# $index")
            data.add(item)
        }

        //得到控件
        val recyclerview = findViewById<RecyclerView>(R.id.rec)
        //设置布局管理器
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview.layoutManager = linearLayoutManager
        //设置适配器
        val mAdapter = GalleryAdapter(this, data)
        recyclerview.adapter = mAdapter
    }

    inner class GalleryAdapter(context: Context?, data: ArrayList<Pair<Int, String>>):
        RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
        private val mInflater: LayoutInflater = LayoutInflater.from(context)
        private val mData: ArrayList<Pair<Int, String>> = data

        // Todo: get default selection from parameter
        private var selected_pos = 8

        inner class ViewHolder(arg0: View?) : RecyclerView.ViewHolder(arg0!!), View.OnClickListener
        {
            var mImg: ImageView? = null
            var mTxt: TextView? = null

            override fun onClick(p0: View?) {
                if (adapterPosition == RecyclerView.NO_POSITION)
                    return;
                // Updating old as well as new positions
                notifyItemChanged(selected_pos);
                selected_pos = adapterPosition;
                notifyItemChanged(selected_pos);
            }
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        /**
         * 创建ViewHolder
         */
        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
            val view: View = mInflater.inflate(
                R.layout.activity_try_on_recycler_view_item,
                viewGroup, false
            )
            val viewHolder = ViewHolder(view)
            view.setOnClickListener(viewHolder)
            viewHolder.mImg = view.findViewById<NiceImageView>(R.id.try_on_item_img)
            viewHolder.mTxt = view.findViewById<TextView>(R.id.try_on_item_txt)
            return viewHolder
        }



        /**
         * 设置值
         */
        override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
            viewHolder.mImg?.setImageResource(data[i].first)
            (viewHolder.mImg as NiceImageView).isCircle(true)
            (viewHolder.mImg as NiceImageView).setCornerRadius(32)
            viewHolder.mTxt?.text = data[i].second
            if (selected_pos == i)
                (viewHolder.mImg as NiceImageView).setBorderWidth(4)
            else
                (viewHolder.mImg as NiceImageView).setBorderWidth(0)
        }

    }
}