package com.google.android.gms.internal.ads;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import defpackage.hd2;
import defpackage.ls0;
import defpackage.rv0;
import defpackage.s61;
import defpackage.v2;
import defpackage.xv0;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwg {
    public static final void zza(Context context, ViewGroup viewGroup, v2 v2Var) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag("layout");
        zzf(linearLayout, -1, -1);
        linearLayout.setGravity(17);
        linearLayout.addView(v2Var);
        v2Var.setTag("ad_view");
        viewGroup.addView(linearLayout);
    }

    public static final void zzb(Context context, ViewGroup viewGroup, rv0 rv0Var) {
        xv0 xv0Var = new xv0(context);
        xv0Var.setTag("ad_view_tag");
        zzf(xv0Var, -1, -1);
        viewGroup.addView(xv0Var);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag("layout_tag");
        linearLayout.setOrientation(1);
        zzf(linearLayout, -1, -1);
        linearLayout.setBackgroundColor(-1);
        xv0Var.addView(linearLayout);
        Resources resourcesZze = hd2.B.g.zze();
        linearLayout.addView(zzc(context, resourcesZze == null ? "Headline" : resourcesZze.getString(s61.native_headline), "headline_header_tag"));
        View viewZzd = zzd(context, zzfvj.zzc(rv0Var.getHeadline()), "headline_tag");
        xv0Var.setHeadlineView(viewZzd);
        linearLayout.addView(viewZzd);
        linearLayout.addView(zzc(context, resourcesZze == null ? "Body" : resourcesZze.getString(s61.native_body), "body_header_tag"));
        View viewZzd2 = zzd(context, zzfvj.zzc(rv0Var.getBody()), "body_tag");
        xv0Var.setBodyView(viewZzd2);
        linearLayout.addView(viewZzd2);
        linearLayout.addView(zzc(context, resourcesZze == null ? "Media View" : resourcesZze.getString(s61.native_media_view), "media_view_header_tag"));
        ls0 ls0Var = new ls0(context);
        ls0Var.setTag("media_view_tag");
        xv0Var.setMediaView(ls0Var);
        linearLayout.addView(ls0Var);
        xv0Var.setNativeAd(rv0Var);
    }

    private static TextView zzc(Context context, String str, String str2) {
        return zze(context, str, R.style.TextAppearance.Small, -9210245, 0.0f, str2);
    }

    private static TextView zzd(Context context, String str, String str2) {
        return zze(context, str, R.style.TextAppearance.Medium, -16777216, 12.0f, str2);
    }

    private static TextView zze(Context context, String str, int i, int i2, float f, String str2) {
        TextView textView = new TextView(context);
        textView.setTag(str2);
        zzf(textView, -2, -2);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new TableRow.LayoutParams();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        marginLayoutParams.bottomMargin = (int) TypedValue.applyDimension(1, f, textView.getResources().getDisplayMetrics());
        textView.setLayoutParams(marginLayoutParams);
        textView.setTextAppearance(context, i);
        textView.setTextColor(i2);
        textView.setText(str);
        return textView;
    }

    private static void zzf(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new TableRow.LayoutParams();
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
        layoutParams2.height = i;
        layoutParams2.width = i2;
        view.setLayoutParams(layoutParams2);
    }
}
