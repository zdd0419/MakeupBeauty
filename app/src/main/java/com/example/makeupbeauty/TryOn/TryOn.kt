package com.example.makeupbeauty.TryOn

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.getOrAddAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeupbeauty.R
import com.shehuan.niv.NiceImageView
import java.util.*


class TryOn : AppCompatActivity() {

    private val lip_data = ArrayList<Pair<Int, String>>()
    private val eye_data = ArrayList<Pair<Int, String>>()
    private val brow_data = ArrayList<Pair<Int, String>>()

    // Todo: get below from intent parameters
    private var selected_lip = 2
    private var selected_eye = -1
    private var selected_brow = -1
    private var current = "LIP";

    fun goBack(view: View) {
        finish()
    }

    private fun setRecyclerView() {
        val recyclerview = findViewById<RecyclerView>(R.id.rec)
        //设置布局管理器
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview.layoutManager = linearLayoutManager
        //设置适配器
        var mAdapter = GalleryAdapter(this, lip_data)

        if (current == "LIP")
            mAdapter = GalleryAdapter(this, lip_data)
        else if (current == "EYE")
            mAdapter = GalleryAdapter(this, eye_data)
        else if (current == "BROW")
            mAdapter = GalleryAdapter(this, brow_data)

        if (current == "LIP")
            mAdapter.selected_pos = selected_lip
        else if (current == "EYE")
            mAdapter.selected_pos = selected_eye
        else if (current == "BROW")
            mAdapter.selected_pos = selected_brow

        recyclerview.adapter = mAdapter
    }

    fun lip_onClick(view: View) {
        current = "LIP"
        change_category()
    }

    fun eye_onClick(view: View) {
        current = "EYE"
        change_category()
    }

    fun brow_onClick(view: View) {
        current = "BROW"
        change_category()
    }

    private fun change_category() {
        val lip_btn = findViewById<Button>(R.id.btn_lip)
        val eye_btn = findViewById<Button>(R.id.btn_eye)
        val brow_btn = findViewById<Button>(R.id.btn_brow)

        lip_btn.setTextColor(getResources().getColor(R.color.black));
        brow_btn.setTextColor(getResources().getColor(R.color.black))
        eye_btn.setTextColor(getResources().getColor(R.color.black))

        if(current == "LIP")
            lip_btn.setTextColor(getResources().getColor(R.color.purple_500))
        if(current == "EYE")
            eye_btn.setTextColor(getResources().getColor(R.color.purple_500))
        if(current == "BROW")
            brow_btn.setTextColor(getResources().getColor(R.color.purple_500))

        setRecyclerView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_try_on)

        // Todo: Get data from api
        for (index in 1..20) {
            var item = Pair<Int, String>(R.drawable.dior1, "口红# $index")
            lip_data.add(item)
            item = Pair<Int, String>(R.drawable.dior1, "美瞳# $index")
            eye_data.add(item)
            item = Pair<Int, String>(R.drawable.dior1, "眉毛# $index")
            brow_data.add(item)
        }

        change_category()
    }

    inner class GalleryAdapter(context: Context?, data: ArrayList<Pair<Int, String>>):
        RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
        private val mInflater: LayoutInflater = LayoutInflater.from(context)
        private val mData: ArrayList<Pair<Int, String>> = data

        var selected_pos = -1

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

                if(current == "LIP")
                    selected_lip = selected_pos
                if(current == "EYE")
                    selected_eye = selected_pos
                if(current == "BROW")
                    selected_brow = selected_pos

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

        override fun onViewAttachedToWindow(viewHolder: ViewHolder) {
            super.onViewAttachedToWindow(viewHolder)
            (viewHolder.mImg as NiceImageView).isCircle(true)
            (viewHolder.mImg as NiceImageView).setCornerRadius(32)
        }

        /**
         * 设置值
         */
        override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
            viewHolder.mImg?.setImageResource(mData[i].first)
            (viewHolder.mImg as NiceImageView).isCircle(true)
            (viewHolder.mImg as NiceImageView).setCornerRadius(32)
            viewHolder.mTxt?.text = mData[i].second
            if (selected_pos == i)
                (viewHolder.mImg as NiceImageView).setBorderWidth(4)
            else
                (viewHolder.mImg as NiceImageView).setBorderWidth(0)
        }

    }
}