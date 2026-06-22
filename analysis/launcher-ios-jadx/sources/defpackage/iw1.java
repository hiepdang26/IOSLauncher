package defpackage;

import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcfz;
import com.google.gson.Gson;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.WeatherWidget_2x2;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.network.OpenWeather;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes.dex */
public final class iw1 implements Callback, ty0, c02, bb, zzcfz {
    public final Object g;

    public /* synthetic */ iw1(Object obj) {
        this.g = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        if (!(view instanceof ox)) {
            return false;
        }
        ((Workspace) this.g).U0.l.remove((ox) view);
        return false;
    }

    @Override // defpackage.bb
    public void onConnectionFailed(vl vlVar) {
        ((ga0) this.g).onConnectionFailed(vlVar);
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        th.getMessage();
        ((jw1) this.g).a.a(th);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        Objects.toString(response);
        boolean zIsSuccessful = response.isSuccessful();
        jw1 jw1Var = (jw1) this.g;
        if (!zIsSuccessful) {
            jw1Var.a.a(new Throwable(response.message()));
            return;
        }
        CurrentResponse currentResponse = (CurrentResponse) response.body();
        tz0 tz0Var = jw1Var.a;
        tz0Var.getClass();
        Objects.toString(currentResponse);
        if (currentResponse == null || currentResponse.getWeather() == null || currentResponse.getMain() == null || currentResponse.getSys() == null) {
            return;
        }
        String json = new Gson().toJson(currentResponse);
        new Handler(Looper.getMainLooper()).post(new sz0(tz0Var, tz0Var.a, currentResponse, 1));
        OpenWeather openWeather = tz0Var.c;
        openWeather.write(openWeather.mContext, tz0Var.b, json);
    }

    @Override // com.google.android.gms.internal.ads.zzcfz
    public void zza(boolean z, int i, String str, String str2) {
        zzcej zzcejVar = ((yb2) this.g).i;
        if (zzcejVar != null) {
            zzcejVar.zzaa();
        }
    }

    @Override // defpackage.ty0
    public void onFailure(Exception exc) {
        if (exc instanceof cb1) {
            try {
                ((cb1) exc).a((t) ((WeatherWidget_2x2) this.g).k);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }
}
