package bright.mobile.samplebottomapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        performFragmentTransaction(new HomeFragment(), "kjhaksd");
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuSelectedId = item.getItemId();
                Fragment fragment;
                if (menuSelectedId == R.id.menu_home) {
                    fragment = new HomeFragment();
                } else if (menuSelectedId == R.id.menu_payments) {
                    fragment = new PaymentsFragment();
                } else {
                    fragment = new AnalyticsFragment();
                }
                performFragmentTransaction(fragment, "");
                return true;
            }
        });
    }

    private void performFragmentTransaction(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment, tag)
                .commit();
    }
}