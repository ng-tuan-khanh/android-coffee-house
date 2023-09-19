package com.ngtuankhanh.android.coffeehouse.feature.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CommonViewModel : ViewModel() {
    private val _loyaltyCardCounter = MutableLiveData<Int>(0)
    val loyaltyCardCounter: LiveData<Int>
        get() = _loyaltyCardCounter

    private val _myCartItems = MutableLiveData<MutableList<MyCartItem>?>(mutableListOf())
    val myCartItems: LiveData<MutableList<MyCartItem>?>
        get() = _myCartItems

    private val _myOnGoingOrderItems = MutableLiveData<MutableList<MyOrderItem>>(mutableListOf())
    val myOnGoingOrderItems: LiveData<MutableList<MyOrderItem>>
        get() = _myOnGoingOrderItems

    private val _myHistoryOrderItems = MutableLiveData<MutableList<MyOrderItem>>(mutableListOf())
    val myHistoryOrderItems: LiveData<MutableList<MyOrderItem>>
        get() = _myHistoryOrderItems

    private val _historyRewards = MutableLiveData<MutableList<HistoryReward>>(mutableListOf())
    val historyRewards: LiveData<MutableList<HistoryReward>>
        get() = _historyRewards

    val rewardPoints = MutableLiveData<Int>(2000)

    val rewardPointsUsed = MutableLiveData<Int>(0)

    fun resetLoyaltyCardCounter() {
        if (_loyaltyCardCounter.value == 8) {
            _loyaltyCardCounter.value = 0
        }
    }

    fun reduceRewardPointsUsed() {
        rewardPoints.value = rewardPoints.value?.minus(rewardPointsUsed.value ?: 0)
    }

    private fun processRewardPoints() {
        _myCartItems.value?.forEach { it ->
            _loyaltyCardCounter.value = if (_loyaltyCardCounter.value?.plus(it.counter)!! <= 8) {
                _loyaltyCardCounter.value?.plus(it.counter)
            } else 8
            for (i in 0 until it.counter) {
                if (it.coffeeName == "Americano") {
                    rewardPoints.value = rewardPoints.value?.plus(13)
                    _historyRewards.value?.add(
                        HistoryReward(
                            coffeeName = "Americano",
                            points = 13
                        )
                    )
                } else if (it.coffeeName == "Cappuccino") {
                    rewardPoints.value = rewardPoints.value?.plus(15)
                    _historyRewards.value?.add(
                        HistoryReward(
                            coffeeName = "Cappuccino",
                            points = 15
                        )
                    )
                } else if (it.coffeeName == "Mocha") {
                    rewardPoints.value = rewardPoints.value?.plus(16)
                    _historyRewards.value?.add(
                        HistoryReward(
                            coffeeName = "Mocha",
                            points = 16
                        )
                    )
                } else if (it.coffeeName == "Flat White") {
                    rewardPoints.value = rewardPoints.value?.plus(14)
                    _historyRewards.value?.add(
                        HistoryReward(
                            coffeeName = "Flat White",
                            points = 14
                        )
                    )
                }
            }
        }
    }

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

        viewModelScope.launch {
            delay(10000)

            // Add to history
            val historyList = _myHistoryOrderItems.value ?: mutableListOf()
            historyList.addAll(onGoingList)
            _myHistoryOrderItems.value = historyList

            // Clear on going list
            _myOnGoingOrderItems.value = mutableListOf()

            processRewardPoints()

            // Clear my cart items
            _myCartItems.value = mutableListOf()
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

data class HistoryReward(
    val coffeeName: String,
    val points: Int
)

