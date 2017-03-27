package com.sxt.serjplayground.App;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.SharedPreferences;

import com.sxt.serjplayground.Listeners.WaitListener;
import com.sxt.serjplayground.Models.Bases.SystemData;

/**
 * Created by Serj on 07/03/2017.
 */

public class TheApplication extends Application {

    ProgressDialog wait;
    CentralActivityLifecycleCallbacks centraActivityLifecycleCallbacks;
    private static TheApplication sInstance;
    SharedPreferences mPref;

    public static TheApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        centraActivityLifecycleCallbacks = new CentralActivityLifecycleCallbacks();
        registerActivityLifecycleCallbacks(centraActivityLifecycleCallbacks);

        sInstance.initializeInstance();
    }

    private void initializeInstance() {

        // Inizializzo systemdata
        SystemData.Initialize();

        //Listeners
        SystemData.Data.Wait.waitListener = waitListener;

        // set application wise preference
        mPref = this.getApplicationContext().getSharedPreferences("pref_key", MODE_PRIVATE);
    }

    public Activity getCurrentActivity()
    {
        return centraActivityLifecycleCallbacks.currentActivity;
    }

    public WaitListener waitListener = new WaitListener()
    {
        @Override
        public void onEvent(boolean shouldWait)
        {
            final boolean isWait = shouldWait;

            Activity act = getCurrentActivity();
            act.runOnUiThread(new Runnable() {
                @Override
                public void run()
                {
                    if (isWait)
                    {

                        if (wait != null)
                            wait.dismiss();

                        wait = ProgressDialog.show(getCurrentActivity(), "Daemon Services",
                                "Attendere prego", true);
                    }
                    else
                    {
                        wait.dismiss();
                    }
                }
            });


        }
    };
}
