package ball.goal.topcars.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ball.goal.topcars.R
import ball.goal.topcars.databinding.ActivityMainBinding
import ball.goal.topcars.presentation.fragments.FavouritesFragment
import ball.goal.topcars.presentation.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val initialFragment = HomeFragment()
            replaceFragment(initialFragment)
        }
        binding.bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    val homeFragment =
                        supportFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
                    if (homeFragment == null) {
                        replaceFragment(HomeFragment())
                    }
                    true
                }

                R.id.favouritesFragment -> {
                    val favouritesFragment =
                        supportFragmentManager.findFragmentByTag(FavouritesFragment::class.java.simpleName)
                    if (favouritesFragment == null) {
                        replaceFragment(FavouritesFragment())
                    }
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentMainContainer.id, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }


}
