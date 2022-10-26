package boke.boke.util;

import com.alibaba.druid.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * png图片转换为jpg图片压缩工具类
 */
public class ImageUtil {

    /**
     * 按照宽高比例压缩
     * @param img 图片
     * @param width 指定压缩的宽度
     * @param height    指定压缩的高度
     */
    public static void thumbnail_w_h(File img, int width, int height, OutputStream out,boolean suf) throws IOException {
        double srcWidth = 0.0; // 源图宽度
        double srcHeight =0.0;   // 源图高度
//         if (suf){//判断是否为jpg格式--从网页上下载的图片后缀为jpg但实际上可能会是webp的文件格式
//             String s = imgTypes(new FileInputStream(img));
//             System.out.println(s);
//         }
        // ImageIO.read解析webp获取宽高报错的解决方法
//        String fileType = ImgeMimeTypeUtils.getMimeType(img.getAbsolutePath());
//        System.out.println(fileType);
//        if (fileType != null && "image/webp".equals(fileType)) {
//            FileInputStream file = new FileInputStream(img);
//            byte[] bytes = new byte[30];
//            file.read(bytes, 0, bytes.length);
//            int wid = ((int) bytes[27] & 0xff) << 8
//                    | ((int) bytes[26] & 0xff);
//            int hei = ((int) bytes[29] & 0xff) << 8
//                    | ((int) bytes[28] & 0xff);
//            srcWidth=(double)wid;
//            srcHeight=(double)hei;
//        } else {
            BufferedImage bi = ImageIO.read(img);
             srcWidth = bi.getWidth();    // 源图宽度
             srcHeight = bi.getHeight();  // 源图高度
//        }
            double scale = 1;

            // 压缩比例
            if (width > 0) {
                scale = width / srcWidth;
            }
            if (height > 0) {
                scale = height / srcHeight;
            }
            if (width > 0 && height > 0) {
                scale = height / srcHeight < width / srcWidth ? height / srcHeight : width / srcWidth;
            }

            thumbnail(img, (int) (srcWidth * scale), (int) (srcHeight * scale), out);

    }

    /**
     * 按照固定宽高原图压缩
     */
    public static void thumbnail(File img, int width, int height, OutputStream out) throws IOException {
        BufferedImage bi = ImageIO.read(img);
        /**放大图像不会导致失真，而缩小图像将不可避免的失真
         * getScaledInstance方法是将图片缩小其中java提供了五个缩放的微调选项
         * Image.SCALE_SMOOTH平滑优先 image.SCALE_AREA_AVERAGING区域均值
         * image.SCALE_FAST速度优先 image.SCALE_REPLICATE 像素复制型缩放
         * image.SCALE_DEFAULT为默认缩放模式
         */
        Image image = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        //创建一个不带透明色的对象
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); //绘制处理后的图
        g.dispose();
        ImageIO.write(tag, "JPG", out);
    }
    //读取图片格式
    public static String imgTypes(InputStream inputStream) throws IOException {
        // 读取文件前几位
        byte[] fileHeader = new byte[4];
        int read = inputStream.read(fileHeader, 0, fileHeader.length);
        inputStream.close();

        // 转为十六进制字符串
        String header =  bytes2Hex(fileHeader);

        if (header.contains("FFD8FF")) {
            return "jpg";
        } else if (header.contains("89504E47")) {
            return "png";
        } else if (header.contains("47494638")) {
            return "gif";
        } else if (header.contains("424D")) {
            return "bmp";
        } else if (header.contains("52494646")) {
            return "webp";
        } else if (header.contains("49492A00")) {
            return "tif";
        } else {
            return "unknown";
        }

    }
    public static String bytes2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xff);
            sb.append(hex.length() == 2 ? hex : ("0"+hex));
        }
        return sb.toString();
    }
}
