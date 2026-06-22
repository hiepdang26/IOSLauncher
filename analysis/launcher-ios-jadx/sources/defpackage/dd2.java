package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzazs;
import com.google.android.gms.internal.ads.zzbcr;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbvt;
import com.google.android.gms.internal.ads.zzbzo;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class dd2 extends u52 {
    public final or1 g;
    public final rc2 h;
    public final do0 i = zzbzo.zza.zzb(new sv(this, 5));
    public final Context j;
    public final s32 k;
    public WebView l;
    public a52 m;
    public zzauo n;
    public AsyncTask o;

    public dd2(Context context, rc2 rc2Var, String str, or1 or1Var) {
        this.j = context;
        this.g = or1Var;
        this.h = rc2Var;
        this.l = new WebView(context);
        this.k = new s32(context, str);
        f(0);
        this.l.setVerticalScrollBarEnabled(false);
        this.l.getSettings().setJavaScriptEnabled(true);
        this.l.setWebViewClient(new gc2(this));
        this.l.setOnTouchListener(new vn1(this, 1));
    }

    public final void f(int i) {
        if (this.l == null) {
            return;
        }
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    @Override // defpackage.v52
    public final void zzA() {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzB() {
        hg0.g("resume must be called on the main UI thread.");
    }

    @Override // defpackage.v52
    public final void zzC(v42 v42Var) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzD(a52 a52Var) {
        this.m = a52Var;
    }

    @Override // defpackage.v52
    public final void zzE(b62 b62Var) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzF(rc2 rc2Var) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // defpackage.v52
    public final void zzG(u62 u62Var) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzH(zzazs zzazsVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzI(pd2 pd2Var) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzK(b92 b92Var) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzL(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzM(zzbsw zzbswVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzO(zzbcr zzbcrVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzQ(zzbsz zzbszVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzR(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzS(zzbvt zzbvtVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzT(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzU(ta2 ta2Var) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final void zzX() {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final boolean zzY() {
        return false;
    }

    @Override // defpackage.v52
    public final boolean zzZ() {
        return false;
    }

    @Override // defpackage.v52
    public final boolean zzaa() {
        return false;
    }

    @Override // defpackage.v52
    public final boolean zzab(tb2 tb2Var) {
        TreeMap treeMap;
        hg0.j(this.l, "This Search Ad has already been torn down");
        s32 s32Var = this.k;
        s32Var.getClass();
        s32Var.d = tb2Var.p.g;
        Bundle bundle = tb2Var.s;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 != null) {
            String str = (String) zzbde.zzc.zze();
            Iterator<String> it = bundle2.keySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                treeMap = (TreeMap) s32Var.c;
                if (!zHasNext) {
                    break;
                }
                String next = it.next();
                if (str.equals(next)) {
                    s32Var.e = bundle2.getString(next);
                } else if (next.startsWith("csa_")) {
                    treeMap.put(next.substring(4), bundle2.getString(next));
                }
            }
            treeMap.put("SDKVersion", this.g.g);
            if (((Boolean) zzbde.zza.zze()).booleanValue()) {
                Bundle bundleT = qg0.T((Context) s32Var.a, (String) zzbde.zzb.zze());
                for (String str2 : bundleT.keySet()) {
                    treeMap.put(str2, bundleT.get(str2).toString());
                }
            }
        }
        this.o = new qy(this, 4).execute(new Void[0]);
        return true;
    }

    @Override // defpackage.v52
    public final void zzac(y62 y62Var) {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final Bundle zzd() {
        throw new IllegalStateException("Unused method");
    }

    @Override // defpackage.v52
    public final rc2 zzg() {
        return this.h;
    }

    @Override // defpackage.v52
    public final a52 zzi() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // defpackage.v52
    public final u62 zzj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // defpackage.v52
    public final u82 zzk() {
        return null;
    }

    @Override // defpackage.v52
    public final x82 zzl() {
        return null;
    }

    @Override // defpackage.v52
    public final he0 zzn() {
        hg0.g("getAdFrame must be called on the main UI thread.");
        return new gy0(this.l);
    }

    public final String zzq() {
        String str = (String) this.k.e;
        if (true == TextUtils.isEmpty(str)) {
            str = "www.google.com";
        }
        return uo.t("https://", str, (String) zzbde.zzd.zze());
    }

    @Override // defpackage.v52
    public final String zzr() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // defpackage.v52
    public final String zzs() {
        return null;
    }

    @Override // defpackage.v52
    public final String zzt() {
        return null;
    }

    @Override // defpackage.v52
    public final void zzx() {
        hg0.g("destroy must be called on the main UI thread.");
        this.o.cancel(true);
        this.i.cancel(false);
        this.l.destroy();
        this.l = null;
    }

    @Override // defpackage.v52
    public final void zzz() {
        hg0.g("pause must be called on the main UI thread.");
    }

    @Override // defpackage.v52
    public final void zzJ(a72 a72Var) {
    }

    @Override // defpackage.v52
    public final void zzN(boolean z) {
    }

    @Override // defpackage.v52
    public final void zzP(m82 m82Var) {
    }

    @Override // defpackage.v52
    public final void zzW(he0 he0Var) {
    }

    @Override // defpackage.v52
    public final void zzy(tb2 tb2Var, f52 f52Var) {
    }
}
