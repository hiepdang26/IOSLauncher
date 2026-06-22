package defpackage;

import android.animation.Animator;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.impl.WorkDatabase_Impl;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.widget.CalendarWidget_2x2;
import com.luutinhit.launcherios.activity.AnimationsActivity;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import com.luutinhit.launcherios.activity.LabelChangeActivity;
import com.luutinhit.launcherios.activity.UtilitiesActivity;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class fz1 implements dl1, ut0, wr0, cb, xg1, ni, un, xj0, mu0, hg, h20, my0, b2, gs, bs1, b1 {
    public static fz1 i;
    public final /* synthetic */ int g;
    public final Object h;

    public /* synthetic */ fz1(Object obj, int i2) {
        this.g = i2;
        this.h = obj;
    }

    public void E() {
        synchronized (this.h) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(defpackage.m91 r9, defpackage.ib r10, defpackage.ib r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.h
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r0.getClass()
            r1 = 0
            r9.s(r1)
            r81 r1 = r0.S
            r2 = r1
            lt r2 = (defpackage.lt) r2
            if (r10 == 0) goto L22
            r2.getClass()
            int r4 = r10.a
            int r6 = r11.a
            if (r4 != r6) goto L24
            int r1 = r10.b
            int r3 = r11.b
            if (r1 == r3) goto L22
            goto L24
        L22:
            r3 = r9
            goto L2e
        L24:
            int r5 = r10.b
            int r7 = r11.b
            r3 = r9
            boolean r9 = r2.g(r3, r4, r5, r6, r7)
            goto L3d
        L2e:
            r2.l(r3)
            android.view.View r9 = r3.g
            r10 = 0
            r9.setAlpha(r10)
            java.util.ArrayList r9 = r2.i
            r9.add(r3)
            r9 = 1
        L3d:
            if (r9 == 0) goto L42
            r0.a0()
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fz1.F(m91, ib, ib):void");
    }

    public void G(m91 m91Var, ib ibVar, ib ibVar2) {
        boolean zG;
        RecyclerView recyclerView = (RecyclerView) this.h;
        recyclerView.i.l(m91Var);
        recyclerView.j(m91Var);
        m91Var.s(false);
        lt ltVar = (lt) recyclerView.S;
        ltVar.getClass();
        int i2 = ibVar.a;
        int i3 = ibVar.b;
        View view = m91Var.g;
        int left = ibVar2 == null ? view.getLeft() : ibVar2.a;
        int top = ibVar2 == null ? view.getTop() : ibVar2.b;
        if (m91Var.m() || (i2 == left && i3 == top)) {
            ltVar.l(m91Var);
            ltVar.h.add(m91Var);
            zG = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zG = ltVar.g(m91Var, i2, i3, left, top);
        }
        if (zG) {
            recyclerView.a0();
        }
    }

    public synchronized void H(b80 b80Var) {
        b80Var.i = true;
        b80 b80Var2 = (b80) this.h;
        if (b80Var2.j == b80Var) {
            b80Var2.j = null;
        }
        notifyAll();
    }

    public synchronized boolean I(b80 b80Var) {
        b80 b80Var2 = (b80) this.h;
        b80 b80Var3 = b80Var2.j;
        if (b80Var3 != b80Var && b80Var3 != null) {
            return false;
        }
        b80Var2.j = b80Var;
        notifyAll();
        return true;
    }

    @Override // defpackage.wr0
    public void a(Object obj) {
        Object obj2 = this.h;
        switch (this.g) {
            case 3:
                ArrayList arrayList = (ArrayList) obj;
                l8 l8Var = (l8) obj2;
                u7 u7Var = l8Var.j;
                u7Var.getClass();
                u7Var.k = new ArrayList(arrayList);
                u7Var.g.d(0, arrayList.size(), null);
                l8Var.h.setAdapter(u7Var);
                break;
            case 5:
                ((Boolean) obj).booleanValue();
                SparseArray sparseArray = BubbleTextView.F;
                ((BubbleTextView) obj2).getClass();
                break;
            case 6:
                Thread.currentThread().getName();
                ((CalendarWidget_2x2) obj2).postDelayed(new wc(this, (ArrayList) obj, 2), 1000L);
                break;
            case 18:
                Thread.currentThread().getName();
                IconChangeActivity iconChangeActivity = (IconChangeActivity) obj2;
                sg sgVar = iconChangeActivity.D;
                sgVar.k = (ArrayList) obj;
                sgVar.f();
                iconChangeActivity.C.setVisibility(8);
                break;
            default:
                Thread.currentThread().getName();
                LabelChangeActivity labelChangeActivity = (LabelChangeActivity) obj2;
                sg sgVar2 = labelChangeActivity.G;
                sgVar2.k = (ArrayList) obj;
                sgVar2.f();
                labelChangeActivity.B.setVisibility(8);
                break;
        }
    }

    @Override // defpackage.gs
    public void b() {
        ((k81) this.h).b();
    }

    @Override // defpackage.wr0
    public void c(cw cwVar) {
        switch (this.g) {
            case 3:
                ((l8) this.h).getClass();
                break;
            case 5:
                break;
            case 6:
                ((CalendarWidget_2x2) this.h).t = cwVar;
                break;
            case 18:
                ((IconChangeActivity) this.h).K = cwVar;
                break;
            default:
                ((LabelChangeActivity) this.h).F = cwVar;
                break;
        }
    }

    @Override // defpackage.h20
    public Object create() {
        mj mjVar = (mj) this.h;
        return new h00((s90) mjVar.a, (s90) mjVar.b, (s90) mjVar.c, (s90) mjVar.d, (d00) mjVar.e, (d00) mjVar.f, (wb2) mjVar.g);
    }

    @Override // defpackage.wr0
    public void d() {
        switch (this.g) {
            case 3:
            case 6:
                break;
            case 18:
                int i2 = w61.start_ios_launcher_firstly;
                IconChangeActivity iconChangeActivity = (IconChangeActivity) this.h;
                Toast.makeText(iconChangeActivity, i2, 1).show();
                iconChangeActivity.C.setVisibility(8);
                break;
            default:
                Toast.makeText((LabelChangeActivity) this.h, w61.start_ios_launcher_firstly, 1).show();
                break;
        }
    }

    @Override // defpackage.dl1
    public void e(boolean z) {
        Object obj = this.h;
        switch (this.g) {
            case 1:
                int i2 = AnimationsActivity.H;
                ((AnimationsActivity) obj).A("unlock_animation", z);
                break;
            default:
                UtilitiesActivity.A((UtilitiesActivity) obj, "auto_rearrange", z);
                break;
        }
    }

    @Override // defpackage.b1
    public boolean f(View view) {
        int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
        ViewPager2 viewPager2 = (ViewPager2) ((ol1) this.h).j;
        if (viewPager2.w) {
            viewPager2.b(currentItem);
        }
        return true;
    }

    @Override // defpackage.un
    public xn g() {
        return new xn(new mc1(((ContentInfo.Builder) this.h).build()));
    }

    @Override // defpackage.xj0
    public void h(boolean z) {
        wq wqVar = (wq) this.h;
        t tVar = wqVar.g;
        if (tVar != null && wqVar.m != null && tVar.getBlurGlassWallpaper() != null) {
            wqVar.m.setBitmapBackground(wqVar.g.getBlurGlassWallpaper());
        }
        wqVar.getVisibility();
        wqVar.getAlpha();
        wqVar.r.getVisibility();
        wqVar.r.getAlpha();
        wqVar.getX();
        wqVar.getY();
        wqVar.r.getX();
        wqVar.r.getY();
        int childCount = wqVar.r.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = wqVar.r.getChildAt(i2);
            if (childAt instanceof dm0) {
                ((dm0) childAt).n();
            }
        }
    }

    @Override // defpackage.b2
    public void i(Object obj) {
        a2 a2Var = (a2) obj;
        h60 h60Var = (h60) this.h;
        e60 e60Var = (e60) h60Var.y.pollFirst();
        if (e60Var == null) {
            return;
        }
        w50 w50VarR = h60Var.c.r(e60Var.g);
        if (w50VarR == null) {
            return;
        }
        w50VarR.w(e60Var.h, a2Var.g, a2Var.h);
    }

    @Override // defpackage.bs1
    public int j() {
        u81 u81Var = (u81) this.h;
        return u81Var.n - u81Var.H();
    }

    @Override // defpackage.un
    public void k(Bundle bundle) {
        ((ContentInfo.Builder) this.h).setExtras(bundle);
    }

    @Override // defpackage.xj0
    public void l() {
        wq wqVar = (wq) this.h;
        int childCount = wqVar.r.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = wqVar.r.getChildAt(i2);
            if (childAt instanceof dm0) {
                ((dm0) childAt).l();
            }
        }
        wqVar.o.setVisibility(8);
        wqVar.n.setVisibility(8);
        wqVar.n();
        SlidingUpWidgetsList slidingUpWidgetsList = wqVar.p;
        if (slidingUpWidgetsList != null) {
            slidingUpWidgetsList.postOnAnimation(new rq(wqVar, 6));
        }
    }

    @Override // defpackage.bs1
    public int m(View view) {
        v81 v81Var = (v81) view.getLayoutParams();
        ((u81) this.h).getClass();
        return u81.A(view) - ((ViewGroup.MarginLayoutParams) v81Var).leftMargin;
    }

    @Override // defpackage.hg
    public void n() {
        ((Animator) this.h).end();
    }

    @Override // defpackage.cb
    public void o(vl vlVar) {
        boolean z = vlVar.h == 0;
        eb ebVar = (eb) this.h;
        if (z) {
            ebVar.getRemoteService(null, ebVar.getScopes());
        } else if (ebVar.zzx != null) {
            ebVar.zzx.onConnectionFailed(vlVar);
        }
    }

    @Override // defpackage.ut0
    public void onCloseMenu(gt0 gt0Var, boolean z) {
        p6 p6Var;
        gt0 gt0VarK = gt0Var.k();
        int i2 = 0;
        boolean z2 = gt0VarK != gt0Var;
        if (z2) {
            gt0Var = gt0VarK;
        }
        q6 q6Var = (q6) this.h;
        p6[] p6VarArr = q6Var.K;
        int length = p6VarArr != null ? p6VarArr.length : 0;
        while (true) {
            if (i2 < length) {
                p6Var = p6VarArr[i2];
                if (p6Var != null && p6Var.h == gt0Var) {
                    break;
                } else {
                    i2++;
                }
            } else {
                p6Var = null;
                break;
            }
        }
        if (p6Var != null) {
            if (!z2) {
                q6Var.l(p6Var, z);
            } else {
                q6Var.j(p6Var.a, p6Var, gt0VarK);
                q6Var.l(p6Var, true);
            }
        }
    }

    @Override // defpackage.wr0
    public void onError(Throwable th) {
        Object obj = this.h;
        switch (this.g) {
            case 3:
                Toast.makeText(((l8) obj).g, w61.action_move_to_workspace, 1).show();
                break;
            case 5:
                break;
            case 6:
                th.getMessage();
                break;
            case 18:
                int i2 = IconChangeActivity.M;
                IconChangeActivity iconChangeActivity = (IconChangeActivity) obj;
                iconChangeActivity.getClass();
                Intent intent = new Intent(iconChangeActivity, (Class<?>) IOSLauncher.class);
                intent.addCategory("android.intent.category.HOME");
                iconChangeActivity.startActivity(intent);
                Toast.makeText(iconChangeActivity, w61.start_ios_launcher_firstly, 1).show();
                iconChangeActivity.finish();
                break;
            default:
                int i3 = LabelChangeActivity.H;
                LabelChangeActivity labelChangeActivity = (LabelChangeActivity) obj;
                labelChangeActivity.getClass();
                Intent intent2 = new Intent(labelChangeActivity, (Class<?>) IOSLauncher.class);
                intent2.addCategory("android.intent.category.HOME");
                labelChangeActivity.startActivity(intent2);
                Toast.makeText(labelChangeActivity, w61.start_ios_launcher_firstly, 1).show();
                labelChangeActivity.finish();
                break;
        }
    }

    @Override // defpackage.ut0
    public boolean onOpenSubMenu(gt0 gt0Var) {
        Window.Callback callback;
        if (gt0Var != gt0Var.k()) {
            return true;
        }
        q6 q6Var = (q6) this.h;
        if (!q6Var.E || (callback = q6Var.k.getCallback()) == null || q6Var.P) {
            return true;
        }
        callback.onMenuOpened(108, gt0Var);
        return true;
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        og1 og1VarI;
        FolderIcon folderIcon = (FolderIcon) this.h;
        qh0 qh0Var = folderIcon.B;
        if (qh0Var instanceof v6) {
            og1VarI = ((v6) qh0Var).i();
            og1VarI.m = 1;
            og1VarI.n = 1;
        } else {
            og1VarI = (og1) qh0Var;
        }
        Folder folder = folderIcon.h;
        folder.F = og1VarI;
        folder.B = folder.r.j0();
        folder.H = true;
        folder.J = true;
        folder.o.m.add(folder);
        folderIcon.g.openFolder(folderIcon);
    }

    @Override // defpackage.xj0
    public void q(float f) {
        wq wqVar = (wq) this.h;
        if (wqVar.g != null) {
            RealTimeBlurView realTimeBlurView = wqVar.m;
            float f2 = wqVar.isRtl() ? wqVar.g.screenWidth + f : f - wqVar.g.screenWidth;
            wqVar.isRtl();
            realTimeBlurView.v = f2;
            realTimeBlurView.invalidate();
            wqVar.post(new i8(this, f, 1));
        }
    }

    @Override // defpackage.gs
    public Object r() {
        k81 k81Var = (k81) this.h;
        k81Var.reset();
        return k81Var;
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 10:
                return new re((iy) this.h, 1);
            default:
                return new l9((Resources) this.h, qm0Var.b(Uri.class, InputStream.class));
        }
    }

    @Override // defpackage.bs1
    public View t(int i2) {
        return ((u81) this.h).u(i2);
    }

    @Override // defpackage.bs1
    public int u() {
        return ((u81) this.h).G();
    }

    @Override // defpackage.un
    public void v(Uri uri) {
        ((ContentInfo.Builder) this.h).setLinkUri(uri);
    }

    @Override // defpackage.bs1
    public int w(View view) {
        v81 v81Var = (v81) view.getLayoutParams();
        ((u81) this.h).getClass();
        return u81.C(view) + ((ViewGroup.MarginLayoutParams) v81Var).rightMargin;
    }

    @Override // defpackage.xj0
    public void x() {
        wq wqVar = (wq) this.h;
        t tVar = wqVar.g;
        if (tVar == null || !tVar.isShaking()) {
            return;
        }
        wqVar.g.cancelShakingAnimation();
    }

    @Override // defpackage.un
    public void y(int i2) {
        ((ContentInfo.Builder) this.h).setFlags(i2);
    }

    public void z(gu0... gu0VarArr) {
        qg0.l(gu0VarArr, "migrations");
        for (gu0 gu0Var : gu0VarArr) {
            int i2 = gu0Var.a;
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.h;
            Integer numValueOf = Integer.valueOf(i2);
            Object treeMap = linkedHashMap.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                linkedHashMap.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            int i3 = gu0Var.b;
            if (treeMap2.containsKey(Integer.valueOf(i3))) {
                Objects.toString(treeMap2.get(Integer.valueOf(i3)));
                gu0Var.toString();
            }
            treeMap2.put(Integer.valueOf(i3), gu0Var);
        }
    }

    public fz1(InputStream inputStream, cq0 cq0Var) {
        this.g = 19;
        k81 k81Var = new k81(inputStream, cq0Var);
        this.h = k81Var;
        k81Var.mark(5242880);
    }

    public fz1(WorkDatabase_Impl workDatabase_Impl) {
        this.g = 0;
        this.h = workDatabase_Impl;
        new su(workDatabase_Impl, 5);
    }

    public fz1(int i2) {
        this.g = i2;
        switch (i2) {
            case 22:
                this.h = new HashMap();
                break;
            case 26:
                this.h = new LinkedHashMap();
                break;
            case 27:
                this.h = new Object();
                new Handler(Looper.getMainLooper(), new h8(this, 5));
                break;
            default:
                this.h = new iy();
                break;
        }
    }

    public fz1(ClipData clipData, int i2) {
        this.g = 8;
        this.h = tn.j(clipData, i2);
    }

    private final void A() {
    }

    private final void B() {
    }

    private final void C(Throwable th) {
    }

    private final void D(cw cwVar) {
    }
}
