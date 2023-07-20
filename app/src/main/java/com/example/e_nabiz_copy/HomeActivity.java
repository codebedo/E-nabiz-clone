package com.example.e_nabiz_copy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

        private BottomNavigationView bottomNavigationView;

        private final Fragment grafiklerimFragment = new GrafiklerimFragment();
        private final Fragment randevularimFragment = new RandevularimFragment();
        private final Fragment profilFragment = new ProfilFragment();
        private final Fragment guvenlikFragment = new GuvenlikFragment();
        private final Fragment acilDurumFragment = new AcilDurumFragment();

        private Fragment activeFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_home);

                bottomNavigationView = findViewById(R.id.bottom_navigation);
                bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                        Fragment selectedFragment = null;

                        if (item.getItemId() == R.id.action_grafiklerim) {
                                selectedFragment = grafiklerimFragment;
                        } else if (item.getItemId() == R.id.action_randevularim) {
                                selectedFragment = randevularimFragment;
                        } else if (item.getItemId() == R.id.action_profil) {
                                selectedFragment = profilFragment;
                        } else if (item.getItemId() == R.id.action_guvenlik) {
                                selectedFragment = guvenlikFragment;
                        } else if (item.getItemId() == R.id.action_acildurum) {
                                selectedFragment = acilDurumFragment;
                        }

                        if (selectedFragment != null) {
                                switchFragment(selectedFragment);
                                return true;
                        }

                        return false;
                });

                activeFragment = profilFragment;
                bottomNavigationView.setSelectedItemId(R.id.action_profil); // ProfilFragment seçili olarak işaretleniyor
                switchFragment(activeFragment);
        }


        private void switchFragment(Fragment selectedFragment) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                if (!selectedFragment.isAdded()) {
                        transaction.add(R.id.fragment_container, selectedFragment);
                }

                transaction.hide(activeFragment);
                transaction.show(selectedFragment);
                transaction.commitNow();

                activeFragment = selectedFragment;
        }
}
