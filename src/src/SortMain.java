import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
    public class SortMain {
    //Initializing important objects for reading and writing files
    private static Scanner myInput;
    private static Scanner keyboard;
    private static PrintWriter myOutPutFile;
    private static FileWriter XXX;
    private static RandomAccessFile accessFile;

    public static void SortMain (String file) throws IOException {

    //static int input = 500000; //place holder number for file size
    //static int max_number = 5000000; //place holder number for maximum amount the memory can store

    byte[] blockofdata = new byte[65536]; // this is one block of data
    byte[] inputBuffer = new byte[8192];
    byte[] outputBuffer = new byte[8192];
    recordNode[] recordBuffer = new recordNode[512];
    boolean isReadable = true;
    String runfile = "run.bin";
    String mergefile = "merge.bin";
    int sizeOfOutput = 0;
    //read the data

        try {
            RandomAccessFile accessFile = new RandomAccessFile("sampleInput16.bin", "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        RandomAccessFile run = new RandomAccessFile(runfile, "rw");
        RandomAccessFile merge = new RandomAccessFile(mergefile, "rw");

        Minheap<recordNode> minHeap = new Minheap<recordNode>();

            //read data into block of data
            try {
                accessFile.read(blockofdata);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //insert 1 block into min heap

            for (int i = 0; i < 4096; i++) {
                minHeap.insert(new recordNode(Arrays.copyOfRange(blockofdata, i * 16, i * 16 + 16)));

            }

            //while the bin file is being read
        while (isReadable){
            //Read input buffer
            try {
                accessFile.read(inputBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int sizeOfinputBuffer = 512;
            Minheap<recordNode> tempHeap = new Minheap<>();
            while (sizeOfinputBuffer > 0) {

                for (int i =0; i<16; i++){
                    outputBuffer[sizeOfOutput *16 + i] = minHeap.getRoot().getSmallArray()[i];
                }
                recordNode temp = minHeap.removeMin();
                recordNode current = new recordNode(Arrays.copyOfRange(inputBuffer,
                        (sizeOfinputBuffer-1)*16, ((sizeOfinputBuffer-1)*16)+16));
                if (current.compareTo(temp) < 0){
                    tempHeap.insert(current);
                }
                else{
                    minHeap.insert(current);
                }

                sizeOfOutput++;
                sizeOfinputBuffer--;
            }

            while (tempHeap.heapSize() > 0){
                minHeap.insert(tempHeap.removeMin());
            }

            run.write(inputBuffer);
            sizeOfOutput = 0;
            sizeOfinputBuffer = 512;

        }
    }

}
