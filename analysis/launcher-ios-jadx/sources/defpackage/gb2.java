package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzdoa;
import com.google.android.gms.internal.ads.zzgcj;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gb2 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ gb2(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    private final void a() {
        ib2 ib2Var = (ib2) this.h;
        Context context = (Context) this.i;
        ib2Var.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        try {
            synchronized (ib2Var.a) {
                try {
                    ib2Var.f = sharedPreferences;
                    ib2Var.g = editorEdit;
                    if (Build.VERSION.SDK_INT >= 23) {
                        NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                    }
                    ib2Var.h = ib2Var.f.getBoolean("use_https", ib2Var.h);
                    ib2Var.u = ib2Var.f.getBoolean("content_url_opted_out", ib2Var.u);
                    ib2Var.i = ib2Var.f.getString("content_url_hashes", ib2Var.i);
                    ib2Var.k = ib2Var.f.getBoolean("gad_idless", ib2Var.k);
                    ib2Var.v = ib2Var.f.getBoolean("content_vertical_opted_out", ib2Var.v);
                    ib2Var.j = ib2Var.f.getString("content_vertical_hashes", ib2Var.j);
                    ib2Var.r = ib2Var.f.getInt("version_code", ib2Var.r);
                    if (((Boolean) zzbdk.zzg.zze()).booleanValue() && n42.d.c.zze()) {
                        ib2Var.n = new zzbyy("", 0L);
                    } else {
                        ib2Var.n = new zzbyy(ib2Var.f.getString("app_settings_json", ib2Var.n.zzc()), ib2Var.f.getLong("app_settings_last_update_ms", ib2Var.n.zza()));
                    }
                    ib2Var.o = ib2Var.f.getLong("app_last_background_time_ms", ib2Var.o);
                    ib2Var.q = ib2Var.f.getInt("request_in_session_count", ib2Var.q);
                    ib2Var.p = ib2Var.f.getLong("first_ad_req_time_ms", ib2Var.p);
                    ib2Var.s = ib2Var.f.getStringSet("never_pool_slots", ib2Var.s);
                    ib2Var.w = ib2Var.f.getString("display_cutout", ib2Var.w);
                    ib2Var.B = ib2Var.f.getInt("app_measurement_npa", ib2Var.B);
                    ib2Var.C = ib2Var.f.getInt("sd_app_measure_npa", ib2Var.C);
                    ib2Var.D = ib2Var.f.getLong("sd_app_measure_npa_ts", ib2Var.D);
                    ib2Var.x = ib2Var.f.getString("inspector_info", ib2Var.x);
                    ib2Var.y = ib2Var.f.getBoolean("linked_device", ib2Var.y);
                    ib2Var.z = ib2Var.f.getString("linked_ad_unit", ib2Var.z);
                    ib2Var.A = ib2Var.f.getString("inspector_ui_storage", ib2Var.A);
                    ib2Var.l = ib2Var.f.getString("IABTCF_TCString", ib2Var.l);
                    ib2Var.m = ib2Var.f.getInt("gad_has_consent_for_cookies", ib2Var.m);
                    try {
                        ib2Var.t = new JSONObject(ib2Var.f.getString("native_advanced_settings", "{}"));
                    } catch (JSONException unused) {
                        k92.j(5);
                    }
                    ib2Var.s();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            hd2.B.g.zzw(th2, "AdSharedPreferenceManagerImpl.initializeOnBackgroundThread");
            k92.b();
        }
    }

    private final void b() {
        synchronized (((b82) this.i).j) {
            try {
                ty0 ty0Var = (ty0) ((b82) this.i).h;
                if (ty0Var != null) {
                    Exception excA = ((pm1) this.h).a();
                    hg0.i(excA);
                    ty0Var.onFailure(excA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        synchronized (((b82) this.i).j) {
            try {
                cz0 cz0Var = (cz0) ((b82) this.i).h;
                if (cz0Var != null) {
                    cz0Var.a(((pm1) this.h).b());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                wb2 wb2Var = (wb2) this.h;
                Context context = (Context) wb2Var.h;
                String string = wb2.F(context).getString("app_set_id", null);
                long j = wb2.F((Context) wb2Var.h).getLong("app_set_id_last_used_time", -1L);
                long j2 = j != -1 ? 33696000000L + j : -1L;
                qm1 qm1Var = (qm1) this.i;
                od2 od2Var = qm1Var.a;
                if (string != null && System.currentTimeMillis() <= j2) {
                    try {
                        wb2.G(context);
                    } catch (rb2 e) {
                        od2Var.g(e);
                        return;
                    }
                    break;
                } else {
                    string = UUID.randomUUID().toString();
                    try {
                        if (!context.getSharedPreferences("app_set_id_storage", 0).edit().putString("app_set_id", string).commit()) {
                            String strValueOf = String.valueOf(context.getPackageName());
                            if (strValueOf.length() != 0) {
                                "Failed to store app set ID generated for App ".concat(strValueOf);
                            }
                            throw new rb2("Failed to store the app set ID.");
                        }
                        wb2.G(context);
                        if (!context.getSharedPreferences("app_set_id_storage", 0).edit().putLong("app_set_id_creation_time", System.currentTimeMillis()).commit()) {
                            String strValueOf2 = String.valueOf(context.getPackageName());
                            if (strValueOf2.length() != 0) {
                                "Failed to store app set ID creation time for App ".concat(strValueOf2);
                            }
                            throw new rb2("Failed to store the app set ID creation time.");
                        }
                    } catch (rb2 e2) {
                        od2Var.g(e2);
                        return;
                    }
                }
                qm1Var.a(new f7(string, 1));
                return;
            case 1:
                synchronized (((b82) this.i).j) {
                    try {
                        py0 py0Var = (py0) ((b82) this.i).h;
                        if (py0Var != null) {
                            py0Var.onComplete((pm1) this.h);
                        }
                    } finally {
                    }
                    break;
                }
                return;
            case 2:
                a();
                return;
            case 3:
                ((yb2) ((n62) this.h).b).g.getWindow().setBackgroundDrawable((BitmapDrawable) this.i);
                return;
            case 4:
                b();
                return;
            case 5:
                c();
                return;
            case 6:
                y22 y22Var = (y22) this.h;
                y22Var.getClass();
                zzdoa zzdoaVar = ((zzdoa[]) this.i)[0];
                if (zzdoaVar != null) {
                    y22Var.k.zzb(zzgcj.zzh(zzdoaVar));
                    return;
                }
                return;
            default:
                od2 od2Var2 = (od2) this.h;
                try {
                    od2Var2.h(((Callable) this.i).call());
                    return;
                } catch (Exception e3) {
                    od2Var2.g(e3);
                    return;
                } catch (Throwable th) {
                    od2Var2.g(new RuntimeException(th));
                    return;
                }
        }
    }

    public /* synthetic */ gb2(b82 b82Var, pm1 pm1Var, int i) {
        this.g = i;
        this.i = b82Var;
        this.h = pm1Var;
    }
}
