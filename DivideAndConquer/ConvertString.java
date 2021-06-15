package DivideAndConquer;

public class ConvertString
{
    public static int find(String s1, String s2, int i1, int i2)
    {
        //if we have reached the end of s2, delete all remaining characters of s1
        if(i2 == s2.length())
            return s1.length()-i1;

        //if we have reached the end of s1, insert all remaining characters of s2
        if(i1==s1.length())
            return s2.length()-i2;

        if(s1.charAt(i1) == s2.charAt(i2))
            return find(s1,s2,i1+1,i2+1);

        int delete = 1 + find(s1,s2,i1,i2+1);
        int insert = 1 + find(s1,s2,i1+1,i2);
        int replace = 1+ find(s1,s2,i1+1,i2+1);

        return Math.min(delete, Math.min(insert,replace));
    }

    public static void main(String[] args)
    {
        System.out.println(find("table","tbres",0,0));
        System.out.println(find("catch","carch",0,0));
    }
}
