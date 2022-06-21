package id.ac.uinsgd.kelompok2.tugasgo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.ac.uinsgd.kelompok2.tugasgologin.R;

public class DaftarActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://login-bafbd-default-rtdb.firebaseio.com/");
    EditText emaill;
    EditText passwordd;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);


        emaill = findViewById(R.id.emaill);
        passwordd = findViewById(R.id.passwordd);


        final Button buttonDaftarAkun = findViewById(R.id.buttonDaftarAkun);
        final TextView loginNow = findViewById(R.id.loginNow);

        mAuth = FirebaseAuth.getInstance();



        buttonDaftarAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createUser();

            }

        });


        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginNow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity();
                    }
                });

            }
        });
    }

    private void createUser(){
         String email = emaill.getText().toString();
         String password = passwordd.getText().toString();
        if (TextUtils.isEmpty(email)){
            emaill.setError("Email cannot be empty");
            emaill.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            passwordd.setError("Password cannot be empty");
            passwordd.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(DaftarActivity.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DaftarActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(DaftarActivity.this, "Pendaftaran tidak berhasil" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void MainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}