package kz.sking.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Fragment2 extends Fragment {

    Spinner spinner;

    // Метод создания второго фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Установка разметки фрагмента и доступ к компонентам фрагмента
        final View rootView = inflater.inflate(R.layout.fragment2, container, false);

        spinner = (Spinner) rootView.findViewById(R.id.spinner);


        // Обработчик кнопки Назад
        Button BackBtn = (Button) rootView.findViewById(R.id.backBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setFragment(getActivity(), new Fragment1());
            }
        });

        // Обработчик кнопки Далее
        Button NextBtn = (Button) rootView.findViewById(R.id.nextBtn);
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создание фрагмента с передачей ему параметров
                MainActivity.spinnerValue = spinner.getSelectedItem().toString();
                MainActivity.setFragment(getActivity(), new Fragment3());
            }
        });

        return rootView;
    }
}
