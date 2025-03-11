package com.example.focusapp2.ui.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import com.example.focusapp2.databinding.FragmentFocusBinding
import java.text.DecimalFormat
import java.text.NumberFormat


class FocusFragment : Fragment() {

    val stepSize = 5
    private var isAppInBg =false
    private var time :Int =2
    private lateinit var binding: FragmentFocusBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFocusBinding.inflate(inflater,container,false)

        binding.seekBarTime.setOnSeekBarChangeListener(object :OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val f: NumberFormat = DecimalFormat("00")
                binding.txtTime.setText(f.format(p1*stepSize+10)+":"+"00")
                time = stepSize*p1 +10

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })

        binding.button2.setOnClickListener(){

            binding.seekBarTime.visibility = View.INVISIBLE
            val t = getTimeValue()
            object: CountDownTimer((t*60000).toLong(),1000){
                override fun onTick(p0: Long) {
                    val f = DecimalFormat("00")

                    val min = (p0 / 60000) % 60
                    val sec = (p0 / 1000) % 60

                    binding.txtTime.setText(f.format(min)+":"+f.format(sec))

                    val remainingTime = p0 / 1000
                    val progressValue = ((remainingTime.toFloat() / (t*60000 / 1000)) * 100).toInt()
                    binding.progressBar.progress = progressValue
                }

                override fun onFinish() {
                    binding.txtTime.setText("00:00")
                }


            }.start()



        }

        return binding.root
    }
    fun getTimeValue(): Int {
        return time
    }

    override fun onPause() {
        super.onPause()
        isAppInBg = true
    }

    override fun onResume() {
        super.onResume()
        if(isAppInBg){
            decreaseHp()
        }
    }

    private fun decreaseHp() {
        if(binding.progressBar2.progress>0 && !(binding.txtTime.equals("00:00"))){
            binding.progressBar2.progress-=10

        }
    }


}