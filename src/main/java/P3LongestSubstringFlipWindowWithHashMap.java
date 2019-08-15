import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3LongestSubstringFlipWindowWithHashMap
{
    public static int lengthOfLongestSubstring(String s)
    {

        //保存j下一个索引, 也就是i滑动后的起始值, 保存所有字符出现过的位置
        Map<Character, Integer> characterIndexMap = new HashMap<Character, Integer>();
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++)
        {
            if (characterIndexMap.containsKey(s.charAt(j)))//发现重复字符, 进行跳转
            {
                i = Math.max(i, characterIndexMap.get(s.charAt(j)));
            }
            characterIndexMap.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("au"));
    }

}
