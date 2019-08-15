public class P3LongestSubstring
{
    public static int lengthOfLongestSubstring(String s) {

        if (null == s || 0 == s.length())
        {
            return 0;
        }

        int max = 1;

        for (int i = 0; i < s.length(); i++)
        {
            int j = i + 1;
            if (j < s.length() && s.charAt(i) == s.charAt(j))
            {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));

            while (j < s.length())
            {
                if (sb.indexOf(s.substring(j, j+1)) < 0)
                {
                    sb.append(s.charAt(j));
                    if (sb.length() > max)
                    {
                        max = sb.length();
                    }
                }
                else //发生重复
                {
                    break;
                }

                j++;
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("au"));
    }

}
