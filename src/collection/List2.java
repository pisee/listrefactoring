package collection;

public class List2 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private static final int INITIAL_STORE_SIZE = 10;
	private Object[] elements = new Object[INITIAL_STORE_SIZE];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		if ( isElementStoreFull()) {
			increaseElementStore();
		}
		addElementAtEnd(element);
	}

	private void addElementAtEnd(Object element) {
		elements[size] = element;
		size++;
	}

	private void increaseElementStore() {
		Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
	}

	private boolean isElementStoreFull() {
		return size + 1 > elements.length;
	}
}