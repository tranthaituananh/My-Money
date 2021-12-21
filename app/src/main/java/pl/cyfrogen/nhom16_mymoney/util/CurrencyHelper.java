package pl.cyfrogen.nhom16_mymoney.util;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import java.text.NumberFormat;
import android.widget.EditText;
import android.widget.TextView;

import pl.cyfrogen.nhom16_mymoney.firebase.models.Currency;
import pl.cyfrogen.nhom16_mymoney.firebase.models.User;

public class CurrencyHelper
{
    public static String formatCurrency(Currency currency, long money)
    {
        long absMoney = Math.abs(money);
        String str = NumberFormat.getInstance().format(absMoney);
        return (currency.left ? (currency.symbol + (currency.space ? " " : "")): "") +
                (money < 0 ? "-" : "") + str;
    }

    public static void setupAmountEditText(EditText editText, User user)
    {
        editText.setText(CurrencyHelper.formatCurrency(user.currency,0));
        editText.addTextChangedListener(new TextWatcher() {
            private String current = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count)
            {
                if (!charSequence.toString().equals(current))
                {
                    editText.removeTextChangedListener(this);
                    current = CurrencyHelper.formatCurrency(user.currency,convertAmountStringToLong(charSequence));
                    editText.setText(current);
                    editText.setSelection(current.length() -
                            (user.currency.left ? 0 : (user.currency.symbol.length() + (user.currency.space ? 1 : 0))));

                    editText.addTextChangedListener(this);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public static long convertAmountStringToLong(CharSequence s)
    {
        String cleanString = s.toString().replaceAll("[^0-9]", "");
        return Long.parseLong(cleanString);
    }
}
