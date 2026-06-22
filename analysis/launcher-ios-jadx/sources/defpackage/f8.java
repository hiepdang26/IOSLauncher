package defpackage;

import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.leftpage.widgets.PhotoWidget_2x2;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f8 implements Callable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ViewGroup h;
    public final /* synthetic */ Object i;

    public /* synthetic */ f8(ViewGroup viewGroup, Object obj, int i) {
        this.g = i;
        this.h = viewGroup;
        this.i = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Throwable {
        LauncherApps launcherApps;
        String str;
        Cursor cursorQuery;
        ComponentName componentName;
        String packageName = null;
        uriWithAppendedId = null;
        uriWithAppendedId = null;
        v6 v6Var = null;
        uriWithAppendedId = null;
        Uri uriWithAppendedId = null;
        Cursor cursor = null;
        int i = 0;
        ViewGroup viewGroup = this.h;
        Object obj = this.i;
        switch (this.g) {
            case 0:
                l8 l8Var = (l8) viewGroup;
                Thread.currentThread().getName();
                wb2 wb2Var = l8Var.u;
                ArrayList arrayList = (ArrayList) obj;
                Collections.sort(arrayList, (z6) wb2Var.i);
                try {
                    new ur0(new j7(l8Var, arrayList)).B(ee1.a).z(new vr0(new mc1(l8Var, 5), x4.a(), 0));
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    ArrayList arrayList8 = new ArrayList();
                    ArrayList arrayList9 = new ArrayList();
                    ArrayList arrayList10 = new ArrayList();
                    ArrayList arrayList11 = new ArrayList();
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj2 = arrayList.get(i2);
                        i2++;
                        int i3 = size;
                        v6 v6Var2 = (v6) obj2;
                        if (v6Var2 != null && v6Var2.B != null) {
                            switch (l8Var.n(v6Var2)) {
                                case 1:
                                    if (!arrayList2.contains(v6Var2)) {
                                        arrayList2.add(v6Var2);
                                    }
                                    break;
                                case 2:
                                    if (!arrayList3.contains(v6Var2)) {
                                        arrayList3.add(v6Var2);
                                    }
                                    break;
                                case 3:
                                    if (!arrayList4.contains(v6Var2)) {
                                        arrayList4.add(v6Var2);
                                    }
                                    break;
                                case 4:
                                    if (!arrayList5.contains(v6Var2)) {
                                        arrayList5.add(v6Var2);
                                    }
                                    break;
                                case 5:
                                    if (!arrayList6.contains(v6Var2)) {
                                        arrayList6.add(v6Var2);
                                    }
                                    break;
                                case 6:
                                    if (!arrayList7.contains(v6Var2)) {
                                        arrayList7.add(v6Var2);
                                    }
                                    break;
                                case 7:
                                    if (!arrayList8.contains(v6Var2)) {
                                        arrayList8.add(v6Var2);
                                    }
                                    break;
                                case 8:
                                    if (!arrayList9.contains(v6Var2)) {
                                        arrayList9.add(v6Var2);
                                    }
                                    break;
                                default:
                                    if (!arrayList10.contains(v6Var2)) {
                                        arrayList10.add(v6Var2);
                                    }
                                    break;
                            }
                        }
                        size = i3;
                    }
                    int size2 = arrayList.size();
                    for (int i4 = 1; i4 <= 4; i4++) {
                        int i5 = size2 - i4;
                        if (i5 >= 0) {
                            arrayList11.add((v6) arrayList.get(i5));
                        }
                    }
                    z6 z6Var = (z6) wb2Var.i;
                    Collections.sort(arrayList11, z6Var);
                    ArrayList arrayList12 = l8Var.l;
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.recent), arrayList11));
                    Collections.sort(arrayList2, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.game), arrayList2));
                    Collections.sort(arrayList3, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.audio), arrayList3));
                    Collections.sort(arrayList4, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.video), arrayList4));
                    Collections.sort(arrayList5, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.image), arrayList5));
                    Collections.sort(arrayList6, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.social), arrayList6));
                    Collections.sort(arrayList7, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.news), arrayList7));
                    Collections.sort(arrayList8, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.maps), arrayList8));
                    Collections.sort(arrayList9, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.productivity), arrayList9));
                    Collections.sort(arrayList10, z6Var);
                    arrayList12.add(new x7(l8Var.getResources().getString(w61.other), arrayList10));
                    return arrayList12;
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th) {
                    hg0.C(th);
                    NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                    nullPointerException.initCause(th);
                    throw nullPointerException;
                }
            case 1:
                SparseArray sparseArray = BubbleTextView.F;
                BubbleTextView bubbleTextView = (BubbleTextView) viewGroup;
                try {
                    if (ar1.e && (launcherApps = bubbleTextView.D) != null && launcherApps.hasShortcutHostPermission() && (str = bubbleTextView.w) != null) {
                        if (str.contains("/")) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(bubbleTextView.w);
                            if (componentNameUnflattenFromString != null) {
                                packageName = componentNameUnflattenFromString.getPackageName();
                            }
                        } else {
                            packageName = bubbleTextView.w;
                        }
                        if (packageName != null) {
                            ae.f();
                            LauncherApps.ShortcutQuery shortcutQueryA = ae.a();
                            shortcutQueryA.setQueryFlags(11);
                            shortcutQueryA.setPackage(packageName);
                            List shortcuts = launcherApps.getShortcuts(shortcutQueryA, ((qh0) obj).w.a);
                            bubbleTextView.E = shortcuts;
                            Objects.toString(shortcuts);
                            return Boolean.TRUE;
                        }
                    }
                } catch (Throwable unused) {
                }
                return Boolean.FALSE;
            case 2:
                int i6 = PhotoWidget_2x2.q;
                ((PhotoWidget_2x2) viewGroup).getClass();
                try {
                    Uri contentUri = MediaStore.Images.Media.getContentUri("external");
                    String[] strArr = {"_id"};
                    Context context = (Context) obj;
                    if (Build.VERSION.SDK_INT >= 29) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("android:query-arg-limit", 1);
                        bundle.putString("android:query-arg-sql-sort-order", "RANDOM()");
                        cursorQuery = context.getContentResolver().query(contentUri, strArr, bundle, null);
                    } else {
                        cursorQuery = context.getContentResolver().query(contentUri, strArr, null, null, "RANDOM() LIMIT 1");
                    }
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                uriWithAppendedId = ContentUris.withAppendedId(contentUri, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")));
                            }
                        } catch (IllegalArgumentException unused2) {
                            if (cursorQuery != null) {
                            }
                            Objects.toString(uriWithAppendedId);
                            return uriWithAppendedId;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    break;
                } catch (IllegalArgumentException unused3) {
                    cursorQuery = null;
                } catch (Throwable th3) {
                    th = th3;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                Objects.toString(uriWithAppendedId);
                return uriWithAppendedId;
            case 3:
                ArrayList arrayList13 = ((SearchViewLayout) viewGroup).r;
                int size3 = arrayList13.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj3 = arrayList13.get(i7);
                    i7++;
                    v6 v6Var3 = (v6) obj3;
                    if (v6Var3 != null && (componentName = v6Var3.A) != null && componentName.flattenToString().equals((String) obj)) {
                        v6Var = v6Var3;
                    }
                }
                if (v6Var != null) {
                    arrayList13.remove(v6Var);
                    arrayList13.add(0, v6Var);
                }
                return arrayList13;
            default:
                CharSequence charSequence = (CharSequence) obj;
                int i8 = WidgetsContainerView.i0;
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) viewGroup;
                widgetsContainerView.getClass();
                Thread.currentThread().getName();
                try {
                    if (widgetsContainerView.b0 != null) {
                        String string = charSequence.toString();
                        if (string.isEmpty()) {
                            qx1 qx1Var = widgetsContainerView.b0;
                            HashMap map = qx1Var.d;
                            map.clear();
                            map.putAll(qx1Var.c);
                            ArrayList arrayList14 = qx1Var.b;
                            arrayList14.clear();
                            arrayList14.addAll(qx1Var.a);
                        } else {
                            qx1 qx1Var2 = widgetsContainerView.b0;
                            qx1Var2.b.clear();
                            qx1Var2.d.clear();
                            if (widgetsContainerView.b0.c != null) {
                                while (i < widgetsContainerView.b0.a.size()) {
                                    ArrayList arrayList15 = widgetsContainerView.b0.a;
                                    s01 s01Var = (i >= arrayList15.size() || i < 0) ? null : (s01) arrayList15.get(i);
                                    if (s01Var.u.toString().toLowerCase().contains(string.toLowerCase())) {
                                        qx1 qx1Var3 = widgetsContainerView.b0;
                                        ArrayList arrayList16 = (ArrayList) qx1Var3.c.get(qx1Var3.a.get(i));
                                        qx1Var3.b.add(s01Var);
                                        qx1Var3.d.put(s01Var, arrayList16);
                                    }
                                    i++;
                                }
                            }
                        }
                    }
                } catch (Throwable th4) {
                    th4.getMessage();
                }
                return widgetsContainerView.b0;
        }
    }
}
