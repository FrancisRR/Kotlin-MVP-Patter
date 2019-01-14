package com.francis.kotlinmvp.app

class ApiConstant {
    companion object {

        //https://maps.googleapis.com/maps/api/place/textsearch/json?query=chennai&key=AIzaSyDlWwGHFqX09wrxJREGVqB-GFqCR1oM358
        //https://maps.googleapis.com/maps/api/place/queryautocomplete/json?key=AIzaSyDlWwGHFqX09wrxJREGVqB-GFqCR1oM358&input=pizza

        const val baseUrl = "https://maps.googleapis.com/maps/api/place/"
        const val SEARCHKEY = "textsearch/json"
        const val AUTOCOMPLETE = "queryautocomplete/json"
    }
}