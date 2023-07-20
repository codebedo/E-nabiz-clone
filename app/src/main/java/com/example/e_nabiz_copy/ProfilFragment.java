package com.example.e_nabiz_copy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfilFragment extends Fragment {

    private Button myButton;

    public ProfilFragment() {}

    public static ProfilFragment newInstance() {
        return new ProfilFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Burada butonları tanımladık...
        myButton = view.findViewById(R.id.covid19);
        ImageView eczane = view.findViewById(R.id.img_nobectieczaneler);
        ImageView nevar = view.findViewById(R.id.neyim_var);
        ImageView ilac = view.findViewById(R.id.img_ilaclarim);
        ImageView bild = view.findViewById(R.id.img_bildirimler);
        ImageView akillia = view.findViewById(R.id.akilli_asistan);
        ImageView hastalik = view.findViewById(R.id.img_hastaliklarim);
        ImageView recete = view.findViewById(R.id.img_recetelerim);
        ImageView radyo = view.findViewById(R.id.img_radyoloji);
        ImageView tahlil = view.findViewById(R.id.img_tahlillerim);
        ImageView malzeme = view.findViewById(R.id.img_malzemevecihazlar);
        ImageView rapor = view.findViewById(R.id.img_raporlarim);
        ImageView aler = view.findViewById(R.id.img_alerjilerim);
        ImageView acildnotu = view.findViewById(R.id.img_acildurumnotlarim);
        ImageView dokuman = view.findViewById(R.id.img_dokumanlar);
        ImageView organb = view.findViewById(R.id.img_organbagisi);
        ImageView asitak = view.findViewById(R.id.img_asitakvimi);
        ImageView uyku = view.findViewById(R.id.img_uykuverisi);
        ImageView kenikilg = view.findViewById(R.id.img_kemikiligi);
        ImageView sigorta = view.findViewById(R.id.img_sigorta);
        ImageView epikrz = view.findViewById(R.id.img_epikriz);
        ImageView patolo = view.findViewById(R.id.img_patoloji);
        ImageView hastayakin = view.findViewById(R.id.img_hastayakinibilgilendirme);



        //Burada ekranda bulunan butonlara tıklanma işlemi verdik...
        sigorta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sgort = new Intent(getActivity(), SigortaEkrani.class);
                startActivity(sgort);
            }
        });
        kenikilg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kan = new Intent(getActivity(), UykuVerisiEkrani.class);
                startActivity(kan);
            }
        });
        uyku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uyk = new Intent(getActivity(), UykuVerisiEkrani.class);
                startActivity(uyk);
            }
        });
        asitak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ast = new Intent(getActivity(), AsitakvimiEkrani.class);
                startActivity(ast);
            }
        });
        organb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent org = new Intent(getActivity(), DokumanlarimEkrani.class);
                startActivity(org);
            }
        });
        dokuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dkn = new Intent(getActivity(), DokumanlarimEkrani.class);
                startActivity(dkn);
            }
        });
        acildnotu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acldn = new Intent(getActivity(), AcilDurumNotEkrani.class);
                startActivity(acldn);
            }
        });
        aler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alr = new Intent(getActivity(), AlerliEkrani.class);
                startActivity(alr);
            }
        });
        rapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpr = new Intent(getActivity(), RaporlarimEkrani.class);
                startActivity(rpr);
            }
        });
        malzeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent malz = new Intent(getActivity(), MalzemeVeCihazlar.class);
                startActivity(malz);
            }
        });
        tahlil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thl = new Intent(getActivity(), TahlilEkrani.class);
                startActivity(thl);
            }
        });
        recete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rcz = new Intent(getActivity(), ReceteEkrani.class);
                startActivity(rcz);
            }
        });
        radyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rdy = new Intent(Intent.ACTION_VIEW);
                rdy.setData(Uri.parse("https://teleradyoloji.saglik.gov.tr/"));
                startActivity(rdy);
            }
        });

        hastalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hst = new Intent(getActivity(), HastaliklarimEkrani.class);
                startActivity(hst);
            }
        });
        ilac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ilc = new Intent(getActivity(), ilaclarim.class);
                startActivity(ilc);
            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CovidDurum.class);
                startActivity(intent);

            }
        });

        eczane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ecz = new Intent(Intent.ACTION_VIEW);
                ecz.setData(Uri.parse("https://www.istanbuleczaciodasi.org.tr/nobetci-eczane/"));
                startActivity(ecz);
            }
        });
        bild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bild = new Intent(getActivity(), Bildirimlerim.class);
                startActivity(bild);
            }
        });
        nevar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ne = new Intent(Intent.ACTION_VIEW);
                ne.setData(Uri.parse("https://neyimvar.gov.tr/giris"));
                startActivity(ne);
            }
        });
        akillia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent akil = new Intent(getActivity(), AkilliAsistan.class);
                startActivity(akil);
            }
        });

    }


}
