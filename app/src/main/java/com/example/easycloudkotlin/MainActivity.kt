package com.example.easycloudkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.easycloudkotlin.databinding.ActivityMainBinding
import com.example.easycloudkotlin.http.LoginService
import com.example.easycloudkotlin.http.ServiceCreator
import com.google.android.material.textfield.TextInputEditText
import com.yatoooon.screenadaptation.ScreenAdapterTools
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ScreenAdapterTools.getInstance().loadView(window.decorView)
        binding.btLogin.setOnClickListener {
            Log.d(TAG, "onCreate: 点击了按钮")
        }
        binding.btGetCode.setOnClickListener {
            val service = ServiceCreator.create<LoginService>()
            service.getCaptchaRequest("15330026521",5).enqueue(object :Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    Log.d("MainActivity", "$response")

                }
                override fun onFailure(
                    call: Call<ResponseBody>,
                    t: Throwable
                ) {
                    Log.d(TAG, "onFailure: 到了这里")
                }
            })
            Log.d(TAG, "onCreate: 获取到的电话是：${binding.phoneNum.text}")
        }
    }
}