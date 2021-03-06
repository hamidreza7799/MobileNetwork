package com.example.mobilenetworkproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilenetworkproject.R


interface RecyclerViewClickListener {
    fun recyclerViewListClicked(v: View?, position: Int)
}
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerTouristPlace: RecyclerView = root.findViewById(R.id.recycler_tourist_place)

        homeViewModel.touristPlacesModel.observe(viewLifecycleOwner, Observer { touristPlaces ->
            recyclerTouristPlace.adapter = TouristPlaceAdapter(touristPlaces, this.findNavController())
        })
        return root
    }
}