package com.lambdatest.proverbial;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ButtonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ButtonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ButtonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButtonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ButtonFragment newInstance(String param1, String param2) {
        ButtonFragment fragment = new ButtonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        TextView textView = (TextView) view.findViewById(R.id.Textbox);
        view.findViewById(R.id.Text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TextView textView = (TextView) view.findViewById(R.id.Textbox);
                if (textView.getText().equals("Hello! Welcome to lambdatest Sample App called Proverbial")) {
                    textView.setText("Proverbial");
                }else {
                    textView.setText("Hello! Welcome to lambdatest Sample App called Proverbial");
                }
            }
        });

        view.findViewById(R.id.color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getCurrentTextColor()==Color.MAGENTA) {
                    textView.setTextColor(Color.BLACK);
                }else {
                    textView.setTextColor(Color.MAGENTA);
                }
            }
        });

        view.findViewById(R.id.geoLocation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout,new BrowserFragment("https://iplocation.net/"))
                        .addToBackStack("geolocation").commit();
            }
        });

        view.findViewById(R.id.toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Toast should be visible", Toast.LENGTH_LONG).show();
            }
        });

        view.findViewById(R.id.notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity()
                        .getApplicationContext(),"testNotification")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Test Notification")
                        .setContentText("Please enjoy this notification")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager)getActivity().getSystemService(
                        Context.NOTIFICATION_SERVICE);

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
//                    RemoteViews remoteViews = new RemoteViews(
//                            getActivity().getApplicationContext().getPackageName(),R.id.text_input_password_toggle);
//                    remoteViews.setTextViewText(R.id.title, "Test Notification");
//                    remoteViews.setTextViewText(R.id.message, "Please enjoy this notification");
//                    remoteViews.setImageViewResource(R.id.icon,
//                            R.drawable.ic_launcher_foreground);
//                    builder = builder.setContent(remoteViews);
//                }

                if (Build.VERSION.SDK_INT
                        >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("2", "High ",
                            NotificationManager.IMPORTANCE_HIGH);
                    builder.setChannelId("2");
                    notificationManager.createNotificationChannel(channel);
                }
                notificationManager.notify(1,builder.build());
            }
        });

        view.findViewById(R.id.speedTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout,new BrowserFragment("https://www.speedtest.net"))
                        .addToBackStack("speedtest").commit();
            }
        });
        return view;
    }
}