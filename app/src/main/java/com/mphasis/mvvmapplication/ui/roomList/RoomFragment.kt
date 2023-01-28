package com.mphasis.mvvmapplication.ui.roomList
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mphasis.mvvmapplication.R
import com.mphasis.mvvmapplication.domain.data.DataState
import com.mphasis.mvvmapplication.domain.data.ProgressBarState
import com.mphasis.mvvmapplication.ui.UICommunicationListener
import kotlinx.android.synthetic.main.room_fragment.*

class RoomFragment : Fragment(R.layout.room_fragment) {
    lateinit var uiCommunicationListener: UICommunicationListener
    private val viewModel: RoomViewModel by activityViewModels()
    companion object {
        val TAG: String = RoomFragment::class.java.simpleName
        fun newInstance() = RoomFragment()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            uiCommunicationListener = context as UICommunicationListener
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement UICommunicationListener" )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, androidx.lifecycle.Observer { dataState->
            when(dataState){
                is DataState.Data ->{
                    txt_output.text =dataState.data.toString()
                }
                is DataState.Loading ->{
                    when(dataState.progressBarState){
                        is ProgressBarState.Idle ->{uiCommunicationListener.displayProgressBar(false)}
                        is ProgressBarState.Loading ->{uiCommunicationListener.displayProgressBar(true)}
                    }
                }
                is DataState.Response ->{

                }
            }
        })
    }
}