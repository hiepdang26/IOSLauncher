package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class z02 {
    public static final ug1 a = new ug1(0);
    public static Locale b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            Context context2 = j02.a(context).h;
            return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i == 1) {
            return resources.getString(t61.common_google_play_services_install_text, strA);
        }
        if (i == 2) {
            return bf1.o(context) ? resources.getString(t61.common_google_play_services_wear_update_text) : resources.getString(t61.common_google_play_services_update_text, strA);
        }
        if (i == 3) {
            return resources.getString(t61.common_google_play_services_enable_text, strA);
        }
        if (i == 5) {
            return d(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i == 7) {
            return d(context, "common_google_play_services_network_error_text", strA);
        }
        if (i == 9) {
            return resources.getString(t61.common_google_play_services_unsupported_text, strA);
        }
        if (i == 20) {
            return d(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i) {
            case 16:
                return d(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return d(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(t61.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(u61.common_google_play_services_unknown_issue, strA);
        }
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(t61.common_google_play_services_install_title);
        }
        if (i == 2) {
            return resources.getString(t61.common_google_play_services_update_title);
        }
        if (i == 3) {
            return resources.getString(t61.common_google_play_services_enable_title);
        }
        if (i == 5) {
            return e(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return e(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return e(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return e(context, "common_google_play_services_restricted_profile_title");
    }

    public static String d(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strE = e(context, str);
        if (strE == null) {
            strE = resources.getString(u61.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strE, str2);
    }

    public static String e(Context context, String str) {
        Resources resourcesForApplication;
        ug1 ug1Var = a;
        synchronized (ug1Var) {
            try {
                Locale locale = hs0.m(context.getResources().getConfiguration()).a.get();
                if (!locale.equals(b)) {
                    ug1Var.clear();
                    b = locale;
                }
                String str2 = (String) ug1Var.get(str);
                if (str2 != null) {
                    return str2;
                }
                int i = ja0.c;
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resourcesForApplication = null;
                }
                if (resourcesForApplication != null) {
                    int identifier = resourcesForApplication.getIdentifier(str, "string", "com.google.android.gms");
                    if (identifier != 0) {
                        String string = resourcesForApplication.getString(identifier);
                        if (!TextUtils.isEmpty(string)) {
                            a.put(str, string);
                            return string;
                        }
                        if (str.length() != 0) {
                            "Got empty resource: ".concat(str);
                        }
                    } else if (str.length() != 0) {
                        "Missing resource: ".concat(str);
                    }
                }
                return null;
            } finally {
            }
        }
    }
}
