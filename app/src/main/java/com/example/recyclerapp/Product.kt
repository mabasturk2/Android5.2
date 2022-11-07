package com.example.recyclerapp

import java.io.Serializable

data class Product(val title: String,val price:Double, val color:String, val image: Int,val itemid: String,val desc: String,): Serializable

/*
class Product{
String Title;
double price;
String color;
String image; // name of the image
String itemid;
String desc; // Description of the product
}
 */