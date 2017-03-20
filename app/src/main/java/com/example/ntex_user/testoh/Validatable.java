package com.example.ntex_user.testoh;

import android.widget.EditText;

/**
 * Created by NTex-User on 3/13/2017.
 */

public class Validatable {
    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean notNull(Object o) {
        return !isNull(o);
    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static boolean notNull(Object... os) {
        if (notNull((Object) os)) {
            for (Object o : os) {
                if (isNull(o)) {
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    public static boolean compare(String s1, String s2) {
        return notNull(s1) && notNull(s2) && s1.toLowerCase().contentEquals(s2.toLowerCase());
    }

    public static boolean isNotEmpty(String s) {
        return notNull(s) && !isEmpty(s);
    }

    public static boolean isEmpty(String s) {
        return notNull(s) && s.isEmpty();
    }

    public static boolean isEmpty(EditText e) {
        return notNull(e) && isEmpty(e.getText().toString());
    }

    public static boolean isEmpty(EditText... es) {
        for (EditText e : es) {
            if ((isNull(e) || isEmpty(e))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(Object[] e) {
        return notNull(e) && e.length > 0;
    }

    public static boolean isNotEmpty(EditText... es) {
        return !isEmpty(es);
    }

//    public static void bindInputToButton(Button btn, EditText... es) {
//        for (EditText e : es) {
//            e.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    btn.setEnabled(isEmpty(es));
//
//                }
//            });
//        }
//
//    }
    public static String requireNonNull(String s){return isNull(s)? "null":s;}
    public static String[] requireNonNull(String[] ss){return isNull(ss) ? new String[0] :ss;}


}
