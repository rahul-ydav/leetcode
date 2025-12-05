public class Lt4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n>m) return  findMedianSortedArrays(nums2, nums1);

        int mmid = (n+m+1)/2;
        mmid++;

        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            int j = (mmid - (mid+1))-1;

            int firstMax = (mid<n-1) ? nums1[mid+1] : Integer.MAX_VALUE;
            int secondMax = (j<m-1) ? nums2[j+1] : Integer.MAX_VALUE;

            if(firstMax>=nums2[j] && secondMax>=nums1[mid]){
                int max1;
                int max2;
                if(nums1[mid]>nums2[j]){
                    max1 = nums1[mid];
                    max2 = nums2[j];
                    if(mid>0) max2 = Math.max(nums2[j], nums1[mid-1]);
                }
                else{
                    max1 = nums2[j];
                    max2 = nums1[mid];
                    if(j>0) max2 = Math.max(nums1[mid], nums2[j-1]);
                }
                if(((n+m) & 1)==1){
                    return Math.min(max1, max2);
                }
                return (double)(max1+max2)/2;
            }

            if(nums1[mid]>secondMax){
                end = mid-1;
            }
            else{
                start = mid+1;
            }

        }

        if(((n+m)&1)==1)    return nums2[mmid-2];

        return (double)(nums2[mmid-2]+nums2[mmid-1])/2;

    }
}