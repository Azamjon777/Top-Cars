package ball.goal.topcars.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ball.goal.topcars.adapters.CarsAdapter
import ball.goal.topcars.databinding.FragmentAllCarsBinding
import ball.goal.topcars.presentation.DetailActivity
import ball.goal.topcars.presentation.models.Car
import ball.goal.topcars.viewmodels.DataViewModel
import ball.goal.topcars.viewmodels.DataViewModelFactory

class AllCarsFragment : Fragment(), CarsAdapter.OnCarClickListener {
    private lateinit var binding: FragmentAllCarsBinding
    private lateinit var viewModel: DataViewModel
    private lateinit var adapter: CarsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllCarsBinding.inflate(inflater, container, false)
        val viewModelFactory = DataViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val allCars = mutableListOf<Car>()
        for (carsPojo in viewModel.carsData) {
            allCars.addAll(carsPojo.carsList)
        }

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CarsAdapter()
        recyclerView.adapter = adapter
        adapter.setOnCarClickListener(this)
        adapter.submitList(allCars)

        val searchEditText = binding.searchEditText

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val searchText = s.toString().trim()

                val filteredCars = allCars.filter { car ->
                    car.name.contains(searchText, ignoreCase = true)
                }

                adapter.submitList(filteredCars)
            }
        })
    }

    override fun onCarClick(car: Car) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra("car", car)
        startActivity(intent)
    }
}
