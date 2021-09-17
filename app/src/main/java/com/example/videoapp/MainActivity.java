package com.example.videoapp;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;

// When you extend an existing Java class (such as the AppCompatActivity class), you create a new class with the existing class’s functionality.
public class MainActivity extends AppCompatActivity {


    @SuppressLint("SetJavaScriptEnabled")

    @Override //The @Override annotation indicates that the child class method is over-writing its base class method. It can improve the readability of the source code
    // In particular, the onCreate method calls setContentView(R.layout.activity_main), which displays the material described in the res/layout/activity_main.xml file
    // Start a android lifecycle activity . Protected is access modifier, when you want the child class to see the fields / methods of the super class
    protected void onCreate(Bundle savedInstanceState) {
        //  A call to super.onCreate(savedInstanceState) helps bring things back to the way they were before Android destroyed the activity.
        super.onCreate(savedInstanceState);
        // It helps to set our content or render our layout on the screen. To access activity_main.xml in /res/layout
        setContentView(R.layout.activity_main);
        //to capture a frame from video in android
        //Load flash files into web view
        String frameVideo = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/gvyUuxdRdR4\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        //A view created this way will be inflated (instantiated) by Android upon a user’s call to setContentView() API. You can obtain handle to the WebView as you do with other views using the findViewById() API
        //In order to use web view, you have to get a reference of this view in Java file. To get a reference, create an object of the class WebView
        WebView displayYoutubeVideo = findViewById(R.id.mWebView);
        //When the user clicks a link from a web page in your WebView, the default behavior is for Android to launch an application that handles URLs
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            //Give the host application a chance to take over the control when a new url is about to be loaded in the current WebView
            //Now when the user clicks a link, the system calls shouldOverrideUrlLoading(), which checks whether the URL host matches a specific domain (as defined above).
            // If it does match, then the method returns false in order to not override the URL loading
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        //JavaScript is disabled in a WebView by default. You can enable it through the WebSettings attached to your WebView.
        // You can retrieve WebSettings with getSettings(), then enable JavaScript with setJavaScriptEnabled().
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);//try in false case
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

