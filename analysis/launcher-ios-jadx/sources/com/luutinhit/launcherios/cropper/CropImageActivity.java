package com.luutinhit.launcherios.cropper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import defpackage.m61;
import defpackage.n90;
import defpackage.op;
import defpackage.qp;
import defpackage.tp;
import defpackage.ua;
import defpackage.v51;
import defpackage.w61;
import defpackage.xp;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CropImageActivity extends ua implements xp, tp, View.OnClickListener {
    public CropImageView B;
    public Uri C;
    public qp D;

    public final void A(Uri uri, Exception exc, int i) {
        int i2 = exc == null ? -1 : 204;
        op opVar = new op(this.B.getImageUri(), uri, exc, this.B.getCropPoints(), this.B.getCropRect(), this.B.getWholeImageRect(), this.B.getRotatedDegrees(), i);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", opVar);
        setResult(i2, intent);
        finish();
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Uri uriFromFile;
        String action;
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            if (i2 == 0) {
                setResult(0);
                finish();
            }
            if (i2 == -1) {
                if (intent == null || intent.getData() == null || (((action = intent.getAction()) != null && action.equals("android.media.action.IMAGE_CAPTURE")) || intent.getData() == null)) {
                    File externalCacheDir = getExternalCacheDir();
                    uriFromFile = externalCacheDir != null ? Uri.fromFile(new File(externalCacheDir.getPath(), "pickImageResult.jpeg")) : null;
                } else {
                    uriFromFile = intent.getData();
                }
                this.C = uriFromFile;
                if (n90.y(this, uriFromFile)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.B.setImageUriAsync(this.C);
                }
            }
        }
    }

    @Override // defpackage.ua, androidx.activity.a, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || view.getId() != v51.ok_crop_button) {
            return;
        }
        qp qpVar = this.D;
        if (qpVar.R) {
            A(null, null, 1);
            return;
        }
        Uri uriFromFile = qpVar.M;
        if (uriFromFile == null || uriFromFile.equals(Uri.EMPTY)) {
            try {
                Bitmap.CompressFormat compressFormat = this.D.N;
                uriFromFile = Uri.fromFile(File.createTempFile("cropped", compressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" : compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".webp", getCacheDir()));
            } catch (IOException e) {
                throw new RuntimeException("Failed to create temp file for output image", e);
            }
        }
        Uri uri = uriFromFile;
        CropImageView cropImageView = this.B;
        qp qpVar2 = this.D;
        Bitmap.CompressFormat compressFormat2 = qpVar2.N;
        int i = qpVar2.O;
        int i2 = qpVar2.P;
        int i3 = qpVar2.Q;
        int i4 = qpVar2.c0;
        if (cropImageView.D == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        cropImageView.h(i2, i3, i4, uri, compressFormat2, i);
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.crop_image_activity);
        z(findViewById(v51.root_layout), true);
        this.B = (CropImageView) findViewById(v51.cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.C = (Uri) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.D = (qp) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            Uri uri = this.C;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (n90.x(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2011);
                } else {
                    startActivityForResult(n90.n(this, getString(w61.pick_image)), 200);
                }
            } else if (n90.y(this, this.C)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.B.setImageUriAsync(this.C);
            }
        }
        findViewById(v51.ok_crop_button).setOnClickListener(this);
    }

    @Override // defpackage.e6, androidx.activity.a, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 201) {
            Uri uri = this.C;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, w61.crop_image_activity_no_permissions, 1).show();
                setResult(0);
                finish();
            } else {
                this.B.setImageUriAsync(uri);
            }
        }
        if (i == 2011) {
            startActivityForResult(n90.n(this, getString(w61.pick_image)), 200);
        }
    }

    @Override // defpackage.ua, defpackage.e6, android.app.Activity
    public final void onStart() {
        super.onStart();
        this.B.setOnSetImageUriCompleteListener(this);
        this.B.setOnCropImageCompleteListener(this);
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onStop() {
        super.onStop();
        this.B.setOnSetImageUriCompleteListener(null);
        this.B.setOnCropImageCompleteListener(null);
    }
}
