package np.com.sudan10.lims_v21

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import np.com.sudan10.lims_v21.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)

        window.statusBarColor = ContextCompat.getColor(this, R.color.default_toolbar) //android status bar color change

        setContentView(binding.root)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        binding.navMenu.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //var binding = ActivityMainBinding.inflate(layoutInflater)
        // need to implement close drawer without kotlin plugin
        drawerLayout.closeDrawer(GravityCompat.START, false)

        when(item.itemId){
            R.id.home -> {
                setToolbarTitle("Home")
                changeFragment(Home())
            }
            R.id.login -> {
                setToolbarTitle("Login")
                changeFragment(login())
            }
            R.id.rationBalance -> {
                setToolbarTitle("Ration Balance")
                changeFragment(rationBalance())
            }
            R.id.animalRegistration -> {
                setToolbarTitle("Animal Registration")
                changeFragment(animalRegistration())
            }R.id.farmRegistration -> {
                setToolbarTitle("Farm Registration")
                changeFragment(farmRegistration())
            }R.id.farmerRegistration -> {
                setToolbarTitle("Farmer Registration")
                changeFragment(farmRegistration())
            }
            R.id.animalHealth -> {
                setToolbarTitle("Animal Health")
                changeFragment(animalHealth())
            }
            R.id.animalBreeding -> {
                setToolbarTitle("Animal Breeding")
                changeFragment(animalBreeding())
            }
            R.id.performanceRecord -> {
                setToolbarTitle("Performance Record")
                changeFragment(performanceRecord())
            }

            R.id.feedback -> {
                setToolbarTitle("Feedback")
                changeFragment(feedback())
            }
        }
        return true
    }
    fun setToolbarTitle(title: String){
        supportActionBar?.title = title
    }

    fun changeFragment(frag: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container, frag).commit()
    }


}