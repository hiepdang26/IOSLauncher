package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import defpackage.gy0;
import defpackage.hg0;
import defpackage.k92;
import defpackage.ka2;
import defpackage.x32;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbeo extends RelativeLayout {
    private static final float[] zza = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzb;

    public zzbeo(Context context, zzben zzbenVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        hg0.i(zzbenVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zza, null, null));
        shapeDrawable.getPaint().setColor(zzbenVar.zzd());
        setLayoutParams(layoutParams);
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzbenVar.zzg())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzbenVar.zzg());
            textView.setTextColor(zzbenVar.zze());
            textView.setTextSize(zzbenVar.zzf());
            ka2 ka2Var = x32.f.a;
            textView.setPadding(ka2.n(context, 4), 0, ka2.k(context.getResources().getDisplayMetrics(), 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List listZzi = zzbenVar.zzi();
        if (listZzi != null && listZzi.size() > 1) {
            this.zzb = new AnimationDrawable();
            Iterator it = listZzi.iterator();
            while (it.hasNext()) {
                try {
                    this.zzb.addFrame((Drawable) gy0.r(((zzbeq) it.next()).zzf()), zzbenVar.zzb());
                } catch (Exception unused) {
                    k92.f();
                }
            }
            imageView.setBackground(this.zzb);
        } else if (listZzi.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) gy0.r(((zzbeq) listZzi.get(0)).zzf()));
            } catch (Exception unused2) {
                k92.f();
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzb;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
