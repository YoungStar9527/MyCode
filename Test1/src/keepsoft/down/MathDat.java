package keepsoft.down;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
public class MathDat {
	public static void main(String[] args) {
		try{
        FileWriter fw=new FileWriter("D:/散点.dat");  
        BufferedWriter bw=new BufferedWriter(fw);
        double x=0,y=0,z=0;
		for(int i=0;i<=25/0.125;i++){
				for(int n=0;n<9;n++){
					x=i*0.125;
					y=n*0.125;
					if(x>8&&x<12){
						z=0.2-0.05*((x-10)*(x-10));
					}else{
						z=0;
					}
					DecimalFormat df=new DecimalFormat("#0.0000");
					System.out.println(x+"  "+y+"  "+round(z,4));
					bw.write(df.format(x)+"  "+df.format(y)+"  "+df.format(round(z,4)));
					bw.newLine();
				}
		}
        bw.close(); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static double round(double v,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
