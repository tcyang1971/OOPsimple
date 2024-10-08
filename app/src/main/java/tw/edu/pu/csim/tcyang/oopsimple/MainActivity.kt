package tw.edu.pu.csim.tcyang.oopsimple

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener, OnLongClickListener {
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

        var img: ImageView = findViewById(R.id.img)
        img.setOnClickListener(this)
        txv.setOnClickListener(this)
        img.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        var txv: TextView = findViewById(R.id.txv)
        if (v == txv){
            txv.text = "文字短按"
        }
        else{
            txv.text = "我是可愛的小企鵝"
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        var txv: TextView = findViewById(R.id.txv)
        txv.text = "長按企鵝"
        return true
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