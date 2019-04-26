package com.example.eatitserver.Common;

import com.example.eatitserver.Model.User;

public class Common {
    public static User currentUser;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";
    public static final int PICK_IMAGE_REQUEST = 71;

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
}
