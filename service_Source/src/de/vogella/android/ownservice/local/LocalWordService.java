package de.vogella.android.ownservice.local;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class LocalWordService extends Service {
  private final IBinder mBinder = new MyBinder();
  public static ArrayList<String> list = new ArrayList<String>();
  
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {

    Random random = new Random();
   System.out.println("im in on startCommnd");
    return Service.START_NOT_STICKY;
  }
  
  @Override
  public IBinder onBind(Intent arg0) {
	  /////////////////by priyanka
	  Random random = new Random();
	    if (random.nextBoolean()) {
	      list.add("Linux");
	    }
	    if (random.nextBoolean()) {
	      list.add("Android");
	    }
	    if (random.nextBoolean()) {
	      list.add("iPhone");
	    }
	    if (random.nextBoolean()) {
	      list.add("Windows7");
	    }
	   // list.add("priyanka");
	    System.out.println("im in onBind");
	   /* if (list.size() >= 20) {
	      list.remove(0);
	    }
	    while(random.nextBoolean())
	    {
	    	list.add("priyanka");
	    }*/
	    MainActivity.value = 9900;
	    /////////////////by priyanka
    return mBinder;
  }

  public class MyBinder extends Binder {
    LocalWordService getService() {
      return LocalWordService.this;
    }
  }

  public List<String> getWordList() {
    return list;
  }

} 