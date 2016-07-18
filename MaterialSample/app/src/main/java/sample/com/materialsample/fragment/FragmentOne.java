package sample.com.materialsample.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import sample.com.materialsample.R;

/**
 * Created by Raghuram on 21/04/2016.
 */
public class FragmentOne extends Fragment{

    private INextFragmentClikcListner mNextFragmentClikcListner;

    public interface INextFragmentClikcListner{
        public void onButtonClick(boolean show);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mNextFragmentClikcListner = (INextFragmentClikcListner) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Button btn = (Button) view.findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "clicked the next fragment button",Toast.LENGTH_SHORT).show();
                mNextFragmentClikcListner.onButtonClick(true);
            }
        });
        return view;
    }
}
