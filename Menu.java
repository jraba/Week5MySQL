import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BerriesDao;
import entity.Berry;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Berries", "Create a Berry", "Modify a Berry",
			"Delete a Berry");

	public void start() throws SQLException {
		String selection = "";

		do {
			printMenu();
			selection = scanner.nextLine();

			if (selection.equals("1")) {
				listBerries();
			} else if (selection.equals("2")) {
				createBerry();
			} else if (selection.equals("3")) {
				modifyBerry();
			} else if (selection.equals("4")) {
				deleteBerry();
			}

			System.out.println("Press Enter to Continue...");
			scanner.nextLine();

		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an Option: \n *******************");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + "-" + options.get(i));
		}
	}

	private void deleteBerry() throws SQLException {
		listBerries();
		System.out.println("Enter Berry ID to Delete: ");
		long berry_id = Long.parseLong(scanner.nextLine());
		BerriesDao.deleteBerry(berry_id);
		listBerries();

	}

	private void modifyBerry() throws SQLException {
		listBerries();
		System.out.println("Enter Berry ID to Modify: ");
		long berry_id = Long.parseLong(scanner.nextLine());

		System.out.println("Enter New Berry Name: ");
		String name = scanner.nextLine();

		BerriesDao.modifyBerry(berry_id, name);
		listBerries();

	}

	private void listBerries() throws SQLException {
		List<Berry> berries = BerriesDao.listBerries();

		berries.stream().forEach(berry -> System.out.println(berry));

	}

	private void createBerry() throws SQLException {
		System.out.println("Enter Berry Name: ");
		String name = scanner.nextLine();
		BerriesDao.createBerry(name);
	}

}
