import java.io.File;
//import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;


public class Pocket {
   /**
    * The RandomAccessFile of the pocket file
    */
    private RandomAccessFile file;
    private FileChannel channel;
    private FileLock lock;

   /**
    * Creates a Pocket object
    * 
    * A Pocket object interfaces with the pocket RandomAccessFile.
    */
    public Pocket () throws Exception {
        try{
            this.file = new RandomAccessFile(new File("pocket.txt"), "rw");
            this.channel = file.getChannel();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   /**
    * Adds a product to the pocket. 
    *
    * @param  product           product name to add to the pocket (e.g. "car")
    */
    public void addProduct(String product) throws Exception {
        this.lock = this.channel.lock();
        this.file.seek(this.file.length());
        this.file.writeBytes(product+'\n');

        if(this.lock != null){
            this.lock.release();
        }

    }

   /**
    * Closes the RandomAccessFile in this.file
    */
    public void close() throws Exception {
        this.file.close();
    }
}
