package de.vogella.android.ownservice.local;

import android.content.BroadcastReceiver;
import java.util.ArrayList;
import java.util.List;
import android.*;
import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MyStartServiceReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    Intent service = new Intent(context, LocalWordService.class);
    //ma.value= 3456;
    
    /*Toast.makeText(MyStartServiceReceiver.this, "Connected", Toast.LENGTH_SHORT)
    .show();*/
    int i =0;
    CharSequence text = "we are in onReceive:";
    Bundle extras = intent.getExtras();
    if (extras != null) {
     if(extras.containsKey("value")){
    	 LocalWordService.list.clear();
    	 Toast.makeText(context, text+" "+MainActivity.value, Toast.LENGTH_SHORT)
         .show();
      System.out.println("Value is:"+extras.get("value"));
      MainActivity.value = 3456;
     // ma.value = 2345;
     // Toast.makeText(context, "value changed to:"+ma.value, Toast.LENGTH_SHORT)
     // .show();
     }
    }
    System.out.println("im in onReceive");
    context.startService(service);
  }
} 