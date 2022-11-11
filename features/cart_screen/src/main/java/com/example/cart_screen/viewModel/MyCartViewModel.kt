package com.example.cart_screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cart_screen.MyCartApiStatus
import com.example.common.models.modelCart.BasketMain
import com.example.common.use_cases.cart_usecase.GetMyCartUseCase
import com.example.common.use_cases.cart_usecase.InsertMyCartToDBUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyCartViewModel @Inject constructor(
    private val getMyCartUseCase: GetMyCartUseCase,
    private val insertMyCartToDBUseCase: InsertMyCartToDBUseCase
) : ViewModel() {

    private val _status = MutableStateFlow<MyCartApiStatus>(MyCartApiStatus.DONE)
    val status = _status.asStateFlow()

    private val _myCart = MutableStateFlow(BasketMain())
    val myCart = _myCart.asStateFlow()

    init {
        getMyCartModels()
    }

    private fun getMyCartModels() {
        viewModelScope.launch {
            _status.value = MyCartApiStatus.LOADING
            try {
                insertMyCartToDBUseCase.insertMyCartToDB()
                _status.value = MyCartApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MyCartApiStatus.ERROR(e.toString())
            }
            _myCart.value = getMyCartUseCase.getMyCart()
        }
    }
}