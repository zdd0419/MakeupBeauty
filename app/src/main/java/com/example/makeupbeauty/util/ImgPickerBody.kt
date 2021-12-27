package com.example.makeupbeauty.util

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita
import com.example.makeupbeauty.ui.MainActivity
import com.example.makeupbeauty.viewModel.PostViewModel

/**
 * Created By Akshay Sharma on 20,June,2021
 * https://ak1.io
 */

fun ImgPickerBody(
    context: Context,
    adapter: RecyclerView.Adapter<ImgPickerAdapter.ViewHolder>,
    clickCallback: View.OnClickListener
): View {
    var editContentId = 0
    var editTitleId = 0
    var recycleViewId = 0
    val layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        this.gravity = Gravity.RIGHT or Gravity.BOTTOM
    }
    return LinearLayout(context).apply {
        orientation = LinearLayout.VERTICAL
        this.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        gravity = Gravity.CENTER
        addView(EditText(context).apply {
            this.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            id = View.generateViewId()
            editTitleId = id

            hint = "帖子标题"
            maxLines = 1
            gravity = top
            minHeight = 100
            setPadding(40,100,40,20)
            background = null
            textSize = 20F
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                textCursorDrawable = ColorDrawable(Color(0xFFec8aa4).toArgb())
            }
        })
        addView(EditText(context).apply {
            this.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            id = View.generateViewId()
            editContentId = id

            hint = "分享一下你的生活吧！"
            minLines = 5
            maxLines = 10
            gravity = top
            inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE
            minHeight = 500
            setSingleLine(false)
            setHorizontallyScrolling(false)
            setPadding(40,100,40,20)
            background = null
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                textCursorDrawable = ColorDrawable(Color(0xFFec8aa4).toArgb())
            }
        })

        addView(LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            this.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1F,
            )
            addView(RecyclerView(context).apply {
                layoutManager = GridLayoutManager(context, 3)
                setPadding(0, 20, 0, 0)
                this.layoutParams = RecyclerView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                )
                id = View.generateViewId()
                recycleViewId = id

                this.adapter = adapter
                minimumHeight = 300
            })
        })

        addView(Button(context).apply {
           this.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,

            ).apply {
            CornerRadius(100F,100F)

//            setMargins(32, 32, 32, 32)
//                this.gravity = Gravity.RIGHT or Gravity.BOTTOM
            }
            gravity = Gravity.CENTER
            text = "发布"

            background = ColorDrawable(Color(0xFFec8aa4).toArgb())
            setTextColor(Color.White.toArgb())
            setOnClickListener {
                val parentView = parent as View
                val title = parentView.findViewById<EditText>(editTitleId).text.toString()
                val content = parentView.findViewById<EditText>(editContentId).text.toString()
                val list = (parentView.findViewById<RecyclerView>(recycleViewId).adapter as ImgPickerAdapter).list
                val uri_list = ArrayList<String>()
                for (item in list) {
                    uri_list.add(item.toString())
                }
                val postViewModel = com.androidisland.vita.Vita.vita.with(VitaOwner.None).getViewModel<PostViewModel>()
                postViewModel.addPost(
                    title,
                    content,
                    uri_list
                )
                val intent = Intent(getContext(), MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("page", "community")
                Toast.makeText(getContext(), "发布成功", Toast.LENGTH_SHORT).show()
                startActivity(getContext(), intent, null)
//                parentView.
            }
        })
    }
}
