package com.example.lab18_viewmodel_et_livedata_en_android;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreManagerViewModel extends ViewModel {

    // MutableLiveData est privé pour respecter l'encapsulation (MVVM)
    private final MutableLiveData<Integer> currentScore = new MutableLiveData<>();

    public ScoreManagerViewModel() {
        // Initialisation de la valeur
        currentScore.setValue(0);
    }

    // Retourne le LiveData en lecture seule pour l'Activity
    public LiveData<Integer> getScoreData() {
        return currentScore;
    }

    public void incrementScore() {
        Integer val = currentScore.getValue();
        if (val != null) {
            currentScore.setValue(val + 1);
        }
    }

    public void decrementScore() {
        Integer val = currentScore.getValue();
        if (val != null) {
            currentScore.setValue(val - 1);
        }
    }

    public void resetScore() {
        currentScore.setValue(0);
    }
}
