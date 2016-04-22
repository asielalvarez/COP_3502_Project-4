
public class RecordStack {
	private Record[] data;
	private int top;

	public RecordStack() {
		data = new Record[3];
	}

	public void push(Record r) {
		data[top++] = r;
		if (maxCapacity()) {
			resizeStack(data.length * 2);
		}
	}

	public Record pop() {
		if (size() == 0) {
			System.out.println("Underflow");
			return null;
		}
		Record poppedRecord = data[--top];
		if (size() == data.length / 4) {
			resizeStack(data.length / 2);
		}
		return poppedRecord;
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return top;
	}

	public String toString() {
		String records = "";
		for (int i = 0; i < top; i++) {
			records += data[i].toString();
			if(i + 1 != top){
				records += ", ";
			}
		}
		return records;
	}

	private void resizeStack(int newSize) {
		Record[] newArray = new Record[newSize];
		for (int i = 0; i < top; i++) {
			newArray[i] = data[i];
		}
		data = newArray;
	}

	private boolean maxCapacity() {
		return top == data.length;
	}
}
