import java.nio.ByteBuffer;

public class MergeSort {
    //public static <ByteBuffer extends Comparable<? super ByteBuffer>>

     private static void MSort(ByteBuffer[] a, ByteBuffer[] tmpArray, int left, int right, int center) {
        if (left < right) {
             center = (left + right)/2;
            MSort(a, tmpArray, left, right, center);
            MSort(a, tmpArray, left, right, center);
            MSort(a,tmpArray,left,center+1,center);

        }
    }



    //public static <ByteBuffer extends Comparable<? super AnyType>>
    public static void MergeSort2(ByteBuffer[] anyTypes, ByteBuffer[] a, int i1, int i) {
        ByteBuffer [] tmpArray = (ByteBuffer[]) new Comparable[a.length];
        MergeSort2(a,tmpArray,0,a.length-1);
    }
}
//