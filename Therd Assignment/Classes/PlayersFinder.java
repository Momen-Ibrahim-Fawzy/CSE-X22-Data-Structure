package eg.edu.alexu.csd.datastructure.iceHockey.cs59.classes;
import eg.edu.alexu.csd.datastructure.iceHockey.cs59.Interfaces.IPlayersFinder;

import java.awt.*;
import java.awt.geom.Point2D;

public class PlayersFinder implements IPlayersFinder {
    private int numOfPixels =0;
    private int xMin=0,xMax=0,yMin=0,yMax=0;
    private char[][]temp;
    private int[] ceckBorders(char[][]pictureA ,int x,int y,int team,int threshold){
        char[][]picture=pictureA;
        temp=pictureA;

        if (x-1>=0&&y<picture[0].length){
            if (Character.getNumericValue(picture[x-1][y])==team){
                if (x-1<xMin) xMin=x-1;
                if (y<yMin) yMin=y;
                if (x-1>xMax) xMax=x-1;
                if (y>yMax) yMax=y;
                numOfPixels++;
                picture[x-1][y]='-';
                temp=picture;
                ceckBorders(picture,x-1,y,team,threshold);
            }
        }
        if (x+1<picture.length&&y<picture[0].length){
            if (Character.getNumericValue(picture[x+1][y])==team){
                if (x+1<xMin) xMin=x+1;
                if (y<yMin) yMin=y;
                if (x+1>xMax) xMax=x+1;
                if (y>yMax) yMax=y;
                numOfPixels++;
                picture[x+1][y]='-';
                temp=picture;
                ceckBorders(picture,x+1,y,team,threshold);
            }
        }
        if (y-1>=0&&y-1<picture[0].length){
            if (Character.getNumericValue(picture[x][y-1])==team){
                if (x<xMin) xMin=x;
                if (y-1<yMin) yMin=y-1;
                if (x>xMax) xMax=x;
                if (y-1>yMax) yMax=y-1;
                numOfPixels++;
                picture[x][y-1]='-';
                temp=picture;
                ceckBorders(picture,x,y-1,team,threshold);
            }
        }
        if (y+1<picture[0].length){
            if (Character.getNumericValue(picture[x][y+1])==team){
                if (x<xMin) xMin=x;
                if (y+1<yMin) yMin=y+1;
                if (x>xMax) xMax=x;
                if (y+1>yMax) yMax=y+1;
                numOfPixels++;
                picture[x][y+1]='-';
                temp=picture;
                ceckBorders(picture,x,y+1,team,threshold);
            }
        }
        int centerPoint[]=new int [2] ;
        centerPoint[0]=0;
        centerPoint[1]=0;
        if (numOfPixels>=threshold) {
            int xPoint, yPoint;
            xPoint = xMin + xMax+1;
            yPoint = yMin + yMax+1;
            centerPoint[0] = xPoint;
            centerPoint[1] = yPoint;
        }
        return centerPoint;
    }
    private String[] newPhoto (char[][]temp){
        //StringBuilder[] newPhoto = new StringBuilder[temp.length];
        String[] photo= new String[temp.length];;
        /*for (int i=0 ;i<temp.length;i++){
            for (int j=0;j<temp[0].length;j++){
                newPhoto[i].setCharAt(j,temp[i][j]);
            }
        }*/
        for (int i=0 ;i<temp.length;i++){
            photo[i]=String.copyValueOf(temp[i]);
        }
        return photo;
    }
    public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
        char[][]picture=new char[photo.length][photo[0].length()];
        for(int i=0;i<photo.length;i++){
            for (int j=0;j<photo[0].length();j++){
                if(Character.getNumericValue( photo[i].charAt(j))==team) {
                    picture[i][j] = photo[i].charAt(j);
                }
                else
                    picture[i][j] ='-';
            }
        }
        int k=(photo.length*photo[0].length())/((int)Math.ceil((double)threshold/(2*2)));
        int centerPoints[][]=new int [k][2];
        k=0;
        for(int i=0;i<photo.length;i++){
            for (int j=0;j<photo[0].length();j++){
                    numOfPixels = 0;
                    xMin=0;xMax=0;yMin=0;yMax=0;
                    if (Character.getNumericValue(picture[i][j])==team) {
                        picture[i][j]='-';
                        numOfPixels++;
                        xMin=i;xMax=i;yMin=j;yMax=j;
                        int temper[] = new int [2];
                        temper=ceckBorders(picture, i, j, team, ((int)Math.ceil((double)threshold/(2*2))));
                        if (temper[0] != 0 && temper[1]!= 0) {
                            centerPoints[k] = temper;
                            photo = newPhoto(temp);
                            k++;
                        }
                    }
            }
        }

        Point[] pointsOut=new Point[k];
        for (int i=0;i<k;i++){
            pointsOut[i]=new Point(0,0);
        }
        int j=0;
        for (int i=0;i<k;i++){
            if (centerPoints[i][0]!=0&&centerPoints[i][1]!=0) {
                //pointsOut[j].
                pointsOut[j].setLocation (centerPoints[i][1],centerPoints[i][0]);
                j++;
            }
        }
        Point tempo= new Point(0,0);
        for (int i=0;i<k;i++){
            for (j=0;j<k-1;j++){
                if (pointsOut[j].getX()>pointsOut[j+1].getX()){
                    tempo=pointsOut[j+1];
                    pointsOut[j+1]=pointsOut[j];
                    pointsOut[j]=tempo;
                }
            }
        }
        return pointsOut;
    }
}
