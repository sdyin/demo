package com.sdyin.demo.qrCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Hashtable;

import java.io.File;
/**
 * 生成二维码
 * @Author: liuye
 * @Date: 2018/6/13 11:01
 */
public class TestQRCode {
  public static void main(String[] args) throws IOException {
    String text = "http://www.baidu.com";
    int width = 400;
    int height = 400;
    String format = "png";
    Hashtable hints = new Hashtable();
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
    hints.put(EncodeHintType.MARGIN, 2);
    try {
      BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
      Path file = new File("D:/new.png").toPath();
      MatrixToImageWriter.writeToPath(bitMatrix, format, file);
    } catch (WriterException e) {
// TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
