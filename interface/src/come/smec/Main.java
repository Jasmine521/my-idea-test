package come.smec;

import com.sun.xml.internal.ws.api.message.MessageWritable;

public class Main {
    public static void main(String[] args){
        Income[] incomes = new Income[]{new R(7500),new S(10010) };
        int total=0;
        for(Income n:incomes){
            total += n.getTex();
        }
        System.out.println(total);
    }
}



interface Income{
    double getTex();
}

class R implements Income{
    private double income;
    public R(double income){
        this.income=income;
    }

    public double getTex(){
        if(income>5000) return (income-5000)*0.2;
        else return 0;
    }
}
class S implements Income{
    private  double income;
    public S(double income){
        this.income=income;
    }

    public  double getTex(){
        if(income>7000)return (income-7000)*0.5;
        else  return 0;
    }
}
