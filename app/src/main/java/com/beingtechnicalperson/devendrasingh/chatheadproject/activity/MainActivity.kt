package com.beingtechnicalperson.devendrasingh.chatheadproject.activity

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import com.beingtechnicalperson.devendrasingh.chatheadproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

     private val CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2084

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        askPermission()
        initilisation()
        inIt()
    }

    private fun askPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:$packageName")
            )
            startActivityForResult(intent, CODE_DRAW_OVER_OTHER_APP_PERMISSION)
        } else {
            initilisation()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    initilisation()
                } else {
                    Toast.makeText(
                        this,
                        "Draw over other app permission not available. Closing the application",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun initilisation() {
        notify_me.setOnClickListener(this)
    }

    private fun inIt() {

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.notify_me -> {
                startService(Intent(this, chatHeadServices::class.java))

            }
        }
    }
}
