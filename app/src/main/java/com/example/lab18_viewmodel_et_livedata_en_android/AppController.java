package com.example.lab18_viewmodel_et_livedata_en_android;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel personnalisé pour la gestion du compteur.
 * Renommé en AppController pour éviter les noms génériques.
 */
public class AppController extends ViewModel {

    // Utilisation d'un nom de variable différent : resultValue
    private final MutableLiveData<Integer> resultValue = new MutableLiveData<>();

    public AppController() {
        // Valeur de départ
        resultValue.setValue(0);
    }

    // Exposition en lecture seule
    public LiveData<Integer> getObservableResult() {
        return resultValue;
    }

    public void doIncrement() {
        Integer val = resultValue.getValue();
        if (val != null) {
            resultValue.setValue(val + 1);
        }
    }

    public void doDecrement() {
        Integer val = resultValue.getValue();
        if (val != null) {
            resultValue.setValue(val - 1);
        }
    }

    public void doReset() {
        resultValue.setValue(0);
    }
}
