package np.com.sudan10.lims_v30.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch
import np.com.sudan10.lims_v30.R
import np.com.sudan10.lims_v30.data.UserPreferences
import np.com.sudan10.lims_v30.databinding.ActivityHomeBinding
import np.com.sudan10.lims_v30.ui.auth.Login
import np.com.sudan10.lims_v30.ui.breeding.*
import np.com.sudan10.lims_v30.ui.farmlist.FarmListing
import np.com.sudan10.lims_v30.ui.feedback.Feedback
import np.com.sudan10.lims_v30.ui.health.AnimalHealth
import np.com.sudan10.lims_v30.ui.health.Sample
import np.com.sudan10.lims_v30.ui.health.Treatment
import np.com.sudan10.lims_v30.ui.health.Vaccination
import np.com.sudan10.lims_v30.ui.list.FarmList
import np.com.sudan10.lims_v30.ui.performance_record.GrowthRecording
import np.com.sudan10.lims_v30.ui.performance_record.MeatRecording
import np.com.sudan10.lims_v30.ui.performance_record.MilkRecording
import np.com.sudan10.lims_v30.ui.performance_record.PerformanceRecord
import np.com.sudan10.lims_v30.ui.ration_balance.RationBalance
import np.com.sudan10.lims_v30.ui.ration_balance.RbNonRuminant
import np.com.sudan10.lims_v30.ui.ration_balance.RbRuminant
import np.com.sudan10.lims_v30.ui.registration.AnimalRegistration
import np.com.sudan10.lims_v30.ui.registration.Calving
import np.com.sudan10.lims_v30.ui.registration.Culling
import np.com.sudan10.lims_v30.ui.registration.FarmRegistration

@AndroidEntryPoint
class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var defaultFragment = HomeMenu()
    private val viewModel by viewModels<HomeViewModel>()

    val userPreferences = UserPreferences(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)

        setSupportActionBar(binding.mainToolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.mainToolbar,
            R.string.open,
            R.string.close
        )
        //setSupportActionBar(binding.mainToolbar)


        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.navMenu.setNavigationItemSelectedListener(this)

        //val defaultFragment = HomeMenu()




        userPreferences.authToken.asLiveData().observe(this, Observer {

            val defaultFragment = if (it == null) HomeMenu() else HomeMenuLoggedIn()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, defaultFragment)
                commit()
            }
        })
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, defaultFragment)
            commit()
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START, false)

        when (item.itemId) {


            R.id.home -> {
                setToolbarTitle("Home")
                changeFragment(defaultFragment)
            }

            R.id.login -> {
                setToolbarTitle("Login")
                changeFragment(Login())
            }

            R.id.dashboard -> {
                setToolbarTitle("Dashboard")
                changeFragment(Dashboard())
            }

            R.id.farmlisting -> {
                setToolbarTitle("Farm Listing")
                changeFragment(FarmListing())
            }

            R.id.farmlist -> {
                setToolbarTitle("Farm List")
                changeFragment(FarmList())
            }

            R.id.rationBalance -> {
                setToolbarTitle("Ration Balance")
                changeFragment(RationBalance())
            }

            R.id.rationBalanceNonRuminant -> {
                setToolbarTitle("Ration Balance Non Ruminant")
                changeFragment(RbNonRuminant())
            }

            R.id.rationBalanceRuminant -> {
                setToolbarTitle("Ration Balance Ruminant")
                changeFragment(RbRuminant())
            }

            R.id.animalRegistration -> {
                setToolbarTitle("Animal Registration")
                changeFragment(AnimalRegistration())
            }

            R.id.farmerRegistration -> {
                setToolbarTitle("Farm Registration")
                changeFragment(FarmRegistration())
            }

            R.id.animalHealth -> {
                setToolbarTitle("Animal Health")
                changeFragment(AnimalHealth())
            }
            R.id.animalVaccine -> {
                setToolbarTitle("Vaccination")
                changeFragment(Vaccination())
            }
            R.id.animalTreatment -> {
                setToolbarTitle("Treatment")
                changeFragment(Treatment())
            }
            R.id.animalSample -> {
                setToolbarTitle("Sample")
                changeFragment(Sample())
            }

            R.id.animalBreeding -> {
                setToolbarTitle("Animal Breeding")
                changeFragment(AnimalBreeding())
            }
            R.id.heatRecording -> {
                setToolbarTitle("Heat Recording")
                changeFragment(HeatRecording())
            }
            R.id.artificialInsemination -> {
                setToolbarTitle("AI")
                changeFragment(AI())
            }
            R.id.pregnancyDiagnosis -> {
                setToolbarTitle("Pregnancy Diagnosis")
                changeFragment(PregnancyDiagnosis())
            }
            R.id.abortion -> {
                setToolbarTitle("Abortion")
                changeFragment(Abortion())
            }

            R.id.performanceRecord -> {
                setToolbarTitle("Performance Record")
                changeFragment(PerformanceRecord())
            }
            R.id.milkRecording -> {
                setToolbarTitle("Milk Recording")
                changeFragment(MilkRecording())
            }
            R.id.growthRecording -> {
                setToolbarTitle("Growth Recording")
                changeFragment(GrowthRecording())
            }
            R.id.meatRecording -> {
                setToolbarTitle("Meat Recording")
                changeFragment(MeatRecording())
            }

            R.id.feedback -> {
                setToolbarTitle("Feedback")
                changeFragment(Feedback())
            }
            R.id.Calving -> {
                setToolbarTitle("Calving")
                changeFragment(Calving())
            }
            R.id.Culling -> {
                setToolbarTitle("Culling")
                changeFragment(Culling())
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

    fun performLogout() = lifecycleScope.launch {
        userPreferences.clear()
    }
}