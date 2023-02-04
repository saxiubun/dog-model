package com.layer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstLayer {
    //用来进行第一层的响应

    public static void main(String[] args) {
        System.out.println("请输入你要加载的图片名");
        int img[][][]=convert2DArray(FirstLayer.loadImg("test.png"));
        printArray(img,0);
    }

    public static BufferedImage loadImg(String imgName){
        String pathname="D:\\\\Java\\\\my-java-project\\\\img\\\\"+imgName;

        System.out.println(pathname);
        File file =new File(pathname);
        BufferedImage bf=null;
        try {
            bf= ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bf;
    }

    public static int[][][] convert2DArray(BufferedImage bf){
        int width=bf.getWidth();
        int height=bf.getHeight();
        System.out.println("高："+height+"，宽:"+width);
        int channel=3;
        int r=0;
        int g=1;
        int b=2;
        int[] date=new int[width*height];
        int[][][] img=new int[width][height][channel];

        bf.getRGB(0,0,width,height,date,0,width);


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                img[i][j][r]=(date[i*width+j]>>16)& 0xFF;
                img[i][j][g]=(date[i*width+j]>>8)& 0xFF;
                img[i][j][b]=(date[i*width+j])& 0xFF;
            }
        }
        return img;
    }

    public static void printArray(int[][][] imgArray,int channel){
        for (int i = 0; i <imgArray.length ; i++) {
            for (int j = 0; j <imgArray[0].length ; j++) {
                System.out.print(imgArray[i][j][channel]+"\t");
            }
            System.out.println();
        }
    }
}
