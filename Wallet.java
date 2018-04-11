import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class Wallet {
   /**
    * The RandomAccessFile of the wallet file
    */  
    private RandomAccessFile file;
    private FileChannel channel;
    private FileLock lock;
   /**
    * Creates a Wallet object
    *
    * A Wallet object interfaces with the wallet RandomAccessFile
    */
    public Wallet () throws Exception {

        try{
            this.file = new RandomAccessFile(new File("wallet.txt"), "rw");
            this.channel = file.getChannel();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   /**
    * Gets the wallet balance. 
    *
    * @return                   The content of the wallet file as an integer
    */
    public int getBalance() throws IOException {
	    this.file.seek(0);
	return Integer.parseInt(this.file.readLine());
    }

   /**
    * Sets a new balance in the wallet
    *
    * @param  newBalance          new balance to write in the wallet
    */
    public void setBalance(int newBalance) throws Exception {
	this.file.setLength(0);
	String str = new Integer(newBalance).toString()+'\n'; 
	this.file.writeBytes(str); 
    }

    public void safeWithdraw(int valueToWithdraw) throws Exception {

        try{
            lock = this.channel.lock();
            this.file.seek(0);
            int balance = Integer.parseInt(this.file.readLine());
            this.file.setLength(0);

            String str = new Integer(balance - valueToWithdraw).toString()+'\n';
            this.file.writeBytes(str);
            if(lock != null){
                lock.release();
            }
        }catch(OverlappingFileLockException e){
            //file is already locked.
        }



    }

   /**
    * Closes the RandomAccessFile in this.file
    */
    public void close() throws Exception {
	this.file.close();
    }
}
