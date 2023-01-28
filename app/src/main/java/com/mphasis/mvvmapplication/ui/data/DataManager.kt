package com.mphasis.mvvmapplication.ui.data
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class DataManager
@Inject
constructor() {
    private val TAG: String = "DataManager"
    val state: MutableLiveData<DataState> = MutableLiveData(DataState())
    fun onTriggerEvent(event: DataEvent) {
        when (event) {
            is DataEvent.Login -> {
                login(event.authToken)
            }
        }
    }
    private fun login(authtoken: String) {
        state.value?.let { state ->
            this.state.value = state.copy(authtoken = authtoken)
        }
    }
}