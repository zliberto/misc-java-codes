// IDS 401 Project
// Liberto, Zuzanna
// Seat 15
// Completed? Y[x] N[ ]
//
// Comments: I emailed Professor Choi asking if I need to ask for user input when it comes to the initial array size.
// He said since I'm using an ArrayList, I don't have to.
// Instead, I should just add a line of code telling the TA that my array doesn't need size input and to not grade this.
// This message is output in the initial menu (code line 34-35)

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class IDS401Proj {
	ArrayList<Coupon> coupons;
	FileReader file;

	public static void main(String[] args) throws Exception {

		// Create an object
		IDS401Proj obj = new IDS401Proj();

		Scanner scanner = new Scanner(System.in);
		int dec;
		String path;

		// This is the master ArrayList of Coupon objects
		obj.coupons = new ArrayList<Coupon>();

		// Code for the initial menu starts here. Its purpose is to fill the coupons
		// ArrayList with data. It can either read it from file or accept manual input
		System.out.println(
				"\nWelcome to the initial menu!\n \nPlease select one of the following options:\n 1. Read data from file \n 2. Manual input 1-by-1 \n 0. Exit\n\n*** Disclaimer: This app doesn't need a user input when it comes to the initial array size. *** \n*** It works with any size of data because it implements an ArrayList. *** \n\n>");

		dec = scanner.nextInt();
		switch (dec) {

		case 0:
			System.out.println("Goodbye!");
			System.exit(0);
			break;

		case 1:
			System.out.println("Please type/paste in the file path. The path can't be empty, and if it is, you'll be prompted to reenter:");
			do {
				path = scanner.nextLine();
			} while (path.isEmpty());
			obj.file = new FileReader(path);
			BufferedReader scan = new BufferedReader(obj.file);
			obj.coupons = obj.readCoupons(obj.file);
			System.out.println(
					"Do you want to manually add additional coupons? You can also do that later. Type in: 1 - Yes, 0 - No\n>");
			int choice;
			choice = scanner.nextInt();
			if (choice == 1) {
				obj.coupons = obj.addCoupons(obj.coupons);
			}
			break;

		case 2:
			obj.coupons = obj.addCoupons(obj.coupons);
			break;
		}

		// This is the main menu of the app. It allows the user to add coupons manually,
		// search for coupons and list sorted coupons.

		do {

			System.out.println(
					"\nMain menu:\n\nPlease select one of the following options:\n 1. Add coupons (Manual input) \n 2. Search for a coupon \n 3. List all coupons \n 0. Exit\n>");
			dec = scanner.nextInt();

			switch (dec) {
			case 0:
				System.out.println("Goodbye!");
				System.exit(0);
				break;

			case 1:
				obj.coupons = obj.addCoupons(obj.coupons);
				break;

			case 2:
				obj.searchCoupons(obj.coupons);
				break;

			case 3:
				obj.sortAndDisplay(obj.coupons);
				break;

			}
		} while (dec != 0);

	}

	// This method reads a .csv file. For each row it reads, it separates and stores
	// the columns in their own arrays.
	// Then, it creates a new Coupon object for each row and adds this object to the
	// passed ArrayList.
	// It returns a ArrayList filled with objects corresponding to the rows of the
	// csv file.

	ArrayList<Coupon> readCoupons(FileReader file) throws Exception {
		String arr[] = {};
		String line = "";
		BufferedReader scan = new BufferedReader(file);
		ArrayList<Coupon> couponArr = new ArrayList<Coupon>();
		float finalPrice;

		while ((line = scan.readLine()) != null) {
			arr = line.split(",");
			float price = Float.parseFloat(arr[1]);
			int disc = Integer.parseInt(arr[3]);
			finalPrice = (float) ((1 - (((float) disc) / 100.00)) * price);
			Coupon coupon = new Coupon(arr[0], price, arr[2], disc, Integer.parseInt(arr[4]), (arr[5]), finalPrice);
			couponArr.add(coupon);
		}
		System.out.println("\nThe file was read successfully.\n");
		return couponArr;

	}

	// This method allows the user to add coupons manually. It takes the master
	// ArrayList and returns it with the input coupon appended to it.
	ArrayList<Coupon> addCoupons(ArrayList<Coupon> coupons) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("\nManual input mode:\n");
		String prod, prov, stat;
		float price, finalPrice;
		int disc, exp, add;

		// Take user input, create a new Coupon object with it.
		do {
			System.out.println("Product:");
			prod = scanner.next();
			System.out.println("Price:");
			price = scanner.nextFloat();
			System.out.println("Provider:");
			prov = scanner.next();
			System.out.println("Discount Rate:");
			disc = scanner.nextInt();
			System.out.println("Expiration:");
			exp = scanner.nextInt();
			System.out.println("Status:");
			stat = scanner.next();

			finalPrice = (float) ((1 - (((float) disc) / 100.00)) * price);
			// finalPrice = (float)(price-(((float)disc/100)*price));

			Coupon coupon = new Coupon(prod, price, prov, disc, exp, stat, finalPrice);

			coupons.add(coupon);

			// Looping so that multiple coupons can be added.

			System.out.println(
					"\nThe coupon has been added. Do you want to continue adding? Type in: 1 - Yes and 0 - No\n>");

			add = scanner.nextInt();

		} while (add != 0);
		return coupons;

	}

	// This method takes the master ArrayList and searches for a coupon that's
	// matching the user input. If found, it displays the coupon. If not, it
	// displays a coupon not found message.

	void searchCoupons(ArrayList<Coupon> coupons) {
		Scanner scanner = new Scanner(System.in);
		int input2;
		boolean found = false;
		System.out.println(
				"\nSearch by: \n1. Product name\n2. Price\n3. Provider\n4. Discount Rate\n5. Expiration\n6. Status\n7. Final Price");
		input2 = scanner.nextInt();

		if (input2 == 1) {
			System.out.println("\nPlease type in the name of the product you want to search for:\n >");
			String input = scanner.next();

			// Searching algorithm

			for (int i = 0; i < coupons.size(); i++) {
				String product = coupons.get(i).getProduct();
				if (product.equalsIgnoreCase(input)) {
					System.out.println("\nThe product was found. Here's the info:\n");
					System.out.println(coupons.get(i));
					found = true;

				}

			}
			if (found == false) {
				System.out.println("\nNo coupon found.\n");

			}
		}

		if (input2 == 2) {
			System.out.println("\nPlease type in the price of the product you want to search for:\n >");
			float input = scanner.nextFloat();

			// Searching algorithm

			for (int i = 0; i < coupons.size(); i++) {
				float price = coupons.get(i).getPrice();
				if (price == input) {
					System.out.println("\nThe product was found. Here's the info:\n");
					System.out.println(coupons.get(i));
					found = true;

				}

			}
			if (found == false) {
				System.out.println("\nNo coupon found.\n");

			}
		}

		if (input2 == 3) {
			System.out.println("\nPlease type in the provider of the product you want to search for:\n >");
			String input = scanner.next();

			// Searching algorithm

			for (int i = 0; i < coupons.size(); i++) {
				String provider = coupons.get(i).getProvider();
				if (provider.equalsIgnoreCase(input)) {
					System.out.println("\nThe product was found. Here's the info:\n");
					System.out.println(coupons.get(i));
					found = true;

				}

			}
			if (found == false) {
				System.out.println("\nNo coupon found.\n");

			}
		}

		if (input2 == 4) {
			System.out.println(
					"\nPlease type in the discount rate of the product you want to search for (e.g. 10, 20, etc.):\n >");
			int input = scanner.nextInt();

			// Searching algorithm

			for (int i = 0; i < coupons.size(); i++) {
				int disc = coupons.get(i).getDiscountRate();
				if (disc == input) {
					System.out.println("\nThe product was found. Here's the info:\n");
					System.out.println(coupons.get(i));
					found = true;

				}

			}
			if (found == false) {
				System.out.println("\nNo coupon found.\n");

			}
		}

		if (input2 == 5) {
			System.out.println(
					"\nPlease type in the expiration (in # of days) of the product you want to search for:\n >");
			int input = scanner.nextInt();

			// Searching algorithm

			for (int i = 0; i < coupons.size(); i++) {
				int exp = coupons.get(i).getExpiration();
				if (exp == input) {
					System.out.println("\nThe product was found. Here's the info:\n");
					System.out.println(coupons.get(i));
					found = true;

				}

			}
			if (found == false) {
				System.out.println("\nNo coupon found.\n");

			}
		}

		if (input2 == 6) {
			System.out.println(
					"\nPlease type in the status of the product you want to search for (Unused or Redeemed):\n >");
			String input = scanner.next();

			// Searching algorithm

			for (int i = 0; i < coupons.size(); i++) {
				String status = coupons.get(i).getStatus();
				if (status.equalsIgnoreCase(input)) {
					System.out.println("\nThe product was found. Here's the info:\n");
					System.out.println(coupons.get(i));
					found = true;

				}

			}
			if (found == false) {
				System.out.println("\nNo coupon found.\n");

			}
		}
		if (input2 == 7) {
			System.out.println(
					"\nPlease type in the final price (in the decimal format 00.00) of the product you want to search for:\n >");
			float input = scanner.nextFloat();

			// Searching algorithm

			for (int i = 0; i < coupons.size(); i++) {
				float finalP = coupons.get(i).getFinalPrice();
				if (finalP == input) {
					System.out.println("\nThe product was found. Here's the info:\n");
					System.out.println(coupons.get(i));
					found = true;

				}

			}
			if (found == false) {
				System.out.println("\nNo coupon found.\n");

			}
		}

	}

	// This method takes the master ArrayList and depending on the user input, sorts
	// by either product name, price, provider, discount rate, expiration, status or
	// final price. Then, it prints out the elements of the sorted ArrayList.

	void sortAndDisplay(ArrayList<Coupon> coupons) {

		Coupon temp;

		System.out.println(
				"\nSort by: \n1. Product name\n2. Price\n3. Provider\n4. Discount Rate\n5. Expiration\n6. Status\n7. Final Price");
		int sel;
		Scanner scan = new Scanner(System.in);
		sel = scan.nextInt();

		if (sel == 1) {

			for (int i = 0; i < coupons.size(); i++) {
				temp = coupons.get(i);

				for (int j = i + 1; j < coupons.size(); j++) {
					if (((coupons.get(i).getProduct()).compareToIgnoreCase(coupons.get(j).getProduct()) > 0)) {
						temp = coupons.get(i);
						coupons.set(i, coupons.get(j));
						coupons.set(j, temp);
					}

				}

			}

			for (int i = 0; i < coupons.size(); i++) {
				System.out.println("\nCoupon #" + (i + 1) + ":");
				System.out.print(coupons.get(i) + "\n\n");
			}
		}

		if (sel == 2) {
			for (int i = 0; i < coupons.size(); i++) {
				temp = coupons.get(i);

				for (int j = i + 1; j < coupons.size(); j++) {
					if (coupons.get(i).getPrice() > coupons.get(j).getPrice()) {
						temp = coupons.get(i);
						coupons.set(i, coupons.get(j));
						coupons.set(j, temp);
					}

				}

			}
			for (int i = 0; i < coupons.size(); i++) {
				System.out.println("\nCoupon #" + (i + 1) + ":");
				System.out.print(coupons.get(i) + "\n\n");
			}
		}
		if (sel == 3) {

			for (int i = 0; i < coupons.size(); i++) {
				temp = coupons.get(i);

				for (int j = i + 1; j < coupons.size(); j++) {
					if (((coupons.get(i).getProvider()).compareToIgnoreCase(coupons.get(j).getProvider()) > 0)) {
						temp = coupons.get(i);
						coupons.set(i, coupons.get(j));
						coupons.set(j, temp);
					}

				}

			}

			for (int i = 0; i < coupons.size(); i++) {
				System.out.println("\nCoupon #" + (i + 1) + ":");
				System.out.print(coupons.get(i) + "\n\n");
			}
		}
		if (sel == 4) {
			for (int i = 0; i < coupons.size(); i++) {
				temp = coupons.get(i);

				for (int j = i + 1; j < coupons.size(); j++) {
					if (coupons.get(i).getDiscountRate() > coupons.get(j).getDiscountRate()) {
						temp = coupons.get(i);
						coupons.set(i, coupons.get(j));
						coupons.set(j, temp);
					}

				}

			}
			for (int i = 0; i < coupons.size(); i++) {
				System.out.println("\nCoupon #" + (i + 1) + ":");
				System.out.print(coupons.get(i) + "\n\n");
			}
		}

		if (sel == 5) {
			for (int i = 0; i < coupons.size(); i++) {
				temp = coupons.get(i);

				for (int j = i + 1; j < coupons.size(); j++) {
					if (coupons.get(i).getExpiration() > coupons.get(j).getExpiration()) {
						temp = coupons.get(i);
						coupons.set(i, coupons.get(j));
						coupons.set(j, temp);
					}

				}

			}
			for (int i = 0; i < coupons.size(); i++) {
				System.out.println("\nCoupon #" + (i + 1) + ":");
				System.out.print(coupons.get(i) + "\n\n");
			}
		}

		if (sel == 6) {
			for (int i = 0; i < coupons.size(); i++) {
				temp = coupons.get(i);

				for (int j = i + 1; j < coupons.size(); j++) {
					if (((coupons.get(i).getStatus()).compareToIgnoreCase(coupons.get(j).getStatus()) > 0)) {
						temp = coupons.get(i);
						coupons.set(i, coupons.get(j));
						coupons.set(j, temp);

					}

				}

			}
			for (int i = 0; i < coupons.size(); i++) {
				System.out.println("\nCoupon #" + (i + 1) + ":");
				System.out.print(coupons.get(i) + "\n\n");
			}
		}
		if (sel == 7) {
			for (int i = 0; i < coupons.size(); i++) {
				temp = coupons.get(i);

				for (int j = i + 1; j < coupons.size(); j++) {
					if (coupons.get(i).getFinalPrice() > coupons.get(j).getFinalPrice()) {
						temp = coupons.get(i);
						coupons.set(i, coupons.get(j));
						coupons.set(j, temp);
					}

				}

			}
			for (int i = 0; i < coupons.size(); i++) {
				System.out.println("\nCoupon #" + (i + 1) + ":");
				System.out.print(coupons.get(i) + "\n\n");
			}
		}

	}

}
