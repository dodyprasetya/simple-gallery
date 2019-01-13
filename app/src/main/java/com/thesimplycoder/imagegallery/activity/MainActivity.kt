package com.thesimplycoder.imagegallery.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.thesimplycoder.imagegallery.R
import com.thesimplycoder.imagegallery.adapter.GalleryImageAdapter
import com.thesimplycoder.imagegallery.adapter.GalleryImageClickListener
import com.thesimplycoder.imagegallery.adapter.Image
import com.thesimplycoder.imagegallery.fragment.GalleryFullscreenFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GalleryImageClickListener {

    // gallery column count
    private val SPAN_COUNT = 2

    private val imageList = ArrayList<Image>()
    lateinit var galleryAdapter: GalleryImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init adapter
        galleryAdapter = GalleryImageAdapter(imageList)
        galleryAdapter.listener = this

        // init recyclerview
        recyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        recyclerView.adapter = galleryAdapter

        // load images
        loadImages()
    }

    private fun loadImages() {

        imageList.add(Image("https://i.ibb.co/wBYDxLq/beach.jpg", "Beach Houses"))
        imageList.add(Image("https://i.ibb.co/gM5NNJX/butterfly.jpg", "Butterfly"))
        imageList.add(Image("https://i.ibb.co/10fFGkZ/car-race.jpg", "Car Racing"))
        imageList.add(Image("https://i.ibb.co/ygqHsHV/coffee-milk.jpg", "Coffee with Milk"))
        imageList.add(Image("https://i.ibb.co/7XqwsLw/fox.jpg", "Fox"))
        imageList.add(Image("https://i.ibb.co/L1m1NxP/girl.jpg", "Mountain Girl"))
        imageList.add(Image("https://i.ibb.co/wc9rSgw/desserts.jpg", "Desserts Table"))
        imageList.add(Image("https://i.ibb.co/wdrdpKC/kitten.jpg", "Kitten"))
        imageList.add(Image("https://i.ibb.co/dBCHzXQ/paris.jpg", "Paris Eiffel"))
        imageList.add(Image("https://i.ibb.co/JKB0KPk/pizza.jpg", "Pizza Time"))
        imageList.add(Image("https://i.ibb.co/VYYPZGk/salmon.jpg", "Salmon "))
        imageList.add(Image("https://i.ibb.co/JvWpzYC/sunset.jpg", "Sunset in Beach"))

        galleryAdapter.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {
        // handle click of image

        val bundle = Bundle()
        bundle.putSerializable("images", imageList)
        bundle.putInt("position", position)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val galleryFragment = GalleryFullscreenFragment()
        galleryFragment.setArguments(bundle)
        galleryFragment.show(fragmentTransaction, "gallery")
    }
}
