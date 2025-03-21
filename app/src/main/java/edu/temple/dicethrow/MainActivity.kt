package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) == null)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView1, DieFragment.newInstance(20))
            .commit()

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) == null)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView2, DieFragment.newInstance(6))
                .commit()

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener{
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) as DieFragment).throwDie()
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as DieFragment).throwDie()
        }
    }
}