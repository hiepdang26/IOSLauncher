package defpackage;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public final class s10 {
    public static final String[] D;
    public static final int[] E;
    public static final byte[] F;
    public static final p10 G;
    public static final p10[][] H;
    public static final p10[] I;
    public static final HashMap[] J;
    public static final HashMap[] K;
    public static final HashSet L;
    public static final HashMap M;
    public static final Charset N;
    public static final byte[] O;
    public static final byte[] P;
    public final FileDescriptor a;
    public final AssetManager.AssetInputStream b;
    public int c;
    public final HashMap[] d;
    public final HashSet e;
    public ByteOrder f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public static final boolean l = Log.isLoggable("ExifInterface", 3);
    public static final List m = Arrays.asList(1, 6, 3, 8);
    public static final List n = Arrays.asList(2, 7, 4, 5);
    public static final int[] o = {8, 8, 8};
    public static final int[] p = {8};
    public static final byte[] q = {-1, -40, -1};
    public static final byte[] r = {102, 116, 121, 112};
    public static final byte[] s = {109, 105, 102, 49};
    public static final byte[] t = {104, 101, 105, 99};
    public static final byte[] u = {79, 76, 89, 77, 80, 0};
    public static final byte[] v = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] w = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final byte[] x = {101, 88, 73, 102};
    public static final byte[] y = {73, 72, 68, 82};
    public static final byte[] z = {73, 69, 78, 68};
    public static final byte[] A = {82, 73, 70, 70};
    public static final byte[] B = {87, 69, 66, 80};
    public static final byte[] C = {69, 88, 73, 70};

    static {
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        D = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        E = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        F = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        p10[] p10VarArr = {new p10("NewSubfileType", 254, 4), new p10("SubfileType", 255, 4), new p10(MotionScene.Transition.TransitionOnClick.JUMP_TO_END, 3, "ImageWidth", 4), new p10(257, 3, "ImageLength", 4), new p10("BitsPerSample", 258, 3), new p10("Compression", 259, 3), new p10("PhotometricInterpretation", 262, 3), new p10("ImageDescription", 270, 2), new p10("Make", 271, 2), new p10("Model", 272, 2), new p10(273, 3, "StripOffsets", 4), new p10("Orientation", 274, 3), new p10("SamplesPerPixel", 277, 3), new p10(278, 3, "RowsPerStrip", 4), new p10(279, 3, "StripByteCounts", 4), new p10("XResolution", 282, 5), new p10("YResolution", 283, 5), new p10("PlanarConfiguration", 284, 3), new p10("ResolutionUnit", 296, 3), new p10("TransferFunction", 301, 3), new p10("Software", 305, 2), new p10("DateTime", 306, 2), new p10("Artist", 315, 2), new p10("WhitePoint", 318, 5), new p10("PrimaryChromaticities", 319, 5), new p10("SubIFDPointer", 330, 4), new p10("JPEGInterchangeFormat", 513, 4), new p10("JPEGInterchangeFormatLength", 514, 4), new p10("YCbCrCoefficients", 529, 5), new p10("YCbCrSubSampling", 530, 3), new p10("YCbCrPositioning", 531, 3), new p10("ReferenceBlackWhite", 532, 5), new p10("Copyright", 33432, 2), new p10("ExifIFDPointer", 34665, 4), new p10("GPSInfoIFDPointer", 34853, 4), new p10("SensorTopBorder", 4, 4), new p10("SensorLeftBorder", 5, 4), new p10("SensorBottomBorder", 6, 4), new p10("SensorRightBorder", 7, 4), new p10("ISO", 23, 3), new p10("JpgFromRaw", 46, 7), new p10("Xmp", 700, 1)};
        p10[] p10VarArr2 = {new p10("ExposureTime", 33434, 5), new p10("FNumber", 33437, 5), new p10("ExposureProgram", 34850, 3), new p10("SpectralSensitivity", 34852, 2), new p10("PhotographicSensitivity", 34855, 3), new p10("OECF", 34856, 7), new p10("SensitivityType", 34864, 3), new p10("StandardOutputSensitivity", 34865, 4), new p10("RecommendedExposureIndex", 34866, 4), new p10("ISOSpeed", 34867, 4), new p10("ISOSpeedLatitudeyyy", 34868, 4), new p10("ISOSpeedLatitudezzz", 34869, 4), new p10("ExifVersion", 36864, 2), new p10("DateTimeOriginal", 36867, 2), new p10("DateTimeDigitized", 36868, 2), new p10("OffsetTime", 36880, 2), new p10("OffsetTimeOriginal", 36881, 2), new p10("OffsetTimeDigitized", 36882, 2), new p10("ComponentsConfiguration", 37121, 7), new p10("CompressedBitsPerPixel", 37122, 5), new p10("ShutterSpeedValue", 37377, 10), new p10("ApertureValue", 37378, 5), new p10("BrightnessValue", 37379, 10), new p10("ExposureBiasValue", 37380, 10), new p10("MaxApertureValue", 37381, 5), new p10("SubjectDistance", 37382, 5), new p10("MeteringMode", 37383, 3), new p10("LightSource", 37384, 3), new p10("Flash", 37385, 3), new p10("FocalLength", 37386, 5), new p10("SubjectArea", 37396, 3), new p10("MakerNote", 37500, 7), new p10("UserComment", 37510, 7), new p10("SubSecTime", 37520, 2), new p10("SubSecTimeOriginal", 37521, 2), new p10("SubSecTimeDigitized", 37522, 2), new p10("FlashpixVersion", 40960, 7), new p10("ColorSpace", 40961, 3), new p10(40962, 3, "PixelXDimension", 4), new p10(40963, 3, "PixelYDimension", 4), new p10("RelatedSoundFile", 40964, 2), new p10("InteroperabilityIFDPointer", 40965, 4), new p10("FlashEnergy", 41483, 5), new p10("SpatialFrequencyResponse", 41484, 7), new p10("FocalPlaneXResolution", 41486, 5), new p10("FocalPlaneYResolution", 41487, 5), new p10("FocalPlaneResolutionUnit", 41488, 3), new p10("SubjectLocation", 41492, 3), new p10("ExposureIndex", 41493, 5), new p10("SensingMethod", 41495, 3), new p10("FileSource", 41728, 7), new p10("SceneType", 41729, 7), new p10("CFAPattern", 41730, 7), new p10("CustomRendered", 41985, 3), new p10("ExposureMode", 41986, 3), new p10("WhiteBalance", 41987, 3), new p10("DigitalZoomRatio", 41988, 5), new p10("FocalLengthIn35mmFilm", 41989, 3), new p10("SceneCaptureType", 41990, 3), new p10("GainControl", 41991, 3), new p10("Contrast", 41992, 3), new p10("Saturation", 41993, 3), new p10("Sharpness", 41994, 3), new p10("DeviceSettingDescription", 41995, 7), new p10("SubjectDistanceRange", 41996, 3), new p10("ImageUniqueID", 42016, 2), new p10("CameraOwnerName", 42032, 2), new p10("BodySerialNumber", 42033, 2), new p10("LensSpecification", 42034, 5), new p10("LensMake", 42035, 2), new p10("LensModel", 42036, 2), new p10("Gamma", 42240, 5), new p10("DNGVersion", 50706, 1), new p10(50720, 3, "DefaultCropSize", 4)};
        p10[] p10VarArr3 = {new p10("GPSVersionID", 0, 1), new p10("GPSLatitudeRef", 1, 2), new p10(2, 5, "GPSLatitude", 10), new p10("GPSLongitudeRef", 3, 2), new p10(4, 5, "GPSLongitude", 10), new p10("GPSAltitudeRef", 5, 1), new p10("GPSAltitude", 6, 5), new p10("GPSTimeStamp", 7, 5), new p10("GPSSatellites", 8, 2), new p10("GPSStatus", 9, 2), new p10("GPSMeasureMode", 10, 2), new p10("GPSDOP", 11, 5), new p10("GPSSpeedRef", 12, 2), new p10("GPSSpeed", 13, 5), new p10("GPSTrackRef", 14, 2), new p10("GPSTrack", 15, 5), new p10("GPSImgDirectionRef", 16, 2), new p10("GPSImgDirection", 17, 5), new p10("GPSMapDatum", 18, 2), new p10("GPSDestLatitudeRef", 19, 2), new p10("GPSDestLatitude", 20, 5), new p10("GPSDestLongitudeRef", 21, 2), new p10("GPSDestLongitude", 22, 5), new p10("GPSDestBearingRef", 23, 2), new p10("GPSDestBearing", 24, 5), new p10("GPSDestDistanceRef", 25, 2), new p10("GPSDestDistance", 26, 5), new p10("GPSProcessingMethod", 27, 7), new p10("GPSAreaInformation", 28, 7), new p10("GPSDateStamp", 29, 2), new p10("GPSDifferential", 30, 3), new p10("GPSHPositioningError", 31, 5)};
        p10[] p10VarArr4 = {new p10("InteroperabilityIndex", 1, 2)};
        p10[] p10VarArr5 = {new p10("NewSubfileType", 254, 4), new p10("SubfileType", 255, 4), new p10(MotionScene.Transition.TransitionOnClick.JUMP_TO_END, 3, "ThumbnailImageWidth", 4), new p10(257, 3, "ThumbnailImageLength", 4), new p10("BitsPerSample", 258, 3), new p10("Compression", 259, 3), new p10("PhotometricInterpretation", 262, 3), new p10("ImageDescription", 270, 2), new p10("Make", 271, 2), new p10("Model", 272, 2), new p10(273, 3, "StripOffsets", 4), new p10("ThumbnailOrientation", 274, 3), new p10("SamplesPerPixel", 277, 3), new p10(278, 3, "RowsPerStrip", 4), new p10(279, 3, "StripByteCounts", 4), new p10("XResolution", 282, 5), new p10("YResolution", 283, 5), new p10("PlanarConfiguration", 284, 3), new p10("ResolutionUnit", 296, 3), new p10("TransferFunction", 301, 3), new p10("Software", 305, 2), new p10("DateTime", 306, 2), new p10("Artist", 315, 2), new p10("WhitePoint", 318, 5), new p10("PrimaryChromaticities", 319, 5), new p10("SubIFDPointer", 330, 4), new p10("JPEGInterchangeFormat", 513, 4), new p10("JPEGInterchangeFormatLength", 514, 4), new p10("YCbCrCoefficients", 529, 5), new p10("YCbCrSubSampling", 530, 3), new p10("YCbCrPositioning", 531, 3), new p10("ReferenceBlackWhite", 532, 5), new p10("Copyright", 33432, 2), new p10("ExifIFDPointer", 34665, 4), new p10("GPSInfoIFDPointer", 34853, 4), new p10("DNGVersion", 50706, 1), new p10(50720, 3, "DefaultCropSize", 4)};
        G = new p10("StripOffsets", 273, 3);
        H = new p10[][]{p10VarArr, p10VarArr2, p10VarArr3, p10VarArr4, p10VarArr5, p10VarArr, new p10[]{new p10("ThumbnailImage", MotionScene.Transition.TransitionOnClick.JUMP_TO_END, 7), new p10("CameraSettingsIFDPointer", 8224, 4), new p10("ImageProcessingIFDPointer", 8256, 4)}, new p10[]{new p10("PreviewImageStart", 257, 4), new p10("PreviewImageLength", 258, 4)}, new p10[]{new p10("AspectFrame", 4371, 3)}, new p10[]{new p10("ColorSpace", 55, 3)}};
        I = new p10[]{new p10("SubIFDPointer", 330, 4), new p10("ExifIFDPointer", 34665, 4), new p10("GPSInfoIFDPointer", 34853, 4), new p10("InteroperabilityIFDPointer", 40965, 4), new p10("CameraSettingsIFDPointer", 8224, 1), new p10("ImageProcessingIFDPointer", 8256, 1)};
        J = new HashMap[10];
        K = new HashMap[10];
        L = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        M = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        N = charsetForName;
        O = "Exif\u0000\u0000".getBytes(charsetForName);
        P = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            p10[][] p10VarArr6 = H;
            if (i >= p10VarArr6.length) {
                HashMap map = M;
                p10[] p10VarArr7 = I;
                map.put(Integer.valueOf(p10VarArr7[0].a), 5);
                map.put(Integer.valueOf(p10VarArr7[1].a), 1);
                map.put(Integer.valueOf(p10VarArr7[2].a), 2);
                map.put(Integer.valueOf(p10VarArr7[3].a), 3);
                map.put(Integer.valueOf(p10VarArr7[4].a), 7);
                map.put(Integer.valueOf(p10VarArr7[5].a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            J[i] = new HashMap();
            K[i] = new HashMap();
            for (p10 p10Var : p10VarArr6[i]) {
                J[i].put(Integer.valueOf(p10Var.a), p10Var);
                K[i].put(p10Var.b, p10Var);
            }
            i++;
        }
    }

    public s10(InputStream inputStream) throws Throwable {
        p10[][] p10VarArr = H;
        this.d = new HashMap[p10VarArr.length];
        this.e = new HashSet(p10VarArr.length);
        this.f = ByteOrder.BIG_ENDIAN;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.b = (AssetManager.AssetInputStream) inputStream;
            this.a = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            try {
                u10.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                this.b = null;
                this.a = fileInputStream.getFD();
            } catch (Exception unused) {
                this.b = null;
                this.a = null;
            }
        } else {
            this.b = null;
            this.a = null;
        }
        boolean z2 = l;
        for (int i = 0; i < p10VarArr.length; i++) {
            try {
                this.d[i] = new HashMap();
            } catch (IOException | UnsupportedOperationException unused2) {
                a();
                if (!z2) {
                    return;
                }
            } catch (Throwable th) {
                a();
                if (z2) {
                    p();
                }
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        int iF = f(bufferedInputStream);
        this.c = iF;
        if (iF == 4 || iF == 9 || iF == 13 || iF == 14) {
            n10 n10Var = new n10(bufferedInputStream);
            int i2 = this.c;
            if (i2 == 4) {
                e(n10Var, 0, 0);
            } else if (i2 == 13) {
                h(n10Var);
            } else if (i2 == 9) {
                i(n10Var);
            } else if (i2 == 14) {
                l(n10Var);
            }
        } else {
            r10 r10Var = new r10(bufferedInputStream);
            int i3 = this.c;
            if (i3 == 12) {
                d(r10Var);
            } else if (i3 == 7) {
                g(r10Var);
            } else if (i3 == 10) {
                k(r10Var);
            } else {
                j(r10Var);
            }
            r10Var.b(this.h);
            u(r10Var);
        }
        a();
        if (!z2) {
            return;
        }
        p();
    }

    public static ByteOrder q(n10 n10Var) throws IOException {
        short s2 = n10Var.readShort();
        if (s2 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        HashMap[] mapArr = this.d;
        if (strB != null && b("DateTime") == null) {
            HashMap map = mapArr[0];
            byte[] bytes = strB.concat("\u0000").getBytes(N);
            map.put("DateTime", new o10(2, bytes, bytes.length));
        }
        if (b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", o10.a(0L, this.f));
        }
        if (b("ImageLength") == null) {
            mapArr[0].put("ImageLength", o10.a(0L, this.f));
        }
        if (b("Orientation") == null) {
            mapArr[0].put("Orientation", o10.a(0L, this.f));
        }
        if (b("LightSource") == null) {
            mapArr[1].put("LightSource", o10.a(0L, this.f));
        }
    }

    public final String b(String str) {
        o10 o10VarC = c(str);
        if (o10VarC != null) {
            if (!L.contains(str)) {
                return o10VarC.f(this.f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = o10VarC.a;
                if (i == 5 || i == 10) {
                    q10[] q10VarArr = (q10[]) o10VarC.g(this.f);
                    if (q10VarArr == null || q10VarArr.length != 3) {
                        Arrays.toString(q10VarArr);
                        return null;
                    }
                    q10 q10Var = q10VarArr[0];
                    Integer numValueOf = Integer.valueOf((int) (q10Var.a / q10Var.b));
                    q10 q10Var2 = q10VarArr[1];
                    Integer numValueOf2 = Integer.valueOf((int) (q10Var2.a / q10Var2.b));
                    q10 q10Var3 = q10VarArr[2];
                    return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (q10Var3.a / q10Var3.b)));
                }
            } else {
                try {
                    return Double.toString(o10VarC.d(this.f));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return null;
    }

    public final o10 c(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < H.length; i++) {
            o10 o10Var = (o10) this.d[i].get(str);
            if (o10Var != null) {
                return o10Var;
            }
        }
        return null;
    }

    public final void d(r10 r10Var) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                v10.a(mediaMetadataRetriever, new m10(r10Var));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.d;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", o10.c(Integer.parseInt(strExtractMetadata), this.f));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", o10.c(Integer.parseInt(strExtractMetadata2), this.f));
                }
                if (strExtractMetadata3 != null) {
                    int i = Integer.parseInt(strExtractMetadata3);
                    mapArr[0].put("Orientation", o10.c(i != 90 ? i != 180 ? i != 270 ? 1 : 8 : 3 : 6, this.f));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i2 = Integer.parseInt(strExtractMetadata4);
                    int i3 = Integer.parseInt(strExtractMetadata5);
                    if (i3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    r10Var.b(i2);
                    byte[] bArr = new byte[6];
                    r10Var.readFully(bArr);
                    int i4 = i2 + 6;
                    int i5 = i3 - 6;
                    if (!Arrays.equals(bArr, O)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i5];
                    r10Var.readFully(bArr2);
                    this.h = i4;
                    r(0, bArr2);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x005d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0060. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0063. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0141 A[LOOP:0: B:10:0x0024->B:78:0x0141, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00fd A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(defpackage.n10 r23, int r24, int r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s10.e(n10, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.io.BufferedInputStream r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s10.f(java.io.BufferedInputStream):int");
    }

    public final void g(r10 r10Var) throws Throwable {
        int i;
        int i2;
        j(r10Var);
        HashMap[] mapArr = this.d;
        o10 o10Var = (o10) mapArr[1].get("MakerNote");
        if (o10Var != null) {
            r10 r10Var2 = new r10(o10Var.d);
            r10Var2.i = this.f;
            byte[] bArr = u;
            byte[] bArr2 = new byte[bArr.length];
            r10Var2.readFully(bArr2);
            r10Var2.b(0L);
            byte[] bArr3 = v;
            byte[] bArr4 = new byte[bArr3.length];
            r10Var2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                r10Var2.b(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                r10Var2.b(12L);
            }
            s(r10Var2, 6);
            o10 o10Var2 = (o10) mapArr[7].get("PreviewImageStart");
            o10 o10Var3 = (o10) mapArr[7].get("PreviewImageLength");
            if (o10Var2 != null && o10Var3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", o10Var2);
                mapArr[5].put("JPEGInterchangeFormatLength", o10Var3);
            }
            o10 o10Var4 = (o10) mapArr[8].get("AspectFrame");
            if (o10Var4 != null) {
                int[] iArr = (int[]) o10Var4.g(this.f);
                if (iArr == null || iArr.length != 4) {
                    Arrays.toString(iArr);
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                o10 o10VarC = o10.c(i5, this.f);
                o10 o10VarC2 = o10.c(i6, this.f);
                mapArr[0].put("ImageWidth", o10VarC);
                mapArr[0].put("ImageLength", o10VarC2);
            }
        }
    }

    public final void h(n10 n10Var) throws Throwable {
        if (l) {
            Objects.toString(n10Var);
        }
        n10Var.i = ByteOrder.BIG_ENDIAN;
        byte[] bArr = w;
        n10Var.a(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = n10Var.readInt();
                byte[] bArr2 = new byte[4];
                n10Var.readFully(bArr2);
                int i2 = length + 8;
                if (i2 == 16 && !Arrays.equals(bArr2, y)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, z)) {
                    return;
                }
                if (Arrays.equals(bArr2, x)) {
                    byte[] bArr3 = new byte[i];
                    n10Var.readFully(bArr3);
                    int i3 = n10Var.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i3) {
                        this.h = i2;
                        r(0, bArr3);
                        x();
                        u(new n10(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                }
                int i4 = i + 4;
                n10Var.a(i4);
                length = i2 + i4;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void i(n10 n10Var) throws Throwable {
        if (l) {
            Objects.toString(n10Var);
        }
        n10Var.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        n10Var.readFully(bArr);
        n10Var.readFully(bArr2);
        n10Var.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        n10Var.a(i - n10Var.h);
        n10Var.readFully(bArr4);
        e(new n10(bArr4), i, 5);
        n10Var.a(i3 - n10Var.h);
        n10Var.i = ByteOrder.BIG_ENDIAN;
        int i4 = n10Var.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = n10Var.readUnsignedShort();
            int unsignedShort2 = n10Var.readUnsignedShort();
            if (unsignedShort == G.a) {
                short s2 = n10Var.readShort();
                short s3 = n10Var.readShort();
                o10 o10VarC = o10.c(s2, this.f);
                o10 o10VarC2 = o10.c(s3, this.f);
                HashMap[] mapArr = this.d;
                mapArr[0].put("ImageLength", o10VarC);
                mapArr[0].put("ImageWidth", o10VarC2);
                return;
            }
            n10Var.a(unsignedShort2);
        }
    }

    public final void j(r10 r10Var) throws Throwable {
        o(r10Var);
        s(r10Var, 0);
        w(r10Var, 0);
        w(r10Var, 5);
        w(r10Var, 4);
        x();
        if (this.c == 8) {
            HashMap[] mapArr = this.d;
            o10 o10Var = (o10) mapArr[1].get("MakerNote");
            if (o10Var != null) {
                r10 r10Var2 = new r10(o10Var.d);
                r10Var2.i = this.f;
                r10Var2.a(6);
                s(r10Var2, 9);
                o10 o10Var2 = (o10) mapArr[9].get("ColorSpace");
                if (o10Var2 != null) {
                    mapArr[1].put("ColorSpace", o10Var2);
                }
            }
        }
    }

    public final void k(r10 r10Var) throws Throwable {
        if (l) {
            Objects.toString(r10Var);
        }
        j(r10Var);
        HashMap[] mapArr = this.d;
        o10 o10Var = (o10) mapArr[0].get("JpgFromRaw");
        if (o10Var != null) {
            e(new n10(o10Var.d), (int) o10Var.c, 5);
        }
        o10 o10Var2 = (o10) mapArr[0].get("ISO");
        o10 o10Var3 = (o10) mapArr[1].get("PhotographicSensitivity");
        if (o10Var2 == null || o10Var3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", o10Var2);
    }

    public final void l(n10 n10Var) throws Throwable {
        if (l) {
            Objects.toString(n10Var);
        }
        n10Var.i = ByteOrder.LITTLE_ENDIAN;
        n10Var.a(A.length);
        int i = n10Var.readInt() + 8;
        byte[] bArr = B;
        n10Var.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                n10Var.readFully(bArr2);
                int i2 = n10Var.readInt();
                int i3 = length + 8;
                if (Arrays.equals(C, bArr2)) {
                    byte[] bArr3 = new byte[i2];
                    n10Var.readFully(bArr3);
                    this.h = i3;
                    r(0, bArr3);
                    u(new n10(bArr3));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                n10Var.a(i2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void m(n10 n10Var, HashMap map) throws Throwable {
        o10 o10Var = (o10) map.get("JPEGInterchangeFormat");
        o10 o10Var2 = (o10) map.get("JPEGInterchangeFormatLength");
        if (o10Var == null || o10Var2 == null) {
            return;
        }
        int iE = o10Var.e(this.f);
        int iE2 = o10Var2.e(this.f);
        if (this.c == 7) {
            iE += this.i;
        }
        if (iE <= 0 || iE2 <= 0 || this.b != null || this.a != null) {
            return;
        }
        n10Var.a(iE);
        n10Var.readFully(new byte[iE2]);
    }

    public final boolean n(HashMap map) {
        o10 o10Var = (o10) map.get("ImageLength");
        o10 o10Var2 = (o10) map.get("ImageWidth");
        if (o10Var == null || o10Var2 == null) {
            return false;
        }
        return o10Var.e(this.f) <= 512 && o10Var2.e(this.f) <= 512;
    }

    public final void o(r10 r10Var) throws IOException {
        ByteOrder byteOrderQ = q(r10Var);
        this.f = byteOrderQ;
        r10Var.i = byteOrderQ;
        int unsignedShort = r10Var.readUnsignedShort();
        int i = this.c;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i2 = r10Var.readInt();
        if (i2 < 8) {
            throw new IOException(k31.k(i2, "Invalid first Ifd offset: "));
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            r10Var.a(i3);
        }
    }

    public final void p() throws Throwable {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.d;
            if (i >= mapArr.length) {
                return;
            }
            mapArr[i].size();
            for (Map.Entry entry : mapArr[i].entrySet()) {
                o10 o10Var = (o10) entry.getValue();
                o10Var.toString();
                o10Var.f(this.f);
            }
            i++;
        }
    }

    public final void r(int i, byte[] bArr) throws IOException {
        r10 r10Var = new r10(bArr);
        o(r10Var);
        s(r10Var, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(defpackage.r10 r33, int r34) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s10.s(r10, int):void");
    }

    public final void t(int i, String str, String str2) {
        HashMap[] mapArr = this.d;
        if (mapArr[i].isEmpty() || mapArr[i].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i];
        map.put(str2, map.get(str));
        mapArr[i].remove(str);
    }

    public final void u(n10 n10Var) throws Throwable {
        o10 o10Var;
        HashMap map = this.d[4];
        o10 o10Var2 = (o10) map.get("Compression");
        if (o10Var2 == null) {
            m(n10Var, map);
            return;
        }
        int iE = o10Var2.e(this.f);
        if (iE != 1) {
            if (iE == 6) {
                m(n10Var, map);
                return;
            } else if (iE != 7) {
                return;
            }
        }
        o10 o10Var3 = (o10) map.get("BitsPerSample");
        if (o10Var3 != null) {
            int[] iArr = (int[]) o10Var3.g(this.f);
            int[] iArr2 = o;
            if (!Arrays.equals(iArr2, iArr)) {
                if (this.c != 3 || (o10Var = (o10) map.get("PhotometricInterpretation")) == null) {
                    return;
                }
                int iE2 = o10Var.e(this.f);
                if ((iE2 != 1 || !Arrays.equals(iArr, p)) && (iE2 != 6 || !Arrays.equals(iArr, iArr2))) {
                    return;
                }
            }
            o10 o10Var4 = (o10) map.get("StripOffsets");
            o10 o10Var5 = (o10) map.get("StripByteCounts");
            if (o10Var4 == null || o10Var5 == null) {
                return;
            }
            long[] jArrI = hs0.i(o10Var4.g(this.f));
            long[] jArrI2 = hs0.i(o10Var5.g(this.f));
            if (jArrI == null || jArrI.length == 0 || jArrI2 == null || jArrI2.length == 0 || jArrI.length != jArrI2.length) {
                return;
            }
            long j = 0;
            for (long j2 : jArrI2) {
                j += j2;
            }
            byte[] bArr = new byte[(int) j];
            this.g = true;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < jArrI.length; i3++) {
                int i4 = (int) jArrI[i3];
                int i5 = (int) jArrI2[i3];
                if (i3 < jArrI.length - 1 && i4 + i5 != jArrI[i3 + 1]) {
                    this.g = false;
                }
                int i6 = i4 - i;
                if (i6 < 0) {
                    return;
                }
                try {
                    n10Var.a(i6);
                    int i7 = i + i6;
                    byte[] bArr2 = new byte[i5];
                    n10Var.readFully(bArr2);
                    i = i7 + i5;
                    System.arraycopy(bArr2, 0, bArr, i2, i5);
                    i2 += i5;
                } catch (EOFException unused) {
                    return;
                }
            }
            if (this.g) {
                long j3 = jArrI[0];
            }
        }
    }

    public final void v(int i, int i2) throws Throwable {
        HashMap[] mapArr = this.d;
        if (mapArr[i].isEmpty() || mapArr[i2].isEmpty()) {
            return;
        }
        o10 o10Var = (o10) mapArr[i].get("ImageLength");
        o10 o10Var2 = (o10) mapArr[i].get("ImageWidth");
        o10 o10Var3 = (o10) mapArr[i2].get("ImageLength");
        o10 o10Var4 = (o10) mapArr[i2].get("ImageWidth");
        if (o10Var == null || o10Var2 == null || o10Var3 == null || o10Var4 == null) {
            return;
        }
        int iE = o10Var.e(this.f);
        int iE2 = o10Var2.e(this.f);
        int iE3 = o10Var3.e(this.f);
        int iE4 = o10Var4.e(this.f);
        if (iE >= iE3 || iE2 >= iE4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public final void w(r10 r10Var, int i) throws Throwable {
        o10 o10VarC;
        o10 o10VarC2;
        HashMap[] mapArr = this.d;
        o10 o10Var = (o10) mapArr[i].get("DefaultCropSize");
        o10 o10Var2 = (o10) mapArr[i].get("SensorTopBorder");
        o10 o10Var3 = (o10) mapArr[i].get("SensorLeftBorder");
        o10 o10Var4 = (o10) mapArr[i].get("SensorBottomBorder");
        o10 o10Var5 = (o10) mapArr[i].get("SensorRightBorder");
        if (o10Var != null) {
            if (o10Var.a == 5) {
                q10[] q10VarArr = (q10[]) o10Var.g(this.f);
                if (q10VarArr == null || q10VarArr.length != 2) {
                    Arrays.toString(q10VarArr);
                    return;
                } else {
                    o10VarC = o10.b(q10VarArr[0], this.f);
                    o10VarC2 = o10.b(q10VarArr[1], this.f);
                }
            } else {
                int[] iArr = (int[]) o10Var.g(this.f);
                if (iArr == null || iArr.length != 2) {
                    Arrays.toString(iArr);
                    return;
                } else {
                    o10VarC = o10.c(iArr[0], this.f);
                    o10VarC2 = o10.c(iArr[1], this.f);
                }
            }
            mapArr[i].put("ImageWidth", o10VarC);
            mapArr[i].put("ImageLength", o10VarC2);
            return;
        }
        if (o10Var2 != null && o10Var3 != null && o10Var4 != null && o10Var5 != null) {
            int iE = o10Var2.e(this.f);
            int iE2 = o10Var4.e(this.f);
            int iE3 = o10Var5.e(this.f);
            int iE4 = o10Var3.e(this.f);
            if (iE2 <= iE || iE3 <= iE4) {
                return;
            }
            o10 o10VarC3 = o10.c(iE2 - iE, this.f);
            o10 o10VarC4 = o10.c(iE3 - iE4, this.f);
            mapArr[i].put("ImageLength", o10VarC3);
            mapArr[i].put("ImageWidth", o10VarC4);
            return;
        }
        o10 o10Var6 = (o10) mapArr[i].get("ImageLength");
        o10 o10Var7 = (o10) mapArr[i].get("ImageWidth");
        if (o10Var6 == null || o10Var7 == null) {
            o10 o10Var8 = (o10) mapArr[i].get("JPEGInterchangeFormat");
            o10 o10Var9 = (o10) mapArr[i].get("JPEGInterchangeFormatLength");
            if (o10Var8 == null || o10Var9 == null) {
                return;
            }
            int iE5 = o10Var8.e(this.f);
            int iE6 = o10Var8.e(this.f);
            r10Var.b(iE5);
            byte[] bArr = new byte[iE6];
            r10Var.readFully(bArr);
            e(new n10(bArr), iE5, i);
        }
    }

    public final void x() throws Throwable {
        v(0, 5);
        v(0, 4);
        v(5, 4);
        HashMap[] mapArr = this.d;
        o10 o10Var = (o10) mapArr[1].get("PixelXDimension");
        o10 o10Var2 = (o10) mapArr[1].get("PixelYDimension");
        if (o10Var != null && o10Var2 != null) {
            mapArr[0].put("ImageWidth", o10Var);
            mapArr[0].put("ImageLength", o10Var2);
        }
        if (mapArr[4].isEmpty() && n(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        n(mapArr[4]);
        t(0, "ThumbnailOrientation", "Orientation");
        t(0, "ThumbnailImageLength", "ImageLength");
        t(0, "ThumbnailImageWidth", "ImageWidth");
        t(5, "ThumbnailOrientation", "Orientation");
        t(5, "ThumbnailImageLength", "ImageLength");
        t(5, "ThumbnailImageWidth", "ImageWidth");
        t(4, "Orientation", "ThumbnailOrientation");
        t(4, "ImageLength", "ThumbnailImageLength");
        t(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
