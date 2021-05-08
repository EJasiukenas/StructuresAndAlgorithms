import java.io.*;

class PetTest
{
    PetTree petTree = new PetTree();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void run()
    {
        Integer key;
        printOptions();

        while (true) {
            System.out.println("\nEnter key: ");
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
        System.out.println("[0] - Exit\n");
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
}