package com.example.imageclassification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Analysis : AppCompatActivity() {
    lateinit var obesity : TextView
    lateinit var stunting : TextView
    lateinit var wasting : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_analysis)



        obesity = findViewById(R.id.obesity)
        stunting = findViewById(R.id.stunting)
        wasting = findViewById(R.id.wasting)

        var value= intent.getStringExtra("Extra_Message")


        if(value.equals("obesity")) {

            obesity.setText("Obesity")



            stunting.setText(
                "Impact – :--   1. High blood pressure (hypertension)\n" +
                        "                   2. Sleep apnea and breathing problems\n" +
                        "                   3. Body pain and difficulty with physical functioning \n" +
                        "                   4. premature death and substantial disability\n"
            )
            wasting.setText(
                "Treatment- :--   1. need to get at least 150 minutes a week of moderate-intensity physical activity to  prevent further weight gain\n" +
                        "                     2.Replace meals with low-calorie shakes or meal bars\n" +
                        "                     3. eat more plant-based foods, such as fruits, vegetables and whole grains\n" +
                        "                     4. Weight-loss medicines.\n"
            )
        }
        if(value.equals("stunting")) {
            obesity.setText("stunting")
            stunting.setText(
                "" +
                        "Impact :--    1. result of chronic or recurrent undernutrition\n" +
                        "                 2. associated with poverty, poor maternal health and nutrition, \n" +
                        "                 3. frequent illness and/or inappropriate feeding and care in early life. \n" +
                        "                 4. prevents children from reaching their physical and cognitive potential\n"
            )
            wasting.setText(
                "Treatment :--       1. giving vitamin A with adding of zinc\n" +
                        "                   2. giving multiple micronutrient\n" +
                        "                   3. Giving plant source foods (vegetables, fruits, staples), animal source foods (dairy,  eggs, fish, meat), and fortified foods,\n"
            )

        }
        if(value.equals("wasting")) {
            obesity.setText("wasting")
            stunting.setText(
                "" +
                        "Impact :--          1. feeling tired all the time\n" +
                        "                      2.feeling weaker\n" +
                        "                      3. wounds taking a long time to heal\n" +
                        "                      4. Low mood or depression \n"
            )
            wasting.setText(
                "Treatment :--         1. Treated with ready-to-use therapeutic food (RUTF) \n" +
                        "                 2.  powdered milk, peanuts, butter, vegetable oil, sugar, and a mix of vitamins and minerals\n"
            )
        }

//            val textView = findViewById<>(R.id.textView).apply{
//                text = message
//            }


    }

}