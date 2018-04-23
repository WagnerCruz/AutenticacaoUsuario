package com.cursoandroid.autenticauser.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword("wagnerfcruz@gmail.com","lotusns")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Log.i("SignIn User" , "Usuario logado com sucesso!!" + task.getException());
                        }else{
                            Log.i("SignIn user", "Erro ao logar o usuario" + task.getException());
                        }

                    }
                });

//        firebaseAuth.createUserWithEmailAndPassword("wagnerfcruz@gmail.com","lotusnotes")
//                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if (task.isSuccessful()){
//                            Log.i("Create User" , "Usuario criado com sucesso!!");
//                        }else{
//                            Log.i("create user", "Erro ao cadastrar o usuario");
//                        }
//                    }
//                });



    }
}
