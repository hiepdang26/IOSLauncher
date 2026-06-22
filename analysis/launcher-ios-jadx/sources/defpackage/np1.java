package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.widget.TintTypedArray;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzbdo;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.material.appbar.MaterialToolbar;
import com.luutinhit.launcher6.CellLayout;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public abstract class np1 {
    public static final wg1 a = new wg1("UNDEFINED", 1);
    public static final wg1 b = new wg1("REUSABLE_CLAIMED", 1);
    public static final wg1 c = new wg1("NULL", 1);
    public static final wg1 d = new wg1("UNINITIALIZED", 1);
    public static final y4 e = new y4(9);

    public static boolean A(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static void B(gp gpVar, s70 s70Var) {
        f huVar = new hu(e42.l(gpVar, sz.g), true, 1);
        huVar.Q(1, huVar, s70Var);
    }

    public static TypedArray C(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static void D(View view, Bundle bundle) {
        jj1 jj1Var;
        if (view == null) {
            return;
        }
        for (ViewParent parent = view.getParent(); parent != null && (parent instanceof View); parent = parent.getParent()) {
            if (parent instanceof jj1) {
                jj1Var = (jj1) parent;
                break;
            }
        }
        jj1Var = null;
        if (jj1Var != null) {
            jj1Var.u(view, bundle);
        } else {
            WeakReference weakReference = jk0.h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void E(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                throw new IllegalArgumentException(uo.k(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof v1) {
                ((v1) activity).getClass();
            }
            t1.l(activity, strArr, i);
        } else if (activity instanceof u1) {
            new Handler(Looper.getMainLooper()).post(new s1(strArr2, activity, i, 0));
        }
    }

    public static final void F(gg ggVar, eo eoVar, boolean z) {
        Object obj = gg.m.get(ggVar);
        Throwable thD = ggVar.d(obj);
        Object objE = thD != null ? e(thD) : ggVar.e(obj);
        if (!z) {
            eoVar.resumeWith(objE);
            return;
        }
        qg0.i(eoVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        yv yvVar = (yv) eoVar;
        go goVar = yvVar.k;
        yo context = goVar.getContext();
        Object objA = bf1.A(context, yvVar.m);
        if (objA != bf1.f) {
            e42.u(goVar, context);
        }
        try {
            goVar.resumeWith(objE);
        } finally {
            bf1.t(context, objA);
        }
    }

    public static final void G(Object obj, eo eoVar) {
        if (!(eoVar instanceof yv)) {
            eoVar.resumeWith(obj);
            return;
        }
        yv yvVar = (yv) eoVar;
        Throwable thA = yb1.a(obj);
        Object ukVar = thA == null ? obj : new uk(false, thA);
        go goVar = yvVar.k;
        goVar.getContext();
        cp cpVar = yvVar.j;
        if (cpVar.B()) {
            yvVar.l = ukVar;
            yvVar.i = 1;
            cpVar.z(goVar.getContext(), yvVar);
            return;
        }
        v00 v00VarA = on1.a();
        if (v00VarA.i >= 4294967296L) {
            yvVar.l = ukVar;
            yvVar.i = 1;
            v00VarA.D(yvVar);
            return;
        }
        v00VarA.F(true);
        try {
            fi0 fi0Var = (fi0) goVar.getContext().n(iy.i);
            if (fi0Var == null || fi0Var.a()) {
                Object obj2 = yvVar.m;
                yo context = goVar.getContext();
                Object objA = bf1.A(context, obj2);
                if (objA != bf1.f) {
                    e42.u(goVar, context);
                }
                try {
                    goVar.resumeWith(obj);
                } finally {
                    bf1.t(context, objA);
                }
            } else {
                CancellationException cancellationExceptionW = ((xi0) fi0Var).w();
                yvVar.b(ukVar, cancellationExceptionW);
                yvVar.resumeWith(e(cancellationExceptionW));
            }
            while (v00VarA.G()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static boolean H(int i) {
        return i == 21 || i == 22 || i == 19 || i == 20 || i == 122 || i == 123 || i == 92 || i == 93 || i == 67 || i == 112;
    }

    public static final void I(Object obj) {
        if (obj instanceof xb1) {
            throw ((xb1) obj).g;
        }
    }

    public static void J(Context context) {
        boolean z;
        Object obj = ub2.b;
        if (((Boolean) zzbdo.zza.zze()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                    synchronized (ub2.b) {
                        z = ub2.c;
                    }
                    if (z) {
                        return;
                    }
                    do0 do0VarZzb = new n62(context).zzb();
                    k92.g("Updating ad debug logging enablement.");
                    zzbzr.zza(do0VarZzb, "AdDebugLogUpdater.updateEnablement");
                }
            } catch (Exception unused) {
                k92.j(5);
            }
        }
    }

    public static xf a(hu huVar) {
        vf vfVar = new vf();
        vfVar.c = new db1();
        xf xfVar = new xf(vfVar);
        vfVar.b = xfVar;
        vfVar.a = uo.class;
        try {
            huVar.D(new vo(vfVar, huVar));
            vfVar.a = "Deferred.asListenableFuture";
            return xfVar;
        } catch (Exception e2) {
            xfVar.h.h(e2);
            return xfVar;
        }
    }

    public static hu b(bo boVar, s70 s70Var) {
        hu huVar = new hu(e42.l(boVar, sz.g), true, 0);
        huVar.Q(1, huVar, s70Var);
        return huVar;
    }

    public static void c(int i, Object obj) {
        if (obj instanceof y70) {
            if ((obj instanceof z70 ? ((z70) obj).getArity() : obj instanceof d70 ? 0 : obj instanceof o70 ? 1 : obj instanceof s70 ? 2 : obj instanceof ry1 ? 3 : obj instanceof r60 ? 4 : obj instanceof u70 ? 6 : -1) == i) {
                return;
            }
        }
        ClassCastException classCastException = new ClassCastException(uo.i(obj.getClass().getName(), " cannot be cast to ", k31.k(i, "kotlin.jvm.functions.Function")));
        qg0.G(classCastException, np1.class.getName());
        throw classCastException;
    }

    public static int d(Context context, String str) {
        if (str != null) {
            return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : new cy0(context).a() ? 0 : -1;
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static final xb1 e(Throwable th) {
        qg0.l(th, "exception");
        return new xb1(th);
    }

    public static int[][] f(int i, int i2) {
        int[] iArr = {i, i2};
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr);
        for (int i3 = 0; i3 < i; i3++) {
            Arrays.fill(iArr2[i3], -1);
        }
        return iArr2;
    }

    public static int[][] g(CellLayout cellLayout) {
        ng1 shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
        int countX = cellLayout.getCountX();
        int countY = cellLayout.getCountY();
        boolean zD = shortcutsAndWidgets.d();
        int[][] iArrF = f(countX, countY);
        for (int i = 0; i < shortcutsAndWidgets.getChildCount(); i++) {
            View childAt = shortcutsAndWidgets.getChildAt(i);
            if (childAt.isFocusable()) {
                int i2 = ((zg) childAt.getLayoutParams()).a;
                int i3 = ((zg) childAt.getLayoutParams()).b;
                if (zD) {
                    i2 = (countX - i2) - 1;
                }
                iArrF[i2][i3] = i;
            }
        }
        return iArrF;
    }

    public static int[][] h(CellLayout cellLayout, CellLayout cellLayout2, int i) {
        ng1 shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
        ng1 shortcutsAndWidgets2 = cellLayout2.getShortcutsAndWidgets();
        boolean z = cellLayout2.getCountX() > cellLayout.getCountX();
        int countX = cellLayout2.getCountX();
        int countY = cellLayout2.getCountY() + cellLayout.getCountY();
        int[][] iArrF = f(countX, countY);
        if (z) {
            for (int i2 = 0; i2 < countY; i2++) {
                iArrF[i][i2] = -11;
            }
        }
        for (int i3 = 0; i3 < shortcutsAndWidgets.getChildCount(); i3++) {
            View childAt = shortcutsAndWidgets.getChildAt(i3);
            if (childAt.isFocusable()) {
                int i4 = ((zg) childAt.getLayoutParams()).a;
                int i5 = ((zg) childAt.getLayoutParams()).b;
                if (z && i4 >= i) {
                    i4++;
                }
                iArrF[i4][i5] = i3;
            }
        }
        for (int childCount = shortcutsAndWidgets2.getChildCount() - 1; childCount >= 0; childCount--) {
            iArrF[((zg) shortcutsAndWidgets2.getChildAt(childCount).getLayoutParams()).a][cellLayout.getCountY()] = shortcutsAndWidgets.getChildCount() + childCount;
        }
        return iArrF;
    }

    public static int[][] i(CellLayout cellLayout, int i, int i2) {
        ng1 shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
        int[][] iArrF = f(cellLayout.getCountX() + 1, cellLayout.getCountY());
        for (int i3 = 0; i3 < shortcutsAndWidgets.getChildCount(); i3++) {
            View childAt = shortcutsAndWidgets.getChildAt(i3);
            if (childAt.isFocusable()) {
                int i4 = ((zg) childAt.getLayoutParams()).a;
                int i5 = ((zg) childAt.getLayoutParams()).b;
                if (i < 0) {
                    iArrF[i4 - i][i5] = i3;
                } else {
                    iArrF[i4][i5] = i3;
                }
            }
        }
        if (i < 0) {
            iArrF[0][i2] = 100;
            return iArrF;
        }
        iArrF[i][i2] = 100;
        return iArrF;
    }

    public static int j(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static int k(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? t1.d(context, i) : context.getResources().getColor(i);
    }

    public static ColorStateList l(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListM;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListM = hg0.m(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListM;
    }

    public static ColorStateList m(Context context, TintTypedArray tintTypedArray, int i) {
        int resourceId;
        ColorStateList colorStateListM;
        return (!tintTypedArray.hasValue(i) || (resourceId = tintTypedArray.getResourceId(i, 0)) == 0 || (colorStateListM = hg0.m(context, resourceId)) == null) ? tintTypedArray.getColorStateList(i) : colorStateListM;
    }

    public static Drawable n(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableO;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableO = hg0.o(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableO;
    }

    public static xk o(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        xk xkVarA;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i2 = typedValue.type;
            if (i2 >= 28 && i2 <= 31) {
                return new xk((Shader) null, (ColorStateList) null, typedValue.data);
            }
            try {
                xkVarA = xk.a(typedArray.getResourceId(i, 0), theme, typedArray.getResources());
            } catch (Exception unused) {
                xkVarA = null;
            }
            if (xkVarA != null) {
                return xkVarA;
            }
        }
        return new xk((Shader) null, (ColorStateList) null, 0);
    }

    public static String p(TypedArray typedArray, XmlResourceParser xmlResourceParser, String str, int i) {
        if (x(xmlResourceParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static int q(ArrayList arrayList, InputStream inputStream, cq0 cq0Var) throws IOException {
        if (inputStream != null) {
            if (!inputStream.markSupported()) {
                inputStream = new k81(inputStream, cq0Var);
            }
            inputStream.mark(5242880);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    int iB = ((af0) arrayList.get(i)).b(inputStream, cq0Var);
                    if (iB != -1) {
                        return iB;
                    }
                } finally {
                    inputStream.reset();
                }
            }
        }
        return -1;
    }

    public static ArrayList r(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < materialToolbar.getChildCount(); i++) {
            View childAt = materialToolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static ImageHeaderParser$ImageType s(ArrayList arrayList, InputStream inputStream, cq0 cq0Var) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new k81(inputStream, cq0Var);
        }
        inputStream.mark(5242880);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeD = ((af0) arrayList.get(i)).d(inputStream);
                inputStream.reset();
                if (imageHeaderParser$ImageTypeD != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeD;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType t(ArrayList arrayList, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeA = ((af0) arrayList.get(i)).a(byteBuffer);
                AtomicReference atomicReference = cf.a;
                if (imageHeaderParser$ImageTypeA != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeA;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = cf.a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static int u(int i, int i2, int i3, int i4, boolean z, int[][] iArr) {
        if (iArr == null) {
            throw new IllegalStateException("Dpad navigation requires a matrix.");
        }
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < i2; i7++) {
            for (int i8 = 0; i8 < i3; i8++) {
                if (iArr[i7][i8] == i) {
                    i5 = i7;
                    i6 = i8;
                }
            }
        }
        int i9 = i5 + i4;
        int iY = -1;
        while (i9 >= 0 && i9 < i2) {
            iY = y(i9, i6, i2, i3, iArr);
            if (iY != -1 && iY != -11) {
                return iY;
            }
            i9 += i4;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i10 = 1; i10 < i3; i10++) {
            int i11 = i10 * i4;
            int i12 = i6 + i11;
            int i13 = i6 - i11;
            int i14 = i11 + i5;
            if (y(i14, i12, i2, i3, iArr) == -11) {
                z2 = true;
            }
            if (y(i14, i13, i2, i3, iArr) == -11) {
                z3 = true;
            }
            while (i14 >= 0 && i14 < i2) {
                int iY2 = y(i14, ((!z2 || i14 >= i2 + (-1)) ? 0 : i4) + i12, i2, i3, iArr);
                if (iY2 != -1) {
                    return iY2;
                }
                iY = y(i14, ((!z3 || i14 >= i2 + (-1)) ? 0 : -i4) + i13, i2, i3, iArr);
                if (iY != -1) {
                    return iY;
                }
                i14 += i4;
            }
        }
        return i == 100 ? z ? i4 < 0 ? -8 : -4 : i4 < 0 ? -4 : -8 : iY;
    }

    public static int v(int i, int i2, int i3, int i4, int[][] iArr) {
        if (iArr == null) {
            throw new IllegalStateException("Dpad navigation requires a matrix.");
        }
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < i2; i7++) {
            for (int i8 = 0; i8 < i3; i8++) {
                if (iArr[i7][i8] == i) {
                    i6 = i7;
                    i5 = i8;
                }
            }
        }
        int i9 = i5 + i4;
        int iY = -1;
        while (i9 >= 0 && i9 < i3 && i9 >= 0) {
            iY = y(i6, i9, i2, i3, iArr);
            if (iY != -1 && iY != -11) {
                return iY;
            }
            i9 += i4;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i10 = 1; i10 < i2; i10++) {
            int i11 = i10 * i4;
            int i12 = i6 + i11;
            int i13 = i6 - i11;
            int i14 = i11 + i5;
            if (y(i12, i14, i2, i3, iArr) == -11) {
                z = true;
            }
            if (y(i13, i14, i2, i3, iArr) == -11) {
                z2 = true;
            }
            while (i14 >= 0 && i14 < i3) {
                int iY2 = y(((!z || i14 >= i3 + (-1)) ? 0 : i4) + i12, i14, i2, i3, iArr);
                if (iY2 != -1) {
                    return iY2;
                }
                iY = y(((!z2 || i14 >= i3 + (-1)) ? 0 : -i4) + i13, i14, i2, i3, iArr);
                if (iY != -1) {
                    return iY;
                }
                i14 += i4;
            }
        }
        return iY;
    }

    public static int w(int i, int i2, int i3, int i4, boolean z, int[][] iArr) {
        int length = iArr == null ? -1 : iArr.length;
        int length2 = iArr == null ? -1 : iArr[0].length;
        if (i == 92) {
            return i3 > 0 ? -3 : -6;
        }
        if (i == 93) {
            return i3 < i4 - 1 ? -8 : -7;
        }
        if (i == 122) {
            return -6;
        }
        if (i == 123) {
            return -7;
        }
        switch (i) {
            case 19:
                return v(i2, length, length2, -1, iArr);
            case 20:
                return v(i2, length, length2, 1, iArr);
            case zzbbc.zzt.zzm /* 21 */:
                int iU = u(i2, length, length2, -1, z, iArr);
                if (!z && iU == -1 && i3 > 0) {
                    return -2;
                }
                if (z && iU == -1 && i3 < i4 - 1) {
                    return -10;
                }
                return iU;
            case 22:
                int iU2 = u(i2, length, length2, 1, z, iArr);
                if (!z && iU2 == -1 && i3 < i4 - 1) {
                    return -9;
                }
                if (z && iU2 == -1 && i3 > 0) {
                    return -5;
                }
                return iU2;
            default:
                return -1;
        }
    }

    public static boolean x(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int y(int i, int i2, int i3, int i4, int[][] iArr) {
        int i5;
        if (i < 0 || i >= i3 || i2 < 0 || i2 >= i4 || (i5 = iArr[i][i2]) == -1) {
            return -1;
        }
        return i5;
    }

    public static boolean z(String str) {
        x5 x5Var = ww1.a;
        Set<pl> setUnmodifiableSet = Collections.unmodifiableSet(y5.c);
        HashSet hashSet = new HashSet();
        for (pl plVar : setUnmodifiableSet) {
            if (((y5) plVar).a.equals(str)) {
                hashSet.add(plVar);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature ".concat(str));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            y5 y5Var = (y5) ((pl) it.next());
            if (y5Var.a() || y5Var.b()) {
                return true;
            }
        }
        return false;
    }
}
