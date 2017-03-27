package com.sxt.serjplayground.WebServices.Interceptors;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.sxt.serjplayground.Helpers.FastDialog;
import com.sxt.serjplayground.Models.Bases.SystemData;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class WaitInterceptor implements Interceptor
{
    @Override
    public Response intercept(Chain chain) throws IOException
    {
        // Request
        SystemData.Data.Wait.ShowWaitDialog();
        Request original = chain.request();
        Request request = original.newBuilder()
                //.header("User-Agent", "Your-App-Name") + header custom per auth?
                .method(original.method(), original.body())
                .build();


        // Response
        Response response = chain.proceed(request);
        SystemData.Data.Wait.HideWaitDialog();

        switch (response.code())
        {
            case 401:
                FastDialog.Popup("Accesso non autorizzato");
                break;
            case 404:
                FastDialog.Popup("Risorsa non disponibile");
                break;
        }

        return response;
    }

}
