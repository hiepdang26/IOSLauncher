package com.luutinhit.launcherios.activity;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.a;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import com.luutinhit.launcherios.cropper.CropImageActivity;
import defpackage.ar1;
import defpackage.cw;
import defpackage.e42;
import defpackage.e51;
import defpackage.ee1;
import defpackage.fz1;
import defpackage.ge0;
import defpackage.hg0;
import defpackage.j7;
import defpackage.jk0;
import defpackage.l51;
import defpackage.m61;
import defpackage.na1;
import defpackage.o61;
import defpackage.op;
import defpackage.p3;
import defpackage.qe0;
import defpackage.qp;
import defpackage.qv;
import defpackage.rp;
import defpackage.sg;
import defpackage.sp;
import defpackage.t3;
import defpackage.u3;
import defpackage.ua;
import defpackage.ue0;
import defpackage.ur0;
import defpackage.v51;
import defpackage.v7;
import defpackage.vr0;
import defpackage.w61;
import defpackage.x4;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IconChangeActivity extends ua {
    public static final /* synthetic */ int M = 0;
    public Context B;
    public LinearLayout C;
    public sg D;
    public RealTimeBlurView E;
    public float F;
    public int G;
    public AppCompatImageView H;
    public String I;
    public cw K;
    public final ArrayList J = new ArrayList();
    public final List L = Arrays.asList(Integer.valueOf(l51.call_icon), Integer.valueOf(l51.calculator_icon), Integer.valueOf(l51.calendar_icon), Integer.valueOf(l51.camera_icon), Integer.valueOf(l51.chrome_icon), Integer.valueOf(l51.clock_icon), Integer.valueOf(l51.compass_icon), Integer.valueOf(l51.contact_icon), Integer.valueOf(l51.drive_icon), Integer.valueOf(l51.dropbox_icon), Integer.valueOf(l51.email_icon), Integer.valueOf(l51.facebook_icon), Integer.valueOf(l51.flipboard_icon), Integer.valueOf(l51.game_icon), Integer.valueOf(l51.gmail_icon), Integer.valueOf(l51.google_icon), Integer.valueOf(l51.google_maps_icon), Integer.valueOf(l51.google_photos_icon), Integer.valueOf(l51.health_icon), Integer.valueOf(l51.instagram_icon), Integer.valueOf(l51.keep_icon), Integer.valueOf(l51.line_icon), Integer.valueOf(l51.message_icon), Integer.valueOf(l51.music_icon), Integer.valueOf(l51.notes_icon), Integer.valueOf(l51.photos_icon), Integer.valueOf(l51.safari_icon), Integer.valueOf(l51.settings_icon), Integer.valueOf(l51.siri_icon), Integer.valueOf(l51.snapchat_icon), Integer.valueOf(l51.spotify_icon), Integer.valueOf(l51.store_icon), Integer.valueOf(l51.translate_icon), Integer.valueOf(l51.twitter_icon), Integer.valueOf(l51.uber_icon), Integer.valueOf(l51.viber_icon), Integer.valueOf(l51.voice_memos_icon), Integer.valueOf(l51.whatsapp_icon), Integer.valueOf(o61.ic_weather), Integer.valueOf(l51.youtube_icon), Integer.valueOf(l51.ic_facetime), Integer.valueOf(l51.ic_files), Integer.valueOf(l51.ic_videos), Integer.valueOf(l51.ic_netflix), Integer.valueOf(l51.ic_mifit), Integer.valueOf(l51.ic_ap_maps), Integer.valueOf(l51.ic_wallet), Integer.valueOf(l51.ic_podcasts), Integer.valueOf(l51.ic_news), Integer.valueOf(l51.ic_radio), Integer.valueOf(l51.ic_reminders), Integer.valueOf(l51.ic_messenger), Integer.valueOf(l51.ic_home), Integer.valueOf(l51.ic_tv), Integer.valueOf(l51.ic_tips), Integer.valueOf(l51.ic_discord), Integer.valueOf(l51.ic_deezer), Integer.valueOf(l51.ic_fortnite), Integer.valueOf(l51.ic_pinterest), Integer.valueOf(l51.ic_tik_tok), Integer.valueOf(l51.ic_shazam), Integer.valueOf(l51.ic_stocks), Integer.valueOf(l51.ic_book), Integer.valueOf(l51.ic_telegram), Integer.valueOf(l51.ic_itunes_store));

    public final void A(AppCompatImageView appCompatImageView, final String str, final int i) {
        this.H = appCompatImageView;
        t3 t3Var = new t3(this);
        GridView gridView = new GridView(this.B);
        gridView.setNumColumns(3);
        gridView.setStretchMode(2);
        ue0 ue0Var = new ue0();
        ue0Var.g = this.L;
        gridView.setAdapter((ListAdapter) ue0Var);
        p3 p3Var = (p3) t3Var.h;
        p3Var.t = gridView;
        int i2 = w61.pick_image;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: pe0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                IconChangeActivity iconChangeActivity = this.g;
                String str2 = str;
                iconChangeActivity.I = str2;
                iconChangeActivity.B(str2);
            }
        };
        p3Var.g = p3Var.a.getText(i2);
        p3Var.h = onClickListener;
        qe0 qe0Var = new qe0();
        p3Var.k = p3Var.a.getText(R.string.cancel);
        p3Var.l = qe0Var;
        final u3 u3VarD = t3Var.d();
        u3VarD.show();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: re0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j) {
                Bitmap bitmapH;
                String str2 = str;
                IconChangeActivity iconChangeActivity = this.g;
                List list = iconChangeActivity.L;
                try {
                    int iIntValue = ((Integer) list.get(i3)).intValue();
                    Intent intent = new Intent("com.luutinhit.launcherios.ACTION_RELOAD_ICON");
                    intent.putExtra("EXTRA_COMPONENT_NAME", str2);
                    intent.putExtra("EXTRA_ICON_ID", iIntValue);
                    iconChangeActivity.sendBroadcast(intent);
                    Drawable drawable = iconChangeActivity.B.getDrawable(((Integer) list.get(i3)).intValue());
                    if (drawable != null && (bitmapH = ar1.h(drawable, iconChangeActivity.B)) != null) {
                        sg sgVar = iconChangeActivity.D;
                        Bitmap bitmapP = ar1.p(iconChangeActivity.B, bitmapH);
                        ArrayList arrayList = sgVar.k;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            int i4 = i;
                            if (size > i4) {
                                ((y6) sgVar.k.get(i4)).b = bitmapP;
                                sgVar.g(i4);
                            }
                        }
                    }
                    int i5 = l51.clock_icon;
                    ArrayList arrayList2 = iconChangeActivity.J;
                    if (iIntValue != i5) {
                        arrayList2.remove(str2);
                    } else if (!arrayList2.contains(str2)) {
                        arrayList2.add(str2);
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
                u3VarD.dismiss();
            }
        });
    }

    public final void B(String str) {
        Uri uriFromFile;
        boolean z = ar1.j;
        if (!z ? e42.h(this) : e42.g(this)) {
            Toast.makeText(this, w61.required_storage_permission, 1).show();
            if (z) {
                e42.o(this);
                return;
            } else {
                e42.p(this);
                return;
            }
        }
        int i = jk0.a().e.h;
        if (i <= 0) {
            i = (int) (((double) this.F) / 0.23d);
        }
        qp qpVar = new qp();
        qpVar.t = 1;
        qpVar.u = 1;
        qpVar.s = true;
        qpVar.k = sp.h;
        qpVar.K = getString(w61.pick_image);
        qpVar.h = this.F / i;
        qpVar.g = rp.h;
        qpVar.a0 = "Done";
        qpVar.N = Bitmap.CompressFormat.JPEG;
        qpVar.O = 100;
        qpVar.P = 200;
        qpVar.Q = 200;
        qpVar.c0 = 3;
        try {
            uriFromFile = Uri.fromFile(new File(new ContextWrapper(this).getDir("image", 0), str.replace("/", "_") + ".jpg"));
        } catch (Throwable unused) {
            uriFromFile = null;
        }
        qpVar.M = uriFromFile;
        qpVar.a();
        qpVar.a();
        Intent intent = new Intent();
        intent.setClass(this, CropImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("CROP_IMAGE_EXTRA_SOURCE", null);
        bundle.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", qpVar);
        intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
        startActivityForResult(intent, 203);
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        if (i == 203) {
            op opVar = intent != null ? (op) intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT") : null;
            if (i2 == -1 && (uri = opVar.h) != null) {
                uri.toString();
                Intent intent2 = new Intent("com.luutinhit.launcherios.ACTION_RELOAD_ICON");
                intent2.putExtra("EXTRA_COMPONENT_NAME", this.I);
                Uri uri2 = opVar.h;
                intent2.putExtra("EXTRA_ICON_PATH", uri2.getPath());
                intent2.setPackage(getPackageName());
                sendBroadcast(intent2);
                na1 na1VarO = ((na1) ((na1) a.e(this.B).l().w()).f(qv.c)).O(uri2);
                na1VarO.K(new ge0(this, 2), na1VarO);
            } else if (i2 == 204) {
                Toast.makeText(this, "Cropping failed: " + opVar.i, 1).show();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_change_icon);
        z(findViewById(v51.root_layout), true);
        this.B = getApplicationContext();
        this.E = (RealTimeBlurView) findViewById(v51.blurring_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(v51.list_apps);
        recyclerView.setNestedScrollingEnabled(false);
        this.F = this.B.getResources().getDimensionPixelSize(e51.icon_round_corner);
        this.G = getResources().getDimensionPixelSize(e51.item_hidden_app_size);
        this.C = (LinearLayout) findViewById(v51.progress_layout);
        this.E.setBlurredView((OverScrollLayout) findViewById(v51.overscroll_layout));
        recyclerView.getViewTreeObserver().addOnScrollChangedListener(new v7(this, 1));
        new LinearLayoutManager(1).f1(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.f1(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        sg sgVar = new sg(1);
        this.D = sgVar;
        recyclerView.setAdapter(sgVar);
        this.D.l = this;
        this.C.setVisibility(0);
        try {
            new ur0(new j7(this, 7)).B(ee1.a).z(new vr0(new fz1(this, 18), x4.a(), 0));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            hg0.C(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onDestroy() {
        cw cwVar = this.K;
        if (cwVar != null) {
            cwVar.b();
        }
        super.onDestroy();
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 68) {
            B(this.I);
        }
    }
}
