public class MergeSort {
    private static <AnyType extends Comparable<? super AnyType>>
     void MergeSort(AnyType [] a, AnyType [] tmpArray, int left, int right, int center) {
        if (left < right) {
             center = (left + right)/2;
            MergeSort(a,tmpArray,left,center);
            MergeSort(a,tmpArray,center+1,right);
            MergeSort(a,tmpArray,left,center+1,center);

        }
    }
    public static <AnyType extends Comparable<? super AnyType>>
    void MergeSort2(AnyType [] a) {
        AnyType [] tmpArray = (AnyType[]) new Comparable[a.length];
        MergeSort2(a,tmpArray,0,a.length-1);
    }
}