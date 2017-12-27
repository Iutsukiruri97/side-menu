package yalantis.com.sidemenu.sample.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yalantis.com.sidemenu.sample.R;

/**
 * Created by tresdy on 17-12-24.
 */

public class QuestFragment extends Fragment {
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.fragment_quest, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}