public final class UnitUtils {

    private UnitUtils() {
    }

    public static int howManyFieldsFilled(String[] paramValues) {
        int count = 0;
        for (String value : paramValues) {
            if (value != null && !value.equals("")) {
                count++;
            }
        }
        return count;
    }
}
