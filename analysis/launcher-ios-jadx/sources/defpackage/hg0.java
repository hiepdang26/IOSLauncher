package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes.dex */
public abstract class hg0 implements cu1 {
    public static Context a;
    public static Boolean b;
    public static final wg1 c = new wg1("RESUME_TOKEN", 1);
    public static final wg1 d = new wg1("COMPLETING_ALREADY", 1);
    public static final wg1 e = new wg1("COMPLETING_WAITING_CHILDREN", 1);
    public static final wg1 f = new wg1("COMPLETING_RETRY", 1);
    public static final wg1 g = new wg1("TOO_LATE_TO_CANCEL", 1);
    public static final wg1 h = new wg1("SEALED", 1);
    public static final qz i = new qz(false);
    public static final qz j = new qz(true);
    public static final byte[] k = {64, 25, 8, 92, 31, 28, 26, 26, 73, 93, 88, 89, 84, 75, 31, 107, 5, 28, 6, 11, 12, 1, 0, 0, 29, 67, 2, 8, 74, 5, 0, 24, 4, 73, 8, 4, 6, 21, 90, 87, 107, 127, 27, 13, 1, 3, 29, 27, 2, 83, 16, 14, 0, 94, 0, 16, 7, 70, 45, 78, 29, 54, 32, 75, 20, 21, 0, 28, 6, 83, 111, 7, 7, 6, 21, 12, 29, 0, 14, 31, 20, 24, 4, 5, 11, 26, 91, 48, 14, 25, 62, 38, 42, 37, 37, 4, 1, 2, 84, 121, 22, 1, 4, 72, 3, 7, 24, 84, 31, 11, 11, 91, 84, 91, 51, 55, 28, 11, 20, 59, 12, 8, 12, 84, 121, 22, 1, 4, 72, 3, 7, 24, 84, 15, 2, 7, 8, 0, 14, 25, 62, 54, 1, 17, 6, 0, 0, 59, 14, 23, 10, 26, 30, 21, 102, 0, 27, 29, 15, 1, 26, 4, 84, 72, 0, 14, 20, 26, 67, 29, 58, 32, 12, 9, 1, 2, 12, 25, 71, 3, 27, 61, 17, 0, 9, 0, 29, 79, 36, 25, 15, 28, 8, 12, 26, 8, 82, 15, 3, 28, 2, 27, 77, 91, 51, 39, 16, 18, 27, 15, 11, 29, 29, 65, 2, 32, 24, 1, 22, 6, 17, 73, 99, 26, 29, 10, 9, 2, 92, 1, 85, 19, 24, 6, 15, 28, 73, 1, 113, 40, 4, 5, 26, 11, 45, 3, 20, 12, 12, 7, 88, 101, 24, 64, 5, 19, 26, 6, 4, 78, 14, 5, 27, 79, 24, 65, 0, 49, 48, 28, 23, 29, 2, 10, 36, 10, 11, 25, 70, 87, 127, 0, 26, 0, 8, 7, 27, 25, 14, 26, 4, 22, 92, 67, 29, 58, 48, 8, 12, 24, 4, 29, 2, 91, 2, 17, 38, 29, 19, 11, 83, 99, 1, 64, 5, 7, 26, 28, 14, 72, 19, 23, 10, 93, 83, 22, 48, 42, 66, 58, 28, 16, 3, 57, 1, 27, 0, 0, 71, 3, 15, 78, 100, 105, 11, 10, 28, 26, 27, 83, 21, 10, 14, 29, 76, 57, 32, 57, 40, 78, 85, 73, 2, 75, 15, 82, 93, 94, 77, 90, 92, 75, 69, 79, 67, 77, 90, 85, 25, 64, 85, 69, 90, 88, 95, 92, 64, 79, 36, 102, 8, 27, 78, 21, 13, 6, 64, 73, 25, 44, 55, 10, 21, 109, 3, 26, 7, 16, 82, 100, 7, 28, 0, 14, 26, 4, 22, 90, 67, 14, 23, 19, 14, 44, 28, 15, 0, 31, 21, 102, 127, 19, 24, 6, 15, 28, 73, 7, 74, 62, 4, 22, 26, 2, 6, 2, 30, 12, 71, 5, 6, 12, 95, 14, 15, 26, 26, 6, 13, 66, 72, 31, 17, 77, 94, 65, 29, 15, 15, 14, 54, 27, 19, 10, 90, 67, 20, 103, 14, 76, 85, 85, 2, 12, 13, 90, 73, 16, 14, 81, 65, 20, 12, 16, 64, 6, 29, 6, 29, 23, 74, 79, 64, 14, 4, 20, 25, 18, 58, 7, 18, 12, 79, 36, 76, 65, 85, 78, 5, 4, 10, 19, 29, 79, 28, 22, 27, 30, 71, 8, 16, 85, 73, 73, 2, 13, 7, 19, 90, 4, 73, 24, 15, 27, 64, 1, 94, 73, 95, 93, 83, 70, 68, 21, 102, 85, 85, 84, 73, 8, 4, 6, 21, 90, 76, 8, 27, 29, 10, 12, 0, 82, 84, 79, 30, 10, 1, 69, 67, 13, 13, 93, 16, 71, 22, 68, 73, 16, 0, 21, 72, 89, 78, 83, 70, 85, 91, 82, 101, 83, 67, 79, 77, 92, 9, 1, 0, 6, 7, 78, 7, 28, 0, 93, 5, 5, 16, 78, 72, 72, 12, 28, 26, 6, 23, 6, 84, 103, 83, 102, 127, 19, 24, 6, 15, 28, 73, 7, 74, 62, 14, 0, 0, 7, 13, 1, 32, 12, 12, 7, 2, 1, 10, 66, 9, 93, 3, 17, 10, 92, 72, 10, 27, 65, 30, 5, 89, 78, 21, 13, 6, 64, 73, 7, 18, 15, 9, 62, 71, 22, 16, 89, 84, 15, 2, 7, 8, 0, 14, 15, 14, 7, 0, 6, 26, 55, 19, 13, 6, 6, 16, 70, 77, 85, 102, 85, 85, 84, 73, 24, 13, 10, 70, 14, 5, 15, 27, 11, 17, 32, 4, 30, 15, 60, 26, 25, 10, 77, 19, 76, 29, 20, 24, 15, 61, 1, 19, 17, 14, 65, 65, 3, 11, 0, 90, 77, 17, 6, 29, 29, 6, 29, 63, 79, 8, 28, 0, 7, 64, 85, 98, 73, 84, 14, 76, 19, 16, 26, 22, 26, 11, 82, 26, 11, 33, 6, 12, 25, 79, 2, 18, 25, 17, 65, 13, 7, 6, 6, 74, 64, 65, 28, 0, 13, 13, 23, 58, 8, 3, 21, 48, 6, 23, 75, 69, 85, 88, 84, 10, 1, 26, 7, 17, 92, 62, 0, 17, 7, 22, 27, 94, 120, 20, 101, 121, 21, 10, 14, 28, 76, 18, 7, 21, 13, 61, 12, 59, 27, 91, 2, 5, 16, 10, 49, 13, 6, 6, 8, 1, 20, 15, 10, 69, 88, 9, 22, 71, 84, 10, 1, 7, 27, 16, 2, 76, 23, 16, 13, 81, 72, 13, 19, 5, 9, 32, 10, 21, 8, 2, 76, 19, 25, 27, 8, 26, 72, 10, 27, 92, 2, 4, 7, 60, 2, 12, 12, 7, 26, 70, 83, 24, 101, 77, 14, 76, 85, 3, 17, 10, 92, 72, 0, 26, 64, 9, 19, 61, 15, 15, 14, 54, 27, 19, 10, 83, 94, 79, 5, 79, 0, 19, 38, 29, 19, 11, 72, 68, 84, 88, 9, 2, 71, 70, 0, 7, 23, 28, 12, 29, 33, 2, 11, 4, 91, 31, 92, 78, 126, 73, 78, 72, 73, 2, 75, 15, 83, 85, 13, 12, 26, 11, 23, 27, 44, 28, 12, 29, 9, 14, 81, 85, 20, 22, 26, 70, 11, 6, 27, 92, 8, 72, 85, 67, 67, 1, 11, 28, 12, 29, 59, 
    2, 3, 11, 125, 5, 15, 16, 79, 99, 100, 72, 73, 84, 14, 10, 13, 26, 15, 23, 72, 12, 28, 26, 6, 23, 6, 44, 2, 92, 2, 16, 7, 84, 84, 78, 27, 29, 17, 94, 68, 81, 91, 94, 79, 72, 8, 27, 7, 71, 16, 12, 29, 3, 75, 30, 54, 26, 27, 27, 10, 70, 17, 88, 14, 15, 14, 7, 0, 6, 26, 38, 29, 6, 29, 23, 77, 22, 68, 7, 87, 127, 85, 84, 73, 78, 14, 5, 27, 79, 24, 65, 13, 35, 2, 2, 10, 0, 73, 82, 83, 16, 27, 8, 94, 68, 22, 26, 6, 7, 11, 26, 42, 27, 65, 30, 5, 91, 23, 79, 72, 6, 29, 27, 1, 22, 17, 44, 2, 65, 30, 17, 91, 12, 64, 85, 98, 73, 84, 14, 76, 23, 16, 13, 81, 72, 2, 0, 8, 11, 54, 7, 8, 8, 14, 81, 85, 3, 17, 10, 92, 64, 17, 57, 79, 6, 14, 7, 66, 67, 89, 75, 66, 73, 66, 83, 27, 34, 12, 68, 3, 7, 92, 79, 99, 78, 72, 73, 84, 88, 9, 2, 71, 78, 4, 26, 4, 22, 42, 0, 1, 13, 10, 31, 14, 81, 85, 27, 27, 27, 3, 9, 5, 29, 84, 9, 73, 22, 1, 17, 6, 0, 0, 42, 0, 28, 17, 11, 68, 21, 102, 85, 85, 84, 73, 28, 13, 29, 1, 92, 2, 65, 6, 7, 4, 6, 77, 17, 6, 0, 1, 7, 70, 77, 4, 76, 24, 28, 12, 65, 9, 26, 8, 16, 107, 8, 6, 16, 66, 67, 15, 23, 19, 13, 44, 28, 17, 1, 8, 92, 64, 85, 28, 26, 26, 7, 12, 12, 55, 65, 30, 15, 16, 28, 74, 83, 111, 15, 99, 101, 21, 15, 0, 12, 90, 76, 22, 28, 6, 10, 2, 13, 36, 21, 94, 68, 7, 25, 1, 2, 28, 69, 10, 64, 79, 8, 105, 79, 77, 14, 76, 7, 16, 0, 28, 28, 6, 73, 69, 0, 92, 65, 88, 78, 16, 25, 23, 6, 65, 94, 93, 83, 79, 64, 14, 20, 85, 95, 84, 17, 71, 83, 99, 9, 36, 102, 7, 25, 1, 2, 28, 69, 31, 12, 11, 26, 2, 1, 69, 88, 9, 22, 70, 84, 31, 71, 72, 18, 126, 14, 76, 65, 85, 28, 6, 28, 16, 0, 7, 79, 30, 2, 23, 69, 67, 5, 27, 93, 2, 71, 28, 68, 73, 2, 0, 11, 72, 89, 78, 14, 1, 11, 90, 4, 14, 11, 75, 25, 67, 92, 64, 85, 3, 90, 14, 71, 68, 73, 2, 0, 14, 72, 92, 85, 105, 21, 111, 120, 31, 10, 16, 80, 79, 12, 74, 6, 0, 6, 0, 58, 15, 28, 28, 6, 79, 24, 8, 26, 0, 75, 30, 0, 17, 90, 79, 16, 12, 3, 2, 92, 64, 85, 19, 24, 6, 15, 28, 73, 7, 79, 24, 20, 7, 15, 23, 1, 10, 28, 64, 79, 8, 105, 79, 77, 14, 76, 19, 25, 27, 8, 26, 72, 14, 6, 79, 21, 65, 72, 78, 7, 7, 17, 90, 10, 0, 31, 12, 29, 65, 14, 32, 32, 56, 53, 64, 85, 98, 73, 84, 14, 76, 19, 16, 26, 22, 26, 11, 82, 4, 6, 11, 75, 25, 8, 77, 95, 93, 18, 6, 8, 23, 65, 69, 84, 77, 3, 13, 26, 28, 79, 72, 22, 19, 29, 26, 1, 2, 27, 4, 65, 2, 92, 78, 126, 20, 100, 98, 31, 27, 71, 8, 65, 24, 15, 10, 6, 77, 91, 73, 20, 121, 67, 79, 77, 14, 26, 16, 22, 70, 73, 12, 9, 10, 31, 73, 30, 14, 0, 0, 7, 56, 12, 10, 12, 3, 48, 12, 0, 31, 74, 76, 72, 85, 2, 54, 58, 13, 17, 55, 65, 3, 19, 17, 78, 73, 72, 16, 45, 63, 6, 22, 20, 60, 4, 84, 9, 85, 94, 84, 28, 49, 47, 5, 34, 71, 9, 22, 37, 1, 16, 1, 17, 27, 6, 1, 72, 105, 79, 77, 14, 76, 3, 16, 23, 91, 78, 14, 0, 26, 79, 0, 53, 16, 22, 23, 29, 23, 23, 42, 0, 28, 17, 11, 77, 19, 76, 23, 20, 23, 2, 9, 26, 6, 1, 64, 8, 49, 28, 22, 6, 4, 38, 29, 6, 29, 23, 67, 64, 77, 91, 51, 55, 20, 23, 2, 9, 26, 6, 1, 64, 8, 50, 28, 20, 6, 83, 111, 82, 73, 79, 83, 21, 10, 14, 28, 76, 29, 20, 24, 15, 61, 1, 19, 17, 14, 81, 65, 0, 49, 53, 1, 0, 5, 58, 6, 9, 6, 79, 71, 14, 92, 91, 64, 79, 99, 78, 72, 73, 84, 88, 9, 2, 71, 78, 0, 13, 11, 6, 12, 29, 22, 7, 44, 2, 65, 30, 17, 85, 73, 73, 70, 30, 54, 32, 75, 20, 34, 26, 1, 17, 12, 69, 95, 73, 95, 93, 86, 70, 77, 4, 76, 0, 42, 34, 0, 11, 31, 58, 29, 84, 9, 90, 127, 78, 67, 72, 69, 20, 5, 0, 18, 23, 79, 30, 74, 76, 72, 85, 7, 13, 60, 7, 28, 26, 74, 9, 5, 39, 11, 0, 28, 4, 28, 14, 3, 22, 75, 12, 8, 64, 24, 16, 7, 17, 13, 45, 7, 6, 6, 74, 64, 65, 29, 15, 15, 14, 54, 27, 19, 10, 95, 67, 26, 50, 109, 3, 7, 27, 17, 27, 60, 9, 13, 29, 91, 31, 72, 78, 100, 67, 72, 69, 82, 31, 10, 16, 80, 79, 0, 93, 8, 19, 85, 73, 73, 26, 13, 17, 0, 91, 30, 4, 93, 27, 60, 59, 33, 52, 36, 14, 0, 8, 67, 77, 88, 51, 33, 16, 12, 42, 1, 7, 27, 16, 7, 66, 19, 18, 12, 88, 98, 69, 82, 73, 79, 21, 15, 0, 12, 90, 76, 17, 28, 7, 29, 85, 98, 73, 84, 14, 76, 26, 127, 78, 67, 72, 69, 82, 73, 79, 83, 
    5, 3, 2, 79, 24, 85, 7, 84, 84, 78, 5, 26, 16, 72, 66, 19, 89, 78, 4, 72, 88, 82, 4, 28, 23, 5, 65, 10, 2, 76, 23, 85, 73, 73, 3, 27, 13, 18, 0, 14, 90, 127, 78, 67, 72, 69, 82, 73, 79, 83, 5, 3, 2, 79, 24, 85, 24, 29, 7, 60, 47, 73, 73, 14, 1, 8, 27, 70, 17, 68, 69, 21, 64, 84, 121, 67, 79, 77, 14, 76, 85, 85, 84, 15, 2, 7, 8, 0, 14, 1, 0, 13, 60, 36, 72, 88, 82, 4, 14, 11, 75, 29, 65, 14, 11, 92, 78, 126, 73, 78, 72, 73, 84, 14, 76, 65, 17, 7, 16, 28, 69, 79, 73, 2, 18, 27, 71, 0, 71, 2, 39, 50, 88, 73, 3, 1, 7, 92, 67, 13, 25, 39, 41, 79, 72, 7, 91, 64, 79, 89, 67, 93, 67, 30, 76, 88, 85, 69, 71, 94, 83, 99, 84, 14, 76, 65, 8, 100, 67, 72, 69, 82, 15, 3, 28, 2, 27, 77, 79, 13, 85, 72, 84, 4, 15, 16, 65, 18, 89, 5, 5, 1, 6, 75, 12, 12, 1, 29, 70, 95, 67, 94, 67, 30, 76, 90, 85, 1, 54, 56, 1, 12, 3, 125, 5, 27, 16, 64, 26, 65, 94, 120, 73, 79, 83, 67, 9, 1, 65, 13, 1, 85, 21, 5, 30, 0, 8, 84, 19, 76, 18, 24, 1, 12, 28, 13, 1, 29, 10, 3, 75, 66, 12, 79, 64, 85, 20, 21, 69, 78, 12, 0, 7, 90, 69, 90, 127, 78, 67, 72, 69, 4, 12, 12, 71, 67, 9, 4, 64, 13, 25, 54, 27, 5, 1, 26, 82, 126, 14, 76, 65, 85, 7, 5, 72, 77, 95, 26, 11, 83, 93, 82, 77, 91, 51, 39, 16, 18, 27, 15, 11, 29, 29, 65, 2, 41, 16, 7, 4, 0, 17, 91, 73, 20, 121, 67, 79, 77, 14, 76, 85, 85, 84, 15, 7, 6, 8, 24, 109, 3, 13, 26, 28, 67, 85, 69, 6, 12, 23, 7, 22, 29, 8, 6, 25, 42, 33, 17, 17, 26, 29, 27, 17, 2, 76, 7, 28, 0, 2, 4, 49, 23, 17, 27, 6, 17, 10, 46, 65, 3, 7, 17, 93, 82, 100, 72, 73, 84, 14, 17, 65, 16, 2, 16, 13, 69, 9, 99, 79, 83, 67, 79, 77, 14, 76, 85, 19, 24, 6, 15, 28, 73, 25, 79, 20, 38, 7, 15, 7, 58, 4, 22, 0, 26, 0, 67, 82, 77, 67, 13, 13, 93, 25, 0, 0, 64, 1, 21, 66, 10, 50, 28, 20, 6, 70, 29, 94, 73, 7, 18, 15, 9, 62, 71, 22, 16, 91, 13, 64, 66, 72, 28, 43, 109, 3, 19, 27, 11, 17, 58, 4, 22, 0, 26, 0, 74, 84, 103, 14, 76, 85, 85, 84, 73, 78, 72, 15, 24, 65, 13, 21, 85, 9, 17, 9, 1, 32, 8, 11, 26, 22, 28, 77, 19, 76, 24, 28, 26, 65, 27, 55, 42, 27, 92, 2, 4, 7, 60, 2, 12, 12, 7, 26, 79, 89, 67, 94, 67, 27, 64, 85, 24, 21, 17, 41, 26, 8, 16, 124, 13, 5, 28, 27, 16, 65, 94, 120, 73, 79, 83, 67, 79, 77, 14, 76, 3, 16, 23, 91, 78, 6, 6, 6, 67, 13, 13, 85, 83, 67, 15, 23, 19, 13, 60, 23, 49, 0, 24, 64, 8, 16, 17, 38, 12, 13, 28, 8, 26, 73, 0, 4, 93, 13, 6, 6, 17, 23, 27, 10, 23, 32, 0, 2, 92, 8, 89, 85, 28, 8, 2, 14, 58, 29, 84, 9, 77, 85, 9, 17, 9, 1, 32, 8, 11, 26, 22, 28, 68, 21, 102, 85, 85, 84, 73, 78, 72, 73, 84, 72, 0, 14, 20, 26, 67, 26, 0, 20, 27, 14, 16, 23, 10, 9, 106, 5, 6, 1, 21, 7, 13, 13, 73, 73, 14, 15, 8, 7, 13, 15, 13, 40, 19, 25, 71, 66, 77, 95, 77, 3, 76, 88, 6, 16, 73, 65, 72, 28, 43, 124, 9, 7, 7, 15, 0, 28, 12, 29, 7, 39, 22, 10, 8, 5, 90, 69, 85, 95, 84, 28, 49, 58, 12, 18, 92, 13, 2, 1, 7, 12, 6, 36, 31, 6, 26, 29, 23, 84, 103, 14, 76, 85, 85, 84, 73, 78, 72, 31, 17, 77, 94, 65, 7, 11, 5, 26, 4, 17, 29, 10, 23, 39, 6, 31, 75, 15, 1, 28, 27, 7, 78, 85, 73, 26, 65, 30, 12, 20, 2, 10, 18, 0, 90, 7, 0, 1, 14, 14, 1, 14, 71, 85, 0, 43, 45, 11, 24, 29, 28, 107, 10, 7, 16, 13, 23, 72, 79, 82, 7, 0, 1, 14, 14, 1, 71, 22, 16, 93, 23, 12, 0, 28, 12, 6, 75, 8, 34, 26, 1, 17, 12, 76, 91, 82, 101, 83, 67, 79, 77, 14, 76, 85, 85, 2, 12, 13, 90, 73, 6, 75, 10, 19, 20, 13, 23, 13, 1, 49, 6, 0, 1, 7, 79, 80, 14, 10, 28, 27, 21, 5, 58, 13, 17, 0, 91, 30, 4, 54, 1, 12, 26, 1, 82, 66, 79, 1, 6, 9, 31, 79, 15, 1, 16, 16, 45, 7, 27, 29, 21, 64, 15, 4, 85, 68, 67, 26, 0, 20, 27, 14, 16, 23, 10, 9, 106, 5, 7, 16, 23, 29, 7, 7, 7, 84, 1, 76, 20, 42, 44, 2, 11, 14, 21, 27, 0, 6, 13, 11, 62, 71, 22, 16, 78, 126, 73, 78, 72, 73, 84, 14, 76, 65, 19, 7, 13, 9, 9, 49, 6, 3, 28, 17, 79, 80, 14, 24, 16, 13, 0, 28, 28, 13, 65, 1, 113, 56, 4, 13, 26, 22, 26, 0, 94, 73, 29, 22, 5, 29, 12, 77, 24, 16, 17, 55, 6, 1, 26, 13, 93, 21, 102, 65, 85, 78, 67, 72, 69, 82, 73, 9, 31, 
    12, 14, 25, 14, 4, 20, 25, 18, 58, 26, 26, 6, 31, 75, 76, 92, 85, 27, 60, 59, 17, 0, 6, 4, 22, 52, 6, 9, 90, 4, 85, 95, 84, 89, 64, 93, 82, 126, 14, 76, 65, 85, 78, 67, 72, 69, 20, 5, 0, 18, 23, 79, 30, 90, 30, 26, 30, 17, 44, 10, 15, 12, 84, 19, 76, 18, 24, 1, 12, 28, 13, 1, 29, 10, 3, 75, 7, 12, 66, 10, 38, 1, 6, 6, 5, 13, 73, 95, 14, 13, 0, 89, 78, 11, 9, 9, 20, 58, 27, 1, 12, 4, 8, 14, 65, 85, 20, 21, 69, 78, 9, 11, 7, 6, 8, 8, 6, 26, 74, 65, 94, 120, 73, 79, 83, 67, 79, 77, 14, 76, 3, 16, 23, 90, 78, 10, 27, 29, 73, 4, 21, 85, 83, 67, 14, 12, 28, 8, 3, 48, 12, 3, 2, 92, 66, 7, 18, 22, 73, 68, 72, 91, 90, 30, 87, 107, 85, 78, 67, 72, 69, 82, 73, 79, 5, 6, 12, 94, 14, 8, 20, 7, 31, 73, 83, 72, 11, 6, 71, 11, 9, 1, 78, 73, 72, 85, 92, 92, 90, 72, 105, 79, 77, 14, 76, 85, 85, 84, 73, 8, 4, 6, 21, 90, 76, 6, 7, 15, 7, 1, 0, 28, 29, 79, 78, 67, 94, 67, 30, 76, 88, 85, 21, 11, 29, 64, 31, 43, 122, 9, 25, 54, 1, 12, 26, 1, 92, 17, 79, 88, 67, 25, 50, 122, 9, 13, 54, 27, 6, 28, 12, 71, 13, 14, 65, 65, 68, 64, 83, 65, 94, 120, 73, 79, 83, 67, 79, 77, 14, 76, 3, 16, 23, 90, 78, 27, 29, 6, 65, 7, 4, 56, 7, 27, 72, 88, 82, 4, 6, 11, 75, 13, 31, 71, 11, 29, 1, 88, 73, 10, 9, 27, 31, 2, 76, 6, 7, 15, 7, 1, 0, 28, 29, 70, 72, 105, 79, 77, 14, 76, 85, 85, 84, 73, 24, 13, 10, 64, 14, 31, 21, 7, 1, 8, 13, 38, 29, 5, 79, 78, 67, 25, 8, 77, 88, 93, 6, 0, 27, 1, 3, 12, 57, 71, 20, 77, 85, 8, 10, 6, 4, 30, 42, 0, 31, 12, 29, 67, 79, 69, 78, 127, 84, 73, 78, 72, 73, 84, 14, 76, 7, 28, 0, 2, 4, 38, 29, 5, 0, 1, 67, 82, 77, 67, 5, 13, 93, 18, 0, 0, 9, 5, 55, 65, 0, 14, 7, 66, 67, 27, 17, 0, 6, 4, 22, 32, 0, 1, 2, 76, 6, 1, 6, 6, 5, 13, 44, 16, 73, 9, 72, 78, 100, 67, 72, 69, 82, 20, 101, 83, 67, 79, 77, 72, 0, 26, 20, 0, 73, 9, 26, 8, 13, 14, 81, 65, 17, 1, 23, 64, 3, 27, 7, 14, 31, 32, 0, 1, 65, 30, 91, 7, 19, 11, 66, 72, 37, 33, 99, 45, 72, 78, 100, 67, 72, 69, 82, 15, 6, 29, 2, 3, 46, 65, 0, 26, 7, 90, 27, 9, 10, 73, 73, 14, 1, 8, 13, 70, 21, 13, 6, 65, 65, 8, 1, 2, 22, 68, 2, 76, 19, 28, 26, 8, 2, 43, 6, 24, 65, 30, 79, 7, 9, 1, 68, 69, 67, 71, 90, 90, 88, 101, 77, 14, 76, 85, 19, 29, 7, 15, 4, 42, 27, 66, 3, 19, 91, 15, 67, 66, 88, 82, 8, 3, 3, 11, 14, 86, 36, 76, 85, 85, 84, 15, 28, 9, 14, 55, 65, 0, 14, 7, 78, 94, 72, 3, 27, 7, 14, 31, 32, 0, 1, 65, 30, 78, 127, 9, 99};

