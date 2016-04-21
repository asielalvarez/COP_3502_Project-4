
public class RecordStack {
	private Record[] data;
	private int top;
	
	public RecordStack(){
		data = new Record[10];
	}
	public void push(Record r){
		data[top++] = r;;
	}
	public Record pop(){
		return data[--top];
	}
	public boolean isEmpty(){
		return false; // remember to change return. erase comment when done
	}
	public int size(){
		return top;
	}
	public String toString(){
		String records = "";
		for (int i = 0; i < top; i++){
			records += data[i].toString() + ", ";
		}
		return  records;
	}
}
