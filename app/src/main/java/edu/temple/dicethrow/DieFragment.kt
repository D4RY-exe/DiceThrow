package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    lateinit var dieTextView: TextView
    var dieSides: Int = 6

    private val currentNum = "currentnumber"
    private var currentNumId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dieSides = it.getInt(DIESIDE,6) //modified this to default to 6
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null){
            throwDie()
        }
        else{
            currentNumId = savedInstanceState.getInt(currentNum)
            dieTextView.text = currentNumId.toString()
        }
        view.setOnClickListener{ throwDie()}
    }

    fun throwDie() {
        currentNumId = (Random.nextInt(dieSides)+1)
        dieTextView.text = (Random.nextInt(dieSides) + 1).toString()
    }

    fun OnSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(currentNum, currentNumId)
    }

    companion object {
        fun newInstance(sides: Int) = DieFragment().apply {
            arguments = Bundle().apply {
                putInt(DIESIDE, sides)
            }
        }
    }
}