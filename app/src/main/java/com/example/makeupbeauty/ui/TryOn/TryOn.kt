package com.example.makeupbeauty.TryOn

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeupbeauty.R
import com.example.makeupbeauty.ui.TryOn.FacialPart
import com.example.makeupbeauty.ui.TryOn.FacialTry
import com.google.mediapipe.components.TextureFrameConsumer
import com.google.mediapipe.framework.TextureFrame
import com.google.mediapipe.solutioncore.CameraInput
import com.google.mediapipe.solutioncore.ErrorListener
import com.google.mediapipe.solutioncore.ResultListener
import com.google.mediapipe.solutioncore.SolutionGlSurfaceView
import com.google.mediapipe.solutions.facemesh.FaceMesh
import com.google.mediapipe.solutions.facemesh.FaceMeshOptions
import com.google.mediapipe.solutions.facemesh.FaceMeshResult
import com.shehuan.niv.NiceImageView
import java.lang.Math.random
import java.lang.RuntimeException
import java.util.*


class TryOn : AppCompatActivity() {

    private val lip_data = ArrayList<FacialPart>()
    private val eye_data = ArrayList<FacialPart>()
    private val brow_data = ArrayList<FacialPart>()

    private val random = Random()
    // Todo: get below from intent parameters
    private var selected_lip = random.nextInt(5)
    private var selected_eye = -1
    private var selected_brow = -1
    private var current = "LIP";

    private val TAG = "MainActivity"
    private var facemesh: FaceMesh? = null
    // Run the pipeline and the model inference on GPU or CPU.
    private val RUN_ON_GPU = true
    // set all kinds of input
    private enum class InputSource {
        UNKNOWN, CAMERA
    }
    private var inputSource = InputSource.UNKNOWN
    // Live camera demo UI and camera components.
    private var cameraInput: CameraInput? = null
    private var glSurfaceView: SolutionGlSurfaceView<FaceMeshResult>? = null
    private var glRenderer: FacialTry? = null


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
        setupStreamingModePipeline(InputSource.CAMERA)

        lip_data.add(FacialPart(R.drawable.attention,"无试装",0f,0f,0f,0f))
        lip_data.add(FacialPart(R.drawable.dior1,"丁香淡紫",233f,215f,223f,0.5f))
        lip_data.add(FacialPart(R.drawable.dior2,"牡丹粉红",238f,162f,164f,0.5f))
        lip_data.add(FacialPart(R.drawable.dior1,"雄黄",255f,153f,0f,0.5f))
        lip_data.add(FacialPart(R.drawable.dior2,"洋水仙红",244f,199f,186f,0.5f))
        lip_data.add(FacialPart(R.drawable.dior1,"豆沙色",72f,30f,28f,0.5f))

        brow_data.add(FacialPart(R.drawable.attention,"无试装",0f,0f,0f,0f))
        brow_data.add(FacialPart(R.drawable.dior1,"长石灰",54f,52f,51f,0.05f))
        brow_data.add(FacialPart(R.drawable.dior2,"古铜褐",92f,55f,25f,0.05f))
        brow_data.add(FacialPart(R.drawable.dior1,"云杉绿",21f,35f,27f,0.05f))
        brow_data.add(FacialPart(R.drawable.dior2,"牛角灰",45f,46f,54f,0.05f))
        brow_data.add(FacialPart(R.drawable.dior1,"莽丛绿",20f,30f,27f,0.05f))

