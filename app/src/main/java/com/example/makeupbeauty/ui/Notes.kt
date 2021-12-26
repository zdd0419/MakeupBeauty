package com.example.makeupbeauty.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.ak1.pix.helpers.*
import io.ak1.pix.*
import com.example.makeupbeauty.R
import io.ak1.pix.adapters.InstantImageAdapter
import io.ak1.pix.models.Flash
import io.ak1.pix.models.Mode
import io.ak1.pix.models.Options
import io.ak1.pix.models.Ratio
import com.example.makeupbeauty.util.ImgPickerAdapter
import com.example.makeupbeauty.util.ImgPickerBody

/**
 * Created By Akshay Sharma on 20,June,2021
 * https://ak1.io
 */

class Notes : AppCompatActivity() {

    private val resultsFragment = ResultsFragment {
        showCameraFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        setupScreen()
        supportActionBar?.hide()
        showResultsFragment()
    }

    private fun showCameraFragment() {
        val options = Options().apply{
            ratio = Ratio.RATIO_AUTO                                    //Image/video capture ratio
            count = 100                                                  //Number of images to restrict selection count
            spanCount = 4                                               //Number for columns in grid
            path = "Pix/Camera"                                         //Custom Path For media Storage
            isFrontFacing = false                                       //Front Facing camera on start
            videoDurationLimitInSeconds = 10                            //Duration for video recording
            mode = Mode.All                                             //Option to select only pictures or videos or both
            flash = Flash.Auto                                          //Option to select flash type
            preSelectedUrls = ArrayList<Uri>()                          //Pre selected Image Urls
        }

        addPixToActivity(R.id.container, options) {
            when (it.status) {
                PixEventCallback.Status.SUCCESS -> {
                    showResultsFragment()
                    it.data.forEach {
                        Log.e(TAG, "showCameraFragment: ${it.path}")
                    }
                    resultsFragment.setList(it.data)
                }
                PixEventCallback.Status.BACK_PRESSED -> {
                    supportFragmentManager.popBackStack()
                }
            }

        }
    }

    private fun showResultsFragment() {
        showStatusBar()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, resultsFragment).commit()
    }

    class ResultsFragment(private val clickCallback: View.OnClickListener) : Fragment() {
        private val customAdapter = ImgPickerAdapter()
        fun setList(list: List<Uri>) {
            customAdapter.apply {
                this.list.clear()
                this.list.addAll(list)
                notifyDataSetChanged()
            }
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = ImgPickerBody(requireActivity(), customAdapter, clickCallback)
    }
}