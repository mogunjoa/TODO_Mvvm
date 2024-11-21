package com.mogun.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mogun.todo.model.ContentEntity
import com.mogun.todo.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentRepository: ContentRepository
): ViewModel() {
    val contentList = contentRepository.loadList()
        .stateIn(
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope
        )

    fun updateItem(item: ContentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            contentRepository.modify(item)
        }
    }
}