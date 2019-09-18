package com.example.droidcafewsettings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.widget.Button;

import static org.hamcrest.CoreMatchers.equalTo;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowToast;

import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

@RunWith(RobolectricTestRunner.class)

public class MainActivityTest {

    private MainActivity activity;
    SharedPreferences sharedPref ;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityIsNotNull() throws Exception {
        assertNotNull(activity);
    }


    @Test
    public void testCase_1() throws Exception {

        ImageView image = (ImageView) activity.findViewById(R.id.froyo);

     image.performClick();
   //  assertEquals("You ordered a FroYo",  R.string.froyo_order_message );
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("You ordered a FroYo."));



    }


   @Test
   public void testCase_2() throws Exception {

       FloatingActionButton button = (FloatingActionButton) activity.findViewById(R.id.fab);
       button.performClick();

        OrderActivity activity1 = Robolectric.buildActivity(OrderActivity.class).create().get();

        Thread.sleep(3000);

       EditText name    = (EditText) activity1.findViewById(R.id.name_text);
       EditText address = (EditText) activity1.findViewById(R.id.address_text);
       EditText phone   = (EditText) activity1.findViewById(R.id.phone_text);

       name.setText("Jasvir");
       address.setText("100 Burrow Road");
       phone.setText("456 789 999");

       assertEquals("Jasvir" , name);
       assertEquals("100 Burrow Road" , address);
       assertEquals("456 789 999" , phone);


       Button button1 = (Button) activity1.findViewById(R.id.saveButton);
       button1.performClick();





  }







}
