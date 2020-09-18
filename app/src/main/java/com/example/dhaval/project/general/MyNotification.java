package com.example.dhaval.project.general;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;

import com.example.dhaval.project.R;
import com.github.mikephil.charting.utils.Utils;

import java.util.HashMap;

import static android.content.Context.ALARM_SERVICE;

public class MyNotification {


    public static void sendNotification(Context context,String title, String message) {
        Intent yesIntent=new Intent(context,SaveAttendance.class);
        yesIntent.putExtra("key","1");
        PendingIntent yesPendingIntent=PendingIntent.getActivity(context,101,yesIntent,0);
        Intent noIntent = new Intent(context, SaveAttendance.class);
        noIntent.putExtra("key", "0");
        PendingIntent noPendingIntent = PendingIntent.getActivity(context, 100, noIntent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .addAction(R.drawable.ic_action_name,"Yes",yesPendingIntent)
                .addAction(R.drawable.ic_no,"No",noPendingIntent)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(0, mBuilder.build());
        }
    }
}
