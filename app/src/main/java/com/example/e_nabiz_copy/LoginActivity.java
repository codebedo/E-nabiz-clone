package com.example.e_nabiz_copy;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    // giriş butonlarının tanımlarını yaptık
    Button giris, edevletgiris, mobilimzagiris, enabizyok, nasilenabizolunur;
    TextView sifremiunuttum;
    EditText tc, password;
    // şifre görünümü için tanım yaptık
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fonksiyonlar();

        EditText password =  findViewById(R.id.edt_sifre_giris);
        EditText tc = findViewById(R.id.edt_tc_giris);

        //Burada şifrenin görüntülenme kodlarını yazdık...
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right=2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=password.getSelectionEnd();
                        if(passwordVisible){
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                                    R.drawable.baseline_visibility_off_24,0);
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                                    R.drawable.baseline_visibility_24,0);
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        if (password.hasFocus()) {
                            password.setSelection(selection);
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void fonksiyonlar() {
        tanimlamalar();
        butonlar();
    }

    private void enabizyokFonk() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("e-Nabız hesabınızı \"Hesap Oluştur”\n" +
                "butonundan e-DevIet girişi yaparak ya\n" +
                "da Aile Hekiminizden alacağınız geçici\n" +
                "e-Nabız şifreniz ile sisteme giriş yaparak\n" +
                "oluşturabilirsiniz.");

        // Set the positive button
        builder.setPositiveButton("HESAP OLUŞTUR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://enabiz.gov.tr/"));
                startActivity(intent);
            }
        });

        // Set the negative button
        builder.setNegativeButton("VAZGEÇ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sifremiunuttumFonk() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);

        final EditText editText1 = dialogView.findViewById(R.id.editText1);
        final EditText editText2 = dialogView.findViewById(R.id.editText2);

        editText1.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                editText1.setHint("");
            } else {
                editText1.setHint("T.C. Kimlik No");
            }
        });

        editText2.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                editText2.setHint("");
            } else {
                editText2.setHint("(0555) 555 55 55");
            }
        });

        builder.setPositiveButton("ŞİFREYİ SIFIRLA", (dialog, which) -> {
            String text1 = editText1.getText().toString();
            String text2 = editText2.getText().toString();
            // EditText'lerdeki girilen değerleri kullanarak yapılacak işlemler
        });

        builder.setNegativeButton("İPTAL ET", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();

    }
    // butonlar methodu butonları  düzenli bir şekilde işlevsellik katmak için yapıldı
    private void butonlar() {
        // bu işlemler işe tıklanma özelliği verildi
        giris.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                // burada validasyon işlemi yapıldı

                final String sifre =String.valueOf( password.getText().toString());
                final String tcnumara = String.valueOf(tc.getText().toString());

                if(sifre.isEmpty() || tcnumara.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Lütfen alanları boş bırakmayın", Toast.LENGTH_SHORT).show();
                }else if(tcnumara.length()<11 ){
                    Toast.makeText(getApplicationContext(),
                            "tc numarası 11 karakter olmalıdı", Toast.LENGTH_SHORT).show();

                } else if(tcnumara.length()>11 ){
                    Toast.makeText(getApplicationContext(),
                            "tc numarası 11 karakter olmalıdı", Toast.LENGTH_SHORT).show();

                }else if(password.length()<8){
                    Toast.makeText(getApplicationContext(),
                            "e-nabız Şifresi 8 karakterden büyük olmalıdır", Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }




            }
        });
        edevletgiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edev = new Intent(LoginActivity.this, EDevletGirisActivity.class);
                startActivity(edev);
            }
        });
        mobilimzagiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        " çok özür dileriz mobil imza şuanlık devre dışı", Toast.LENGTH_LONG).show();
            }
        });
        enabizyok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enabizyokFonk();
            }

        });
        nasilenabizolunur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://m.youtube.com/watch?v=WtYw8CAW4mE"));
                startActivity(intent);
            }
        });
        sifremiunuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sifremiunuttumFonk();
            }

        });
    }

    private void tanimlamalar() {
        giris = findViewById(R.id.btn_giris);
        edevletgiris = findViewById(R.id.btn_edevlet_giris);
        mobilimzagiris = findViewById(R.id.btn_mobil_imza_giris);
        enabizyok = findViewById(R.id.btn_enabiz_hesap_yok);
        nasilenabizolunur = findViewById(R.id.btn_nasil_enabizli_olurum);
        sifremiunuttum = findViewById(R.id.txt_sifremi_unuttum);
        tc = findViewById(R.id.edt_tc_giris);
        password = findViewById(R.id.edt_sifre_giris);
    }


}
