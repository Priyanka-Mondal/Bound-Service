package de.vogella.android.ownservice.local;

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



public class MainActivity extends ListActivity {
  private LocalWordService s;
  public  static int value;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myFunc();
  
    Intent intent2 = new Intent();
    intent2.setAction("MyBroadcast");
    intent2.putExtra("value", value);
    sendBroadcast(intent2);
    
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    Intent intent= new Intent(this, LocalWordService.class);
    bindService(intent, mConnection,
        Context.BIND_AUTO_CREATE);
    Toast.makeText(MainActivity.this, "START service will be called now", Toast.LENGTH_SHORT).show();
    startService(intent);
    
    Toast.makeText(MainActivity.this, "Value Initialized to: "+value, Toast.LENGTH_SHORT).show();
    Toast.makeText(MainActivity.this, "stop service will be called now", Toast.LENGTH_SHORT).show();
    stopService(intent);
  }

  @Override
  protected void onPause() {
	  myFunc();
	  Toast.makeText(MainActivity.this, "Value changed back to: "+value, Toast.LENGTH_SHORT).show();
    super.onPause();
    unbindService(mConnection);
  }

  private ServiceConnection mConnection = new ServiceConnection() {

    public void onServiceConnected(ComponentName className, 
        IBinder binder) {
      LocalWordService.MyBinder b = (LocalWordService.MyBinder) binder;
      s = b.getService();
      //value = 1200;
      Toast.makeText(MainActivity.this, "Connected:"+value, Toast.LENGTH_SHORT)
          .show();
    }
    public void onServiceDisconnected(ComponentName className) {
      s = null;
    }
  };
  
  
  public void myFunc()
  {
	 /* LocalWordService.list.add("priyanka");
	  LocalWordService.list.add("mondal");*/
	  value =1000;
  }
} 