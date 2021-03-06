package com.example.devicemanagement.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devicemanagement.Activities.MainActivity;
import com.example.devicemanagement.Entities.User;
import com.example.devicemanagement.R;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

public class ProfileInfoFragment extends Fragment {
    public static String LOG_TAG = "F_PROFILE_INFO";

    public ProfileInfoFragment() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_info, container, false);
        TextView loginField = v.findViewById(R.id.s_profile_info__login);
        TextView nameSurnameField = v.findViewById(R.id.s_profile_info__name_surname);
        TextView dateOfRegField = v.findViewById(R.id.s_profile_info__date_of_reg);
        TextView emailField = v.findViewById(R.id.s_profile_info__email);

        if (getArguments() != null) {
            String json = getArguments().getString(MainActivity.ARG_USER, "");
            Log.i(LOG_TAG, "Json: " + json);
            User mUser = new Gson().fromJson(json, User.class);
            loginField.setText(mUser.getLogin());
            nameSurnameField.setText(mUser.getName() + " " + mUser.getSurname());
            emailField.setText(mUser.getEmail());

            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf = new SimpleDateFormat();
            dateOfRegField.setText(sdf.format(mUser.getRegDate()));

        }


        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
