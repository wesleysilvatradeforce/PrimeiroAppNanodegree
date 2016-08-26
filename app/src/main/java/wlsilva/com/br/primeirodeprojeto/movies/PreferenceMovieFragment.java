package wlsilva.com.br.primeirodeprojeto.movies;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.text.BoringLayout;

import wlsilva.com.br.primeirodeprojeto.R;

/**
 * Created by wesleysilva on 8/21/16.
 */

public class PreferenceMovieFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue){
        return false;
    }
}
