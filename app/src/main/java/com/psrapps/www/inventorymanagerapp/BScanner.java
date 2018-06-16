package com.psrapps.www.inventorymanagerapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import static android.Manifest.permission.CAMERA;

public class BScanner extends AppCompatActivity  implements ZXingScannerView.ResultHandler{
    public static ArrayList<IModel> k = new ArrayList();
    static ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=new ZXingScannerView(this);
        setContentView(b);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
        {
            if (checkPermission())
            {
                //Toast.makeText(BScanner.this,"Permission is granted!", Toast.LENGTH_LONG).show();
            }
            else
            {
                requestPermission();
            }
        }
    }

    private boolean checkPermission()
    {
        return (ContextCompat.checkSelfPermission(BScanner.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission()
    {
        ActivityCompat.requestPermissions(this,new String[]{CAMERA},a);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if(checkPermission())
            {
                if (b == null)
                {
                    b = new ZXingScannerView(this);
                    setContentView(b);
                }
                b.setResultHandler(this);
                b.startCamera();
            }
            else
            {
                requestPermission();
            }

        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        b.stopCamera();
    }

    private static final int a=1;
    private ZXingScannerView b;

    @Override
    public void handleResult(Result result) {
        final String scanResult  = result.getText();
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                b.resumeCameraPreview(BScanner.this);
            }
        });
        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // load(scanResult);
            }
        });
        builder.setMessage(scanResult);
        AlertDialog alert = builder.create();
        alert.show();*/
        progress = ProgressDialog.show(this, scanResult, "Loading the content please wait", true);
        registeruser(scanResult,getBaseContext(),registerInterface);
    }
    RegisterInterface registerInterface=new RegisterInterface() {
        @Override
        public void success(Boolean success)
        {

        }

    };
    public interface RegisterInterface
    {
        void success(Boolean success);
    }

    public void registeruser(String bcode, final Context context, RegisterInterface registerInterface) {
        final ArrayList<IModel> list =new ArrayList();
        //done=0;
        try {
            String url ="http://54.203.2.19:3009/psr/demouiddetails";
            JSONObject jsonbody = new JSONObject();
            jsonbody.put("uid", bcode);
            final String mRequestBody = jsonbody.toString();

            final JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST,url,null,new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        JSONArray array = response;
                        for (int x = 0; x < array.length(); x++)
                        {
                            JSONObject item = array.getJSONObject(x);
                            String uid = item.getString("uid");
                            String name = item.getString("name");
                            String quantity = item.getString("quantity");
                            String price = item.getString("price");
                            int flag=0;
                            if(k.size()==0)
                            {
                                IModel newitem = new IModel(uid, name, quantity, price);
                                k.add(newitem);
                                //progress.dismiss();
                            }
                            else
                            {
                                for(int j=0;j<k.size();j++) {
                                    if (uid.equals(k.get(j).getUid())) {
                                        progress.dismiss();
                                        Toast.makeText(getBaseContext(), "item already exists in the list please change the quantity", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(BScanner.this, list.class));
                                        finish();
                                        flag = 1;
                                        break;
                                    }
                                }
                                   if(flag==0)
                                    {
                                        IModel newitem = new IModel(uid, name, quantity, price);
                                        k.add(newitem);
                                        progress.dismiss();
                                        break;
                                    }
                                }
                            }
                        progress.dismiss();
                        startActivity(new Intent(BScanner.this,list.class));
                        finish();
                    }
                    catch (JSONException e) {
                        progress.dismiss();
                        Toast.makeText(getBaseContext(),e.toString(),Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progress.dismiss();
                }
            })
            {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() {
                    try {
                        return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encodig", mRequestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                    if (response.statusCode == 200 || response.statusCode == 409) {
                        //registerInterface.success(true);
                    }
                    return super.parseNetworkResponse(response);
                }
            };
            Volley.newRequestQueue(context).add(request);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}