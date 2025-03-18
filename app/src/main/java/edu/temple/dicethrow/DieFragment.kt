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
            it.getInt(DIESIDE).run {
                dieSides = this
            }
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

        savedInstanceState.run {
            currentNumId = getInt(currentNum, 0)
        }
        if (currentNumId == 0)
            throwDie()
        else
            throwDie(currentNumId)
    }
    //throwDie()
    //view.setOnClickListener{
    //    throwDie()}

    fun throwDie() {
        dieTextView.text = (Random.nextInt(dieSides) + 1).toString()
    }

    fun throwDie(numId: Int) {
        dieTextView.text = (Random.nextInt(dieSides) + 1).toString()
    }

    override fun OnSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outstate)
        outState.putInt(currentNum, currentNumId)
    }

    companion object {
        fun newInstance(sides: Int) = DieFragment().apply {
            //unfinished
            arguments = Bundle().apply {

            }
        }
    }
}