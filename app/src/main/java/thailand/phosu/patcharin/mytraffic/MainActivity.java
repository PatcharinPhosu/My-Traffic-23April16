package thailand.phosu.patcharin.mytraffic;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

        //ListView Controller
        ListViewController();


    }   //main method คือ method หลัก โดยจะทำงานที่ method หลักก่อนเสมอ

    private void ListViewController() {
        //Type1
        final int[] iconInts = {R.drawable.traffic_01, R.drawable.traffic_02,
                R.drawable.traffic_03, R.drawable.traffic_04,
                R.drawable.traffic_05, R.drawable.traffic_06, R.drawable.traffic_07,
                R.drawable.traffic_08, R.drawable.traffic_09, R.drawable.traffic_10,
                R.drawable.traffic_11, R.drawable.traffic_12, R.drawable.traffic_13,
                R.drawable.traffic_14, R.drawable.traffic_15, R.drawable.traffic_16,
                R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19,
                R.drawable.traffic_20};

        //Type2
        final String[] titleStrings = new String[20]; // ทำการจองหน่วยความจำก่อน 20 ตัว   // ctrl+alt+L คือการ reformat code
        titleStrings[0] = "ห้ามเลี้ยวซ้าย";
        titleStrings[1] = "ห้ามเลี้ยวขวา";
        titleStrings[2] = "ให้เดินรถทางเดียวไปข้างหน้า";
        titleStrings[3] = "ให้เลี้ยวขวา";
        titleStrings[4] = "ให้เลี้ยวซ้าย";
        titleStrings[5] = "ให้ออก";
        titleStrings[6] = "ให้เข้า";
        titleStrings[7] = "ให้ออก";
        titleStrings[8] = "หยุดตรวจ";
        titleStrings[9] = "ห้ามรถสูงเกินกำหนด";
        titleStrings[10] = "ให้เลี้ยวซ้ายหรือเลี้ยวขวา";
        titleStrings[11] = "ห้ามกลับรถไปทางขวา";
        titleStrings[12] = "ห้ามจอดรถ";
        titleStrings[13] = "ให้รถสวนทางมาก่อน";
        titleStrings[14] = "ห้ามแซง";
        titleStrings[15] = "ให้เข้า";
        titleStrings[16] = "หยุดตรวจ";
        titleStrings[17] = "จำกัดความเร็ว";
        titleStrings[18] = "ห้ามรถกว้างเกินกำหนด";
        titleStrings[19] = "ห้ามรถสูงเกินกำหนด";

        //Type3
        final String[] detailStrings = getResources().getStringArray(R.array.detail);



        //Create ListView โดยการสร้าง instant ของ adapter
        MyAdapter myAdapter = new MyAdapter(this, iconInts, titleStrings, detailStrings);
        trafficListView.setAdapter(myAdapter);

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Image", iconInts[position]);
                intent.putExtra("Detail", detailStrings[position]);
                startActivity(intent);

            }// OnItemClick เมื่อไหร่ก็ตามที่มีการคลิก จะทำงานตรงนี้
        });

        //ListViewController

    }

    private void buttonController() {
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.cat);
                mediaPlayer.start();


                // Intent to Webview, Intent คือ class ที่อยู่ภายนอกต้องสร้าง instant เพื่อ
//                Intent intent = new Intent(Intent.ACTION_VIEW); // ACTION_VIEW คือ ทำการเปิด browser
//                intent.setData(Uri.parse("https://youtu.be/jT0fIfiw7Sg")); //ใส่ url ของ youtube
//                startActivity(intent);
// การ comment หลายบรรทัด ให้ drag ทั้งหมด แล้วกด ctrl + /

                try {

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:0879184485"));  //ต้องทำการเปิด permission เพื่อขออนุญาตใช้สิทธิ์ call ออกก่อน โดยไปที่ AndroidManifet แล้วพิพม์ <uses-permission android:name="android.permission.CALL_PHONE"/>
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(intent); // ยัง run ไม่ได้

                    Log.d("master", "ok");

                } catch (Exception e) {
                    Log.d("master", "error ==>" + e.toString());
                }


            }   // onClick เมื่อไหร่ก็ตามที่มีการคลิกจะทำงานที่นี่
        });
    }   // bottonController Method

}   //main class หรือ คลาสหลัก
