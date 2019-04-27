package com.example.eatitserver.Common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.example.eatitserver.Model.Request;
import com.example.eatitserver.Model.User;
import com.example.eatitserver.Remote.IGeoCoordinates;
import com.example.eatitserver.Remote.RetrofitClient;

public class Common {
    public static User currentUser;
    public static Request currentRequest;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";
    public static final int PICK_IMAGE_REQUEST = 71;
    public static final String API_KEY = "AIzaSyCJbGicSafT9ZO5r9A7XSk0w3_VCh8Ms0I";

    public static final String  baseUrl = "https://maps.googleapis.com";

    public static  String convertCodeToStatus(String code)
    {
        switch (code) {
            case "0":
                return "Placed";
            case "1":
                return "On my way";
            default:
                return "Shipped";
        }
    }

    public  static IGeoCoordinates getGeoCodeService()
    {
        return RetrofitClient.getClient(baseUrl).create(IGeoCoordinates.class);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int newWidth, int newHeight)
    {
        Bitmap scaledBitmap = Bitmap.createBitmap(newWidth,newHeight,Bitmap.Config.ARGB_8888);

        float scaleX = newWidth/(float)bitmap.getWidth();
        float scaleY = newHeight/(float)bitmap.getHeight();
        float pivotX = 0,pivotY = 0;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(scaleX,scaleY,pivotX,pivotY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap,0,0,new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;
    }

}
