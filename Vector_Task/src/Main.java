public class Main {
    public static void main(String[] args) {
        Vector[] vectors = Vector.randomVectors(2);
        System.out.println(vectors[0]);
        System.out.println("длина: " +  vectors[0].lengthVector());
        System.out.println("скалярное произведение: " + vectors[0].scalarMultiply(vectors[1]));
        System.out.println("векторное произведение: " + vectors[0].vectorMultiply(vectors[1]));
        System.out.println("угол: " + vectors[0].angle(vectors[1]));
        System.out.println("суммы: " + vectors[0].add(vectors[1]));
        System.out.println("разность: " + vectors[0].subtract(vectors[1]));
    }
}
