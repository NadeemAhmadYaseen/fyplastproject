package com.example.fypwebhost;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Teacher_Activity extends AppCompatActivity {

    SharedPreferences prefs;
    Uri Image_Uri;

    String loginEmail, userId, userName, userPassword, Pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_);


        prefs = getSharedPreferences("LogIn", MODE_PRIVATE);
        loginEmail = prefs.getString("email", "No name defined");
        userId = prefs.getString("userId", "");
        userName = prefs.getString("name", "");
        userPassword = prefs.getString("password", "");


        Toast.makeText(getApplicationContext(),"->"+loginEmail, Toast.LENGTH_SHORT).show();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment(loginEmail, userId, userName, userPassword)).addToBackStack(null).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment(loginEmail, userId, userName, userPassword);
                            break;
                        case R.id.navigation_add:
                            selectedFragment = new AddFragment(loginEmail, userId);
                            break;
                        case R.id.navigation_classes:
                            selectedFragment = new ClassesFragment(loginEmail, userId, userName, userPassword);
                            break;
                        default:
                            selectedFragment = new HomeFragment(loginEmail, userId, userName, userPassword);
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).addToBackStack(null).commit();

                    return true;
                }
            };

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){

            case R.id.menu_logout:
                Toast.makeText(getApplicationContext(), "logout pressed", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LogIn", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Intent intent1 = new Intent(getApplicationContext(), login.class);
                startActivity(intent1);
                break;

            case R.id.menu_compare:
                Intent intent2 = new Intent(this, CosineComparing.class);
                startActivity(intent2);
                break;

        }
        return true;
    }







//    public void attach_image() {
//        if(!checkPermission()){
//            requestPermission();
//        }
//        else{
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//            intent.setType("*/txt");
//            intent.addCategory(Intent.CATEGORY_OPENABLE);
//            startActivityForResult(Intent.createChooser(intent, "Select Image"), 100);
//        }
//
//    }
//    public String getImagePath(Uri uri) {
//        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//        cursor.moveToFirst();
//        String document_id = cursor.getString(0);
//        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
//        cursor.close();
//
//        cursor = getContentResolver().query(
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
//        cursor.moveToFirst();
//        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
//        cursor.close();
//
//        return path;
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100 && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            Image_Uri = data.getData();
//            String path=getImagePath(Image_Uri);
//            Pic=path.substring(path.lastIndexOf("/") + 1);
//        }
//    }
//    private boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE);
//        if (result == PackageManager.PERMISSION_GRANTED) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    private void requestPermission() {
//
//
//        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 110);
//
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case 110:
//
//                break;
//        }
//    }
}

