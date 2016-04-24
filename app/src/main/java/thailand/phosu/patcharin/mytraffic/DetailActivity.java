package thailand.phosu.patcharin.mytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView titleTextView = (TextView) findViewById(R.id.textView4);
        titleTextView.setText(getIntent().getStringExtra("Title"));

        ImageView traffImageView = (ImageView) findViewById(R.id.imageView2);
        traffImageView.setImageResource(getIntent().getIntExtra("Image",R.drawable.traffic_01)); // หาแหล่งกำเนิดของภาพ

//        TextDetail textDetail = (TextDetail) findViewById(R.id.text/)



    }// Main Method หลัก

    public void clickbBack(View view){
        finish();

    }

}// Main Class
