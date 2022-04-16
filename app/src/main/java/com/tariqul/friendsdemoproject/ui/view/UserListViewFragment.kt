package com.tariqul.friendsdemoproject.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.tariqul.friendsdemoproject.R
import com.tariqul.friendsdemoproject.databinding.FragmentUserListBinding
import com.tariqul.friendsdemoproject.ui.uistate.UsersFragmentUIState
import com.tariqul.friendsdemoproject.ui.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject


@AndroidEntryPoint
class UserListViewFragment : Fragment(R.layout.fragment_user_list){

    private lateinit var binding: FragmentUserListBinding
    private val viewModel: UsersViewModel by viewModels()

    @Inject
    lateinit var adapter: UsersListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserListBinding.bind(view)

        setUI()

    }

    private fun setUI(){
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.apply {
                delay(1000)
                getHomeData()
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                    userFragmentUIState.collect{
                        handleUsersUiState(it)
                    }
                }
            }
        }
    }

    private fun handleUsersUiState(uiState: UsersFragmentUIState){
        uiState.apply {

            binding.recyclerView.layoutManager = GridLayoutManager(context,2)

            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            adapter.submitList(uiState.usersDataModel)
            binding.recyclerView.adapter = adapter


            adapter.clickListener.onItemClick = {
                val direction = UserListViewFragmentDirections.actionUsersToUserDetails(it)
                findNavController().navigate(direction)
            }
        }
    }


}