package com.example.dhaval.project.database_call;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall {

    private SetDataResponse setDataRes;
    private static HashMap<String, String> parameters;
    private String responseString = "";

    public interface uploadFolder {
        String ASSIGNMENT = "assignment/";
    }


    private boolean isTaskKilled = false;

    public static String SERVER_URL_WEBSERVICE_API = "http://proglan.in/techmicra/college/collage_app.php";
    public static String SERVER_URL_ASSIGNMENT = "http://proglan.in/techmicra/college/" + uploadFolder.ASSIGNMENT;
    private static final String TAG = "NetworkCall";


    public static NetworkCall call(HashMap<String, String> parameters) {
        NetworkCall call = new NetworkCall();
        NetworkCall.parameters = parameters;
        call.performPostCall();
        return call;
    }


    private void performPostCall() {
        Call<Object> call = RestClient.getClient().getResponse(SERVER_URL_WEBSERVICE_API,
                parameters);
        Log.e(TAG, "requestedURL : " + getRequestURL(parameters));

        call.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                if (response.isSuccessful()) {
                    responseString = RestClient.getGSONBuilder().toJson(response.body());
                } else {
                    responseString = "";
                }
                setDataRes.setResponse(responseString);
            }
            @Override
            public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                responseString = "";
                setDataRes.setResponse(responseString);
            }

        });
    }
    public static String getRequestURL(HashMap<String, String> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append(SERVER_URL_WEBSERVICE_API).append("?");

        Iterator it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            sb.append(pair.getKey() + "=" + pair.getValue()).append("&");
//            it.remove(); // avoids a ConcurrentModificationException
        }
        Log.e("full_request", "full_request: " + sb.toString());
        return sb.toString();
    }




    public interface SetDataResponse {
        void setResponse(String responseStr);
    }

    public void setDataResponseListener(SetDataResponse setDataRes) {
        this.setDataRes = setDataRes;
    }

}
