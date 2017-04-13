package com.carouselnew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rajasingh on 2/17/2017.
 */

public class MyFragment extends Fragment implements View.OnClickListener {
    public static Fragment newInstance(MainActivity context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);

        return Fragment.instantiate(context, MyFragment.class.getName(), b);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(400,400);
        LinearLayout fragmentLL  = (LinearLayout) inflater.inflate(R.layout.mf, container, false);
        int pos   = this.getArguments().getInt("pos");
        TextView tv  = (TextView) fragmentLL.findViewById(R.id.text);
        tv.setText("Image " +  pos );

        ImageView iv = (ImageView) fragmentLL.findViewById(R.id.pagerImg);

        iv.setLayoutParams(layoutParams);
        iv.setImageResource(MainActivity.mainActivityCtx.coverUrl[pos] );
//        iv.setPadding(15, 15, 15, 15);
        iv.setTag(pos);
        iv.setOnClickListener(this);

        MyLinearLayout root = (MyLinearLayout) fragmentLL.findViewById(R.id.root);
        float scale   = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return fragmentLL;
    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        Toast.makeText(getContext(),"Position"+tag,Toast.LENGTH_LONG).show();
    }
}
