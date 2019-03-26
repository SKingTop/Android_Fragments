package kz.sking.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Fragment3 extends Fragment {

    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    // Метод создания третьего фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Установка разметки фрагмента и доступ к компонентам фрагмента
        final View rootView = inflater.inflate(R.layout.fragment3, container, false);

        radioButton1 = (RadioButton) rootView.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) rootView.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) rootView.findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) rootView.findViewById(R.id.radioButton4);

        MainActivity.radioGroupValue = radioButton1.getText().toString();

        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);

        // Обработчик выбора значения в radioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        MainActivity.radioGroupValue = radioButton1.getText().toString();
                        break;
                    case R.id.radioButton2:
                        MainActivity.radioGroupValue = radioButton2.getText().toString();
                        break;
                    case R.id.radioButton3:
                        MainActivity.radioGroupValue = radioButton3.getText().toString();
                        break;
                    case R.id.radioButton4:
                        MainActivity.radioGroupValue = radioButton4.getText().toString();
                        break;
                    default:
                        MainActivity.radioGroupValue = radioButton1.getText().toString();
                        break;
                }
            }
        });
        radioGroup.check(R.id.radioButton1);

        // Обработчик кнопки Назад
        Button BackBtn = (Button) rootView.findViewById(R.id.backBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setFragment(getActivity(), new Fragment2());
            }
        });

        // Обработчик кнопки Далее
        Button NextBtn = (Button) rootView.findViewById(R.id.nextBtn);
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создание фрагмента с передачей ему параметров
                Fragment4 fragment4 = new Fragment4();
                MainActivity.setFragment(getActivity(), fragment4);
            }
        });

        return rootView;
    }
}
