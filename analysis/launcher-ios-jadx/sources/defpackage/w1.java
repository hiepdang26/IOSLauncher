package defpackage;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.pm.ShortcutInfo;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.ButtonDropTarget;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.FavoriteContactWidget;
import com.luutinhit.launcherios.activity.AnimationsActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class w1 implements Runnable {
    public final /* synthetic */ int g;
    public final Object h;
    public final Object i;

    public /* synthetic */ w1(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    private final void a() {
        try {
            ArrayList arrayList = (ArrayList) this.h;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                qh0 qh0Var = (qh0) obj;
                long j = qh0Var.g;
                ((ContentResolver) this.i).delete(wl0.a(qh0Var.g), null, null);
                synchronized (rl0.A) {
                    try {
                        int i2 = qh0Var.h;
                        if (i2 == 0 || i2 == 1) {
                            rl0.C.remove(qh0Var);
                        } else if (i2 == 2) {
                            rl0.E.remove(qh0Var.g);
                            wp0 wp0Var = rl0.B;
                            wp0Var.getClass();
                            int i3 = 0;
                            while (true) {
                                if (!(i3 < wp0Var.size())) {
                                    break;
                                }
                                int i4 = i3 + 1;
                                qh0 qh0Var2 = (qh0) wp0Var.valueAt(i3);
                                if (qh0Var2.i == qh0Var.g) {
                                    qh0Var.toString();
                                    qh0Var2.toString();
                                }
                                i3 = i4;
                            }
                            rl0.C.remove(qh0Var);
                        } else if (i2 == 4) {
                            rl0.D.remove(qh0Var);
                        }
                        rl0.B.remove(qh0Var.g);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    private final void b() {
        ((ContentResolver) this.h).delete(wl0.a(((w40) this.i).g), null, null);
        Object obj = rl0.A;
        synchronized (obj) {
            rl0.B.remove(((w40) this.i).g);
            rl0.E.remove(((w40) this.i).g);
            rl0.C.remove((w40) this.i);
        }
        ((ContentResolver) this.h).delete(wl0.a, "container=" + ((w40) this.i).g, null);
        synchronized (obj) {
            try {
                ArrayList arrayList = ((w40) this.i).x;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    rl0.B.remove(((qh0) obj2).g);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        Drawable shortcutIconDrawable;
        boolean z = true;
        boolean z2 = false;
        switch (this.g) {
            case 0:
                ((x1) this.h).g = this.i;
                return;
            case 1:
                ((Application) this.i).unregisterActivityLifecycleCallbacks((x1) this.h);
                return;
            case 2:
                try {
                    Method method = y1.d;
                    Object obj = this.h;
                    Object obj2 = this.i;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        y1.e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e) {
                    if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                        throw e;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 3:
                try {
                    ((AnimationsActivity) this.i).F.setBitmap((Bitmap) this.h);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            case 4:
                y11 y11VarT = ((v21) this.h).t();
                if (y11VarT == null) {
                    throw new IllegalStateException("No pending post available");
                }
                ((r00) this.i).c(y11VarT);
                return;
            case 5:
                ButtonDropTarget buttonDropTarget = (ButtonDropTarget) this.i;
                buttonDropTarget.n((nx) this.h);
                buttonDropTarget.i.t();
                buttonDropTarget.g.exitSpringLoadedDragModeDelayed(true, 0, null);
                return;
            case 6:
                try {
                    ((hf) this.i).h.put((yi0) this.h);
                    return;
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                    return;
                }
            case 7:
                qb1 qb1Var = (qb1) ((nx0) this.h).h;
                if (qb1Var != null) {
                    qb1Var.onFontRetrieved((Typeface) this.i);
                    return;
                }
                return;
            case 8:
                fj fjVar = (fj) this.i;
                ((EditText) this.h).removeTextChangedListener(((jj) fjVar.b).e);
                ((jj) fjVar.b).e(true);
                return;
            case 9:
                ((kr) this.i).h.onMessageChannelReady((Bundle) this.h);
                return;
            case 10:
                ka0 ka0VarJ = ka0.j();
                int i4 = mu.e;
                lz1 lz1Var = (lz1) this.h;
                ka0VarJ.getClass();
                ((mu) this.i).a.c(lz1Var);
                return;
            case 11:
                ((View) this.h).setVisibility(0);
                Runnable runnable = (Runnable) this.i;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 12:
                boolean zIsPopupShowing = ((AutoCompleteTextView) this.h).isPopupShowing();
                qx qxVar = (qx) this.i;
                ((ux) qxVar.h).i(zIsPopupShowing);
                ((ux) qxVar.h).l = zIsPopupShowing;
                return;
            case 13:
                ((AutoCompleteTextView) this.h).removeTextChangedListener(((ux) ((fj) this.i).b).e);
                return;
            case 14:
                try {
                    int iIntValue = ((Integer) this.h).intValue();
                    ow1 ow1Var = (ow1) this.i;
                    if (iIntValue > 4) {
                        FavoriteContactWidget favoriteContactWidget = (FavoriteContactWidget) ow1Var.h;
                        y00 y00Var = favoriteContactWidget.r;
                        y00Var.p = favoriteContactWidget.t;
                        y00Var.f();
                        FavoriteContactWidget favoriteContactWidget2 = (FavoriteContactWidget) ow1Var.h;
                        y00 y00Var2 = favoriteContactWidget2.s;
                        y00Var2.p = favoriteContactWidget2.u;
                        y00Var2.f();
                        favoriteContactWidget2.n.setVisibility(0);
                    } else {
                        FavoriteContactWidget favoriteContactWidget3 = (FavoriteContactWidget) ow1Var.h;
                        y00 y00Var3 = favoriteContactWidget3.r;
                        y00Var3.p = favoriteContactWidget3.t;
                        y00Var3.f();
                        ((FavoriteContactWidget) ow1Var.h).n.setVisibility(8);
                    }
                    FavoriteContactWidget favoriteContactWidget4 = (FavoriteContactWidget) ow1Var.h;
                    favoriteContactWidget4.x = true;
                    ar1.A((ViewGroup) favoriteContactWidget4.findViewById(v51.expandable_layout), -1);
                    return;
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
            case 15:
                ((ValueAnimator) this.h).removeUpdateListener((b30) this.i);
                return;
            case 16:
                gb0 gb0VarA = gb0.a();
                gb0VarA.getClass();
                vq1.a();
                gb0VarA.d.set(true);
                ((c30) this.i).b.h = true;
                ((c30) this.i).a.getViewTreeObserver().removeOnDrawListener((c30) this.h);
                ((c30) this.i).b.g.clear();
                return;
            case 17:
                pk0 pk0Var = (pk0) this.h;
                z30 z30Var = (z30) this.i;
                try {
                    z30Var.removeView(z30Var.L);
                    z30Var.removeView(z30Var.K);
                    pg1 pg1Var = new pg1(z30Var.x, z30Var.F, false);
                    pg1Var.setText(w61.edit);
                    pg1Var.setIcon(l51.ic_widget_background);
                    pg1Var.setOnClickListener(new w30(this));
                    z30Var.addView(pg1Var, 0, z30Var.H);
                    z30Var.z = pk0Var;
                    int dimensionPixelSize = (z30Var.getResources().getDimensionPixelSize(e51.shortcut_info_item_height) * 3) - 1;
                    pw pwVar = (pw) z30Var.getLayoutParams();
                    ((FrameLayout.LayoutParams) pwVar).height = dimensionPixelSize;
                    z30Var.setLayoutParams(pwVar);
                    int[] locationWidget = pk0Var.getLocationWidget();
                    int i5 = locationWidget[0];
                    int i6 = locationWidget[1];
                    int width = pk0Var.getWidth();
                    int height = pk0Var.getHeight() - pk0Var.q;
                    if (i5 < z30Var.C / 2) {
                        WeakHashMap weakHashMap = qs1.a;
                        z30Var.setLayoutDirection(0);
                        if (i6 < z30Var.D / 2) {
                            i = i6 + height + z30Var.B;
                            z30Var.setPivotX(width / 2.0f);
                            z30Var.setPivotY(0.0f);
                        } else {
                            i = (i6 - dimensionPixelSize) - z30Var.B;
                            z30Var.setPivotX(width / 2.0f);
                            z30Var.setPivotY(dimensionPixelSize);
                        }
                    } else {
                        WeakHashMap weakHashMap2 = qs1.a;
                        z30Var.setLayoutDirection(1);
                        int i7 = z30Var.E;
                        i5 = (i5 - i7) + width;
                        if (i6 < z30Var.D / 2) {
                            i = i6 + height + z30Var.B;
                            z30Var.setPivotX(i7 - (width / 2.0f));
                            z30Var.setPivotY(0.0f);
                        } else {
                            i = (i6 - dimensionPixelSize) - z30Var.B;
                            z30Var.setPivotX(i7 - (width / 2.0f));
                            z30Var.setPivotY(dimensionPixelSize);
                        }
                    }
                    pwVar.b = Math.max(i5, 0);
                    pwVar.c = Math.max(i, 0);
                    z30Var.setLayoutParams(pwVar);
                    try {
                        z30Var.x.getDragLayer().removeView(z30Var);
                        break;
                    } catch (Throwable th3) {
                        th3.getMessage();
                    }
                    try {
                        z30Var.x.getDragLayer().addView(z30Var, pwVar);
                        break;
                    } catch (Throwable th4) {
                        th4.getMessage();
                    }
                    z30Var.setScaleX(0.0f);
                    z30Var.setScaleY(0.0f);
                    z30Var.setAlpha(0.0f);
                    z30Var.postDelayed(new o1(this, 22), 80L);
                    return;
                } catch (Throwable th5) {
                    th5.getMessage();
                    return;
                }
            case 18:
                BubbleTextView bubbleTextView = (BubbleTextView) this.h;
                z30 z30Var2 = (z30) this.i;
                try {
                    List<ShortcutInfo> shortcutInfoList = bubbleTextView.getShortcutInfoList();
                    pw pwVar2 = (pw) z30Var2.getLayoutParams();
                    boolean z3 = (shortcutInfoList == null || shortcutInfoList.isEmpty()) ? false : true;
                    int size = (((z3 ? shortcutInfoList.size() + 4 : 4) * z30Var2.getResources().getDimensionPixelSize(e51.shortcut_info_item_height)) + (z3 ? z30Var2.getResources().getDimensionPixelSize(e51.shortcut_padding_item) : 0)) - 1;
                    ((FrameLayout.LayoutParams) pwVar2).height = size;
                    z30Var2.setLayoutParams(pwVar2);
                    z30Var2.z = bubbleTextView;
                    int[] locationIcon = bubbleTextView.getLocationIcon();
                    int i8 = locationIcon[0];
                    int i9 = locationIcon[1];
                    int i10 = !ar1.v(z30Var2.getResources()) ? 1 : 0;
                    WeakHashMap weakHashMap3 = qs1.a;
                    z30Var2.setLayoutDirection(i10);
                    if (i8 >= z30Var2.C / 2) {
                        int i11 = z30Var2.E;
                        int i12 = z30Var2.A;
                        i2 = (i8 - i11) + i12;
                        if (i9 < z30Var2.D / 2) {
                            i3 = i9 + i12 + z30Var2.B;
                            z30Var2.setPivotX(i11 - (i12 / 2.0f));
                            z30Var2.setPivotY(0.0f);
                            z = true;
                        } else {
                            i3 = (i9 - size) - z30Var2.B;
                            z30Var2.setPivotX(i11 - (i12 / 2.0f));
                            z30Var2.setPivotY(size);
                            z = false;
                        }
                    } else if (i9 < z30Var2.D / 2) {
                        int i13 = z30Var2.A;
                        i3 = i9 + i13 + z30Var2.B;
                        z30Var2.setPivotX(i13 / 2.0f);
                        z30Var2.setPivotY(0.0f);
                        i2 = i8;
                    } else {
                        i3 = (i9 - size) - z30Var2.B;
                        z30Var2.setPivotX(z30Var2.A / 2.0f);
                        z30Var2.setPivotY(size);
                        i2 = i8;
                        z = false;
                    }
                    if (Math.abs((i8 + (z30Var2.A / 2)) - (z30Var2.C / 2)) < 3) {
                        int i14 = z30Var2.C;
                        int i15 = z30Var2.E;
                        i2 = (i14 - i15) / 2;
                        z30Var2.setPivotX(i15 / 2.0f);
                    }
                    if (ar1.e && shortcutInfoList != null && shortcutInfoList.size() > 0) {
                        shortcutInfoList.size();
                        if (z) {
                            z30Var2.addView(z30Var2.M, 0, z30Var2.I);
                        } else {
                            z30Var2.addView(z30Var2.M, z30Var2.I);
                        }
                        Iterator<ShortcutInfo> it = shortcutInfoList.iterator();
                        while (it.hasNext()) {
                            ShortcutInfo shortcutInfoB = ae.b(it.next());
                            pg1 pg1Var2 = new pg1(z30Var2.x, z30Var2.F, false);
                            pg1Var2.setText(shortcutInfoB.getShortLabel());
                            if (ar1.e) {
                                try {
                                    shortcutIconDrawable = z30Var2.G.getShortcutIconDrawable(shortcutInfoB, 0);
                                } catch (Throwable unused3) {
                                    shortcutIconDrawable = null;
                                }
                            } else {
                                shortcutIconDrawable = null;
                            }
                            pg1Var2.setIcon(shortcutIconDrawable);
                            pg1Var2.setOnClickListener(new x30(this, shortcutInfoB));
                            if (z) {
                                z30Var2.addView(pg1Var2, 0, z30Var2.H);
                            } else {
                                z30Var2.addView(pg1Var2, z30Var2.H);
                            }
                            break;
                        }
                    }
                    pwVar2.b = Math.max(i2, 0);
                    pwVar2.c = Math.max(i3, 0);
                    z30Var2.setLayoutParams(pwVar2);
                    try {
                        z30Var2.x.getDragLayer().removeView(z30Var2);
                        break;
                    } catch (Throwable th6) {
                        th6.getMessage();
                    }
                    try {
                        z30Var2.x.getDragLayer().addView(z30Var2, pwVar2);
                        break;
                    } catch (Throwable th7) {
                        th7.getMessage();
                    }
                    z30Var2.setScaleX(0.0f);
                    z30Var2.setScaleY(0.0f);
                    z30Var2.setAlpha(0.0f);
                    z30Var2.postDelayed(new o1(this, 23), 80L);
                    return;
                } catch (Throwable th8) {
                    th8.getMessage();
                    return;
                }
            case 19:
                FolderIcon folderIcon = (FolderIcon) this.i;
                ArrayList arrayList = folderIcon.z;
                og1 og1Var = (og1) this.h;
                arrayList.remove(og1Var);
                folderIcon.h.E(og1Var).setVisibility(0);
                folderIcon.invalidate();
                return;
            case 20:
                r90 r90Var = (r90) this.i;
                if (r90Var.j) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    ((Runnable) this.h).run();
                    return;
                } catch (Throwable unused4) {
                    r90Var.i.getClass();
                    Log.isLoggable("GlideExecutor", 6);
                    return;
                }
            case zzbbc.zzt.zzm /* 21 */:
                t tVar = (t) this.i;
                if (tVar.mWorkerHandler != null) {
                    List list = (List) this.h;
                    if (list == null) {
                        tVar.mWorkerHandler.obtainMessage(0).sendToTarget();
                        return;
                    }
                    Message message = new Message();
                    message.what = 1;
                    message.obj = list;
                    tVar.mWorkerHandler.removeCallbacksAndMessages(null);
                    tVar.mWorkerHandler.sendMessageDelayed(message, 500L);
                    return;
                }
                return;
            case 22:
                ArrayList arrayList2 = (ArrayList) this.i;
                AnimatorSet animatorSet = (AnimatorSet) this.h;
                animatorSet.playTogether(arrayList2);
                animatorSet.start();
                return;
            case 23:
                ((t) this.i).bindFolders((wp0) this.h);
                return;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                ((t) this.i).bindRestoreItemsChange((HashSet) this.h);
                return;
            case 25:
                ArrayList<qh0> arrayList3 = new ArrayList<>();
                arrayList3.add((qh0) this.h);
                dk0 dk0Var = (dk0) this.i;
                int size2 = arrayList3.size();
                t tVar2 = dk0Var.h;
                tVar2.bindItems(arrayList3, 0, size2, true);
                tVar2.getDragLayer().announceForAccessibility(tVar2.getResources().getString(w61.item_moved));
                return;
            case 26:
                hl0 hl0VarL = ((rl0) ((w1) this.i).i).l();
                if (hl0VarL != null) {
                    hl0VarL.bindRestoreItemsChange((HashSet) this.h);
                    return;
                }
                return;
            case 27:
                a();
                return;
            case 28:
                b();
                return;
            default:
                synchronized (rl0.A) {
                    try {
                        HashSet hashSet = new HashSet();
                        if (((le0) this.h).b == 0) {
                            return;
                        }
                        wp0 wp0Var = rl0.B;
                        wp0Var.getClass();
                        int i16 = 0;
                        while (i16 < wp0Var.size()) {
                            int i17 = i16 + 1;
                            qh0 qh0Var = (qh0) wp0Var.valueAt(i16);
                            if (qh0Var instanceof og1) {
                                og1 og1Var2 = (og1) qh0Var;
                                ComponentName componentNameG = og1Var2.g();
                                if (og1Var2.h(3) && componentNameG != null && ((le0) this.h).a.equals(componentNameG.getPackageName())) {
                                    le0 le0Var = (le0) this.h;
                                    og1Var2.F = le0Var.c;
                                    int i18 = og1Var2.E | 4;
                                    og1Var2.E = i18;
                                    if (le0Var.b == 2) {
                                        og1Var2.E = i18 & (-5);
                                    }
                                    hashSet.add(og1Var2);
                                }
                            }
                            i16 = i17;
                        }
                        ArrayList arrayList4 = rl0.D;
                        int size3 = arrayList4.size();
                        int i19 = 0;
                        while (i19 < size3) {
                            Object obj3 = arrayList4.get(i19);
                            i19++;
                            qk0 qk0Var = (qk0) obj3;
                            if (qk0Var.y.getPackageName().equals(((le0) this.h).a)) {
                                qk0Var.A = ((le0) this.h).c;
                                hashSet.add(qk0Var);
                            }
                        }
                        if (!hashSet.isEmpty()) {
                            ((rl0) this.i).j.K(new w1(this, hashSet, 26, z2));
                        }
                        return;
                    } finally {
                    }
                }
        }
    }

    public /* synthetic */ w1(Object obj, Object obj2, int i, boolean z) {
        this.g = i;
        this.i = obj;
        this.h = obj2;
    }

    public w1(r00 r00Var) {
        this.g = 4;
        this.i = r00Var;
        this.h = new v21(6);
    }
}
