package com.example.shudu;

import java.util.Random;

public class Functions {
   /* final String str="902507360"+
            "405003027"+
            "730920800"+
            "006805079"+
            "809064502"+
            "014070083"+
            "150098206"+
            "240601090"+
            "090730154";
    */

      /*final String str="982547361"+
              "465183927"+
              "731926845"+
              "326815479"+
              "879364512"+
              "514279683"+
              "157498036"+
              "043651798"+
              "698730154";
*/  static String str;
   static int sudoAll[]=new int[81];
   static int sudoEmpty[]=new int[81];
   static int sudoFill[]=new int[81];
    int ri,errorkind;
    static int blank_num;
    public Functions(){
        str=Level.string;
        sudoEmpty=fillPuzzle(str);//原始棋盘
        sudoAll=fillPuzzle(str);//全部内容
    }
   static int[] fillPuzzle(String str)
    {
        int[]sudo=new int[81];
        if(str=="") return sudo;
        for(int i=0;i<81;++i)
        {
            sudo[i]=str.charAt(i)-'0';
        }
        return sudo;
    }

    public static String randomStr(String str)
    {
        Random rand=new Random();
        String str2="";
        int []old_shudu=fillPuzzle(str);
        int x;
        for(int i=0;i<blank_num;++i)
        {
            x=(int)(rand.nextInt(81));
           old_shudu[x]=0;
        }
        for(int i=0;i<81;++i)
        {
            str2+=String.valueOf(old_shudu[i]);
        }
        return str2;
    }

    private int getNum(int x,int y,int[]sudu)
    {
        return sudu[9*y+x];
    }
    public boolean setNum(int x,int y,int num)
    {
        if(sudoEmpty[9*y+x]==0) {
            sudoAll[9 * y + x] = num;
            sudoFill[9 * y + x] = num;
            return true;
        }
        return false;
    }
    public String drawNum(int x,int y,int[]sudo)
    {
        int num=getNum(x,y,sudo);
        if(num==0) return"";
        else return String.valueOf(num);
    }
    private Boolean checkFull(int[] sudo)
    {
        for(int i=0;i<81;++i)
        {
            if(sudo[i]>=1&&sudo[i]<=9) continue;
            ri=i;
            errorkind=0;
            return false;
        }
        return true;
    }
    private Boolean checkRow(int[]sudo)
    {
        int[] nums=new int[10];
        int pass=1,tag=0;
        for(int i=0;i<9;++i)
        {
            for(int j=0;j<9;++j)
            {
                if(++nums[sudo[tag]]==pass)
                {
                    ++tag;
                    continue;
                }
                else
                {
                    ri=tag;
                    errorkind=1;
                    return false;
                }

            }
            ++pass;
        }
        return true;
    }
    private Boolean checkCol(int[]sudo)
    {
        int[] nums=new int[10];
        int pass=1,tag;
        for(int i=0;i<9;++i)
        {
            tag=i;
            for(int j=0;j<9;++j)
            {
                if(++nums[sudo[tag]]==pass)
                {
                    tag+=9;
                    continue;
                }
                else
                {   ri=tag;
                    errorkind=2;
                    return false;
                }
            }
            ++pass;
        }
        return true;
    }
    private Boolean checkSquare(int[]sudo)
    {
        int[] nums=new int[10];
        int[] tags=new int[]{0,3,6,27,30,33,54,57,60};
        int pass=1,tag;
        for(int i=0;i<9;++i)
        {
            tag=tags[i];
            for(int j=0;j<3;++j)
            {
                if(tag==57)
                    tag=57;
                if(++nums[sudo[tag]]==pass&&++nums[sudo[tag+1]]==pass&&++nums[sudo[tag+2]]==pass) {
                    tag+=9;
                    continue;
                }
                else
                {
                    errorkind=3;
                    ri=tag;
                    return false;
                }
            }
            ++pass;
        }
        return true;
    }
    public boolean winGame(){
        if(checkFull(sudoAll)&&checkRow(sudoAll)&&checkCol(sudoAll)&&checkSquare(sudoAll))
            return true;
        else return false;
    }
}
