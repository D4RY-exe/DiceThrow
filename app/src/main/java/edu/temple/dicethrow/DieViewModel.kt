package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {
    var dieSides: Int = 6
    val currentRoll : MutableLiveData<Int> by lazy {
        MutableLiveData()
    }
    fun getCurrentRoll() : LiveData<Int> {
        return currentRoll
    }

    fun setCurrentRoll(roll: Int){
        currentRoll.value = roll
    }

    fun rollDie() {
        setCurrentRoll(Random.nextInt(dieSides)+1)
    }

}