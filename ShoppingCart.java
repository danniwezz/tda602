import java.io.IOException;
import java.util.Scanner;

public class ShoppingCart {


	
	public static void main(String[] args) throws IOException, Exception {
		Wallet wallet = new Wallet();
		//wallet.setBalance(30000);
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
			int cost = Store.products.get(itemToBuy);
			if(cost > wallet.getBalance()){
				System.out.print("your balance is to low");
				System.exit(0);
			}
			else {
				//wallet.setBalance(wallet.getBalance() - cost);
				wallet.safeWithdraw(cost);
				pocket.addProduct(itemToBuy);
				pocket.close();
			}
			} else {
			System.out.println("Product does not exist");
		}
		System.out.print("Your current balance is now: " + wallet.getBalance());
		System.exit(0);

	}
}
