package com.tariqul.friendsdemoproject.ui.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tariqul.friendsdemoproject.R
import com.tariqul.friendsdemoproject.databinding.FragmentUserDetailsViewBinding
import com.tariqul.friendsdemoproject.util.loadImage

// implemented view binding
class UserDetailsViewFragment : Fragment(R.layout.fragment_user_details_view){

    private val args: UserDetailsViewFragmentArgs by navArgs()
    private lateinit var binding: FragmentUserDetailsViewBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserDetailsViewBinding.bind(view)
        setupView()

    }

    private fun setupView() {

        loadImage(binding.image, args.userData.picture.large)
        binding.name.text = args.userData.name.title + " "+ args.userData.name.first+ " "+ args.userData.name.last
        binding.email.text = args.userData.email
        binding.email.setLinkTextColor(Color.BLUE);
        binding.email.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + args.userData.email))
            intent.putExtra(Intent.EXTRA_SUBJECT, "iOS developer")
            intent.putExtra(Intent.EXTRA_TEXT, "dear sit please check my resium")
            startActivity(intent)
        }
        binding.cellphone.text = args.userData.cell
        binding.country.text = args.userData.location.country

    }

}