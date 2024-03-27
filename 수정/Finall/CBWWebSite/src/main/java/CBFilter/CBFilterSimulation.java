package CBFilter;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class CBFilterSimulation {

    // Daltonize 알고리즘에 사용되는 매개변수
    private static final double[][] LMS_TRANSFORM_MATRIX = {
        { 0.4002, 0.7076, -0.0808 },
        { -0.2263, 1.1653, 0.0457 },
        { 0.0000, 0.0497, 0.9735 }
    };
    private static final double PROTONOPIA_ALPHA = 0.1;
    private static final double DEUTERANOPIA_ALPHA = 0.8;
    private static final double TRITANOPIA_ALPHA = 0.4;

    // Gamma 보정값
    private static final double GAMMA = 2.2;	

    // 색맹 시뮬레이션 메소드
    public static BufferedImage simulateColorBlindness(BufferedImage originalImage, ColorBlindType type) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage simulatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        double alpha = 0.0;
        if (type == ColorBlindType.PROTANOPIA) {
            alpha = PROTONOPIA_ALPHA;
        } else if (type == ColorBlindType.DEUTERANOPIA) {
            alpha = DEUTERANOPIA_ALPHA;
        } else if (type == ColorBlindType.TRITANOPIA) {
            alpha = TRITANOPIA_ALPHA; // Tritanopia에 대한 alpha 값 추가
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = originalImage.getRGB(x, y);
                Color color = new Color(rgb);

                // Gamma 보정 적용
                color = applyGammaCorrection(color);
                
                // Daltonize 알고리즘 적용
                Color simulatedColor = simulateColorBlindness(color, alpha);

                // 역 Gamma 보정 적용
                simulatedColor = applyInverseGammaCorrection(simulatedColor);

                simulatedImage.setRGB(x, y, simulatedColor.getRGB());
            }
        }

        return simulatedImage;
    }

    // Gamma 보정 적용
    private static Color applyGammaCorrection(Color color) {
        int red = (int) (255 * Math.pow(color.getRed() / 255.0, 1.0 / GAMMA));
        int green = (int) (255 * Math.pow(color.getGreen() / 255.0, 1.0 / GAMMA));
        int blue = (int) (255 * Math.pow(color.getBlue() / 255.0, 1.0 / GAMMA));
        return new Color(red, green, blue);
    }
    
    // 역 Gamma 보정 적용
    private static Color applyInverseGammaCorrection(Color color) {
        int red = (int) (255 * Math.pow(color.getRed() / 255.0, GAMMA));
        int green = (int) (255 * Math.pow(color.getGreen() / 255.0, GAMMA));
        int blue = (int) (255 * Math.pow(color.getBlue() / 255.0, GAMMA));
        return new Color(red, green, blue);
    }

    // Daltonize 알고리즘
    private static Color simulateColorBlindness(Color color, double alpha) {
        double[] lms = colorToLMS(color);
        double[] correctedLMS = correctLMS(lms, alpha);
        Color correctedColor = LMSToColor(correctedLMS);
        return correctedColor;
    }

    // RGB 색상을 LMS 색상으로 변환
    private static double[] colorToLMS(Color color) {
        double r = color.getRed() / 255.0;
        double g = color.getGreen() / 255.0;
        double b = color.getBlue() / 255.0;

        double l = 0.0;
        double m = 0.0;
        double s = 0.0;

        // RGB를 LMS로 변환
        l = LMS_TRANSFORM_MATRIX[0][0] * r + LMS_TRANSFORM_MATRIX[0][1] * g + LMS_TRANSFORM_MATRIX[0][2] * b;
        m = LMS_TRANSFORM_MATRIX[1][0] * r + LMS_TRANSFORM_MATRIX[1][1] * g + LMS_TRANSFORM_MATRIX[1][2] * b;
        s = LMS_TRANSFORM_MATRIX[2][0] * r + LMS_TRANSFORM_MATRIX[2][1] * g + LMS_TRANSFORM_MATRIX[2][2] * b;

        return new double[] { l, m, s };
    }

    // LMS 색상을 RGB 색상으로 변환
    private static Color LMSToColor(double[] lms) {
        double r = 0.0;
        double g = 0.0;
        double b = 0.0;

        // LMS를 RGB로 변환
        r = 4.4679 * lms[0] - 3.5873 * lms[1] + 0.1193 * lms[2];
        g = -1.2186 * lms[0] + 2.3809 * lms[1] - 0.1624 * lms[2];
        b = 0.0497 * lms[0] - 0.2439 * lms[1] + 1.2045 * lms[2];

        // 정규화
        r = Math.min(Math.max(r, 0), 1);
        g = Math.min(Math.max(g, 0), 1);
        b = Math.min(Math.max(b, 0), 1);

        return new Color((int) (r * 255), (int) (g * 255), (int) (b * 255));
    }

    // LMS 색상을 보정
    private static double[] correctLMS(double[] lms, double alpha) {
        // 보정
        lms[0] = lms[0] + alpha * (lms[0] - lms[1]);
        lms[2] = lms[2] + alpha * (lms[2] - lms[1]);
        return lms;
    }

    // 색맹 타입 열거형
    public enum ColorBlindType {
        PROTANOPIA,   // Protanopia: 빨간색에 영향을 받는 색상을 구분하지 못함
        DEUTERANOPIA,  // Deuteranopia: 녹색에 영향을 받는 색상을 구분하지 못함
        TRITANOPIA // TRITANOPIA: 청색에 영향을 받는 색상을 구분하지 못함
    }
}