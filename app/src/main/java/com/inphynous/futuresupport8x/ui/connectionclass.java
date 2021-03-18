package com.inphynous.futuresupport8x.ui;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class connectionclass {
    String classs = "com.mysql.jdbc.Driver";
    String url = "jdbd:mysql://192.168.43.48/future_web";
    String username= "root";
    String password = "";

    @SuppressLint("NewApi")
    public Connection CONN(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String ConnURL = null;
        Connection conn = null;
        try {
            Class.forName(classs);
            conn = DriverManager.getConnection(url, username,password);

            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se){
            Log.e("ERPO", se.getMessage());

        }catch (ClassNotFoundException e){
            Log.e("ERPO", e.getMessage());
        }catch (Exception e){
            Log.e("ERPO", e.getMessage());
        }
        return conn;
    }
}
