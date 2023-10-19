package ball.goal.topcars.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ball.goal.topcars.adapters.FavoritesAdapter
import ball.goal.topcars.databinding.FragmentFavouritesBinding
import ball.goal.topcars.presentation.DetailActivity
import ball.goal.topcars.presentation.models.Car
import ball.goal.topcars.viewmodels.FavouriteViewModel
import ball.goal.topcars.viewmodels.MyViewModel

class FavouritesFragment : Fragment() {
    private lateinit var binding: FragmentFavouritesBinding
    private lateinit var favoritesAdapter: FavoritesAdapter
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesAdapter = FavoritesAdapter(
            onItemClickListener = { car ->
                val intent = Intent(requireActivity(), DetailActivity::class.java)
                intent.putExtra(
                    "car", Car(
                        name = car.title,
                        images = car.images,
                        desc = car.desc,
                        points = car.points
                    )
                )
                startActivity(intent)
            },
            onDeleteClickListener = { car ->
                myViewModel.delete(car) {}
            }
        )

        binding.recyclerViewFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = favoritesAdapter
        }

        favouriteViewModel.getAllBasics().observe(viewLifecycleOwner) { favoriteItems ->
            favoritesAdapter.submitList(favoriteItems)
        }

        val searchEditText = binding.searchEditText
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val searchText = s.toString().trim()

                val filteredFavorites = if (searchText.isEmpty()) {
                    favouriteViewModel.getAllBasics().value
                } else {
                    favouriteViewModel.getFilteredBasics(searchText).value
                }

                favoritesAdapter.submitList(filteredFavorites)
            }
        })
    }
}
