package cs.types;

public class Array<T> implements List<T> {
    protected T[] items;
    protected int count;

    @SuppressWarnings("unchecked")
    public Array(Class<T> classType, int maxCount) {
//        Type superClass = getClass().getGenericSuperclass();
//        Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        this.items = (T[]) java.lang.reflect.Array.newInstance(classType, maxCount);
        this.count = 0;
    }

    public void insert(int i, T element) {
        items[i] = element;
        count++;
    }

    public boolean delete(T element) {
        for (int i = 0; i < count; i++) {
            if (items[i] == element) {
                for (int j = i; j < count; j++) {
                    items[j] = items[j+1];
                }
                count--;
                return true;
            }
        }

        return false;
    }

    @Override
    public T[] getItems() {
        return items;
    }

    @Override
    public T getItem(int i) {
        return (T) items[i];
    }

    @Override
    public int getCount() {
        return count;
    }
}
