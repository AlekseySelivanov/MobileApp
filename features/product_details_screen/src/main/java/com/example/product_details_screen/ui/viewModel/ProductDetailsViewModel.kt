package com.example.product_details_screen.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.product_details_screen.domain.model.ProductDetailsItem
import com.example.product_details_screen.domain.usecase.GetProductDetailsUseCase
import com.example.product_details_screen.domain.usecase.InsertProductDetailsToDBUseCase
import com.example.product_details_screen.ui.DetailsApiStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val insertProductDetailsToDBUseCase: InsertProductDetailsToDBUseCase
) : ViewModel() {

    private val _status = MutableStateFlow<DetailsApiStatus>(DetailsApiStatus.DONE)
    val status = _status.asStateFlow()

    private val _phoneDetailsList = MutableStateFlow(ProductDetailsItem())
    val phoneDetailsList = _phoneDetailsList.asStateFlow()

    init {
        getPDItem()
    }

    private fun getPDItem() {
        viewModelScope.launch {
            _status.value = DetailsApiStatus.LOADING
            try {
                insertProductDetailsToDBUseCase.insertProductDetailsToCache()
                _status.value = DetailsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = DetailsApiStatus.ERROR(e.toString())
            }
            _phoneDetailsList.value = getProductDetailsUseCase.getProductDetails()
        }
    }
}