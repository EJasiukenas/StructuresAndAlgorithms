import java.io.*;

class PetTest
{
    CombinedPetTree petTree = new CombinedPetTree();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void run()
    {
        Integer key;
        printOptions();

        while (true) {
            System.out.print("\nEnter key: ");

            try {
                key = Integer.parseInt(input.readLine());
            } catch (Exception error) {
                continue;
            }

            switch (key) {
                case 0:
                    System.out.println("Thank you for using our application!");
                    return;
                case 1:
                    addNewPetToList();
                    break;
                case 2:
                    addProductToList();
                    break;
                case 3:
                    findPetInList();
                    break;
                case 4:
                    petTree.display();
                    break;
                case 5:
                    displayProducts();
                    break;
                case 6:
                    petTree.display(true);
                    break;
                case 7:
                    deleteProduct();
                    break;
                case 8:
                    deletePetFromList();
                    break;
            
                default:
                    System.out.println("Invalid menu option entered.\n");
                    printOptions();
                    break;
            }
        }
    }
    private void printOptions()
    {
        System.out.println("Please select what do you want to do:");
        System.out.println("[1] - Add details of a new pet type");
        System.out.println("[2] - Add details of a new product for a specified pet type");
        System.out.println("[3] - Find if the company stocks products for a particular type of pet");
        System.out.println("[4] - Display all the types of pets that the company provides products for");
        System.out.println("[5] - Display all the products stocked for a specific pet type");
        System.out.println("[6] - Display all the product details for all the pets");
        System.out.println("[7] - Remove a particular product for a specified pet (eg discontinued ítem)");
        System.out.println("[8] - Remove a pet type from the system");
        System.out.println("[0] - Exit");
    }

    private void addNewPetToList()
    {
        System.out.print("Enter pet type name: ");

        try {
            String name = input.readLine();
            if (petTree.find(name) == null) {
                petTree.insert(new Pet(name));
                System.out.println("Pet type added successfully!");
            } else {
                System.out.println("This pet type already exists");
            }
        } catch (IOException exception) {
            System.out.println("Error on input: " + exception.getMessage());
        }
    }

    private void findPetInList()
    {
        System.out.print("Enter pet type name: ");

        try {
            String name = input.readLine();
            if (petTree.find(name) != null) {
                System.out.println("Our company provides products for " + name);
            } else {
                System.out.println("Our company does not provide products for " + name);
            }
        } catch (IOException exception) {
            System.out.println("Error on input: " + exception.getMessage());
        }
    }

    private void deletePetFromList()
    {
        System.out.print("Enter pet type name: ");

        try {
            String name = input.readLine();
            if (petTree.find(name) != null) {
                petTree.delete(name);
                System.out.println("Pet type deleted successfully!");
            } else {
                System.out.println("This pet type does not exist");
            }
        } catch (IOException exception) {
            System.out.println("Error on input: " + exception.getMessage());
        }
    }

    private void addProductToList() {
        Pet pet = petTree.find(Input.getString("Enter pet name: "));
        if (pet == null) {
            System.out.println("The pet was not found");
            return;
        }

        String name = Input.getString("Enter product name: ");
        String code = Input.getString("Enter product code: ");
        try {
            Integer quantity = Input.getInteger("Enter product quantity: ");
            Product product = new Product(name, code, quantity);
            petTree.insertProduct(pet, product);
            System.out.println("Product added");
        } catch (NumberFormatException exception) {
            System.out.println("Please write an integer!");
        } catch (Exception exception) {
            System.out.println("This product already exists");
        }
    }

    private void deleteProduct() {
        Pet pet = petTree.find(Input.getString("Enter pet name: "));
        if (pet == null) {
            System.out.println("The pet was not found");
            return;
        }

        String code = Input.getString("Enter product code: ");
        try {
            petTree.removeProduct(pet, new Product("", code));
            System.out.println("Product was deleted");
        } catch (Exception exception) {
            System.out.println("Product not found");
        }
    }
    
    private void displayProducts() {
        Pet pet = petTree.find(Input.getString("Enter pet name: "));
        if (pet == null) {
            System.out.println("The pet was not found");
            return;
        }

        String response = petTree.displayProducts(pet);
        System.out.println(response.compareTo("list is empty") == 0 ? "There are no products in system" : response);
    }
}