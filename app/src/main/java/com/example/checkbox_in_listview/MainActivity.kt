package com.example.checkbox_in_listview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.checkbox_in_listview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personArrayList: ArrayList<PersonDataClass>

    private var hashMap: MutableMap<Int, Any> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personName = arrayOf(
            "Ali", "Hamza", "Hammad", "Ahamad", "Shakeeb", "Baber", "Rehman", "Raffay", "Abdul"
        )
        val personDesignation = arrayOf(
            "Android Developer", "Software Developer", "Python Developer", "Node JS Developer",
            "DB Developer", "Website Developer", "Developer", "Assistant", "Quality Assurance"
        )
        personArrayList = ArrayList()

        for (i in personName.indices){
            hashMap[i] = isOdd(i)
            val person = PersonDataClass(personName[i], personDesignation[i], true)
            personArrayList.add(person)
        }
        Log.e("Tag", "map $hashMap")

        binding.listView.isClickable = true
        binding.listView.adapter = PersonAdapterClass(this, personArrayList, hashMap)
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val personName = personName[position]
            val personDesignation = personDesignation[position]
        }

        }

    private fun isOdd(`val`: Int): Boolean {
        return `val` and 0x01 == 0

    }
}
