package np.com.sudan10.lims_v21

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import np.com.sudan10.lims_v21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout,binding.toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val cardTitles : Array<String> = resources.getStringArray(R.array.cardTitles)
        val cardImages : Array<String> =  resources.getStringArray(R.array.cardImages)

        val adapter = GridItemAdapter(cardTitles,cardImages)
        val gridLayout = GridLayoutManager(this,2)

        binding.gridItems.layoutManager = gridLayout
        binding.gridItems.adapter = adapter


    }
}