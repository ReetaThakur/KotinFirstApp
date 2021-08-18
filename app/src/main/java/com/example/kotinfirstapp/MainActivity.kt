package com.example.kotinfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var responseDTO:ResponseDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPost.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient=Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getPosts(etPostId.text.toString().toInt())
            .enqueue(object: Callback<ResponseDTO>{
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    responseDTO= response.body()!!
                    setRecyclerView()

                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

    private fun setRecyclerView() {
        val postAdapter=PostAdapter(responseDTO)
        val liearLayoutManager=LinearLayoutManager(this)
        recyclerView.adapter=postAdapter
        recyclerView.layoutManager=liearLayoutManager
    }
}
