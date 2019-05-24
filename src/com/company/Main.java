package com.company;
import java.util.Scanner;
class Game {
    private static int getRandomCard(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    private String TypeSolution() {
        Scanner sc = new Scanner(System.in);
        String TypeIn = sc.nextLine();
        return TypeIn;
    }
    public void ModelChoose(){
        Calculator solve=new Calculator();
        Solution search=new Solution();
        int[]nums=new int[4];
        System.out.println("Welcome to 24Pointer Game");
        System.out.println("Please select the option:");
        System.out.println("1)Random Start 2)Quit");
        String tmp=TypeSolution();
        if(tmp.equals("1")){
            System.out.println("Please find a Solution from following Cards ");
            System.out.println("Type 'SOS' if you want to see a Solution");
            System.out.println("Type 'No' if there is no Solution");
            for(int i=0;i<4;i++){
                nums[i]=getRandomCard(1,13);
                System.out.println(nums[i]);
            }
            tmp=TypeSolution();
           if(tmp.equals("SOS")){
               System.out.println("The Solution of this case is "+search.TwentyFourPoints(nums[0],nums[1],nums[2],nums[3]));
           }
            else if(solve.FPE(tmp)==24||tmp.equals("No")){
                System.out.println("Your Answer is Correct");
            }
            else
                System.out.println("Your Answer is invalid");
        }
        else if(tmp.equals("2")){
            System.out.println("Thank you for Playing");
        }
    }
}
class Solution{
    public String TwentyFourPoints(int a,int b,int c, int d){
        if(SecondNum(a,b,c,d)!=NoFound()){
            return SecondNum(a,b,c,d);
        }
        else if(SecondNum(a,b,d,c)!=NoFound()){
            return SecondNum(a,b,d,c);
        }
        else if(SecondNum(a,c,b,d)!=NoFound()){
            return SecondNum(a,c,b,d);
        }
        else if(SecondNum(a,c,d,b)!=NoFound()){
            return SecondNum(a,c,d,b);
        }
        else if(SecondNum(a,d,b,c)!=NoFound()){
            return SecondNum(a,d,b,c);
        }
        else if(SecondNum(a,d,c,b)!=NoFound()){
            return SecondNum(a,d,c,b);
        }
        else if(SecondNum(b,a,c,d)!=NoFound()){
            return SecondNum(b,a,c,d);
        }
        else if(SecondNum(b,a,d,c)!=NoFound()){
            return SecondNum(b,a,d,c);
        }
        else if(SecondNum(b,c,a,d)!=NoFound()){
            return SecondNum(b,c,a,d);
        }
        else if(SecondNum(b,c,d,a)!=NoFound()){
            return SecondNum(b,c,d,a);
        }
        else if(SecondNum(b,d,a,c)!=NoFound()){
            return SecondNum(b,d,a,c);
        }
        else if(SecondNum(b,d,c,a)!=NoFound()){
            return SecondNum(b,d,c,a);
        }
        else if(SecondNum(c,a,b,d)!=NoFound()){
            return SecondNum(c,a,b,d);
        }
        else if(SecondNum(c,a,d,b)!=NoFound()){
            return SecondNum(c,a,d,b);
        }
        else if(SecondNum(c,b,a,d)!=NoFound()){
            return SecondNum(c,b,a,d);
        }
        else if(SecondNum(c,b,d,a)!=NoFound()){
            return SecondNum(c,b,d,a);
        }
        else if(SecondNum(c,d,a,b)!=NoFound()){
            return SecondNum(c,d,a,b);
        }
        else if(SecondNum(c,d,b,a)!=NoFound()){
            return SecondNum(c,d,b,a);
        }
        else if(SecondNum(d,a,b,c)!=NoFound()){
            return SecondNum(d,a,b,c);
        }
        else if(SecondNum(d,a,c,b)!=NoFound()){
            return SecondNum(d,a,c,b);
        }
        else if(SecondNum(d,c,a,b)!=NoFound()){
            return SecondNum(d,c,a,b);
        }
        else if(SecondNum(d,c,b,a)!=NoFound()){
            return SecondNum(d,c,b,a);
        }
        return NoFound();
    }
    private String FourthNum(int front,int d){
        String s="";
        if(front+d==24){
            s="+"+""+d+"";
        }
        else if(front-d==24){
            s="-"+""+d+"";
        }
        else if(front*d==24){
            s="*"+""+d;
        }
        else if(front%d==0&&front/d==24){
            s="/"+""+d;
        }
        else{
            s=NoFound();
        }
        return s;
    }
    private String ThirdNum(int front,int c,int d){
        String s="";
        if(FourthNum(front+c,d)!=NoFound()){
            s="+"+c+""+""+FourthNum(front+c,d);
        }
        else if(FourthNum(front-c,d)!=NoFound()){
            if(front-c>0)
                s="-"+c+""+""+FourthNum(front-c,d);
            else
                s="-"+""+front+""+""+FourthNum(c-front,d);
        }
        else if(FourthNum(front*c,d)!=NoFound()){
            s="*"+""+c+""+""+FourthNum(front*c,d);
        }
        else if(front%c==0&&FourthNum(front/c,d)!=NoFound()){
            s="/"+""+c+""+""+FourthNum(front/c,d);
        }
        else{
            s=NoFound();
        }
        return s;
    }
    private String SecondNum(int front,int b,int c,int d) {
        String s="";
        if (ThirdNum(front + b, c, d)!=NoFound()) {
            s="("+front+"+"+""+b+")"+""+ThirdNum(front+b,c,d);
        }
        else if(ThirdNum(front - b, c, d)!=NoFound()) {
            if(front-b>0){
                s="("+front+"-"+""+b+")"+""+ThirdNum(front-b,c,d);
            }
            else{
                s="("+b+"-"+""+front+")"+""+ThirdNum(b-front,c,d);
            }
        }
        else if(ThirdNum(front * b, c, d)!=NoFound()){
            s=""+front+"*"+""+b+""+""+ThirdNum(front*b,c,d);
        }
        else if(front % b == 0&&ThirdNum(front / b, c, d)!=NoFound()){
            s=""+front+"/"+""+b+""+""+ThirdNum(front/b,c,d);
        }
        else{
            s=NoFound();
        }
        return s;
    }
    private String NoFound(){
        return "NotFound";
    }

}
public class Main {

    public static void main(String[] args) {
	Game game=new Game();
    game.ModelChoose();

    }
}