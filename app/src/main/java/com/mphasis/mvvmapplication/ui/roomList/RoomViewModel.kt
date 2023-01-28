package com.mphasis.mvvmapplication.ui.roomList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mphasis.mvvmapplication.domain.data.DataState
import com.mphasis.mvvmapplication.repository.GetRoomDetails
import com.mphasis.mvvmapplication.ui.data.DataManager
import com.vm.smacompose.domain.model.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RoomViewModel
@Inject
constructor(
    private val getRoomDetails: GetRoomDetails,
    private val dataManager: DataManager
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Room>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Room>>>
        get() = _dataState

    init {
        setStateEvent(RoomStateEvent.GetRoomEvent)
    }

    fun setStateEvent(roomStateEvent: RoomStateEvent) {
        when (roomStateEvent) {
            is RoomStateEvent.GetRoomEvent -> {
                viewModelScope.launch (Dispatchers.IO){
                    getRoomDetails.fetchRoomDetails()
                        .onEach {
                            _dataState.value =it
                        }.launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class RoomStateEvent {
    object GetRoomEvent : RoomStateEvent()
    object None : RoomStateEvent()
}