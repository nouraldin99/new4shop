package com.noura.anwar.new4shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.luciferldy.viewpagerindicator.ViewPagerIndicator;
import com.noura.anwar.new4shop.Activites.LogAndSignButtum;
import com.noura.anwar.new4shop.Activites.LoginActivity;
import com.noura.anwar.new4shop.Adapter.AboutPagerAdapter;
import com.noura.anwar.new4shop.Moodle.AboutModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage =0;
    private static int NUM_PAGES = 0;
    private ArrayList<AboutModel>imageModelArrayList ;

    Button btnGetStarted ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //butterknife


        btnGetStarted = findViewById(R.id.email_log_button_main);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LogAndSignButtum.class));
            }
        });
         imageModelArrayList = populateList();
      //       btnGetStarted.performClick();

        //        btnGetStared = findViewById(R.id.btn_start);
//        btnNext = findViewById(R.id.btn_next);


//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                nextStep();
//            }
//        });

        init();


        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentPage == NUM_PAGES){
                currentPage = 0 ;
                }
                mPager.setCurrentItem(currentPage++ , true);
            }
        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 3000, 3000);



  }
  private void getStarted(){


  }
  private void init(){
mPager=findViewById(R.id.viewPager);
final ViewPagerIndicator indicator = findViewById(R.id.indecator);
mPager.setAdapter(new AboutPagerAdapter(this, imageModelArrayList));
      NUM_PAGES = imageModelArrayList.size();

      mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
              indicator.moveIndicator(position, positionOffset, positionOffsetPixels);
          }

          @Override
          public void onPageSelected(int position) {
              indicator.setCurrentPosition(position);
          }

          @Override
          public void onPageScrollStateChanged(int state) {
          }
      });


  }

    private ArrayList<AboutModel> populateList() {

        ArrayList<AboutModel> list = new ArrayList<>();

        list.add(new AboutModel(R.drawable.fimg, "Title One ", "Quia sed consequatur rem quia molestias nulla quia. Eos optio soluta asperiores in similique. "));
        list.add(new AboutModel(R.drawable.simg, "Title tow ", "Quia sed consequatur rem quia molestias nulla quia. Eos optio soluta asperiores in similique.  "));
        list.add(new AboutModel(R.drawable.thimg, " Title three ", "Quia sed consequatur rem quia molestias nulla quia. Eos optio soluta asperiores in similique.  "));
        list.add(new AboutModel(R.drawable.foimg, "Title four ", "Quia sed consequatur rem quia molestias nulla quia. Eos optio soluta asperiores in similique.  "));
        return list;
    }


}
