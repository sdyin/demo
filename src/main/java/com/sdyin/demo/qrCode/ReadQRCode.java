package com.sdyin.demo.qrCode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * 读取解析二维码
 * @Author: liuye
 * @Date: 2018/6/13 11:06
 */
public class ReadQRCode {
  public static void main(String[] args) throws NotFoundException {
    MultiFormatReader formatReader=new MultiFormatReader();
    File file =new File("D:/new.png");
    BufferedImage image=null;
    try {
      image = ImageIO.read(file);
    } catch (IOException e) {
// TODO Auto-generated catch block
      e.printStackTrace();
    }
    BinaryBitmap binaryBitmap =new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
    Hashtable hints=new Hashtable();
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    Result result=formatReader.decode(binaryBitmap,hints);
    System.err.println("解析结果："+result.toString());
    System.out.println(result.getBarcodeFormat());
    System.out.println(result.getText());
  }
}
