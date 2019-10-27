package com.example.homework07;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DisplayFragment extends Fragment {
    Profile profile;

    private OnFragmentInteractionListener mListener;


    public DisplayFragment(Profile profile) {
        this.profile = profile;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().findViewById(R.id.bt_Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.displayFragmentInterface(profile);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_display, container, false);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_id = view.findViewById(R.id.tv_id);
        TextView tv_dept = view.findViewById(R.id.tv_dept);
        ImageView imageView = view.findViewById(R.id.iv_dp);

        tv_name.setText(profile.fullName);
        tv_id.setText(profile.id);
        tv_dept.setText(profile.dept);
        imageView.setImageDrawable(profile.image);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void displayFragmentInterface(Profile profile);
    }
}
