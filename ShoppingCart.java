import java.io.IOException;
import java.util.Scanner;

public class ShoppingCart {


	
	public static void main(String[] args) throws IOException, Exception {
		Wallet wallet = new Wallet();
		wallet.setBalance(30000);
		Pocket pocket = new Pocket();
		Scanner scan = new Scanner(System.in);	
		//printUserBalance();
		System.out.println("Your balance " + wallet.getBalance());
		//printProducts();
		System.out.println(Store.asString());
		System.out.print("What do you want to buy?:");
		String itemToBuy = scan.nextLine();
		scan.close();
		if(Store.products.containsKey(itemToBuy)) {
			if(wallet.getBalance() >= Store.products.get(itemToBuy)) {
				int cost = Store.products.get(itemToBuy);
				wallet.setBalance(wallet.getBalance() - cost);
				pocket.addProduct(itemToBuy);
				pocket.close();
			}
		} else {
			System.out.println("Product does not exist");
		}
		System.out.print("Your current balance is now: " + wallet.getBalance());
		System.exit(0);

	}

	/*private static void changeBalance(String itemToBuy) {
		if(Store.products.containsKey(itemToBuy)) {
			int cost = Store.products.get(itemToBuy);
			Wallet.setBalance(Wallet.getBalance() - cost) ;
		}
	}
	
	private static void printUserBalance() {
		try {
			System.out.println("Your balance" + Wallet.getBalance());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	private static void printProducts(){
		System.out.println(Store.asString());
		}
	*/
	
				
	

}
