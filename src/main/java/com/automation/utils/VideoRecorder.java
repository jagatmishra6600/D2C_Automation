package com.automation.utils;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorder {

    private static final ThreadLocal<ScreenRecorder> screenRecorder = new ThreadLocal<>();
    private static final ThreadLocal<String> videoPath = new ThreadLocal<>();

    public static void startRecording(String testName) throws Exception {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS").format(new Date());
        String fileName = "videos/" + testName + "_" + timestamp + ".mov";
        String fullPath = System.getProperty("user.dir") + File.separator + fileName.replace("/", File.separator);

        File file = new File(fullPath);
        file.getParentFile().mkdirs();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();

        ScreenRecorder recorder = new ScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey, ENCODING_QUICKTIME_JPEG,
                        CompressorNameKey, ENCODING_QUICKTIME_JPEG,
                        DepthKey, 24,
                        FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null, file);

        recorder.start();
        screenRecorder.set(recorder);
        videoPath.set(fullPath);
        System.out.println("Video recording started: " + fullPath);
    }

    public static String stopRecording() throws Exception {
        ScreenRecorder recorder = screenRecorder.get();
        String path = videoPath.get();
        if (recorder != null) {
            try { recorder.stop(); } catch (Exception ignored) {}
            screenRecorder.remove();
            videoPath.remove();
            System.out.println("Video recording stopped: " + path);
            return path;
        }
        return null;
    }
}