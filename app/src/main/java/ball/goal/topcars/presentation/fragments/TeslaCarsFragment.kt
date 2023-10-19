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
import ball.goal.topcars.databinding.FragmentTeslaCarsBinding
import ball.goal.topcars.presentation.DetailActivity
import ball.goal.topcars.presentation.models.Car
import ball.goal.topcars.viewmodels.DataViewModel
import ball.goal.topcars.viewmodels.DataViewModelFactory

class TeslaCarsFragment : Fragment(), CarsAdapter.OnCarClickListener {
    private lateinit var binding: FragmentTeslaCarsBinding
    private lateinit var viewModel: DataViewModel
    private lateinit var adapter: CarsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeslaCarsBinding.inflate(inflater, container, false)
        val viewModelFactory = DataViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val allTeslaCars = viewModel.carsData[0].carsList

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CarsAdapter()
        recyclerView.adapter = adapter
        adapter.setOnCarClickListener(this)
        adapter.submitList(allTeslaCars)

        val searchEditText = binding.searchEditText
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val searchText = s.toString().trim()
                val filteredTeslaCars = if (searchText.isEmpty()) {
                    allTeslaCars
                } else {
                    allTeslaCars.filter { car ->
                        car.name.contains(searchText, ignoreCase = true)
                    }
                }
                adapter.submitList(filteredTeslaCars)
            }
        })
    }

    override fun onCarClick(car: Car) {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra("car", car)
        startActivity(intent)
    }
}