package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //instanciar la clase clsDb
    clsDb ohDB = new clsDb(this, "dblibrary",null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instanciar y referencias los ID del archivo xml(activity_main.xml)
        EditText fullname = findViewById(R.id.etfullname);
        EditText email = findViewById(R.id.etemail);
        EditText password = findViewById(R.id.etpassword);
        ImageButton btnsave = findViewById(R.id.btnsave);
        ImageButton btnsearch = findViewById(R.id.btnsearch);
        ImageButton btnupdate = findViewById(R.id.btnupdate);
        ImageButton btndelete = findViewById(R.id.btndelete);


        btnsave.setOnClickListener(new View.OnClickListener() {
            //este es una clase de sobrecargado de metodos -->
            @Override
            public void onClick(View v) {
                //en esta variable se capturan los datos digitados
                saveUser(fullname.getText().toString(),email.getText().toString(), password.getText().toString());
            }
        });
    }
    //se crea el metodo de saveUser
    private void saveUser(String sFullname, String sEmail, String sPassword) {
        //instanciar la clase clsDb
        //clsDb ohDB = new clsDb(this, "dblibrary",null, 1);
        //instanciar la base de datos en modo de escritura (INSERT, UPDATE, DELETE);
        SQLiteDatabase db = ohDB.getWritableDatabase();
        //Try sirve para el manejo de exepciones
        try{
            //crear un objeto de contentValues para que contengas los mismos campos de la tabla user
            ContentValues cvUser = new ContentValues();
            cvUser.put("fullname", sFullname);
            cvUser.put("email", sEmail);
            cvUser.put("password", sPassword);
            //guardar en la tabla user lo que contiene cvUser
            db.insert("user", null, cvUser);
            db.close();
            Toast.makeText(getApplicationContext(), "Usuario Guardado exitosamente ...", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Paila pri: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}