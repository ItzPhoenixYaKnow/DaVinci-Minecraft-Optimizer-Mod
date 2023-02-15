package com.bolt.fix-lighting-mod.api.main;

import okhttp3.*
import requests
import java.io.IOException


// Gathers important info from the mojang api (Name and UUID of the player) and uses it for code management
def get_minecraft_account_info(username):
    url = "https://api.mojang.com/users/profiles/minecraft/" + username
    response = requests.get(url)
    if response.status_code == 200:
        return response.json()
    else:
        return None

// Makes a request to the mojang api to retrieve a dataset        
fun main() {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://api.example.com/data.json")
        .build()
    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("Request failed")
        }
        override fun onResponse(call: Call, response: Response) {
            val jsonData = response.body?.string()
            println(jsonData)
        }
    })
}

// Logs to your pc when a json request has been completed successfully
fun logging() {
    val client = OkHttpClient.Builder()
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request()
                println("Making JSON request: ${request.url()}")
                val response = chain.proceed(request)
                println("JSON request completed")
                return response
            }
        })
        .build()

    val request = Request.Builder()
        .url("https://api.example.com/data.json")
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("Request failed")
        }
        override fun onResponse(call: Call, response: Response) {
            val jsonData = response.body?.string()
            println(jsonData)
        }
    })
}