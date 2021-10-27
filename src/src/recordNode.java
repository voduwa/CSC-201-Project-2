public class recordNode implements Comparable {

    private byte[] smallArray;
    long getID;
    double getKey;

    //Create constructor with array
    public recordNode(byte[] copyOfRange){
        smallArray = copyOfRange;
    }

    public recordNode(byte[] copyOfRange, long getID, double getKey) {
        smallArray = copyOfRange;
        this.getID = getID;
        this.getKey = getKey;
    }






    @Override
    public int compareTo(Object o) {
        return 0;
    }


}
