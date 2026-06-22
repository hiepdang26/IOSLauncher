package defpackage;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.impl.WorkDatabase;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderPagedView;
import com.luutinhit.launcher6.appslibrary.IndexBarView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import com.luutinhit.launcher6.widget.AppSuggestionsWidget;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.activity.AnimationsActivity;
import com.luutinhit.launcherios.activity.UtilitiesActivity;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes.dex */
public final class mc1 implements dl1, wr0, MenuItemHoverListener, wn, wy0, my0, y40, b2, et0, bs1, mu0, hg, gq1, b1, Callback {
    public static mc1 i;
    public static final nc1 j = new nc1(0, 0, 0, false, false);
    public final /* synthetic */ int g;
    public Object h;

    public /* synthetic */ mc1(Object obj, int i2) {
        this.g = i2;
        this.h = obj;
    }

    public static synchronized mc1 r() {
        try {
            if (i == null) {
                i = new mc1(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    public static mc1 v(int i2, int i3, int i4) {
        return new mc1(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, false, i4), 1);
    }

    public void A(int i2) {
        RecyclerView recyclerView = (RecyclerView) this.h;
        View childAt = recyclerView.getChildAt(i2);
        if (childAt != null) {
            recyclerView.t(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i2);
    }

    public void B(xg1 xg1Var) {
        yc1 yc1Var = new yc1(m90.b);
        xg1Var.c(yc1Var);
        if (yc1Var.a()) {
            return;
        }
        try {
            Object objCall = ((f8) this.h).call();
            if (yc1Var.a()) {
                return;
            }
            xg1Var.a(objCall);
        } catch (Throwable th) {
            hg0.C(th);
            if (yc1Var.a()) {
                e42.m(th);
            } else {
                xg1Var.onError(th);
            }
        }
    }

    @Override // defpackage.wr0
    public void a(Object obj) {
        String[] strArr;
        int[] iArr;
        char upperCase;
        switch (this.g) {
            case 4:
                ArrayList arrayList = (ArrayList) obj;
                try {
                    i7 i7Var = ((AppSuggestionsWidget) this.h).m;
                    i7Var.l = arrayList;
                    i7Var.f();
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            default:
                ArrayList arrayList2 = (ArrayList) obj;
                Thread.currentThread().getName();
                q8 q8Var = new q8(arrayList2);
                l8 l8Var = (l8) this.h;
                l8Var.t = q8Var;
                q8Var.l = l8Var;
                BouncyRecyclerView bouncyRecyclerView = l8Var.i;
                bouncyRecyclerView.setAdapter(q8Var);
                bouncyRecyclerView.k(new ta0(l8Var.t));
                IndexBarView indexBarView = l8Var.k;
                indexBarView.getClass();
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    strArr = new String[]{"#"};
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    int size = arrayList2.size();
                    char c = 0;
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        w6 w6Var = (w6) obj2;
                        if (w6Var != null && !w6Var.a().trim().isEmpty() && (upperCase = Character.toUpperCase(w6Var.a().trim().charAt(0))) != c) {
                            arrayList3.add(String.valueOf(upperCase));
                            c = upperCase;
                        }
                    }
                    strArr = (String[]) arrayList3.toArray(new String[0]);
                }
                if (arrayList2 == null || arrayList2.isEmpty() || strArr == null || strArr.length == 0) {
                    iArr = new int[]{0};
                } else {
                    int length = strArr.length;
                    iArr = new int[length];
                    Arrays.fill(iArr, -1);
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        w6 w6Var2 = (w6) arrayList2.get(i3);
                        if (w6Var2 != null && !w6Var2.a().trim().isEmpty()) {
                            char upperCase2 = Character.toUpperCase(w6Var2.a().trim().charAt(0));
                            int i4 = 0;
                            while (true) {
                                if (i4 >= strArr.length) {
                                }
                                if (strArr[i4].charAt(0) == upperCase2 && iArr[i4] == -1) {
                                    iArr[i4] = i3;
                                } else {
                                    i4++;
                                }
                                break;
                            }
                        }
                    }
                    for (int i5 = 0; i5 < length; i5++) {
                        if (iArr[i5] == -1) {
                            iArr[i5] = 0;
                        }
                    }
                }
                indexBarView.setLetters(strArr);
                indexBarView.setOnLetterChangeListener(new k8(this, iArr, 0));
                break;
        }
    }

    @Override // defpackage.wn
    public ClipData b() {
        return ((ContentInfo) this.h).getClip();
    }

    @Override // defpackage.wr0
    public void c(cw cwVar) {
        switch (this.g) {
            case 4:
                ((AppSuggestionsWidget) this.h).p = cwVar;
                break;
            default:
                ((l8) this.h).getClass();
                break;
        }
    }

    @Override // defpackage.y40
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.h;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // defpackage.wr0
    public void d() {
        int i2 = this.g;
    }

    @Override // defpackage.dl1
    public void e(boolean z) {
        switch (this.g) {
            case 3:
                int i2 = AnimationsActivity.H;
                ((AnimationsActivity) this.h).A("open_close_animation", z);
                break;
            default:
                UtilitiesActivity utilitiesActivity = (UtilitiesActivity) this.h;
                UtilitiesActivity.A(utilitiesActivity, "iphone_8_style", z);
                ar1.z(utilitiesActivity);
                break;
        }
    }

    @Override // defpackage.b1
    public boolean f(View view) {
        int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
        ViewPager2 viewPager2 = (ViewPager2) ((ol1) this.h).j;
        if (viewPager2.w) {
            viewPager2.b(currentItem);
        }
        return true;
    }

    @Override // defpackage.y40
    public Cursor g(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.h;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // defpackage.gq1
    public cs h(Uri uri) {
        return new uj1(1, uri, (ContentResolver) this.h);
    }

    @Override // defpackage.b2
    public void i(Object obj) {
        Map map = (Map) obj;
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
        }
        h60 h60Var = (h60) this.h;
        e60 e60Var = (e60) h60Var.y.pollFirst();
        if (e60Var == null) {
            return;
        }
        h60Var.c.r(e60Var.g);
    }

    @Override // defpackage.bs1
    public int j() {
        u81 u81Var = (u81) this.h;
        return u81Var.o - u81Var.F();
    }

    public synchronized void k(tc1 tc1Var) {
        ((LinkedHashSet) this.h).remove(tc1Var);
    }

    @Override // defpackage.wn
    public int l() {
        return ((ContentInfo) this.h).getFlags();
    }

    @Override // defpackage.bs1
    public int m(View view) {
        v81 v81Var = (v81) view.getLayoutParams();
        ((u81) this.h).getClass();
        return u81.D(view) - ((ViewGroup.MarginLayoutParams) v81Var).topMargin;
    }

    @Override // defpackage.hg
    public void n() {
        ((li1) this.h).a();
    }

    @Override // defpackage.wn
    public ContentInfo o() {
        return (ContentInfo) this.h;
    }

    @Override // defpackage.wr0
    public void onError(Throwable th) {
        switch (this.g) {
            case 4:
                th.getMessage();
                break;
            default:
                Toast.makeText(((l8) this.h).g, w61.action_move_to_workspace, 1).show();
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        th.getMessage();
        ((jw1) this.h).b.a(th);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(gt0 gt0Var, MenuItem menuItem) {
        pg pgVar = (pg) this.h;
        pgVar.m.removeCallbacksAndMessages(null);
        ArrayList arrayList = pgVar.o;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (gt0Var == ((og) arrayList.get(i2)).b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1) {
            return;
        }
        int i3 = i2 + 1;
        pgVar.m.postAtTime(new ng(this, i3 < arrayList.size() ? (og) arrayList.get(i3) : null, menuItem, gt0Var, 0), gt0Var, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(gt0 gt0Var, MenuItem menuItem) {
        ((pg) this.h).m.removeCallbacksAndMessages(gt0Var);
    }

    @Override // defpackage.et0
    public boolean onMenuItemSelected(gt0 gt0Var, MenuItem menuItem) {
        qw0 qw0Var = ((NavigationView) this.h).n;
        if (qw0Var != null) {
            MainActivity mainActivity = (MainActivity) qw0Var;
            int itemId = menuItem.getItemId();
            if (itemId == v51.nav_how_to_use) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:DGTF7PZoVTg"));
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=DGTF7PZoVTg"));
                    try {
                        mainActivity.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        mainActivity.startActivity(intent2);
                    }
                    return true;
                } catch (Throwable unused2) {
                    Toast.makeText(mainActivity.C, w61.application_not_found, 0).show();
                    return true;
                }
            }
            if (itemId == v51.nav_menu_policy) {
                mainActivity.A("https://luutinhit.blogspot.com/2018/09/launcher-ios-12-policy.html");
                return true;
            }
            if (itemId == v51.nav_menu_web) {
                mainActivity.A("https://luutinhit.blogspot.com");
                return true;
            }
            if (itemId == v51.nav_menu_about) {
                mainActivity.A("https://luutinhit.blogspot.com/2018/11/launcher-ios.html");
                return true;
            }
            if (itemId == v51.nav_reload_launcher) {
                try {
                    t3 t3Var = new t3(mainActivity);
                    p3 p3Var = (p3) t3Var.h;
                    p3Var.d = p3Var.a.getText(w61.reload_launcher);
                    yn0 yn0Var = new yn0(mainActivity, 1);
                    p3Var.g = p3Var.a.getText(R.string.ok);
                    p3Var.h = yn0Var;
                    jq0 jq0Var = new jq0(0);
                    p3Var.i = p3Var.a.getText(R.string.cancel);
                    p3Var.j = jq0Var;
                    t3Var.d().show();
                    return true;
                } catch (Throwable unused3) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        Objects.toString(response);
        boolean zIsSuccessful = response.isSuccessful();
        jw1 jw1Var = (jw1) this.h;
        if (!zIsSuccessful) {
            jw1Var.b.a(new Throwable(response.message()));
            return;
        }
        HourlyResponse hourlyResponse = (HourlyResponse) response.body();
        vz0 vz0Var = jw1Var.b;
        vz0Var.getClass();
        Objects.toString(hourlyResponse);
        if (hourlyResponse == null || hourlyResponse.getList() == null) {
            return;
        }
        String json = new Gson().toJson(hourlyResponse);
        new Handler(Looper.getMainLooper()).post(new uz0(vz0Var, vz0Var.b, hourlyResponse, 1));
        OpenWeather openWeather = vz0Var.d;
        openWeather.write(openWeather.mContext, vz0Var.c, json);
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        int i2;
        int i3;
        Folder folder = (Folder) this.h;
        FolderPagedView folderPagedView = folder.r;
        int i4 = folder.B;
        int i5 = folder.z;
        folderPagedView.l0();
        int nextPage = folderPagedView.getNextPage();
        int i6 = folderPagedView.z0;
        int i7 = i5 / i6;
        int i8 = i5 % i6;
        int i9 = i4 % i6;
        int i10 = i4 / i6;
        if (i5 != i4) {
            int i11 = -1;
            if (i5 > i4) {
                if (i10 < nextPage) {
                    i11 = nextPage * i6;
                    i9 = 0;
                } else {
                    i4 = -1;
                }
                i3 = 1;
            } else {
                if (i10 > nextPage) {
                    i2 = ((nextPage + 1) * i6) - 1;
                    i9 = i6 - 1;
                } else {
                    i4 = -1;
                    i2 = -1;
                }
                i11 = i2;
                i3 = -1;
            }
            while (i4 != i11) {
                int i12 = i4 + i3;
                int i13 = i12 / i6;
                int i14 = i12 % i6;
                int i15 = folderPagedView.B0;
                int i16 = i14 % i15;
                int i17 = i14 / i15;
                CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(i13);
                View viewB = cellLayout.I.b(i16, i17);
                if (viewB != null) {
                    if (nextPage != i13) {
                        cellLayout.removeView(viewB);
                        folderPagedView.i0(viewB, (og1) viewB.getTag(), i4);
                    } else {
                        x40 x40Var = new x40(folderPagedView, viewB, viewB.getTranslationX(), i4);
                        viewB.animate().translationXBy((i3 > 0) ^ folderPagedView.t0 ? -viewB.getWidth() : viewB.getWidth()).setDuration(230L).setStartDelay(0L).withEndAction(x40Var);
                        folderPagedView.w0.put(viewB, x40Var);
                    }
                }
                i4 = i12;
            }
            if ((i8 - i9) * i3 > 0) {
                CellLayout cellLayout2 = (CellLayout) folderPagedView.getChildAt(nextPage);
                float f = 30.0f;
                int i18 = 0;
                while (i9 != i8) {
                    int i19 = i9 + i3;
                    int i20 = folderPagedView.B0;
                    View viewB2 = cellLayout2.I.b(i19 % i20, i19 / i20);
                    if (viewB2 != null) {
                        ((qh0) viewB2.getTag()).q -= i3;
                    }
                    int i21 = folderPagedView.B0;
                    CellLayout cellLayout3 = cellLayout2;
                    if (cellLayout3.c(viewB2, i9 % i21, i9 / i21, 230, i18, true, true)) {
                        i18 += (int) f;
                        f *= 0.9f;
                    }
                    i9 = i19;
                    cellLayout2 = cellLayout3;
                }
            }
        }
        folder.B = folder.z;
    }

    @Override // defpackage.wn
    public int q() {
        return ((ContentInfo) this.h).getSource();
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 22:
                return new l9((Resources) this.h, aq1.b);
            default:
                return new hq1(this);
        }
    }

    @Override // defpackage.bs1
    public View t(int i2) {
        return ((u81) this.h).u(i2);
    }

    public String toString() {
        switch (this.g) {
            case 7:
                return "ContentInfoCompat{" + ((ContentInfo) this.h) + "}";
            default:
                return super.toString();
        }
    }

    @Override // defpackage.bs1
    public int u() {
        return ((u81) this.h).I();
    }

    @Override // defpackage.bs1
    public int w(View view) {
        v81 v81Var = (v81) view.getLayoutParams();
        ((u81) this.h).getClass();
        return u81.y(view) + ((ViewGroup.MarginLayoutParams) v81Var).bottomMargin;
    }

    public void z(yi0 yi0Var, uv uvVar, w1 w1Var) {
        synchronized (yi0Var.j) {
            yi0Var.o = true;
        }
        yi0Var.a("post-response");
        ((k10) this.h).execute(new xm(yi0Var, uvVar, w1Var, 2));
    }

    public mc1(int i2) {
        this.g = i2;
        switch (i2) {
            case 14:
                this.h = new HashMap();
                break;
            case 23:
                this.h = new LinkedHashSet();
                break;
        }
    }

    public mc1(WorkDatabase workDatabase) {
        this.g = 15;
        qg0.l(workDatabase, "workDatabase");
        this.h = workDatabase;
    }

    public mc1(Handler handler) {
        this.g = 10;
        this.h = new k10(0, handler);
    }

    public mc1(Uri uri, Context context) {
        this.g = 12;
        this.h = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    public mc1(ContentInfo contentInfo) {
        this.g = 7;
        contentInfo.getClass();
        this.h = tn.l(contentInfo);
    }

    private final void x() {
    }

    private final void y() {
    }

    @Override // defpackage.et0
    public void onMenuModeChange(gt0 gt0Var) {
    }
}
