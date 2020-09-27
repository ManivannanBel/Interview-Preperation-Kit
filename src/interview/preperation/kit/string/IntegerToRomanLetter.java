package interview.preperation.kit.string;

public class IntegerToRomanLetter {

	public static void main(String args[]) {
		System.out.println(intToRoman(4));	//IV
		System.out.println(intToRoman(3));	//III
		System.out.println(intToRoman(58));	//LVIII
		System.out.println(intToRoman(1994));	//MCMXCIV
	}
	
	public static String intToRoman(int num) {
        int value[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String roman[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int index = 12;
        StringBuffer sb = new StringBuffer();
        while(num > 0){
            if(num >= value[index]){
                num -= value[index];
                sb.append(roman[index]);
            }else{
                index--;
            }
        }
        return sb.toString();
    }
}
