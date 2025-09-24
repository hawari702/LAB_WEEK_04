package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView       // ✅ PENTING: tambahkan import ini
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    // ✅ Gunakan lazy findViewById dengan 'view?.findViewById' atau binding
    private val coffeeTitle: TextView?
        get() = view?.findViewById(R.id.coffee_title)
    private val coffeeDesc: TextView?
        get() = view?.findViewById(R.id.coffee_desc)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ Ambil data ID dari arguments
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)
    }

    // ✅ Isi data berdasarkan ID
    private fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text = getString(R.string.latte_desc)
            }
        }
    }

    companion object {
        // ✅ Factory method agar mudah membuat instance fragment dengan argument
        fun newInstance(coffeeId: Int): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putInt(COFFEE_ID, coffeeId)
            fragment.arguments = bundle
            return fragment
        }
    }
}

// ✅ Simpan constant di luar class
private const val COFFEE_ID = "COFFEE_ID"
