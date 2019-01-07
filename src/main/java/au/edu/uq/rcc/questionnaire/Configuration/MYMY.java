package au.edu.uq.rcc.questionnaire.Configuration;

public class MYMY {
    private Integer id;
    public MYMY(){
        id=5;
        initailizeId();
        System.out.println(id);
    }

    private void initailizeId(){
        id++;
    }

    public static void main(String[] args){
        MYMY m=new MYMY();
    }
}
