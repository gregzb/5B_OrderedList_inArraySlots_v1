public class UserOfOrderedList {
    public static void main(String[] cmdLn) {
        OrderedList_inArraySlots orderedList = new OrderedList_inArraySlots();

        orderedList.add(1);
        orderedList.add(4);
        orderedList.add(3);
        orderedList.add(5);
        orderedList.add(2);
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println("Actual: " + orderedList);

        orderedList.remove(3); //Remove the actual number 3 from the list
        System.out.println("Expected: [1, 2, 4, 5]");
        System.out.println("Actual: " + orderedList);

        orderedList.removeIndex(3); //Remove the item at index 3 from the list
        System.out.println("Expected: [1, 2, 4]");
        System.out.println("Actual: " + orderedList);

        orderedList.set(1, 5); // set the value at index 1 to be 5
        System.out.println("Expected: [1, 4, 5]");
        System.out.println("Actual: " + orderedList);

        System.out.println("Expected: 4");
        System.out.println("Actual: " + orderedList.get(1));

        System.out.println("Expected: 1");
        System.out.println("Actual: " + orderedList.find(4));

        orderedList.add(4);
        System.out.println("Expected: [1, 4, 4, 5]");
        System.out.println("Actual: " + orderedList);

        System.out.println("Expected: 1");
        System.out.println("Actual: " + orderedList.find(4));

        orderedList.add(9);

        System.out.println("Expected: [1, 4, 4, 5, 9]");
        System.out.println("Actual: " + orderedList);
    }
}
