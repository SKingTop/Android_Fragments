package kz.sking.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Глобальные переменные для всех фреймов
    public static String spinnerValue = "", radioGroupValue = "", checkboxValue = "";

    // Создание окна
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Установка первого фрагмента в окно
        setFragment(this, new Fragment1());
    }

    // Установка в окне требуемого фрагмента
    public static void setFragment(FragmentActivity activity, Fragment fragment) {
        if (activity != null) {
            FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
        }
    }

    // Создание диалогового окна при нажатии на кнопку "Назад"
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getString(R.string.exit))
                .setMessage(getString(R.string.exit_desc))
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton(getString(R.string.no), null)
                .show();
    }

}
