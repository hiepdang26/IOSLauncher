package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionScene;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzbtq;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Hotseat;
import com.luutinhit.launcher6.UninstallDropTarget;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.concurrent.Callable;
import org.apache.commons.collections4.trie.KeyAnalyzer;

/* JADX INFO: loaded from: classes.dex */
public abstract class bf1 {
    public static ze1 a;
    public static long b;
    public static s4 e;
    public static Boolean g;
    public static Boolean h;
    public static Boolean i;
    public static Boolean j;
    public static Boolean k;
    public static Boolean l;
    public static Field m;
    public static boolean n;
    public static Class o;
    public static boolean p;
    public static Field q;
    public static boolean r;
    public static Field s;
    public static boolean t;
    public static Point u;
    public static final ub c = new ub();
    public static final s4 d = new s4(null, null, null);
    public static final wg1 f = new wg1("NO_THREAD_ELEMENTS", 1);

    public static final Object A(yo yoVar, Object obj) {
        if (obj == null) {
            obj = yoVar.h(0, zo.j);
            qg0.h(obj);
        }
        if (obj == 0) {
            return f;
        }
        if (obj instanceof Integer) {
            return yoVar.h(new qn1(((Number) obj).intValue(), yoVar), zo.l);
        }
        k31.q(obj);
        throw null;
    }

    public static void B(int i2, om omVar, jn jnVar) {
        gm gmVar;
        gm gmVar2;
        gm gmVar3;
        gm gmVar4;
        if (jnVar.n) {
            return;
        }
        if (!(jnVar instanceof kn) && jnVar.A() && b(jnVar)) {
            kn.U(jnVar, omVar, new ub());
        }
        gm gmVarJ = jnVar.j(3);
        gm gmVarJ2 = jnVar.j(5);
        int iD = gmVarJ.d();
        int iD2 = gmVarJ2.d();
        HashSet<gm> hashSet = gmVarJ.a;
        in inVar = in.i;
        if (hashSet != null && gmVarJ.c) {
            for (gm gmVar5 : hashSet) {
                jn jnVar2 = gmVar5.d;
                int i3 = i2 + 1;
                boolean zB = b(jnVar2);
                if (jnVar2.A() && zB) {
                    kn.U(jnVar2, omVar, new ub());
                }
                gm gmVar6 = jnVar2.J;
                gm gmVar7 = jnVar2.L;
                boolean z = (gmVar5 == gmVar6 && (gmVar4 = gmVar7.f) != null && gmVar4.c) || (gmVar5 == gmVar7 && (gmVar3 = gmVar6.f) != null && gmVar3.c);
                in inVar2 = jnVar2.T[1];
                if (inVar2 != inVar || zB) {
                    if (!jnVar2.A()) {
                        if (gmVar5 == gmVar6 && gmVar7.f == null) {
                            int iE = gmVar6.e() + iD;
                            jnVar2.J(iE, jnVar2.l() + iE);
                            B(i3, omVar, jnVar2);
                        } else if (gmVar5 == gmVar7 && gmVar6.f == null) {
                            int iE2 = iD - gmVar7.e();
                            jnVar2.J(iE2 - jnVar2.l(), iE2);
                            B(i3, omVar, jnVar2);
                        } else if (z && !jnVar2.z()) {
                            w(i3, omVar, jnVar2);
                        }
                    }
                } else if (inVar2 == inVar && jnVar2.y >= 0 && jnVar2.x >= 0 && (jnVar2.h0 == 8 || (jnVar2.s == 0 && jnVar2.X == 0.0f))) {
                    if (!jnVar2.z() && !jnVar2.F && z && !jnVar2.z()) {
                        x(i3, jnVar, omVar, jnVar2);
                    }
                }
            }
        }
        char c2 = 1;
        if (jnVar instanceof va0) {
            return;
        }
        HashSet<gm> hashSet2 = gmVarJ2.a;
        if (hashSet2 != null && gmVarJ2.c) {
            for (gm gmVar8 : hashSet2) {
                jn jnVar3 = gmVar8.d;
                int i4 = i2 + 1;
                boolean zB2 = b(jnVar3);
                if (jnVar3.A() && zB2) {
                    kn.U(jnVar3, omVar, new ub());
                }
                gm gmVar9 = jnVar3.J;
                gm gmVar10 = jnVar3.L;
                boolean z2 = (gmVar8 == gmVar9 && (gmVar2 = gmVar10.f) != null && gmVar2.c) || (gmVar8 == gmVar10 && (gmVar = gmVar9.f) != null && gmVar.c);
                in inVar3 = jnVar3.T[1];
                if (inVar3 != inVar || zB2) {
                    if (!jnVar3.A()) {
                        if (gmVar8 == gmVar9 && gmVar10.f == null) {
                            int iE3 = gmVar9.e() + iD2;
                            jnVar3.J(iE3, jnVar3.l() + iE3);
                            B(i4, omVar, jnVar3);
                        } else if (gmVar8 == gmVar10 && gmVar9.f == null) {
                            int iE4 = iD2 - gmVar10.e();
                            jnVar3.J(iE4 - jnVar3.l(), iE4);
                            B(i4, omVar, jnVar3);
                        } else if (z2 && !jnVar3.z()) {
                            w(i4, omVar, jnVar3);
                        }
                    }
                } else if (inVar3 == inVar && jnVar3.y >= 0 && jnVar3.x >= 0 && (jnVar3.h0 == 8 || (jnVar3.s == 0 && jnVar3.X == 0.0f))) {
                    if (!jnVar3.z() && !jnVar3.F && z2 && !jnVar3.z()) {
                        x(i4, jnVar, omVar, jnVar3);
                    }
                }
            }
        }
        gm gmVarJ3 = jnVar.j(6);
        if (gmVarJ3.a != null && gmVarJ3.c) {
            int iD3 = gmVarJ3.d();
            for (gm gmVar11 : gmVarJ3.a) {
                jn jnVar4 = gmVar11.d;
                int i5 = i2 + 1;
                boolean zB3 = b(jnVar4);
                if (jnVar4.A() && zB3) {
                    kn.U(jnVar4, omVar, new ub());
                }
                if (jnVar4.T[c2] != inVar || zB3) {
                    if (jnVar4.A()) {
                        continue;
                    } else {
                        gm gmVar12 = jnVar4.M;
                        if (gmVar11 == gmVar12) {
                            int iE5 = gmVar11.e() + iD3;
                            if (jnVar4.E) {
                                int i6 = iE5 - jnVar4.b0;
                                int i7 = jnVar4.W + i6;
                                jnVar4.a0 = i6;
                                jnVar4.J.l(i6);
                                jnVar4.L.l(i7);
                                gmVar12.l(iE5);
                                jnVar4.l = true;
                            }
                            B(i5, omVar, jnVar4);
                        }
                    }
                }
                c2 = 1;
            }
        }
        jnVar.n = true;
    }

