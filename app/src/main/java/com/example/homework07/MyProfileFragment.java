package com.example.homework07;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MyProfileFragment extends Fragment {
    Profile profile;
    String dept;
    Drawable image;
    private OnFragmentInteractionListener mListener;

    public MyProfileFragment() {
        this.profile = new Profile();
        // Required empty public constructor
    }

    public MyProfileFragment(Profile profile1) {
        this.profile = profile1;
        this.dept = profile.dept;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText et_id = view.findViewById(R.id.et_id);
        final EditText et_first = view.findViewById(R.id.et_first);
        final EditText et_last = view.findViewById(R.id.et_last);
        RadioButton rb_CS = view.findViewById(R.id.rb_cs);
        RadioButton rb_SIS = view.findViewById(R.id.rb_SIS);
        RadioButton rb_BIO = view.findViewById(R.id.rb_BIO);
        RadioButton rb_Other = view.findViewById(R.id.rb_other);
        final ImageView iv_dp = view.findViewById(R.id.iv_dp);

        RadioGroup rg_dept = view.findViewById(R.id.rg_dept);

        if(profile != null){

            if(profile.getImage() != null){
                iv_dp.setImageDrawable(profile.image);
            }

            if(profile.getId() != null){
            et_id.setText(profile.id);
            }

            if(profile.getFirst() != null) {
                et_first.setText(profile.first);
            }

            if(profile.getLast() != null) {
                et_last.setText(profile.last);
            }

            if(profile.getDept() != null){
                if(profile.dept.equals("CS")){
                    rb_CS.setChecked(true);
                }
                else if(profile.dept.equals("SIS")){
                    rb_SIS.setChecked(true);
                }
                else if(profile.dept.equals("BIO")){
                    rb_BIO.setChecked(true);
                }
                else if(profile.dept.equals("Other")){
                    rb_Other.setChecked(true);
                }
            }
        }

        iv_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.setFirst(et_first.getText().toString());
                profile.setLast(et_last.getText().toString());
                profile.setFullName(et_first.getText().toString()+"  "+ et_last.getText().toString());
                profile.setId(et_id.getText().toString());

                if(profile.dept == null){
                    profile.dept = dept;
                }

                mListener.avatarInterface(profile);
            }
        });

        rg_dept.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) getActivity().findViewById(i);
                profile.setDept(radioButton.getText().toString());
            }
        });

        view.findViewById(R.id.bt_Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText et_first = view.findViewById(R.id.et_first);
                //EditText et_last = view.findViewById(R.id.et_last);
                profile.setFirst(et_first.getText().toString());
                profile.setLast(et_last.getText().toString());
                profile.setFullName(et_first.getText().toString()+"  "+ et_last.getText().toString());
               // EditText et_id = view.findViewById(R.id.et_id);
                profile.setId(et_id.getText().toString());
                if(profile.dept == null){
                    profile.dept = dept;
                }
                mListener.myProfileInterface(profile);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
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

    public interface OnFragmentInteractionListener {
        void myProfileInterface(Profile profile);
        void avatarInterface(Profile profile);
    }
}
