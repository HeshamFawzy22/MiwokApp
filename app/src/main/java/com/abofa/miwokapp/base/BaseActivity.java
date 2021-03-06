package com.abofa.miwokapp.base;

import android.content.DialogInterface;

import com.abofa.miwokapp.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public AlertDialog showMessage(String message ,
                                   String positiveMsg , String negativeMsg ,
                                   DialogInterface.OnClickListener onClickListenerPositive,
                                   DialogInterface.OnClickListener onClickListenerNegative){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(positiveMsg,onClickListenerPositive)
                .setNegativeButton(negativeMsg,onClickListenerNegative)
                .setTitle(R.string.warning)
                .setCancelable(false);
        return builder.show();
    }
    public AlertDialog showMessage(int message ,
                                   int positiveMsg , int negativeMsg ,
                                   DialogInterface.OnClickListener onClickListenerPositive,
                                   DialogInterface.OnClickListener onClickListenerNegative){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(positiveMsg,onClickListenerPositive)
                .setNegativeButton(negativeMsg,onClickListenerNegative)
                .setTitle(R.string.warning)
                .setCancelable(false);
        return builder.show();
    }
    public AlertDialog showMessage(int message , int positiveMsg, DialogInterface.OnClickListener onClickListener){

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(positiveMsg,onClickListener)
                .setCancelable(false)
                .setTitle(R.string.warning);
        return builder.show();
    }
    @Override
    public void onBackPressed() {
        showMessage(R.string.do_you_want_to_exit, R.string.ok, R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

}
