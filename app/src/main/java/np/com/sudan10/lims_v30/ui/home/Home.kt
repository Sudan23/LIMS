package np.com.sudan10.lims_v30.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.navigation_header.*
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.UserPreferences
import np.com.sudan10.lims_v30.databinding.ActivityHomeBinding
import np.com.sudan10.lims_v30.ui.auth.Login
import np.com.sudan10.lims_v30.ui.auth.Logout
import np.com.sudan10.lims_v30.ui.feedback.Feedback
import np.com.sudan10.lims_v30.ui.ration_balance.RbRuminant
import np.com.sudan10.lims_v30.util.toast

@AndroidEntryPoint
class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var binding: ActivityHomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)

        setSupportActionBar(binding.mainToolbar)

        val userPreferences = UserPreferences(this)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.mainToolbar,
            R.string.open,
            R.string.close
        )



        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        binding.navMenu.setNavigationItemSelectedListener(this)




        userPreferences.authToken.asLiveData().observe(this, Observer {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, HomeMenu())
                commit()
            }

            if (it == null) {
                binding.navMenu.inflateMenu(R.menu.navigation_menu_not_login)

            } else {
                binding.navMenu.inflateMenu(R.menu.navigation_menu_login)

            }


        })


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START, false)

        when (item.itemId) {


            R.id.logout -> {
                changeFragment(Logout())
            }

            R.id.login -> {
                setToolbarTitle("Login")
                changeFragment(Login())
            }



            R.id.dashboard -> {
                setToolbarTitle("Dashboard")
                Navigation.findNavController(this,R.id.fragment_container).navigate(R.id.home2dashboard)
                //Navigation.findNavController(binding.drawerLayout.).navigate(R.id.dashboard2breeding)
            }


            R.id.rationBalance -> {
                setToolbarTitle("Ration Balance")
                Navigation.findNavController(this,R.id.fragment_container).navigate(R.id.home2rationabalance)
            }

            R.id.home -> {
                setToolbarTitle("Home")
                changeFragment(HomeMenu())
            }



            R.id.feedback -> {
                setToolbarTitle("Feedback")
                Navigation.findNavController(this,R.id.fragment_container).navigate(R.id.home2feedback)
            }

        }
        return true
    }

    fun setToolbarTitle(title: String) {

        supportActionBar?.title = title
    }

    fun changeFragment(frag: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container, frag).commit()
    }

 /*   override fun onItemClick(position: Int) {
        when(position){
            0 -> {
                setToolbarTitle("Feedback")
                changeFragment(Feedback())
            }
            1 -> {
                setToolbarTitle("Feedback")
                changeFragment(Feedback())
            }
            2 -> {
                setToolbarTitle("Feedback")
                changeFragment(Feedback())
            }
        }
    }*/





}