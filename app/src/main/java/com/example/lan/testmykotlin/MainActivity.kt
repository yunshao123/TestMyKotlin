package com.example.lan.testmykotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


//https://github.com/teddyisme/LWidgets
class MainActivity : AppCompatActivity(){
    private var menuItem:MenuItem?=null
    private val mBottomNavigationView = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        menuItem=item
        when (item.itemId) {

            R.id.menu -> {

                vp_main.currentItem = 0

                return@OnNavigationItemSelectedListener true
            }
            R.id.more -> {

                vp_main.currentItem = 1

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        bottom_navigation.setOnNavigationItemSelectedListener(mBottomNavigationView)
        initFragment()
        val adapter = MyAdater(
            supportFragmentManager,
            fragmentArrayList
        )
        vp_main.adapter = adapter
        vp_main.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageSelected(position: Int) {
                if (menuItem != null) {
                    menuItem!!.isChecked = false
                } else {
                    bottom_navigation.menu.getItem(0).isChecked = false
                }
                menuItem = bottom_navigation.menu.getItem(position)
                menuItem!!.isChecked=true
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        if (menu != null) {
            if (menu.javaClass.simpleName.equals("MenuBuilder", ignoreCase = true)) {
                try {
                    val method = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible", java.lang.Boolean.TYPE)
                    method.isAccessible = true
                    method.invoke(menu, true)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
        return super.onMenuOpened(featureId, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.change_user -> {

            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private var fragmentArrayList: ArrayList<Fragment>? = null
    private fun initFragment() {
        fragmentArrayList = ArrayList()
        fragmentArrayList!!.add(FragmentOne())
        fragmentArrayList!!.add(FragmentOne())
    }


}
