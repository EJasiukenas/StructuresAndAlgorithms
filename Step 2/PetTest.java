import java.io.*;

class PetTest
{
    PetTree petTree = new PetTree();
    SortedLinkedList products = new SortedLinkedList();
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
                    findPetInList();
                    break;
                case 3:
                    getPetFromList();
                    break;
                case 4:
                    deletePetFromList();
                    break;
                case 5:
                    petTree.display();
                    break;
                case 6:
                    addProductToList();
                    break;
                case 7:
                    findProduct();
                    break;
                case 8:
                    deleteProduct();
                    break;
                case 9:
                    displayProducts();
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
        System.out.println("[1] - Add new pet type");
        System.out.println("[2] - Find products for particular pet type");
        System.out.println("[3] - Display a specific pet type");
        System.out.println("[4] - Remove pet type");
        System.out.println("[5] - Display all pet types");
        System.out.println("[6] - Add a product");
        System.out.println("[7] - Find product");
        System.out.println("[8] - Remove product");
        System.out.println("[9] - Display products");
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

    private void getPetFromList()
    {
        System.out.print("Enter pet type name: ");

        try {
            Pet pet = petTree.find(input.readLine());

            if (pet != null) {
                System.out.println("Pet type found!");
                System.out.println(pet.toString());
            } else {
                System.out.println("This pet type does not exist.");
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
        String name = Input.getString("Enter product name: ");
        String code = Input.getString("Enter product code: ");
        try {
            Integer quantity = Input.getInteger("Enter product quantity: ");
            Product product = new Product(name, code, quantity);
            products.insert(product);
            System.out.println("Product added");
        } catch (NumberFormatException exception) {
            System.out.println("Please write an integer!");
        } catch (Exception exception) {
            System.out.println("This product already exists");
        }
    }

    private void findProduct() {
        String code = Input.getString("Enter product code: ");
        try {
            Comparable<Product> product = products.find(new Product("", code));
            System.out.println("Product was found! Product details:\n" + product);
        } catch (Exception exception) {
            System.out.println("Product not found");
        }
    }

    private void deleteProduct() {
        String code = Input.getString("Enter product code: ");
        try {
            products.remove(new Product("", code));
            System.out.println("Product was deleted");
        } catch (Exception exception) {
            System.out.println("Product not found");
        }
    }
    
    private void displayProducts() {
        String response = products.toString();
        System.out.println(response.compareTo("list is empty") == 0 ? "There are no products in system" : response);
    }
}