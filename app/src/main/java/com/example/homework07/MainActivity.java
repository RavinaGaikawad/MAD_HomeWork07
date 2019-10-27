package com.example.homework07;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyProfileFragment.OnFragmentInteractionListener, DisplayFragment.OnFragmentInteractionListener, AvatarFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("My Profile");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MyProfileFragment(), "MyProfileFragment")
                .commit();

        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
    }


    public void myProfileInterface(Profile profile) {
        Toast.makeText(this, profile.toString(), Toast.LENGTH_SHORT).show();

        setTitle("Display My Profile");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new DisplayFragment(profile), "DisplayFragment")
                .commit();

    }

    @Override
    public void avatarInterface(Profile profile) {
        setTitle("Select Avatar");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new AvatarFragment(profile), "AvatarFragment")
                .commit();
    }


    @Override
    public void displayFragmentInterface(Profile profile) {
        setTitle("My Profile");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MyProfileFragment(profile), "MyProfileFragment")
                .commit();
    }

    @Override
    public void AvatarFragmentInterface(Profile profile) {
        setTitle("My Profile");
        //Toast.makeText(this, "avatar inteface" + profile.image.toString(), Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MyProfileFragment(profile), "MyProfileFragment")
                .commit();
    }
}
