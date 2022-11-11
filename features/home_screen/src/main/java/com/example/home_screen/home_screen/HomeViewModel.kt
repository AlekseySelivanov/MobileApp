package com.example.home_screen.home_screen

import android.util.Log
import androidx.lifecycle.*
import com.example.common.models.BestSeller
import com.example.common.models.home_model.HomeStore
import com.example.common.use_cases.home_use_case.GetBestSellerPhonesListUseCase
import com.example.common.use_cases.home_use_case.GetHomeStorePhonesListUseCase
import com.example.common.use_cases.home_use_case.InsertMainRemoteToDBUseCase
import com.example.common.use_cases.liked_use_case.AddBookmarkUseCase
import com.example.common.use_cases.liked_use_case.DeleteBookmarkMainUseCase
import com.example.home_screen.home_screen.state.MainScreenStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getBestSellerPhonesListUseCase: GetBestSellerPhonesListUseCase,
    private val getHomeStorePhonesListUseCase: GetHomeStorePhonesListUseCase,
    private val insertMainRemoteToDBUseCase: InsertMainRemoteToDBUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkMainUseCase: DeleteBookmarkMainUseCase,
): ViewModel() {
    private val _status = MutableStateFlow<MainScreenStatus>(MainScreenStatus.DONE)
    val status = _status.asStateFlow()

    private val _homeStorePhonesList = MutableStateFlow<List<HomeStore>>(listOf())
    val homeStorePhonesList = _homeStorePhonesList.asStateFlow()

    private val _homeStoreListSize = MutableStateFlow(value = 0)
    val homeStoreListSize = _homeStoreListSize.asStateFlow()

    private val _bestSellerPhonesList = MutableStateFlow<List<BestSeller>>(listOf())
    val bestSellerPhonesList = _bestSellerPhonesList.asStateFlow()

    init {
        getPhoneModels()
    }

    private fun getPhoneModels() {
        viewModelScope.launch {
            _status.value = MainScreenStatus.LOADING
            try {
                insertMainRemoteToDBUseCase.insertMainRemoteToDB()
                _status.value = MainScreenStatus.DONE
            } catch (e: Exception) {
                Log.e("named",e.toString())
                _status.value = MainScreenStatus.ERROR(e.toString())
            }
            _homeStorePhonesList.value = getHomeStorePhonesListUseCase.getHomeStorePhonesList()
            _bestSellerPhonesList.value = getBestSellerPhonesListUseCase.getBestSellerPhonesList()
            _homeStoreListSize.value  = homeStorePhonesList.value.size
        }
    }

    fun addBookmark(bestSeller: BestSeller) {
        viewModelScope.launch(Dispatchers.IO) {
            addBookmarkUseCase.addBookmark(bestSeller)
        }
    }

    fun deleteBookmark(bestSeller: BestSeller) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkMainUseCase.deleteBookmark(bestSeller)
        }
    }
}