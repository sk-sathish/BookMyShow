package helper;

public class UUIDGenerator {
	long start;
	String prefix;
	public UUIDGenerator(String prefix){
		start = 0;
		this.prefix = prefix;
	}
	public String generateUUID() {
		start++;
		if(start == Long.MAX_VALUE) {
			start = 1;
		}
		return prefix+start;
	}
}
