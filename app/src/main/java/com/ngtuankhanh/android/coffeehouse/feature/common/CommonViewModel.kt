package com.ngtuankhanh.android.coffeehouse.feature.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CommonViewModel : ViewModel() {
    private val _myCartItems = MutableLiveData<MutableList<MyCartItem>?>(mutableListOf())
    val myCartItems: LiveData<MutableList<MyCartItem>?>
        get() = _myCartItems

    private val _myOnGoingOrderItems = MutableLiveData<MutableList<MyOrderItem>>(mutableListOf())
    val myOnGoingOrderItems: LiveData<MutableList<MyOrderItem>>
        get() = _myOnGoingOrderItems

    private val _myHistoryOrderItems = MutableLiveData<MutableList<MyOrderItem>>(mutableListOf())
    val myHistoryOrderItems: LiveData<MutableList<MyOrderItem>>
        get() = _myHistoryOrderItems

    fun addMyCartItem(item: MyCartItem) {
        val list = _myCartItems.value ?: mutableListOf()
        list.add(0, item)
        _myCartItems.value = list
    }

    fun addMyOrderItem() {
        val onGoingList = _myOnGoingOrderItems.value ?: mutableListOf()

        val totalAmountAmericano = getTotalAmountAmericano()
        if (totalAmountAmericano > 0f) onGoingList.add(
            MyOrderItem(amount = totalAmountAmericano, coffeeName = "Americano")
        )

        val totalAmountCappuccino = getTotalAmountCappuccino()
        if (totalAmountCappuccino > 0f) onGoingList.add(
            MyOrderItem(amount = totalAmountCappuccino, coffeeName = "Cappuccino")
        )

        val totalAmountMocha = getTotalAmountMocha()
        if (totalAmountMocha > 0f) onGoingList.add(
            MyOrderItem(amount = totalAmountMocha, coffeeName = "Mocha")
        )

        val totalAmountFlatWhite = getTotalFlatWhite()
        if (totalAmountFlatWhite > 0f) onGoingList.add(
            MyOrderItem(amount = totalAmountFlatWhite, coffeeName = "Flat White")
        )

        _myOnGoingOrderItems.value = onGoingList

        // Clear my cart items
        _myCartItems.value = mutableListOf()

        viewModelScope.launch {
            delay(10000)

            // Add to history
            val historyList = _myHistoryOrderItems.value ?: mutableListOf()
            historyList.addAll(onGoingList)
            _myHistoryOrderItems.value = historyList

            // Clear on going list
            _myOnGoingOrderItems.value = mutableListOf()
        }

    }

    fun getTotalAmount(): Float {
        var sum = 0f
        _myCartItems.value?.forEach { it -> sum += it.totalAmount }
        return sum
    }

    private fun getTotalAmountAmericano(): Float {
        var sum = 0f
        _myCartItems.value?.forEach { it -> if (it.coffeeName == "Americano") sum += it.totalAmount }
        return sum
    }

    private fun getTotalAmountCappuccino(): Float {
        var sum = 0f
        _myCartItems.value?.forEach { it -> if (it.coffeeName == "Cappuccino") sum += it.totalAmount }
        return sum
    }

    private fun getTotalAmountMocha(): Float {
        var sum = 0f
        _myCartItems.value?.forEach { it -> if (it.coffeeName == "Mocha") sum += it.totalAmount }
        return sum
    }

    private fun getTotalFlatWhite(): Float {
        var sum = 0f
        _myCartItems.value?.forEach { it -> if (it.coffeeName == "Flat White") sum += it.totalAmount }
        return sum
    }
}

data class MyCartItem(
    val imageId: Int,
    val coffeeName: String,
    val counter: Int,
    val shotOption: String,
    val selectOption: String,
    val sizeOption: String,
    val iceOption: String,
    val totalAmount: Float,
)

data class MyOrderItem(
    val time: String = "24 June | 12:30 PM",
    val amount: Float,
    val coffeeName: String,
    val address: String = "3 Addersion Court Chino Hills, HO56824, United States"
)

