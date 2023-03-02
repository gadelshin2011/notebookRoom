package com.example.notebookroom.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notebookroom.APP
import com.example.notebookroom.R
import com.example.notebookroom.adapter.NoteAdapter
import com.example.notebookroom.databinding.FragmentStartBinding
import com.example.notebookroom.model.NoteModel


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNote ->
            adapter.setList(listNote.asReversed())
        }
        binding.btnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)

            APP.navController.navigate(R.id.action_startFragment_to_detailFragment3, bundle)
        }
    }


}