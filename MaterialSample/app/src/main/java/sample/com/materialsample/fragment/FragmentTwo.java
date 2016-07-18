package sample.com.materialsample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sample.com.materialsample.R;

/**
 * Created by Raghuram on 21/04/2016.
 */
public class FragmentTwo extends Fragment{

    private FragmentOne.INextFragmentClikcListner mNextFragmentClikcListner;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mNextFragmentClikcListner = (FragmentOne.INextFragmentClikcListner) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tool_bar);
        if(toolbar!=null) {
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_launcher));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //What to do on back clicked
                    mNextFragmentClikcListner.onButtonClick(false);
                }
            });
        }
        return view;
    }
}
