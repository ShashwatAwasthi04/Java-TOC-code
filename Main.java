import java.util.*;
class Main{
    public static void main(String args[]){
        System.out.println("Input Symbols: {0,1}*");
        System.out.println("L = {w#w}");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String to be accepted in format *W#W*");
        String n=sc.next();
        n=n.trim();
        
        
        
        n=n+"b";
        char c[]=n.toCharArray();
        int i=0;int flag=0;
        System.out.println("\nTuring Machine Running\n*****************");
        while(c[i]!='b'){
            char ch=c[i];
            char temp;
            if(ch=='0'){//starting first loop for 0
                temp=ch;
                c[i]='x';
                System.out.println("Replacing 0 with x");
                while(c[i+1]!='#'){
                i++;
                System.out.println("Skipping Variable "+c[i]);
                }
                System.out.println("Skipping Variable #");
                i++;
                while((c[i+1]=='x')||(c[i+1]=='y')){
                    i++;
                    System.out.println("Skipping Variable "+c[i]);
                }
                i++;
                if(c[i]==temp){
                    System.out.println("Match of Character Found!Replacing 0 with x");
                    c[i]='x';
                    i--;
                    while(c[i-1]=='x'||c[i-1]=='y'){
                        i--;
                        System.out.println("Skipping Variable "+c[i]);
                    }
                    System.out.println("Skipping Variable #");
                    i--;
                    while(c[i]!='x'){
                        System.out.println("Skipping Variable "+c[i]);
                        i--;
                    }
                    
                }
                else{//If character Mismatches, this halts the machine
                    flag=1;
                    break;
                }
                
            }
            if(ch=='1'){//starting loop for 1
                temp=ch;
                c[i]='y';
                System.out.println("Replacing 1 with y");
                while(c[i+1]!='#'){
                i++;
                System.out.println("Skipping Variable "+c[i]);
                }
                System.out.println("Skipping Variable #");
                i++;
                while((c[i+1]=='x')||(c[i+1]=='y')){
                    i++;
                    System.out.println("Skipping Variable "+c[i]);
                }
                i++;
                if(c[i]==temp){
                    System.out.println("Match of Character Found!Replacing 1 with y");
                    
                    
                    
                    System.out.println("Tape now looks like \n"+String.valueOf(c)+"\nMoving Left");
                    c[i]='y';
                    i--;
                    while(c[i-1]=='x'||c[i-1]=='y'){
                        i--;
                        System.out.println("Skipping Variable "+c[i]);
                    }
                    System.out.println("Skipping Variable #");
                    i--;
                    while(c[i]!='x'){
                        System.out.println("Skipping Variable "+c[i]);
                        i--;
                    }
                    
                }
                else{
                    flag=1;
                    break;
                }
            }
            if(ch=='x'||ch=='y'){
                System.out.println("Skip Variable "+c[i]);
            }
            i++;
        }
        if(flag==1)
        System.out.println("********************************\n\nHalted!Sorry Your String cannot be accepted");
        else
        System.out.println("********************************\n\nHurray! String got Accepted");
        
        
        System.out.println("\nState Transition Table\n");
        System.out.println("        0      1     x       y       #       B");
        System.out.println("->q0  q1,x,R q5,y,R                 q9,#,R  ");
        System.out.println("  q1  q1,0,R q1,1,R                 q2,#,R  ");
        System.out.println("  q2  q3,x,L         q2,x,R q2,y,R          ");
        System.out.println("  q3                 q3,x,L q3,y,L  q4,#,L  ");
        System.out.println("  q4  q4,0,L q4,1,L  q0,x,R                 ");
        System.out.println("  q5  q5,0,R q5,1,R                 q6,#,R  ");
        System.out.println("  q6  q7,y,L         q6,x,R q6,y,R          ");
        System.out.println("  q7                 q7,x,L q7,y,L  q8,#,L  ");
        System.out.println("  q8  q8,0,L q8,1,L  q0,y,R                 ");
        System.out.println("  q9                 q9,x,R q9,y,R  q8,#,L  q10,B,R");
        System.out.println("  q10                                       HALT");
       
    }
}