    public static final void A(int i2, int i3, Object[] objArr) {
        qg0.l(objArr, "<this>");
        while (i2 < i3) {
            objArr[i2] = null;
            i2++;
        }
    }

    public static void B(TextView textView, String str) {
        CharSequence text = textView.getText();
        if (str != text) {
            if (str == null && text.length() == 0) {
                return;
            }
            if (!(str instanceof Spanned)) {
                if ((str == null) == (text == null)) {
                    if (str == null) {
                        return;
                    }
                    int length = str.length();
                    if (length == text.length()) {
                        for (int i2 = 0; i2 < length; i2++) {
                            if (str.charAt(i2) == text.charAt(i2)) {
                            }
                        }
                        return;
                    }
                }
            } else if (str.equals(text)) {
                return;
            }
            textView.setText(str);
        }
    }

    public static void C(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static final boolean a(Object[] objArr, int i2, int i3, List list) {
        if (i3 == list.size()) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (qg0.d(objArr[i2 + i4], list.get(i4))) {
                }
            }
            return true;
        }
        return false;
    }

    public static final String b(Object[] objArr, int i2, int i3, q qVar) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2 + i4];
            if (obj == qVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        qg0.k(string, "toString(...)");
        return string;
    }

    public static void f(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    public static void g(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void h(String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void i(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void k(je jeVar) {
        jeVar.j(false, null);
    }

    public static n02 l(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        long j2 = length - 22;
        if (j2 < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j3 = length - 65558;
        long j4 = j3 >= 0 ? j3 : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                n02 n02Var = new n02();
                n02Var.b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                n02Var.a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return n02Var;
            }
            j2--;
        } while (j2 >= j4);
        throw new ZipException("End Of Central Directory signature not found");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (r5.c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList m(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            pb1 r1 = new pb1
            r1.<init>(r0, r8)
            java.lang.Object r2 = defpackage.rb1.c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = defpackage.rb1.b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L4f
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L4f
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            ob1 r5 = (defpackage.ob1) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L4f
            android.content.res.Configuration r6 = r5.b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4c
            if (r8 != 0) goto L3e
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L48
            goto L3e
        L3c:
            r8 = move-exception
            goto L95
        L3e:
            if (r8 == 0) goto L4c
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4c
        L48:
            android.content.res.ColorStateList r3 = r5.a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L51
        L4c:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L4f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L51:
            if (r3 == 0) goto L54
            return r3
        L54:
            java.lang.ThreadLocal r2 = defpackage.rb1.a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L66
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L66:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L75
            r3 = 31
            if (r2 > r3) goto L75
            goto L7f
        L75:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = defpackage.hk.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7e
            goto L7f
        L7e:
        L7f:
            if (r4 == 0) goto L85
            defpackage.rb1.a(r1, r9, r4, r8)
            goto L94
        L85:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L90
            android.content.res.ColorStateList r4 = defpackage.t1.e(r9, r8, r0)
            goto L94
        L90:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9)
        L94:
            return r4
        L95:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hg0.m(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static final int n(Cursor cursor, String str) {
        String string;
        qg0.l(cursor, "c");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
                    String[] columnNames = cursor.getColumnNames();
                    qg0.k(columnNames, "columnNames");
                    String strConcat = ".".concat(str);
                    String str2 = "." + str + '`';
                    int length = columnNames.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < length) {
                        String str3 = columnNames[i3];
                        int i4 = i2 + 1;
                        if (str3.length() >= str.length() + 2) {
                            qg0.l(strConcat, "suffix");
                            if (!str3.endsWith(strConcat)) {
                                if (str3.charAt(0) == '`') {
                                    qg0.l(str2, "suffix");
                                    if (str3.endsWith(str2)) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                            columnIndex = i2;
                            break;
                        }
                        i3++;
                        i2 = i4;
                    }
                    columnIndex = -1;
                } else {
                    columnIndex = -1;
                }
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames2 = cursor.getColumnNames();
            qg0.k(columnNames2, "c.columnNames");
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "");
            int i5 = 0;
            for (String str4 : columnNames2) {
                i5++;
                if (i5 > 1) {
                    sb.append((CharSequence) ", ");
                }
                p02.a(sb, str4, null);
            }
            sb.append((CharSequence) "");
            string = sb.toString();
        } catch (Exception unused) {
            string = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + string);
    }

    public static Drawable o(Context context, int i2) {
        return ResourceManagerInternal.get().getDrawable(context, i2);
    }

    public static Intent p(e6 e6Var) {
        Intent parentActivityIntent = e6Var.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strR = r(e6Var, e6Var.getComponentName());
            if (strR == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(e6Var, strR);
            try {
                return r(e6Var, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Intent q(e6 e6Var, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strR = r(e6Var, componentName);
        if (strR == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strR);
        return r(e6Var, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String r(Activity activity, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        PackageManager packageManager = activity.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2 >= 29 ? 269222528 : i2 >= 24 ? 787072 : 640);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return activity.getPackageName() + string;
    }

    public static synchronized boolean s(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = a;
        if (context2 != null && (bool = b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        b = null;
        if (os.j()) {
            b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                b = Boolean.FALSE;
            }
        }
        a = applicationContext;
        return b.booleanValue();
    }

    public static void t(ua uaVar) {
        Intent intentP = p(uaVar);
        if (intentP != null) {
            uaVar.navigateUpTo(intentP);
            return;
        }
        throw new IllegalArgumentException("Activity " + uaVar.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static ef u(uv uvVar) {
        long j2;
        long j3;
        long j4;
        boolean z;
        long j5;
        long jW;
        long j6;
        long j7;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = (Map) uvVar.g;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jW2 = str != null ? w(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j3 = 0;
            j4 = 0;
            while (i2 < strArrSplit.length) {
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j4 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i2++;
            }
            j2 = 0;
            i2 = 1;
        } else {
            j2 = 0;
            j3 = 0;
            j4 = 0;
            z = false;
        }
        String str3 = (String) map.get("Expires");
        long jW3 = str3 != null ? w(str3) : j2;
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j5 = jCurrentTimeMillis;
            jW = w(str4);
        } else {
            j5 = jCurrentTimeMillis;
            jW = j2;
        }
        String str5 = (String) map.get("ETag");
        if (i2 != 0) {
            long j8 = (j3 * 1000) + j5;
            if (z) {
                j7 = j8;
            } else {
                Long.signum(j4);
                j7 = (j4 * 1000) + j8;
            }
            j6 = j8;
        } else {
            j6 = (jW2 <= j2 || jW3 < jW2) ? j2 : (jW3 - jW2) + j5;
            j7 = j6;
        }
        ef efVar = new ef();
        efVar.a = (byte[]) uvVar.i;
        efVar.b = str5;
        efVar.f = j6;
        efVar.e = j7;
        efVar.c = jW2;
        efVar.d = jW;
        efVar.g = map;
        efVar.h = (List) uvVar.j;
        return efVar;
    }

    public static String v(Map map) {
        String str;
        if (map == null || (str = (String) map.get("Content-Type")) == null) {
            return "utf-8";
        }
        String[] strArrSplit = str.split(";", 0);
        for (int i2 = 1; i2 < strArrSplit.length; i2++) {
            String[] strArrSplit2 = strArrSplit[i2].trim().split("=", 0);
            if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                return strArrSplit2[1];
            }
        }
        return "utf-8";
    }

    public static long w(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException unused) {
            if ("0".equals(str) || "-1".equals(str)) {
                gv1.b("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            gv1.a("Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public abstract boolean c(p pVar, k kVar, k kVar2);

    public abstract boolean d(p pVar, Object obj, Object obj2);

    public abstract boolean e(p pVar, o oVar, o oVar2);

    public abstract void x(String str);

    public abstract void y(o oVar, o oVar2);

    public abstract void z(o oVar, Thread thread);

    @Override // defpackage.cu1
    public void onAnimationCancel(View view) {
    }

    @Override // defpackage.cu1
    public void onAnimationStart(View view) {
    }
}
