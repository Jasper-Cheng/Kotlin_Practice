package com.example.particekotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.palette.graphics.Palette

class MainActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var tvClose:TextView
    private lateinit var mDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mToolbar=findViewById(R.id.toolbar)
        mToolbar.title = "Toolbar"
        setSupportActionBar(mToolbar)
        // 给左上角图标的左边加上一个返回的图标
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setLogo(R.mipmap.just_do_it)
        mToolbar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.custom_setting -> Toast.makeText(this,"custom_setting",Toast.LENGTH_LONG).show()
                R.id.custom_share -> Toast.makeText(this,"custom_share",Toast.LENGTH_LONG).show()
                else -> Toast.makeText(this,"what's you click?",Toast.LENGTH_LONG).show()
            }
            true
        }

        mDrawerLayout=findViewById(R.id.id_drawerlayout)
        mDrawerToggle=ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close)
        mDrawerToggle.syncState()
        mDrawerLayout.addDrawerListener(mDrawerToggle)
        tvClose=findViewById(R.id.tv_close)
        tvClose.setOnClickListener{
            mDrawerLayout.closeDrawer(Gravity.LEFT)
        }

        var bitmap=BitmapFactory.decodeResource(resources,R.mipmap.insist)
        Palette.from(bitmap).generate(Palette.PaletteAsyncListener {
            supportActionBar?.setBackgroundDrawable(it?.mutedSwatch?.rgb?.let { it1 ->
                ColorDrawable(
                    it1
                )
            })
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.customtoolbarmenu,menu)
        return true
    }
}
