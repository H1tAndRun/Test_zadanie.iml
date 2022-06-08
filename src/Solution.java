public class Solution {
    public static void getResult(String name, String str) {
        if (name.equals("Human")) {
            Human men = new Human();
            men.CreateField(str,name);
        }
        if (name.equals("Swamper")) {
            Swamper swam = new Swamper();
            swam.CreateField(str,name);

        }

        if (name.equals("Woodman")) {
            Woodman wood = new Woodman();
            wood.CreateField(str,name);
        }
    }
}
