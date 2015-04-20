package com.cardboard.photosphere;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.cardboard.photosphere.ParallaxScollListView;
import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

/*
TODO
1. Stack activities for going back
2. Set header image on panaromic list
3. Oncardboard trigger to go next activity
 */

public class ParallaxActivity extends Activity {

    private ParallaxScollListView mListView;
    private ImageView mImageView;

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax);

        mListView = (ParallaxScollListView) findViewById(R.id.layout_listview);
        View header = LayoutInflater.from(this).inflate(R.layout.listview_header, null);
        mImageView = (ImageView) header.findViewById(R.id.layout_header_image);

        mListView.setParallaxImageView(mImageView);
        mListView.addHeaderView(header);

//        app_id:
//        IBM-Application_Secret:
//        classname: panaromas
//        start:0
//        end:<end>

        //Hardcoded
//        int end = 4;
//        String abc= "Aki";
//
//        try {
//            HttpClient client = new DefaultHttpClient();
//            String getURL = "https://mobile.eu-gb.bluemix.net:443/data/rest/v1/apps/15133dba-d68f-4217-98e0-c691a7f4e0ed/objects?classname=panaromas&start=0&num=4";
//
//
//            HttpGet get = new HttpGet(getURL);
//            get.setHeader("app_id", "15133dba-d68f-4217-98e0-c691a7f4e0ed");
//            get.setHeader("IBM-Application_Secret", "442d6c24d952981b63a8b42759a2914f0597c5ea");
//            get.setHeader("classname", "panoramas");
//            get.setHeader("start", "0");
//            get.setHeader("end", "4");
//
//            JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
//
//
//            HttpResponse responseGet = client.execute(get);
//            HttpEntity resEntityGet = responseGet.getEntity();
//            System.out.println(resEntityGet.toString());
//            abc = resEntityGet.toString();
//
//            if (resEntityGet != null) {
//                //do something with the response
//                Log.i("GET ", EntityUtils.toString(resEntityGet));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        final String opt1="Mojave";
        final String opt2="Alexander Hills";
        final String opt3="Amargosa Valley";
        final String opt4="Chinle";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,
                new String[]{
                        opt1,
                        opt2,
                        opt3,
                        opt4
                }
        );
        mListView.setAdapter(adapter);
        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = mListView.getItemAtPosition(position);


                if(o.toString().compareTo(opt1)==0){
                    Intent intent = new Intent(ParallaxActivity.this, VRActivity.class);
                    intent.putExtra("mychoice",0);
                    startActivity(intent);
                    finish();
                }
                if(o.toString().compareTo(opt2)==0){
                    Intent intent = new Intent(ParallaxActivity.this, VRActivity.class);
                    intent.putExtra("mychoice",1);
                    startActivity(intent);
                    finish();
                }
                if(o.toString().compareTo(opt3)==0){
                    Intent intent = new Intent(ParallaxActivity.this, VRActivity.class);
                    intent.putExtra("mychoice",2);
                    startActivity(intent);
                    finish();
                }
                if(o.toString().compareTo(opt4)==0){
                    Intent intent = new Intent(ParallaxActivity.this, VRActivity.class);
                    intent.putExtra("mychoice",3);
                    startActivity(intent);
                    finish();
                }

    /* write you handling code like...
    String st = "sdcard/";
    File f = new File(st+o.toString());
    // do whatever u want to do with 'f' File object
    */
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.parallax, menu);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            mListView.setViewsBounds(ParallaxScollListView.ZOOM_X2);
        }
    }



}
