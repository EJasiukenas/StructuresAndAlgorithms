public class CombinedPetTree {
    class Node {
        Pet pet;
        Node left, right;
        SortedLinkedList products = new SortedLinkedList();
 
        public Node(Pet pet) {
            this.pet = pet;
            left = right = null;
        }
    }
 
    Node root;
 
    public CombinedPetTree() {
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
        display(false);
    }
 
    public void display(Boolean full) {
        if (root != null) {
            displayRecursion(root, full);
        } else {
            System.out.println("There are no pet types in the system");
        }
    }
 
    private void displayRecursion(Node root, Boolean full) {
        if (root != null) {
            displayRecursion(root.left, full);
            System.out.println(root.pet.getName());
            if (full) {
                String response = root.products.toString();
                if (response.compareTo("list is empty") == 0) {
                    System.out.println("There are no products in system");
                } else {
                    System.out.println("Products:");
                    System.out.println(response);
                }
            }
            displayRecursion(root.right, full);
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

    public void insertProduct(Pet pet, Comparable<Product> object) throws Exception {
        insertProductRecursion(root, pet.getName(), object);
    }

    private void insertProductRecursion(Node root, String petName, Comparable<Product> object) throws Exception {
        if (root == null) {
            return;
        } else {
            int comparison = petName.compareToIgnoreCase(root.pet.getName());

            if (comparison < 0)
                insertProductRecursion(root.left, petName, object);
            else if (comparison > 0)
                insertProductRecursion(root.right, petName, object);
            else
                root.products.insert(object);
        }
    }

    public Comparable<Product> removeProduct(Pet pet, Comparable<Product> object) throws Exception {
        return removeProductRecursion(root, pet.getName(), object);
    }

    private Comparable<Product> removeProductRecursion(Node root, String petName, Comparable<Product> object) throws Exception {
        if (root == null) {
            return null;
        } else {
            int comparison = petName.compareToIgnoreCase(root.pet.getName());

            if (comparison < 0)
                return removeProductRecursion(root.left, petName, object);
            else if (comparison > 0)
                return removeProductRecursion(root.right, petName, object);
            else
                return root.products.remove(object);
        }
    }

    public Comparable<Product> findProduct(Pet pet, Comparable<Product> object) throws Exception {
        return findProductRecursion(root, pet.getName(), object);
    }

    private Comparable<Product> findProductRecursion(Node root, String petName, Comparable<Product> object) throws Exception {
        if (root == null) {
            return null;
        } else {
            int comparison = petName.compareToIgnoreCase(root.pet.getName());

            if (comparison < 0)
                return findProductRecursion(root.left, petName, object);
            else if (comparison > 0)
                return findProductRecursion(root.right, petName, object);
            else
                return root.products.find(object);
        }
    }

    public String displayProducts(Pet pet) {
        return displayProductsRecursion(root, pet.getName());
    }

    private String displayProductsRecursion(Node root, String petName) {
        if (root == null) {
            return null;
        } else {
            int comparison = petName.compareToIgnoreCase(root.pet.getName());

            if (comparison < 0)
                return displayProductsRecursion(root.left, petName);
            else if (comparison > 0)
                return displayProductsRecursion(root.right, petName);
            else
                return root.products.toString();
        }
    }
}