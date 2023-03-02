package com.example.notebookroom.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notebookroom.APP
import com.example.notebookroom.R
import com.example.notebookroom.databinding.FragmentDetailBinding
import com.example.notebookroom.model.NoteModel


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote:NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.twTitleDetail.text = currentNote.title
        binding.tvDescDetail.text = currentNote.description

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment3_to_startFragment)
        }

        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailFragment3_to_startFragment)
        }
    }


}