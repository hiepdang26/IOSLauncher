package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a50 {
    public static final gq0 a = new gq0(2);
    public static final pi b = new pi(1);

    public static t3 a(Context context, List list) {
        z71.c("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                b50 b50Var = (b50) list.get(i);
                ProviderInfo providerInfoB = b(context.getPackageManager(), b50Var, context.getResources());
                if (providerInfoB == null) {
                    return new t3(6, false);
                }
                arrayList.add(c(context, b50Var, providerInfoB.authority));
            }
            return new t3(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, b50 b50Var, Resources resources) {
        z71.c("FontProvider.getProvider");
        try {
            List listU = b50Var.d;
            String str = b50Var.a;
            String str2 = b50Var.b;
            if (listU == null) {
                listU = p02.u(0, resources);
            }
            z40 z40Var = new z40();
            z40Var.a = str;
            z40Var.b = str2;
            z40Var.c = listU;
            gq0 gq0Var = a;
            ProviderInfo providerInfo = (ProviderInfo) gq0Var.get(z40Var);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            pi piVar = b;
            Collections.sort(arrayList, piVar);
            for (int i = 0; i < listU.size(); i++) {
                ArrayList arrayList2 = new ArrayList((Collection) listU.get(i));
                Collections.sort(arrayList2, piVar);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                            break;
                        }
                    }
                    gq0Var.put(z40Var, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    public static m50[] c(Context context, b50 b50Var, String str) {
        z71.c("FontProvider.query");
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            y40 mc1Var = Build.VERSION.SDK_INT < 24 ? new mc1(uriBuild, context) : new nx0(uriBuild, context);
            Cursor cursorG = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                z71.c("ContentQueryWrapper.query");
                try {
                    cursorG = mc1Var.g(uriBuild, strArr, new String[]{b50Var.c});
                    Trace.endSection();
                    if (cursorG != null && cursorG.getCount() > 0) {
                        int columnIndex = cursorG.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursorG.getColumnIndex("_id");
                        int columnIndex3 = cursorG.getColumnIndex("file_id");
                        int columnIndex4 = cursorG.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorG.getColumnIndex("font_weight");
                        int columnIndex6 = cursorG.getColumnIndex("font_italic");
                        while (cursorG.moveToNext()) {
                            int i = columnIndex != -1 ? cursorG.getInt(columnIndex) : 0;
                            arrayList2.add(new m50(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorG.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorG.getLong(columnIndex3)), columnIndex4 != -1 ? cursorG.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorG.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorG.getInt(columnIndex6) == 1, i));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorG != null) {
                        cursorG.close();
                    }
                    mc1Var.close();
                    return (m50[]) arrayList.toArray(new m50[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursorG != null) {
                    cursorG.close();
                }
                mc1Var.close();
                throw th;
            }
        } finally {
        }
    }
}
