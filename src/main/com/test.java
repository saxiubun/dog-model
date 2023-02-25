package main.com;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.net.URL;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.cvtColor;

public class test {
    public static void main(String[] args) {
        try {
            testOpencv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testOpencv() throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // ¶ÁÈ¡Í¼Ïñ
        Mat image = imread("D:\\Java\\my-java-project\\img\\test.png");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
        imshow("Original Image", image);

        waitKey();
    }
}
