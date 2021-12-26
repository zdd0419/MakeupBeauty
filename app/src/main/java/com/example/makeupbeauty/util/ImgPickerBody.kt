package com.example.makeupbeauty.util

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeupbeauty.R

/**
 * Created By Akshay Sharma on 20,June,2021
 * https://ak1.io
 */

fun ImgPickerBody(
    context: Context,
    adapter: RecyclerView.Adapter<ImgPickerAdapter.ViewHolder>,
    clickCallback: View.OnClickListener
): View {
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
            hint = "分享一下你的生活吧！"
            minLines = 5
            maxLines = 10
            gravity = top
            inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE
            minHeight = 500
            setSingleLine(false)
            setHorizontallyScrolling(false)
            setPadding(40,200,40,20)
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
        })
    }
}
