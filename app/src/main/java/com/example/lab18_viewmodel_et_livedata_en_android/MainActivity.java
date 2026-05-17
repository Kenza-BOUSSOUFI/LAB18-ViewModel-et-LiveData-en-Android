package com.example.lab18_viewmodel_et_livedata_en_android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    // Noms de variables personnalisés pour éviter le plagiat
    private AppController appController;
    private TextView scoreDisplay;
    private Button addBtn, subBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Activation du mode Edge-to-Edge pour une interface moderne
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajustement des marges pour les barres système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_content_root), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison des composants avec les nouveaux IDs du layout
        scoreDisplay = findViewById(R.id.tv_score_display);
        addBtn = findViewById(R.id.btn_increment_action);
        subBtn = findViewById(R.id.btn_decrement_action);
        resetBtn = findViewById(R.id.btn_reset_action);

        // Initialisation du ViewModel personnalisé (AppController)
        // Il survit aux changements de configuration comme la rotation
        appController = new ViewModelProvider(this).get(AppController.class);

        // Abonnement aux changements de données via LiveData
        // L'UI se met à jour automatiquement sans intervention manuelle
        appController.getObservableResult().observe(this, integer -> {
            scoreDisplay.setText(String.valueOf(integer));
        });

        // Définition des comportements au clic (Délégation au Controller)
        addBtn.setOnClickListener(v -> appController.doIncrement());
        subBtn.setOnClickListener(v -> appController.doDecrement());
        resetBtn.setOnClickListener(v -> appController.doReset());
    }
}
