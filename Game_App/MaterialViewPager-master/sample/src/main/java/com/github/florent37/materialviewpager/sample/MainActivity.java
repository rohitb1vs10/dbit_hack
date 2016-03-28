package com.github.florent37.materialviewpager.sample;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.github.florent37.materialviewpager.sample.fragment.CarpaccioRecyclerViewFragment;
import com.github.florent37.materialviewpager.sample.fragment.Friends;
import com.github.florent37.materialviewpager.sample.fragment.LeaderboardFragment;
import com.github.florent37.materialviewpager.sample.fragment.MypointsFragment;
import com.github.florent37.materialviewpager.sample.fragment.RecyclerViewFragment;
import com.github.florent37.materialviewpager.sample.fragment.ScrollFragment;
import com.github.florent37.materialviewpager.sample.fragment.TrialFragment;
import com.github.florent37.materialviewpager.sample.fragment.WebViewFragment;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    public int myNum=0;
    public String username;
    public String usernameF;

    public String s;
    public int myNum1;
    int[] usagelm = new int[1000];
    String[] usagelmn = new String[1000];

    private EditText editTextFriendName;
    private MaterialViewPager mViewPager;

    //private DrawerLayout mDrawer;
    //private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;

       public void friendDekho(View view){
        editTextFriendName = (EditText) findViewById(R.id.textVie8w);
        usernameF = editTextFriendName.getText().toString();
        friendDetail(usernameF);}

    public void naamDekho() {
        //editTextFriendName = (EditText) findViewById(R.id.textVie8w);
        //usernameF = editTextFriendName.getText().toString();
        naamDetail(username);

    }
    public void scoreDekho() {
        //editTextFriendName = (EditText) findViewById(R.id.textVie8w);
        //usernameF = editTextFriendName.getText().toString();
        scoreDetail(username);

    }


    private void friendDetail(final String username) {

        class LoginAsync extends AsyncTask<String, Void, String> {

            //private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loadingDialog = ProgressDialog.show(MainActivity.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                //String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                //nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://2minutetechread.2fh.co/readfriend.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                //loadingDialog.dismiss();
                if(s.equalsIgnoreCase("failure")){

                    //Toast.makeText(getApplicationContext(), "baaaddddd", Toast.LENGTH_LONG).show();
                }else {
                    String usageF=s;
                    //Toast.makeText(getApplicationContext(), usageF , Toast.LENGTH_LONG).show();

                    TextView textView = (TextView) findViewById(R.id.textView9);

                    textView.setText(usageF);

                }
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(username);

    }

    private void naamDetail(final String username) {

        class LoginAsync extends AsyncTask<String, Void, String> {

            //private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loadingDialog = ProgressDialog.show(MainActivity.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                //String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                //nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://2minutetechread.2fh.co/readlbn.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                //loadingDialog.dismiss();
                if(s.equalsIgnoreCase("failure")){

                    //Toast.makeText(getApplicationContext(), "baaaddddd", Toast.LENGTH_LONG).show();
                }else {
                    String usageF=s;
                    //Toast.makeText(getApplicationContext(), usageF , Toast.LENGTH_LONG).show();

                    TextView textView = (TextView) findViewById(R.id.textView6);

                    textView.setText(usageF);

                }
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(username);

    }

    private void scoreDetail(final String username)

    {

        class LoginAsync extends AsyncTask<String, Void, String> {

            //private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loadingDialog = ProgressDialog.show(MainActivity.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                //String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                //nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://2minutetechread.2fh.co/read.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                //loadingDialog.dismiss();
                if(s.equalsIgnoreCase("failure")){

                    //Toast.makeText(getApplicationContext(), "baaaddddd", Toast.LENGTH_LONG).show();
                }else {
                    String usageF=s;
                    //Toast.makeText(getApplicationContext(), usageF , Toast.LENGTH_LONG).show();

                    TextView textView = (TextView) findViewById(R.id.textView7);

                    textView.setText(usageF);

                }
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(username);

    }

    public void invokeData(){
        for(int k=0 ; k<2 ; k++) {
            myNum1=1;
            username = Integer.toString(myNum1);
            viewData(username);
            viewName(username);
            myNum1 = myNum1 + 1;
            username = Integer.toString(myNum1);
        }
        myNum1=1;
        username = Integer.toString(myNum1);


    }
    private void viewName(final String username) {

        class LoginAsync extends AsyncTask<String, Void, String> {

            //private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loadingDialog = ProgressDialog.show(Main3Activity.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                //String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                //nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://2minutetechread.2fh.co/readlbn.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                s = result.trim();
                //loadingDialog.dismiss();
                if(s.equalsIgnoreCase("failure")){

                    //Toast.makeText(getApplicationContext(), "bhlhluj;", Toast.LENGTH_LONG).show();
                }else {
                    usagelmn[myNum1-1]=s;
                    //Toast.makeText(getApplicationContext(), usagelmn[myNum1-1] , Toast.LENGTH_LONG).show();


                }
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(username);

    }


    private void viewData(final String username) {

        class LoginAsync extends AsyncTask<String, Void, String> {

            //private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loadingDialog = ProgressDialog.show(Main3Activity.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                //String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                //nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://2minutetechread.2fh.co/read.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                s = result.trim();
                //loadingDialog.dismiss();
                if(s.equalsIgnoreCase("failure")){

                    Toast.makeText(getApplicationContext(), "hfvjnn", Toast.LENGTH_LONG).show();
                }else {
                    usagelm[myNum1-1]=Integer.parseInt(s);;
                    Toast.makeText(getApplicationContext(), s , Toast.LENGTH_LONG).show();


                }
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(username);

    }
    private void sortLeaderBoard()
    {
        for(int g=0 ; g<2 ; g++)
            for(int y=0 ;y<1 ; y++) {
                if (usagelm[y] < usagelm[y + 1]) {
                    int temp = usagelm[y];
                    usagelm[y] = usagelm[y + 1];
                    usagelm[y + 1] = temp;
                    String tempn = usagelmn[y];
                    usagelmn[y] = usagelmn[y + 1];
                    usagelmn[y + 1] = tempn;
                }
            }

        TextView textView = (TextView) findViewById(R.id.textView14);
        textView.setText("Saurabh");
        TextView textView1 = (TextView) findViewById(R.id.textView15);
        textView1.setText("110");
        TextView textView2 = (TextView) findViewById(R.id.textViewh2);
        textView2.setText("Jay");
        TextView textView3 = (TextView) findViewById(R.id.textViewh3);
        textView3.setText("133");
        TextView textView4 = (TextView) findViewById(R.id.textViewh4);
        textView4.setText("Tanay");
        TextView textView5 = (TextView) findViewById(R.id.textViewh5);
        textView5.setText("150");
        TextView textView6 = (TextView) findViewById(R.id.textViewh6);
        textView6.setText("Amit");
        TextView textView7 = (TextView) findViewById(R.id.textViewh66);
        textView7.setText("157");
        TextView textView8 = (TextView) findViewById(R.id.textViewh7);
        textView8.setText("Rohit");
        TextView textView9 = (TextView) findViewById(R.id.textViewh77);
        textView9.setText("160");
        TextView textView10 = (TextView) findViewById(R.id.textViewh8);
        textView10.setText("Sachin");
        TextView textView11 = (TextView) findViewById(R.id.textView88);
        textView11.setText("197");
        TextView textView12 = (TextView) findViewById(R.id.textViewh9);
        textView12.setText("Awadhut");
        TextView textView13 = (TextView) findViewById(R.id.textViewh99);
        textView13.setText("280");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        username = intent.getStringExtra(Main2Activity.USER_NAME);
        myNum= Integer.parseInt(username);
        editTextFriendName = (EditText) findViewById(R.id.textVie8w);
        TextView textView = (TextView) findViewById(R.id.textView3);
        naamDekho();
        scoreDekho();
       // invokeData();
        //sortLeaderBoard();

        if (!BuildConfig.DEBUG)
            Fabric.with(this, new Crashlytics());

        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
        //mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }

       // mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
       // mDrawer.setDrawerListener(mDrawerToggle);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 6) {
                    case 0:
                        return TrialFragment.newInstance();
                    case 1:
                        return Friends.newInstance();
                    case 2:
                        return LeaderboardFragment.newInstance();
                    case 3:
                        return MypointsFragment.newInstance();
                    case 4:
                        return WebViewFragment.newInstance();
                    default:
                            return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 6) {
                    case 0:
                        return "Pre-Paid";
                    case 1:
                        return "Vs Friends";
                    case 2:
                        return "Leader Baord";
                    case 3:
                        return "My Points";
                    case 4:
                        return "News";
                    case 5:
                        return "Notifications";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "https://lh5.ggpht.com/GJO-iHaNMuP5z8IQs6CMrL2NPGJ2DyQ3BGSLY54jlhE7dQ5SQ-jgAAOiRZaVuc8wHg=h900");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn.desktopwallpapers4.me/media/thumbs_400x250/3/20848.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://static.comicvine.com/uploads/original/2/22062/3422148-game-of-thrones-crown.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://addicted2success.com/wp-content/uploads/2011/12/if-you-can-believe-you-can-achieve.png");
                    case 4:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://p1.pichost.me/i/69/1937790.jpg");
                    case 5:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://p1.pichost.me/i/69/1937790.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null)
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //mDrawerToggle.syncState();
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return mDrawerToggle.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }*/
}
