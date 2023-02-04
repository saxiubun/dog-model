package com.layer;

public class SecondLayer {
    public static void main(String[] args) {

        int img[][][]=FirstLayer.convert2DArray(FirstLayer.loadImg("test2.png"));
        img=filterImg(img);
        FirstLayer.printArray(img,0);
    }

    boolean onHandle=true;//是否为on时间否则为off时间
    //第二层是使用感受野探测第一层
    public static int[][][] filterImg(int[][][] imgArray){
        int[][][] secArry=new int[imgArray.length][imgArray[0].length][imgArray[0][0].length];
        for (int i = 0; i <imgArray.length ; i++) {
            for (int j = 0; j < imgArray[0].length; j++) {
                for (int k = 0; k < imgArray[0][0].length; k++) {
                    secArry[i][j][k]=convFilter(imgArray,i,j,k,1,10);
                }
            }
        }
        return secArry;
    }

    public static int convFilter(int[][][] imgArray,int x,int y,int channle,int radius,int border){
        int maxx=x+radius;
        int minx=x-radius;
        int maxy=y+radius;
        int miny=y-radius;

        int inner=0;
        int outsider=0;

        int sum=imgArray[x][y][channle];

        for (int i = minx; i <= maxx; i++) {
            for (int j = miny; j <=maxy ; j++) {
                int ourput=0;
                if (i>=0&&i<imgArray.length&&j>=0&&j<imgArray[0].length){
                    ourput=imgArray[i][j][channle];
                }
                else{
                    ourput=0;
                }
                if(i==x && j==y){
                    inner=ourput;
                }
                else{
                    outsider=outsider+ourput;
                }
            }
        }
        if(inner-outsider/8>border){
            return sum;
        }
        else {
            return 0;
        }
    }
}
