package tw.edu.pu.csim.tcyang.oopsimple

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txv: TextView = findViewById(R.id.txv)
        //txv.text = "物件導向實例"
        var v1 = Two()
        v1.x = 5
        v1.y = 7
        txv.text = v1.Sum().toString()
    }
}

class Two{
    var x:Int = 0
    var y:Int = 0
    fun Sum(): Int {
        return x + y
    }
}