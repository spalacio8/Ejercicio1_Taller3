package exercise;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author josep
 */
public class Logic {
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double radiusOne;
    private double radiusTwo;
    private ArrayList listPoints;
    private String answer;
    private Ventana window;
    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    

    public void tokens(String word){
        
        
        StringTokenizer token = new StringTokenizer(word, ";(),\n");

        String xOne = (token.nextElement()).toString();
        x1 = Double.parseDouble(xOne);


        String yOne = (token.nextElement()).toString();
        y1 = Double.parseDouble(yOne);


        String r1 = (token.nextElement()).toString();
        radiusOne = Double.parseDouble(r1);


        String xTwo = (token.nextElement()).toString();
        x2 = Double.parseDouble(xTwo);

        
        String yTwo = (token.nextElement()).toString();
        y2 = Double.parseDouble(yTwo);


        String r2 = (token.nextElement()).toString();
        radiusTwo = Double.parseDouble(r2);
        
        listPoints = new ArrayList();
        
        while (token.hasMoreElements()) {
            listPoints.add( ( token.nextElement() ).toString() );
        }
        
        double cX, cY;
        int pos = 0;
        double [][] points;
        
        points = new double [listPoints.size()/2][2];
        
        for (int x = 0; x < (listPoints.size() - 1); x += 2) 
        {
            cX = Double.parseDouble( ( listPoints.get(x) ).toString() );
            cY = Double.parseDouble(   ( listPoints.get(x + 1) ).toString() );
            
            points [pos][0] = cX;
            points [pos][1] = cY;
            
            pos++;
        }
        calculate(points);
    }
    
    public void calculate( double [][] p ){
        String word="";
        double distanceOne, distanceTwo;
        
        for (int i = 0; i < p.length; i++) {
            double c = p[i][0];
            double d = p[i][1];

            distanceOne = Math.sqrt( Math.pow( (c-x1), 2) +  Math.pow( (d-y1), 2) );
            distanceTwo = Math.sqrt( Math.pow( (c-x2), 2) +  Math.pow( (d-y2), 2) );
            
            if( (distanceOne <= radiusOne) && (distanceTwo <= radiusTwo) )
            {
                word += "El punto (" + c + ", " + d + ") "+ "está dentro de ambas circunferencias.\n";
            }else
            {
                if( (distanceOne <= radiusOne) && (distanceTwo > radiusTwo) ){
                    word += "El punto (" + c + ", " + d + ") "+ "está dentro de la circunferencia 1.\n";
                }else{
            
                    if( (distanceTwo <= radiusTwo) && (distanceOne > radiusOne) ){
                        word += "El punto (" + c + ", " + d + ") "+ "está dentro de la circunferencia 2.\n";
                    }else{
                        word += "El punto (" + c + ", " + d + ") "+ " NO está dentro de ninguna circunferencia.\n";
                    }
                }
            }
            
        }
        
        window = new Ventana(word);
        window.show();

       
    }
    
}
