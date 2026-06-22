package defpackage;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.drawable.IconCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class t1 {
    public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(icon, charSequence, pendingIntent);
    }

    public static int b(AppCompatTextView appCompatTextView) {
        return appCompatTextView.getBreakStrategy();
    }

    public static Drawable c(CompoundButton compoundButton) {
        return compoundButton.getButtonDrawable();
    }

    public static int d(Context context, int i) {
        return context.getColor(i);
    }

    public static ColorStateList e(int i, Resources.Theme theme, Resources resources) {
        return resources.getColorStateList(i, theme);
    }

    public static int f(AppCompatTextView appCompatTextView) {
        return appCompatTextView.getHyphenationFrequency();
    }

    public static int g(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    public static Object h(Context context) {
        return context.getSystemService(AppOpsManager.class);
    }

    public static boolean i(TextPaint textPaint, String str) {
        return textPaint.hasGlyph(str);
    }

    public static int j(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOpNoThrow(str, str2);
    }

    public static String k(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static void l(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }

    public static void m(AppCompatTextView appCompatTextView, int i) {
        appCompatTextView.setBreakStrategy(i);
    }

    public static void n(TextView textView, ColorStateList colorStateList) {
        textView.setCompoundDrawableTintList(colorStateList);
    }

    public static void o(TextView textView, PorterDuff.Mode mode) {
        textView.setCompoundDrawableTintMode(mode);
    }

    public static void p(AppCompatTextView appCompatTextView, int i) {
        appCompatTextView.setHyphenationFrequency(i);
    }

    public static void q(Notification.Builder builder, Icon icon) {
        builder.setLargeIcon(icon);
    }

    public static boolean r(Drawable drawable, int i) {
        return drawable.setLayoutDirection(i);
    }

    public static void s(PopupWindow popupWindow, boolean z) {
        popupWindow.setOverlapAnchor(z);
    }

    public static void t(PopupWindow popupWindow, int i) {
        popupWindow.setWindowLayoutType(i);
    }

    public static Icon u(IconCompat iconCompat, Context context) {
        Icon iconCreateWithBitmap;
        int i;
        int i2 = iconCompat.a;
        String strE = null;
        inputStreamOpenInputStream = null;
        InputStream inputStreamOpenInputStream = null;
        switch (i2) {
            case -1:
                return (Icon) iconCompat.b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.b);
                break;
            case 2:
                if (i2 == -1 && (i = Build.VERSION.SDK_INT) >= 23) {
                    Object obj = iconCompat.b;
                    if (i >= 28) {
                        strE = eu.e(obj);
                    } else {
                        try {
                            strE = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                        }
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + iconCompat);
                    }
                    String str = iconCompat.j;
                    strE = (str == null || TextUtils.isEmpty(str)) ? ((String) iconCompat.b).split(":", -1)[0] : iconCompat.j;
                }
                iconCreateWithBitmap = Icon.createWithResource(strE, iconCompat.e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.b, iconCompat.e, iconCompat.f);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.b);
                break;
            case 5:
                iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.a((Bitmap) iconCompat.b, false)) : ao.b((Bitmap) iconCompat.b);
                break;
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    iconCreateWithBitmap = o0.a(iconCompat.f());
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.f());
                    }
                    Uri uriF = iconCompat.f();
                    String scheme = uriF.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uriF);
                        } catch (Exception unused2) {
                            uriF.toString();
                        }
                        break;
                    } else {
                        try {
                            inputStreamOpenInputStream = new FileInputStream(new File((String) iconCompat.b));
                        } catch (FileNotFoundException unused3) {
                            uriF.toString();
                        }
                    }
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.f());
                    }
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(inputStreamOpenInputStream), false));
                    } else {
                        iconCreateWithBitmap = ao.b(BitmapFactory.decodeStream(inputStreamOpenInputStream));
                    }
                }
                break;
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.h;
        if (mode != IconCompat.k) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }
}
