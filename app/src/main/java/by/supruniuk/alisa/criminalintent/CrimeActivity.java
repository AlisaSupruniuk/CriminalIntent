package by.supruniuk.alisa.criminalintent;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "by.supruniuk.alisa.criminalintent.crime_id";

    @Override
    protected Fragment createFragment() {
        UUID crimeID = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeID);
    }

    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }
}