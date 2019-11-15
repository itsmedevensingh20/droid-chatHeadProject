package com.beingtechnicalperson.devendrasingh.chatheadproject.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.beingtechnicalperson.devendrasingh.chatheadproject.R
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        inIt()
    }

    private fun inIt() {
        close_btn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.close_btn -> {
                finish()
            }
        }
    }
}
