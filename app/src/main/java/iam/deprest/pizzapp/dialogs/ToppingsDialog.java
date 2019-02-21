package iam.deprest.pizzapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class ToppingsDialog extends DialogFragment {

    public interface DialogConfirmListener{
        void confirm(ArrayList<String> toppings);
    }
    private DialogConfirmListener dialogConfirmListener;
    public void setDialogConfirmListener(DialogConfirmListener dialogConfirmListener){
        this.dialogConfirmListener = dialogConfirmListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[] toppings = {"banana", "strawberry", "pineapple", "apple", "milk chocolate", "dark chocolate", "white chocolate", "caramel", "salted caramel", "nuts", "cookies", "oreos", "chocolate pieces"};
        boolean[] isChecked = new boolean[toppings.length];
        Arrays.fill(isChecked, false);
        final ArrayList<String> gekozenToppings = new ArrayList<>();

        AlertDialog.Builder bob = new AlertDialog.Builder(getActivity());

        bob.setTitle("Choose your toppings");
        bob.setMultiChoiceItems(toppings, isChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    gekozenToppings.add(toppings[which]);
                }else{
                    gekozenToppings.remove(toppings[which]);
                }
            }
        });
        return bob.create();
    }
}
