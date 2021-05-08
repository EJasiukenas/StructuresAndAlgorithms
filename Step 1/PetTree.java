public class PetTree {
    class Node {
        Pet pet;
        Node left, right;
 
        public Node(Pet pet) {
            this.pet = pet;
            left = right = null;
        }
    }
 
    Node root;
 
    public PetTree() {
         root = null;
    }
 
    public void insert(Pet pet) {
         root = insertRecursion(root, pet);
    }

    private Node insertRecursion(Node root, Pet pet) {
        if (root == null)
        {
            root = new Node(pet);
            return root;
        }
 
        int comparison = pet.getName().compareToIgnoreCase(root.pet.getName());

        if (comparison < 0)
            root.left = insertRecursion(root.left, pet);
        else if (comparison > 0)
            root.right = insertRecursion(root.right, pet);
            
 
        return root;
    }
 
    public void display() {
        if (root != null) {
            displayRecursion(root);
        } else {
            System.out.println("There are no pet types in the system");
        }
    }
 
    private void displayRecursion(Node root) {
        if (root != null) {
            displayRecursion(root.left);
            System.out.println(root.pet.getName());
            displayRecursion(root.right);
        }
    }

    public Pet find(String petName) {
        return findRecursion(root, petName);
    }

    private Pet findRecursion(Node root, String petName) {
        if (root == null) {
            return null;
        } else {
            int comparison = petName.compareToIgnoreCase(root.pet.getName());

            if (comparison < 0)
                return findRecursion(root.left, petName);
            else if (comparison > 0)
                return findRecursion(root.right, petName);
            else
                return root.pet;
        }
    }
    
    public void delete(String petName) {
        root = deleteRecursion(root, petName);
    }

    private Node deleteRecursion(Node root, String petName) {
        if (root == null)
            return root;
 
        int comparison = petName.compareToIgnoreCase(root.pet.getName());

        if (comparison < 0)
            root.left = deleteRecursion(root.left, petName);
        else if (comparison > 0)
            root.right = deleteRecursion(root.right, petName);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.pet = minValue(root.right);

            root.right = deleteRecursion(root.right, root.pet.getName());
        }
 
        return root;
    }

    private Pet minValue(Node root) {
        Pet minv = root.pet;

        while (root.left != null)
        {
            minv = root.left.pet;
            root = root.left;
        }

        return minv;
    }
}