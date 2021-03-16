package com.inphynous.futuresupport8x;


import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.util.Log;

import java.util.HashMap;

public class SessionManager {

  SharedPreferences usersSession;
  SharedPreferences.Editor editor;
  Context context;

  private static final String Is_login ="IsLoggedIn";
    public static final String KEY_FULLNAME = "fullname";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_MOBILE = "phonenumber";


    public SessionManager(Context _context){
        context = _context;
        usersSession = _context.getSharedPreferences("userLoginSession", Context.MODE_PRIVATE);
        editor  = usersSession.edit();

    }

        public  void createLoginSession(String fullname, String username, String email, String phonenumber){
        editor.putBoolean(Is_login,true);

            editor.putString(KEY_FULLNAME,fullname);
            editor.putString(KEY_USERNAME,username);
            editor.putString(KEY_EMAIL,email);
            editor.putString(KEY_MOBILE,phonenumber);

            editor.commit();
        }
        public HashMap<String, String> getUserDetailFromSesion(){
        HashMap<String, String> userData = new HashMap<String, String>();

            userData.put(KEY_FULLNAME,usersSession.getString(KEY_FULLNAME, null));
            userData.put(KEY_USERNAME,usersSession.getString(KEY_USERNAME, null));
            userData.put(KEY_EMAIL,usersSession.getString(KEY_EMAIL, null));
            userData.put(KEY_MOBILE,usersSession.getString(KEY_MOBILE, null));

            return userData;
        }

        public boolean checkLogin(){
        if (usersSession.getBoolean(Is_login,true)){
            return true;
        }else
            return false;

        }

        public void logoutUserFromSession(){
        editor.clear();
        editor.commit();
        }
}
