package thailand.phosu.patcharin.mytraffic;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    //Explicit คือ การประกาศตัวแปร (เพื่อสำรองหน่วยความจำ)
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
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.cat);
                mediaPlayer.start();


                //Intent to Webview, Intent คือ class ที่อยู่ภายนอกต้องสร้าง instant เพื่อ
//                Intent intent = new Intent(Intent.ACTION_VIEW); // ACTION_VIEW คือ ทำการเปิด browser
//                intent.setData(Uri.parse("https://youtu.be/jT0fIfiw7Sg")); //ใส่ url ของ youtube
//                startActivity(intent);
// การ comment หลายบรรทัด ให้ drag ทั้งหมด แล้วกด ctrl + /

//                Intent intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse("tel:0879184485"));  //ต้องทำการเปิด permission เพื่อขออนุญาตใช้สิทธิ์ call ออกก่อน โดยไปที่ AndroidManifet แล้วพิพม์ <uses-permission android:name="android.permission.CALL_PHONE"/>
//                startActivity(intent);



            }   // onClick เมื่อไหร่ก็ตามที่มีการคลิกจะทำงานที่นี่
        });
    }   // bottonController Method

}   //main class หรือ คลาสหลัก