        change_category()
    }

    override fun onResume() {
        super.onResume()
        if (inputSource == InputSource.CAMERA) {
            // Restarts the camera and the opengl surface rendering.
            cameraInput = CameraInput(this)
            cameraInput!!.setNewFrameListener(TextureFrameConsumer { textureFrame: TextureFrame? ->
                facemesh!!.send(
                    textureFrame
                )
            })
            glSurfaceView!!.post { this.startCamera() }
            glSurfaceView!!.setVisibility(View.VISIBLE)
        }
    }

    override fun onPause() {
        super.onPause()
        glSurfaceView!!.setVisibility(View.GONE)
        cameraInput!!.close()
    }

    private fun startCamera() {
        cameraInput!!.start(
            this,
            facemesh!!.glContext,
            CameraInput.CameraFacing.FRONT,
            glSurfaceView!!.width,
            glSurfaceView!!.height
        )
    }

    private fun stopCurrentPipeline() {
        if (cameraInput != null) {
            cameraInput!!.setNewFrameListener(null)
            cameraInput!!.close()
        }
        if (glSurfaceView != null) {
            glSurfaceView!!.visibility = View.GONE
        }
        if (facemesh != null) {
            facemesh!!.close()
        }
    }

    inner class GalleryAdapter(context: Context?, data: ArrayList<FacialPart>):
        RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
        private val mInflater: LayoutInflater = LayoutInflater.from(context)
        private val mData: ArrayList<FacialPart> = data

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

        /**
         * 设置值
         */
        override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
            viewHolder.mImg?.setImageResource(mData[i].id)
            (viewHolder.mImg as NiceImageView).isCircle(true)
            (viewHolder.mImg as NiceImageView).setCornerRadius(32)
            viewHolder.mTxt?.text = mData[i].name
            if (selected_pos == i){
                if(current == "LIP"){
                    if(i == 0){
                        glRenderer?.setPutLip(false);
                    }else{
                        glRenderer?.setPutLip(true);
                        glRenderer?.setLipsColor(mData[i].red,mData[i].blue,mData[i].green,mData[i].alpha)
                    }
                }else if(current == "BROW"){
                    if(i == 0){
                        glRenderer?.setPutBrow(false);
                    }else{
                        glRenderer?.setPutBrow(true);
                        glRenderer?.setBrowsColor(mData[i].red,mData[i].blue,mData[i].green,mData[i].alpha)
                    }
                }
                (viewHolder.mImg as NiceImageView).setBorderWidth(4)
            }else
                (viewHolder.mImg as NiceImageView).setBorderWidth(0)
        }

    }

    private fun setupStreamingModePipeline(inputSource: InputSource) {
        this.inputSource = inputSource
        // Initializes a new MediaPipe Face Mesh solution instance in the streaming mode.
        facemesh = FaceMesh(
            this,
            FaceMeshOptions.builder()
                .setStaticImageMode(false)
                .setRefineLandmarks(true)
                .setRunOnGpu(RUN_ON_GPU)
                .build()
        )
        facemesh!!.setErrorListener(ErrorListener { message: String, e: RuntimeException? ->
            Log.e(
                TAG,
                "MediaPipe Face Mesh error:$message"
            )
        })
        if (inputSource == InputSource.CAMERA) {
            cameraInput = CameraInput(this)
            cameraInput!!.setNewFrameListener { textureFrame: TextureFrame? ->
                facemesh!!.send(
                    textureFrame
                )
            }
        }

        // Initializes a new Gl surface view with a user-defined FaceMeshResultGlRenderer.
        glSurfaceView =
            SolutionGlSurfaceView(this, facemesh!!.getGlContext(), facemesh!!.getGlMajorVersion())
        glRenderer = FacialTry(this)
        glSurfaceView!!.setSolutionResultRenderer(glRenderer)
        glSurfaceView!!.setRenderInputImage(true)
        facemesh!!.setResultListener(ResultListener { result ->
            glSurfaceView!!.setRenderData(result)
            glSurfaceView!!.requestRender()
        })

        // The runnable to start camera after the gl surface view is attached.
        // For video input source, videoInput.start() will be called when the video uri is available.
        if (inputSource == InputSource.CAMERA) {
            glSurfaceView!!.post(Runnable { this.startCamera() })
        }

        // Updates the preview layout.

        // Updates the preview layout.
        val frameLayout = findViewById<FrameLayout>(R.id.camera_layout)
        frameLayout.removeAllViewsInLayout()
        frameLayout.addView(glSurfaceView)
        glSurfaceView!!.visibility = View.VISIBLE
//        frameLayout.requestLayout()
    }
}