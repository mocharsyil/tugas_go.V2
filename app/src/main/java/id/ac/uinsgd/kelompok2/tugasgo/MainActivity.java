package id.ac.uinsgd.kelompok2.tugasgo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.lang.String;
import id.ac.uinsgd.kelompok2.tugasgologin.R;

public class MainActivity extends AppCompatActivity {
    private Button masuk;
    private Button daftar;

    EditText loginEmail;
    EditText loginPassword;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);

        masuk = (Button) findViewById(R.id.masuk);
        daftar = (Button) findViewById(R.id.buttonDaftar);

        Button button = findViewById(R.id.masuk);
        Button buttondaftar = findViewById(R.id.buttonDaftar);

        mAuth = FirebaseAuth.getInstance();

        buttondaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    buttondaftar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DaftarActivity();
                        }
                    });

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();
            }
        });

    }

    private void loginUser(){
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            loginEmail.setError("Email cannot be empty");
            loginEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            loginPassword.setError("Password cannot be empty");
            loginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    }else{
                        Toast.makeText(MainActivity.this, "Login Gagal: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void MainActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void DaftarActivity(){
        Intent intent = new Intent(this, DaftarActivity.class);
        startActivity(intent);
    }
}