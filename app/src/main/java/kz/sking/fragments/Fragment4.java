package kz.sking.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Fragment4 extends Fragment {

    CheckBox checkBox;

    // Метод создания третьего фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Установка разметки фрагмента и доступ к компонентам фрагмента
        final View rootView = inflater.inflate(R.layout.fragment4, container, false);

        checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);

        // Обработчик кнопки Назад
        Button BackBtn = (Button) rootView.findViewById(R.id.backBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setFragment(getActivity(), new Fragment3());
            }
        });


        // Обработчик кнопки Далее
        Button NextBtn = (Button) rootView.findViewById(R.id.nextBtn);
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создание фрагмента с передачей ему параметров
                MainActivity.checkboxValue = checkBox.isChecked() ? getString(R.string.checkbox_yes) : getString(R.string.checkbox_no);
                Fragment5 fragment5 = new Fragment5();
                MainActivity.setFragment(getActivity(), fragment5);

            }
        });

        return rootView;
    }
}
