package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener()
        {
            var basic: Int = 0
            var extra: Int = 0
            var total = 0
            //Get age group
            val age = binding.spinnerAge.selectedItemPosition
            when (age) {
                0 //age less than 17
                -> {
                    basic = 60
                }
                1 -> {
                    basic = 70
                }
                2 -> {
                    basic = 90
                }
                3 -> {
                    basic = 120
                }
                4 -> {
                    basic = 150
                }
                else -> basic = 150
            }
            //Get the gender
            val gender = binding.radioGroupGender.checkedRadioButtonId
            if (gender == binding.radioButtonMale.id) {
                //Calculate extra premium for male
                when (age) {
                    0 //age less than 17
                    -> {
                        extra += 0
                    }
                    1 -> {
                        extra += 50
                    }
                    2 -> {
                        extra += 100
                    }
                    3 -> {
                        extra += 150
                    }
                    4 -> {
                        extra += 200
                    }
                    else -> extra += 200
                }
            }
            //Get the smoker status
            val smoker = binding.checkBoxSmoker.isChecked
            if (smoker) {
                //Calculate extra premium for smoker
                when (age) {
                    0 //age less than 17
                    -> {
                        extra += 0
                    }
                    1 -> {
                        extra += 100
                    }
                    2 -> {
                        extra += 150
                    }
                    3 -> {
                        extra += 200
                    }
                    4 -> {
                        extra += 250
                    }
                    else -> extra += 300
                }
            }
            total = basic + extra
            binding.myPremium = Premium(basic, extra, total)
        }

        binding.buttonReset.setOnClickListener()
        {
            binding.myPremium = Premium()
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
        }
    }
}