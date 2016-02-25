/*
 */

package imageprocessing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;



/**
 * Vincent Yahna
 */
public class Imageprocessing {
    

public static boolean matches(double[] c1, double[] c2)
{
    return (Math.abs(c2[0] - c1[0]) > 20 || Math.abs(c2[1] - c1[1]) > 20 || Math.abs(c2[2] - c1[2]) > 20);
}
public static boolean matchesANeighbor(int i, int j, Mat m, double[] color)
{
    
    double[] cur = m.get(i, j);
    double[] up = m.get(i, j-1);
    double[] down = m.get(i, j +1);
    double[] left = m.get(i-1, j);
    double[] right = m.get(i+1, j);
    
    if(matches(cur, up) || matches(cur, down) || matches(cur, left) || matches(cur, right)){
        color = cur;
        return true;
    }
    else{
        color = left;
        return false;
    }
}
    /**
     * Main method does awesome stuff
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat picture = Highgui.imread("C:\\Users\\Vince\\Pictures\\samuraiColored.png");
        picture = picture;
        for(int i=1; i< 2500 -1; i++){
            for(int j=1; j< 1944 -1; j++)
                
            
        {
            
            double[] color = new double[3];
            if(color[0] > 230 && color[1] >230  && color[2] >230)
                  picture.put(i,j, picture.get(i - 1, j));
            if(! matchesANeighbor(i,j, picture, color)){
                picture.put(i, j, color);
            }
            /*double c1 = picture.get(i,j)[0];
            double c2 = picture.get(i,j)[1];
            double c3 = picture.get(i,j)[2];
            
            double b1 = picture.get(i -1, j)[0];
            double b2 = picture.get(i -1, j)[1];
            double b3 = picture.get(i -1, j)[2];
            
              
              
              
              //if(i %10==0)
                //picture.put(i, j, 255, 155 , 0.0);
              //if(j % 10==0)
                //  picture.put(i,j, 255,0,100);
              if(Math.abs(b1 - c1) < 20 || Math.abs(b2 - c2) < 20 || Math.abs(b3 - c3) < 20)
                picture.put(i,j, picture.get(i - 1, j));
            */
                
            
        }
            }
        Highgui.imwrite("samurai.png", picture);
     
        System.out.println(picture.channels());
        System.out.println(picture.dims());
        System.out.println(picture.cols());
        System.out.println(picture.rows());
        System.out.println(picture.toString());
       
       
    }

}
