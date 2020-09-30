package interview.preperation.kit.array;

public class PlusOne {
	public static void main(String args[]) {
		int arr[] = new int[] {9,9,9};
		print(arr);
		arr = plusOne(arr);
		print(arr);
	}
	
	public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[]{1};
        int index = digits.length - 1, carry = 0, sum = 0;
        
        digits[index] = digits[index] + 1;
        carry = digits[index] / 10;
        digits[index] = digits[index] % 10;
        index--;
        while(index >= 0){
            digits[index] = carry + digits[index]; 
            carry = digits[index] / 10;
            digits[index] = digits[index] % 10;
            digits[index] = digits[index];
            index--;
        }
        
        if(carry != 0){
            int newArr[] = new int[digits.length + 1];
            newArr[0] = carry;
            for(int i = 1; i < newArr.length; i++){
                newArr[i] = digits[i - 1];
            }
            return newArr;
        }
        
        return digits;
    }
	
	public static void print(int arr[]) {
		System.out.print("[");
		for(int a : arr) {
			System.out.print(a+", ");
		}
		System.out.println("]");
	}
}
