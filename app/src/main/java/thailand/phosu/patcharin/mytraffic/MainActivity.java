package thailand.phosu.patcharin.mytraffic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    //Explicit คือ การประกาศตัวแปร (เพื่อสำรองหน่่่วยความจำ)
    private ListView trafficListView;
    private Button aboutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //bind Widget การผูกความสัมพันธ์ระหว่างตัวแปรที่ประกาศกับ widget ที่อยู่บน activity
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutButton = (Button) findViewById(R.id.button);

        //Button Controller
        buttonController();

    }   //main method คือ method หลัก โดยจะทำงานที่ method หลักก่อนเสมอ

    private void buttonController() {
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.cat);
                        mediaPlayer.start();

            }   // onClick เมื่อไหร่ก็ตามที่มีการคลิกจะทำงานที่นี่
        });
    }   // bottonController Method

}   //main class หรือ คลาสหลัก
