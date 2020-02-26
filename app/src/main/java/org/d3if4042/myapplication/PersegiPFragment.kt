package org.d3if4042.myapplication


import android.app.Activity
import android.content.ActivityNotFoundException
import android.os.Bundle
import android.os.SharedMemory
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegip.*
import org.d3if4042.myapplication.databinding.FragmentPersegipBinding

/**
 * A simple [Fragment] subclass.
 */
class PersegiPFragment : Fragment() {

    companion object {
        var P = 0
        var L = 0
        var Luas = 0
        var Keliling = 0
        var keyLuas = "1"
        var keyKel = "2"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPersegipBinding>(inflater, R.layout.fragment_persegip,container, false)
        if (savedInstanceState != null) {
            Luas = savedInstanceState.getInt(keyLuas)
            Keliling = savedInstanceState.getInt(keyKel)
            binding.tvLuaspp.setText(Luas.toString())
            binding.tvKelpp.setText(Keliling.toString())
        }
        binding.btnHasilP.setOnClickListener {
            P = panjang.text.toString().toInt()
            L = lebar.text.toString().toInt()
            Luas = P * L
            Keliling = 2*(P+L)
            tvLuaspp.setText(Luas.toString())
            tvKelpp.setText(Keliling.toString())
        }
        binding.btnshare.setOnClickListener {
            val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setType("text/plain")
                .setText(getString(R.string.share_PP, P,L, Luas, Keliling))
                .intent
                try {
                    startActivity(shareIntent)
                }catch (ex: ActivityNotFoundException){
                    Toast.makeText(context, "Share Tidak DiTemukan", Toast.LENGTH_LONG).show()
                }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(keyLuas, Luas)
        outState.putInt(keyKel, Keliling)
        super.onSaveInstanceState(outState)
    }


}
