public class Vector {
    private double x, y, z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lengthVector(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarMultiply(Vector vector){
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector vectorMultiply(Vector vector){
        return new Vector(y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x);
    }

    public double angle(Vector vector) {
        return scalarMultiply(vector) / (lengthVector() * vector.lengthVector());
    }

    public Vector add(Vector vector) {
        return new Vector(x + vector.x,
                y + vector.y,
                z + vector.z
        );
    }

    public Vector subtract(Vector vector) {
        return new Vector(x - vector.x,
                y - vector.y,
                z - vector.z
        );
    }

    public static Vector[] randomVectors(int N){
        Vector[] vectors = new Vector[N];
        for (int i = 0; i < N; i++){
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
