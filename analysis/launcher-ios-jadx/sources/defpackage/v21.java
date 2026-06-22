package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.gms.internal.ads.zzbbc;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.Workspace;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class v21 implements tw0, lb1, ny0, c02, l92 {
    public final /* synthetic */ int g;
    public Object h;
    public Object i;

    public /* synthetic */ v21(int i) {
        this.g = i;
    }

    public static boolean c(Editable editable, KeyEvent keyEvent, boolean z) {
        up1[] up1VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (up1VarArr = (up1[]) editable.getSpans(selectionStart, selectionEnd, up1.class)) != null && up1VarArr.length > 0) {
                for (up1 up1Var : up1VarArr) {
                    int spanStart = editable.getSpanStart(up1Var);
                    int spanEnd = editable.getSpanEnd(up1Var);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void a(si1 si1Var) {
        if (((ArrayList) this.i) == null) {
            this.i = new ArrayList();
        }
        int size = ((ArrayList) this.i).size();
        for (int i = 0; i < size; i++) {
            si1 si1Var2 = (si1) ((ArrayList) this.i).get(i);
            if (si1Var2.g == si1Var.g) {
                ((ArrayList) this.i).remove(i);
            }
            if (si1Var2.g >= si1Var.g) {
                ((ArrayList) this.i).add(i, si1Var);
                return;
            }
        }
        ((ArrayList) this.i).add(si1Var);
    }

    public void b() {
        int[] iArr = (int[]) this.h;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.i = null;
    }

    public void d(String str, PrintWriter printWriter) {
        ji1 ji1Var = ((ap0) this.i).c;
        if (ji1Var.i > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (ji1Var.i <= 0) {
                return;
            }
            if (ji1Var.h[0] != null) {
                throw new ClassCastException();
            }
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(ji1Var.g[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    public synchronized void e(y11 y11Var) {
        try {
            y11 y11Var2 = (y11) this.i;
            if (y11Var2 != null) {
                y11Var2.c = y11Var;
                this.i = y11Var;
            } else {
                if (((y11) this.h) != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.i = y11Var;
                this.h = y11Var;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.zz
    public boolean f(Object obj, File file, g01 g01Var) {
        return ((jc) this.i).f(new pc((oc) this.h, ((BitmapDrawable) ((eb1) obj).get()).getBitmap()), file, g01Var);
    }

    public void g(int i) {
        int[] iArr = (int[]) this.h;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.h = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.h = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.h;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        if ((qh0Var instanceof og1) && (view instanceof BubbleTextView) && ((HashSet) this.h).contains(qh0Var)) {
            og1 og1Var = (og1) qh0Var;
            BubbleTextView bubbleTextView = (BubbleTextView) view;
            Workspace workspace = (Workspace) this.i;
            workspace.getClass();
            Objects.toString(bubbleTextView);
            Drawable icon = bubbleTextView.getIcon();
            bubbleTextView.o(og1Var, workspace.T0, og1Var.h(3) != ((icon instanceof i31) && (((i31) icon).i > 1.0f ? 1 : (((i31) icon).i == 1.0f ? 0 : -1)) < 0));
            if (folderIcon != null) {
                folderIcon.invalidate();
            }
        }
        return false;
    }

    public void i(int i) {
        ArrayList arrayList = (ArrayList) this.i;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((si1) ((ArrayList) this.i).get(size)).g >= i) {
                    ((ArrayList) this.i).remove(size);
                }
            }
        }
        q(i);
    }

    public si1 j(int i, int i2, int i3) {
        ArrayList arrayList = (ArrayList) this.i;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            si1 si1Var = (si1) ((ArrayList) this.i).get(i4);
            int i5 = si1Var.g;
            if (i5 >= i2) {
                return null;
            }
            if (i5 >= i && (i3 == 0 || si1Var.h == i3 || si1Var.j)) {
                return si1Var;
            }
        }
        return null;
    }

    @Override // defpackage.lb1
    public int k(g01 g01Var) {
        return 2;
    }

    public si1 l(int i) {
        ArrayList arrayList = (ArrayList) this.i;
        if (arrayList == null) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            si1 si1Var = (si1) ((ArrayList) this.i).get(size);
            if (si1Var.g == i) {
                return si1Var;
            }
        }
        return null;
    }

    public Long m(String str) {
        lc1 lc1VarA = lc1.a(1, "SELECT long_value FROM Preference where `key`=?");
        lc1VarA.e(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.h;
        workDatabase_Impl.b();
        Cursor cursorL = workDatabase_Impl.l(lc1VarA);
        try {
            Long lValueOf = null;
            if (cursorL.moveToFirst() && !cursorL.isNull(0)) {
                lValueOf = Long.valueOf(cursorL.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorL.close();
            lc1VarA.k();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    @Override // defpackage.ny0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.ly1 n(android.view.View r17, defpackage.ly1 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.Object r3 = r0.i
            ay r3 = (defpackage.ay) r3
            int r4 = r3.a
            java.lang.Object r5 = r0.h
            jd r5 = (defpackage.jd) r5
            iy1 r6 = r2.a
            r7 = 519(0x207, float:7.27E-43)
            eg0 r7 = r6.f(r7)
            r8 = 32
            eg0 r6 = r6.f(r8)
            int r8 = r7.b
            java.lang.Object r9 = r5.b
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r9
            r9.v = r8
            boolean r8 = defpackage.qg0.y(r1)
            int r10 = r1.getPaddingBottom()
            int r11 = r1.getPaddingLeft()
            int r12 = r1.getPaddingRight()
            boolean r13 = r9.n
            if (r13 == 0) goto L43
            int r10 = r2.a()
            r9.u = r10
            int r14 = r3.c
            int r10 = r10 + r14
        L43:
            int r3 = r3.b
            boolean r14 = r9.o
            int r15 = r7.a
            if (r14 == 0) goto L51
            if (r8 == 0) goto L4f
            r11 = r3
            goto L50
        L4f:
            r11 = r4
        L50:
            int r11 = r11 + r15
        L51:
            boolean r14 = r9.p
            int r0 = r7.c
            if (r14 == 0) goto L5d
            if (r8 == 0) goto L5a
            goto L5b
        L5a:
            r4 = r3
        L5b:
            int r12 = r4 + r0
        L5d:
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
            boolean r4 = r9.r
            r8 = 1
            if (r4 == 0) goto L70
            int r4 = r3.leftMargin
            if (r4 == r15) goto L70
            r3.leftMargin = r15
            r4 = 1
            goto L71
        L70:
            r4 = 0
        L71:
            boolean r14 = r9.s
            if (r14 == 0) goto L7c
            int r14 = r3.rightMargin
            if (r14 == r0) goto L7c
            r3.rightMargin = r0
            r4 = 1
        L7c:
            boolean r0 = r9.t
            if (r0 == 0) goto L89
            int r0 = r3.topMargin
            int r7 = r7.b
            if (r0 == r7) goto L89
            r3.topMargin = r7
            goto L8a
        L89:
            r8 = r4
        L8a:
            if (r8 == 0) goto L8f
            r1.setLayoutParams(r3)
        L8f:
            int r0 = r1.getPaddingTop()
            r1.setPadding(r11, r0, r12, r10)
            boolean r0 = r5.a
            if (r0 == 0) goto L9e
            int r1 = r6.d
            r9.l = r1
        L9e:
            if (r13 != 0) goto La4
            if (r0 == 0) goto La3
            goto La4
        La3:
            return r2
        La4:
            r9.H()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v21.n(android.view.View, ly1):ly1");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o(java.lang.CharSequence r10, int r11, int r12, defpackage.hz r13) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v21.o(java.lang.CharSequence, int, int, hz):boolean");
    }

    @Override // defpackage.tw0
    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        s3.b(nestedScrollView, (View) this.h, (View) this.i);
    }

    public void p(u21 u21Var) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.h;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((su) this.i).f(u21Var);
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int q(int r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.h
            int[] r0 = (int[]) r0
            r1 = -1
            if (r0 != 0) goto L8
            goto Lb
        L8:
            int r0 = r0.length
            if (r5 < r0) goto Lc
        Lb:
            return r1
        Lc:
            java.lang.Object r0 = r4.i
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto L14
        L12:
            r0 = -1
            goto L54
        L14:
            si1 r0 = r4.l(r5)
            if (r0 == 0) goto L21
            java.lang.Object r2 = r4.i
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r2.remove(r0)
        L21:
            java.lang.Object r0 = r4.i
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            r2 = 0
        L2a:
            if (r2 >= r0) goto L3e
            java.lang.Object r3 = r4.i
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.lang.Object r3 = r3.get(r2)
            si1 r3 = (defpackage.si1) r3
            int r3 = r3.g
            if (r3 < r5) goto L3b
            goto L3f
        L3b:
            int r2 = r2 + 1
            goto L2a
        L3e:
            r2 = -1
        L3f:
            if (r2 == r1) goto L12
            java.lang.Object r0 = r4.i
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r2)
            si1 r0 = (defpackage.si1) r0
            java.lang.Object r3 = r4.i
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            r3.remove(r2)
            int r0 = r0.g
        L54:
            if (r0 != r1) goto L64
            java.lang.Object r0 = r4.h
            int[] r0 = (int[]) r0
            int r2 = r0.length
            java.util.Arrays.fill(r0, r5, r2, r1)
            java.lang.Object r5 = r4.h
            int[] r5 = (int[]) r5
            int r5 = r5.length
            return r5
        L64:
            int r0 = r0 + 1
            java.lang.Object r2 = r4.h
            int[] r2 = (int[]) r2
            int r2 = r2.length
            int r0 = java.lang.Math.min(r0, r2)
            java.lang.Object r2 = r4.h
            int[] r2 = (int[]) r2
            java.util.Arrays.fill(r2, r5, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v21.q(int):int");
    }

    public void r(int i, int i2) {
        int[] iArr = (int[]) this.h;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        g(i3);
        int[] iArr2 = (int[]) this.h;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill((int[]) this.h, i, i3, -1);
        ArrayList arrayList = (ArrayList) this.i;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            si1 si1Var = (si1) ((ArrayList) this.i).get(size);
            int i4 = si1Var.g;
            if (i4 >= i) {
                si1Var.g = i4 + i2;
            }
        }
    }

    public void s(int i, int i2) {
        int[] iArr = (int[]) this.h;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        g(i3);
        int[] iArr2 = (int[]) this.h;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = (int[]) this.h;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.i;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            si1 si1Var = (si1) ((ArrayList) this.i).get(size);
            int i4 = si1Var.g;
            if (i4 >= i) {
                if (i4 < i3) {
                    ((ArrayList) this.i).remove(size);
                } else {
                    si1Var.g = i4 - i2;
                }
            }
        }
    }

    public synchronized y11 t() {
        y11 y11Var;
        y11Var = (y11) this.h;
        if (y11Var != null) {
            y11 y11Var2 = y11Var.c;
            this.h = y11Var2;
            if (y11Var2 == null) {
                this.i = null;
            }
        }
        return y11Var;
    }

    public String toString() {
        int iLastIndexOf;
        switch (this.g) {
            case 5:
                StringBuilder sb = new StringBuilder(128);
                sb.append("LoaderManager{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" in ");
                Object obj = this.h;
                String simpleName = obj.getClass().getSimpleName();
                if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                    simpleName = simpleName.substring(iLastIndexOf + 1);
                }
                sb.append(simpleName);
                sb.append('{');
                sb.append(Integer.toHexString(System.identityHashCode(obj)));
                sb.append("}}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public synchronized y11 u() {
        try {
            if (((y11) this.h) == null) {
                wait(zzbbc.zzq.zzf);
            }
        } catch (Throwable th) {
            throw th;
        }
        return t();
    }

    @Override // defpackage.l92
    public boolean zza(String str) {
        ja2 ja2Var = cd2.l;
        cd2 cd2Var = hd2.B.c;
        cd2.j((Context) this.h, (String) this.i, str);
        return true;
    }

    public /* synthetic */ v21(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    public v21(WorkDatabase_Impl workDatabase_Impl) {
        this.g = 0;
        this.h = workDatabase_Impl;
        this.i = new su(workDatabase_Impl, 3);
    }

    public v21(en0 en0Var, ct1 ct1Var) {
        ap0 ap0Var;
        this.g = 5;
        this.h = en0Var;
        qg0.l(ct1Var, "store");
        mp mpVar = mp.h;
        qg0.l(mpVar, "defaultCreationExtras");
        String canonicalName = ap0.class.getCanonicalName();
        if (canonicalName != null) {
            String strConcat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
            qg0.l(strConcat, "key");
            LinkedHashMap linkedHashMap = ct1Var.a;
            at1 at1Var = (at1) linkedHashMap.get(strConcat);
            if (ap0.class.isInstance(at1Var)) {
                qg0.i(at1Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            } else {
                jv0 jv0Var = new jv0(mpVar);
                ((LinkedHashMap) jv0Var.g).put(jl1.m, strConcat);
                try {
                    ap0Var = new ap0();
                } catch (AbstractMethodError unused) {
                    ap0Var = new ap0();
                }
                at1Var = ap0Var;
                at1 at1Var2 = (at1) linkedHashMap.put(strConcat, at1Var);
                if (at1Var2 != null) {
                    at1Var2.a();
                }
            }
            this.i = (ap0) at1Var;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public v21(hz1 hz1Var, jl1 jl1Var, iz izVar) {
        this.g = 3;
        this.h = hz1Var;
        this.i = izVar;
    }

    public v21(Workspace workspace, HashSet hashSet) {
        this.g = 9;
        this.i = workspace;
        this.h = hashSet;
    }
}
