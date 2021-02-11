package by.supruniuk.alisa.criminalintent;

import android.os.Bundle;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import java.util.UUID;


public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crimeID";
    private Crime mCrime;
    private EditText mEtCrimeTitle;
    private Button mBtnCrimeDate;
    private CheckBox mCbCrimeSolved;

    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //CrimeFragment использует метод getActivity() для прямого
        //обращения к интенту CrimeActivity
        //читаем дополнение из интента CrimeActivity
        //и используем его для получения данных Crime.
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);

        mEtCrimeTitle = (EditText) view.findViewById(R.id.etCrimeTitle);
        mEtCrimeTitle.setText(mCrime.getTitle());
        mEtCrimeTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrime.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mBtnCrimeDate = (Button) view.findViewById(R.id.btnCrimeDate);
        mBtnCrimeDate.setText(mCrime.getDate());
        mBtnCrimeDate.setEnabled(false);

        mCbCrimeSolved = (CheckBox) view.findViewById(R.id.cbCrimeSolved);
        mCbCrimeSolved.setChecked(mCrime.isSolved());
        mCbCrimeSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return view;
    }
}