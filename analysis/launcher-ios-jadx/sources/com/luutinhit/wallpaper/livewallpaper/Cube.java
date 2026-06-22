package com.luutinhit.wallpaper.livewallpaper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import defpackage.hq;
import defpackage.tu;

/* JADX INFO: loaded from: classes.dex */
public class Cube extends View {
    public final Paint g;
    public final Paint h;
    public final hq[] i;
    public final tu[] j;
    public final Path k;
    public final Path l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cube(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        int i = 3;
        boolean z = false;
        Paint paint = new Paint();
        this.g = paint;
        Paint paint2 = new Paint();
        this.h = paint2;
        this.k = new Path();
        this.l = new Path();
        paint.setColor(-1275068417);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3.0f);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint2.setColor(1711276031);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(2.0f);
        paint2.setStrokeCap(cap);
        paint2.setStyle(style);
        paint2.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f}, 0.0f));
        hq[] hqVarArr = {new hq(this, -1.0f, -1.0f, 1.0f), new hq(this, -1.0f, 1.0f, 1.0f), new hq(this, 1.0f, 1.0f, 1.0f), new hq(this, 1.0f, -1.0f, 1.0f), new hq(this, -1.0f, -1.0f, -1.0f), new hq(this, -1.0f, 1.0f, -1.0f), new hq(this, 1.0f, 1.0f, -1.0f), new hq(this, 1.0f, -1.0f, -1.0f)};
        this.i = hqVarArr;
        hq hqVar = hqVarArr[0];
        hq hqVar2 = hqVarArr[1];
        tu tuVar = new tu(hqVar, hqVar2, i, z);
        hq hqVar3 = hqVarArr[2];
        tu tuVar2 = new tu(hqVar2, hqVar3, i, z);
        hq hqVar4 = hqVarArr[3];
        tu tuVar3 = new tu(hqVar3, hqVar4, i, z);
        tu tuVar4 = new tu(hqVar4, hqVar, i, z);
        hq hqVar5 = hqVarArr[4];
        tu tuVar5 = new tu(hqVar, hqVar5, i, z);
        hq hqVar6 = hqVarArr[5];
        tu tuVar6 = new tu(hqVar2, hqVar6, i, z);
        hq hqVar7 = hqVarArr[6];
        tu tuVar7 = new tu(hqVar3, hqVar7, i, z);
        hq hqVar8 = hqVarArr[7];
        this.j = new tu[]{tuVar, tuVar2, tuVar3, tuVar4, tuVar5, tuVar6, tuVar7, new tu(hqVar4, hqVar8, i, z), new tu(hqVar5, hqVar6, i, z), new tu(hqVar6, hqVar7, i, z), new tu(hqVar7, hqVar8, i, z), new tu(hqVar8, hqVar5, i, z)};
    }

    private int getMaxSize() {
        return Math.min(getWidth(), getHeight());
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        tu[] tuVarArr;
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        int maxSize = getMaxSize();
        hq[] hqVarArr = this.i;
        int i = 0;
        for (int length = hqVarArr.length; i < length; length = length) {
            hq hqVar = hqVarArr[i];
            Cube cube = hqVar.h;
            double d = 0.0f;
            double dSin = Math.sin(d);
            double d2 = hqVar.c;
            double dCos = Math.cos(d);
            hq[] hqVarArr2 = hqVarArr;
            double d3 = hqVar.b;
            hqVar.e = (float) ((dCos * d3) + (dSin * d2));
            hqVar.f = (float) ((Math.cos(d) * d2) - (Math.sin(d) * d3));
            double dSin2 = Math.sin(d) * ((double) hqVar.f);
            double dCos2 = Math.cos(d);
            double d4 = hqVar.a;
            hqVar.d = (float) ((dCos2 * d4) + dSin2);
            float fCos = (float) ((Math.cos(d) * ((double) hqVar.f)) - (Math.sin(d) * d4));
            hqVar.f = fCos;
            float f = maxSize * 3.0f;
            float f2 = fCos + 10.0f;
            hqVar.d = (hqVar.d * f) / f2;
            hqVar.e = (f * hqVar.e) / f2;
            i++;
            hqVarArr = hqVarArr2;
        }
        hq[] hqVarArr3 = hqVarArr;
        int i2 = 0;
        while (true) {
            tuVarArr = this.j;
            if (i2 >= 4) {
                break;
            }
            hq hqVar2 = hqVarArr3[i2];
            if (hqVar2.d < tuVarArr[8].h(hqVar2.e) || hqVar2.d > tuVarArr[10].h(hqVar2.e) || hqVar2.e < tuVarArr[11].i(hqVar2.d) || hqVar2.e > tuVarArr[9].i(hqVar2.d)) {
                hqVar2.g = false;
            } else {
                hqVar2.g = true;
            }
            i2++;
        }
        Path path = this.k;
        path.reset();
        Path path2 = this.l;
        path2.reset();
        for (tu tuVar : tuVarArr) {
            hq hqVar3 = (hq) tuVar.h;
            boolean z = hqVar3.g;
            hq hqVar4 = (hq) tuVar.i;
            if (z || hqVar4.g) {
                path2.moveTo(hqVar3.d, hqVar3.e);
                path2.lineTo(hqVar4.d, hqVar4.e);
            } else {
                path.moveTo(hqVar3.d, hqVar3.e);
                path.lineTo(hqVar4.d, hqVar4.e);
            }
        }
        canvas.drawPath(path2, this.h);
        canvas.drawPath(path, this.g);
        canvas.restore();
    }
}
