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
        var v1 = Three(3, 8, 9)
        txv.text = v1.Sum().toString() + "\n" + v1.Display()
    }
}

interface ShowPurpose{
    fun Display(): String
}

open class Two(var x:Int, var y:Int): ShowPurpose{
    open fun Sum(): Int {
        return x + y
    }

    override fun Display(): String {
        return "設定變數，並透過Sum方法回傳總和"
    }
}

class Three(x: Int, y:Int, var z:Int) :Two(x, y){
    override fun Sum(): Int {
        return x + y + z
    }
}