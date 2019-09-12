package binary;

public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if (image.length==0){
            return -1;
        }
        int left=findLeft(image, y);
        int right=findRight(image, y);
        int top=findTop(image, x);
        int bottom=findBottom(image, x);
        return (right-left+1)*(bottom-top+1);
    }
    private boolean rowIsEmpty(int x,char[][] image){
        if (x<0 || x>image.length-1){
            throw new IllegalArgumentException("index out of boundary");
        }
        for (int i=0;i<image[0].length-1;i++){
            if (image[x][i]=='1'){
                return false;
            }
        }
        return true;
    }
    private boolean colIsEmpty(int y,char[][] image){
        if (y<0 || y>image[0].length-1){
            throw new IllegalArgumentException("index out of boundary");
        }
        for (int i=0;i<image.length-1;i++){
            if (image[i][y]=='1'){
                return false;
            }
        }
        return true;
    }
    private int findLeft(char[][] image ,int y){
        int y1=0;
        while (y1+1<y){
            int mid=y1+(y-y1)/2;
            if (colIsEmpty(mid,image)){
                y1=mid;
            }else {
                y=mid;
            }
        }
        if (colIsEmpty(y1,image)){
            return y;
        }
        return y1;
    }
    private int findRight(char[][] image , int y){
        int y2 = image[0].length-1;
        while (y+1<y2){
            int mid=y+(y2-y)/2;
            if (colIsEmpty(mid,image)){
                y2=mid;
            }else {
                y=mid;
            }
        }
        if (colIsEmpty(y2,image)){
            return y;
        }
        return y2;
    }
    private int findTop(char[][] image,int x){
        int x1=0;
        while(x1+1<x){
            int mid=x1+(x-x1)/2;
            if(rowIsEmpty(mid,image)){
                x1=mid;
            }else {
                x=mid;
            }
        }
        if (rowIsEmpty(x1,image)){
            return x;
        }
        return x1;
    }
    private int findBottom(char[][] image,int x){
        int x2=image.length-1;
        while (x+1<x2){
            int mid=x+(x2-x)/2;
            if (rowIsEmpty(mid,image)){
                x2=mid;
            }else {
                x=mid;
            }
        }
        if (rowIsEmpty(x2,image)){
            return x;
        }
        return x2;
    }
}
