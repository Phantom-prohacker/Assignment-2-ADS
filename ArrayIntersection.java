public class ArrayIntersection {
    /// Returns an array of intersection of A and B.
    /// Each item in the resultant array must be unique.
    public static int[] intersect(int[] A, int[] B) {
        IntArray tempResult = new IntArray();

        // Перебираем каждый элемент первого массива
        for (int aItem : A) {
            // Проверяем, есть ли он во втором массиве
            if (contains(B, aItem)) {
                // И проверяем, не добавили ли мы его уже (для уникальности)
                if (tempResult.indexOf(aItem) == -1) {
                    tempResult.add(aItem);
                }
            }
        }

        // Превращаем наш IntArray обратно в обычный массив int[]
        int[] result = new int[tempResult.size()];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = tempResult.get(i);
        }
        return result;
    }

    // Вспомогательный метод, чтобы проверить наличие числа в массиве
    private static boolean contains(int[] array, int item) {
        for (int x : array) {
            if (x == item) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4};
        int[] b = {2, 2, 4, 5};
        int[] result = intersect(a, b);

        // Должно вывести [2, 4]
        System.out.print("Intersection: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i < result.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
