package com.example.arispanayiotou.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.arispanayiotou.kotlin.adapter.MovieAdapter
import com.example.arispanayiotou.kotlin.models.PeopleKotlin
import kotlinx.android.synthetic.main.activity_main.*
import com.example.arispanayiotou.kotlin.models.MovieObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), Callback<MovieObject> {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        collections()
        doRequest()
    }

    private fun doRequest() {


        /*Create handle for the RetrofitInstance interface*/


        val service = RetrofitClientInstance.getRetrofitInstance().create(GetMovies::class.java)
        val call = service.getMovie("captain")
        call.enqueue(this)

    }

    override fun onFailure(call: Call<MovieObject>, t: Throwable) {
        println("Error," + t.toString())
    }

    override fun onResponse(call: Call<MovieObject>, response: Response<MovieObject>) {


        if (response.isSuccessful) {
            val movie: MutableList<MovieObject> = mutableListOf()
            movie.add(response.body()!!)
            recyclerview.adapter = MovieAdapter(movie)
        }


    }


    private fun collections() {


        val peopleList: MutableList<PeopleKotlin> = mutableListOf()


        peopleList.add(PeopleKotlin(10, "Aris"))
        peopleList.add(PeopleKotlin(11, "Ari"))
        peopleList.add(PeopleKotlin(12, "Ar"))
        peopleList.add(PeopleKotlin(13, "A"))
        peopleList.add(PeopleKotlin(14, "Ar"))
        peopleList.add(PeopleKotlin(15, "Ari"))
        peopleList.add(PeopleKotlin(16, "Aris"))
        peopleList.add(PeopleKotlin(17, "Ari"))
        peopleList.add(PeopleKotlin(18, "Ar"))
        peopleList.add(PeopleKotlin(19, "A"))


//        recyclerview.adapter = MovieAdapter(peopleList)

//
//        println("my mutable list after addition -- ${peopleList.filter { it.age < 13 }}")        // prints "[1, 2, 3, 4]"
//        println(readOnlyView)
//


    }

    private fun main() {
        val a: Int = 10000
        val d: Double = 100.00
        val f: Float = 100.00f
        val l: Long = 1000000004
        val s: Short = 10
        val b: Byte = 1
        val letter: Char
        letter = 'A'
        var rawString: String = "I am Raw String!"
        val escapedString: String = "I am escaped String!\n"

        println("Hello!" + escapedString)
        println("Hey!!" + rawString)
        println("$letter")
        println("Your Int Value is " + a);
        println("Your Double  Value is " + d);
        println("Your Float Value is " + f);
        println("Your Long Value is " + l);
        println("Your Short Value is " + s);
        println("Your Byte Value is " + b);
    }

}



