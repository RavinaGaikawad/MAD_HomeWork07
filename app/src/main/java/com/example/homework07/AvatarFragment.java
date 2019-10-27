package com.example.homework07;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class AvatarFragment extends Fragment {
    Profile profile;
    ImageView iv_1;
    ImageView iv_2;
    ImageView iv_3;
    ImageView iv_4;
    ImageView iv_5;
    ImageView iv_6;
    private OnFragmentInteractionListener mListener;

    public AvatarFragment() {
        // Required empty public constructor
    }

    public AvatarFragment(Profile profiled) {
        this.profile = profiled;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // final Profile profile1 = new Profile();
        /*if(profile != null){
            profile1.setFirst(profile.getFirst());
            profile1.setLast(profile.getLast());
            profile1.setFullName(profile.getFullName());
            profile1.setId(profile.getId());
            profile1.setDept(profile.getDept());
        }*/

        iv_1 = getActivity().findViewById(R.id.iv_1);
        iv_2 = getActivity().findViewById(R.id.iv_2);
        iv_3 = getActivity().findViewById(R.id.iv_3);
        iv_4 = getActivity().findViewById(R.id.iv_4);
        iv_5 = getActivity().findViewById(R.id.iv_5);
        iv_6 = getActivity().findViewById(R.id.iv_6);

        iv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.setImage(iv_1.getDrawable());
                Log.d("bagh", "profile image "+profile.image.toString());
                //Toast.makeText(getActivity(), profile.image.toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(), profile.toString(), Toast.LENGTH_SHORT).show();
                mListener.AvatarFragmentInterface(profile);
            }
        });

        iv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.image = iv_2.getDrawable();
                mListener.AvatarFragmentInterface(profile);
            }
        });

        iv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.image = iv_3.getDrawable();
                mListener.AvatarFragmentInterface(profile);
            }
        });

        iv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.image = iv_4.getDrawable();
                mListener.AvatarFragmentInterface(profile);
            }
        });

        iv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.image = iv_5.getDrawable();
                mListener.AvatarFragmentInterface(profile);
            }
        });

        iv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.image = iv_6.getDrawable();
                mListener.AvatarFragmentInterface(profile);
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_avatar, container, false);
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
        void AvatarFragmentInterface(Profile profile);
    }
}
