package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import defpackage.hd2;
import defpackage.ka2;
import defpackage.x32;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcrg extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcrg(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcrg zza(Context context, View view, zzfel zzfelVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcrg zzcrgVar = new zzcrg(context);
        if (!zzfelVar.zzu.isEmpty() && (resources = zzcrgVar.zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            float f = ((zzfem) zzfelVar.zzu.get(0)).zza;
            float f2 = displayMetrics.density;
            zzcrgVar.setLayoutParams(new FrameLayout.LayoutParams((int) (f * f2), (int) (r1.zzb * f2)));
        }
        zzcrgVar.zzb = view;
        zzcrgVar.addView(view);
        hd2 hd2Var = hd2.B;
        zzcab zzcabVar = hd2Var.A;
        zzcab.zzb(zzcrgVar, zzcrgVar);
        zzcab zzcabVar2 = hd2Var.A;
        zzcab.zza(zzcrgVar, zzcrgVar);
        JSONObject jSONObject = zzfelVar.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzcrgVar.zza);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject != null) {
            zzcrgVar.zzc(jSONObjectOptJSONObject, relativeLayout, 10);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
        if (jSONObjectOptJSONObject2 != null) {
            zzcrgVar.zzc(jSONObjectOptJSONObject2, relativeLayout, 12);
        }
        zzcrgVar.addView(relativeLayout);
        return zzcrgVar;
    }

    private final int zzb(double d) {
        ka2 ka2Var = x32.f.a;
        return ka2.n(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int iZzb = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, iZzb, 0, iZzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        getLocationInWindow(new int[2]);
        this.zzb.setY(-r0[1]);
    }
}
