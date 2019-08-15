public class P4FindMedianInSortedArray
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int totalLength = nums1.length + nums2.length;


        int medianIndexOfOddTotalLength = totalLength / 2;

        int medianIndexLeftOfEvenLength = totalLength / 2 - 1;
        int medianIndexRightOfEvenLength = totalLength / 2;

        boolean totalLengthIsOdd = true;
        if (totalLength % 2 == 0)
        {
            totalLengthIsOdd = false;
        }


        return median;
    }
}
