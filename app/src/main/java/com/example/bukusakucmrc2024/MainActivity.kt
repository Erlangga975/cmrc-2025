package com.example.bapekom6surabaya
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
//import com.example.bapekom6surabaya.HomeFragment
import com.google.android.material.navigation.NavigationView
//import android.view.Menu
import android.text.SpannableString
import android.text.style.StyleSpan
import android.graphics.Typeface
import android.text.Spannable

import androidx.core.view.forEach



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private var lastOpenedMenuId: Int? = null // variabel untuk melacak menu yang terakhir dibuka

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        navigationView.menu.forEach { menuItem: MenuItem ->
            // Cek apakah ini menu utama (memiliki icon) atau submenu
            if (menuItem.icon != null) {
                // Menu utama - set bold
                menuItem.title = SpannableString(menuItem.title).apply {
                    setSpan(
                        StyleSpan(Typeface.BOLD),
                        0,
                        length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            } else {
                // Submenu - set normal
                menuItem.title = SpannableString(menuItem.title).apply {
                    setSpan(
                        StyleSpan(Typeface.NORMAL),
                        0,
                        length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }
        }


        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }
    // fungsi untuk menutup submenu yang tarakhir dibuka (jika ada)
    private fun closeLastOpenedMenu(menu: Menu) {
        lastOpenedMenuId?.let{ lastId ->
            when(lastId) {
                R.id.nav_menu1 -> {
                    menu.findItem(R.id.nav_menu1_option1).isVisible = false
                }
                R.id.nav_menu2 -> {
                    menu.findItem(R.id.nav_menu2_option1).isVisible = false
                    menu.findItem(R.id.nav_menu2_option2).isVisible = false
                    menu.findItem(R.id.nav_menu2_option3).isVisible = false
                    menu.findItem(R.id.nav_menu2_option4).isVisible = false

                }
                R.id.nav_menu3 -> {
                    menu.findItem(R.id.nav_menu3_option1).isVisible = false
                    menu.findItem(R.id.nav_menu3_option2).isVisible = false
                }
                R.id.nav_menu4 -> {
                    menu.findItem(R.id.nav_menu4_option1).isVisible = false
                    menu.findItem(R.id.nav_menu4_option2).isVisible = false
                    menu.findItem(R.id.nav_menu4_option3).isVisible = false
                }
                R.id.nav_menu5 -> {
                    menu.findItem(R.id.nav_menu5_option1).isVisible = false
                }
                R.id.nav_menu6 -> {
                    menu.findItem(R.id.nav_menu6_option1).isVisible = false
                    menu.findItem(R.id.nav_menu6_option2).isVisible = false
                    menu.findItem(R.id.nav_menu6_option3).isVisible = false
                    menu.findItem(R.id.nav_menu6_option4).isVisible = false
//                    menu.findItem(R.id.nav_menu6_option5).isVisible = false
                    menu.findItem(R.id.nav_menu6_option6).isVisible = false
                }
                R.id.nav_menu7 -> {
                    //menu.findItem(R.id.nav_menu7_option1).isVisible = false
                    //menu.findItem(R.id.nav_menu7_option2).isVisible = false
                    menu.findItem(R.id.nav_menu7_option3).isVisible = false
                    menu.findItem(R.id.nav_menu7_option4).isVisible = false
                    menu.findItem(R.id.nav_menu7_option5).isVisible = false
                }
                R.id.nav_menu8 -> {
                    menu.findItem(R.id.nav_menu8_option1).isVisible = false
                    menu.findItem(R.id.nav_menu8_option2).isVisible = false
                    menu.findItem(R.id.nav_menu8_option3).isVisible = false
                }
                R.id.nav_menu9 -> {
                    menu.findItem(R.id.nav_menu9_option1).isVisible = false
                    menu.findItem(R.id.nav_menu9_option2).isVisible = false
                }

            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val menu = navigationView.menu


        // menangani tombol utama
        when(item.itemId) {
            R.id.nav_menu1, R.id.nav_menu2,R.id.nav_menu3,R.id.nav_menu4,R.id.nav_menu5,
            R.id.nav_menu6, R.id.nav_menu7, R.id.nav_menu8 -> {
                // jika menu yang di klik berbeda dengan menu terakhir yang di buka
                if (lastOpenedMenuId != item.itemId) {
                    // tutup menu yang sebelumnya terbuka
                    closeLastOpenedMenu(menu)
                    // update lastOpenedId (menu yang terbuka) dengan menu yang terbuka sekarang
                    lastOpenedMenuId = item.itemId

                    when(item.itemId) {
                        R.id.nav_menu1 -> {
                            menu.findItem(R.id.nav_menu1_option1).isVisible = true
                        }
                        R.id.nav_menu2 -> {
                            menu.findItem(R.id.nav_menu2_option1).isVisible = true
                            menu.findItem(R.id.nav_menu2_option2).isVisible = true
                            menu.findItem(R.id.nav_menu2_option3).isVisible = true
                            menu.findItem(R.id.nav_menu2_option4).isVisible = true
                        }
                        R.id.nav_menu3 -> {
                            menu.findItem(R.id.nav_menu3_option1).isVisible = true
                            menu.findItem(R.id.nav_menu3_option2).isVisible = true
                        }
                        R.id.nav_menu4 -> {
                            menu.findItem(R.id.nav_menu4_option1).isVisible = true
                            menu.findItem(R.id.nav_menu4_option2).isVisible = true
                            menu.findItem(R.id.nav_menu4_option3).isVisible = true
                        }
                        R.id.nav_menu5 -> {
                            menu.findItem(R.id.nav_menu5_option1).isVisible = true
                        }
                        R.id.nav_menu6 -> {
                            menu.findItem(R.id.nav_menu6_option1).isVisible = true
                            menu.findItem(R.id.nav_menu6_option2).isVisible = true
                            menu.findItem(R.id.nav_menu6_option3).isVisible = true
                            menu.findItem(R.id.nav_menu6_option4).isVisible = true
                            //menu.findItem(R.id.nav_menu6_option5).isVisible = true
                            menu.findItem(R.id.nav_menu6_option6).isVisible = true
                        }
                        R.id.nav_menu7 -> {
//                            menu.findItem(R.id.nav_menu7_option1).isVisible = true
//                            menu.findItem(R.id.nav_menu7_option2).isVisible = true
                            menu.findItem(R.id.nav_menu7_option3).isVisible = true
                            menu.findItem(R.id.nav_menu7_option4).isVisible = true
                            menu.findItem(R.id.nav_menu7_option5).isVisible = true
                        }
                        R.id.nav_menu8 -> {
                            menu.findItem(R.id.nav_menu8_option1).isVisible = true
                            menu.findItem(R.id.nav_menu8_option2).isVisible = true
                            menu.findItem(R.id.nav_menu8_option3).isVisible = true
                        }
                        R.id.nav_menu9 -> {
                            menu.findItem(R.id.nav_menu9_option1).isVisible = true
                            menu.findItem(R.id.nav_menu9_option2).isVisible = true
                        }
                    }

                } else {
                    // jika menu yang sama di klik maka tutup sub menunya
                    closeLastOpenedMenu(menu)
                    lastOpenedMenuId = null
                }
            }
            R.id.nav_menu1 -> {
                val subItem1 = menu.findItem(R.id.nav_menu1_option1)
                subItem1.isVisible = !subItem1.isVisible
            }
            R.id.nav_menu2 -> {
                val subItem1 = menu.findItem(R.id.nav_menu2_option1)
                val subItem2 = menu.findItem(R.id.nav_menu2_option2)
                val subItem3 = menu.findItem(R.id.nav_menu2_option3)
                val subItem4 = menu.findItem(R.id.nav_menu2_option4)
                subItem1.isVisible = !subItem1.isVisible
                subItem2.isVisible = !subItem2.isVisible
                subItem3.isVisible = !subItem3.isVisible
                subItem4.isVisible = !subItem4.isVisible
            }
            R.id.nav_menu3 -> {
                val subItem1 = menu.findItem(R.id.nav_menu3_option1)
                val subItem2 = menu.findItem(R.id.nav_menu3_option2)
                subItem1.isVisible = !subItem1.isVisible
                subItem2.isVisible = !subItem2.isVisible
            }
            R.id.nav_menu4 -> {
                val subItem1 = menu.findItem(R.id.nav_menu4_option1)
                val subItem2 = menu.findItem(R.id.nav_menu4_option2)
                val subItem3 = menu.findItem(R.id.nav_menu4_option3)
                subItem1.isVisible = !subItem1.isVisible
                subItem2.isVisible = !subItem2.isVisible
                subItem3.isVisible = !subItem3.isVisible
            }
            R.id.nav_menu5 -> {
                val subItem1 = menu.findItem(R.id.nav_menu5_option1)
                subItem1.isVisible = !subItem1.isVisible
            }
            R.id.nav_menu6 -> {
                val subItem1 = menu.findItem(R.id.nav_menu6_option1)
                val subItem2 = menu.findItem(R.id.nav_menu6_option2)
                val subItem3 = menu.findItem(R.id.nav_menu6_option3)
                val subItem4 = menu.findItem(R.id.nav_menu6_option4)
              //  val subItem5 = menu.findItem(R.id.nav_menu6_option5)
                val subItem6 = menu.findItem(R.id.nav_menu6_option6)
                subItem1.isVisible = !subItem1.isVisible
                subItem2.isVisible = !subItem2.isVisible
                subItem3.isVisible = !subItem3.isVisible
                subItem4.isVisible = !subItem4.isVisible
               // subItem5.isVisible = !subItem5.isVisible
                subItem6.isVisible = !subItem6.isVisible
            }
            R.id.nav_menu7 -> {
                //val subItem1 = menu.findItem(R.id.nav_menu7_option1)
                //val subItem2 = menu.findItem(R.id.nav_menu7_option2)
                val subItem3 = menu.findItem(R.id.nav_menu7_option3)
                val subItem4 = menu.findItem(R.id.nav_menu7_option4)
                val subItem5 = menu.findItem(R.id.nav_menu7_option5)
                //subItem1.isVisible = !subItem1.isVisible
                //subItem2.isVisible = !subItem2.isVisible
                subItem3.isVisible = !subItem3.isVisible
                subItem4.isVisible = !subItem4.isVisible
                subItem5.isVisible = !subItem5.isVisible

            }

            R.id.nav_menu8 -> {
                val subItem1 = menu.findItem(R.id.nav_menu8_option1)
                val subItem2 = menu.findItem(R.id.nav_menu8_option2)
                val subItem3 = menu.findItem(R.id.nav_menu8_option3)
                subItem1.isVisible = !subItem1.isVisible
                subItem2.isVisible = !subItem2.isVisible
                subItem3.isVisible = !subItem3.isVisible
            }

            R.id.nav_menu9 -> {
                val subItem1 = menu.findItem(R.id.nav_menu9_option1)
                val subItem2 = menu.findItem(R.id.nav_menu9_option2)
                subItem1.isVisible = !subItem1.isVisible
                subItem2.isVisible = !subItem2.isVisible
            }

            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu1_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu1Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu2_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu2Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu2_option2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu2Option2Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu2_option3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu2Option3Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu2_option4 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu2Option4Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu3_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu3Fragment())
                    .commit()
                closeDrawer()
            }

            R.id.nav_menu3_option2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu3Option2Fragment())
                    .commit()
                closeDrawer()
            }

            R.id.nav_menu4_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu4Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu4_option2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu4Option2Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu4_option3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu4Option3Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu5_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu5Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu6_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu6Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu6_option2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu6Option2Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu6_option3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu6Option3Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu6_option4 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu6Option4Fragment())
                    .commit()
                closeDrawer()
            }
//            R.id.nav_menu6_option5 -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, Menu6Option5Fragment())
//                    .commit()
//                closeDrawer()
//            }

            R.id.nav_menu6_option6 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu6Option6Fragment())
                    .commit()
                closeDrawer()
            }
//
//            R.id.nav_menu7_option1 -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, Menu7Fragment())
//                    .commit()
//                closeDrawer()
//            }
//            R.id.nav_menu7_option2 -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, Menu7Option2Fragment())
//                    .commit()
//                closeDrawer()
//            }
            R.id.nav_menu7_option3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu7Option3Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu7_option4 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu7Option4Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu7_option5 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu7Option5Fragment())
                    .commit()
                closeDrawer()
            }

            R.id.nav_menu8_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu8Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu8_option2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu8Option2Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu8_option3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu8Option3Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu9_option1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu9Fragment())
                    .commit()
                closeDrawer()
            }
            R.id.nav_menu9_option2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Menu9Option2Fragment())
                    .commit()
                closeDrawer()
            }

        }
        // drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}