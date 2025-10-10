package com.example.jpmchase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class MainFragment : Fragment() {


    //when userrepo obj is required, hilt will search in constructor,
    //search for fragmentComponent -- ActivityComponent--SingletonComponent
    @Inject
    @Named("firebase")
    lateinit var userRepository: UserRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       userRepository.saveUser("abdul@mail.com","1234")

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}