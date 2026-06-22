package com.luutinhit.launcher6;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import defpackage.mt;
import defpackage.r71;
import defpackage.w9;
import defpackage.y9;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class CommonAppTypeParser implements w9 {
    private static final int RESTORE_FLAG_BIT_SHIFT = 4;
    public static final int SUPPORTED_TYPE_COUNT = 7;
    private static final String TAG = "CommonAppTypeParser";
    final Context mContext;
    private final long mItemId;
    final int mResId;
    Intent parsedIntent;
    String parsedTitle;
    ContentValues parsedValues;

    public CommonAppTypeParser(long j, int i, Context context) {
        this.mItemId = j;
        this.mContext = context;
        this.mResId = getResourceForItemType(i);
    }

    public static int decodeItemTypeFromFlag(int i) {
        return (i & 240) >> 4;
    }

    public static int encodeItemTypeToFlag(int i) {
        return i << 4;
    }

    public static int getResourceForItemType(int i) {
        switch (i) {
            case 1:
                return r71.app_target_phone;
            case 2:
                return r71.app_target_messenger;
            case 3:
                return r71.app_target_email;
            case 4:
                return r71.app_target_browser;
            case 5:
                return r71.app_target_gallery;
            case 6:
                return r71.app_target_camera;
            default:
                return 0;
        }
    }

    public boolean findDefaultApp() {
        if (this.mResId == 0) {
            return false;
        }
        this.parsedIntent = null;
        this.parsedValues = null;
        a aVar = new a(this);
        XmlResourceParser xml = aVar.c.getXml(aVar.d);
        try {
            y9.b(xml, aVar.e);
            mt mtVar = new mt(aVar);
            int depth = xml.getDepth();
            long jA = -1;
            while (true) {
                int next = xml.next();
                if (next == 3 && xml.getDepth() <= depth) {
                    break;
                }
                if (next == 2 && jA <= -1 && "favorite".equals(xml.getName())) {
                    jA = mtVar.a(xml);
                }
            }
        } catch (IOException | XmlPullParserException unused) {
        }
        xml.close();
        return (this.parsedValues == null || this.parsedIntent == null) ? false : true;
    }

    @Override // defpackage.w9
    public long generateNewItemId() {
        return this.mItemId;
    }

    @Override // defpackage.w9
    public long insertAndCheck(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        this.parsedValues = contentValues;
        contentValues.put("iconType", (Integer) null);
        contentValues.put("iconPackage", (String) null);
        contentValues.put("iconResource", (String) null);
        contentValues.put("icon", (byte[]) null);
        return 1L;
    }
}