    public static Object C(Context context, Callable callable) {
        try {
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return callable.call();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Throwable th) {
            k92.f();
            zzbtq.zza(context).zzh(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }

    public static boolean D(Context context) {
        if (h == null) {
            h = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return h.booleanValue();
    }

    public static void a(xk1 xk1Var, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            if (obj == null) {
                xk1Var.g(i2);
            } else if (obj instanceof byte[]) {
                xk1Var.s(i2, (byte[]) obj);
            } else if (obj instanceof Float) {
                xk1Var.i(i2, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                xk1Var.i(i2, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                xk1Var.q(i2, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                xk1Var.q(i2, ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                xk1Var.q(i2, ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                xk1Var.q(i2, ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                xk1Var.e(i2, (String) obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                }
                xk1Var.q(i2, ((Boolean) obj).booleanValue() ? 1L : 0L);
            }
        }
    }

    public static boolean b(jn jnVar) {
        in[] inVarArr = jnVar.T;
        in inVar = inVarArr[0];
        in inVar2 = inVarArr[1];
        jn jnVar2 = jnVar.U;
        kn knVar = jnVar2 != null ? (kn) jnVar2 : null;
        in inVar3 = in.g;
        if (knVar != null) {
            in inVar4 = knVar.T[0];
        }
        if (knVar != null) {
            in inVar5 = knVar.T[1];
        }
        in inVar6 = in.i;
        in inVar7 = in.h;
        boolean z = inVar == inVar3 || jnVar.B() || inVar == inVar7 || (inVar == inVar6 && jnVar.r == 0 && jnVar.X == 0.0f && jnVar.u(0)) || (inVar == inVar6 && jnVar.r == 1 && jnVar.v(0, jnVar.r()));
        boolean z2 = inVar2 == inVar3 || jnVar.C() || inVar2 == inVar7 || (inVar2 == inVar6 && jnVar.s == 0 && jnVar.X == 0.0f && jnVar.u(1)) || (inVar2 == inVar6 && jnVar.s == 1 && jnVar.v(1, jnVar.l()));
        return (jnVar.X > 0.0f && (z || z2)) || (z && z2);
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void d(Object obj) {
        LongSparseArray longSparseArray;
        if (!p) {
            try {
                o = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            p = true;
        }
        Class cls = o;
        if (cls == null) {
            return;
        }
        if (!r) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                q = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            r = true;
        }
        Field field = q;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static int e(int i2, View view) {
        return z71.o(view.getContext(), view.getClass().getCanonicalName(), i2);
    }

    public static int f(Context context, int i2, int i3) {
        TypedValue typedValueN = z71.n(context, i2);
        return typedValueN != null ? typedValueN.data : i3;
    }

    public static View h(CellLayout cellLayout, boolean z) {
        int countX = cellLayout.getCountX();
        for (int i2 = 0; i2 < cellLayout.getCountY(); i2++) {
            int i3 = z ? -1 : 1;
            for (int i4 = z ? countX - 1 : 0; i4 >= 0 && i4 < countX; i4 += i3) {
                View viewB = cellLayout.I.b(i4, i2);
                if (viewB != null && viewB.isFocusable()) {
                    return viewB;
                }
            }
        }
        return null;
    }

    public static View i(CellLayout cellLayout, boolean z) {
        int countX = cellLayout.getCountX();
        for (int countY = cellLayout.getCountY() - 1; countY >= 0; countY--) {
            int i2 = z ? 1 : -1;
            for (int i3 = z ? 0 : countX - 1; i3 >= 0 && i3 < countX; i3 += i2) {
                View viewB = cellLayout.I.b(i3, countY);
                if (viewB != null && viewB.isFocusable()) {
                    return viewB;
                }
            }
        }
        return null;
    }

    public static boolean j(View view, int i2, KeyEvent keyEvent) {
        int[][] iArrG;
        int i3;
        View childAt;
        View viewK;
        boolean zH = np1.H(i2);
        if (keyEvent.getAction() != 1 && zH) {
            t tVar = (t) view.getContext();
            xu deviceProfile = tVar.getDeviceProfile();
            ng1 ng1Var = (ng1) view.getParent();
            CellLayout cellLayout = (CellLayout) ng1Var.getParent();
            Workspace workspace = (Workspace) cellLayout.getParent();
            Hotseat hotseat = (Hotseat) ((ViewGroup) workspace.getParent()).findViewById(v51.hotseat);
            qh0 qh0Var = (qh0) view.getTag();
            int iIndexOfChild = ng1Var.indexOfChild(view);
            int iIndexOfChild2 = workspace.indexOfChild(cellLayout);
            int childCount = workspace.getChildCount();
            CellLayout cellLayout2 = (CellLayout) hotseat.getChildAt(0);
            ng1 shortcutsAndWidgets = cellLayout2.getShortcutsAndWidgets();
            if (i2 == 20) {
                deviceProfile.getClass();
                iArrG = np1.h(cellLayout, cellLayout2, deviceProfile.a.l);
            } else {
                if (i2 == 22) {
                    deviceProfile.getClass();
                }
                int keyCode = keyEvent.getKeyCode();
                if ((keyCode == 67 || keyCode == 112) && keyEvent.hasModifiers(4097)) {
                    iArrG = np1.g(cellLayout);
                    if (UninstallDropTarget.x(tVar, qh0Var)) {
                        UninstallDropTarget.w(tVar, qh0Var);
                    }
                } else {
                    int keyCode2 = keyEvent.getKeyCode();
                    if ((keyCode2 == 67 || keyCode2 == 112) && keyEvent.hasModifiers(MotionScene.Transition.TransitionOnClick.JUMP_TO_START)) {
                        iArrG = np1.g(cellLayout);
                        tVar.removeItem(view, qh0Var, true);
                    } else {
                        iArrG = np1.g(cellLayout);
                    }
                }
            }
            int iW = np1.w(i2, iIndexOfChild, iIndexOfChild2, childCount, ar1.v(view.getResources()), iArrG);
            boolean zV = ar1.v(view.getResources());
            CellLayout cellLayout3 = (CellLayout) workspace.getChildAt(iIndexOfChild2);
            switch (iW) {
                case -10:
                case -2:
                    int i4 = iIndexOfChild2 - 1;
                    if (iW == -10) {
                        i4 = iIndexOfChild2 + 1;
                    }
                    int i5 = i4;
                    int i6 = ((zg) view.getLayoutParams()).b;
                    ng1 shortcutsAndWidgets2 = ((CellLayout) workspace.getChildAt(i5)).getShortcutsAndWidgets();
                    if (shortcutsAndWidgets2 == null) {
                        i3 = i2;
                        childAt = null;
                    } else {
                        CellLayout cellLayout4 = (CellLayout) shortcutsAndWidgets2.getParent();
                        int[][] iArrI = np1.i(cellLayout4, cellLayout4.getCountX(), i6);
                        i3 = i2;
                        int iW2 = np1.w(i3, 100, i5, childCount, ar1.v(view.getResources()), iArrI);
                        childAt = iW2 != -8 ? iW2 != -4 ? shortcutsAndWidgets2.getChildAt(iW2) : l(workspace, cellLayout2, iIndexOfChild2, zV) : k(workspace, cellLayout2, iIndexOfChild2, zV);
                    }
                    break;
                case -9:
                case -5:
                    int i7 = iIndexOfChild2 + 1;
                    if (iW == -5) {
                        i7 = iIndexOfChild2 - 1;
                    }
                    int i8 = i7;
                    int i9 = ((zg) view.getLayoutParams()).b;
                    ng1 shortcutsAndWidgets3 = ((CellLayout) workspace.getChildAt(i8)).getShortcutsAndWidgets();
                    if (shortcutsAndWidgets3 != null) {
                        int iW3 = np1.w(i2, 100, i8, childCount, ar1.v(view.getResources()), np1.i((CellLayout) shortcutsAndWidgets3.getParent(), -1, i9));
                        viewK = iW3 == -8 ? k(workspace, cellLayout2, iIndexOfChild2, zV) : iW3 == -4 ? l(workspace, cellLayout2, iIndexOfChild2, zV) : shortcutsAndWidgets3.getChildAt(iW3);
                        childAt = viewK;
                        i3 = i2;
                    }
                    i3 = i2;
                    childAt = null;
                    break;
                case -8:
                    viewK = k(workspace, cellLayout2, iIndexOfChild2, zV);
                    childAt = viewK;
                    i3 = i2;
                    break;
                case -7:
                    viewK = i(cellLayout3, zV);
                    if (viewK == null) {
                        viewK = i(cellLayout2, zV);
                    }
                    childAt = viewK;
                    i3 = i2;
                    break;
                case -6:
                    viewK = h(cellLayout3, zV);
                    if (viewK == null) {
                        viewK = h(cellLayout2, zV);
                    }
                    childAt = viewK;
                    i3 = i2;
                    break;
                case -4:
                    viewK = l(workspace, cellLayout2, iIndexOfChild2, zV);
                    childAt = viewK;
                    i3 = i2;
                    break;
                case KeyAnalyzer.OUT_OF_BOUNDS_BIT_KEY /* -3 */:
                    int i10 = iIndexOfChild2 - 1;
                    viewK = h((CellLayout) workspace.getChildAt(i10), zV);
                    if (viewK == null) {
                        viewK = h(cellLayout2, zV);
                        workspace.Z(i10);
                    }
                    childAt = viewK;
                    i3 = i2;
                    break;
                default:
                    if (iW < 0 || iW >= ng1Var.getChildCount()) {
                        if (ng1Var.getChildCount() <= iW) {
                            if (iW < shortcutsAndWidgets.getChildCount() + ng1Var.getChildCount()) {
                                viewK = shortcutsAndWidgets.getChildAt(iW - ng1Var.getChildCount());
                            }
                        }
                        i3 = i2;
                        childAt = null;
                    } else {
                        viewK = ng1Var.getChildAt(iW);
                    }
                    childAt = viewK;
                    i3 = i2;
                    break;
            }
            if (childAt != null) {
                childAt.requestFocus();
                r(i3, view);
            }
        }
        return zH;
    }

    public static View k(Workspace workspace, CellLayout cellLayout, int i2, boolean z) {
        int i3 = i2 + 1;
        if (i3 >= workspace.getPageCount()) {
            return null;
        }
        View viewH = h((CellLayout) workspace.getChildAt(i3), z);
        if (viewH != null) {
            return viewH;
        }
        View viewH2 = h(cellLayout, z);
        workspace.Z(i3);
        return viewH2;
    }

    public static View l(Workspace workspace, CellLayout cellLayout, int i2, boolean z) {
        int i3 = i2 - 1;
        if (i3 < 0) {
            return null;
        }
        View viewI = i((CellLayout) workspace.getChildAt(i3), z);
        if (viewI != null) {
            return viewI;
        }
        View viewI2 = i(cellLayout, z);
        workspace.Z(i3);
        return viewI2;
    }

    public static void m(int i2, om omVar, jn jnVar, boolean z) {
        gm gmVar;
        gm gmVar2;
        char c2;
        gm gmVar3;
        gm gmVar4;
        if (jnVar.m) {
            return;
        }
        if (!(jnVar instanceof kn) && jnVar.A() && b(jnVar)) {
            kn.U(jnVar, omVar, new ub());
        }
        gm gmVarJ = jnVar.j(2);
        gm gmVarJ2 = jnVar.j(4);
        int iD = gmVarJ.d();
        int iD2 = gmVarJ2.d();
        HashSet<gm> hashSet = gmVarJ.a;
        in inVar = in.i;
        if (hashSet != null && gmVarJ.c) {
            for (gm gmVar5 : hashSet) {
                jn jnVar2 = gmVar5.d;
                int i3 = i2 + 1;
                boolean zB = b(jnVar2);
                if (jnVar2.A() && zB) {
                    c2 = 0;
                    kn.U(jnVar2, omVar, new ub());
                } else {
                    c2 = 0;
                }
                gm gmVar6 = jnVar2.I;
                gm gmVar7 = jnVar2.K;
                boolean z2 = (gmVar5 == gmVar6 && (gmVar4 = gmVar7.f) != null && gmVar4.c) || (gmVar5 == gmVar7 && (gmVar3 = gmVar6.f) != null && gmVar3.c);
                in inVar2 = jnVar2.T[c2];
                if (inVar2 != inVar || zB) {
                    if (!jnVar2.A()) {
                        if (gmVar5 == gmVar6 && gmVar7.f == null) {
                            int iE = gmVar6.e() + iD;
                            jnVar2.I(iE, jnVar2.r() + iE);
                            m(i3, omVar, jnVar2, z);
                        } else if (gmVar5 == gmVar7 && gmVar6.f == null) {
                            int iE2 = iD - gmVar7.e();
                            jnVar2.I(iE2 - jnVar2.r(), iE2);
                            m(i3, omVar, jnVar2, z);
                        } else if (z2 && !jnVar2.y()) {
                            u(i3, omVar, jnVar2, z);
                        }
                    }
                } else if (inVar2 == inVar && jnVar2.v >= 0 && jnVar2.u >= 0 && (jnVar2.h0 == 8 || (jnVar2.r == 0 && jnVar2.X == 0.0f))) {
                    if (!jnVar2.y() && !jnVar2.F && z2 && !jnVar2.y()) {
                        v(i3, jnVar, omVar, jnVar2, z);
                    }
                }
            }
        }
        if (jnVar instanceof va0) {
            return;
        }
        HashSet<gm> hashSet2 = gmVarJ2.a;
        if (hashSet2 != null && gmVarJ2.c) {
            for (gm gmVar8 : hashSet2) {
                jn jnVar3 = gmVar8.d;
                int i4 = i2 + 1;
                boolean zB2 = b(jnVar3);
                if (jnVar3.A() && zB2) {
                    kn.U(jnVar3, omVar, new ub());
                }
                gm gmVar9 = jnVar3.I;
                gm gmVar10 = jnVar3.K;
                boolean z3 = (gmVar8 == gmVar9 && (gmVar2 = gmVar10.f) != null && gmVar2.c) || (gmVar8 == gmVar10 && (gmVar = gmVar9.f) != null && gmVar.c);
                in inVar3 = jnVar3.T[0];
                if (inVar3 != inVar || zB2) {
                    if (!jnVar3.A()) {
                        if (gmVar8 == gmVar9 && gmVar10.f == null) {
                            int iE3 = gmVar9.e() + iD2;
                            jnVar3.I(iE3, jnVar3.r() + iE3);
                            m(i4, omVar, jnVar3, z);
                        } else if (gmVar8 == gmVar10 && gmVar9.f == null) {
                            int iE4 = iD2 - gmVar10.e();
                            jnVar3.I(iE4 - jnVar3.r(), iE4);
                            m(i4, omVar, jnVar3, z);
                        } else if (z3 && !jnVar3.y()) {
                            u(i4, omVar, jnVar3, z);
                        }
                    }
                } else if (inVar3 == inVar && jnVar3.v >= 0 && jnVar3.u >= 0) {
                    if (jnVar3.h0 == 8 || (jnVar3.r == 0 && jnVar3.X == 0.0f)) {
                        if (!jnVar3.y() && !jnVar3.F && z3 && !jnVar3.y()) {
                            v(i4, jnVar, omVar, jnVar3, z);
                        }
                    }
                }
            }
        }
        jnVar.m = true;
    }

    public static boolean n(Context context) {
        if (i == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            i = Boolean.valueOf(z);
        }
        return i.booleanValue();
    }

    public static boolean o(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (g == null) {
            g = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (g.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (D(context)) {
            return !os.j() || os.k();
        }
        return false;
    }

    public static int p(float f2, int i2, int i3) {
        return ik.f(ik.h(i3, Math.round(Color.alpha(i3) * f2)), i2);
    }

    public static void r(int i2, View view) {
        if (i2 != 92) {
            if (i2 != 93) {
                if (i2 != 122) {
                    if (i2 != 123) {
                        switch (i2) {
                            case zzbbc.zzt.zzm /* 21 */:
                                view.playSoundEffect(1);
                                break;
                            case 22:
                                view.playSoundEffect(3);
                                break;
                        }
                        return;
                    }
                }
            }
            view.playSoundEffect(4);
            return;
        }
        view.playSoundEffect(2);
    }

    public static void s(ze1 ze1Var) {
        if (ze1Var.f != null || ze1Var.g != null) {
            throw new IllegalArgumentException();
        }
        if (ze1Var.d) {
            return;
        }
        synchronized (bf1.class) {
            try {
                long j2 = b + 8192;
                if (j2 > 65536) {
                    return;
                }
                b = j2;
                ze1Var.f = a;
                ze1Var.c = 0;
                ze1Var.b = 0;
                a = ze1Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void t(yo yoVar, Object obj) {
        if (obj == f) {
            return;
        }
        if (!(obj instanceof qn1)) {
            qg0.i(yoVar.h(null, zo.k), "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            throw new ClassCastException();
        }
        qn1 qn1Var = (qn1) obj;
        nn1[] nn1VarArr = qn1Var.b;
        int length = nn1VarArr.length - 1;
        if (length < 0) {
            return;
        }
        nn1 nn1Var = nn1VarArr[length];
        qg0.h(null);
        Object obj2 = qn1Var.a[length];
        throw null;
    }

    public static void u(int i2, om omVar, jn jnVar, boolean z) {
        float f2 = jnVar.e0;
        gm gmVar = jnVar.I;
        int iD = gmVar.f.d();
        gm gmVar2 = jnVar.K;
        int iD2 = gmVar2.f.d();
        int iE = gmVar.e() + iD;
        int iE2 = iD2 - gmVar2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iR = jnVar.r();
        int i3 = (iD2 - iD) - iR;
        if (iD > iD2) {
            i3 = (iD - iD2) - iR;
        }
        int i4 = ((int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3)) + iD;
        int i5 = i4 + iR;
        if (iD > iD2) {
            i5 = i4 - iR;
        }
        jnVar.I(i4, i5);
        m(i2 + 1, omVar, jnVar, z);
    }

    public static void v(int i2, jn jnVar, om omVar, jn jnVar2, boolean z) {
        float f2 = jnVar2.e0;
        gm gmVar = jnVar2.I;
        int iE = gmVar.e() + gmVar.f.d();
        gm gmVar2 = jnVar2.K;
        int iD = gmVar2.f.d() - gmVar2.e();
        if (iD >= iE) {
            int iR = jnVar2.r();
            if (jnVar2.h0 != 8) {
                int i3 = jnVar2.r;
                if (i3 == 2) {
                    iR = (int) (jnVar2.e0 * 0.5f * (jnVar instanceof kn ? jnVar.r() : jnVar.U.r()));
                } else if (i3 == 0) {
                    iR = iD - iE;
                }
                iR = Math.max(jnVar2.u, iR);
                int i4 = jnVar2.v;
                if (i4 > 0) {
                    iR = Math.min(i4, iR);
                }
            }
            int i5 = iE + ((int) ((f2 * ((iD - iE) - iR)) + 0.5f));
            jnVar2.I(i5, iR + i5);
            m(i2 + 1, omVar, jnVar2, z);
        }
    }

    public static void w(int i2, om omVar, jn jnVar) {
        float f2 = jnVar.f0;
        gm gmVar = jnVar.J;
        int iD = gmVar.f.d();
        gm gmVar2 = jnVar.L;
        int iD2 = gmVar2.f.d();
        int iE = gmVar.e() + iD;
        int iE2 = iD2 - gmVar2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iL = jnVar.l();
        int i3 = (iD2 - iD) - iL;
        if (iD > iD2) {
            i3 = (iD - iD2) - iL;
        }
        int i4 = (int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3);
        int i5 = iD + i4;
        int i6 = i5 + iL;
        if (iD > iD2) {
            i5 = iD - i4;
            i6 = i5 - iL;
        }
        jnVar.J(i5, i6);
        B(i2 + 1, omVar, jnVar);
    }

    public static void x(int i2, jn jnVar, om omVar, jn jnVar2) {
        float f2 = jnVar2.f0;
        gm gmVar = jnVar2.J;
        int iE = gmVar.e() + gmVar.f.d();
        gm gmVar2 = jnVar2.L;
        int iD = gmVar2.f.d() - gmVar2.e();
        if (iD >= iE) {
            int iL = jnVar2.l();
            if (jnVar2.h0 != 8) {
                int i3 = jnVar2.s;
                if (i3 == 2) {
                    iL = (int) (f2 * 0.5f * (jnVar instanceof kn ? jnVar.l() : jnVar.U.l()));
                } else if (i3 == 0) {
                    iL = iD - iE;
                }
                iL = Math.max(jnVar2.x, iL);
                int i4 = jnVar2.y;
                if (i4 > 0) {
                    iL = Math.min(i4, iL);
                }
            }
            int i5 = iE + ((int) ((f2 * ((iD - iE) - iL)) + 0.5f));
            jnVar2.J(i5, iL + i5);
            B(i2 + 1, omVar, jnVar2);
        }
    }

    public static Bitmap y(int i2, Bitmap bitmap) {
        int i3;
        int i4 = i2;
        if (i4 < 1) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i5 = width * height;
        int[] iArr = new int[i5];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = iArr;
        int i6 = width - 1;
        int i7 = height - 1;
        int i8 = i4 + i4;
        int i9 = i8 + 1;
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[i5];
        int[] iArr6 = new int[Math.max(width, height)];
        int i10 = (i8 + 2) >> 1;
        int i11 = i10 * i10;
        int i12 = i11 * MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
        int[] iArr7 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr7[i13] = i13 / i11;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i9, 3);
        int i14 = i4 + 1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < height) {
            int i18 = -i4;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            while (i18 <= i4) {
                int[][] iArr9 = iArr8;
                int[] iArr10 = iArr2;
                int i28 = iArr10[Math.min(i6, Math.max(i18, 0)) + i16];
                int[] iArr11 = iArr9[i18 + i4];
                iArr11[0] = (i28 & 16711680) >> 16;
                iArr11[1] = (i28 & 65280) >> 8;
                iArr11[2] = i28 & 255;
                int iAbs = i14 - Math.abs(i18);
                int i29 = iArr11[0];
                i19 = (i29 * iAbs) + i19;
                int i30 = iArr11[1];
                i20 = (i30 * iAbs) + i20;
                int i31 = iArr11[2];
                i21 = (iAbs * i31) + i21;
                if (i18 > 0) {
                    i25 += i29;
                    i26 += i30;
                    i27 += i31;
                } else {
                    i22 += i29;
                    i23 += i30;
                    i24 += i31;
                }
                i18++;
                iArr8 = iArr9;
                iArr2 = iArr10;
            }
            int[][] iArr12 = iArr8;
            int[] iArr13 = iArr2;
            int i32 = i4;
            int i33 = 0;
            while (i33 < width) {
                iArr3[i16] = iArr7[i19];
                iArr4[i16] = iArr7[i20];
                iArr5[i16] = iArr7[i21];
                int i34 = i19 - i22;
                int i35 = i20 - i23;
                int i36 = i21 - i24;
                int[] iArr14 = iArr12[((i32 - i4) + i9) % i9];
                int i37 = i22 - iArr14[0];
                int i38 = i23 - iArr14[1];
                int i39 = i24 - iArr14[2];
                if (i15 == 0) {
                    i3 = i33;
                    iArr6[i3] = Math.min(i33 + i4 + 1, i6);
                } else {
                    i3 = i33;
                }
                int i40 = iArr13[i17 + iArr6[i3]];
                int i41 = (i40 & 16711680) >> 16;
                iArr14[0] = i41;
                int i42 = (i40 & 65280) >> 8;
                iArr14[1] = i42;
                int i43 = i40 & 255;
                iArr14[2] = i43;
                int i44 = i25 + i41;
                int i45 = i26 + i42;
                int i46 = i27 + i43;
                i19 = i34 + i44;
                i20 = i35 + i45;
                i21 = i36 + i46;
                i32 = (i32 + 1) % i9;
                int[] iArr15 = iArr12[i32 % i9];
                int i47 = iArr15[0];
                i22 = i37 + i47;
                int i48 = iArr15[1];
                i23 = i38 + i48;
                int i49 = iArr15[2];
                i24 = i39 + i49;
                i25 = i44 - i47;
                i26 = i45 - i48;
                i27 = i46 - i49;
                i16++;
                i33 = i3 + 1;
            }
            i17 += width;
            i15++;
            iArr8 = iArr12;
            iArr2 = iArr13;
        }
        int[][] iArr16 = iArr8;
        int[] iArr17 = iArr2;
        int i50 = 0;
        while (i50 < width) {
            int i51 = -i4;
            int i52 = i51 * width;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            while (i51 <= i4) {
                int iMax = Math.max(0, i52) + i50;
                int[] iArr18 = iArr16[i51 + i2];
                iArr18[0] = iArr3[iMax];
                iArr18[1] = iArr4[iMax];
                iArr18[2] = iArr5[iMax];
                int iAbs2 = i14 - Math.abs(i51);
                i53 = (iArr3[iMax] * iAbs2) + i53;
                i54 = (iArr4[iMax] * iAbs2) + i54;
                i55 = (iArr5[iMax] * iAbs2) + i55;
                if (i51 > 0) {
                    i59 += iArr18[0];
                    i60 += iArr18[1];
                    i61 += iArr18[2];
                } else {
                    i56 += iArr18[0];
                    i57 += iArr18[1];
                    i58 += iArr18[2];
                }
                if (i51 < i7) {
                    i52 += width;
                }
                i51++;
                i4 = i2;
            }
            int i62 = i2;
            int i63 = i50;
            int i64 = 0;
            while (i64 < height) {
                iArr17[i63] = (iArr17[i63] & (-16777216)) | (iArr7[i53] << 16) | (iArr7[i54] << 8) | iArr7[i55];
                int i65 = i53 - i56;
                int i66 = i54 - i57;
                int i67 = i55 - i58;
                int[] iArr19 = iArr16[((i62 - i2) + i9) % i9];
                int i68 = i56 - iArr19[0];
                int i69 = i57 - iArr19[1];
                int i70 = i58 - iArr19[2];
                int i71 = i64;
                if (i50 == 0) {
                    iArr6[i71] = Math.min(i71 + i14, i7) * width;
                }
                int i72 = iArr6[i71] + i50;
                int i73 = iArr3[i72];
                iArr19[0] = i73;
                int i74 = iArr4[i72];
                iArr19[1] = i74;
                int i75 = iArr5[i72];
                iArr19[2] = i75;
                int i76 = i59 + i73;
                int i77 = i60 + i74;
                int i78 = i61 + i75;
                i53 = i65 + i76;
                i54 = i66 + i77;
                i55 = i67 + i78;
                i62 = (i62 + 1) % i9;
                int[] iArr20 = iArr16[i62];
                int i79 = iArr20[0];
                i56 = i68 + i79;
                int i80 = iArr20[1];
                i57 = i69 + i80;
                int i81 = iArr20[2];
                i58 = i70 + i81;
                i59 = i76 - i79;
                i60 = i77 - i80;
                i61 = i78 - i81;
                i63 += width;
                i64 = i71 + 1;
            }
            i50++;
            i4 = i2;
        }
        bitmap.setPixels(iArr17, 0, width, 0, 0, width, height);
        return bitmap;
    }

    public static ze1 z() {
        synchronized (bf1.class) {
            try {
                ze1 ze1Var = a;
                if (ze1Var == null) {
                    return new ze1();
                }
                a = ze1Var.f;
                ze1Var.f = null;
                b -= 8192;
                return ze1Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void g(gg1 gg1Var, float f2, float f3);

    public void q() {
        synchronized (this) {
        }
    }
}
