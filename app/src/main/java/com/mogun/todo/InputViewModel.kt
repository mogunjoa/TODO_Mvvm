package com.mogun.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mogun.todo.model.ContentEntity
import com.mogun.todo.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {

    private val _doneEvent = MutableLiveData<Unit>()
    val doneEvent: LiveData<Unit> = _doneEvent

    var content = MutableLiveData<String>()
    var memo = MutableLiveData<String?>()
    var item: ContentEntity? = null

    fun initData(item: ContentEntity) {
        this.item = item
        content.value = item.content
        memo.value = item.memo
    }

    fun insertData() {
        content.value?.let { content ->
            viewModelScope.launch(Dispatchers.IO) {
                contentRepository.insert(
                    item?.copy(
                        content = content,
                        memo = memo.value
                    ) ?: ContentEntity(content = content, memo = memo.value)
                )
                _doneEvent.postValue(Unit)
            }
        }
    }
}