package DynamicProgramming;

public class ConvertString
{
    public static int topDown(Integer[][] dp,String s1, String s2, int i1, int i2)
    {
        if(dp[i1][i2] == null)
        {
            if(i1 == s1.length()) // if we have reached the end of s1, then insert all the remaining characters of s2
                dp[i1][i2] = s2.length() - i2;
            else if(i2 == s2.length()) // if we have reached the end of s2, then delete all the remaining characters of s1
                dp[i1][i2] = s1.length() - i1;
            else if(s1.charAt(i1) == s2.charAt(i2))
                dp[i1][i2] = topDown(dp, s1, s2, i1+1, i2+1);
            else
            {
                int delete = 1 + topDown(dp,s1,s2,i1,i2+1);
                int insert = 1 + topDown(dp,s1,s2,i1+1,i2);
                int replace = 1 + topDown(dp,s1,s2,i1+1,i2+1);
                dp[i1][i2] = Math.min(delete, Math.min(insert,replace));
            }
        }
        return dp[i1][i2];
    }

    public static int bottomUp(String s1, String s2)
    {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // if we have reached the end of s2, then delete all the remaining characters of s1
        for (int i1 = 0; i1 <= s1.length(); i1++)
            dp[i1][0] = i1;
        // if we have reached the end of s1, then insert all the remaining characters of s2
        for (int i2 = 0; i2 <= s2.length(); i2++)
            dp[0][i2] = i2;
        for (int i1 = 1; i1 <= s1.length(); i1++)
        {
            for (int i2 = 1; i2 <= s2.length(); i2++)
            { // If the strings have a matching character, recursively match for the remaining lengths.
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1][i2 - 1], // delete
                            Math.min(dp[i1 - 1][i2], // insert
                                    dp[i1 - 1][i2 - 1])); // replace
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args)
    {
        String s1="table",s2="tbres";
        Integer[][] arr = new Integer[s1.length()+1][s2.length()+1];
        System.out.println(topDown(arr, s1, s2, 0, 0));

        System.out.println(bottomUp(s1,s2));
    }
}
