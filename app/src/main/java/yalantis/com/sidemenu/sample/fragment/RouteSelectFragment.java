package yalantis.com.sidemenu.sample.fragment;

import android.support.v4.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicResize;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.sample.QuestAddActivity;
import yalantis.com.sidemenu.sample.R;

/**
 * Created by tresdy on 17-12-24.
 */

public class RouteSelectFragment extends Fragment implements ScreenShotable {
    Button button_query;
    private View view;
    private Bitmap bitmap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_routeselect, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button_query = view.findViewById(R.id.button_query);
        button_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                Intent it = new Intent(getActivity(), QuestAddActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void takeScreenShot() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
                        view.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                view.draw(canvas);
                RouteSelectFragment.this.bitmap = bitmap;
            }
        };

        thread.start();
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }
}