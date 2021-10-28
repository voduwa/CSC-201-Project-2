import java.io.*;
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

    public static void SortMain (String file) {

    byte[] blockofdata = new byte[65536]; // this is one block of data
    byte[] inputBuffer = new byte[8192];
    byte[] outputBuffer = new byte[8192];
    recordNode[] recordBuffer = new recordNode[512];
    //read the data

        try {
            RandomAccessFile accessFile = new RandomAccessFile("sampleInput16.bin", "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Minheap minHeap = new Minheap();


        //For loop to read and insert 8 blocks of data to a minheap
        for(int k = 0; k <8; k++) {
            //read data into block of data
            try {
                accessFile.read(blockofdata);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //insert 1 block into min heap
            for (int i = 0; i < 512; i++) {
                minHeap.insert(new recordNode(Arrays.copyOfRange(blockofdata, i * 16, i * 16 + 16)));

            }
        }
        //sizeOfInput
        //sizeofOutput
        //input Buffer = byte[] 8192
        //output Buffer = byte[] 8192
        try {
            accessFile.read(inputBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Make inputBuffer into records
        for (int i = 0; i < recordBuffer.length; i++){
            recordBuffer[i] = new recordNode(Arrays.copyOfRange(inputBuffer, i * 16, i*16 + 16));
        }
    }
}
