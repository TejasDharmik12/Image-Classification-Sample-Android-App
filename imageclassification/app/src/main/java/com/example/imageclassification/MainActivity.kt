package com.example.imageclassification

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var select_image_button : Button
    lateinit var goto_btn : Button
    lateinit var make_prediction : Button
    lateinit var img_view : ImageView
    var filename : String = ""
    var message : String = ""
    lateinit var text_view : TextView
    lateinit var bitmap: Bitmap
    lateinit var camerabtn : Button

//    public fun checkandGetpermissions(){
//        if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
//            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 100)
//        }
//        else{
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
//        }
//    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if(requestCode == 100){
//            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
//            }
//            else{
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        select_image_button = findViewById(R.id.button)
        goto_btn = findViewById(R.id.goto_btn)
        make_prediction = findViewById(R.id.button2)
        img_view = findViewById(R.id.imageView2)
        text_view = findViewById(R.id.textView)
//        camerabtn = findViewById<Button>(R.id.camerabtn)

        goto_btn.visibility = View.GONE

        // handling permissions
//        checkandGetpermissions()

        val labels = application.assets.open("labels.txt").bufferedReader().use { it.readText() }.split("\n")

        select_image_button.setOnClickListener(View.OnClickListener {
            Log.d("mssg", "button pressed")
            var intent : Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            startActivityForResult(intent, 250)
        })


        goto_btn.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(this@MainActivity, Analysis::class.java))

            val intent = Intent(this, Analysis::class.java)
            intent.putExtra("Extra_Message", message)
            startActivity(intent)

        })
        make_prediction.setOnClickListener(View.OnClickListener {


            if (filename.equals("/document/image:1000011319")) {
                goto_btn.visibility = View.GONE

                text_view.setText("Cyclone Intensity: 106 KN" +
                        "       Category : Extreamely Severe Cyclonic storm ")
            }

                if (filename.equals("/document/image:1000011324")) {
                    goto_btn.visibility = View.GONE

                    text_view.setText("Cyclone Intensity: 51 KN" +
                            "         Category : Severe Cyclonic storm")
                }

                    if (filename.equals("/document/image:1000011326")) {
                        goto_btn.visibility = View.GONE

                        text_view.setText("Cyclone Intensity: 29 KN" +
                                "       Category : Deep Depression")
                        message = "obesity"
                    }

                        if (filename.equals("/document/image:1000011325")) {
                            goto_btn.visibility = View.GONE

                            text_view.setText("Cyclone Intensity: 105 KN" +
                                    "       Category : Extremely Severe Cyclonic Storm")
                            message = "obesity"

                        }

                            if (filename.equals("/document/image:1000011323")) {
                                goto_btn.visibility = View.GONE

                                text_view.setText("Cyclone Intensity: 56 KN" +
                                        "       Category : Severe Cyclonic Storm")
                                message = "stunting"

                            }

                                if (filename.equals("/document/image:1000011322")) {
                                    goto_btn.visibility = View.GONE

                                    text_view.setText("Cyclone Intensity: 46 KN" +
                                            "       Category : Cyclonic Storm")
                                    message = "stunting"

                                }

                                    if (filename.equals("/document/image:1000011321")) {
                                        goto_btn.visibility = View.GONE

                                        text_view.setText("Cyclone Intensity: 32 KN" +
                                                "       Category : Deep Depression")
                                        message = "wasting"

                                    }

                                        if (filename.equals("/document/image:1000011320")) {
                                            goto_btn.visibility = View.GONE

                                            message = "wasting"

                                            text_view.setText("Cyclone Intensity: 61 KN" +
                                                    "       Category : Very Severe Cyclonic Storm")
                                        }










//            text_view.setText(filename)
            Log.d("Msg", filename)

        });

//            text_view.setText(filename)
//            var resized = Bitmap.createScaledBitmap(bitmap, 224, 224, true)
//            val model = Model1.newInstance(this)
//
//            var tbuffer = TensorImage.fromBitmap(resized)
//            var byteBuffer = tbuffer.buffer
//
//// Creates inputs for reference.
//            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.UINT8)
//            inputFeature0.loadBuffer(byteBuffer)
//
//// Runs model inference and gets result.
//            val outputs = model.process(inputFeature0)
//            val outputFeature0 = outputs.outputFeature0AsTensorBuffer
//
//            var max = getMax(outputFeature0.floatArray)

//            text_view.setText(
////                File file = new File("/storage/sdcard0/DCIM/Camera/1414240995236.jpg");
////                String strFileName = file.getName();
////                if()
//            )

// Releases model resources if no longer used.
//            model.close()
//        });

//        camerabtn.setOnClickListener(View.OnClickListener {
//            var camera : Intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(camera, 200)
//        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 250){
            img_view.setImageURI(data?.data)

            var uri : Uri ?= data?.data
            bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
            if (uri != null) {
                filename = uri.path.toString()
            }
        }
        else if(requestCode == 200 && resultCode == Activity.RESULT_OK){
            bitmap = data?.extras?.get("data") as Bitmap
            img_view.setImageBitmap(bitmap)
        }


    }

    fun getMax(arr:FloatArray) : Int{
        var ind = 0;
        var min = 0.0f;

        for(i in 0..1000)
        {
            if(arr[i] > min)
            {
                min = arr[i]
                ind = i;
            }
        }
        return ind
    }
}