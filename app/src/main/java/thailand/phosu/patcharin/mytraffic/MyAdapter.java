package thailand.phosu.patcharin.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Constructor;

/**
 * Created by Patcharin on 24/4/2559.
 */
public class MyAdapter extends BaseAdapter{
    @Override
    public int getCount() {  //คือต้องการสร้างกี่อัน โดยการนับจาก...
        return iconInts.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //การขอเปิด layout เสมือน
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //cast to คือ การเปลี่ยน datatype ก่อนถึงจะเอามาบวกลบคูณหารกันได้ //Alt+Enter คือการขอ case to

        //view จะเป็นคนดำเนินการนำภาพหรือข้อความมาแสดง
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //Show Text

        TextView titleTextview = (TextView) view1.findViewById(R.id.textView2);
        titleTextview.setText(titleStrings[i]);

        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);
        detailTextView.setText(detailStrings[i]);  // Ctrl+space คือการเจนเพื่อขอความช่วยเหลือ


        //Show image
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        iconImageView.setImageResource(iconInts[i]);

        return view1;
    }

    //extends คือการสืบทอดมาจาก baseadapter

    // การสร้าง adapter คือ การสร้าง class เปล่า
    // การทำ context คือ การย้าย data ระหว่าง object กับ object
    // แหล่งกำเนิดภาพ เป็น int โดยวางค่าเป็น array
    //Explicit
    private Context context;
    private int[] iconInts;
    private String[] titleStrings, detailStrings;

    // contructor คือ method หลัก
    // seter ดึงเข้ามา
    // geter ดึงออกไป
    public MyAdapter(Context context, int[] iconInts, String[] titleStrings, String[] detailStrings) {
        this.context = context;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }
}
