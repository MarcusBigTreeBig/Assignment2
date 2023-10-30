package question1;

public class Main {
    public static void main (String[] args) {
        CuckooHashMap map = new CuckooHashMap(10);
        System.out.println(map.elementAtKey(10));
        map.addElement(10, 10);
        System.out.println(map.elementAtKey(10));
        System.out.println(map);
        map.removeElementAtKey(10);
        System.out.println(map.elementAtKey(10));
        System.out.println(map);
        map.addElement(10, 10);
        map.addElement(20, 20);
        System.out.println(map);
        System.out.println(map.elementAtKey(10));
        System.out.println(map.elementAtKey(20));
        map.addElement(30, 10);
        System.out.println(map);
        for (int i = 4; i < 8; i++) {
            map.addElement(i*10, i*10);
        }
        System.out.println(map);
        System.out.println(map.elementAtKey(60));
    }

}
