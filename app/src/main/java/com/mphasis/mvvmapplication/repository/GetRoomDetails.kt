package com.mphasis.mvvmapplication.repository
import com.mphasis.mvvmapplication.domain.data.DataState
import com.mphasis.mvvmapplication.domain.data.ProgressBarState
import com.mphasis.mvvmapplication.network.apiservice.RoomService
import com.mphasis.mvvmapplication.network.handleUseCaseException
import com.mphasis.mvvmapplication.network.model.room.RoomDtoMapper
import com.vm.smacompose.domain.model.Room
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion

class GetRoomDetails(
    private val roomService: RoomService,
    private val roomDtoMapper: RoomDtoMapper
) {

    fun fetchRoomDetails(): Flow<DataState<List<Room>>> = flow {
            emit(DataState.Loading(progressBarState = ProgressBarState.Loading))
            delay(1000)
            var people = roomDtoMapper.toDomainList(roomService.getRooms())
            emit(DataState.Data(people))

        } .catch { e ->
            emit(handleUseCaseException(e))
        }.onCompletion {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }
}