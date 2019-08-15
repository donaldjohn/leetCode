import java.util.HashSet;
import java.util.Set;

public class P3LongestSubstringFlipWindowWithSet
{
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<Character>();
        int ans = 0, i = 0, j = 0, n = s.length();

        while (j < n && i < n)
        {
            if (!charSet.contains(s.charAt(j))) //移动j
            {
                charSet.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else //移动i,j
            {
                charSet.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("au"));
    }

}
